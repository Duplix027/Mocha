package com.example.mocha.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mocha.TodoData


@Dao
interface TodoDao {

    @Query("SELECT * FROM TodoData")
    fun getAllTodo(): LiveData<List<TodoData>>

    @Insert
    fun addTodo(todo: TodoData)

    @Query("DELETE FROM TodoData WHERE id = :id")
    fun deleteTodo(id: Int)

}