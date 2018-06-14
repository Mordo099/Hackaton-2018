package ejemplo.aplicacion.primera.gerardo.hackaton2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import ejemplo.aplicacion.primera.gerardo.hackaton2018.Web_service.Constantes_web_service;
import ejemplo.aplicacion.primera.gerardo.hackaton2018.Web_service.EndPoints;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView texto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto1 = findViewById(R.id.texto1);
        obtenerMonitorizacion();
    }

    private void obtenerMonitorizacion(){
        final Retrofit.Builder Builder = new Retrofit.Builder()
                .baseUrl(Constantes_web_service.base_url)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = Builder.build();
        EndPoints endPoints = retrofit.create(EndPoints.class);
        Call call=endPoints.ObtenerMonitorizacion();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                String gsonCadena = new Gson().toJson(response.body());
                //Toast.makeText(MainActivity.this, gsonCadena, Toast.LENGTH_SHORT).show();
                texto1.setText(gsonCadena);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
