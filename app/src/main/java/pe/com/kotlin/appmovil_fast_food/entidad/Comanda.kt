package pe.com.kotlin.appmovil_fast_food.entidad


class Comanda {
    private var idComanda: Int = 0
    private var nombreCliente: String = ""
    //private var productos: List<Producto> = listOf()

    constructor()

    constructor(idComanda: Int, nombreCliente: String/*, productos: List<Producto>*/) {
        this.idComanda = idComanda
        this.nombreCliente = nombreCliente
        //this.productos = productos
    }

}
