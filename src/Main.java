
public class Main {
    public static void main(String[] args) {
        Rotas rotas = new Rotas();

        Roteador r1 = new Roteador("R1");
        Roteador r2 = new Roteador("R2");
        Roteador r3 = new Roteador("R3");
        Roteador r4 = new Roteador("R4");
        Roteador r5 = new Roteador("R5");

        rotas.addRota(r1);
        rotas.addRota(r2);
        rotas.addRota(r3);
        rotas.addRota(r4);
        rotas.addRota(r5);

        rotas.addConnection(r1,r2,2);
        rotas.addConnection(r1,r3,3);
        rotas.addConnection(r2,r3,1);
        rotas.addConnection(r2,r4,5);
        rotas.addConnection(r3,r4,4);
        rotas.addConnection(r3,r5,2);
        rotas.addConnection(r4,r5,2);

        System.out.println(rotas.calcularRota(r1,r5));

    }
}