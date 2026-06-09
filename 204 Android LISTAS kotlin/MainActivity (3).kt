package com.example.ep2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ep2.ui.theme.Ep2Theme


data class Piloto(val nombre: String, val descripcion: String, val foto: Int)
/* val no se puede cambiar
class Piloto(nombre: String, descripcion: String, foto: Int) {
    var nombre by mutableStateOf(nombre)
    var descripcion by mutableStateOf(descripcion)
    var foto by mutableStateOf(foto)
}
*/




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ep2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

}
//


//"Fernando Alonso", "Carlos Sainz", "Max Verstappen","Lewis Hamilton","Lando Norris"
// listOf leo lista inmutable
/*Piloto("nombre", "texto", R.drawable.motito),*/ //ese será el contenido de piloto
@Composable
fun ListaNombresPilotos() {


    val pilotos = listOf<Piloto>(
        Piloto(
            "Fernando Alonso",
            "Fernando Alonso continúa compitiendo con Aston Martin y ha tenido una temporada 2025 marcada por altibajos y resultados dispares. Aunque enfrenta ciertas dificultades con el ritmo del coche y ha terminado décimo en carreras recientes, sigue mostrando su capacidad para entrar en la Q3 y sumar puntos, a la espera de un mayor rendimiento bajo la normativa técnica de 2026.",
            R.drawable.fernando
        ),
        Piloto(
            "Carlos Sainz",
            "Carlos Sainz vive uno de sus mejores momentos tras su llegada a Williams para la temporada 2025 de F1. A pesar de algunos problemas de rendimiento iniciales, ha conseguido podios históricos y remontadas destacadas, consolidándose como un valor clave para el equipo británico y ascendiendo en la clasificación general.",
            R.drawable.carloss
        ),
        Piloto(
            "Max Verstappen",
            "Max Verstappen sigue siendo un protagonista de la F1 2025 con Red Bull, manteniéndose en la pelea por el mundial pese a que el equipo ha perdido algo de ventaja respecto a McLaren. Reconocido por su nivel de pilotaje y por motivar a su equipo a exprimir el RB21 al máximo, Verstappen afronta las últimas carreras del año con opciones de sumar un quinto campeonato del mundo.",
            R.drawable.elmax
        ),
        Piloto(
            "Lewis Hamilton",
            "Lewis Hamilton afronta su temporada de debut con Ferrari en 2025 con desafíos de adaptación al nuevo monoplaza SF-25. Si bien ha logrado buenos resultados en las carreras sprint y mantiene el récord de podios en F1, su principal objetivo es seguir aprendiendo y sumando la mayor cantidad de puntos posibles durante el proceso de integración con su nuevo equipo.",
            R.drawable.lewispng
        ),
        Piloto(
            "Lando Norris",
            "Lando Norris es una de las principales figuras de la F1 2025 tras convertirse en referente absoluto de McLaren. Mantiene una racha de resultados sobresalientes, luchando por victorias y consolidando su imagen tanto dentro como fuera de la pista gracias a su constancia y evolución desde sus inicios en el karting.",
            R.drawable.lando
        ),
        //Piloto("Fernando Alonso","sdd","w"),
    )

    LazyColumn { //comandod e compose para poder meter una cosa debajo de otra en pocas palabras
        //items(5){ index ->
        itemsIndexed(pilotos) { index, pilotoR ->


            ItemPiloto(pilotoR)
        }
    }


}

@Composable
fun ItemPiloto(pilotoRandom: Piloto) {
    //copia local modificable
//    var descripcion by remember {
//        mutableStateOf(
//            pilotoRandom.descripcion
//        )
//    }
    var isSelected by remember { mutableStateOf(true) }   //para poner si esta encogido o no
    var descripcion = pilotoRandom.descripcion
    if (isSelected) descripcion =
        pilotoRandom.descripcion.take(26)  //con substring(0, 26) si el texto es mas corto crashe
    //if (isSelected) descripcion = pilotoRandom.descripcion.substring(0, 26)
    /*

    @Composable
    fun ItemPiloto(pilotoRandom: Piloto) {
        //copia local modificable
        var pilotoActual by remember {
            mutableStateOf(
                Piloto(
                    pilotoRandom.nombre,
                    pilotoRandom.descripcion,
                    pilotoRandom.foto
                )
            )
        }
     */

    Row(

        //verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .clickable(true, onClick = { isSelected = !isSelected })
            .background(Color.Black)
            .padding(16.dp)             //metemos margenes internos entre filas
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(pilotoRandom.foto),
            contentScale = ContentScale.Crop, //recorta al tamaño especificado de modifier
            modifier = Modifier
                //.border(0.dp, Color.White, CircleShape) //las posiciones shape =
                .clip(CircleShape)  //circular forma
                .size(60.dp),           // w y h aplica
            //.width(40.dp)
            // .padding(end = 10.dp)               //las , lo fastidian preguntar porque o si es así sin mas , es la separacion entre imagen y texto
            //.height(40.dp),


            contentDescription = "Imagen de pilotoRandom"
        )
        Column {
            Text(text = pilotoRandom.nombre, color = Color.White)
            Text(text = descripcion, color = Color.Magenta)
            // if (isSelected)  "a" else
        }
    }
}

//mirar greeting
/* este es el greeting viejo que usé apra crear solo las listas de los pilotos , el de abajo es el nuemo con "Lista" incluida
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    ListaNombresPilotos()
}
*/

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Fodno moradod e arriba
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6200EA)) // Morado parecido   Color(0xFF6200EA) Color.Blue no es
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart //centro izquierda
        ) {
            Text(
                text = "Lista",
                color = Color.White,
                fontSize = 25.sp
            )
        }

        // Lista de pilotos
        ListaNombresPilotos()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ep2Theme {
        Greeting("Android")
    }
}
