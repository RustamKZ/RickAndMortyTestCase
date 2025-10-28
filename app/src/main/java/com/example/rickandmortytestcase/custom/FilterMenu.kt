import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortytestcase.custom.CustomButtonFilter
import com.example.rickandmortytestcase.ui.theme.CustomCardBackgroundBlue
import com.example.rickandmortytestcase.ui.theme.CustomCardButtonEpisodesGray
import com.example.rickandmortytestcase.ui.theme.CustomCardButtonGray
import com.example.rickandmortytestcase.ui.theme.CustomGreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FilterMenu(
    modifier: Modifier = Modifier,
    onFilterSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 32.dp)
    ) {
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + slideInVertically { it / 2 },
            exit = fadeOut() + slideOutVertically { it / 2 },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 100.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(CustomCardBackgroundBlue.copy(alpha =  0.95f))
                    .border(width = 0.2.dp, color = CustomCardButtonGray, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Фильтры",
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
                Text(
                    text = "Статус",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CustomButtonFilter(text = "Alive") {
                        onFilterSelected("Alive")
                    }
                    CustomButtonFilter(text = "Dead") {
                        onFilterSelected("Dead")
                    }
                }
                Text(
                    text = "Вид",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CustomButtonFilter(text = "Human") {
                        onFilterSelected("Human")
                    }
                    CustomButtonFilter(text = "Alien") {
                        onFilterSelected("Alien")
                    }
                    CustomButtonFilter(text = "Humanoid") {
                        onFilterSelected("Humanoid")
                    }
                }
                Text(
                    text = "Пол",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CustomButtonFilter(text = "Male") {
                        onFilterSelected("Human")
                    }
                    CustomButtonFilter(text = "Female") {
                        onFilterSelected("Alien")
                    }
                    CustomButtonFilter(text = "Genderless") {
                        onFilterSelected("Humanoid")
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
                        text = "Очистить все фильтры",
                        fontSize = 14.sp,
                        color = CustomGreen,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                }
            }
        }

        FloatingActionButton(
            onClick = { expanded = !expanded },
            containerColor = if (expanded) CustomGreen else CustomGreen.copy(alpha = 0.7f),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.Close else Icons.Filled.FilterList,
                contentDescription = null
            )
        }
    }
}