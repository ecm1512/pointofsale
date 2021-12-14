package com.nttdata.saleapp.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.nttdata.saleapp.data.database.SaleDatabase
import com.nttdata.saleapp.data.database.SaleDatabaseDataSource
import com.nttdata.saleapp.data.repository.InventoryRepository
import com.nttdata.saleapp.data.repository.SaleDetailRepository
import com.nttdata.saleapp.data.repository.SaleRepository
import com.nttdata.saleapp.data.repository.UserRepository
import com.nttdata.saleapp.data.service.SaleServiceDataSource
import com.nttdata.saleapp.data.source.LocalDataSource
import com.nttdata.saleapp.data.source.RemoteDataSource
import com.nttdata.saleapp.domain.usecases.*
import com.nttdata.saleapp.presentation.home.inventory.InventoryFragment
import com.nttdata.saleapp.presentation.home.inventory.InventoryViewModel
import com.nttdata.saleapp.presentation.home.inventory.newarticle.NewArticleFragment
import com.nttdata.saleapp.presentation.home.inventory.newarticle.NewArticleViewModel
import com.nttdata.saleapp.presentation.home.pos.PosFragment
import com.nttdata.saleapp.presentation.home.pos.PosViewModel
import com.nttdata.saleapp.presentation.home.pos.newsale.NewSaleFragment
import com.nttdata.saleapp.presentation.home.pos.newsale.NewSaleViewModel
import com.nttdata.saleapp.presentation.home.pos.newsale.addproduct.AddProductFragment
import com.nttdata.saleapp.presentation.home.pos.newsale.addproduct.AddProductViewModel
import com.nttdata.saleapp.presentation.login.LoginActivity
import com.nttdata.saleapp.presentation.login.LoginViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.core.scope.get
import org.koin.dsl.module

fun Application.initDI(){
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule,scopesModule))
    }
}

private const val PREFERENCES_FILE_KEY = "sale_prefs"

private fun provideSettingsPreference(app: Application): SharedPreferences =
    app.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)

private val appModule = module {
    single { SaleDatabase.build(get()) }
    single { provideSettingsPreference(androidApplication()) }
    factory<RemoteDataSource> { SaleServiceDataSource(get()) }
    factory<LocalDataSource> { SaleDatabaseDataSource(get()) }
}

private val dataModule = module{
    factory { UserRepository(get()) }
    factory { InventoryRepository(get()) }
    factory { SaleRepository(get()) }
    factory { SaleDetailRepository(get()) }
}

private val scopesModule = module {
    scope(named<LoginActivity>()){
        viewModel { LoginViewModel(get()) }
        scoped{ Autenticate(get()) }
    }

    scope(named<PosFragment>()){
        viewModel{ PosViewModel(get(),get()) }
        scoped { GetSale(get()) }
    }

    scope(named<NewSaleFragment>()){
        viewModel{ NewSaleViewModel(get(),get()) }
        scoped { GetInventoryById(get()) }
    }

    scope(named<InventoryFragment>()){
        viewModel{ InventoryViewModel(get(),get()) }
        scoped { GetInventory(get()) }
    }

    scope(named<NewArticleFragment>()){
        viewModel{ NewArticleViewModel(get(),get()) }
        scoped { InsertInventory(get()) }
    }

    scope(named<AddProductFragment>()){
        viewModel{ AddProductViewModel(get(),get()) }
        scoped { GetInventory(get()) }
    }
}