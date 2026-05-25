package com.example.nopesestantoporfavor


//ESTA ES LA QUE TIENES QUE VER IMANOL
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class b : AppCompatActivity() {
    private lateinit var botonSuma: FloatingActionButton
    private lateinit var botonGaleria: FloatingActionButton
    private lateinit var botonCompartir: FloatingActionButton
    private lateinit var botonCamara: FloatingActionButton
    private lateinit var mainLayout: View
    private lateinit var textView: TextView

    private var areButtonsVisible = false // Variable para controlar la visibilidad de los botones

    private var textoOriginal: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        // Inicialización de los botones y vistas
        botonSuma = findViewById(R.id.soylasuma)
        botonGaleria = findViewById(R.id.soygaleria)
        botonCompartir = findViewById(R.id.elgenerosocompatidor)
        botonCamara = findViewById(R.id.soylacamara)

        mainLayout = findViewById(R.id.main) // layout principal
        textView = findViewById(R.id.textView) // TextView

        textoOriginal = textView.text.toString()
        //ahora tenemos 2 textos , eso esta bien


        // Invisibles por defecto
        botonGaleria.visibility = View.INVISIBLE
        botonCompartir.visibility = View.INVISIBLE
        botonCamara.visibility = View.INVISIBLE

        //el menu es +
        botonSuma.setOnClickListener {
            if (areButtonsVisible) {
                ocultarBotones()
                animarBotonSuma(false) //desgirar
                mainLayout.alpha = 1.0f // Valor por defecto
                textView.text = textoOriginal
            } else {
                mostrarBotones()
                animarBotonSuma(true) //giro
                mainLayout.alpha = 0.5f // oscurece
            }
            areButtonsVisible = !areButtonsVisible
        }

        botonGaleria.setOnClickListener {
            textView.text = "Galeria"
            textView.setTextColor(Color.YELLOW)
            Toast.makeText(this, "¡Color cambiado a amarillo!", Toast.LENGTH_SHORT).show()
        }

        botonCompartir.setOnClickListener {
            textView.text = "Comparte"
            textView.setTextColor(Color.MAGENTA)
            Toast.makeText(this, "¡Texto cambiado a 'Comparte'!", Toast.LENGTH_SHORT).show()
        }


        botonCamara.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://es.wikipedia.org"))
            startActivity(browserIntent)
            Toast.makeText(this, "¡NAVEGA SEGURO!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mostrarBotones() {
        val animAparece = AnimationUtils.loadAnimation(this, R.anim.abracadabra)


        botonGaleria.visibility = View.VISIBLE
        botonCompartir.visibility = View.VISIBLE
        botonCamara.visibility = View.VISIBLE



        botonGaleria.startAnimation(animAparece)
        botonCompartir.startAnimation(animAparece)
        botonCamara.startAnimation(animAparece)
        //animacion Aparicion aparece
    }

    private fun ocultarBotones() {

        //se usa animacion y encima restaura texto original
        val animXao = AnimationUtils.loadAnimation(this, R.anim.asenosfue)
        //reverso ver si hay otro metodo

        botonGaleria.startAnimation(animXao)
        botonCompartir.startAnimation(animXao)
        botonCamara.startAnimation(animXao)
        textView.text = textoOriginal


        textView.setTextColor(Color.BLACK) //negro porque si no no lo coge mirar numero


        botonGaleria.visibility = View.INVISIBLE
        botonCompartir.visibility = View.INVISIBLE
        botonCamara.visibility = View.INVISIBLE
    }

    private fun animarBotonSuma(abrir: Boolean) {
        val inicio = if (abrir) 0f else 45f
        val fin = if (abrir) 45f else 0f
        //con esto giro
        val rotateAnimation = RotateAnimation(
            inicio, fin,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.duration = 300
        rotateAnimation.fillAfter = true

        botonSuma.startAnimation(rotateAnimation)
    }
}
//R.anim