package uz.ultimatedevs.kattabozordemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {


    fun showOrHideLoader(it: Boolean) {
        findViewById<ProgressBar>(R.id.loader).isVisible = it
    }
}