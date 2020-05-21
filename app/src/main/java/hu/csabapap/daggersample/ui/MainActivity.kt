package hu.csabapap.daggersample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.csabapap.daggersample.di.AppComponent
import hu.csabapap.daggersample.DaggerExampleApp
import hu.csabapap.daggersample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAppComponent().mainComponent().create()
                .inject(this)

        apple_btn.setOnClickListener {
            val hasAllViewRight = checkBox.isChecked
            getApp().saveUserType(hasAllViewRight)
            getApp().addUserComponent(hasAllViewRight)
            LoggedInActivity.start(this, hasAllViewRight)
        }
    }

    private fun getAppComponent(): AppComponent {
        return (applicationContext as DaggerExampleApp).appComponent
    }

    private fun getApp(): DaggerExampleApp {
        return (applicationContext as DaggerExampleApp)
    }
}
