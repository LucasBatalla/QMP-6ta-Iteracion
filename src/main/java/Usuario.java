import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class Usuario {
 List<Accion> acciones;
 String mail;


 public void aceptarAccion(Accion accion){
   if(acciones.contains(accion)){
     accion.ejecutar(this);
     acciones.remove(accion);
 }
 }
 public void rechazarAccion(Accion accion){
     acciones.remove(accion);
   }
 public void recibirSugerencia(Sugerencia sugerencia){
   acciones.add(sugerencia);
 }

  public String getMail() {
    return mail;
  }

  public List<TipoAlerta> consultarAlertas(Empleado empleado){
   return empleado.getUltimasAlertas();
 }

 public void notificarSegunAlerta(List<String> alertas, Empleado empleado){
    consultarAlertas(empleado).forEach(alerta -> alerta.notificarUsuario(this));
   }
 }



}
