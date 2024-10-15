package com.example.mealsapp2.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.model.MealsRepository
import com.example.model.response.MealResponse

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val repository: MealsRepository = MealsRepository()

    var mealState =  mutableStateOf<MealResponse?>(null)

    init{
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }

}
