package bd.maruf.coinapp.feature_coin.data.remote

import bd.maruf.coinapp.feature_coin.data.remote.dto.CoinDetailDto
import bd.maruf.coinapp.feature_coin.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoinList(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoin(@Path("coinId") coinId: String): CoinDetailDto
}