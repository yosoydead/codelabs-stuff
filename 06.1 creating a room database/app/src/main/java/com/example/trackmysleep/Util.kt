package com.example.trackmysleep

import android.content.res.Resources

//returns a string representing the numeric quality rating
fun convertNumericQualityToString(quality: Int, resources: Resources): String{
    var qualityString = resources.getString(R.string.three_ok)

    when(quality){
        -1 -> qualityString = "--"
        0 -> qualityString = resources.getString(R.string.zero_very_bad)
        1 -> qualityString = resources.getString(R.string.one_poor)
        2 -> qualityString = resources.getString(R.string.two_soso)
        3 -> qualityString = resources.getString(R.string.three_ok)
        4 -> qualityString = resources.getString(R.string.four_pretty_good)
        5 -> qualityString = resources.getString(R.string.five_excellent)
    }

    return qualityString
}