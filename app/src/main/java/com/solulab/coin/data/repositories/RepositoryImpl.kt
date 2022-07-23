package com.solulab.coin.data.repositories

import com.solulab.coin.data.remote.ApiService
import com.solulab.coin.data.remote.dto.ResponseDtoMapper
import com.solulab.coin.domain.model.DomainCoinResponse
import com.solulab.coin.domain.repositories.Repository
import com.solulab.coin.utils.Resource
import com.solulab.coin.utils.UiErrorText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ResponseDtoMapper,
) : Repository {

    override suspend fun getFromRepository(): Flow<Resource<List<DomainCoinResponse>>> {
        return flow {
            emit(Resource.Loading(true))
            //val response = apiService.getDataFromApiService(20, 0)
            try {
                val response = apiService.getDataFromApiService()
                emit(Resource.Success(mapper.mapToDomainModel(response)))
            } catch (e: IOException) {
                emit(Resource.Error(UiErrorText.DynamicString(e.message.toString())))
            } catch (e: HttpException) {
                emit(Resource.Error(UiErrorText.DynamicString(e.message.toString())))
            }
            emit(Resource.Loading(false))
        }
    }
}