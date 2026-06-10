package com.example.examentema6

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.IntentCompat
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class ContactoFragment : Fragment() {

    private lateinit var nombreUsuario: TextView
    private lateinit var numeroUsuario: TextView
    private lateinit var tipoDispositivo: TextView
    private lateinit var botonTelefono: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contacto, container, false)
        return (view)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nombreUsuario = view.findViewById(R.id.nombreUsuario)
        numeroUsuario = view.findViewById(R.id.numero)
        tipoDispositivo = view.findViewById(R.id.tipoDispositivo)
        botonTelefono = view.findViewById(R.id.telefono)

        val indicerecibido = arguments?.getInt("indice")


        if (indicerecibido != null) {
            val arraynombres = resources.getStringArray(R.array.nombres)
            val arraynumeros = resources.getStringArray(R.array.numeros)
            nombreUsuario.text = arraynombres[indicerecibido]
            numeroUsuario.text = arraynumeros[indicerecibido]

            if (numeroUsuario.text[0] == '9') {
                tipoDispositivo.text = "Número Fijo"
            } else {
                tipoDispositivo.text = "Móvil"
            }
        }


        botonTelefono.setOnClickListener{
            val numeroTlf = numeroUsuario.text.toString()
            val camara = Intent(Intent.ACTION_DIAL).apply {
                setData(Uri.parse("tel:$numeroTlf"))
                
            }

            startActivity(camara)

        }
    }
    


}