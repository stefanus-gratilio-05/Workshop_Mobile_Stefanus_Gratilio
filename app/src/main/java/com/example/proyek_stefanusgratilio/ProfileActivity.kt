package com.example.proyek_stefanusgratilio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var toolbar: Toolbar
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        toolbar=findViewById(R.id.toolbar)
        toolbar.title = "My Profile"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}