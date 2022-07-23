package com.solulab.coin.di

import android.content.Context
import com.solulab.coin.BaseCoinApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent ::class)
object AppModule {


    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseCoinApplication {
        return  app as BaseCoinApplication
    }


    @Singleton
    @Provides
    fun provideRandomString():String{
        return "Random String"
    }

//
//    fun provideDataCclass():DataCClass{
//        return DataCClass("")
//    }

}