package com.nttdata.saleapp

import android.app.Application
import com.nttdata.saleapp.module.initDI

class SaleApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}