package com.nefrit.app.di

import com.nefrit.app.App
import com.nefrit.common.di.CommonApi
import com.nefrit.common.di.CommonHolder
import com.nefrit.core_db.di.DbApi
import com.nefrit.core_db.di.DbHolder
import com.nefrit.core_di.FeatureApiHolder
import com.nefrit.core_di.FeatureContainer
import com.nefrit.core_di.scope.ApplicationScope
import com.nefrit.core_network_api.di.NetworkApi
import com.nefrit.core_network_impl.di.NetworkHolder
import com.nefrit.feature_user_api.di.UserFeatureApi
import com.nefrit.splash.di.SplashFeatureApi
import com.nefrit.splash.di.SplashFeatureHolder
import com.nefrit.users.di.UserFeatureHolder
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ComponentHolderModule {

    @ApplicationScope
    @Binds
    fun provideFeatureContainer(application: App): FeatureContainer

    @ApplicationScope
    @Binds
    @ClassKey(NetworkApi::class)
    @IntoMap
    fun provideNetworkHolder(networkHolder: NetworkHolder): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(CommonApi::class)
    @IntoMap
    fun provideCommonHolder(commonHolder: CommonHolder): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(SplashFeatureApi::class)
    @IntoMap
    fun provideSplashFeatureHolder(splashFeatureHolder: SplashFeatureHolder): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(UserFeatureApi::class)
    @IntoMap
    fun provideUserFeatureHolder(userFeatureHolder: UserFeatureHolder): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(DbApi::class)
    @IntoMap
    fun provideDbFeature(dbHolder: DbHolder): FeatureApiHolder
}