package uz.ultimatedevs.kattabozordemo1.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import uz.ultimatedevs.kattabozordemo1.data.model.ResultData
import uz.ultimatedevs.kattabozordemo1.data.model.response.OfferData
import uz.ultimatedevs.kattabozordemo1.domain.usecase.OffersUseCase
import javax.inject.Inject

@HiltViewModel
class OffersViewModelImpl @Inject constructor(
    private val offersUseCase: OffersUseCase
) : OffersViewModel, ViewModel() {
    override val offersFlow = MutableSharedFlow<List<OfferData>>()
    override val messageFlow = MutableSharedFlow<String>()
    override val errorFlow = MutableSharedFlow<Throwable>()
    override val loadingFlow = MutableSharedFlow<Boolean>()

    override fun getOffers() {
        viewModelScope.launch {
            loadingFlow.emit(true)
            offersUseCase.getOffers().collect {
                Timber.d("viewModel data :  $it")
                when (it) {
                    is ResultData.Success -> {
                        offersFlow.emit(it.data)
                    }
                    is ResultData.Message -> {
                        messageFlow.emit(it.message)
                    }
                    is ResultData.Error -> {
                        errorFlow.emit(it.error)
                    }
                }
                loadingFlow.emit(false)
            }
        }
    }

    init {
        getOffers()
    }
}