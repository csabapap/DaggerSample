package hu.csabapap.daggersample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.csabapap.daggersample.DaggerExampleApp
import hu.csabapap.daggersample.R
import kotlinx.android.synthetic.main.activity_account.*
import javax.inject.Inject
import javax.inject.Named

class AccountActivity : AuthenticatedActivity() {

    @Inject
    @field:Named("user_type")
    lateinit var userType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addUserRelatedComponent()
        val userComponent = (application as DaggerExampleApp).userComponent
        if (userComponent == null) {
            finish()
            return
        }
        userComponent.accountComponent().create()
            .inject(this)

        setContentView(R.layout.activity_account)

        user_info.text = "User info: $userType"

        logout_btn.setOnClickListener {
            (application as DaggerExampleApp).releaseUserComponent()
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
