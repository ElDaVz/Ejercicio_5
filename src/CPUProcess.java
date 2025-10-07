public class CPUProcess extends Proceso {
    private int operaciones;

    public CPUProcess(String pid, String nombre, int operaciones) {
        super(pid, nombre);
        this.operaciones = operaciones;
    }

    public CPUProcess(String pid, String nombre) {
        super(pid, nombre);
        this.operaciones = 0;
    }

    @Override
    public String ejecutar() {
        //Simula procesos de cálculo aritmético sencillos (suma o resta).
        int resultado = 0;
        int cantidadOperaciones = (this.operaciones != 0) ? this.operaciones : 1000;

        for (int i = 0; i < cantidadOperaciones; i++) {
            resultado += i;
            resultado -= i / 2;
        }

        return String.format("[CPU] Proceso '%s' (PID: %s) completó %d operaciones de cálculo intensivo. Resultado: %d",
                nombre, pid, cantidadOperaciones, resultado);
    }
}