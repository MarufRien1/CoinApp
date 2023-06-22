package bd.maruf.coinapp.feature_coin.domain.model

import bd.maruf.coinapp.feature_coin.data.remote.dto.Tag
import bd.maruf.coinapp.feature_coin.data.remote.dto.Team

data class CoinDetail(
    val description: String,
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
)