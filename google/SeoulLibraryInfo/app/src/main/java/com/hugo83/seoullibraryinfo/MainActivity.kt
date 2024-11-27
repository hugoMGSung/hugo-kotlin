package com.hugo83.seoullibraryinfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.hugo83.seoullibraryinfo.data.Library
import com.hugo83.seoullibraryinfo.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // 기본 위치(서울 시청) 설정
        val seoulCityHall = LatLng(37.5663, 126.9779)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoulCityHall, 12f))

        fetchLibraryData() // 도서관 데이터를 가져오고 마커 표시
    }

    private fun fetchLibraryData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(SeoulOpenApi.DOMAIN) // 서울 열린데이터광장 기본 URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val seoulOpenService = retrofit.create(SeoulOpenService::class.java)

        seoulOpenService
            .getLibrary(SeoulOpenApi.API_KEY)
            .enqueue(object : Callback<Library> {
            override fun onResponse(
                call: Call<Library>,
                response: Response<Library>
            ) {
                if (response.isSuccessful) {
                    Log.d("HUGO!!!", response.body().toString())
                    //showLibraries(response.body() as Library)
                }
            }

            override fun onFailure(call: Call<Library>, t: Throwable) {
                t.printStackTrace() // 오류 처리
                Toast.makeText(baseContext
                    , "서버에서 데이터를 가져올 수 없습니다."
                    , Toast.LENGTH_LONG).show()
                Log.e("HUGO!!!", "Error message: ${t.message}")
            }
        })
    }

    fun showLibraries(libraries:Library) {

    }
}