package kz.just_code.dihiltapp.data.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.just_code.dihiltapp.data.repositories.WeatherRepository
import kz.just_code.dihiltapp.data.useCases.GetCurrentWeatherInteraction
import kz.just_code.dihiltapp.data.useCases.GetCurrentWeatherUseCase
import kz.just_code.dihiltapp.data.useCases.GetWeeklyWeatherInteraction
import kz.just_code.dihiltapp.data.useCases.GetWeeklyWeatherUseCase
import kz.just_code.dihiltapp.data.useCases.SearchWeatherInteraction
import kz.just_code.dihiltapp.data.useCases.SearchWeatherUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideSearchWeatherUseCase(repo: WeatherRepository): SearchWeatherUseCase =
        SearchWeatherInteraction(repo)

    @Provides
    fun provideGetCurrentWeatherUseCase(repo: WeatherRepository): GetCurrentWeatherUseCase =
        GetCurrentWeatherInteraction(repo)

    @Provides
    fun GetWeeklyWeatherUseCase(repo: WeatherRepository): GetWeeklyWeatherUseCase =
        GetWeeklyWeatherInteraction(repo)


}