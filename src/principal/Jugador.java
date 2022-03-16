package principal;

public class Jugador {
    private String nombre;
    private Integer resultado =0;
    private int parcial;
    private Integer vInicialDado;
    private Integer turno;

    public Jugador() {
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(Integer turno) {
        this.turno = turno;
    }

    public Jugador(int vInicialDado, String nombre) {
        this.nombre = nombre;
        this.resultado = resultado;
        this.parcial = parcial;
        this.vInicialDado = vInicialDado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public int getParcial() {
        return parcial;
    }

    public void setParcial(int parcial) {
        this.parcial = parcial;
    }

    public Integer getvInicialDado() {
        return vInicialDado;
    }

    public void setvInicialDado(Integer vInicialDado) {
        this.vInicialDado = vInicialDado;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }
}
