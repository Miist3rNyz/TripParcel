import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tripparcel.ui.view.composants.ComponentCircle
import com.example.tripparcel.ui.view.composants.ComponentRectangle
import com.example.tripparcel.ui.view.composants.ComponentRectangleLineLong
import com.example.tripparcel.ui.view.composants.ComponentRectangleLineShort
import com.example.tripparcel.ui.view.composants.ComponentSquare

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .border(border = BorderStroke(width = 0.dp, color = Color.White))
            .padding(20.dp)
    ) {
       LazyColumn(
           userScrollEnabled = false
       ) {
           items(6) { trip ->
           Column(
               modifier = Modifier.align(alignment = Alignment.TopCenter).padding(top = 8.dp, bottom = 8.dp)
           ) {

               Row {
                   ComponentCircle()
                   Spacer(modifier = Modifier.padding(4.dp))
                   Column {
                       Spacer(modifier = Modifier.padding(8.dp))
                       ComponentRectangleLineShort()
                       Spacer(modifier = Modifier.padding(4.dp))
                       ComponentRectangleLineLong()
                   }
               }
               Spacer(modifier = Modifier.padding(7.dp))
               Column {
                   ComponentRectangle()
               }

           }
       }
    }

}
}
