package com.example.flowerapp.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flowerapp.DetailActivity
import com.example.flowerapp.R
import com.example.flowerapp.domain.Flower
import com.example.flowerapp.databinding.AdapterFlowerBinding

class MainAdapter(var context: Context) : RecyclerView.Adapter<MainViewHolder>() {

    var flowers = mutableListOf<Flower>()

    @SuppressLint("NotifyDataSetChanged")
    fun setFlowerList(flowers: List<Flower>) {
        this.flowers = flowers.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterFlowerBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val flower = flowers[position]

        holder.binding.name.text = context.getString(R.string.flower_id,flower.id)
        holder.binding.status.text = context.getString(R.string.flower_status,flower.status)
        Glide.with(holder.itemView.context).load(flower.imageUrl).into(holder.binding.imageview)

        holder.itemView.setOnClickListener {

            val intent = Intent(context as AppCompatActivity, DetailActivity::class.java).apply {
                putExtra("flowerDeliver", flower.deliver_to)
                putExtra("flowerDesc", flower.desc)
                putExtra("flowerPrice", flower.price)
            }

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return flowers.size
    }
}

class MainViewHolder(val binding: AdapterFlowerBinding) : RecyclerView.ViewHolder(binding.root)