package pe.com.kotlin.appmovil_fast_food

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import pe.com.kotlin.appmovil_fast_food.entidad.Comanda
import pe.com.kotlin.appmovil_fast_food.implementacion.ImpComanda
import pe.com.kotlin.appmovil_fast_food.interfaz.IComanda


class MainActivity : AppCompatActivity() {
    //objeto
    val objComanda:Comanda = Comanda()
    val comandas:IComanda = ImpComanda()
    //declaramos los adapter
    var adaptadorBedida:ArrayAdapter<String>? = null
    var adaptadorPlatos:ArrayAdapter<String>? = null
    // declaramos variable alertDialog
    var dialogo: AlertDialog.Builder?=null

    var filaPlato:Int = 0
    var filaBedida:Int = 0
    var preP:Double =0.0
    var preB:Double =0.0

    lateinit var spinnerBedida: Spinner
    lateinit var spinnerPlato: Spinner
    lateinit var edtPrecioB:EditText
    lateinit var edtCantidadB:EditText
    lateinit var edtPrecioP:EditText
    lateinit var edtCantidadP:EditText
    lateinit var btnLimpiar:Button
    lateinit var btnTotalizar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerBedida = findViewById(R.id.sp_bebidas)
        spinnerPlato = findViewById(R.id.sp_platos)
        edtPrecioB=findViewById(R.id.edt_precio_bebida)
        edtPrecioP=findViewById(R.id.edt_precio_plato)
        edtCantidadB=findViewById(R.id.edt_cantidad_bebida)
        edtCantidadP=findViewById(R.id.edt_cantidad_plato)
        btnLimpiar=findViewById(R.id.btn_limpiar)
        btnTotalizar=findViewById(R.id.btn_totalizar)

        //construimos la estructura de data
        adaptadorBedida = ArrayAdapter(this,android.R.layout.simple_spinner_item,comandas.CargarComboBedida())
        adaptadorPlatos = ArrayAdapter(this,android.R.layout.simple_spinner_item,comandas.CargarComboPlato())
        //cargamos al spinner con la data
        spinnerBedida.adapter = adaptadorBedida
        spinnerPlato.adapter = adaptadorPlatos


        spinnerPlato.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                filaPlato =p2
                when(filaPlato){
                    1->preP=15.0
                    2->preP=40.0
                    3->preP=14.0
                    4->preP=16.0
                    5->preP=20.0
                    6->preP=35.50
                    else->preP=0.0
                }
                edtPrecioP.setText(preP.toString())
                if(spinnerPlato.selectedItemPosition >0){
                    edtCantidadP.setText("1")
                }
                else{
                    edtCantidadP.isActivated = false
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        spinnerBedida.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                filaBedida=p2
                when(filaBedida){
                    1->preB=2.50
                    2->preB=2.50
                    3->preB=3.00
                    4->preB=2.80
                    5->preB=3.40
                    6->preB=3.50
                    else->preB=0.0

                }
                edtPrecioB.setText(preB.toString())
                if(spinnerBedida.selectedItemPosition >0){
                    edtCantidadB.setText("1")
                }
                else{
                    edtCantidadB.isActivated = false
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        btnLimpiar.setOnClickListener{
            spinnerBedida.setSelection(0)
            spinnerPlato.setSelection(0)
            edtCantidadP.setText("")
            edtCantidadB.setText("")
        }
        btnTotalizar.setOnClickListener {
            if(spinnerPlato.selectedItemPosition.equals(0) && spinnerBedida.selectedItemPosition.equals(0) ) {
                MostrarMensaje(this, "validaciones!", "seleccione el producto")
            }
            else if((edtCantidadB.text.isEmpty() || edtCantidadB.text.toString() == "0") && (edtCantidadP.text.isEmpty() || edtCantidadP.text.toString() == "0")){
                MostrarMensaje(this,"validaciones!","Ingrese cantidad")
            }

            else{
                Toast.makeText(this,"se calculará la compra ...",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DetalleActivity::class.java)
                startActivity(intent)

            }

        }

    }

    //creamos un procedimiento para mostrar los cuadro de dialogos
    fun MostrarMensaje(context:Context,t:String,m:String) {
        dialogo = AlertDialog.Builder(context)
        dialogo!!.setTitle(t)
        dialogo!!.setMessage(m)
        dialogo!!.setCancelable(false)
        dialogo!!.setPositiveButton("Ok") { dialogo, which ->
        }
        dialogo!!.show()
    }
}