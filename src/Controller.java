import java.util.ArrayList;

public class Controller {
    private View view;
    private ArrayList<Proceso> procesos;

    public Controller() {
        this.view = new View();
        this.procesos = new ArrayList<>();
    }

    public void iniciar() {
        //Inicia el programa
        var flag = true;

        while (flag) {
            view.mostrarMenu();
            int opcion = view.leerOpcion();

            if (opcion == 1) {
                manejarAgregarProceso();
            } else if (opcion == 2) {
                ejecutarTodos();
            } else if (opcion == 3) {
                view.mostrarProcesos(procesos);
            } else if (opcion == 4) {
                flag = false;
                view.mostrarMensaje("\nSaliendo del sistema...");
            } else {
                view.mostrarMensaje("\nOpción inválida. Intente nuevamente.");
            }
        }
    }

    private void manejarAgregarProceso() {

        view.mostrarSubMenu();
        int tipo = view.leerTipo();
        String pid = view.leerPID();
        String nombre = view.leerNombre();

        if (tipo == 1) {
            int ops = view.leerOperaciones();
            if (ops > 0) {
                agregarProceso(new CPUProcess(pid, nombre, ops));
            } else {
                agregarProceso(new CPUProcess(pid, nombre));
            }
        } else if (tipo == 2) {
            agregarProceso(new IOProcess(pid, nombre));
        } else if (tipo == 3) {
            agregarProceso(new Daemon(pid, nombre));
        } else {
            view.mostrarMensaje("\nTipo de proceso inválido.");
            return;
        }

        view.mostrarMensaje("\nProceso agregado exitosamente.");
    }

    public void agregarProceso(Proceso p) {
        this.procesos.add(p);
    }

    public void ejecutarTodos() {
        if (procesos.isEmpty()) {
            view.mostrarMensaje("\nNo hay procesos para ejecutar.");
            return;
        }

        view.mostrarMensaje("\n=== EJECUTANDO PROCESOS ===\n");
        for (Proceso p : this.procesos) {
            String resultado = p.ejecutar();
            view.mostrarResultado(resultado);
            view.mostrarMensaje(""); // Línea en blanco entre procesos
        }
    }

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }
}