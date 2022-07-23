package com.solulab.coin.data.remote.dto

import com.solulab.coin.domain.model.DomainCoinResponse
import com.solulab.coin.domain.utils.DomainMapper


class ResponseDtoMapper : DomainMapper<ResponseDto, List<DomainCoinResponse>> {
    override fun mapToDomainModel(entity: ResponseDto): List<DomainCoinResponse> {
        val output: MutableList<DomainCoinResponse> = mutableListOf()
        entity.data?.list?.forEach { item ->
           output.add(
               DomainCoinResponse(
                   id = item?.id,
                   name = item?.name,
                   image = item?.pictures?.front?.url ?: ""
               )
           )
        }
        return output.toList()
    }

    override fun mapFromDomainModel(domainModel: List<DomainCoinResponse>): ResponseDto {
        TODO("Not yet implemented")
    }
/*
    override fun mapFromDomainModel(domainModel: DomainResponse): ResponseDto {
        return ResponseDto(

        )
    }

    private fun mapToDomainData(input: Data): DomainData {
        return DomainData(
            totalItems = input.totalItems,
            startIndex = input.startIndex,
            itemsPerPage = input.itemsPerPage,
            list = mapToDomainListItem(input.list as List<ListItem>),
        )


    }

    private fun mapToDomainListItem(input: List<ListItem>): List<DomainListItem> {
        val output: MutableList<DomainListItem> = mutableListOf()
        input.forEach { data ->
            output.add(
                DomainListItem(
                    isGraded = data.isGraded,
                    year = data.year,
                    price = data.price,
                    name = data.name,
                    id = data.id,
                    history = data.history,
                    age = data.age,
                    pictures = data.pictures?.let { mapToDomainPictures(it) },
                    isSold = data.isSold,
                    isCoin = data.isCoin,
                    tags = data.tags,
                )
            )
        }
        return output.toList()
    }

    private fun mapToDomainPictures(data: Pictures): DomainPictures {
        return DomainPictures(
            front = data.front?.let { mapToDomainFront(it) },
            back = data.back?.let { mapToDomainBack(it) },
        )
    }

    private fun mapToDomainFront(input: Front): DomainFront {
        return DomainFront(
            sizeInMegaByte = input.sizeInMegaByte,
            key = input.key,
            url = input.url,
        )
    }

    private fun mapToDomainBack(input: Back): DomainBack {
        return DomainBack(
            sizeInMegaByte = input.sizeInMegaByte,
            key = input.key,
            url = input.url,
        )
    }*/
}



