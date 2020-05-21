package hu.csabapap.daggersample.di

import dagger.Component
import hu.csabapap.daggersample.di.modules.CoreModule
import hu.csabapap.daggersample.di.components.MainActivityComponent
import hu.csabapap.daggersample.di.modules.SubcomponentModule
import hu.csabapap.daggersample.di.components.UserComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, SubcomponentModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun coreModule(module: CoreModule): Builder
        fun build(): AppComponent
    }

    fun mainComponent(): MainActivityComponent.Factory
    fun userComponent(): UserComponent.Builder
}