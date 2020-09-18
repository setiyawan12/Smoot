package com.example.smoot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.smoot.fragment.AkunFragment
import com.example.smoot.fragment.HomeFragment
import com.example.smoot.fragment.KeranjangFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentAkun: Fragment = AkunFragment()
    val fragmentKeranjang: Fragment = KeranjangFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var menu:Menu
    private lateinit var  menuItem:MenuItem
    private lateinit var  bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang).hide(fragmentKeranjang).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu =bottomNavigationView.menu
        menuItem =menu.getItem(0)
        menuItem.isChecked=true

        bottomNavigationView.setOnNavigationItemReselectedListener { item ->
            when(item.itemId){
                R.id.navigation_home ->{
                    Log.d("respons","home")
                    menuItem =menu.getItem(0)
                    menuItem.isChecked=true
                    fm.beginTransaction().hide(active).show(fragmentHome).commit()
                    active = fragmentHome
                }
                R.id.navigation_keranjang ->{
                    Log.d("respons","keranjang")
                    menuItem =menu.getItem(1)
                    menuItem.isChecked=true
                    fm.beginTransaction().hide(active).show(fragmentKeranjang).commit()
                    active = fragmentKeranjang
                }
                R.id.navigation_akun ->{
                    Log.d("respons","akun")
                    menuItem =menu.getItem(2)
                    menuItem.isChecked=true
                    fm.beginTransaction().hide(active).show(fragmentAkun).commit()
                    active = fragmentAkun

                }
            }
            false
        }


    }
}