package com.example.aptest

import android.graphics.Paint
import android.icu.text.ListFormatter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color //TENGO TODOS
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aptest.ui.theme.ApTestTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Albertito( //Mi nombre
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/*Vamos a aprovechar para meter  composable  que es muy útil para sitiaciones repetitivas ahorrando
//así gran parte de tiempo y reduciendo el código
Lo primero es identificar  que parámetros por defecto queremos y ponerles nombres
 */
//Atributos únicos , Texto ,forma, color , alineación de texto
//color es de la clase background es un tipo
/*Es bastante importante saber que hay un orden por defecto y que nosotros nos podemos saltar ese mismo orden
 introduciendo el "nombre completo" , en cambio si el orden coincide puede poner el valor directamente
*/
@Composable
fun Cajita(
    textocaja: String,
    colorFondo: Color,
    alineacionTexto: Alignment,
    forma: Shape = RectangleShape,
) {

    Box(
        modifier = Modifier // permite iniciar modificaciones
            .size(100.dp) //caja tamaño estándar
            .background(color = colorFondo, shape = forma)
            .border(8.dp, Color.Black, shape = forma)
            .padding(16.dp), contentAlignment = alineacionTexto

    )
    {
        Text(textocaja)
    }
}
/*aquí por ejemplo vemos que usé el @composable para la fun Cajita , con poner solo la caja y los valores
que quiera ,lo usaré un total de 3 veces
*/

@Composable
fun Albertito(name: String, modifier: Modifier = Modifier) {
    // .metodos
    //,argumentos
    //interfac clase abstracta
    Column(                   //quiero hacer que la pantalla del movil cuente como 1 columna
        modifier = Modifier
            .fillMaxSize() //tamaño máximo
            .padding(16.dp) //espaciado interno
            .background(color = Color.White),
        Arrangement.spacedBy(18.dp) //espacioado de componenete  para la columna
    ) {  //puedo modifical la columna
        Box(
            modifier = Modifier
                .background(color = Color.Cyan)
                .fillMaxWidth()
                .padding(8.dp), contentAlignment = Alignment.Center
        )
        {
            Text(

                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 20.sp,
                    //estn comentados porque no hacen falta pero podria modificarlo
                    //background = Color.Green,
                ),
                text = "Desarrollo en Android",
            )
        }
        //La primera parte esta hecha
        Row(
            modifier = Modifier
                // .border(8.dp, Color.Gray) se  come el contenido y pading te quita el fondo
                .fillMaxWidth()//todo lo ancho
                .background(Color.LightGray)
                .padding(8.dp)  //IMPORTA MUCHISIMO escribirlo despues de background por el orden que te indica Modifier
            , Arrangement.SpaceEvenly //reparte todo SpaceBetween


        ) {
            /*Esta es la parte de las cajas con formas ,
            Esta comentado el como sería sin usar la herramienta @Composable
            Se puede ver que ahorariamos muchisismo texto de esta forma
            */
            Cajita(
                "DAM", Color.Yellow,
                Alignment.CenterStart
            )
            /*
            Box(
                modifier = Modifier
                    .size(100.dp) //caja grande
                    .background(color = Color.Yellow)
                    .border(8.dp, Color.Black)
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            )
            {
                Text("DAM")
            }
            */
            Cajita(
                "DAW",
                Color.Green, Alignment.TopCenter,
                CircleShape,
            )
            /*
            Box(
                modifier = Modifier
                    .size(100.dp)
                    // shape =
                    .background(Color.Green, CircleShape)
                    .border(8.dp, Color.Black, CircleShape)
                    .padding(16.dp), contentAlignment = Alignment.TopCenter
            )
            {
                Text("DAW")
            }
            */
            Cajita(
                "ASIR",
                Color.Magenta, Alignment.BottomEnd
            )
            /*
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Magenta)
                    .border(8.dp, Color.Black)
                    .padding(16.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text("ASIR")
            }

             */

        }
        //nuevo row , la parte final creamos nueva fila horizontal donde metemos caja y texto


        Row(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box(
                modifier = Modifier
                    .size(250.dp)
                    .background(Color.Gray),

                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Texto en un Box",
                    color = Color.White,
                    fontSize = 18.sp,
                    style = TextStyle(
                        background = Color.DarkGray
                    )


                )
            }


        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApTestTheme {
        Albertito("Android")
    }
}
