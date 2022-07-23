package com.solulab.coin.domain.repositories

import com.solulab.coin.domain.model.DomainCoinResponse
import com.solulab.coin.utils.Resource
import kotlinx.coroutines.flow.Flow


interface Repository {

    suspend fun getFromRepository(): Flow<Resource<List<DomainCoinResponse>>>
    //other fun domain (buisness model)
}