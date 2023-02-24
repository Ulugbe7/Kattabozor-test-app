package uz.ultimatedevs.kattabozordemo1.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ultimatedevs.kattabozordemo1.domain.repository.OffersRepository
import uz.ultimatedevs.kattabozordemo1.domain.repository.impl.OffersRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindOffersRepository(impl: OffersRepositoryImpl): OffersRepository
}