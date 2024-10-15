package com.example.model

import com.example.model.api.MealsWebService
import com.example.model.response.MealResponse
import com.example.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoriesResponse{
        val response  = webService.getMeals()
        cachedFoodItems = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse?{
        return cachedFoodItems.firstOrNull{
            it.id == id
        }
    }

    companion object{
        lateinit var cachedFoodItems: List<MealResponse>
    }
}
