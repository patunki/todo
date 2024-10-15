package me.patunki.todo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.patunki.todo.model.Todo
import me.patunki.todo.model.TodosApi

class TodoViewModel: ViewModel() {
    val todos = mutableListOf<Todo>()



    init {
        getTodosList()
    }

    private fun getTodosList(){
        Log.d("tag7", "tag 7")
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TODOVM", e.message.toString())
            }
        }
    }
}

