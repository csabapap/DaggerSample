package hu.csabapap.daggersample.di.modules

import dagger.Module
import hu.csabapap.daggersample.di.components.LoggedInActivityComponent
import hu.csabapap.daggersample.di.components.AccountComponent

@Module(subcomponents = [LoggedInActivityComponent::class, AccountComponent::class])
class UserSubcomponentModule {
}