package uz.ultimatedevs.kattabozordemo1.data.remote

import retrofit2.Response
import retrofit2.http.GET
import uz.ultimatedevs.kattabozordemo1.data.model.response.OfferResponse

interface OffersApi {

    @GET("offers")
    suspend fun getOffers(): Response<OfferResponse>
}