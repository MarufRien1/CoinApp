package bd.maruf.coinapp.feature_coin.domain.use_case

import bd.maruf.coinapp.core.Resource
import bd.maruf.coinapp.feature_coin.data.remote.dto.toCoinDetail
import bd.maruf.coinapp.feature_coin.domain.model.CoinDetail
import bd.maruf.coinapp.feature_coin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())

            val coin = repository.getCoinDetail(coinId).toCoinDetail()
            emit(Resource.Success(coin))


        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.message ?: "Couldn't reach server. Check your internet connection"
                )
            )

        }

    }
}