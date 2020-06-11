package com.example.pesonadelta1.ui.info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pesonadelta1.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class InfoMaps : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    var lat: Double = 0.0
    var long: Double = 0.0
    var name: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_activity_maps)
        var intentThatStartedThisActivity = intent
        val latitude = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_ASSIST).toDouble()
        this.lat = latitude
        val longitude = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_PICK).toDouble()
        this.long = longitude
        val nameLocal = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_APPLICATION_PREFERENCES).toString()
        this.name = nameLocal
        if (intentThatStartedThisActivity.hasExtra(Intent.ACTION_ASSIST)) { Toast.makeText(
                this@InfoMaps,
                "lat : " + this.lat + ", long : " + this.long,
                Toast.LENGTH_LONG).show()
        } else { }
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this) }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val loc = LatLng(-34.0, 151.0)
        val newLoc = LatLng(this.lat, this.long)
        mMap.addMarker(MarkerOptions().position(newLoc).title(this.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newLoc))
        val zoomLevel: Float = 15.0f
        mMap.animateCamera(CameraUpdateFactory.zoomTo(zoomLevel), 2000, null)
    }
}
