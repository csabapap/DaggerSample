package hu.csabapap.daggersample.ui

import androidx.appcompat.app.AppCompatActivity

abstract class AuthenticatedActivity: BaseActivity() {

    fun addUserRelatedComponent() {
        if (getApp().userComponent == null) {
               getApp().addUserComponent(getApp().getUserType())
        }
    }
}