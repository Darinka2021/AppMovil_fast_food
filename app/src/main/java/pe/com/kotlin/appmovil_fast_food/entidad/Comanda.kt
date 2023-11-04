package pe.com.kotlin.appmovil_fast_food.entidad

class Comanda {
    var precioBebida:Double=0.0
    var cantidadBebida:Double=0.0
    var precioPlato:Double=0.0
    var cantidadPlato:Double=0.0

    constructor()
    constructor(
        precioBebida: Double,
        cantidadBebida: Double,
        precioPlato: Double,
        cantidadPlato: Double
    ) {
        this.precioBebida = precioBebida
        this.cantidadBebida = cantidadBebida
        this.precioPlato = precioPlato
        this.cantidadPlato = cantidadPlato
    }


}