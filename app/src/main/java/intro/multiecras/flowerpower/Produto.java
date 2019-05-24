package intro.multiecras.flowerpower;

public class Produto {

    public enum EnumCategorias {
        MaisVendidas("Mais vendidas"),
        DiaDaMae("Dia da Mãe"),
        Decorativas("Decorativas"),
        Arvores("Árvores"),
        Raras("Raras");

        private final String tipo;

        EnumCategorias(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return this.tipo;
        }
    }

    public final String nome;
    public final double preco;
    public final EnumCategorias categoria;
    public final int idImagem;
    public final String tipoPlanta;
    public final String evento;



    public Produto(String nome, double preco, EnumCategorias categoria, int idImagem, String tipoPlanta, String evento) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.idImagem = idImagem;
        this.tipoPlanta = tipoPlanta;
        this.evento = evento;

    }



    /*public void defineFiltros(){
        tipoPlanta[0] = "Naturais";
        tipoPlanta[1] = "Artificias";
        eventos[0] = "Casamentos";
        eventos[1] = "Dia da Mãe";
        eventos[2] = "Festas";
        eventos[3] = "Páscoa";
        eventos[4] = "Aniversários";
    }*/
}
