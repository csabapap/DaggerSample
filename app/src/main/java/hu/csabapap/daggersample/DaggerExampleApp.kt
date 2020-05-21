package hu.csabapap.daggersample

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import hu.csabapap.daggersample.di.AppComponent
import hu.csabapap.daggersample.di.DaggerAppComponent
import hu.csabapap.daggersample.di.components.UserComponent
import hu.csabapap.daggersample.di.modules.CoreModule
import hu.csabapap.daggersample.di.modules.UserModule
import javax.inject.Inject

class DaggerExampleApp: Application() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var preferences: SharedPreferences
    var userComponent: UserComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .coreModule(CoreModule(this))
            .build()
        appComponent.inject(this)
    }

    fun addUserComponent(hasAllViewRight: Boolean): UserComponent {
        return appComponent.userComponent().userModule(
            UserModule(
                hasAllViewRight
            )
        ).build().also {
            userComponent = it
        }
    }

    fun releaseUserComponent() {
        userComponent = null
    }

    fun saveUserType(hasAllViewRight: Boolean) {
        preferences.edit()
            .putBoolean("has_all_view_right", hasAllViewRight)
            .apply()
    }

    fun getUserType(): Boolean {
        return preferences.getBoolean("has_all_view_right", false)
    }
}