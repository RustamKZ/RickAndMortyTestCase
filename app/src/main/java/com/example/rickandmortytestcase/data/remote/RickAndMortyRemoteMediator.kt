package com.example.rickandmortytestcase.data.remote
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.rickandmortytestcase.data.local.CharacterEntity
import com.example.rickandmortytestcase.data.local.RickAndMortyDb
import com.example.rickandmortytestcase.data.mappers.toCharEntity
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class RickAndMortyRemoteMediator(
    private val ramDb: RickAndMortyDb,
    private val ramApi: RickAndMortyApi
): RemoteMediator<Int, CharacterEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val response = ramApi.getCharacters(loadKey)
            val characters = response.results

            ramDb.withTransaction {
                if(loadType == LoadType.REFRESH) {
                    ramDb.dao.clearAll()
                }
                val charEntities = characters.map { it.toCharEntity() }
                ramDb.dao.upsertAll(charEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = characters.isEmpty()
            )
        } catch(e: IOException) {
            MediatorResult.Error(e)
        } catch(e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}