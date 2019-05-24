package intro.multiecras.flowerpower;

public class DadosConta {

    public final boolean isLoggedIn;
    public final String username;
    public final String email;

    public DadosConta(boolean isLoggedIn, String username, String email) {
        this.isLoggedIn = isLoggedIn;
        this.username = username;
        this.email = email;
    }
}
