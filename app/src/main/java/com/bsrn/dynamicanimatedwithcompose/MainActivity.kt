package com.bsrn.dynamicanimatedwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
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
                    SampleListView(myDataList)
                }
            }
        }
    }
}

val myDataList = listOf(
    MyDataType(
        mainText = "Item 1",
        subText = "Subtext 1"
    ),
    MyDataType(
        mainText = "Item 2",
        subText = "Subtext 2"
    ),
    MyDataType(
        mainText = "Item 3",
        subText = "Subtext 3"
    ),
    MyDataType(
        mainText = "Item 4",
        subText = "Subtext 4"
    ),
    MyDataType(
        mainText = "Item 5",
        subText = "Subtext 5"
    ),
    MyDataType(
        mainText = "Item 6",
        subText = "Subtext 6"
    ),
    MyDataType(
        mainText = "Item 7",
        subText = "Subtext 7"
    ),
    MyDataType(
        mainText = "Item 8",
        subText = "Subtext 8"
    ),
    MyDataType(
        mainText = "Item 9",
        subText = "Subtext 9"
    ),
    MyDataType(
        mainText = "Item 10",
        subText = "Subtext 10"
    )
)