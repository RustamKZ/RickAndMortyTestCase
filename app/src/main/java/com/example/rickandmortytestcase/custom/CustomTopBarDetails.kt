package com.example.rickandmortytestcase.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortytestcase.R
import com.example.rickandmortytestcase.ui.theme.CustomCardBackgroundBlue
import com.example.rickandmortytestcase.ui.theme.CustomGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBarDetails(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = CustomCardBackgroundBlue
        ),
        windowInsets = WindowInsets(top = 0.dp),
        title = {
            Text(
                text = "Детали персонажа",
                color = CustomGreen,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(27.dp)
                    .clickable{
                        onBackClick()
                    },
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