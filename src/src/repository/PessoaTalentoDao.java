package repository;

import model.PessoaTalento;
import modelController.Cadastros;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;



public class PessoaTalentoDao {

    static List<PessoaTalento> pessoaTalentoList = new ArrayList<>();

    public static void salvarPessoaTalento(PessoaTalento pessoaTalento) {
        pessoaTalentoList.add(pessoaTalento);
    }

    public static List<PessoaTalento> buscarTodasPessoasTalento() {
        return pessoaTalentoList;
    }


    public static List<PessoaTalento> buscarPorNome(String nome){
        List<PessoaTalento> pessoaTalentosFiltradas = new ArrayList<>();
        for (PessoaTalento pessoaTalento: pessoaTalentoList){
            if (pessoaTalento.getNome().contains(nome)){
                pessoaTalentosFiltradas.add(pessoaTalento);
            }
        }
        return pessoaTalentosFiltradas;
    }

    public static void alterarPessoaMentoria(PessoaTalento pessoaTalento) {


        Object[] selectionValues = PessoaTalentoDao.ListaDeNomesDeMentores();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o mentor!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<PessoaTalento> pessoaTalentos = PessoaTalentoDao.buscarPorNome((String) selection);

        //pessoaTalento.getNome().contains(selection.toString());
        String nome = JOptionPane.showInputDialog(null, "Informe novo nome." , pessoaTalentos.get(0).getNome());
        if (nome == null || nome.isEmpty()) {
            Cadastros.chamaMenuPrincipal();
        } else {
            pessoaTalentos.get(0).setNome(nome);
            JOptionPane.showMessageDialog(null, "Mentor alterado com sucesso!");
            Cadastros.chamaMenuPrincipal();
        }

    }


    public static void excluirPessoasTalento(PessoaTalento pessoaTalento) {
        pessoaTalentoList.remove(pessoaTalento);
        JOptionPane.showMessageDialog(null, "Mentor removido com sucesso!");
    }




    public static Object[] ListaDeNomesDeMentores() {   //Lista de Nomes
        List<PessoaTalento> pessoaTalentos = buscarTodasPessoasTalento();
        List<String> mentoresNomes = new ArrayList<>();
        for (PessoaTalento pessoaTalento : pessoaTalentos) {
            mentoresNomes.add(pessoaTalento.getNome());
        }
        return mentoresNomes.toArray();
    }
}