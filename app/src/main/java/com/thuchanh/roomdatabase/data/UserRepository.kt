package com.thuchanh.roomdatabase.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.delay

class UserRepository(private var userdao : DaoUser ) {

    var getall : LiveData<List<User>> = userdao.getAll()

    suspend fun insert(user : User )
    {

        userdao.insert(user)
    }

}