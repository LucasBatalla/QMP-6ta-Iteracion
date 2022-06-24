public class AlertaGranizo implements Accion, TipoAlerta {
  String tipoAlerta = "Granizo"

  @Override
  public void ejecutar(Usuario usuario) {
    notificarUsuario(usuario);
  }
  @Override
  public void notificarUsuario(Usuario usuario) {
    usuario.notify("Evita salir en auto");
  }
}
