package com.example.tripparcel.ui.view.composants

import android.app.Person
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}



@Composable
fun TableScreen(columnData: List<Pair<String, List<String>>>) {
    // Calculate weights for each column
    val columnWeights = List(columnData.size) { 1f / columnData.size }

    LazyColumn(Modifier.fillMaxWidth().padding(vertical = 16.dp)) {
        // Here is the header
        item {
            Row(Modifier.background(Color.Red.copy(alpha = 0.2f))) {
                columnData.forEachIndexed { index, (columnName, _) ->
                    TableCell(text = columnName, weight = columnWeights[index])
                }
            }
        }
        val rowIndices = columnData[0].second.indices.toList()

        items(rowIndices) { rowIndex ->
            Row(Modifier.fillMaxWidth()) {
                columnData.forEachIndexed { columnIndex, (_, column) ->
                    TableCell(
                        text = column.getOrElse(rowIndex) { "" },
                        weight = columnWeights[columnIndex]
                    )
                }
            }
        }
    }
}



