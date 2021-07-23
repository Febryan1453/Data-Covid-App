package com.febryan.datacovid_19.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.febryan.datacovid_19.R
import com.febryan.datacovid_19.api.ApiConfig
import com.febryan.datacovid_19.model.ResponseIndonesia
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        getDataCovid()

        return view
    }



    fun getDataCovid(){
        ApiConfig.instance.getDataCovidIndonesia().enqueue(object :
            Callback<ArrayList<ResponseIndonesia>> {
            override fun onResponse(
                call: Call<ArrayList<ResponseIndonesia>>,
                response: Response<ArrayList<ResponseIndonesia>>
            ) {

                val indonesia = response.body()?.get(0)
                val positif = indonesia?.positif

                tv_positif.text = positif
                tv_sembuh.text = indonesia?.sembuh
                tv_meninggal.text = indonesia?.meninggal
                tv_rawat.text = indonesia?.dirawat
            }

            override fun onFailure(call: Call<ArrayList<ResponseIndonesia>>, t: Throwable) {
                Toast.makeText(activity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

}