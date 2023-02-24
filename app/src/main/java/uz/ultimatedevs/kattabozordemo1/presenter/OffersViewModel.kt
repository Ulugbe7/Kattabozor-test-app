package uz.ultimatedevs.kattabozordemo1.presenter

import kotlinx.coroutines.flow.Flow
import uz.ultimatedevs.kattabozordemo1.data.model.response.OfferData

interface OffersViewModel {

    val offersFlow: Flow<List<OfferData>>
    val messageFlow: Flow<String>
    val errorFlow: Flow<Throwable>
    val loadingFlow: Flow<Boolean>

    fun getOffers()
}