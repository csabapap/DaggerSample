package hu.csabapap.daggersample.di.components

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
import hu.csabapap.daggersample.di.ActivityScope
import hu.csabapap.daggersample.di.modules.PrinterModule
import hu.csabapap.daggersample.ui.AccountActivity
import hu.csabapap.daggersample.ui.LoggedInActivity
import hu.csabapap.daggersample.ui.MainActivity

@ActivityScope
@Subcomponent(modules = [PrinterModule::class])
interface AuthenticatedActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): AuthenticatedActivityComponent
    }

    fun inject(activity: AccountActivity)
    fun inject(activity: LoggedInActivity)
}