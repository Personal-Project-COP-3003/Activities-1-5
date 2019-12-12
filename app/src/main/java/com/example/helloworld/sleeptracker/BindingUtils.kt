package com.example.helloworld.sleeptracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.helloworld.R
import com.example.helloworld.convertDurationToFormatted
import com.example.helloworld.convertNumericQualityToString
import com.example.helloworld.database.SleepNight

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNight?) {

    text = item?.startTimeMilli?.let { convertDurationToFormatted(it, item.endTimeMilli, context.resources) }

}

@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(item: SleepNight?) {
    text = item?.sleepQuality?.let { convertNumericQualityToString(it, context.resources) }
}

@BindingAdapter("sleepImage")
fun ImageView.setSleepImage(item: SleepNight?) {
    setImageResource(when (item?.sleepQuality) {
        0 -> R.drawable.ic_sleep_0
        1 -> R.drawable.ic_sleep_1
        2 -> R.drawable.ic_sleep_2
        3 -> R.drawable.ic_sleep_3
        4 -> R.drawable.ic_sleep_4
        5 -> R.drawable.ic_sleep_5
        else -> R.drawable.ic_sleep_active
    })
}
