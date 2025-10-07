public class Daemon extends Proceso {

    public Daemon(String pid, String nombre) {
        super(pid, nombre);
    }

    @Override
    public String ejecutar() {
        //Esta parte imprime una barra que se "carga" simulando que un proceso está ocurriendo
        int porcentaje = 0;
        String simbolo = "=";
        int total = 10;
        String vacio = " ";
        String texto = "[DAEMON] '" + nombre + "' (PID: " + pid + ") Cargando servicio [";
        StringBuilder sb = new StringBuilder();

        while (porcentaje <= total) {
            int faltantes = total - porcentaje;

            sb.append(texto)
                    .append(simbolo.repeat(porcentaje))
                    .append(vacio.repeat(faltantes))
                    .append("] ")
                    .append((porcentaje * 100) / total)
                    .append("%\n");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                return "[DAEMON] Error en ejecución: " + e.getMessage();
            }

            porcentaje += 1;
        }

        sb.append("\n[DAEMON] Proceso '").append(nombre).append("' ejecutándose en segundo plano. Servicio activo.");
        return sb.toString();
    }
}
