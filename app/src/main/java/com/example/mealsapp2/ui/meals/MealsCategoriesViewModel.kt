package com.example.mealsapp2.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.MealsRepository
import com.example.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals: List<MealResponse> = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList())

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}
