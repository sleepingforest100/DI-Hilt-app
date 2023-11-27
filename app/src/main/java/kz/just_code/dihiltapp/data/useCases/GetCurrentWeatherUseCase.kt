package kz.just_code.dihiltapp.data.useCases

import kz.just_code.dihiltapp.data.network.WeatherResponse
import kz.just_code.dihiltapp.data.repositories.WeatherRepository

interface GetCurrentWeatherUseCase {
    suspend fun execute(city: String): WeatherResponse?
}

class GetCurrentWeatherInteraction(
    private val repo: WeatherRepository
) : GetCurrentWeatherUseCase {
    override suspend fun execute(city: String): WeatherResponse? {
        return repo.getCurrentWeather(city)
    }
}


interface SearchWeatherUseCase {
    suspend fun execute(text: String): WeatherResponse?
}

class SearchWeatherInteraction(
    private val repo: WeatherRepository
) : SearchWeatherUseCase {
    override suspend fun execute(text: String): WeatherResponse? {
        return repo.searchWeather(text)
    }
}


interface GetWeeklyWeatherUseCase {
    suspend fun execute(city: String): WeatherResponse?
}

class GetWeeklyWeatherInteraction(
    private val repo: WeatherRepository
) : GetWeeklyWeatherUseCase {
    override suspend fun execute(city: String): WeatherResponse? {
        return repo.getWeeklyWeather(city)
    }
}

