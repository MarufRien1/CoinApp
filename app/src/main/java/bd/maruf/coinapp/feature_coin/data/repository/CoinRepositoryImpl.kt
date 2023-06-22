package bd.maruf.coinapp.feature_coin.data.repository

import bd.maruf.coinapp.feature_coin.data.remote.CoinPaprikaApi
import bd.maruf.coinapp.feature_coin.data.remote.dto.CoinDetailDto
import bd.maruf.coinapp.feature_coin.data.remote.dto.CoinDto
import bd.maruf.coinapp.feature_coin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {

    override suspend fun getCoinList(): List<CoinDto> = api.getCoinList()

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto = api.getCoin(coinId)


}