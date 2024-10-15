package me.patunki.todo.model

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean

)

const val BASE_URL: String = "https://jsonplaceholder.typicode.com"

interface TodosApi {
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    companion object {
        var todosServices: TodosApi? = null

        fun getInstance(): TodosApi {
            Log.d("tag5", "tag 5")
            if (todosServices === null){
                Log.d("tag6", "tag 6")
                todosServices = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }
            return todosServices!!
        }
    }
}
