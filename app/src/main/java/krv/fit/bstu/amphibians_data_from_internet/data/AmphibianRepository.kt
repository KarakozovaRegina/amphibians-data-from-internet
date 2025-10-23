package krv.fit.bstu.amphibians_data_from_internet.data

import krv.fit.bstu.amphibians_data_from_internet.model.Amphibian
import krv.fit.bstu.amphibians_data_from_internet.network.AmphibianApiService

interface AmphibianRepository{
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibianRepository(
    private val amphibianApiService: AmphibianApiService
): AmphibianRepository {
    override suspend fun getAmphibians(): List<Amphibian> = amphibianApiService.getAmphibians()
}