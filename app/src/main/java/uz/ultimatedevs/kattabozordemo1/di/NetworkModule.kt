package uz.ultimatedevs.kattabozordemo1.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.ultimatedevs.kattabozordemo1.BuildConfig
import uz.ultimatedevs.kattabozordemo1.data.remote.OffersApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @[Provides Singleton]
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @[Provides Singleton]
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()


    @[Provides Singleton]
    fun providesRetrofitInstance(client: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()

    @Provides
    fun provideOffersApi(retrofit: Retrofit): OffersApi = retrofit.create(OffersApi::class.java)
}