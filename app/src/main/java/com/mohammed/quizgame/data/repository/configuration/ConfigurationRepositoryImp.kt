package com.mohammed.quizgame.data.repository.configuration

import android.content.Context
import android.content.SharedPreferences

class ConfigurationRepositoryImp (private val context: Context) :ConfigurationRepository{

    override suspend fun saveConfiguration(selectedCategory: String?, selectedLevel: String?, selectedQuantity: Int?) {
        val editor = sharedPreferences.edit()

        if (selectedQuantity != null){
            editor.putInt(KEY_QUANTITY, selectedQuantity)
        }
        if (selectedLevel != null){
            editor.putString(KEY_LEVEL, selectedLevel)
        }
        if (selectedCategory != null){
            editor.putString(KEY_CATEGORY, selectedCategory)
        }
        editor.apply()
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }



    override suspend fun getSavedConfiguration(): SavedConfiguration? {
        val category = sharedPreferences.getString(KEY_CATEGORY, null)
        val level = sharedPreferences.getString(KEY_LEVEL, null)
        val quantity = sharedPreferences.getInt(KEY_QUANTITY, -1)
        return if (category != null && level != null && quantity != -1) {
            SavedConfiguration(category, level, quantity)
        } else {
            null
        }
    }

    private companion object {
        const val PREFERENCES_NAME = "configuration"
        const val KEY_CATEGORY = "selectedCategory"
        const val KEY_LEVEL = "selectedLevel"
        const val KEY_QUANTITY = "selectedQuantity"
    }

}