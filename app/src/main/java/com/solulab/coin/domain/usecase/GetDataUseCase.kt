package com.solulab.coin.domain.usecase

import com.solulab.coin.domain.model.DomainCoinResponse
import com.solulab.coin.domain.repositories.Repository
import com.solulab.coin.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetDataUseCase @Inject
constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<Resource<List<DomainCoinResponse>>> {
        return repository.getFromRepository()
    }
}