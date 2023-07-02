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
        exibirMensagemBoasVindas();
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);
        ProcessosGerais.chamaMenuPrincipal();
    }
    private static void checaSenhaUsuario(Object usuarioLogado) throws SQLException, ClassNotFoundException {
        String senhaDigitada = JOptionPane.showInputDialog(null,
                "Informe a senha do usuário: ");
        Usuario usuarioByLogin = UsuarioDao.findUsuarioByLogin((String) usuarioLogado);

        if (usuarioByLogin.getSenha().equals(senhaDigitada)) {
            chamaMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta! Digite novamente: ");
            checaSenhaUsuario(usuarioLogado);
        }
    }
    private static Object chamaSelecaoUsuario() {
        Object[] selectionValues = UsuarioDao.findUsuariosSistemaInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o usuário: ",
                "Tela de Login", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        return selection;
    }
}




