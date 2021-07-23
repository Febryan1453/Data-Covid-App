package com.febryan.datacovid_19.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.febryan.datacovid_19.R
import com.febryan.datacovid_19.adapter.ProvinsiAdapter
import com.febryan.datacovid_19.api.ApiConfig
import com.febryan.datacovid_19.model.ResponseProvinsi
import kotlinx.android.synthetic.main.fragment_provinsi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinsiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_provinsi, container, false)

        getProvinsi()

        return view
    }

    private fun getProvinsi() {


        ApiConfig.instance.getDataProvinsi().enqueue(object : Callback<ArrayList<ResponseProvinsi>>{
            override fun onResponse(call: Call<ArrayList<ResponseProvinsi>>, response: Response<ArrayList<ResponseProvinsi>>) {
                if (response.isSuccessful){

                    val daftarProv = response.body()
                    val provAdapter = daftarProv?.let { ProvinsiAdapter(it) }

                    rvProvince.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
//                        (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
                        provAdapter?.notifyDataSetChanged()
                        adapter = provAdapter
                    }

                }
            }

            override fun onFailure(call: Call<ArrayList<ResponseProvinsi>>, t: Throwable) {
                Toast.makeText(activity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

}

