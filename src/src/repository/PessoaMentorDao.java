package repository;

import bancoDeDados.PessoaMentorRepository;
import model.EnumSexo;
import model.EnumStartup;
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
        String estado = JOptionPane.showInputDialog(null, "Informe novo estado: ", pessoaMentors.get(0).getEstado());
        if (estado == null || estado.isEmpty()) {
            ProcessosGerais.chamaMenuPrincipal();
        }else {
            pessoaMentors.get(0).setEstado(estado);
        }
        String email = JOptionPane.showInputDialog(null, "Informe novo e-mail: ", pessoaMentors.get(0).getEmail());
        if (email == null || email.isEmpty() ) {
            ProcessosGerais.chamaMenuPrincipal();
        }else {
            pessoaMentors.get(0).setEmail(email);
        }
        String linkdin = JOptionPane.showInputDialog(null, "Informe novo linkedin: ", pessoaMentors.get(0).getLinkdin());
        if (linkdin == null || linkdin.isEmpty() ) {
            ProcessosGerais.chamaMenuPrincipal();
        }else {
            pessoaMentors.get(0).setLinkdin(linkdin);
        }
        String especialidade = JOptionPane.showInputDialog(null, "Informe nova especialidade: ", pessoaMentors.get(0).getEspecialidade());
        if (especialidade == null || especialidade.isEmpty() ) {
            ProcessosGerais.chamaMenuPrincipal();
        }else {
            pessoaMentors.get(0).setEspecialidade(especialidade);
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

        EnumStartup startup = EnumStartup.INNOVATETECH;
        Object[] selectionStatusStartup = {"INNOVATETECH", "TECHLAB", "DIGITALLABS", "CONNECTX", "NEXUSTECH"};
        String initialSelectionStatusStartup = pessoaTalento.toString();
        Object selectionStatusStartup2 = JOptionPane.showInputDialog(null, "Selecione startup:",
                "Lista de Startup", JOptionPane.QUESTION_MESSAGE, null, selectionStatusStartup, initialSelectionStatusStartup);
        if (selectionStatusStartup2 == null) {
            ProcessosGerais.chamaMenuPrincipal();
        }
        EnumStartup startup1 = EnumStartup.INNOVATETECH;
        if (selectionStatusStartup2.equals("TECHLAB")) {
            startup1 = EnumStartup.TECHLAB;
            pessoaMentors.get(0).setEnumStartup(startup1);
        } if (selectionStatusStartup2.equals("DIGITALLABS")) {
            startup1 = EnumStartup.DIGITALLABS;
            pessoaMentors.get(0).setEnumStartup(startup1);
        } if (selectionStatusStartup2.equals("CONNECTX")) {
            startup1 = EnumStartup.CONNECTX;
            pessoaMentors.get(0).setEnumStartup(startup1);
        } if (selectionStatusStartup2.equals("DIGITALLABS")) {
            startup1 = EnumStartup.DIGITALLABS;
            pessoaMentors.get(0).setEnumStartup(startup1);
        }if (selectionStatusStartup2.equals("DIGITALLABS")) {
            startup1 = EnumStartup.NEXUSTECH;
            pessoaMentors.get(0).setEnumStartup(startup1);
        }

        EnumtipoAreaAtuacao pessoaTalentoAtuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
        Object[] selectionStatusAtuacao = {"ANALISTA DE SISTEMAS", "MARKETING", "DIREITO EMPRESARIAL", "GESTAO FINANCEIRA", "MENTOR EM INOVAÇÃO",
                "EDUCAÇÃO PARA MIDIAS", "QA", "DESENVOLVEDOR BACK-END", "DESENVOLVEDOR FRONT-END", "ANALISTA DE NEGOCIO", "PO", "SCRUM MASTER"};
        String initialSelectionStatusAtuacao = pessoaTalentoAtuacao.toString();
        Object selectionStatus2 = JOptionPane.showInputDialog(null, "Selecione sua Área de Atuação.",
                "Lista de Especialidades", JOptionPane.QUESTION_MESSAGE, null, selectionStatusAtuacao, initialSelectionStatusAtuacao);
        if (selectionStatus2 == null) {
            ProcessosGerais.chamaMenuPrincipal();
        }
        EnumtipoAreaAtuacao atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
        if (selectionStatus2.equals("MARKETING")) {
            atuacao = EnumtipoAreaAtuacao.MARKTING;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("DIREITO EMPRESARIAL")) {
            atuacao = EnumtipoAreaAtuacao.DIREITO_EMPRESARIAL;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("DIREITO EMPRESARIAL")) {
            atuacao = EnumtipoAreaAtuacao.DIREITO_EMPRESARIAL;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("GESTAO FINANCEIRA")) {
            atuacao = EnumtipoAreaAtuacao.GESTAO_FINANCEIRA;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("MENTOR EM INOVACAO")) {
            atuacao = EnumtipoAreaAtuacao.MENTOR_EM_INOVACAO;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("EDUCAOÇÃO PARA MIDIAS")) {
            atuacao = EnumtipoAreaAtuacao.EDUCAO_PARA_MIDIAS;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("QA")) {
            atuacao = EnumtipoAreaAtuacao.QA;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("DESENVOLVEDO BACK-END")) {
            atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_BACKEND;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("DESENVOLVEDOR FRONT-END")) {
            atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_FRONTEND;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("ANALISTA DE NEGOCIO")) {
            atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_NEGOCIO;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("PO")) {
            atuacao = EnumtipoAreaAtuacao.PO;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
        } else if (selectionStatus2.equals("SCRUMMASTER")) {
            atuacao = EnumtipoAreaAtuacao.SCRUMMASTER;
            pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
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