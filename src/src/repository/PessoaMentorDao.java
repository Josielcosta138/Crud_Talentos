package repository;

import bancoDeDados.PessoaMentorRepository;
import model.EnumSexo;
import model.EnumtipoAreaAtuacao;
import model.PessoaMentor;
import modelController.ProcessosGerais;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PessoaMentorDao {

    static List<PessoaMentor> pessoaMentorList = new ArrayList<>();

    public static void salvarPessoaMentor(PessoaMentor pessoaMentor) {
        pessoaMentorList.add(pessoaMentor);
    }

    public static void salvarBanco(PessoaMentor pessoaMentor) throws SQLException, ClassNotFoundException {
        PessoaMentorRepository repository = new PessoaMentorRepository();
        repository.insere(pessoaMentor);


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

    public static void alterarPessoaMentoria(PessoaMentor pessoaMentor) throws SQLException, ClassNotFoundException {


        Object[] selectionValues = PessoaMentorDao.ListaDeNomesDeMentores();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o mentor!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<PessoaMentor> pessoaMentors = PessoaMentorDao.buscarPorNome((String) selection);

        String nome = JOptionPane.showInputDialog(null, "Informe novo nome." , pessoaMentors.get(0).getNome());
        if (nome == null || nome.isEmpty()) {
            ProcessosGerais.chamaMenuPrincipal();
        } else {
            pessoaMentors.get(0).setNome(nome);
        }
        int idade = 0;
        try {
            idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe nova idade: ", pessoaMentors.get(0).getIdade()));
        } catch (NumberFormatException e) {
            ProcessosGerais.chamaMenuPrincipal();
        }
        String cidade = JOptionPane.showInputDialog(null, "Informe nova cidade." , pessoaMentors.get(0).getCidade());
        if (cidade == null || cidade.isEmpty()) {
            ProcessosGerais.chamaMenuPrincipal();
        } else {
            pessoaMentors.get(0).setCidade(cidade);
        }


        String historicoMent = JOptionPane.showInputDialog(null, "Informe novo histórico de mentoria: ", pessoaMentors.get(0).getHistorioDeMentorias());
        if (historicoMent == null || historicoMent.isEmpty() ) {
            ProcessosGerais.chamaMenuPrincipal();
        }else {
            pessoaMentors.get(0).setHistorioDeMentorias(historicoMent);
        }

        EnumSexo pessoaTalento = EnumSexo.MASCULINO;
        Object[] selectionStatusSexo = {"MASCULINO", "FEMININO", "OUTROS"};
        String initialSelectionStatusSexo = pessoaTalento.toString();
        Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione seu sexo:",
                "Lista de Sexo", JOptionPane.QUESTION_MESSAGE, null, selectionStatusSexo, initialSelectionStatusSexo);
        if (selectionStatus == null) {
            ProcessosGerais.chamaMenuPrincipal();
        }
        EnumSexo sexo = EnumSexo.MASCULINO;
        if (selectionStatus.equals("FEMININO")) {
            sexo = EnumSexo.FEMININO;
            pessoaMentors.get(0).setEnumSexo(sexo);
        } else if (selectionStatus.equals("OUTROS")) {
            sexo = EnumSexo.OUTROS;
            pessoaMentors.get(0).setEnumSexo(sexo);
        }


        JOptionPane.showMessageDialog(null,"Dados alterados com sucesso!");
        ProcessosGerais.chamaMenuPrincipal();
    }

    public static void excluirPessoasMentor(PessoaMentor pessoaMentor) throws SQLException, ClassNotFoundException {

        Object[] selectionValues = PessoaMentorDao.ListaDeNomesDeMentores();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o mentor para remover!",
                "Processo - exclusão", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

        if (selection != null) {
            String selectedMentor = (String) selection;
            List<PessoaMentor> pessoaMentors = PessoaMentorDao.buscarPorNome(selectedMentor);
            for (PessoaMentor mentor : pessoaMentors) {
                pessoaMentorList.remove(mentor);
                ProcessosGerais.chamaMenuPrincipal();
                break;
            }
        }
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