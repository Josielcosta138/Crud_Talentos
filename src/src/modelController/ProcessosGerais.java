package modelController;
import model.*;
import repository.PessoaMentorDao;
import sun.applet.Main;
import tableForm.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;


public class ProcessosGerais {
    public static void exibirMensagemBoasVindas(){
        JOptionPane.showOptionDialog(null, "Bem vindo a Plataforma de Mentoria!",
                "Mensagem de Boas-vindas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"Entrar"}, "Entrar");
    }
    public static void chamaMenuPrincipal() throws SQLException, ClassNotFoundException {

        String[] opcoesMenu = {"Cadastro de Mentoria", "Processos", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

        switch (opcao){
            case 0: //Cadastro de mentoria
                chamaCadastroMentoria();
                //PessoaMentor pessoaMentor = chamaCadastroMentoria();
                //getPessoaMentorDao().salvarBanco(pessoaMentor);
                break;
            case 1:  //Processos
                chamaMenuProcessos();
                break;
            case 2: //Relatorios
                chamaRelatorios();
                break;
            case 3:
                int opcaoSair = JOptionPane.showOptionDialog(null, "Deseja realmente sair ?",
                        "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (opcaoSair == JOptionPane.YES_NO_OPTION){
                    //System.exit(0);
                    Login.exibirTelaLogin();
                } else {
                    chamaMenuPrincipal();
                }
        }
    }

    private static PessoaMentor chamaCadastroMentoria () throws SQLException, ClassNotFoundException {

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

        PessoaMentor pessoaMentor1 = new PessoaMentor(atuacao, nome, sexo, idade, cidade, estado, email, linkdin, especialidade, historicoDeMent,startup1);
        PessoaMentorDao.salvarPessoaMentor(pessoaMentor1);



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



        //PessoaMentor pessoaMentor = chamaCadastroMentoria();
        //PessoaMentorDao.salvarBanco(pessoaMentor);

        //chamaMenuPrincipal();
        return pessoaMentor1;
    }

    private static void chamaRelatorios() throws SQLException, ClassNotFoundException {
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

    private static void chamaMenuProcessos() throws SQLException, ClassNotFoundException {

        String[] opcoesMenuProcessos = {"Alterar", "Excluir", "Buscar todos", "Buscar por nome"};
        int menuProcessos = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                "Menu processos Mentaria", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuProcessos, opcoesMenuProcessos[0]);
        List<PessoaMentor> pessoaTalentos1 = PessoaMentorDao.buscarTodasPessoasMentor();


        switch (menuProcessos){
            case 0: //Alterar
                PessoaMentorDao.alterarPessoaMentoria(pessoaTalentos1.get(0));
                break;
            case 1: //Remover
                PessoaMentorDao.excluirPessoasMentor(pessoaTalentos1.get(0));
                break;
            case 2: //Voltar
                chamaMenuPrincipal();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static PessoaMentorDao getPessoaMentorDao() {
        PessoaMentorDao pessoaMentorDao = new PessoaMentorDao();
        return pessoaMentorDao;
    }


    private static void chamaRelatoriosPessoasTalentos() throws SQLException, ClassNotFoundException {
        List<PessoaMentor> pessoaMentors = PessoaMentorDao.buscarTodasPessoasMentor();

        if (pessoaMentors.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lista Pessoa Talento esta Vazia!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            chamaMenuPrincipal();
        } else {
            RelatorioMentorForm.emitirRelatorio(pessoaMentors);
        }
    }
}
