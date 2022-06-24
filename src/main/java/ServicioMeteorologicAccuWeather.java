import java.util.List;
import java.util.Map;

public interface ServicioMeteorologicAccuWeather {


     Map<String, Object> getWeather(String ciudad);

     Map<String, List<String>> getAlerts(String ciudad);




}
