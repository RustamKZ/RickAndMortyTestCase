package com.example.rickandmortytestcase.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortytestcase.ui.theme.CustomCardBackgroundBlue
import com.example.rickandmortytestcase.ui.theme.CustomColorFemale
import com.example.rickandmortytestcase.ui.theme.CustomColorGray
import com.example.rickandmortytestcase.ui.theme.CustomColorMale
import com.example.rickandmortytestcase.ui.theme.CustomGreen

@Composable
fun CustomCardInfo(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    text: String = "",
    flag: Boolean = false,
    text2: String = ""
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(CustomCardBackgroundBlue)
            .padding(horizontal = 12.dp, vertical = 18.dp)
    ) {
        Column{
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    imageVector = if (title == "GENDER" && text == "Male") Icons.Filled.Male else if (title == "GENDER" && text == "Female") Icons.Filled.Female else icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = if (title == "GENDER" && text == "Male") CustomColorMale else if (title == "GENDER" && text == "Female") CustomColorFemale else CustomGreen
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    title,
                    color = CustomColorGray,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            if (flag) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text2,
                    color = CustomColorGray,
                    fontSize = 16.sp
                )
            }
        }
    }
}