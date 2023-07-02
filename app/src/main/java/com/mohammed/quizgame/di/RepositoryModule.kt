package com.mohammed.quizgame.di

import android.content.Context
import com.mohammed.quizgame.data.local.database.QuizGameDao
import com.mohammed.quizgame.data.remote.ApiService
import com.mohammed.quizgame.data.repository.configuration.ConfigurationRepository
import com.mohammed.quizgame.data.repository.configuration.ConfigurationRepositoryImp
import com.mohammed.quizgame.data.repository.quiz.QuizRepository
import com.mohammed.quizgame.data.repository.quiz.QuizRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideQuizRepository(
        apiService: ApiService,
        dao: QuizGameDao,
    ): QuizRepository =
        QuizRepositoryImp(apiService, dao)

    @Singleton
    @Provides
    fun provideConfigurationRepository(
        @ApplicationContext context: Context

    ) :ConfigurationRepository= ConfigurationRepositoryImp(context)


}