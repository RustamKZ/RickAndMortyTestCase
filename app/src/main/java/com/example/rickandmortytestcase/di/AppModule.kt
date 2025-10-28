package com.example.rickandmortytestcase.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.rickandmortytestcase.data.local.CharacterEntity
import com.example.rickandmortytestcase.data.local.RickAndMortyDb
import com.example.rickandmortytestcase.data.remote.RickAndMortyApi
import com.example.rickandmortytestcase.data.remote.RickAndMortyRemoteMediator
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton
import kotlin.jvm.java

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRickAndMortyDatabase(@ApplicationContext context: Context): RickAndMortyDb {
        return Room.databaseBuilder(
            context,
            RickAndMortyDb::class.java,
            "characters.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(RickAndMortyApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRickAndMortyPager(RickAndMortyDb: RickAndMortyDb, RickAndMortyApi: RickAndMortyApi): Pager<Int, CharacterEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = RickAndMortyRemoteMediator(
                ramDb = RickAndMortyDb,
                ramApi = RickAndMortyApi
            ),
            pagingSourceFactory = {
                RickAndMortyDb.dao.pagingSource()
            }
        )
    }
}