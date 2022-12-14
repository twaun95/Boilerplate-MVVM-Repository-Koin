package com.twaun95.boilerplatemvvmkoin

import android.app.Application
import com.twaun95.boilerplatemvvmkoin.di.modules.DataModule
import com.twaun95.boilerplatemvvmkoin.di.modules.LogModule
import com.twaun95.boilerplatemvvmkoin.di.modules.ViewModelModule
import com.twaun95.core.logger.ActivityLifecycleLogger
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    private val activityLifeCycleLogger by inject<ActivityLifecycleLogger>()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                LogModule.module,
                ViewModelModule.module,
                DataModule.module
            )
        }
        registerActivityLifecycleCallbacks(activityLifeCycleLogger)
    }
}