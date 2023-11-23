package pe.com.kotlin.appmovil_fast_food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import pe.com.kotlin.appmovil_fast_food.implementacion.ImpComanda
import pe.com.kotlin.appmovil_fast_food.interfaz.IComanda

class ComandaActivity : AppCompatActivity() {

    //implementación para consumir data estatica
    private val comandas: IComanda = ImpComanda()
    //declaramos adaptador
    private var adaptadorCategorias:ArrayAdapter<String>? = null
    private lateinit var comboCateg:Spinner
    private lateinit var btnTotalizar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comanda)

        comboCateg=findViewById(R.id.sp_comanda_categoria)
        btnTotalizar=findViewById(R.id.btn_totalizar_pedido)

        //modelamos la data en adaptador
        adaptadorCategorias = ArrayAdapter(this,android.R.layout.simple_spinner_item,comandas.CargarCategorias())
        //cargamos el spinner
        comboCateg.adapter = adaptadorCategorias


        btnTotalizar.setOnClickListener {
            Toast.makeText(this,"se calculará la compra ...",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetalleActivity::class.java)
            startActivity(intent)

        }

    }
}