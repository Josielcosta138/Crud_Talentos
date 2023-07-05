package model;

import modelController.ProcessosGerais;
import repository.UsuarioDao;

import javax.swing.*;
import java.sql.SQLException;
import model.EnumtipoAreaAtuacao;

import static modelController.ProcessosGerais.chamaMenuPrincipal;

public class Login {

    public static void exibirTelaLogin() throws SQLException, ClassNotFoundException {
            
        String[] nomesMentores = {"Mentor 1", "Mentor 2", "Mentor 3"};

        JComboBox<String> nomesMentoresComboBox = new JComboBox<>(nomesMentores);
        JPasswordField passwordField = new JPasswordField();

        Object[] loginMessage = {
                "Usuario do Mentor:", nomesMentoresComboBox,
                "Senha:", passwordField
        };

        int loginOption = JOptionPane.showConfirmDialog(null, loginMessage,
                "Tela de Login - Mentor", JOptionPane.OK_CANCEL_OPTION);

        if (loginOption == JOptionPane.OK_OPTION) {
            String nomeMentor = (String) nomesMentoresComboBox.getSelectedItem();
            String password = new String(passwordField.getPassword());

            if (verificarCredenciais(nomeMentor, password)) {
                ProcessosGerais.chamaMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Credenciais inválidas. Tente novamente.", "Erro de login", JOptionPane.ERROR_MESSAGE);
                exibirTelaLogin();
            }
        } else {
            System.exit(0);
        }
    }
    public static boolean verificarCredenciais(String nomesMentores, String password) {

        return password.equals("123");
    }
}