package com.example.creatingtableusingroomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    fun userInsert(user: User)

    @Update
    fun userUpdate(user: User)

    @Delete
    fun userDelete(user: User)


    @Query("SELECT *FROM User")
fun getAllUser():List<User>
}