package com.example.rickandmortytestcase.screens

import android.R.attr.onClick
import android.R.attr.text
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.rickandmortytestcase.R
import com.example.rickandmortytestcase.custom.CustomCardInfo
import com.example.rickandmortytestcase.custom.CustomCardInfoEpisodes
import com.example.rickandmortytestcase.custom.CustomTopBarDetails
import com.example.rickandmortytestcase.domain.CharacterInfo
import com.example.rickandmortytestcase.ui.theme.CustomBlackBackground
import com.example.rickandmortytestcase.ui.theme.CustomGreenIndicator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    character: CharacterInfo
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )
    Scaffold(
        modifier = modifier,
        topBar = {
            CustomTopBarDetails() {
                navController.popBackStack()
            }
        },
        containerColor = CustomBlackBackground
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            Box {
                AsyncImage(
                    model = character.image,
                    contentDescription = character.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp),
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    0.0f to Color.Transparent,
                                    0.3f to CustomBlackBackground.copy(alpha = 0.4f),
                                    0.6f to CustomBlackBackground.copy(alpha = 0.7f),
                                    1.0f to CustomBlackBackground.copy(alpha = 1f)
                                )
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = character.name,
                        color = Color.White,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(32.dp))
                            .background(CustomGreenIndicator)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Circle,
                                contentDescription = null,
                                tint = Color.White.copy(alpha = alpha),
                                modifier = Modifier.size(10.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text(
                                text = character.status,
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomCardInfo(
                    modifier = Modifier.weight(1f),
                    title = "GENDER",
                    icon = Icons.Filled.Male,
                    text = character.gender
                )
                CustomCardInfo(
                    modifier = Modifier.weight(1f),
                    title = "SPECIES",
                    icon = Icons.Filled.Person,
                    text = character.species
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            CustomCardInfo(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                title = "ORIGIN",
                icon = Icons.Filled.Home,
                text = character.origin,
                flag = true,
                text2 = character.origin
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomCardInfo(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                title = "LAST LOCATION",
                icon = Icons.Filled.LocationOn,
                text = character.location,
                flag = true,
                text2 = character.location
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomCardInfoEpisodes(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp))
        }
    }
}
