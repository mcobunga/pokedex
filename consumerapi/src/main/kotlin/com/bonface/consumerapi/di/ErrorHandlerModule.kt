package com.bonface.consumerapi.di

import com.bonface.consumerapi.domain.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ErrorHandlerModule {

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler = ErrorHandler()
}
