package com.example.pesonadelta1.ui.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pesonadelta1.R
import kotlinx.android.synthetic.main.event_list_item.view.*
import kotlinx.android.synthetic.main.wisata_list_item.view.*

class EventAdapter (val eventItemList: List<EventData>, val clickListener: (EventData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.event_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(eventItemList[position], clickListener)
    }

    override fun getItemCount() = eventItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: EventData, clickListener: (EventData) -> Unit) {
            itemView.EventNama.text = event.EventNama.toString()
            itemView.EventPhoto.setImageResource(event.EventPhoto)
            itemView.setOnClickListener { clickListener(event) }
        }
    }
}
