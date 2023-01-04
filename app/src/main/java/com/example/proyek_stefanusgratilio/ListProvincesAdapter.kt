package com.example.proyek_stefanusgratilio

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.proyek_stefanusgratilio.databinding.ItemRowProvinceBinding

class ListProvincesAdapter(private val list : ArrayList<Provinces>) :
    RecyclerView.Adapter<ListProvincesAdapter.ListViewHolder>() {
    inner class ListViewHolder (private val binding : ItemRowProvinceBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(provinces: Provinces) {
            with(binding) {
                tvProvinceName.text = provinces.name
                tvProvinceAbstract.text = provinces.abstract
                Glide.with(itemView.context)
                    .load(provinces.logo)
                    .apply(RequestOptions().override(175,175))
                    .into(ivProvince)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DETAIL, provinces)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowProvinceBinding.inflate((LayoutInflater.from(parent.context)),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]

        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}