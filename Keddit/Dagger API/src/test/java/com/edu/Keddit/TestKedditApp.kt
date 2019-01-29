package com.edu.Keddit

import android.app.Application

class TestKedditApp : Application() {

    companion object {
        lateinit var testNewsComponent: TestNewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        testNewsComponent = DaggerTestNewsComponent.builder()
                .testAppModule(TestAppModule(this))
                //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }

    fun getTestNewsComponent(): TestNewsComponent {
        return testNewsComponent
    }

    fun initTestComponent() {
        testNewsComponent = DaggerTestNewsComponent.builder()
                .testAppModule(TestAppModule(this))
                //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }
}