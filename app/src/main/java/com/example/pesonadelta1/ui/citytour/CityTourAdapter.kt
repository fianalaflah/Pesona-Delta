package com.example.pesonadelta1.ui.citytour

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pesonadelta1.R
import kotlinx.android.synthetic.main.citytour_list_item.view.*
import kotlinx.android.synthetic.main.wisata_list_item.view.*

class CityTourAdapter (val citytourItemList: List<CityTourData>, val clickListener: (CityTourData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.citytour_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(citytourItemList[position], clickListener)
    }

    override fun getItemCount() = citytourItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(citytour: CityTourData, clickListener: (CityTourData) -> Unit) {
            itemView.citytourJadwal.text = citytour.CityTourNama.toString()
            itemView.citytourPhoto.setImageResource(citytour.CityTourPhoto)
            itemView.setOnClickListener { clickListener(citytour) }
        }
    }
}
