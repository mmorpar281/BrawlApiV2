package com.example.brawlapi.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.brawlapi.Brawler
import com.example.brawlapi.databinding.ItemBrawlersBinding

class ViewHolder(view : View): RecyclerView.ViewHolder(view) {
    val binding = ItemBrawlersBinding.bind(view)

    fun render(brawlerModel: Brawler, onClickListener: (Brawler)-> Unit){
        binding.tvBrawlerName.text = brawlerModel.nombre
        binding.tvBrawlerDescripcion.text = brawlerModel.descripcion
        binding.tvBrawlerRareza.text = brawlerModel.rareza
        Glide.with(binding.ivBrawler.context).load(brawlerModel.imagen).into(binding.ivBrawler)
        itemView.setOnClickListener {
            onClickListener(brawlerModel)
        }
    }
}