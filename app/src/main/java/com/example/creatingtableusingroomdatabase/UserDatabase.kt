package com.example.creatingtableusingroomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[User::class], version = 1 )
abstract class UserDatabase :RoomDatabase(){

abstract fun getUserDao() : UserDao


companion object{
    var db:UserDatabase?=null

    public fun getInstance(context: Context):UserDatabase{

if (db==null){
    db= Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        "user_db"

    ).allowMainThreadQueries().build()
}



        return db as UserDatabase
    }
}
}