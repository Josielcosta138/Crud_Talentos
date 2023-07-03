package model;
import modelController.ProcessosGerais;
import repository.UsuarioDao;

import javax.swing.*;
import java.sql.SQLException;

import static modelController.ProcessosGerais.chamaMenuPrincipal;

public class Login {

    public static void exibirTelaLogin() throws SQLException, ClassNotFoundException {
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);
    }

    private static Object chamaSelecaoUsuario() {
        Object[] selectionValues = {"Mentor", "Startup"};
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o usuário:",
                "Tela de Login", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

        if (selection == null) {
            int opcaoSair = JOptionPane.showOptionDialog(null, "Você está cancelando o login. Deseja realmente sair?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoSair == JOptionPane.YES_OPTION)
                System.exit(0);
            return chamaSelecaoUsuario();
        }

        return selection;
    }

    private static void checaSenhaUsuario(Object usuarioLogado) throws SQLException, ClassNotFoundException {
        String senhaCorreta = "123";

        String senhaDigitada = JOptionPane.showInputDialog(null, "Informe a senha do usuário:");

        if (senhaDigitada == null) {
            Object usuarioSelecionado = chamaSelecaoUsuario();
            checaSenhaUsuario(usuarioSelecionado);
            return;
        }

        if (senhaDigitada.equals(senhaCorreta)) {
            chamaMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta! Digite novamente.");
            checaSenhaUsuario(usuarioLogado);
        }
    }}