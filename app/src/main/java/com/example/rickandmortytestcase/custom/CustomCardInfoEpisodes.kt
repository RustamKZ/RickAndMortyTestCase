package com.example.rickandmortytestcase.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortytestcase.ui.theme.CustomCardBackgroundBlue
import com.example.rickandmortytestcase.ui.theme.CustomCardButtonEpisodesGray
import com.example.rickandmortytestcase.ui.theme.CustomCardButtonGray
import com.example.rickandmortytestcase.ui.theme.CustomColorGray
import com.example.rickandmortytestcase.ui.theme.CustomGreen

@Composable
fun CustomCardInfoEpisodes(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(CustomCardBackgroundBlue)
            .padding(horizontal = 12.dp, vertical = 18.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    imageVector = Icons.Filled.Tv,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = CustomGreen
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    "EPISODES",
                    color = CustomColorGray,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "51 Episodes",
                    color = CustomGreen,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(32.dp))
                        .background(CustomGreen)
                        .padding(horizontal = 12.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "S01E01",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(32.dp))
                        .background(CustomGreen)
                        .padding(horizontal = 12.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "S01E02",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(32.dp))
                        .background(CustomGreen)
                        .padding(horizontal = 12.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "S01E03",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(32.dp))
                        .background(CustomCardButtonGray)
                        .padding(horizontal = 12.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "+48 more",
                        color = CustomColorGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = CustomCardButtonEpisodesGray
                )
            ) {
                Text(
                    text = "View all Episodes",
                    fontSize = 18.sp,
                    color = CustomGreen,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
    }
}