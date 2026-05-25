package com.example.contadorequipos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class Fragmentousado1 : Fragment() {

    private lateinit var botonSumar1: Button
    private lateinit var botonSumar2: Button
    private lateinit var botonSumar5: Button
    private lateinit var textoPuntos: TextView
    private lateinit var campoNombreEquipo: EditText

    private var totalPuntos = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_fragmentousado1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //var sumar1 = view.findViewById<Button>(R.id.suma1)
        //var puntos = view.findViewById<TextView>(R.id.puntosE1)


        botonSumar1 = view.findViewById(R.id.suma1)
        botonSumar2 = view.findViewById(R.id.suma2)
        botonSumar5 = view.findViewById(R.id.suma5)
        textoPuntos = view.findViewById(R.id.puntaje)
        campoNombreEquipo = view.findViewById(R.id.nombreEquipo)

        if (savedInstanceState != null) {
            var puntuacion = savedInstanceState.getInt("puntuacion")
            setTotalPuntos(puntuacion)
        }



        botonSumar1.setOnClickListener {
            // textoPuntos.setText("hola")
            setTotalPuntos(totalPuntos + 1)
            //setTotalPuntos(1) //te pondrá solo 1

//            totalPuntos++
//            textoPuntos.setText("$totalPuntos puntos")
        }
        botonSumar2.setOnClickListener {
            setTotalPuntos(totalPuntos + 2)
        }
        botonSumar5.setOnClickListener {
            setTotalPuntos(totalPuntos + 5)
        }

        //textoPuntos.setText("$totalPuntos")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("puntuacion", totalPuntos)
    }

    fun setTotalPuntos(puntos: Int) {
        totalPuntos = puntos
        textoPuntos.setText("$puntos puntos")
    }
}


/*
package com.example.contadorequipos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class Fragmentousado1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_fragmentousado1, container, false)
    }

}
 */