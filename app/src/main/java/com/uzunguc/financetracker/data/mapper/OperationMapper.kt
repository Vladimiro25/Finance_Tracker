package com.uzunguc.financetracker.data.mapper

import com.uzunguc.financetracker.TypeOperation
import com.uzunguc.financetracker.data.entity.OperationEntity
import com.uzunguc.financetracker.domain.model.Operation
import java.time.LocalDateTime

fun Operation.toEntity(): OperationEntity{
    return OperationEntity(
        id = this.id,
        name = this.name,
        sum = this.sum.toString(),
        type = this.type.name,
        date = this.date.toString(),
        categoryId = this.categoryId,
    )
}

fun OperationEntity.toDomain(): Operation{
    return Operation(
        id = this.id,
        name = this.name,
        sum = this.sum.toBigDecimal(),
        type = TypeOperation.valueOf(type),
        date = LocalDateTime.parse(date),
        categoryId = this.categoryId
    )
}