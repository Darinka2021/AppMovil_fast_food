package pe.com.kotlin.appmovil_fast_food

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import pe.com.kotlin.appmovil_fast_food.entidad.Categoria
import pe.com.kotlin.appmovil_fast_food.service.CategoriaService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriaActivity : AppCompatActivity() {
    //variables
    private var cat_service:CategoriaService?=null
    private var lista_categoria:List<Categoria>?= listOf()
    private var ctg:Categoria? = Categoria()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)
    }

    fun listCategorias(context:Context) {
        val call = cat_service!!.findAll()
        call!!.enqueue(object : Callback<List<Categoria>?> {
            override fun onResponse(
                call: Call<List<Categoria>?>,
                response: Response<List<Categoria>?>
            ) {
                if (response.isSuccessful) {
                    lista_categoria = response.body()
                }
            }

            override fun onFailure(call: Call<List<Categoria>?>, t: Throwable) {
                Log.e("error:", t.toString())
            }
        })
    }

    fun addCategoria(context: Context,c:Categoria){

        val call = cat_service!!.add(c)
        call!!.enqueue(object :Callback<Categoria?>{
            override fun onResponse(call: Call<Categoria?>, response: Response<Categoria?>) {
                if(response.isSuccessful){
                    Log.e("mensaje","se registro categoria")
                }
            }

            override fun onFailure(call: Call<Categoria?>, t: Throwable) {
                Log.e("Error",t.toString())
            }

        })
    }

    fun findByIdCategoria(context: Context,id:Int){
        val call = cat_service!!.findById(id)
        call!!.enqueue(object : Callback<Categoria?>{
            override fun onResponse(call: Call<Categoria?>, response: Response<Categoria?>) {
                if(response.isSuccessful){
                    ctg = response.body()
                }
            }
            override fun onFailure(call: Call<Categoria?>, t: Throwable) {
                Log.e("Error",t.toString())
            }

        })
    }


    fun updateCategoria(context: Context,c:Categoria,id:Int){
        val call = cat_service!!.update(c,id)
        call!!.enqueue(object : Callback<Categoria?>{
            override fun onResponse(call: Call<Categoria?>, response: Response<Categoria?>) {
                if(response.isSuccessful){
                    ctg = response.body()
                }
            }

            override fun onFailure(call: Call<Categoria?>, t: Throwable) {
                Log.e("Error",t.toString())
            }

        })
    }

    fun eliminarCategoria(context: Context,id:Int){
        val call = cat_service!!.delete(id)
        call!!.enqueue(object : Callback<Categoria?>{
            override fun onResponse(call: Call<Categoria?>, response: Response<Categoria?>) {
                if(response.isSuccessful){
                    Log.e("mensaje","se eliminó categoria")
                }
            }
            override fun onFailure(call: Call<Categoria?>, t: Throwable) {
                Log.e("Error",t.toString())
            }

        })
    }
//showing - d
}