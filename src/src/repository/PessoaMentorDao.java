package repository;

import model.PessoaMentor;
import modelController.Cadastros;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;



public class PessoaMentorDao {

    static List<PessoaMentor> pessoaMentorList = new ArrayList<>();

    public static void salvarPessoaMentor(PessoaMentor pessoaMentor) {
        pessoaMentorList.add(pessoaMentor);
    }

    public static List<PessoaMentor> buscarTodasPessoasMentor() {
        return pessoaMentorList;
    }


    public static List<PessoaMentor> buscarPorNome(String nome){
        List<PessoaMentor> pessoaMentorFiltradas = new ArrayList<>();
        for (PessoaMentor pessoaMentor : pessoaMentorList){
            if (pessoaMentor.getNome().contains(nome)){
                pessoaMentorFiltradas.add(pessoaMentor);
            }
        }
        return pessoaMentorFiltradas;
    }

    public static void alterarPessoaMentoria(PessoaMentor pessoaMentor) {


        Object[] selectionValues = PessoaMentorDao.ListaDeNomesDeMentores();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o mentor!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<PessoaMentor> pessoaMentors = PessoaMentorDao.buscarPorNome((String) selection);

        //pessoaTalento.getNome().contains(selection.toString());
        String nome = JOptionPane.showInputDialog(null, "Informe novo nome." , pessoaMentors.get(0).getNome());
        if (nome == null || nome.isEmpty()) {
            Cadastros.chamaMenuPrincipal();
        } else {
            pessoaMentors.get(0).setNome(nome);
            JOptionPane.showMessageDialog(null, "Mentor alterado com sucesso!");
            Cadastros.chamaMenuPrincipal();
        }

    }


    public static void excluirPessoasMentor(PessoaMentor pessoaMentor) {
        pessoaMentorList.remove(pessoaMentor);
        JOptionPane.showMessageDialog(null, "Mentor removido com sucesso!");
    }




    public static Object[] ListaDeNomesDeMentores() {   //Lista de Nomes
        List<PessoaMentor> pessoaMentors = buscarTodasPessoasMentor();
        List<String> mentoresNomes = new ArrayList<>();
        for (PessoaMentor pessoaMentor : pessoaMentors) {
            mentoresNomes.add(pessoaMentor.getNome());
        }
        return mentoresNomes.toArray();
    }
}