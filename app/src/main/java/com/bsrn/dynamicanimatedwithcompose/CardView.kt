package com.bsrn.dynamicanimatedwithcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bsrn.dynamic_animation.DynamicAnimation
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardView(item: MyDataType) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box {
            Column(modifier = Modifier.padding(16.dp)) {
                GlideImage(
                    model = R.drawable.ic_launcher_foreground,
                    contentDescription = "Image for ${item.mainText}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text(
                    text = item.mainText,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp)
                )
                Text(
                    text = item.subText,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 4.dp)
                )
                Spacer(modifier = Modifier.height(36.dp))
            }
            DynamicAnimation(
                iconPathData = "M14.5,1C13.2573,1 12.1323,1.5376 11.3174,2.4063L9.9993,3.8125L8.6817,2.4063C7.8672,1.5376 6.7422,1 5.5,1C3.0155,1 1,3.1486 1,5.8003C1,7.1254 1.504,8.3255 2.3183,9.1941L8.9394,16.5338C9.5225,17.1554 10.4774,17.1554 11.0611,16.5338L17.6815,9.1941C18.496,8.3253 19,7.1252 19,5.8003C19,3.15 16.986,1 14.5,1Z",
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp) 
            )
        }
    }
}