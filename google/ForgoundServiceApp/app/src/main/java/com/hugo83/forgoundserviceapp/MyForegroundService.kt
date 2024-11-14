package com.hugo83.forgoundserviceapp

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MyForegroundService : Service() {

    // static 멤버를 정의
    companion object {
        // CHANNEL_ID: 알림 채널을 정의하고 식별하는 상수
        const val CHANNEL_ID = "ForegroundServiceChannel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    // onStartCommand() 메서드: 포어그라운드 서비스가 시작되면 startForeground()를 통해 알림
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE
        )

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("Foreground service is running.")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        // 서비스가 종료되지 않고 계속 실행되도록 설정
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    // 알림 채널 생성 (안드로이드 8.0 이상 필요)
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }
    }
}