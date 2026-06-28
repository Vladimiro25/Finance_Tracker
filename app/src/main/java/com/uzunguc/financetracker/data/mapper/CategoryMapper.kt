package com.uzunguc.financetracker.data.mapper

import com.uzunguc.financetracker.data.entity.CategoryEntity
import com.uzunguc.financetracker.domain.model.Category

fun Category.toEntity(): CategoryEntity{
    return CategoryEntity(
        id = this.id,
        name = this.name,
        iconRes = this.iconRes,
        color = this.color
    )
}

fun CategoryEntity.toDomain(): Category{
    return Category(
        id = this.id,
        name = this.name,
        iconRes = this.iconRes,
        color = this.color
    )
}