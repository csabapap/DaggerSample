package hu.csabapap.daggersample.di.components

import dagger.Subcomponent
import hu.csabapap.daggersample.di.UserScope
import hu.csabapap.daggersample.di.modules.UserModule

@UserScope
@Subcomponent(modules = [UserModule::class])
interface UserComponent {
    @Subcomponent.Builder
    interface Builder {
        fun userModule(userModule: UserModule): Builder
        fun build(): UserComponent
    }

    fun authenticatedActivityComponent(): AuthenticatedActivityComponent.Builder
}