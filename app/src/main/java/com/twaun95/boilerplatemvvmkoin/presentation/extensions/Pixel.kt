package com.twaun95.boilerplatemvvmkoin.presentation.extensions

import android.content.res.Resources

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
