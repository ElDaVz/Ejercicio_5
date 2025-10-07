import java.util.Scanner;

public class IOProcess extends Proceso {

    public IOProcess(String pid, String nombre) {
        super(pid, nombre);
    }

    @Override
    public String ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("[I/O] Proceso '" + nombre + "' solicita entrada. Ingrese su nombre: ");
        String nombreUsuario = scanner.nextLine();

        return String.format("[I/O] Proceso '%s' (PID: %s) completado. ¡Hola, %s! Datos recibidos del dispositivo de entrada.",
                nombre, pid, nombreUsuario);
    }
}