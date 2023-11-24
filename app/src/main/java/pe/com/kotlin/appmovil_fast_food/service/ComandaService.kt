package pe.com.kotlin.appmovil_fast_food.service

import pe.com.kotlin.appmovil_fast_food.entidad.Comanda
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ComandaService {
    @GET("comanda")
    fun findAll(): Call<List<Comanda>?>

    @GET("comanda/{id}")
    fun findById(@Path("id") id: Int): Call<Comanda>?

    @POST("comanda")
    fun add(@Body comanda: Comanda): Call<Comanda>?

    @PUT("comanda/{id}")
    fun update(@Path("id") id: Int, @Body comanda: Comanda): Call<Comanda>?

    @DELETE("comanda/{id}")
    fun delete(@Path("id") id: Int): Call<Void>?
}