package com.muchori.joseph.distancetracker.di

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.muchori.joseph.distancetracker.R
import com.muchori.joseph.distancetracker.ui.MainActivity
import com.muchori.joseph.distancetracker.util.Constants.NOTIFICATION_CHANNEL_ID
import com.muchori.joseph.distancetracker.util.Constants.PENDING_INTENT_REQUEST_CODE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped

@Module
@InstallIn(ServiceComponent::class)
object NotificationModule {

  @ServiceScoped
  @Provides
  fun providePendingIntent(@ApplicationContext context: Context): PendingIntent {
    return PendingIntent.getActivity(
      context,
      PENDING_INTENT_REQUEST_CODE,
      Intent(context, MainActivity::class.java),
      FLAG_UPDATE_CURRENT
    )
  }

  @ServiceScoped
  @Provides
  fun provideNotificationBuilder(
    @ApplicationContext context: Context,
    pendingIntent: PendingIntent
  ): NotificationCompat.Builder {
    return NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
      .setAutoCancel(false)
      .setOngoing(true)
      .setSmallIcon(R.drawable.ic_run)
      .setContentIntent(pendingIntent)
  }

  @ServiceScoped
  @Provides
  fun provideNotificationManager(@ApplicationContext context: Context): NotificationManager {
    return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
  }
}