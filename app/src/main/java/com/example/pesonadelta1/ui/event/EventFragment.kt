package com.example.pesonadelta1.ui.event

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pesonadelta1.R

class EventFragment : Fragment() {

    private lateinit var EventViewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.event_fragment, container, false)
        val testData = createEventData()
        root.findViewById<RecyclerView>(R.id.eventRV).layoutManager = LinearLayoutManager(context)
        root.findViewById<RecyclerView>(R.id.eventRV).setHasFixedSize(true)
        root.findViewById<RecyclerView>(R.id.eventRV).adapter = EventAdapter(testData, { EventItem: EventData ->EventItemClicked(EventItem)})
        return root
    }

    private fun EventItemClicked(EventData: EventData) {
        val showDetailActivity = Intent(context, EventDetailActivity::class.java)
        showDetailActivity.putExtra(Intent.EXTRA_SPLIT_NAME, EventData.EventPhoto.toString())
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, EventData.EventNama.toString())
        showDetailActivity.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, EventData.EventTanggal.toString())
        showDetailActivity.putExtra(Intent.EXTRA_PACKAGE_NAME, EventData.EventNarahubung.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER_NAME, EventData.EventWebsite.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, EventData.EventMapLat.toString())
        showDetailActivity.putExtra(Intent.EXTRA_BCC, EventData.EventMapLong.toString())
        startActivity(showDetailActivity)
    }

    private fun createEventData() : List<EventData> {
        val partList = ArrayList<EventData>()
        partList.add(EventData(R.drawable.edeltacarnival,
            "Delta Carnival",
            "Dilaksanakan Pada 21 Agustus 2020",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.446071",
            "112.717733"))
        partList.add(EventData(R.drawable.egukyuk,
            "Pemilihan Guk&Yuk Sidoarjo 2020",
            "Dilaksanakan Pada 18 Oktober 2019",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.446071",
            "112.717733"))
        partList.add(EventData(R.drawable.erenang,
            "Kejuaraan Nasional Renang (Jatim Open)",
            "Dilaksanakan Pada 25-27 Oktober 2019",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447516",
            "112.705335"))
        partList.add(EventData(R.drawable.epekanolahraga,
            "Pekan Olahraga Pelajar Sidoarjo",
            "Dilaksanakan Pada 06-10 November 2019",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447516",
            "112.705335"))
        partList.add(EventData(R.drawable.elusi,
            "Lusi 10K",
            " Dilaksanakan Pada1 Desember 2019",
            "087722649593",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.518403",
            "112.71402"))
        partList.add(EventData(R.drawable.esiriv,
            "Delta Creative Fest 2019",
            "27-30 November 2019",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447516",
            "112.705335"))
        partList.add(EventData(R.drawable.ejamborepemuda,
            "Jambore Pemuda Sidoarjo",
            "Dilaksanakan Pada 2-4 November 2019",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447516",
            "112.705335"))
        partList.add(EventData(R.drawable.etravelfair,
            "Sidoarjo Travel Fair",
            "Dilaksanakan Pada 25-26 November 2019",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447516",
            "112.705335"))
        partList.add(EventData(R.drawable.egowesnusantara,
            "Gowes Nusantara 2019",
            "27 Oktober 2019",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447516",
            "112.705335"))

        return partList
    }
}


