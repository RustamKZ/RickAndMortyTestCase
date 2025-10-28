package com.example.rickandmortytestcase.custom

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortytestcase.ui.theme.CustomGreen

@Composable
fun CustomButtonFilter(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    var isClicked by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(32.dp))
            .border(2.dp, if (isClicked) CustomGreen else Color.White, RoundedCornerShape(32.dp))
            .clickable {
                onClick()
                isClicked = !isClicked
            }
    ) {
        Text(
            text = text,
            color = if (isClicked) CustomGreen else Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp)
        )
    }
}