package com.example.pesonadelta1.ui.kuliner

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pesonadelta1.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.kuliner_content_detail.*
import kotlinx.android.synthetic.main.user_registration.*
import kotlinx.android.synthetic.main.wisata_content_detail.*
import kotlinx.android.synthetic.main.wisata_content_detail.buttonCall
import kotlinx.android.synthetic.main.wisata_content_detail.buttonMap
import kotlinx.android.synthetic.main.wisata_content_detail.buttonWeb

class KulinerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kuliner_activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        var intentThatStartedThisActivity = intent
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_COMPONENT_NAME)) {
            putData(intentThatStartedThisActivity)
        }

    }

    private fun putData(intentThatStartedThisActivity : Intent) {
        var photo = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_SPLIT_NAME).toInt()
        var nama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
        var harga = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME)
        var deskripsi= intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EXCLUDE_COMPONENTS)
        var narahubung = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_PACKAGE_NAME)
        var website = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER_NAME)
        var mapLat = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER)
        var mapLong = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_BCC)
        KulinerPhotoDetail.setImageResource(photo)
        KulinerNamaDetail.text = nama
        KulinerHargaDetail.text = harga
        KulinerDeskripsiDetail.text = deskripsi


        buttonMap.setOnClickListener {
            openMap(mapLat, mapLong, nama)
        }

        buttonCall.setOnClickListener {
            call(narahubung)
        }

        buttonWeb.setOnClickListener {
            openWeb(website)
        }
    }

    private fun openMap(latitude: String, longitude: String, KulinerNama: String) {
        val showMapActivity = Intent(this, KulinerMaps::class.java)
        showMapActivity.putExtra(Intent.ACTION_ASSIST, latitude)
        showMapActivity.putExtra(Intent.ACTION_PICK, longitude)
        showMapActivity.putExtra(Intent.ACTION_APPLICATION_PREFERENCES, KulinerNama)

        startActivity(showMapActivity)
    }

    private fun openWeb(url: String) {
        val showWebActivity = Intent(this, KulinerWebsite::class.java)
        showWebActivity.putExtra(Intent.ACTION_WEB_SEARCH, url)
        startActivity(showWebActivity)
    }

    private fun call (number: String) {
        val callThis = Intent(Intent.ACTION_DIAL)
        callThis.setData(Uri.parse("tel:"+ number))
        startActivity(callThis)
    }


}