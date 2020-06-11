package com.example.pesonadelta1.ui.citytour

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pesonadelta1.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.citytour_content_detail.*
import kotlinx.android.synthetic.main.wisata_content_detail.*
import kotlinx.android.synthetic.main.wisata_content_detail.buttonCall
import kotlinx.android.synthetic.main.wisata_content_detail.buttonMap
import kotlinx.android.synthetic.main.wisata_content_detail.buttonWeb

class CityTourDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.citytour_activity_detail)
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
        var rute = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME)
        var deskripsi= intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EXCLUDE_COMPONENTS)
        var narahubung = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_PACKAGE_NAME)
        var website = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER_NAME)
        var mapLat = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER)
        var mapLong = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_BCC)
        CityTourPhotoDetail.setImageResource(photo)
        CityTourNamaDetail.text = nama
        CityTourRuteDetail.text = rute
        CityTourDeskripsiDetail.text = deskripsi

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

    private fun openMap(latitude: String, longitude: String, citytourNama: String) {
        val showMapActivity = Intent(this, CityTourMaps::class.java)
        showMapActivity.putExtra(Intent.ACTION_ASSIST, latitude)
        showMapActivity.putExtra(Intent.ACTION_PICK, longitude)
        showMapActivity.putExtra(Intent.ACTION_APPLICATION_PREFERENCES, citytourNama)

        startActivity(showMapActivity)
    }

    private fun openWeb(url: String) {
        val showWebActivity = Intent(this, CityTourWebsite::class.java)
        showWebActivity.putExtra(Intent.ACTION_WEB_SEARCH, url)
        startActivity(showWebActivity)
    }

    private fun call (number: String) {
        val callThis = Intent(Intent.ACTION_DIAL)
        callThis.setData(Uri.parse("tel:"+ number))
        startActivity(callThis)
    }


}