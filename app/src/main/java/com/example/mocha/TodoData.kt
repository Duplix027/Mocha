package com.example.mocha

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var isFavorite: Boolean
)


