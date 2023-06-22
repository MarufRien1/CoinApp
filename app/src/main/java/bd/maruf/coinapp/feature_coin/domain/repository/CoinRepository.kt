package bd.maruf.coinapp.feature_coin.domain.repository

import bd.maruf.coinapp.feature_coin.data.remote.dto.CoinDetailDto
import bd.maruf.coinapp.feature_coin.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoinList():List<CoinDto>

    suspend fun getCoinDetail(coinId:String):CoinDetailDto
}