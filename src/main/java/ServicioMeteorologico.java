import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ServicioMeteorologico{
    private final LocalDateTime expiracion;
    private final ServicioMeteorologicAccuWeather api;
    private final String direccion;
    private Map<String, Object> ultimaRespuesta;
    private LocalDateTime proximaExpiracion;
    private List<String> ultimasAlertas;

    public ServicioMeteorologico(ServicioMeteorologicAccuWeather api, Duration periodoDeValidez, String direccion) {
      this.api = api;
      this.expiracion = expiracion;
      this.direccion = direccion;
    }

    public List<TipoAlerta> getUltimasAlertas(String city){
      return (List<TipoAlerta>) api.getAlerts(city);
    }

    public Map<String, Object> obtenerCondicionesClimaticas() {
      if (this.ultimaRespuesta == null || this.expiro()) {
        this.ultimaRespuesta = consultarApi();
        this.proximaExpiracion = LocalDateTime.now().plus(expiracion);
      }
      return this.ultimaRespuesta;
    }

    private boolean expiro() {
      return proximaExpiracion.isAfter(DateTime.now);
    }
  }

}

}
