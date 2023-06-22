package bd.maruf.coinapp.feature_coin.presentation.coin_list
import bd.maruf.coinapp.feature_coin.domain.model.Coin

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
        )