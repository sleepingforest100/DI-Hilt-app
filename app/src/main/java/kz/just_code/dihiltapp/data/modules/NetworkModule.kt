package kz.just_code.dihiltapp.data.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.just_code.dihiltapp.data.network.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @WeatherUrl
    private const val weatherUrl = "https://api.weatherapi.com/v1/"
    @WeatherUrl
    @Provides
    @Singleton
    fun getWeatherRetrofit(@WeatherUrl url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getWeatherApi(@WeatherUrl retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}

@Qualifier
annotation class WeatherUrl
