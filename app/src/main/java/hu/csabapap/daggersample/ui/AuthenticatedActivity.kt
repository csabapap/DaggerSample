package hu.csabapap.daggersample.ui

import android.os.Bundle

abstract class AuthenticatedActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        addUserRelatedComponent()
        super.onCreate(savedInstanceState)
    }

    private fun addUserRelatedComponent() {
        if (getApp().userComponent == null) {
               getApp().addUserComponent(getApp().getUserType())
        }
    }

    val userComponent by lazy {
        getApp().userComponent
    }

    val authenticatedActivityComponent by lazy {
        userComponent?.authenticatedActivityComponent()?.build()
    }
}