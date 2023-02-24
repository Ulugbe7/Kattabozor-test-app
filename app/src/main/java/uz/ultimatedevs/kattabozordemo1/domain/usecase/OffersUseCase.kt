package uz.ultimatedevs.kattabozordemo1.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.ultimatedevs.kattabozordemo1.data.model.ResultData
import uz.ultimatedevs.kattabozordemo1.data.model.response.OfferData

interface OffersUseCase {

    fun getOffers(): Flow<ResultData<List<OfferData>>>
}