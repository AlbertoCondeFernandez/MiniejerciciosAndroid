package com.example.contadorequipos

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    //declaro
    private lateinit var botonReset: Button
    private lateinit var contenedorFragmento1: FragmentContainerView
    private lateinit var contenedorFragmento2: FragmentContainerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //defino  si no recives vistta no se necesita poner view (view es this)
        botonReset = findViewById(R.id.reseteamos)
        contenedorFragmento1 = findViewById(R.id.f1)
        contenedorFragmento2 = findViewById(R.id.f2)

        botonReset.setOnClickListener {
            // fragmento1.findViewById<TextView>(R.id.puntaje).setText("0 puntos")

            /*
            contenedorFragmento1.findViewById<TextView>(R.id.puntaje).setText("0 puntos")
            contenedorFragmento2.findViewById<TextView>(R.id.puntaje).setText("0 puntos")
            contenedorFragmento1.getFragment<Fragmentousado1>().setTotalPuntos(0)
            contenedorFragmento2.getFragment<Fragmentousado1>().setTotalPuntos(0)
            */
            contenedorFragmento1.getFragment<Fragmentousado1>()
                .setTotalPuntos(0) //usamos la funcion de FU1 y funciona
            contenedorFragmento2.getFragment<Fragmentousado1>().setTotalPuntos(0)

        }


    }
}

//fragemnto 76 y 35 main problemas