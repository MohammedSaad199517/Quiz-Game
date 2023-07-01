package com.mohammed.quizgame.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuizGameEntity::class], version = 1)
abstract class QuizGameDatabase():RoomDatabase() {
    abstract val quizGameDao: QuizGameDao

}