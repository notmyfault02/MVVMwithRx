package com.example.mvvmwithrx.util

import android.arch.lifecycle.Lifecycle

interface LifecycleCallback {
    fun apply(event: Lifecycle.Event)
}