package com.example.brawlapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brawlapi.Brawler
import com.example.brawlapi.R

class BrawlerAdapter(
    private val brawlerLista: List<Brawler>,
    private val onClickListener: (Brawler) -> Unit
) : RecyclerView.Adapter<ViewHolder>() { // 🔹 Usa tu propio ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_brawlers, parent, false)
        return ViewHolder(view) // 🔹 Ahora devuelve tu ViewHolder
    }

    override fun getItemCount(): Int = brawlerLista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBrawler = brawlerLista[position]
        holder.render(itemBrawler, onClickListener) // 🔹 Llama a `render()` correctamente
    }
}
