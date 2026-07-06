package com.uzunguc.financetracker.domain.model

import com.uzunguc.financetracker.TypeOperation
import java.math.BigDecimal
import java.time.LocalDateTime

data class Operation(
    val id: Int,
    val name: String,
    val sum: BigDecimal,
    val type: TypeOperation,
    val date: LocalDateTime,
    val categoryId: Int? = null,
)