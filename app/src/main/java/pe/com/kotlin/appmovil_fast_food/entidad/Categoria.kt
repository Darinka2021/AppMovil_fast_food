package pe.com.kotlin.appmovil_fast_food.entidad

class Categoria {

    private  var codcat:Int = 0
    private  var nomcat:String =""
    private  var estado:Boolean=false

    constructor()
    constructor(codcat: Int, nomcat: String, estado: Boolean) {
        this.codcat = codcat
        this.nomcat = nomcat
        this.estado = estado
    }


}