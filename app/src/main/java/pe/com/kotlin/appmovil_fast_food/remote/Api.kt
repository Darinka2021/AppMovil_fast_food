package pe.com.kotlin.appmovil_fast_food.remote

import pe.com.kotlin.appmovil_fast_food.service.CategoriaService

object Api {

    val API_URL="http://192.168.100.7:8099/supertasty/categoria"

    val categoriaservice:CategoriaService? get()
    = RetrofitClient.getConnection(API_URL)?.create(CategoriaService::class.java)
}