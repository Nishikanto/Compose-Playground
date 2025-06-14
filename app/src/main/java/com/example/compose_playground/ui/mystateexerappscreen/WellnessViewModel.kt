package com.example.compose_playground.ui.mystateexerappscreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WellnessViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<WellnessTask>()
    val tasks: List<WellnessTask> get() = _tasks

    init {
        viewModelScope.launch {
            val loadedTasks = getWellnessTasks()
            _tasks.addAll(loadedTasks)
        }
    }

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    private suspend fun getWellnessTasks(): List<WellnessTask> {
        delay(2000) // Simulate async fetch
        return List(30) { i -> WellnessTask(i, "Task #$i") }
    }
}

