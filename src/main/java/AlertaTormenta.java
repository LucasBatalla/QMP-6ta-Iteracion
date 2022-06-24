public class AlertaTormenta implements Accion, TipoAlerta {
  String tipoAlerta = "Tormenta";

  @Override
  public void ejecutar(Usuario usuario) {
    notificarUsuario(usuario);
  }
  @Override
  public void notificarUsuario(Usuario usuario) {
    usuario.notify("Llevar paraguas!");
  }
}
