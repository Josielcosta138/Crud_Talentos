package modelController;
import model.*;
import repository.PessoaMentorDao;
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

    public static PessoaMentor chamaMenuPrincipal() throws SQLException, ClassNotFoundException {

        String[] opcoesMenu = {"Cadastro de Mentoria", "Processos", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

        switch (opcao) {
            case 0: //Cadastro de mentoria
               // PessoaMentor pessoaMentor = chamaCadastroMentoria();
                //getPessoaMentorDao().salvarBanco(pessoaMentor);
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
            default:
                //JOptionPane.showMessageDialog(null, "Teste");
        }

        return null;
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


        Object[] selectionStatusCidades = {"CRICIUMA", "GUARULHOS", "PORTO ALEGRE"};
        String initialSelectionStatusCidades = pessoaTalento.toString();
        Object selectionStatusCid = JOptionPane.showInputDialog(null, "Selecione a Cidade:",
                "Lista de Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionStatusCidades, initialSelectionStatusCidades);
        if (selectionStatusCid == null) {
            chamaMenuPrincipal();
        }
        EnumCidades cidade = EnumCidades.CIDADE_CRICIUMA;
        if (selectionStatusCid.equals("GUARULHOS")) {
            cidade = EnumCidades.CIDADE_GUARULHOS;
        } else if (selectionStatusCid.equals("PORTO ALEGRE")) {
            cidade = EnumCidades.CIDADE_PORTO_ALEGRE;
        }


        EnumtipoAreaAtuacao enumtipoAreaAtuacao = EnumtipoAreaAtuacao.MARKTING;
        Object[] selectionStatusAreaDeAtuacao = {"MARKETING", "ANALISTA DE SISTEMA", "DIREITO_EMPRESARIAL", "GESTAO FINANCEIRA", "MENTOR EM INOVACAO",
                "EDUCAO PARA MIDIAS", "QA", "DESENVOLVEDOR BACKEND", "DESENVOLVEDOR FRONTEND", "ANALISTA DE NEGOCIO", "PO", "SCRUMMASTER", "OUTROS"};
        String initialSelectionStatusAreaDeAtuacao = pessoaTalento.toString();
        Object selectionStatusAre = JOptionPane.showInputDialog(null, "Selecione seu area:",
                "Lista Area de Atuação.", JOptionPane.QUESTION_MESSAGE, null, selectionStatusAreaDeAtuacao, initialSelectionStatusAreaDeAtuacao);
        if (selectionStatusAre == null) {
            chamaMenuPrincipal();
        }
        EnumtipoAreaAtuacao atuacao = EnumtipoAreaAtuacao.MARKTING;
        if (selectionStatusAre.equals("ANALISTA DE SISTEMA")) {
            atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
        } else if (selectionStatusAre.equals("DIREITO EMPRESARIAL")) {
            atuacao = EnumtipoAreaAtuacao.DIREITO_EMPRESARIAL;
        } else if (selectionStatusAre.equals("GESTAO FINANCEIRA")) {
            atuacao = EnumtipoAreaAtuacao.GESTAO_FINANCEIRA;
        } else if (selectionStatusAre.equals("MENTOR EM INOVACAO")) {
            atuacao = EnumtipoAreaAtuacao.MENTOR_EM_INOVACAO;
        } else if (selectionStatusAre.equals("EDUCAO PARA MIDIAS")) {
            atuacao = EnumtipoAreaAtuacao.EDUCAO_PARA_MIDIAS;
        } else if (selectionStatusAre.equals("QA")) {
            atuacao = EnumtipoAreaAtuacao.QA;
        } else if (selectionStatusAre.equals("DESENVOLVEDOR BACKEND")) {
            atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_BACKEND;
        } else if (selectionStatusAre.equals("DESENVOLVEDOR FRONTEND")) {
            atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_FRONTEND;
        } else if (selectionStatusAre.equals("ANALISTA DE NEGOCIO")) {
            atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_NEGOCIO;
        } else if (selectionStatusAre.equals("PO")) {
            atuacao = EnumtipoAreaAtuacao.PO;
        } else if (selectionStatusAre.equals("SCRUMMASTER")) {
            atuacao = EnumtipoAreaAtuacao.SCRUMMASTER;
        } else if (selectionStatusAre.equals("OUTROS")) {
            atuacao = EnumtipoAreaAtuacao.OUTROS;
        }


        EnumFormacao enumFormacao = EnumFormacao.ENSINO_FUNDAMENTAL;
        Object[] selectionStatusFormacao = {"ENSINO MEDIO", "ENSINO TECNICO", "GRADUACAO", "POS GRADUACAO", "MESTRADO", "DOUTORADO"};
        String initialSelectionStatusFormacao = pessoaTalento.toString();
        Object selectionStatusForm = JOptionPane.showInputDialog(null, "Selecione sua Formação",
                "Lista de formação", JOptionPane.QUESTION_MESSAGE, null, selectionStatusFormacao, initialSelectionStatusFormacao);
        if (selectionStatusForm == null) {
            chamaMenuPrincipal();
        }
        EnumFormacao formacao = EnumFormacao.ENSINO_FUNDAMENTAL;
        if (selectionStatusForm.equals("ENSINO MEDIO")) {
            formacao = EnumFormacao.ENSINO_MEDIO;
        } else if (selectionStatusForm.equals("ENSINO TECNICO")) {
            formacao = EnumFormacao.ENSINO_TECNICO;
        } else if (selectionStatusForm.equals("GRADUACAO")) {
            formacao = EnumFormacao.GRADUACAO;
        } else if (selectionStatusForm.equals("POS GRADUACAO")) {
            formacao = EnumFormacao.POS_GRADUACAO;
        } else if (selectionStatusForm.equals("MESTRADO")) {
            formacao = EnumFormacao.MESTRADO;
        } else if (selectionStatusForm.equals("DOUTORADO")) {
            formacao = EnumFormacao.DOUTORADO;
        }


        List<EnumContato> contatos = new ArrayList<>();


        boolean cadastrarMaisContatos = true;
        String descricaoContato = null;
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

            descricaoContato = JOptionPane.showInputDialog("Digite a descrição do contato:");
            if (descricaoContato == null || descricaoContato.isEmpty()) {
                chamaMenuPrincipal();
            }

            Contato contato = new Contato(descricaoContato, enumContato1);
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

        PessoaMentor pessoaMentor1 = new PessoaMentor(nome, idade, sexo, formacao, cidade, enumtipoAreaAtuacao, historicoDeMent,  contatos, descricaoContato);
        PessoaMentorDao.salvarPessoaMentor(pessoaMentor1);
      //  PessoaMentorDao.salvarBanco(pessoaMentor1);
        return chamaMenuPrincipal();
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

            String[] opcoesMenuProcessos = {"Alterar", "Excluir", "Buscar todos", "Buscar por nome", "Voltar"};
            int menuProcessos = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                    "Menu processos Mentaria", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuProcessos, opcoesMenuProcessos[0]);
            List<PessoaMentor> pessoaTalentos1 = PessoaMentorDao.buscarTodasPessoasMentor();


            switch (menuProcessos) {
                case 0: //Alterar
                    List<PessoaMentor> pessoaMentors = PessoaMentorDao.buscarTodasPessoasMentor();
                    if (pessoaMentors.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Lista Pessoa Talento esta Vazia!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        chamaMenuPrincipal();
                    } else {
                        PessoaMentorDao.alterarPessoaMentoria(pessoaTalentos1.get(0));
                    }



                    break;
                case 1: //Remover
                    List<PessoaMentor> pessoaMentors1 = PessoaMentorDao.buscarTodasPessoasMentor();
                    if (pessoaMentors1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Lista Pessoa Talento esta Vazia!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        chamaMenuPrincipal();
                    } else {
                        PessoaMentorDao.excluirPessoasMentor(pessoaTalentos1.get(0));
                    }

                    break;
                case 2: // Buscar Todos
                    List<PessoaMentor> todosMentores = PessoaMentorDao.buscarTodasPessoasMentor();
                    if (todosMentores.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Lista Pessoa Talento está vazia!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        chamaMenuPrincipal();
                    } else {
                        StringBuilder mensagem = new StringBuilder();
                        mensagem.append("Todos os mentores:\n");
                        for (PessoaMentor mentor : todosMentores) {
                            mensagem.append("- ").append(mentor.getNome()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, mensagem.toString(), "Mentores Encontrados", JOptionPane.INFORMATION_MESSAGE);
                    }
                    chamaMenuPrincipal();
                    break;

                case 3: // Buscar Por Nome
                    List<PessoaMentor> todosMentoresBuscarNome = PessoaMentorDao.buscarTodasPessoasMentor();
                    if (todosMentoresBuscarNome.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Lista Pessoa Talento está vazia!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        chamaMenuPrincipal();
                    } else {
                        String nomeMentor = JOptionPane.showInputDialog(null, "Digite o nome do mentor:",
                                "Buscar mentor por nome", JOptionPane.QUESTION_MESSAGE);
                        if (nomeMentor != null) {
                            List<PessoaMentor> mentoresPorNome = PessoaMentorDao.buscarPorNome(nomeMentor);
                            if (mentoresPorNome.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum mentor encontrado com o nome informado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                StringBuilder mensagem = new StringBuilder();
                                mensagem.append("Mentores encontrados:\n");
                                for (PessoaMentor mentor : mentoresPorNome) {
                                    mensagem.append("- ").append(mentor.getNome()).append("\n");
                                }
                                JOptionPane.showMessageDialog(null, mensagem.toString(), "Mentores Encontrados", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            chamaMenuPrincipal();
                        }
                    }
                    chamaMenuPrincipal();
                    break;

                case 4: //Voltar
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




