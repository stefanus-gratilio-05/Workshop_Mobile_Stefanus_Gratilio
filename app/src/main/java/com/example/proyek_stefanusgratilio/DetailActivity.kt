package com.example.proyek_stefanusgratilio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.proyek_stefanusgratilio.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
    private val binding : ActivityDetailBinding by viewBinding()
    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        toolbar=findViewById(R.id.toolbar)
        toolbar.title = "More about"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setdata()
    }

    private fun setdata() {
        binding.apply {
            val provinces = intent.getParcelableExtra<Provinces>(EXTRA_DETAIL)

            tvProvinceName.text = provinces?.name
            tvProvinceCapital.text = provinces?.capital
            tvProvinceGovernor.text = provinces?.governor
            tvProvincePopulation.text = provinces?.population
            tvProvinceArea.text = provinces?.area
            tvProvinceAbstract.text = provinces?.abstract

            Glide.with(this@DetailActivity)
                .load(provinces?.logo)
                .apply(RequestOptions())
                .into(ivProvince)
        }
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }
}