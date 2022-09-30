package com.thuchanh.roomdatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(

    @PrimaryKey val Ten: String,
    val Tuoi: Int,

    )





