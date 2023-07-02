import model.*;
import modelController.ProcessosGerais;
import repository.*;

import javax.swing.*;
import java.sql.SQLException;

import static modelController.ProcessosGerais.chamaMenuPrincipal;
import static modelController.ProcessosGerais.exibirMensagemBoasVindas;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        Login.exibirTelaLogin();
        exibirMensagemBoasVindas();
        ProcessosGerais.chamaMenuPrincipal();
    }


}




