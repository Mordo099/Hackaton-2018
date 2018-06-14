package ejemplo.aplicacion.primera.gerardo.hackaton2018.Web_service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoints {
    @GET(Constantes_web_service.get_monitorizacion)
    Call<Object> ObtenerMonitorizacion();
}
