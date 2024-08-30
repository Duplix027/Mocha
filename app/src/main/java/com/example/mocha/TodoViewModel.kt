package np.com.bimalkafle.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocha.MainActivity
import com.example.mocha.TodoData
import com.example.mocha.database.TodoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {

    val todoDao = MainActivity.todoDatabase.getTodoDao()

    val todoList: LiveData<List<TodoData>> = todoDao.getAllTodo()

    fun addTodo(title: String) {

        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addTodo(TodoData(title = title, isFavorite = false))

        }

    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
    }


}