package com.wcg.interviewdharmarajmangukiya

import android.app.Application
import com.wcg.interviewdharmarajmangukiya.data.network.repositories.MainActivityRepository
import com.wcg.interviewdharmarajmangukiya.factory.MainActivityViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class InterviewDharmarajMangukiya : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@InterviewDharmarajMangukiya))

        bind() from singleton { MainActivityRepository(instance()) }
        bind() from provider { MainActivityViewModelFactory(instance()) }

    }
}