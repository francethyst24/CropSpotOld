package com.example.cropspot.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CropDao {
    @Query("SELECT * FROM crop")
    fun loadAllCrops(): Flow<List<Crop>>

    @Query("SELECT * FROM crop WHERE is_supported = 1")
    fun loadAllSupportedCrops(): Flow<List<Crop>>
}