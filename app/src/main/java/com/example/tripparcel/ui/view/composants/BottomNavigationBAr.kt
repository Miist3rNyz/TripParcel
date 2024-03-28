import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tripparcel.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Add,
        NavigationItem.Notification,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.height(60.dp),

        ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.title,
                    tint = if (currentRoute == item.route) Color(0xffd02d27).copy(alpha = 0.9f) else Color.Black
                )},
                label = { Text(text = item.title, fontSize = 12.sp, color = if (currentRoute == item.route)Color(0xffd02d27).copy(alpha = 0.9f) else Color.Black  ) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.White.copy(0.8f),
                alwaysShowLabel = true,
                selected =  currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    data object Home : NavigationItem("home", R.drawable.outline_house_24, "Home")
    data object Add : NavigationItem("add", R.drawable.outline_add_box_24, "Publié")
    data object Notification : NavigationItem("notification", R.drawable.outline_circle_notifications_24, "Notification")
    data object Profile : NavigationItem("profil", R.drawable.outline_person_24, "Profile")
    data object DetailScreen : NavigationItem("detail", R.drawable.outline_person_24, "Detail")
}




