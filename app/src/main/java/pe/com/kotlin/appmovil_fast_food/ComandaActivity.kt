package pe.com.kotlin.appmovil_fast_food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import pe.com.kotlin.appmovil_fast_food.implementacion.ImpComanda
import pe.com.kotlin.appmovil_fast_food.interfaz.IComanda

class ComandaActivity : AppCompatActivity() {

    //implementación para consumir data estatica
    private val comandas: IComanda = ImpComanda()
    //declaramos adaptador
    private var adaptadorCategorias:ArrayAdapter<String>? = null
    private lateinit var comboCateg:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comanda)

        comboCateg=findViewById(R.id.sp_comanda_categoria)

        //modelamos la data en adaptador
        adaptadorCategorias = ArrayAdapter(this,android.R.layout.simple_spinner_item,comandas.CargarCategorias())
        //cargamos el spinner
        comboCateg.adapter = adaptadorCategorias


    }
}