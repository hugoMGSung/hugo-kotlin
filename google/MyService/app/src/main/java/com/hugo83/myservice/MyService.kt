package com.hugo83.myservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "서비스가 생성되었습니다.")
    }

    // 서비스 시작시 실행되는 메서드
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // return super.onStartCommand(intent, flags, startId)
        Log.d("MyService", "서비스가 시작되었습니다.")

        // 백그라운드 작섭 수행 예시
        Thread {
            for (i in 1..5) {
                Log.d("MyService", "작업실행 중... $i")
                Thread.sleep(1000)
            }
            Log.d("MyService", "작업완료")
            stopSelf() // 작업 완료후 서비스 종료
        }.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "서비스가 종료되었습니다.")
    }

    override fun onBind(intent: Intent?): IBinder? {
        // TODO("Not yet implemented")
        return null // Bound 서비스가 아니므로 null 반환
    }
}