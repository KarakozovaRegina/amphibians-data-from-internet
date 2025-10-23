package krv.fit.bstu.amphibians_data_from_internet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import krv.fit.bstu.amphibians_data_from_internet.ui.theme.AmphibiansdatafrominternetTheme
import krv.fit.bstu.amphibians_data_from_internet.ui.theme.page.AmphibiansViewModel
import krv.fit.bstu.amphibians_data_from_internet.ui.theme.page.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmphibiansdatafrominternetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val ambsViewModel: AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
                    HomeScreen(ambsUiState = ambsViewModel.amphibiansUiState, contentPadding = innerPadding)
                }
            }
        }
    }
}
