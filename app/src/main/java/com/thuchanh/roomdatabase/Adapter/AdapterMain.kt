package com.thuchanh.roomdatabase.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thuchanh.roomdatabase.R
import com.thuchanh.roomdatabase.data.User

class AdapterMain: RecyclerView.Adapter<AdapterMain.AdapterHolder>() {
    var list  = emptyList<User>()

    fun set(list : List<User>)
    {
        this.list = list
        notifyDataSetChanged()
    }

    class AdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        lateinit var ten : TextView
        lateinit var tuoi:TextView

        init {

            ten = itemView.findViewById(R.id.ten)
            tuoi = itemView.findViewById(R.id.tuoi)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        var view :View = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return AdapterHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        val user = list.get(position)
        if (list == null)
        {
            return
        }

        holder.ten.text = user.Ten
        holder.tuoi.text = user.Tuoi.toString()
    }

    override fun getItemCount(): Int {
        if (list != null)
        {
            return list.size
        }
        return 0

    }

}