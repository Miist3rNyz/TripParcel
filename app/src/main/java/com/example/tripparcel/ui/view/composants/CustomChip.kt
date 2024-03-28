import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomChip(
    text: String,
    shape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color = Color.Blue,
    textColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(color = Color.Gray.copy(alpha = 0.2f), shape = shape)
            .padding(horizontal = 6.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 10.sp,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
        )
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipList(chips: List<String>) {
    Box(modifier = Modifier.fillMaxWidth()) {
        FlowRow(
            Modifier.fillMaxWidth(),
        ) {
            chips.forEach { chip ->
                CustomChip(text = chip, modifier = Modifier.padding(5.dp))
            }
        }
    }
}
