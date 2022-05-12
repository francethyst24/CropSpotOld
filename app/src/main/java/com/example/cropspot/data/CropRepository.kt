package com.example.cropspot.data

import javax.inject.Inject

class CropRepository @Inject constructor(
    cropDao: CropDao,
) {
    val loadAllCrops by lazy { cropDao.loadAllCrops() }
}