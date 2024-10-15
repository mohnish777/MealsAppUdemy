package com.example.mealsapp2.ui.details

import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.model.response.MealResponse

@Composable
fun MealDetailsScreen(mealState: MealResponse?) {
    val context = LocalContext.current
    var isExpanded by remember { mutableStateOf(false) }
    val imageSize: Dp by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else 100.dp, label = ""
    )

    Column {
        Row {
            Card(
                modifier = Modifier,
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                Surface(modifier = Modifier.clip(CircleShape)) {
                    Image(
                        modifier = Modifier
                            .size(imageSize),
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(mealState?.imageUrl)
                                .build(),
                            contentScale = ContentScale.Fit,
                        ),
                        contentDescription = "",
                    )
                }

            }
            Text(
                mealState?.name ?: "Default Name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(
            onClick = {
                isExpanded = !isExpanded
                Toast.makeText(context, "$isExpanded", Toast.LENGTH_SHORT).show()
            }

        ) {
            Text("Change state of meal profile picture")
        }
    }
}
