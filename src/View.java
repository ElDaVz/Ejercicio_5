import java.util.ArrayList;
import java.util.Scanner;

/// Esta clase es la vista general para el usuario

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        //Crear menú
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== SIMULADOR DE PROCESOS ===\n");
        sb.append("1. Agregar nuevo proceso\n");
        sb.append("2. Ejecutar todos los procesos\n");
        sb.append("3. Ver procesos registrados\n");
        sb.append("4. Salir\n");
        sb.append("Seleccione una opción: ");
        //Mostar menú
        System.out.print(sb.toString());
    }

    public int leerOpcion() {
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public void mostrarSubMenu() {
        //Menú que se muestra después de seleccionar una opción.
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== TIPO DE PROCESO ===\n");
        sb.append("1. Proceso CPU\n");
        sb.append("2. Proceso I/O\n");
        sb.append("3. Daemon\n");
        sb.append("Seleccione tipo: ");
        System.out.print(sb.toString());
    }

    public int leerTipo() {
        int tipo = scanner.nextInt();
        scanner.nextLine();
        return tipo;
    }

    public String leerPID() {
        System.out.print("Ingrese PID: ");
        return scanner.nextLine();
    }

    public String leerNombre() {
        System.out.print("Ingrese nombre del proceso: ");
        return scanner.nextLine();
    }

    public int leerOperaciones() {
        //Cantidad de veces que se ejecutará una operación
        System.out.print("Ingrese operaciones (0 = default): ");
        int ops = scanner.nextInt();
        scanner.nextLine();
        return ops;
    }

    public void mostrarProcesos(ArrayList<Proceso> procesos) {
        // imprimir procesos creados.
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== PROCESOS REGISTRADOS ===\n");

        if (procesos.isEmpty()) {
            sb.append("No hay procesos registrados.\n");
        } else {
            for (Proceso p : procesos) {
                sb.append(p.toString()).append("\n");
            }
        }
        sb.append("============================\n");

        System.out.println(sb.toString());
    }

    public void mostrarResultado(String resultado) {
        System.out.println(resultado);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}