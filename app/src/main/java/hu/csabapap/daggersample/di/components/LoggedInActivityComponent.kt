package hu.csabapap.daggersample.di.components

import dagger.Subcomponent
import hu.csabapap.daggersample.di.ActivityScope
import hu.csabapap.daggersample.ui.LoggedInActivity

@ActivityScope
@Subcomponent
interface LoggedInActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoggedInActivityComponent
    }

    fun inject(activity: LoggedInActivity)
}