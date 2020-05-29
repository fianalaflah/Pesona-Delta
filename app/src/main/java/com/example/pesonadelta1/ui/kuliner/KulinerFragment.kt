package com.example.pesonadelta1.ui.kuliner

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

class KulinerFragment : Fragment() {

    private lateinit var KulinerViewModel: KulinerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.kuliner_fragment, container, false)
        val testData = createWisataData()
        root.findViewById<RecyclerView>(R.id.KulinerRV).layoutManager = LinearLayoutManager(context)
        root.findViewById<RecyclerView>(R.id.KulinerRV).setHasFixedSize(true)
        root.findViewById<RecyclerView>(R.id.KulinerRV).adapter = KulinerAdapter(testData, { KulinerItem: KulinerData ->KulinerItemClicked(KulinerItem)})
        return root
    }

    private fun KulinerItemClicked(KulinerData: KulinerData) {
        val showDetailActivity = Intent(context, KulinerDetailActivity::class.java)
        showDetailActivity.putExtra(Intent.EXTRA_SPLIT_NAME, KulinerData.KulinerPhoto.toString())
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, KulinerData.KulinerNama.toString())
        showDetailActivity.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, KulinerData.KulinerHarga.toString())
        showDetailActivity.putExtra(Intent.EXTRA_EXCLUDE_COMPONENTS, KulinerData.KulinerDeskripsi.toString())
        showDetailActivity.putExtra(Intent.EXTRA_PACKAGE_NAME, KulinerData.KulinerWebsite.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, KulinerData.KulinerMapLat.toString())
        showDetailActivity.putExtra(Intent.EXTRA_BCC, KulinerData.KulinerMapLong.toString())
        startActivity(showDetailActivity)
    }

    private fun createWisataData() : List<KulinerData> {
        val partList = ArrayList<KulinerData>()
        partList.add(KulinerData(R.drawable.kkupang,
            "Lontong Kupang",
            "Rp.10.000 sampai Rp.15.000/Porsi",
            "Lontong kupang adalah makanan khas Sidoarjo, Jawa Timur. Sepiring lontong kupang terdiri dari lontong, kuah petis, kupang, lentho, dan sate kerang. Rasanya gurih menggugah selera.Olahan ini menghasilkan sajian bercita rasa khas. Rasa gurih dari kuah, dan petis yang beraroma membuat udang kaya rasa.Selain itu teksturnya juga beragam. Lontong yang padat berpadu dengan kupang yang kenyal, dan lentho yang renyah.",
            "085330534899",
            "https://cookpad.com/id/resep/9172676-kupang-lontong-sidoarjo?via=search&search_term=lontong%20kupang%20sidoarjo/",
            "-7.401722",
            "112.726917"))
        partList.add(KulinerData(R.drawable.klumpur,
            "Kue Lumpur",
            "Rp.3.500/Potong",
            "Sidoarjo tak hanya terkenal akan lumpur lapindonya. Kota yang berbatasan dengan Surabaya ini juga populer dengan kuliner khasnya kue lumpur. Soal rasa, tentu saja berbeda dengan yang lain. Varian rasa yang banyak sehingga beragam rasa yang dimiliki",
            "081330172133",
            "https://cookpad.com/id/cari/kue%20lumpur%20sidoarjo",
            "-7.461500",
            "112.722639"))
        partList.add(KulinerData(R.drawable.kbandeng,
            "Bandeng Presto",
            "Rp.20.000 sampai Rp40.000/Ekor",
            "Siapa yang tidak mengenal bandeng? ikan air tawar yang memiliki banyak khasiat.Ikon tersebut bahkan tersemat dalam lambang Kota Delta. Terkenalnya bandeng sebagai oleh-oleh khas Sidoarjo tentunya dimanfaatkan oleh banyak penduduk lokal. Salah satunya makanan yang lezat dan cocok menjadi oleh-oleh khas Sidoarjo yakni bandeng presto",
            "081331334645",
            "https://cookpad.com/id/resep/8518020-bandeng-presto",
            "-7.465318",
            "112.706701"))
        partList.add(KulinerData(R.drawable.krawon,
            "Rawon Gajah Mada",
            "Rp.12.000/Porsi",
            "Menikmati kuliner di malam hari memang lebih menyenangkan dibandingkan kuliner disiang hari guys, karena cuaca siang hari yang sangat panas, itu yang bikin saya kurang suka kulineran di siang hari, apalagi di Kota Surabaya/Sidoarjo. Nah kalo malam gini dingin, cocok banget untuk menyantap menu makanan yang satu ini, yaitu Rawon Gajah Mada",
            "085748611163",
            "https://www.masakapahariini.com/resep/resep-rawon-daging/",
            "-7.457611",
            "112.717667"))
        partList.add(KulinerData(R.drawable.kceker,
            "Ceker Lapindo",
            "Rp.10.000 sampai Rp13.000/porsi",
            "Ada yang jadi pecinta ceker pedas disini? Kebetulan banget, bagi kalian pecinta ceker pedas kalian wajib cobain lezatnya Ceker Lapindo yang ada di Kabupaten Sidoarjo ini. Ada yang jadi pecinta ceker pedas disini? Kebetulan banget, bagi kalian pecinta ceker pedas kalian wajib cibain lezatnya Ceker Lapindo yang ada di Kabupaten Sidoarjo ini",
            "081330154235",
            "https://cookpad.com/id/resep/1977258-ceker-lapindo-khas-sidoarjodower%F0%9F%98%A8/",
            "-7.446859",
            "112.715493"))
        partList.add(KulinerData(R.drawable.kklepon,
            "Klepon Bulang",
            "Rp. 5.000/Box",
            "Salah satu Kuliner yang lezat dan nikmat khas Sidoarjo asal Kecamatan Prambon yakni klepon. kue tradisional yang dibuat dari tepung ketan yang berwarna hijau dan di dalamnya ada gula merah cair, sehingga jika digigit akan terasa letupan manisnya. Selain itu juga ditaburi dengan kelapa yang sudah diparut sehingga menambah kenikmatan kue klepon ini. Karena menggunakan bahan alami termasuk warna hijau yang dibuat dari air daun suji, maka klepon ini hanya bisa tahan satu hari.",
            "082298883921",
            "https://cookpad.com/id/resep/1143665-klepon-ketan-gula-merah-kenyal-no-kapur-sirih/",
            "-7.490222",
            "112.602444"))


        return partList
    }
}


