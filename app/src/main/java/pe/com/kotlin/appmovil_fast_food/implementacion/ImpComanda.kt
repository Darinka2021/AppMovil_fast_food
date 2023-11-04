package pe.com.kotlin.appmovil_fast_food.implementacion

import pe.com.kotlin.appmovil_fast_food.interfaz.IComanda

class ImpComanda:IComanda {
    override fun CargarComboBedida(): List<String> {
        val bebida= mutableListOf<String>()
        bebida.add("--Seleccione el producto--")
        bebida.add("Inka Kola 350ml")
        bebida.add("Coca Cola 350ml")
        bebida.add("Inka Kola 550ml")
        bebida.add("Coca Cola 550ml")
        bebida.add("Cola Inglesa 400ml")
        bebida.add("Sprint Limon 500ml")
        return bebida
    }

    override fun CargarComboPlato(): List<String> {
        val plato = mutableListOf<String>()
        plato.add("--Seleccione el producto--")
        plato.add("Broster 4 Piezas")
        plato.add("Broster 4 Piezas Picante")
        plato.add("Broster Familiar")
        plato.add("Enchilada Ranchera")
        plato.add("Amburguesa Royal")
        plato.add("Amburguesa Clasica")
        return plato
    }
}