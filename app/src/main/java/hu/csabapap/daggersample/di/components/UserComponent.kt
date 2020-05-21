package hu.csabapap.daggersample.di.components

import dagger.Subcomponent
import hu.csabapap.daggersample.di.UserScope
import hu.csabapap.daggersample.di.modules.UserModule
import hu.csabapap.daggersample.di.modules.UserSubcomponentModule

@UserScope
@Subcomponent(modules = [UserModule::class, UserSubcomponentModule::class])
interface UserComponent {
    @Subcomponent.Builder
    interface Builder {
        fun userModule(userModule: UserModule): Builder
        fun build(): UserComponent
    }

    fun loggedInComponent(): LoggedInActivityComponent.Factory
    fun accountComponent(): AccountComponent.Factory
}