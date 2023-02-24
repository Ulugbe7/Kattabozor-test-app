package uz.ultimatedevs.kattabozordemo1.app

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import uz.ultimatedevs.kattabozordemo1.BuildConfig

@HiltAndroidApp
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}