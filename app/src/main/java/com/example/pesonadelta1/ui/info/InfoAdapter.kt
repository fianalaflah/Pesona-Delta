package com.example.pesonadelta1.ui.info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pesonadelta1.R
import kotlinx.android.synthetic.main.info_list_item.view.*

class InfoAdapter (val infoItemList: List<InfoData>, val clickListener: (InfoData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.info_list_item, parent, false)
            return PartViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as PartViewHolder).bind(infoItemList[position], clickListener)
        }

        override fun getItemCount() = infoItemList.size

        class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(info:InfoData, clickListener: (InfoData) -> Unit) {
                itemView.infoNama.text = info.InfoNama.toString()
                itemView.infoPhoto.setImageResource(info.InfoPhoto)
                itemView.setOnClickListener { clickListener(info) }
            }
        }
    }