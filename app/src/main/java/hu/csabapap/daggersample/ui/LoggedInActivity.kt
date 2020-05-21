package hu.csabapap.daggersample.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.csabapap.daggersample.DaggerExampleApp
import hu.csabapap.daggersample.R
import kotlinx.android.synthetic.main.activity_logged_in.*
import javax.inject.Inject
import javax.inject.Named

class LoggedInActivity : AuthenticatedActivity() {

    @Inject
    @field:Named("user_type")
    lateinit var userType: String

    @Inject
    @field:Named("global_properties")
    lateinit var property: String

    @Inject
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addUserRelatedComponent()
        val userComponent = getApp().userComponent
        if (userComponent == null) {
            finish()
            return
        }
        userComponent.loggedInComponent().create()
            .inject(this)
        setContentView(R.layout.activity_logged_in)
        textView.text = property
        user_info.text = "User type: $userType"
        account_btn.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
    }

    companion object {
        fun start(context: Context, hasAllViewRight: Boolean) {
            val intent = Intent(context, LoggedInActivity::class.java)
            intent.putExtra("has_allview_right", hasAllViewRight)
            context.startActivity(intent)
        }
    }
}
