package bd.maruf.coinapp.feature_coin.presentation.coin_detail
import bd.maruf.coinapp.feature_coin.domain.model.Coin
import bd.maruf.coinapp.feature_coin.domain.model.CoinDetail

data class CoinDetailState (
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
        )