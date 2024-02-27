package com.bsrn.dynamicanimatedwithcompose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun SampleListView(myDataList: List<MyDataType>) {
    LazyColumn {
        items(myDataList.size) { index ->
            CardView(myDataList[index])
        }
    }
}
