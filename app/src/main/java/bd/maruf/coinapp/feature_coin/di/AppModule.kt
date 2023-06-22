package bd.maruf.coinapp.feature_coin.di

import bd.maruf.coinapp.core.Constants
import bd.maruf.coinapp.feature_coin.data.remote.CoinPaprikaApi
import bd.maruf.coinapp.feature_coin.data.repository.CoinRepositoryImpl
import bd.maruf.coinapp.feature_coin.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    suspend fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)


}