package com.test.fitpeotest.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val title: String,
    val url: String,
    val thumbnailUrl: String,
) : Parcelable