package com.example.rickandmortytestcase.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.outlined.Male
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmortytestcase.domain.CharacterInfo
import com.example.rickandmortytestcase.ui.theme.CustomCardBackgroundBlue
import com.example.rickandmortytestcase.ui.theme.CustomColorGray
import com.example.rickandmortytestcase.ui.theme.CustomColorMale
import com.example.rickandmortytestcase.ui.theme.CustomGreen

@Composable
fun CustomCard(
    character: CharacterInfo,
    modifier: Modifier = Modifier,
    onClickCard: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(180.dp)
            .height(250.dp)
            .clickable {
                onClickCard()
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CustomCardBackgroundBlue
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 110.dp, height = 125.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = character.name,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Male,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = CustomColorMale
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    character.gender,
                    color = CustomColorGray,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = null,
                    modifier = Modifier.size(10.dp),
                    tint = CustomGreen
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    character.species,
                    color = CustomColorGray,
                    fontSize = 16.sp
                )
            }
        }
    }
}