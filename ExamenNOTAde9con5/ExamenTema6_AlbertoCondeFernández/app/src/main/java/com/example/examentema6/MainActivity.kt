package com.example.examentema6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), PasarDatos {

    private lateinit var datos: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        datos = Bundle()
    }




    override fun onBackPressed() {//no lo hemos dado
        val frag = ListaFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmento, frag)
            commit()
        }
    }

    override fun pasarindice(indice: Int) {
        datos.putInt("indice", indice)
        val frag = ContactoFragment().apply {
            arguments = datos
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmento, frag)
            addToBackStack(null)
            commit()
        }
    }
}