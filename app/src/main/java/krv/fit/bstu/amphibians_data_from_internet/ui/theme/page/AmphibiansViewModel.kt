package krv.fit.bstu.amphibians_data_from_internet.ui.theme.page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import krv.fit.bstu.amphibians_data_from_internet.AmphibianApplication
import krv.fit.bstu.amphibians_data_from_internet.data.AmphibianRepository
import krv.fit.bstu.amphibians_data_from_internet.model.Amphibian
import java.io.IOException

sealed interface AmphibiansUiState {
    data class Success(val amphibians: List<Amphibian>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}


class AmphibiansViewModel(
    private val amphibianRepository: AmphibianRepository
): ViewModel() {

    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibians()
    }

     fun getAmphibians() {
        viewModelScope.launch {
            try {
                // val marsPhotosRepository = NetworkMarsPhotosRepository() // есть уже при вызове вью-модел
                val result = amphibianRepository.getAmphibians()
                amphibiansUiState = AmphibiansUiState.Success(result)
            } catch (e: IOException) {
                amphibiansUiState = AmphibiansUiState.Error
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                val amphibianRepository = application.container.amphibianRepository
                AmphibiansViewModel(amphibianRepository = amphibianRepository)
            }
        }
    }
}