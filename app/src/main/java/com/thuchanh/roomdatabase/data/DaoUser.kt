package com.thuchanh.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoUser {

    //vararg co the chuyen nhieu pram
    @Insert
    fun insert(vararg user:User )

    @Query("select * from User")
    fun getAll():LiveData<List<User>>

}