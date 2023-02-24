package uz.ultimatedevs.kattabozordemo1.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import uz.ultimatedevs.kattabozordemo1.data.model.ResultData
import uz.ultimatedevs.kattabozordemo1.data.model.response.OfferData
import uz.ultimatedevs.kattabozordemo1.data.remote.OffersApi
import uz.ultimatedevs.kattabozordemo1.domain.repository.OffersRepository
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val offersApi: OffersApi,
) : OffersRepository {

    override fun getOffers() = flow<ResultData<List<OfferData>>> {
        val response = offersApi.getOffers()
        if (response.isSuccessful) {
            val result = response.body()!!
            emit(ResultData.Success(result.offers))
        } else {
            emit(ResultData.Message(response.message()))
        }
    }.catch {
        Timber.d(it.message)
        emit(ResultData.Error(it))
    }.flowOn(Dispatchers.IO)
}