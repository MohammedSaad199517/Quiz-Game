package com.mohammed.quizgame.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizGameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllQuestions(quizGame: List<QuizGameEntity>)

    @Query("SELECT * FROM QUIZ_GAME_TABLE ")
     fun getAllQuestions() : List<QuizGameEntity>
}