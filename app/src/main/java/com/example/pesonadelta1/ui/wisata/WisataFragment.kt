package com.example.pesonadelta1.ui.wisata

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pesonadelta1.R

class WisataFragment : Fragment() {

    private lateinit var WisataViewModel: WisataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.wisata_fragment, container, false)
        val testData = createWisataData()
        root.findViewById<RecyclerView>(R.id.wisataRV).layoutManager = LinearLayoutManager(context)
        root.findViewById<RecyclerView>(R.id.wisataRV).setHasFixedSize(true)
        root.findViewById<RecyclerView>(R.id.wisataRV).adapter = WisataAdapter(testData, { WisataItem: WisataData -> wisataItemClicked(WisataItem)})
        return root
    }

    private fun wisataItemClicked(WisataData: WisataData) {
        val showDetailActivity = Intent(context, WisataDetailActivity::class.java)
        showDetailActivity.putExtra(Intent.EXTRA_SPLIT_NAME, WisataData.WisataPhoto.toString())
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, WisataData.WisataNama.toString())
        showDetailActivity.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, WisataData.WisataDeskripsi.toString())
        showDetailActivity.putExtra(Intent.EXTRA_PACKAGE_NAME, WisataData.WisataNarahubung.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER_NAME, WisataData.WisataWebsite.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, WisataData.WisataMapLat.toString())
        showDetailActivity.putExtra(Intent.EXTRA_BCC, WisataData.WisataMapLong.toString())
        startActivity(showDetailActivity)
    }

    private fun createWisataData() : List<WisataData> {
        val partList = ArrayList<WisataData>()
        partList.add(WisataData(R.drawable.wlusi,
            "Lumpur Sidoarjo",
            "kini kawasan ini telah dijadikan tempat wisata yang sampai saat ini sudah sangat populer. Terdapat destinasi wisata yang menarik dan unik di sini, yaitu wisata patung lumpur. Di sini kamu bisa menjumpai banyak patung-patung unik yang dibentuk layaknya orang tenggelam dalam genangan lumpur.",
            "0318941104",
            "https://travel.detik.com/dtravelers_stories/u-4616406/melihat-wisata-lumpur-lapindo/",
            "-7.518403",
            " 112.714028"))
        partList.add(WisataData(R.drawable.wpari,
            "Candi Pari",
            "Candi peninggalan kerajaan Majapahit, tepatnya dari masa pemerintahan Raja Hayam Wuruk yang hingga kini masih berdiri dengan kokoh. Candi Pari ini berbeda dengan candi-candi peninggalan Majapahit lainnya. Pasalnya candi ini perpaduan antara pola Candi Khamer (Birma) dengan Candi Champa (Thailand).Di sini kamu bisa menikmati nuansa religi penganut agama Hindu sambil menikmati suasana candi yang memesona",
            "0318941104",
            "https://travelingyuk.com/candi-pari/25232/",
            "-7.516073",
            "112.68342"))
        partList.add(WisataData(R.drawable.wplaulusi,
            "Pulau Lusi",
            "Wisata Pulau Lusi (tadinya bernamakan Pulau Sarinah) terletak di tengah-tengah Sungai Porong perbatasan antara Pasuruan dan Sidoarjo yang berjarak sekitar 25 kilometer dari darat Tlocor, Desa Kedungpandan Jabon. Untuk sampai ke pulau ini pengunjung dapat menggunakan armada perahu mesin yang dikelola kelompok sadar wisata desa setempat. Mengutip kkp.go.id, pulau ini memiliki luas kurang lebih 93,4 hektar",
            "0318941104",
            "https://travelingyuk.com/pulau-lusi-sidoarjo/16916/",
            "-7.552833",
            " 112.845556"))
        partList.add(WisataData(R.drawable.wgor,
            "Gor Sidoarjo",
            "Stadion Gelora Delta adalah stadion multi-guna di Sidoarjo, Jawa Timur, Indonesia. Stadion ini lebih sering dipergunakan untuk menggelar pertandingan sepak bola. Stadion ini memiliki kapasitas untuk 35.000 orang. Stadion kebanggaan rakyat Sidoarjo ini adalah kandang dari klub sepak bola terkenal dari Sidoarjo bernama Deltras FC",
            "0318941104",
            "https://radarsurabaya.jawapos.com/read/2020/02/10/178697/pssi-melakukan-peninjauan-kesiapan-gor-delta-dan-jenggolo/",
            "-7.447516",
            " 112.705335"))
        partList.add(WisataData(R.drawable.wintako,
            "Industri Tas dan Koper (INTAKO)",
            "salah satu wisata perbelanjaan yang bisa anda temukan di Jl. Kludan Raya Tanggulangin, Kecamatan Tanggulangin, Kabupaten Sidoarjo, Jawa Timur. Anda bisa langsung datang ke Kawasan INTAKO, di mana anda bisa menemukan berbagai jenis macam tas atau dompet dari berbagai bahan. Kreasi dan juga kreativitas dari para perajin tas asal Desa Tanggulangin, Kabupaten Sidoarjo.",
            "0318941104",
            "https://www.tempatwisata.pro/wisata/Kawasan-Intako/",
            "-7.50532",
            " 112.69424"))
        partList.add(WisataData(R.drawable.wsumur,
            "Candi Sumur",
            "Candi Sumur diperkirakan dibangun secara bersamaan dengan Candi Pari pada masa Majapahit. Candi ini diperkirakan dibangun pada abad ke XIV dan berlatar belakang Hindu. Candi Sumur dan Candi Pari ditemukan pada 16 Oktober 1906. Ukuran Candi Sumur ini kira-kira hanya setengah dari Candi Pari",
            "0318941104",
            "https://disidoarjo.com/147/sejarah-candi-sumur-di-sidoarjo/",
            "-7.517088",
            "112.682962"))
        partList.add(WisataData(R.drawable.wsuncity,
            "Sun City Water Park",
            "Menikmati suasana libur akhir pekan di Waterpark Kolam Renang Sun City Sidoarjo akan terasa sangat menyenangkan jika bersama dengan keluarga dan sahabat. Nah, kalian juga bisa membuktikan sensasi tersebut di Waterpark Sun City Sidoarjo. Tempat wisata yang layak dan asyik untuk dikunjungi lo. Ada tempat wisata outbond, ada pula tempat wisata air atau waterpark.",
            "0318941104",
            "https://www.infowisataoutbound.com/sun-city-waterpark.html/",
            "-7.44941",
            " 112.712694"))
        partList.add(WisataData(R.drawable.wmuseum,
            "Museum Mpu Tantular",
            "Menikmati libur bersama keluarga tak harus melulu ditempat wisata yang itu-itu saja. Anda bisa mengajak buah hati berlibur sambil belajar sejarah di museum Mpu Tantular di Jalan Buduran atau tepatnya sebelah barat jembatan layang, Sidoarjo, Jawa Timur",
            "0318941104",
            "https://www.travelblog.id/museum-mpu-tantular-berwisata-dan-belajar-sejarah-di-sidoarjo/",
            "-7.434000",
            "112.719917"))
        partList.add(WisataData(R.drawable.wjayandaru,
            "Alun-Alun Sidoarjo",
            "Tempat wisata di Sidoarjo yang wajib kamu kunjungi selanjutnya adalah alun-alun. Tempat wisata di Sidoarjo ini sangat mudah untuk diakses karena terletak di jantung kota. Tempat ini menjadi menjadi pilihan utama masyarakat Sidoarjo untuk menghabiskan akhir pekan atau hari libur. Selain itu terdapat monumen Jayandaru juga di tengah Alun-Alun Sidoarjo sehingga menjadi icon.",
            "0318941104",
            "https://www.tripadvisor.co.id/Attraction_Review-g3175994-d11807546-Reviews-Jayandaru_Monument-Sidoarjo_East_Java_Java.html/",
            "-7.446071",
            "112.717733"))


        return partList
    }
}

