package hu.csabapap.daggersample.di.modules

import dagger.Module
import dagger.Provides
import hu.csabapap.daggersample.di.UserScope
import javax.inject.Named

@Module
class UserModule(private val hasAllView: Boolean){

    @UserScope
    @Provides
    @Named("user_type")
    fun provideType(): String {
        return if (hasAllView) {
            "all view user"
        } else {
            "regular user"
        }
    }
}