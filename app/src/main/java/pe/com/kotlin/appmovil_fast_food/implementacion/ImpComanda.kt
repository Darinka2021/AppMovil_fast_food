package pe.com.kotlin.appmovil_fast_food.implementacion

import pe.com.kotlin.appmovil_fast_food.interfaz.IComanda

class ImpComanda:IComanda {
    override fun CargarCategorias(): List<String> {
        val categ= mutableListOf<String>()
        categ.add("--Seleccione categoria--")
        categ.add("bebidas")
        categ.add("platos")
        categ.add("postres")
        return categ
    }

}