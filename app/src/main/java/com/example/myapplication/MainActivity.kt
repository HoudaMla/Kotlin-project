package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ListAdapter
import com.example.myapplication.adapter.NavAdapter
import com.example.myapplication.fragment.homefragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL ="https://api.unsplash.com/"
class MainActivity : AppCompatActivity() {
    lateinit var navAdapter: NavAdapter
    lateinit var listAdapter: ListAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.vertical_recycler_view)
        linearLayoutManager = LinearLayoutManager(this)

        findViewById<RecyclerView>(R.id.horizontale_recycler_view)
        linearLayoutManager = LinearLayoutManager(this)
        //injecter le fragment
        val transaction= supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment , homefragment(this))
        transaction.addToBackStack(null)
        transaction.commit()
        getMyData()


    }

    private fun getMyData() {
        val retrofitBuilder =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {

                val responseBody = response.body()!!
                d("affiche","mrg"+responseBody)
                listAdapter = ListAdapter(baseContext , responseBody)
                listAdapter.notifyDataSetChanged()
                findViewById<RecyclerView>(R.id.vertical_recycler_view).adapter = listAdapter
                navAdapter = NavAdapter(baseContext , responseBody)
                navAdapter.notifyDataSetChanged()
                findViewById<RecyclerView>(R.id.horizontale_recycler_view).adapter = navAdapter
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
            }
        })


    }
}