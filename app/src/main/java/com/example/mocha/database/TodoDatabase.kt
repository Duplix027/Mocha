package com.example.mocha.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mocha.TodoData

@Database(entities = [TodoData::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase: RoomDatabase(){
    companion object{
        const val DATABASE_NAME = "todo_database"
    }

    abstract fun getTodoDao(): TodoDao

}