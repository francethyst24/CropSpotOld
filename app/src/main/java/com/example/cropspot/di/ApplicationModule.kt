package com.example.cropspot.di

import android.content.Context
import androidx.room.Room
import com.example.cropspot.data.AppDatabase
import com.example.cropspot.data.CropDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "db_cropspot"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCropDao(db: AppDatabase): CropDao {
        return db.cropDao()
    }

}