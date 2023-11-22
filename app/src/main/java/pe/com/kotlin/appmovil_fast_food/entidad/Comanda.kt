package pe.com.kotlin.appmovil_fast_food.entidad

//tabla detalle de pedido
class Comanda {
    //fk_id_pedido
    //fk_id_producto
    private lateinit var producto:MutableCollection<Any>
    //cantidad
    private var cantidad:Int=0
    //subtotal
    private var subtotal:Double=0.0
    //total
    private var total:Double=0.0


}