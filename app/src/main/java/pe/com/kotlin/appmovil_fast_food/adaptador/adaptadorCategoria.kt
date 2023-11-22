package pe.com.kotlin.appmovil_fast_food.adaptador

import android.content.Context
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import pe.com.kotlin.appmovil_fast_food.R
import pe.com.kotlin.appmovil_fast_food.entidad.Categoria

class adaptadorCategoria(context:Context, val listaCategoria:List<Categoria>?):BaseAdapter() {
    private var layoutInflater:LayoutInflater

    init{
        layoutInflater=LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return listaCategoria!!.size
    }

    override fun getItem(p0: Int): Any {
        return listaCategoria!![p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var vista=p1

        return vista!!
    }
}