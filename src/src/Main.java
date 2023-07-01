import repository.*;
import model.*;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        chamaMenuPrincipal();
    }

    protected static void chamaMenuPrincipal(){
        String[] opcoesMenu = {"Cadastro de Mentoria", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

        switch (opcao){
            case 0: //Cadastro de mentoria
                chamaCadastroMentoria();
                break;
            case 1: //Relatorios
                chamaRelatorios();
                break;
            case 2:
                int opcaoSair = JOptionPane.showOptionDialog(null, "Deseja realmente sair ?",
                        "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    if (opcaoSair == JOptionPane.YES_NO_OPTION){
        System.exit(0);
    }else {
        chamaMenuPrincipal();
    }
    }}

        private static void chamaCadastroMentoria () {

            String nome = JOptionPane.showInputDialog(null, "Informe o seu nome: ");
            if (nome == null || nome.isEmpty() ) {
                chamaMenuPrincipal();
            }
            int idade = 0;
            try {
                idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe sua idade: "));
            } catch (NumberFormatException e) {
                chamaMenuPrincipal();
            }

            String cidade = JOptionPane.showInputDialog(null, "Informe sua cidade: ");
            if (cidade == null || cidade.isEmpty() ) {
                chamaMenuPrincipal();
            }
            String estado = JOptionPane.showInputDialog(null, "Informe seu estado: ");
            if (estado == null || estado.isEmpty()) {
                chamaMenuPrincipal();
            }
            String email = JOptionPane.showInputDialog(null, "Informe seu e-mail: ");
            if (email == null || email.isEmpty() ) {
                chamaMenuPrincipal();
            }
            String linkdin = JOptionPane.showInputDialog(null, "Informe seu linkedin: ");
            if (linkdin == null || linkdin.isEmpty() ) {
                chamaMenuPrincipal();
            }
            String especialidade = JOptionPane.showInputDialog(null, "Informe sua especialidade: ");
            if (especialidade == null || especialidade.isEmpty() ) {
                chamaMenuPrincipal();
            }
            String historicoDeMent = JOptionPane.showInputDialog(null, "Informe o histórico de mentoria: ");
            if (historicoDeMent == null || historicoDeMent.isEmpty() ) {
                chamaMenuPrincipal();
            }


            EnumSexo pessoaTalento = EnumSexo.MASCULINO;
            Object[] selectionStatusSexo = {"MASCULINO", "FEMININO", "OUTROS"};
            String initialSelectionStatusSexo = pessoaTalento.toString();
            Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione seu sexo:",
                    "Lista de Sexo", JOptionPane.QUESTION_MESSAGE, null, selectionStatusSexo, initialSelectionStatusSexo);
            if (selectionStatus == null) {
                chamaMenuPrincipal();
            }
            EnumSexo sexo = EnumSexo.MASCULINO;
            if (selectionStatus.equals("FEMININO")) {
                sexo = EnumSexo.FEMININO;
            } else if (selectionStatus.equals("OUTROS")) {
                sexo = EnumSexo.OUTROS;
            }

            EnumStartup startup = EnumStartup.INNOVATETECH;
            Object[] selectionStatusStartup = {"INNOVATETECH", "TECHLAB", "DIGITALLABS", "CONNECTX", "NEXUSTECH"};
            String initialSelectionStatusStartup = pessoaTalento.toString();
            Object selectionStatusStartup2 = JOptionPane.showInputDialog(null, "Selecione seu sexo:",
                    "Lista de Sexo", JOptionPane.QUESTION_MESSAGE, null, selectionStatusStartup, initialSelectionStatusStartup);
            if (selectionStatusStartup2 == null) {
                chamaMenuPrincipal();
            }
            EnumStartup startup1 = EnumStartup.INNOVATETECH;
            if (selectionStatusStartup2.equals("TECHLAB")) {
                startup1 = EnumStartup.TECHLAB;
            } if (selectionStatusStartup2.equals("DIGITALLABS")) {
                startup1 = EnumStartup.DIGITALLABS;
            } if (selectionStatusStartup2.equals("CONNECTX")) {
                startup1 = EnumStartup.CONNECTX;
            } if (selectionStatusStartup2.equals("DIGITALLABS")) {
                startup1 = EnumStartup.DIGITALLABS;
            }if (selectionStatusStartup2.equals("DIGITALLABS")) {
                startup1 = EnumStartup.NEXUSTECH;
            }


            EnumtipoAreaAtuacao pessoaTalentoAtuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
            Object[] selectionStatusAtuacao = {"ANALISTA DE SISTEMAS", "MARKETING", "DIREITO EMPRESARIAL", "GESTAO FINANCEIRA", "MENTOR EM INOVAÇÃO",
                    "EDUCAÇÃO PARA MIDIAS", "QA", "DESENVOLVEDOR BACK-END", "DESENVOLVEDOR FRONT-END", "ANALISTA DE NEGOCIO", "PO", "SCRUM MASTER"};
            String initialSelectionStatusAtuacao = pessoaTalentoAtuacao.toString();
            Object selectionStatus2 = JOptionPane.showInputDialog(null, "Selecione sua Área de Atuação.",
                    "Lista de Especialidades", JOptionPane.QUESTION_MESSAGE, null, selectionStatusAtuacao, initialSelectionStatusAtuacao);
            if (selectionStatus2 == null) {
                chamaMenuPrincipal();
            }
            EnumtipoAreaAtuacao atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
            if (selectionStatus2.equals("MARKETING")) {
                atuacao = EnumtipoAreaAtuacao.MARKTING;
            } else if (selectionStatus2.equals("DIREITO EMPRESARIAL")) {
                atuacao = EnumtipoAreaAtuacao.DIREITO_EMPRESARIAL;
            } else if (selectionStatus2.equals("DIREITO EMPRESARIAL")) {
                atuacao = EnumtipoAreaAtuacao.DIREITO_EMPRESARIAL;
            } else if (selectionStatus2.equals("GESTAO FINANCEIRA")) {
                atuacao = EnumtipoAreaAtuacao.GESTAO_FINANCEIRA;
            } else if (selectionStatus2.equals("MENTOR EM INOVACAO")) {
                atuacao = EnumtipoAreaAtuacao.MENTOR_EM_INOVACAO;
            } else if (selectionStatus2.equals("EDUCAOÇÃO PARA MIDIAS")) {
                atuacao = EnumtipoAreaAtuacao.EDUCAO_PARA_MIDIAS;
            } else if (selectionStatus2.equals("QA")) {
                atuacao = EnumtipoAreaAtuacao.QA;
            } else if (selectionStatus2.equals("DESENVOLVEDO BACK-END")) {
                atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_BACKEND;
            } else if (selectionStatus2.equals("DESENVOLVEDOR FRONT-END")) {
                atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_FRONTEND;
            } else if (selectionStatus2.equals("ANALISTA DE NEGOCIO")) {
                atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_NEGOCIO;
            } else if (selectionStatus2.equals("PO")) {
                atuacao = EnumtipoAreaAtuacao.PO;
            } else if (selectionStatus2.equals("SCRUMMASTER")) {
                atuacao = EnumtipoAreaAtuacao.SCRUMMASTER;
            }

            PessoaTalento pessoaTalento1 = new PessoaTalento(atuacao, nome, sexo, idade, cidade, estado, email, linkdin, especialidade, historicoDeMent,startup1);
            PessoaTalentoDao.salvarPessoaTalento(pessoaTalento1);

            StringBuilder relatorio = new StringBuilder();
            relatorio.append(("Nome ")).append(nome).append("\n");
            relatorio.append(("Idade ")).append(idade).append("\n");
            relatorio.append(("Sexo ")).append(sexo).append("\n");
            relatorio.append(("E-mail")).append(email).append("\n");
            relatorio.append(("Linkedin ")).append(linkdin).append("\n");
            relatorio.append(("Cidade ")).append(cidade).append("\n");
            relatorio.append(("Estado ")).append(estado).append("\n");
            relatorio.append(("Especialidade ")).append(especialidade).append("\n");
            relatorio.append(("Histórico de mentorias ")).append(historicoDeMent).append("\n");
            relatorio.append(("Atuação ")).append(atuacao).append("\n");
            relatorio.append(("Atuação ")).append(startup1).append("\n");

            JOptionPane.showMessageDialog(null, relatorio.toString(), "Relatório Mentor", JOptionPane.INFORMATION_MESSAGE);

            chamaMenuPrincipal();

        }

        private static void chamaRelatorios(){
            String[] opcoesMenuRelatorios = {"Talentos", "Voltar"};
            int menuRelatorios = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                    "Menu Relatórios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuRelatorios, opcoesMenuRelatorios[0]);

            switch (menuRelatorios){
                case 0: //Pessoas Talentos
                    chamaRelatoriosPessoasTalentos();
                    break;
                case 1: //Voltar 
                    chamaMenuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
    }
        

private static void chamaRelatoriosPessoasTalentos(){
    List<PessoaTalento> pessoaTalentos = PessoaTalentoDao.buscarTodasPessoasTalento();
    RelatorioPessoaTalentoForm.emitirRelatorio(pessoaTalentos);

}


}


