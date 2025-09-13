package com.bonface.pokedex.di

import android.content.Context
import com.bonface.pokedex.helpers.NetworkConnectionDelegate
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNetworkConnectionDelegate(
        @ApplicationContext context: Context
    ): NetworkConnectionDelegate = NetworkConnectionDelegate(context)
}
