package hu.csabapap.daggersample.di.modules

import dagger.Module
import dagger.Provides
import hu.csabapap.daggersample.di.ActivityScope

@Module
class PrinterModule {

    @ActivityScope
    @Provides
    fun provideTextToPrint(): String {
        return "apple"
    }



}