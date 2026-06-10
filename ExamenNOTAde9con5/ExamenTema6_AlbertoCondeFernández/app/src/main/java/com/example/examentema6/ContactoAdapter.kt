package com.example.examentema6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ContactoAdapter(pContexto: Context, pDatos: List<Persona>) : BaseAdapter() {

    val contexto = pContexto
    val datos = pDatos

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(contexto).inflate(
            R.layout.elemento_lista,
            parent,
            false
        )

        val nombreView = view.findViewById<TextView>(R.id.nombre)

        val elemento = datos[position]
        nombreView.text = elemento.nombre
        return (view)
    }


}