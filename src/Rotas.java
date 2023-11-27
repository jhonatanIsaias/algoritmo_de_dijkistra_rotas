import java.util.*;

public class Rotas {
    List<Roteador> roteadores;

    public Rotas() {
        this.roteadores = new ArrayList<>();
    }

    public void addRota(Roteador r) {
        roteadores.add(r);
    }

    public void addConnection(Roteador router1, Roteador router2, int peso) {
        if (router1 != null && router2 != null) {
            router1.addConexoes(router2, peso);
        }
    }

    public String calcularRota(Roteador origem, Roteador destino) {

        if (!roteadores.contains(origem) || !roteadores.contains(destino)) {
            return "Roteador de origem ou destino não encontrado";
        }





        origem.setDistanciaMinima(0);


        PriorityQueue<Roteador> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(Roteador::getDistanciaMinima));
        filaPrioridade.addAll(roteadores);

        while (!filaPrioridade.isEmpty()) {
            Roteador roteadorAtual = filaPrioridade.poll();


            for (Conexao conexao : roteadorAtual.getConexoes()) {
                Roteador roteadorVizinho = conexao.getRoteadorConectado();
                int pesoAresta = conexao.getPeso();


                if (roteadorAtual.getDistanciaMinima() + pesoAresta < roteadorVizinho.getDistanciaMinima()) {
                    filaPrioridade.remove(roteadorVizinho);
                    roteadorVizinho.setDistanciaMinima(roteadorAtual.getDistanciaMinima() + pesoAresta);
                    filaPrioridade.add(roteadorVizinho);
                }
            }
        }


        StringBuilder caminho = new StringBuilder();
        Roteador roteadorAtual = destino;

        while (roteadorAtual != null) {
            caminho.insert(0, roteadorAtual.getName());
            caminho.insert(0, " -> ");
            roteadorAtual = getRoteadorAnterior(roteadorAtual);
        }


        caminho.delete(0, 4);

        return caminho.toString();
    }

    private Roteador getRoteadorAnterior(Roteador roteador) {
        for (Roteador r : roteadores) {
            for (Conexao conexao : r.getConexoes()) {
                if (conexao.getRoteadorConectado().equals(roteador) &&
                        r.getDistanciaMinima() + conexao.getPeso() == roteador.getDistanciaMinima()) {
                    return r;
                }
            }
        }
        return null;
    }
}
