package com.febryan.datacovid_19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.febryan.datacovid_19.R
import com.febryan.datacovid_19.model.Attributes
import com.febryan.datacovid_19.model.ResponseProvinsi
import kotlinx.android.synthetic.main.list_item_provinsi.*
import kotlinx.android.synthetic.main.list_item_provinsi.view.*

class ProvinsiAdapter (private val daftarProv: ArrayList<ResponseProvinsi>) : RecyclerView.Adapter<ProvinsiAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun ikat(attributes: ResponseProvinsi){
            with(itemView){
                tvName.text = attributes.attributes.provinsi
                tvPositive.text = attributes.attributes.kasusPosi.toString()
                tvRecover.text = attributes.attributes.kasusSemb.toString()
                tvDeath.text = attributes.attributes.kasusMeni.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_provinsi, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ikat(daftarProv[position])
    }

    override fun getItemCount(): Int {
        return daftarProv.size
    }


}