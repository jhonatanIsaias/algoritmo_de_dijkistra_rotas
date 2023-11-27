public class Conexao {
    private Roteador roteadorConectado;
    private int peso;

    public Conexao(Roteador roteadorConectado, int peso) {
        this.roteadorConectado = roteadorConectado;
        this.peso = peso;
    }

    public Roteador getRoteadorConectado() {
        return roteadorConectado;
    }

    public void setRoteadorConectado(Roteador roteadorConectado) {
        this.roteadorConectado = roteadorConectado;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
