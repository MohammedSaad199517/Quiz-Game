package com.mohammed.quizgame.di

import android.content.Context
import androidx.room.Room
import com.mohammed.quizgame.data.Constants
import com.mohammed.quizgame.data.local.database.QuizGameDao
import com.mohammed.quizgame.data.local.database.QuizGameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideFootballDatabase(
        @ApplicationContext context: Context
    ): QuizGameDatabase =
        Room.databaseBuilder(
            context,
            QuizGameDatabase::class.java,
            Constants.DATABASE_NAME,
        ).build()

    @Singleton
    @Provides
    fun provideQuizGameDao(quizGameDatabase: QuizGameDatabase): QuizGameDao {
        return quizGameDatabase.quizGameDao
    }


}