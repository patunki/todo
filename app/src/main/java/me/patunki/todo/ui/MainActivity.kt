package me.patunki.todo.ui

import android.os.Bundle
import android.util.Log
import android.util.Log.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.patunki.todo.model.Todo
import me.patunki.todo.ui.theme.TodoTheme
import me.patunki.todo.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag1", "tag 1")
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                TodoScreen()
            }
        }
    }
}

@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()){
    TodoList(todoViewModel.todos)
    Log.d("tag2", "tag 2")
}

@Composable
fun TodoList(todos: List<Todo>){
    Log.d("tag3", "tag 3")
    LazyColumn (
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos) { todo->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}