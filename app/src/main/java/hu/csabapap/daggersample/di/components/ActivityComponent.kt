package hu.csabapap.daggersample.di.components

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
import hu.csabapap.daggersample.di.ActivityScope
import hu.csabapap.daggersample.di.modules.PrinterModule
import hu.csabapap.daggersample.ui.MainActivity

@ActivityScope
@Subcomponent(modules = [PrinterModule::class])
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity: AppCompatActivity): Builder
        fun build(): ActivityComponent
    }

    fun inject(activity: MainActivity)
}