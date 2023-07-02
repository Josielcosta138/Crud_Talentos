import model.Login;
import modelController.ProcessosGerais;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Login.exibirTelaLogin();
        ProcessosGerais.chamaMenuPrincipal();
    }

}




