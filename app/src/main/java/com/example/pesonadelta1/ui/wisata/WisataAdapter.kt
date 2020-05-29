package com.example.pesonadelta1.ui.wisata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pesonadelta1.R
import kotlinx.android.synthetic.main.wisata_list_item.view.*

class WisataAdapter (val wisataItemList: List<WisataData>, val clickListener: (WisataData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.wisata_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(wisataItemList[position], clickListener)
    }

    override fun getItemCount() = wisataItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(wisata: WisataData, clickListener: (WisataData) -> Unit) {
            itemView.wisataNama.text = wisata.WisataNama.toString()
            itemView.wisataPhoto.setImageResource(wisata.WisataPhoto)
            itemView.setOnClickListener { clickListener(wisata) }
        }
    }
}
