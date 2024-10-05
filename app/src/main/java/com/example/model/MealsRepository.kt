package com.example.model

import com.example.model.api.MealsWebService
import com.example.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse{
        return webService.getMeals()
    }
}
