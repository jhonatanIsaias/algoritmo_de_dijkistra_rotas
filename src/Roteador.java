import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Roteador {
    private String name;
    private List<Conexao> conexoes;

    private int distanciaMinima = Integer.MAX_VALUE;

    public Roteador(String name) {
        this.name = name;
        this.conexoes = new ArrayList<>();
    }

    public void addConexoes(Roteador roteadorConectado, int peso){
        conexoes.add(new Conexao(roteadorConectado,peso));
        roteadorConectado.getConexoes().add(new Conexao(this,peso));
    }

    public int getDistanciaMinima() {
        return distanciaMinima;
    }

    public void setDistanciaMinima(int distanciaMinima) {
        this.distanciaMinima = distanciaMinima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roteador roteador)) return false;
        return Objects.equals(name, roteador.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public List<Conexao> getConexoes() {
        return conexoes;
    }

    public String getName() {
        return name;
    }
}
