package com.thuchanh.roomdatabase.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version =1 )
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao():DaoUser

    companion object{
        @Volatile
        var INSTANCE :UserDatabase? = null

        fun getdatabase(contex:Context):UserDatabase{
            var tempInstace = INSTANCE
            if (tempInstace != null)
            {
                return tempInstace
            }
            synchronized(this)
            {
               var instance  = Room.databaseBuilder(
                    contex.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()

                INSTANCE = instance
                return instance

            }

        }

    }

}