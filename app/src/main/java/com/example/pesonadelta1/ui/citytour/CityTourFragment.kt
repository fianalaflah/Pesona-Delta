package com.example.pesonadelta1.ui.citytour

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pesonadelta1.R

class CityTourFragment : Fragment() {

    private lateinit var CityTourDataViewModel: CityTourViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.citytour_fragment, container, false)
        val testData = createWisataData()
        root.findViewById<RecyclerView>(R.id.CTRV).layoutManager = LinearLayoutManager(context)
        root.findViewById<RecyclerView>(R.id.CTRV).setHasFixedSize(true)
        root.findViewById<RecyclerView>(R.id.CTRV).adapter = CityTourAdapter(testData, {  CityTourItem: CityTourData -> citytourItemClicked(CityTourItem)})
        return root
    }

    private fun citytourItemClicked(CityTourData: CityTourData) {
        val showDetailActivity = Intent(context, CityTourDetailActivity::class.java)
        showDetailActivity.putExtra(Intent.EXTRA_SPLIT_NAME, CityTourData.CityTourPhoto.toString())
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, CityTourData.CityTourNama.toString())
        showDetailActivity.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, CityTourData.CityTourRute.toString())
        showDetailActivity.putExtra(Intent.EXTRA_EXCLUDE_COMPONENTS, CityTourData.CityTourDeskripsi.toString())
        showDetailActivity.putExtra(Intent.EXTRA_PACKAGE_NAME, CityTourData.CityTourNarahubung.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER_NAME, CityTourData.CityTourWebsite.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, CityTourData.CityTourMapLat.toString())
        showDetailActivity.putExtra(Intent.EXTRA_BCC, CityTourData.CityTourMapLong.toString())
        startActivity(showDetailActivity)
    }


    private fun createWisataData() : List<CityTourData> {
        val partList = ArrayList<CityTourData>()
        partList.add(CityTourData(R.drawable.cta,
            "Senin Jelajah Darjo",
            " Rute:Alun-Alun Sidoarjo, Mpu Tantular, Candi Pari, Lusi",
            "Bagi Wisatawan yang akan mengikuti City Tour Jelajah Darjo. Harap mendaftar terlebih dahulu agar dapat disesuaikan dengan jadwal dan wisatawan yang bergabung pada Jelajah Darjo kali ini.\n" +
                    "\n" +
                    "Berikut merupakan hal yang harus diperhatikan bagi Wisatawan yang mengikuti rangkaian City Tour Jelajah Darjo. Harap wisatawan datang tepat waktu pada jadwal yang telah ditentukan. yakni:\n" +
                    "Pukul : 08.00 WIB\n" +
                    "Tempat: DISPORAPAR Sidoarjo \n" +
                    "Biaya: tiket masuk wisata\n" +
                    "\n" +
                    "Terimakasih sudah mengikuti City Tour Jelajah Darjo. Semoga mendapatkan pengalaman menyenangkan dan mengesankan.\n" +
                    "Tresno Darjo!\n" +
                    "Bumi Jenggolo, Rahayu.",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447329",
            "112.716146"
        ))
        partList.add(CityTourData(R.drawable.ctb,
            " Rabu Jelajah Darjo",
            "Rute:Alun-Alun Sidoarjo, Taman Abhirama, Intako",
            "Bagi Wisatawan yang akan mengikuti City Tour Jelajah Darjo. Harap mendaftar terlebih dahulu agar dapat disesuaikan dengan jadwal dan wisatawan yang bergabung pada Jelajah Darjo kali ini. \n" +
                    "\n" +
                    "Berikut merupakan hal yang harus diperhatikan bagi Wisatawan yang mengikuti rangkaian City Tour Jelajah Darjo. Harap wisatawan datang tepat waktu pada jadwal yang telah ditentukan. yakni:\n" +
                    "Pukul : 08.00 WIB \n" +
                    "Tempat: DISPORAPAR Sidoarjo \n" +
                    "Biaya: biaya tiket masuk wisata\n" +
                    "\n" +
                    "Terimakasih sudah mengikuti City Tour Jelajah Darjo. Semoga mendapatkan pengalaman menyenangkan dan mengesankan. \n" +
                    "Tresno Darjo!\n" +
                    "Bumi Jenggolo, Rahayu.",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447329",
            "112.716146" ))
        partList.add(CityTourData(R.drawable.ctc,
            " Sabtu Jelajah Darjo ",
            "Rute:Alun-Alun Sidoarjo, Bursa Lontong Kupang, Candi Sumur, Lusi",
            "Bagi Wisatawan yang akan mengikuti City Tour Jelajah Darjo. Harap mendaftar terlebih dahulu agar dapat disesuaikan dengan jadwal dan wisatawan yang bergabung pada Jelajah Darjo kali ini. \n" +
                    "\n" +
                    "Berikut merupakan hal yang harus diperhatikan bagi Wisatawan yang mengikuti rangkaian City Tour Jelajah Darjo. Harap wisatawan datang tepat waktu pada jadwal yang telah ditentukan. yakni :\n" +
                    "Pukul : 08.00 WIB\n" +
                    "Tempat: DISPORAPAR Sidoarjo \n" +
                    "Biaya: biaya tiket masuk wisata\n" +
                    "\n" +
                    "Terimakasih sudah mengikuti City Tour Jelajah Darjo. Semoga mendapatkan pengalaman menyenangkan dan mengesankan.\n" +
                    "Tresno Darjo!\n" +
                    "Bumi Jenggolo, Rahayu.",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447329",
            "112.716146"))
        partList.add(CityTourData(R.drawable.ctd,
            "Minggu Jelajah Darjo",
            "Rute:Alun-Alun Sidoarjo, Mpu Tantular, Klepon Bulang, Alas Prambon",
            "Bagi Wisatawan yang akan mengikuti City Tour Jelajah Darjo. Harap mendaftar terlebih dahulu agar dapat disesuaikan dengan jadwal dan wisatawan yang bergabung pada Jelajah Darjo kali ini.\n" +
                    "\n" +
                    "Berikut merupakan hal yang harus diperhatikan bagi Wisatawan yang mengikuti rangkaian City Tour Jelajah Darjo. Harap wisatawan datang tepat waktu pada jadwal yang telah ditentukan. yakni:\n" +
                    "Pukul : 08.00 WIB \n" +
                    "Tempat: DISPORAPAR Sidoarjo \n" +
                    "Biaya: tiket masuk wisata\n" +
                    "\n" +
                    "Terimakasih sudah mengikuti City Tour Jelajah Darjo. Semoga mendapatkan pengalaman menyenangkan dan mengesankan.\n" +
                    "Tresno Darjo!\n" +
                    "Bumi Jenggolo, Rahayu.",
            "0318941104",
            "http://disporapar.sidoarjokab.go.id/",
            "-7.447329",
            "112.716146"))

        return partList
    }
}

