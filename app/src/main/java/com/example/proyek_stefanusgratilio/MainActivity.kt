package com.example.proyek_stefanusgratilio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.proyek_stefanusgratilio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding : ActivityMainBinding by viewBinding()
    private val list : ArrayList<Provinces> = arrayListOf()
    private lateinit var listProvincesAdapter: ListProvincesAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvProvinces.setHasFixedSize(true)
        list.addAll(ProvincesData.listData)
        showRecyclerViewList()

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Provinsi Indonesia"
        setSupportActionBar(toolbar)
    }

    private fun showRecyclerViewList() {
        binding.apply {
            rvProvinces.layoutManager = LinearLayoutManager(this@MainActivity)
            listProvincesAdapter = ListProvincesAdapter(list)
            rvProvinces.adapter = listProvincesAdapter
        }
    }

    override fun onCreateOptionsMenu(menu : Menu) : Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, ProfileActivity::class.java)
        this.startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

}