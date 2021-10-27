package com.example.apiloadretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apiloadretrofit.data.Billing
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    object RetrofitBuilder {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://prices.azure.com/api/retail/prices")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    interface AzureCalculate {
        @GET("")
        fun getPriceList(
            @Query("currencyCode") currencyCode: String
        ): Call<Billing>
    }
}