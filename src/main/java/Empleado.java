import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Empleado {
  List<Usuario> usuarios;
  ServicioMeteorologico servicioMeteorologico;
  private MailSender mailSender;
  List<TipoAlerta> ultimasAlertas;

  public void dispararSugerencias(){

    TimerTask calculoDeSugerencia = new TimerTask() {
    public void run() {
      usuarios.forEach(usuario -> usuario.recibirSugerencia(new Sugerencia()));
    }
    Timer calcularSugerencia = new Timer("Timer");
    long interval = 600000L; //
    long horas = 24;

    calcularSugerencia.schedule(calculoDeSugerencia, 0L, horas);

  };
  }

  public List<TipoAlerta> getUltimasAlertas() {
    return ultimasAlertas;
  }

  public void consultarAlertas(){
    ultimasAlertas = servicioMeteorologico.getUltimasAlertas("Buenos Aires");
    usuarios.forEach(usuario -> usuario.recibirSugerencia(new Sugerencia()));
    usuarios.forEach(usuario -> mailSender.send(usuario.getMail(), "Nueva Alerta Meteorologica!"));

  }
}
