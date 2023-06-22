package bd.maruf.coinapp.feature_coin.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bd.maruf.coinapp.core.Resource
import bd.maruf.coinapp.feature_coin.domain.use_case.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(val useCase: GetCoinListUseCase) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoin()
    }


    private fun getCoin() {
        viewModelScope.launch(Dispatchers.IO) {

            useCase().onEach { result ->
                when (result) {

                    is Resource.Error -> _state.value =
                        CoinListState(error = result.message ?: "Unknown Error")

                    is Resource.Loading -> _state.value = CoinListState(isLoading = true)

                    is Resource.Success -> _state.value =
                        CoinListState(coins = result.data ?: emptyList())
                }
            }

        }
    }


}
