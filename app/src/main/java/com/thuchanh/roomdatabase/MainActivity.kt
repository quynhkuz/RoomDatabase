package com.thuchanh.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thuchanh.roomdatabase.Adapter.AdapterMain
import com.thuchanh.roomdatabase.ViewModel.UserViewModel
import com.thuchanh.roomdatabase.data.User
import com.thuchanh.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var adapter:AdapterMain

    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.floating.setOnClickListener {
            var inten = Intent(this,AddUserActivity::class.java)
            startActivity(inten)
        }

        var viewmodel : UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        adapter = AdapterMain()
        var layoutManager  = LinearLayoutManager(this)
        binding.recyc.layoutManager = layoutManager
        binding.recyc.adapter = adapter

        viewmodel.getall?.observe(this)
        {
            Log.d("AAA","back()")
            adapter.set(it)
        }
        Log.d("AAA","onCreate()")
    }


    override fun onStop() {
        super.onStop()
        Log.d("AAA","onStop()")
    }

    override fun onStart() {
        super.onStart()
        Log.d("AAA","onStart()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("AAA","onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("AAA","onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("AAA","onRestart()")
    }
}


