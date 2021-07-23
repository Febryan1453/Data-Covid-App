package com.febryan.datacovid_19.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.febryan.datacovid_19.R
import com.febryan.datacovid_19.fragment.HomeFragment
import com.febryan.datacovid_19.fragment.InfoAplikasiFragment
import com.febryan.datacovid_19.fragment.ProvinsiFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fragHome: Fragment = HomeFragment()
    val fragProvinsi: Fragment = ProvinsiFragment()
    val fragInfoApp: Fragment = InfoAplikasiFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragHome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
//        swipRefresh()
        setupBottomNavigations()

    }

//    private fun swipRefresh() {
//        sr_home.setColorSchemeResources(R.color.bg_papan,R.color.kuning);
//        sr_home.setOnRefreshListener {
////            Toast.makeText(this, "Rafresh !", Toast.LENGTH_SHORT).show()
////            sr_home.isRefreshing =  false
//            Handler().postDelayed(Runnable {
//                sr_home.isRefreshing =  false
//            }, 3000)
//        }
//    }

    private fun setupBottomNavigations() {

        fm.beginTransaction().add(R.id.nav_container, fragHome).show(fragHome).commit()
        fm.beginTransaction().add(R.id.nav_container, fragProvinsi).hide(fragProvinsi).commit()
        fm.beginTransaction().add(R.id.nav_container, fragInfoApp).hide(fragInfoApp).commit()

        menu = btn_nav_view.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        btn_nav_view.setOnNavigationItemSelectedListener { item->

            when(item.itemId){
                R.id.navigation_home -> {
                    callFrag(0, fragHome)
                }
                R.id.navigation_data_provinsi -> {
                    callFrag(1, fragProvinsi)
                }
                R.id.navigation_info_aplikasi -> {
                    callFrag(2, fragInfoApp)
                }
            }

            false
        }
    }

    private fun callFrag(i: Int, fragment: Fragment) {
        menuItem = menu.getItem(i)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}