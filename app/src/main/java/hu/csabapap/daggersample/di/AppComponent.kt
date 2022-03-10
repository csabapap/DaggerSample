package hu.csabapap.daggersample.di

import dagger.Component
import hu.csabapap.daggersample.DaggerExampleApp
import hu.csabapap.daggersample.di.components.ActivityComponent
import hu.csabapap.daggersample.di.components.UserComponent
import hu.csabapap.daggersample.di.modules.CoreModule
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun coreModule(module: CoreModule): Builder
//        fun application(app: DaggerExampleApp): Builder
        fun build(): AppComponent
    }

    fun activityComponent(): ActivityComponent.Builder
    fun userComponent(): UserComponent.Builder

    fun inject(app: DaggerExampleApp)
}