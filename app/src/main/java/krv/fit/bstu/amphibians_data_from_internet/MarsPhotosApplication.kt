package krv.fit.bstu.amphibians_data_from_internet

import android.app.Application
import krv.fit.bstu.amphibians_data_from_internet.data.AppContainer
import krv.fit.bstu.amphibians_data_from_internet.data.DefaultAppContainer

class AmphibianApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}