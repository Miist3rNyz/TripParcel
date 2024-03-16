import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tripparcel.ui.view.composants.MainComponants
import com.example.tripparcel.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    val homeText by viewModel.homeText.collectAsState()
    Column {
        MainComponants(text = homeText, onClick = { viewModel.updateHomeText("Nouveau texte") })
    }
}
