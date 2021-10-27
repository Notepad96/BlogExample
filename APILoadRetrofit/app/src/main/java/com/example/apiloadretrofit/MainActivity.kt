package com.example.apiloadretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
    var billingList: MutableList<Billing?> = mutableListOf()
    var pos = 0

    lateinit var listManager: RecyclerView.LayoutManager
    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiLoad("serviceName eq 'Virtual Machines' and armRegionName eq 'koreacentral'")

        btnListLoad.setOnClickListener {
//            for(item in billingList?.items!!) {
//                Log.d("test", "$item")
//            }
            listLoad()
        }

        btnListPrev.setOnClickListener {
            if(pos != 0) {
                pos--
                listLoad()
            }
        }
        btnListNext.setOnClickListener {
            var next: String = billingList[pos]?.nextPageLink ?: ""
            var url: String = next?.substring(next.indexOf("=") + 1) ?: ""
//            callGet = RetrofitBuilder.api.getPriceList(url,currencyCode = "KRW")
//
//
//            callGet.enqueue(object: Callback<Billing> {
//                override fun onResponse(call: Call<Billing>, response: Response<Billing>) {
//                    billingList.add(response.body())
//                    Log.d("test", "Success: ${response.body()}")
//                }
//
//                override fun onFailure(call: Call<Billing>, t: Throwable) {
//                    Log.d("test", "Error: $t")
//                }
//            })
            apiLoad(url)
            Log.d("test", "url = $url")
            pos++
//            listLoad()
        }

    }

    private fun apiLoad(url: String, cur: String = "KRW") {

        var callGet = RetrofitBuilder.api.getPriceList(url,"KRW")

        callGet.enqueue(object: Callback<Billing> {
            override fun onResponse(call: Call<Billing>, response: Response<Billing>) {
                billingList.add(response.body())
                Log.d("test", "Success: ${response.body()}")
                Toast.makeText(applicationContext, "API Load Complete", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Billing>, t: Throwable) {
                Log.d("test", "Error: $t")
            }
        })
    }

    private fun listLoad() {
        listManager = LinearLayoutManager(this)
        listAdapter = billingList[pos]?.let { it1 -> ListAdapter(it1.items) }!!
        var recyclerView = listCalc.apply {
            setHasFixedSize(true)
            layoutManager = listManager
            adapter = listAdapter
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
            @Query("currencyCode") currencyCode: String
        ): Call<Billing>
    }
}