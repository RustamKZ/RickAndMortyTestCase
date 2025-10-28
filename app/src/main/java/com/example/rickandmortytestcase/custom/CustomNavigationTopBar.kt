package com.example.rickandmortytestcase.custom

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortytestcase.R
import com.example.rickandmortytestcase.ui.theme.CustomCardBackgroundBlue
import com.example.rickandmortytestcase.ui.theme.CustomGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomNavigationTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp)),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = CustomCardBackgroundBlue
        ),
        windowInsets = WindowInsets(top = 0.dp),
        title = {
            Text(
                text = "Введите имя персонажа",
                color = CustomGreen,
                fontSize = 17.sp
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.rick_top_bar),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(27.dp),
                tint = CustomGreen
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.plumbus_top_bar),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .size(27.dp),
                tint = CustomGreen
            )
        }
    )

}