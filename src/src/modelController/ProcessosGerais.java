package modelController;
import model.*;
import repository.PessoaMentorDao;
import sun.applet.Main;
import tableForm.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProcessosGerais {
    public static void exibirMensagemBoasVindas() {
        JOptionPane.showOptionDialog(null, "Bem vindo a Plataforma de Mentoria!",
                "Mensagem de Boas-vindas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"Entrar"}, "Entrar");
    }

    public static void chamaMenuPrincipal() throws SQLException, ClassNotFoundException {

        String[] opcoesMenu = {"Cadastro de Mentoria", "Processos", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

        switch (opcao) {
            case 0: //Cadastro de mentoria
                chamaCadastroMentoria();
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
                if (opcaoSair == JOptionPane.YES_NO_OPTION) {
                    //System.exit(0);
                    Login.exibirTelaLogin();
                } else {
                    chamaMenuPrincipal();
                }
        }
    }

    private static PessoaMentor chamaCadastroMentoria() throws SQLException, ClassNotFoundException {

        String nome = JOptionPane.showInputDialog(null, "Informe o seu nome: ");
        if (nome == null || nome.isEmpty()) {
            chamaMenuPrincipal();
        }
        int idade = 0;
        try {
            idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe sua idade: "));
        } catch (NumberFormatException e) {
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

        EnumEstado enumEstado = EnumEstado.SC;
        Object[] selectionStatusEstado = {"SC", "PR", "RS"};
        String initialSelectionStatusEstado = enumEstado.toString();
        Object selectionStatusEst = JOptionPane.showInputDialog(null, "Selecione o Estado conforme sua cidade:",
                "Lista de Estado", JOptionPane.QUESTION_MESSAGE, null, selectionStatusEstado, initialSelectionStatusEstado);
        if (selectionStatusEst == null) {
            chamaMenuPrincipal();
        }
        EnumEstado estado = EnumEstado.SC;
        if (selectionStatusEst.equals("PR")) {
            estado = EnumEstado.PR;
        } else if (selectionStatusEst.equals("RS")) {
            estado = EnumEstado.RS;
        }


        String cidade = JOptionPane.showInputDialog(null, "Informe sua cidade: ");
        if (cidade == null || cidade.isEmpty()) {
            chamaMenuPrincipal();
        }


        EnumtipoAreaAtuacao enumtipoAreaAtuacao = EnumtipoAreaAtuacao.MARKTING;
        Object[] selectionStatusAreaDeAtuacao = {"MARKTING", "ANALISTA_DE_SISTEMA", "DIREITO_EMPRESARIAL","GESTAO_FINANCEIRA","MENTOR_EM_INOVACAO",
                "EDUCAO_PARA_MIDIAS","QA","DESENVOLVEDOR_BACKEND","DESENVOLVEDOR_FRONTEND","ANALISTA_DE_NEGOCIO","PO","SCRUMMASTER","OUTROS"};
        String initialSelectionStatusAreaDeAtuacao = pessoaTalento.toString();
        Object selectionStatusAre = JOptionPane.showInputDialog(null, "Selecione seu area:",
                "Lista Area de Atuação.", JOptionPane.QUESTION_MESSAGE, null, selectionStatusAreaDeAtuacao, initialSelectionStatusAreaDeAtuacao);
        if (selectionStatusAre == null) {
            chamaMenuPrincipal();
        }
        EnumtipoAreaAtuacao atuacao = EnumtipoAreaAtuacao.MARKTING;
        if (selectionStatusAre.equals("ANALISTA_DE_SISTEMA")) {
            atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
        } else if (selectionStatusAre.equals("DIREITO_EMPRESARIAL")) {
            atuacao = EnumtipoAreaAtuacao.DIREITO_EMPRESARIAL;
        }else if (selectionStatusAre.equals("GESTAO_FINANCEIRA")) {
            atuacao = EnumtipoAreaAtuacao.GESTAO_FINANCEIRA;
        }else if (selectionStatusAre.equals("MENTOR_EM_INOVACAO")) {
            atuacao = EnumtipoAreaAtuacao.MENTOR_EM_INOVACAO;
        }else if (selectionStatusAre.equals("EDUCAO_PARA_MIDIAS")) {
            atuacao = EnumtipoAreaAtuacao.EDUCAO_PARA_MIDIAS;
        }else if (selectionStatusAre.equals("QA")) {
            atuacao = EnumtipoAreaAtuacao.QA;
        }else if (selectionStatusAre.equals("DESENVOLVEDOR_BACKEND")) {
            atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_BACKEND;
        }else if (selectionStatusAre.equals("DESENVOLVEDOR_FRONTEND")) {
            atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_FRONTEND;
        }else if (selectionStatusAre.equals("ANALISTA_DE_NEGOCIO")) {
            atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_NEGOCIO;
        }else if (selectionStatusAre.equals("PO")) {
            atuacao = EnumtipoAreaAtuacao.PO;
        }else if (selectionStatusAre.equals("SCRUMMASTER")) {
            atuacao = EnumtipoAreaAtuacao.SCRUMMASTER;
        }else if (selectionStatusAre.equals("OUTROS")) {
            atuacao = EnumtipoAreaAtuacao.OUTROS;
        }

        //AQUI TERA QUE PERGUNTAR SE DESEJA CADASTRAR MAIS DE UM CONTATO
//        EnumContato enumContato = EnumContato.TELEFONE;
//        Object[] selectionStatusContato = {"TELEFONE", "WHATSAPP", "FACEBOOK" , "INSTAGRAM" , "LINKEDIN" , "TWITTER"};
//        String initialSelectionStatusContato = enumEstado.toString();
//        Object selectionStatusCont = JOptionPane.showInputDialog(null, "Selecione o Contato:",
//                "Lista de Contatos", JOptionPane.QUESTION_MESSAGE, null, selectionStatusContato, initialSelectionStatusContato);
//        if (selectionStatusCont == null) {
//            chamaMenuPrincipal();
//        }
//        EnumContato enumContato1 = EnumContato.TELEFONE;
//        if (selectionStatusCont.equals("WHATSAPP")) {
//            enumContato1 = EnumContato.WHATSAPP;
//        } else if (selectionStatusCont.equals("FACEBOOK")) {
//            enumContato1 = EnumContato.FACEBOOK;
//        } else if (selectionStatusCont.equals("INSTAGRAM")) {
//            enumContato1 = EnumContato.INSTAGRAM;
//        } else if (selectionStatusCont.equals("LINKEDIN")) {
//            enumContato1 = EnumContato.LINKEDIN;
//        } else if (selectionStatusCont.equals("TWITTER")) {
//            enumContato1 = EnumContato.TWITTER;
//        }
        List<EnumContato> contatos = new ArrayList<>();

        boolean cadastrarMaisContatos = true;
        while (cadastrarMaisContatos) {
            EnumContato enumContato = EnumContato.TELEFONE;
            Object[] selectionStatusContato = {"TELEFONE", "WHATSAPP", "FACEBOOK", "INSTAGRAM", "LINKEDIN", "TWITTER"};
            String initialSelectionStatusContato = enumContato.toString();
            Object selectionStatusCont = JOptionPane.showInputDialog(null, "Selecione o Contato:",
                    "Lista de Contatos", JOptionPane.QUESTION_MESSAGE, null, selectionStatusContato, initialSelectionStatusContato);
            if (selectionStatusCont == null) {
                chamaMenuPrincipal();
            }
            EnumContato enumContato1 = EnumContato.TELEFONE;
            if (selectionStatusCont.equals("WHATSAPP")) {
                enumContato1 = EnumContato.WHATSAPP;
            } else if (selectionStatusCont.equals("FACEBOOK")) {
                enumContato1 = EnumContato.FACEBOOK;
            } else if (selectionStatusCont.equals("INSTAGRAM")) {
                enumContato1 = EnumContato.INSTAGRAM;
            } else if (selectionStatusCont.equals("LINKEDIN")) {
                enumContato1 = EnumContato.LINKEDIN;
            } else if (selectionStatusCont.equals("TWITTER")) {
                enumContato1 = EnumContato.TWITTER;
            }

            String descricao = JOptionPane.showInputDialog("Digite a descrição do contato:");
            if (descricao == null || descricao.isEmpty()) {
                chamaMenuPrincipal();
            }

            Contato contato = new Contato(descricao, enumContato1);
            contatos.add(contato.getEnumContato());

            int option = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais contatos?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                cadastrarMaisContatos = false;
            }
        }




        String historicoDeMent = JOptionPane.showInputDialog(null, "Informe o histórico de mentoria: ");
        if (historicoDeMent == null || historicoDeMent.isEmpty()) {
                chamaMenuPrincipal();
        }

        PessoaMentor pessoaMentor1 = new PessoaMentor(nome, idade, sexo, cidade, enumEstado, enumtipoAreaAtuacao, historicoDeMent,  contatos);
        PessoaMentorDao.salvarPessoaMentor(pessoaMentor1);

        StringBuilder relatorio = new StringBuilder();
        relatorio.append(("Nome ")).append(nome).append("\n");
        relatorio.append(("Idade ")).append(idade).append("\n");
        relatorio.append(("Sexo ")).append(sexo).append("\n");
        relatorio.append(("Cidade ")).append(cidade).append("\n");
        relatorio.append(("Estado ")).append(estado).append("\n");
        relatorio.append(("Atuação ")).append(atuacao).append("\n");
        relatorio.append(("Histórico de mentorias ")).append(historicoDeMent).append("\n");
        relatorio.append(("Contato ")).append(contatos).append("\n");



        JOptionPane.showMessageDialog(null, relatorio.toString(), "Relatório Mentor", JOptionPane.INFORMATION_MESSAGE);
            return pessoaMentor1;
        }


        private static void chamaRelatorios () throws SQLException, ClassNotFoundException {
            String[] opcoesMenuRelatorios = {"Talentos", "Voltar"};
            int menuRelatorios = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                    "Menu Relatórios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuRelatorios, opcoesMenuRelatorios[0]);

            switch (menuRelatorios) {
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

        private static void chamaMenuProcessos () throws SQLException, ClassNotFoundException {

            String[] opcoesMenuProcessos = {"Alterar", "Excluir", "Buscar todos", "Buscar por nome"};
            int menuProcessos = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                    "Menu processos Mentaria", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuProcessos, opcoesMenuProcessos[0]);
            List<PessoaMentor> pessoaTalentos1 = PessoaMentorDao.buscarTodasPessoasMentor();


            switch (menuProcessos) {
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

        public static PessoaMentorDao getPessoaMentorDao () {
            PessoaMentorDao pessoaMentorDao = new PessoaMentorDao();
            return pessoaMentorDao;
        }


        private static void chamaRelatoriosPessoasTalentos () throws SQLException, ClassNotFoundException {
            List<PessoaMentor> pessoaMentors = PessoaMentorDao.buscarTodasPessoasMentor();

            if (pessoaMentors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lista Pessoa Talento esta Vazia!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                chamaMenuPrincipal();
            } else {
                RelatorioMentorForm.emitirRelatorio(pessoaMentors);
            }
        }
    }


