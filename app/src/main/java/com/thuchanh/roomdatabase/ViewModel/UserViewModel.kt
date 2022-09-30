package com.thuchanh.roomdatabase.ViewModel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thuchanh.roomdatabase.data.User
import com.thuchanh.roomdatabase.data.UserDatabase
import com.thuchanh.roomdatabase.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(applicetion : Application): AndroidViewModel(applicetion) {

    var getall : LiveData<List<User>>? = null
     var repository : UserRepository

    init {
        var userdao = UserDatabase.getdatabase(applicetion).userDao()
        repository = UserRepository(userdao)
        getall = repository.getall

        Log.d("AAA","AndroidViewModel()")

    }

    fun insert(user:User)
    {

           viewModelScope.launch (Dispatchers.IO){
               repository.insert(user)
           }
    }


}