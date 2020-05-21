package hu.csabapap.daggersample.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class CoreModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Named("global_properties")
    @Provides
    fun provideGlobalProperties(): String {
        return "app level property"
    }

}