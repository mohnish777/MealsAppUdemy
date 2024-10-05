package com.example.model.api

import com.example.model.response.MealsCategoriesResponse
import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse
}
