package com.example.apiloadretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiloadretrofit.data.Billing
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {
    var billingList: Billing? = null

    lateinit var listManager: RecyclerView.LayoutManager
    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callGet = RetrofitBuilder.api.getPriceList(currencyCode = "KRW", count = 200)

        callGet.enqueue(object: Callback<Billing> {
            override fun onResponse(call: Call<Billing>, response: Response<Billing>) {
                billingList = response.body()
                Log.d("test", "${response.body()}")
            }

            override fun onFailure(call: Call<Billing>, t: Throwable) {
                Log.d("test", "Error: $t")
            }
        })


        btnListLoad.setOnClickListener {
//            for(item in billingList?.items!!) {
//                Log.d("test", "$item")
//            }
            listManager = LinearLayoutManager(this)
            listAdapter = ListAdapter(billingList!!.items)
            var recyclerView = listCalc.apply {
                setHasFixedSize(true)
                layoutManager = listManager
                adapter = listAdapter
            }
        }

    }

    object RetrofitBuilder {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://prices.azure.com/api/retail/prices/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(AzureCalculate::class.java)
    }

    interface AzureCalculate {
        @GET(".")
        fun getPriceList(
            @Query("\$filter") filter: String = "serviceName eq 'Virtual Machines' and armRegionName eq 'koreacentral'",
            @Query("currencyCode") currencyCode: String,
            @Query("count") count: Int
        ): Call<Billing>
    }
}