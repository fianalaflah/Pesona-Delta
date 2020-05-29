package com.example.pesonadelta1.ui.kuliner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pesonadelta1.R
import kotlinx.android.synthetic.main.kuliner_list_item.view.*

class KulinerAdapter (val kulinerItemList: List<KulinerData>, val clickListener: (KulinerData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kuliner_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(kulinerItemList[position], clickListener)
    }

    override fun getItemCount() = kulinerItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(kuliner: KulinerData, clickListener: (KulinerData) -> Unit) {
            itemView.kulinerNama.text = kuliner.KulinerNama.toString()
            itemView.kulinerPhoto.setImageResource(kuliner.KulinerPhoto)
            itemView.setOnClickListener { clickListener(kuliner) }
        }
    }
}
