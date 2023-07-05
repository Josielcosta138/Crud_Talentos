package model;

import modelController.ProcessosGerais;
import repository.UsuarioDao;

import javax.swing.*;
import java.sql.SQLException;

public class Login {

    public static void exibirTelaLogin() throws SQLException, ClassNotFoundException {
        Object[] nomesMentores = UsuarioDao.findUsuariosSistemaInArray();

        JComboBox<Object> nomesMentoresComboBox = new JComboBox<>(nomesMentores);
        JPasswordField passwordField = new JPasswordField();

        Object[] loginMessage = {
                "Usuário do Mentor:", nomesMentoresComboBox,
                "Senha:", passwordField
        };

        int loginOption = JOptionPane.showConfirmDialog(null, loginMessage,
                "Tela de Login - Mentor", JOptionPane.OK_CANCEL_OPTION);

        if (loginOption == JOptionPane.OK_OPTION) {
            Object nomeMentor = nomesMentoresComboBox.getSelectedItem();
            String password = new String(passwordField.getPassword());

            if (verificarCredenciais(nomeMentor, password)) {
                Login.verificarCredenciais(nomeMentor, password);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Credenciais inválidas. Tente novamente.", "Erro de login", JOptionPane.ERROR_MESSAGE);
                exibirTelaLogin();
            }
        } else if (loginOption == JOptionPane.CANCEL_OPTION) {
            int opcaoSair = JOptionPane.showOptionDialog(null,
                    "Você está cancelando o login. Deseja realmente sair?",
                    "Confirmação", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (opcaoSair == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                exibirTelaLogin();
            }
        } else {
            System.exit(0);
        }
    }


    public static boolean verificarCredenciais(Object nomeMentor, String password) {
        try {
            String nomeMentorStr = nomeMentor.toString();
            Usuario usuario = UsuarioDao.findUsuarioByLogin(nomeMentorStr);

            if (usuario != null && usuario.getSenha().equals(password)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
