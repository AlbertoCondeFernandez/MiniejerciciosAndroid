package com.example.examentema6

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class Persona(pNombre: String) {
    var nombre = pNombre
}


class ListaFragment : Fragment() {

    private lateinit var lista: ListView
    private lateinit var comunicadorInterfaz: PasarDatos

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arraynombres = resources.getStringArray(R.array.nombres)


        val listaDatos = mutableListOf<Persona>()
        for (i in 0..<arraynombres.size) {
            listaDatos.add(Persona(arraynombres[i]))
        }

        lista = view.findViewById(R.id.lista)
        val adapter = ContactoAdapter(requireContext(), listaDatos)


        lista.adapter = adapter
        comunicadorInterfaz = activity as PasarDatos

        lista.setOnItemClickListener { parent, view, position, id ->
            val indice = position
            comunicadorInterfaz.pasarindice(indice)
        }

    }
}