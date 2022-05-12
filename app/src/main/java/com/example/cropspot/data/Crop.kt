package com.example.cropspot.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Crop(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "is_supported") val isSupported: Boolean,
)