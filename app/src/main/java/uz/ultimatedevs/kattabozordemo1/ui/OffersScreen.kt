package uz.ultimatedevs.kattabozordemo1.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.swiperefreshlayout.refreshes
import timber.log.Timber
import uz.ultimatedevs.kattabozordemo1.MainActivity
import uz.ultimatedevs.kattabozordemo1.R
import uz.ultimatedevs.kattabozordemo1.databinding.ScreenOffersBinding
import uz.ultimatedevs.kattabozordemo1.presenter.OffersViewModel
import uz.ultimatedevs.kattabozordemo1.presenter.OffersViewModelImpl
import uz.ultimatedevs.kattabozordemo1.ui.adapters.OffersAdapter

@AndroidEntryPoint
class OffersScreen : Fragment(R.layout.screen_offers) {

    private val viewModel: OffersViewModel by viewModels<OffersViewModelImpl>()
    private val binding by viewBinding(ScreenOffersBinding::bind)
    private val offersAdapter = OffersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadingFlow.onEach {
            (requireActivity() as MainActivity).showOrHideLoader(it)
        }.launchIn(lifecycleScope)

        viewModel.messageFlow.onEach {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)

        viewModel.errorFlow.onEach {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initListeners()
        initSubscribers()
    }

    private fun initListeners() {
        binding.rvOffers.adapter = offersAdapter

        binding.containerSwipeRefresh.refreshes().onEach {
            binding.containerSwipeRefresh.isRefreshing = false
            viewModel.getOffers()
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun initSubscribers() {

        viewModel.offersFlow.onEach {
            offersAdapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}