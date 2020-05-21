package hu.csabapap.daggersample.di.modules

import dagger.Module
import hu.csabapap.daggersample.di.components.MainActivityComponent
import hu.csabapap.daggersample.di.components.UserComponent

@Module(subcomponents = [MainActivityComponent::class,
    UserComponent::class])
class SubcomponentModule