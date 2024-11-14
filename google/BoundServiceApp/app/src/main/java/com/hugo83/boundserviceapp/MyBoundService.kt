package com.hugo83.boundserviceapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MyBoundService : Service()
{
    // 서비스에 바인딩할 Binder 객체
    // LocalBinder 클래스: getService() 메서드를 통해 MyBoundService 객체를 반환하여 액티비티에서 서비스의 메서드를 호출할 수 있게
    private val binder = LocalBinder()
    
    // Binder 클래스 : 서비스와 바인딩할 때 사용 
    inner class LocalBinder : Binder() {
        fun getService(): MyBoundService = this@MyBoundService
    }

    // 바인딩 시 반환할 IBinder 객체
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }
    
    // 현재 시간을 반환하는 메서드
    // getCurrentTime() 메서드: 호출 시 현재 시간을 반환
    fun getCurrentTime(): String {
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return dateFormat.format(Date())
    }
}