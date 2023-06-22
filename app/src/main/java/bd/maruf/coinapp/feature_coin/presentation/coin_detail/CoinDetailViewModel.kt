package bd.maruf.coinapp.feature_coin.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bd.maruf.coinapp.core.Resource
import bd.maruf.coinapp.feature_coin.domain.use_case.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val useCase: GetCoinDetailUseCase,
    safeStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        safeStateHandle.get<String>("coinId")?.let {
            useCase(it)
        }

    }


    private fun getCoin(coinId: String) {
        viewModelScope.launch(Dispatchers.IO) {

            useCase(coinId).onEach { result ->
                when (result) {

                    is Resource.Error -> _state.value =
                        CoinDetailState(error = result.message ?: "Unknown Error")

                    is Resource.Loading -> _state.value = CoinDetailState(isLoading = true)

                    is Resource.Success -> _state.value =
                        CoinDetailState(coin = result.data)
                }
            }

        }
    }


}
