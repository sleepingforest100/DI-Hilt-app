package kz.just_code.dihiltapp.data.repositories

import com.google.gson.Gson
import dagger.Provides
import kz.just_code.dihiltapp.data.network.WeatherApi
import kz.just_code.dihiltapp.data.network.WeatherApiError
import kz.just_code.dihiltapp.data.network.WeatherResponse
import okhttp3.ResponseBody
import javax.inject.Inject
import javax.inject.Singleton


interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): WeatherResponse?
    suspend fun searchWeather(text: String): WeatherResponse?
    suspend fun getWeeklyWeather(city: String): WeatherResponse?
}


class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): WeatherResponse? {
        val response = api.getCurrentWeather(city, "ru")
        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun searchWeather(text: String): WeatherResponse? {
        val response = api.searchWeather(text, "ru")
        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun getWeeklyWeather(city: String): WeatherResponse? {
        val response = api.getWeeklyWeather(city, "ru")
        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }


}
fun ResponseBody?.getErrorMessage(): String? {
    return try {
        Gson().fromJson(this?.charStream(), WeatherApiError::class.java)?.error?.message
    } catch (e: Exception) {
        e.message.orEmpty()
    }
}