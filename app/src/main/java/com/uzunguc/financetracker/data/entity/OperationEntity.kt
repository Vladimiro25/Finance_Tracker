package com.uzunguc.financetracker.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.SET_NULL,

        )
    ],
    indices = [Index("categoryId")]
)
data class OperationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val categoryId: Int?,
    val name: String,
    val sum: String,
    val type: String,
    val date: String,
)