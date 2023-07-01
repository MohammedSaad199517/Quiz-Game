package com.mohammed.quizgame.di

import com.mohammed.quizgame.data.repository.QuizGameRepository
import com.mohammed.quizgame.data.repository.QuizGameRepositoryImp
import com.mohammed.quizgame.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideQuizGameRepository(apiService: ApiService):QuizGameRepository =
        QuizGameRepositoryImp(apiService)



}