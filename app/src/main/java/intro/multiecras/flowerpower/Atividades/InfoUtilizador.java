package intro.multiecras.flowerpower.Atividades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class InfoUtilizador {
    public int id;
    public String username;
    public String email;
    public String nTelemovel;
    public long dataNascimento;
    public String password;

    public InfoUtilizador(String username, String email, String nTelemovel, long dataNascimento, String password) {
        this.username = username;
        this.email = email;
        this.nTelemovel = nTelemovel;
        this.dataNascimento = dataNascimento;
        this.password = password;
    }
}


