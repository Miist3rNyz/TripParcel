import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tripparcel.ui.view.composants.TopBar
import com.example.tripparcel.ui.view.composants.TripCard
import com.example.tripparcel.ui.view.ecrans.EmptyPage


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    val trips = viewModel.items
    val error = viewModel.error
    var tripLoading: MutableState<Boolean> = viewModel.tripLoading
    val pullRefreshState = rememberPullRefreshState(tripLoading.value, { viewModel.loadTrip() })
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier
                .padding(padding)
                .pullRefresh(pullRefreshState)) {
                if (tripLoading.value == true) {
                    LoadingScreen()
                } else {
                    if (tripLoading.value == true) {
                        Text("Erreur : $error")
                    } else {

                        if (trips.value.size!=0) {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(3.dp, 3.dp),
                                contentPadding = PaddingValues(5.dp),
                                verticalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                items(trips.value.size) { trip ->
                                    Box(
                                        modifier = Modifier
                                            .background(Color.White.copy(alpha = 0.9f))
                                            .fillMaxWidth()
                                            .padding(8.dp)
                                            .clickable {
                                                navController.navigate(NavigationItem.DetailScreen.route)
                                            }

                                    ) {
                                        TripCard(trips.value[trip])
                                    }
                                }
                            }
                            PullRefreshIndicator(
                                refreshing = tripLoading.value,
                                state = pullRefreshState,
                                modifier = Modifier.align(Alignment.TopCenter)
                            )
                        }else{
                            EmptyPage(onClick = {
                              viewModel.seederOperation()
                            })
                        }
                    }
                }
            }
        },
        modifier = Modifier.background(Color.White)


    )


}
