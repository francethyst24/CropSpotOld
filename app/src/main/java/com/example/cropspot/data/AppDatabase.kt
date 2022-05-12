package com.example.cropspot.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [Crop::class],
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cropDao(): CropDao
}