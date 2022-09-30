package com.thuchanh.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.thuchanh.roomdatabase.ViewModel.UserViewModel
import com.thuchanh.roomdatabase.data.User
import com.thuchanh.roomdatabase.databinding.ActivityAddUserBinding

class AddUserActivity : AppCompatActivity() {
    lateinit var binding :ActivityAddUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var model = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.add.setOnClickListener {

            var ten = binding.ten.text.toString()
            var tuoi = binding.tuoi.text.toString()

            var user = User(ten,tuoi.toInt())

            if (checker(ten,tuoi))
            {
                Toast.makeText(this,"Nhap day du thong tin",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"Them Thanh Cong",Toast.LENGTH_SHORT).show()
                model.insert(user)
            }

        }
    }



    private fun checker(ten: String, tuoi: String):Boolean {

        //TextUtils.isEmpty(ten) tra ve true ve chuoi rong ,tra ve false neu chuoi co ky tu
       return (TextUtils.isEmpty(ten) || TextUtils.isEmpty(tuoi))

    }
}