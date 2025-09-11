package com.bonface.consumerapi.di

import com.bonface.consumerapi.repository.PokemonRepository
import com.bonface.consumerapi.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}