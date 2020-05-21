package hu.csabapap.daggersample.di.components

import dagger.Subcomponent
import hu.csabapap.daggersample.di.ActivityScope
import hu.csabapap.daggersample.ui.AccountActivity

@ActivityScope
@Subcomponent
interface AccountComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AccountComponent
    }

    fun inject(activity: AccountActivity)
}