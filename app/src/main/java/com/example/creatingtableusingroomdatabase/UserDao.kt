package com.example.creatingtableusingroomdatabase

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    fun datainsert(user: User)

}