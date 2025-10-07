abstract class Proceso {
    protected String pid;
    protected String nombre;

    protected Proceso(String pid, String nombre) {
        this.pid = pid;
        this.nombre = nombre;
    }

    //Método que las clases hijas implementarán a su forma.
    public abstract String ejecutar();

    public String getPid() {
        return pid;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] PID: " + pid + " - Nombre: " + nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Proceso proceso = (Proceso) obj;
        return pid.equals(proceso.pid);
    }
}
