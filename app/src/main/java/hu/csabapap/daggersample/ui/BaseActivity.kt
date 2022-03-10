package hu.csabapap.daggersample.ui

import androidx.appcompat.app.AppCompatActivity
import hu.csabapap.daggersample.DaggerExampleApp
import hu.csabapap.daggersample.di.AppComponent

abstract class BaseActivity: AppCompatActivity() {

    protected fun getAppComponent(): AppComponent {
        return (applicationContext as DaggerExampleApp).appComponent
    }

    protected fun getApp(): DaggerExampleApp {
        return (applicationContext as DaggerExampleApp)
    }

    val activityComponent by lazy {
        getAppComponent().activityComponent()
            .activity(this)
            .build()
    }
}