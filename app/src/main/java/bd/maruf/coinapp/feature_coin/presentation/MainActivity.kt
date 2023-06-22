package bd.maruf.coinapp.feature_coin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import bd.maruf.coinapp.ui.theme.CoinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "coin_list_screen") {

                        composable(
                            route = "coin_list_screen"
                        ) {
                            CoinListScreen(navController)

                        }

                        composable(
                            route = "coin_detail_screen"
                        ) {
                            CoinDetailScreen()

                        }

                    }
                }
            }
        }
    }
}

@Composable
fun CoinListScreen(navController: NavHostController) {
    Column() {
        Text(text = "This is the coin list screen")

        Button(onClick = { navController.navigate("coin_detail_screen") }) {
            Text(text = "Go to coin detail screen")
        }

    }

}

@Composable
fun CoinDetailScreen() {
    Text(text = "This is the coin Detail screen")

}

