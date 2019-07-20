package project.shen.mvp

import android.content.res.Configuration
import android.os.Bundle

interface ILifycycle {
    fun onCreate(savedInstanceState: Bundle?)

    fun onSaveInstanceState(outState: Bundle)

    fun onViewStateRestored(savedInstanceState: Bundle?)

    fun onConfigurationChanged(newConfig: Configuration?)

    fun onDestroy()

    fun onStart()

    fun onStop()

    fun onResume()

    fun onPause()
}