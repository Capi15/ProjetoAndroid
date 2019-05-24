package intro.multiecras.flowerpower;

public class Container {

    public static String[] tipoPlantas = {
            "Naturais", "Artificias"
    };
    public static String[] eventos = {
            "Casamentos", "Dia da Mãe", "Festas", "Páscoa", "Aniversários"
    };


    public static final Produto[] AProduto = {
            new Produto(
                    "Flor 1",
                    10.00d,
                    Produto.EnumCategorias.MaisVendidas,
                    R.drawable.flor_01,
                    tipoPlantas[0],
                    eventos[0]
            ),
            new Produto(
                    "Flor 2",
                    5.00d,
                    Produto.EnumCategorias.MaisVendidas,
                    R.drawable.flor_02,
                    tipoPlantas[1],
                    eventos[0]
            ),
            new Produto(
                    "Flor 3",
                    6.00d,
                    Produto.EnumCategorias.MaisVendidas,
                    R.drawable.flor_03,
                    tipoPlantas[0],
                    eventos[1]
            ),
            new Produto(
                    "Flor 4",
                    8.00d,
                    Produto.EnumCategorias.DiaDaMae,
                    R.drawable.flor_04,
                    tipoPlantas[1],
                    eventos[1]
            ),
            new Produto(
                    "Flor 5",
                    3.00d,
                    Produto.EnumCategorias.DiaDaMae,
                    R.drawable.flor_05,
                    tipoPlantas[0],
                    eventos[2]
            ),
            new Produto(
                    "Flor 6",
                    6.00d,
                    Produto.EnumCategorias.DiaDaMae,
                    R.drawable.flor_06,
                    tipoPlantas[1],
                    eventos[2]
            ),
            new Produto(
                    "Flor 7",
                    11.00d,
                    Produto.EnumCategorias.MaisVendidas,
                    R.drawable.flor_07,
                    tipoPlantas[0],
                    eventos[3]
            ),
            new Produto(
                    "Flor 8",
                    4.00d,
                    Produto.EnumCategorias.MaisVendidas,
                    R.drawable.flor_08,
                    tipoPlantas[1],
                    eventos[3]
            ),
            new Produto(
                    "Flor 9",
                    7.00d,
                    Produto.EnumCategorias.MaisVendidas,
                    R.drawable.flor_09,
                    tipoPlantas[0],
                    eventos[4]
            ),
    };
}
