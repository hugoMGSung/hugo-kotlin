package com.hugo83.seoulpubliclibraryinfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.hugo83.seoulpubliclibraryinfo.data.Library
import com.hugo83.seoulpubliclibraryinfo.data.Row
import com.hugo83.seoulpubliclibraryinfo.databinding.ActivityMainBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mMap: GoogleMap
    private lateinit var clusterManager: ClusterManager<Row>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // 기본 위치(서울 시청) 설정
        //val seoulCityHall = LatLng(37.551228, 126.988208) // 서울N타워 위치
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoulCityHall, 12f))

        // 클러스터 매니저 세팅
        clusterManager = ClusterManager(this, mMap)
        mMap.setOnCameraIdleListener(clusterManager) // 화면을 이동 후 멈췄을  때 설정
        mMap.setOnMarkerClickListener(clusterManager) // 마커 클릭 설정

        loadLibraries()
    }

    fun loadLibraries() {
        val retrofit = Retrofit.Builder()
            .baseUrl(SeoulOpenApi.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val seoulOpenService = retrofit.create(SeoulOpenService::class.java)
        seoulOpenService
            .getLibrary(SeoulOpenApi.API_KEY)
            .enqueue(object : Callback<Library> {
                // OpenAPI 호출이 실패하면
                override fun onFailure(call: Call<Library>, t: Throwable) {
                    Toast.makeText(baseContext, "서버에서 데이터를 가져올 수 없습니다.", Toast.LENGTH_LONG).show()
                }
                
                // OpenAPI 호출이 성공하면
                override fun onResponse(call: Call<Library>, response: Response<Library>) {
                    // Toast.makeText(baseContext, "데이터가 있습니다.", Toast.LENGTH_LONG).show()
                    showLibraries(response.body() as Library)
                }
            })
    }

    fun showLibraries(libraries:Library) {
        val latLngBounds = LatLngBounds.Builder()

        Toast.makeText(baseContext, libraries.SeoulPublicLibraryInfo.row.count().toString(), Toast.LENGTH_LONG).show()

        for (lib in libraries.SeoulPublicLibraryInfo.row) {
            //5. 기존 마커 세팅코드는 삭제하고 클러스터 메니저에 데이터를 추가하는 코드만 넣어준다.
            clusterManager.addItem(lib)

            // 첫 화면에 보여줄 범위를 정하기 위해서 아래 코드 두 줄은 남겨둔다.
            val position = LatLng(lib.XCNTS.toDouble(), lib.YDNTS.toDouble())
            latLngBounds.include(position)
        }

        val bounds = latLngBounds.build()
        val padding = 0
        val updated = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        mMap.moveCamera(updated)
    }
}