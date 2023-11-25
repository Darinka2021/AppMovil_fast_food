package pe.com.kotlin.appmovil_fast_food.entidad

class Producto {
    var idProducto: Int = 0
    var nombre: String = ""
    var precio: Double = 0.0
    var descripcion: String = ""
    var imageUrl: String? = null // URL imagen del producto
    var cantidad: Int = 0

    constructor()

    constructor(idProducto: Int, nombre: String, precio: Double, descripcion: String, imageUrl: String?, cantidad: Int) {
        this.idProducto = idProducto
        this.nombre = nombre
        this.precio = precio
        this.descripcion = descripcion
        this.imageUrl = imageUrl
        this.cantidad = cantidad
    }
}