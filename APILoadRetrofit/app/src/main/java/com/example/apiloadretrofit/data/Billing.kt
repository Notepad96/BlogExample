package com.example.apiloadretrofit.data

import com.google.gson.annotations.SerializedName

data class Billing(
    @SerializedName("BillingCurrency")
    val billingCurrency: String,
    @SerializedName("CustomerEntityId")
    val customerEntityId: String,
    @SerializedName("CustomerEntityType")
    val customerEntityType: String,
    @SerializedName("Items")
    val items: List<Item>,
    @SerializedName("NextPageLink")
    val nextPageLink: String,
    @SerializedName("Count")
    val count: Int
)


