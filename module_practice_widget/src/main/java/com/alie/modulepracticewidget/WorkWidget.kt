package com.alie.modulepracticewidget

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class WorkWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        updateAppWidget(context, appWidgetManager, appWidgetIds)
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val views = RemoteViews(context.packageName, R.layout.work_widget)
        views.setOnClickPendingIntent(
            R.id.btn1,
            generatePendingIntent(R.string.widget_port_1, context)
        )
        views.setOnClickPendingIntent(
            R.id.btn2,
            generatePendingIntent(R.string.widget_port_2, context)
        )
        views.setOnClickPendingIntent(
            R.id.btn3,
            generatePendingIntent(R.string.widget_port_3, context)
        )
        appWidgetManager.updateAppWidget(appWidgetIds, views)
    }


    // todo 1.need to find out what happened in uri jump
    // todo 2.need to find out no icon issue
    @SuppressLint("UnspecifiedImmutableFlag")
    private fun generatePendingIntent(resId: Int, context: Context): PendingIntent =
        PendingIntent.getActivity(context.applicationContext, 0, Intent(context,TestActivity1::class.java).apply {
            action = context.getString(R.string.widget_action)
            data = Uri.parse(context.getString(R.string.widget_scheme)
                .plus("://")
                .plus(context.getString(R.string.widget_host))
                .plus(":")
                .plus(context.getString(resId)))
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            println(data.toString())
        }, PendingIntent.FLAG_UPDATE_CURRENT)
}

