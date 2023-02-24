package uz.ultimatedevs.kattabozordemo1.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ultimatedevs.kattabozordemo1.domain.usecase.OffersUseCase
import uz.ultimatedevs.kattabozordemo1.domain.usecase.impl.OffersUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @[Binds Singleton]
    fun bindOffersRepository(impl: OffersUseCaseImpl): OffersUseCase
}
