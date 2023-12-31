package com.bsrn.dynamicanimatedwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.bsrn.dynamic_animation.DynamicAnimation
import com.bsrn.dynamicanimatedwithcompose.ui.theme.DynamicAnimatedWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicAnimatedWithComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DynamicAnimation(
                        iconPathData = "M14.5,1C13.2573,1 12.1323,1.5376 11.3174,2.4063L9.9993,3.8125L8.6817,2.4063C7.8672,1.5376 6.7422,1 5.5,1C3.0155,1 1,3.1486 1,5.8003C1,7.1254 1.504,8.3255 2.3183,9.1941L8.9394,16.5338C9.5225,17.1554 10.4774,17.1554 11.0611,16.5338L17.6815,9.1941C18.496,8.3253 19,7.1252 19,5.8003C19,3.15 16.986,1 14.5,1Z",
                        onClick = {
                        }
                    )
                }
            }
        }
    }
}
