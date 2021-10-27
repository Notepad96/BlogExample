package com.example.apiloadretrofit.data

data class Item(
    val currencyCode: String,
    val tierMinimumUnits: Double,
    val retailPrice: Double,
    val unitPrice: Double,
    val armRegionName: String,
    val location: String,
    val effectiveStartDate: String,
    val effectiveEndDate: String,
    val meterId: String,
    val meterName: String,
    val productId: String,
    val skuId: String,
    val productName: String,
    val skuName: String,
    val serviceName: String,
    val serviceId: String,
    val serviceFamily: String,
    val unitOfMeasure: String,
    val type: String,
    val isPrimaryMeterRegion: Boolean,
    val armSkuName: String
)
