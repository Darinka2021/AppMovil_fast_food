package pe.com.kotlin.appmovil_fast_food.service
import pe.com.kotlin.appmovil_fast_food.entidad.Categoria
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CategoriaService {

    @GET("categoria")
    fun findAll():Call<List<Categoria>?>

    /*@GET("categoria/custom")
    fun findAllCustom():Call<List<Categoria>?>?*/
    @GET("categoria")
    fun findById(id:Int):Call<Categoria>?
    @POST("categoria")
    fun add(@Body c:Categoria):Call<Categoria?>?
    @PUT("categoria/id")
    fun update(@Body c:Categoria,@Path("id") id:Int):Call<Categoria>?
    @PUT("categoria/id")
    fun update_enable(@Body c:Categoria,@Path("id") id:Int):Call<Categoria>?
    @DELETE
    fun delete(@Path("id") id:Int):Call<Categoria>?
}