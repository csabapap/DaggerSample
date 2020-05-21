package hu.csabapap.daggersample.di.components

import dagger.Subcomponent
import hu.csabapap.daggersample.di.ActivityScope
import hu.csabapap.daggersample.di.modules.PrinterModule
import hu.csabapap.daggersample.ui.MainActivity

@ActivityScope
@Subcomponent(modules = [PrinterModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}