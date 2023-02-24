package uz.ultimatedevs.kattabozordemo1.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.ultimatedevs.kattabozordemo1.data.model.ResultData
import uz.ultimatedevs.kattabozordemo1.data.model.response.OfferData

interface OffersRepository {

    fun getOffers(): Flow<ResultData<List<OfferData>>>
}