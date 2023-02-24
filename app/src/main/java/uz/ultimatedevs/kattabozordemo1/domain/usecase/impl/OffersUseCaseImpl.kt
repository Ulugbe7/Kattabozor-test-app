package uz.ultimatedevs.kattabozordemo1.domain.usecase.impl

import uz.ultimatedevs.kattabozordemo1.domain.repository.OffersRepository
import uz.ultimatedevs.kattabozordemo1.domain.usecase.OffersUseCase
import javax.inject.Inject

class OffersUseCaseImpl @Inject constructor(
    private val offersRepository: OffersRepository
) : OffersUseCase {

    // Usecase return repository value because we have not any logic.
    override fun getOffers() = offersRepository.getOffers()
}