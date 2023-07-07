package repository;

import bancoDeDados.PessoaMentorRepository;
import model.*;
import modelController.ProcessosGerais;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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

    public static void salvarupdate(PessoaMentor pessoaMentor) throws SQLException, ClassNotFoundException {
        PessoaMentorRepository repository = new PessoaMentorRepository();
        repository.update(pessoaMentor);

    }

    public static List<PessoaMentor> buscarTodasPessoasMentor() {
        System.out.println("TESTE"+pessoaMentorList);
        PessoaMentorRepository pessoaMentorRepository = new PessoaMentorRepository();

        try {
            pessoaMentorList = pessoaMentorRepository.busca();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("teste erro "+e);
        }

       // PessoaMentorRepository repository = new PessoaMentorRepository();
       // Object[] objects = ListaDeNomesDeMentores();
        return pessoaMentorList;
    }


    public static List<PessoaMentor> buscarPorNome(String nome){
        List<PessoaMentor> pessoaMentorFiltradas = new ArrayList<>();
        for (PessoaMentor pessoaMentor : pessoaMentorList){
            if (pessoaMentor.getNome().equalsIgnoreCase(nome)){
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

        //teste
        if (selection != null) {

            String nome = JOptionPane.showInputDialog(null, "Informe novo nome.", pessoaMentors.get(0).getNome());
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


            Object[] selectionStatusCidades = {"CRICIUMA", "GUARULHOS", "PORTO ALEGRE"};
            String initialSelectionStatusCidades = pessoaTalento.toString();
            Object selectionStatusCid = JOptionPane.showInputDialog(null, "Selecione a Cidade:",
                    "Lista de Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionStatusCidades, initialSelectionStatusCidades);
            if (selectionStatusCid == null) {
                ProcessosGerais.chamaMenuPrincipal();
            }
            EnumCidades cidade = EnumCidades.CIDADE_CRICIUMA;
            if (selectionStatusCid.equals("GUARULHOS")) {
                cidade = EnumCidades.CIDADE_GUARULHOS;
                pessoaMentors.get(0).setEnumCidades(cidade);
            } else if (selectionStatusCid.equals("PORTO ALEGRE")) {
                cidade = EnumCidades.CIDADE_PORTO_ALEGRE;
                pessoaMentors.get(0).setEnumCidades(cidade);
            }


            EnumtipoAreaAtuacao enumtipoAreaAtuacao = EnumtipoAreaAtuacao.MARKTING;
            Object[] selectionStatusAreaDeAtuacao = {"MARKETING", "ANALISTA DE SISTEMA", "DIREITO_EMPRESARIAL", "GESTAO FINANCEIRA", "MENTOR EM INOVACAO",
                    "EDUCAO PARA MIDIAS", "QA", "DESENVOLVEDOR BACKEND", "DESENVOLVEDOR FRONTEND", "ANALISTA DE NEGOCIO", "PO", "SCRUMMASTER", "OUTROS"};
            String initialSelectionStatusAreaDeAtuacao = pessoaTalento.toString();
            Object selectionStatusAre = JOptionPane.showInputDialog(null, "Selecione seu area:",
                    "Lista Area de Atuação.", JOptionPane.QUESTION_MESSAGE, null, selectionStatusAreaDeAtuacao, initialSelectionStatusAreaDeAtuacao);
            if (selectionStatusAre == null) {
                ProcessosGerais.chamaMenuPrincipal();
            }
            EnumtipoAreaAtuacao atuacao = EnumtipoAreaAtuacao.MARKTING;
            if (selectionStatusAre.equals("ANALISTA DE SISTEMA")) {
                atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("DIREITO EMPRESARIAL")) {
                atuacao = EnumtipoAreaAtuacao.DIREITO_EMPRESARIAL;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("GESTAO FINANCEIRA")) {
                atuacao = EnumtipoAreaAtuacao.GESTAO_FINANCEIRA;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("MENTOR EM INOVACAO")) {
                atuacao = EnumtipoAreaAtuacao.MENTOR_EM_INOVACAO;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("EDUCAO PARA MIDIAS")) {
                atuacao = EnumtipoAreaAtuacao.EDUCAO_PARA_MIDIAS;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("QA")) {
                atuacao = EnumtipoAreaAtuacao.QA;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("DESENVOLVEDOR BACKEND")) {
                atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_BACKEND;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("DESENVOLVEDOR FRONTEND")) {
                atuacao = EnumtipoAreaAtuacao.DESENVOLVEDOR_FRONTEND;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("ANALISTA DE NEGOCIO")) {
                atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_NEGOCIO;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("PO")) {
                atuacao = EnumtipoAreaAtuacao.PO;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("SCRUMMASTER")) {
                atuacao = EnumtipoAreaAtuacao.SCRUMMASTER;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            } else if (selectionStatusAre.equals("OUTROS")) {
                atuacao = EnumtipoAreaAtuacao.OUTROS;
                pessoaMentors.get(0).setEnumtipoAreaAtuacao(atuacao);
            }


            EnumFormacao enumFormacao = EnumFormacao.ENSINO_FUNDAMENTAL;
            Object[] selectionStatusFormacao = {"ENSINO MEDIO", "ENSINO TECNICO", "GRADUACAO", "POS GRADUACAO", "MESTRADO", "DOUTORADO"};
            String initialSelectionStatusFormacao = pessoaTalento.toString();
            Object selectionStatusForm = JOptionPane.showInputDialog(null, "Selecione sua Formação",
                    "Lista de formação", JOptionPane.QUESTION_MESSAGE, null, selectionStatusFormacao, initialSelectionStatusFormacao);
            if (selectionStatusForm == null) {
                ProcessosGerais.chamaMenuPrincipal();
            }
            EnumFormacao formacao = EnumFormacao.ENSINO_FUNDAMENTAL;
            if (selectionStatusForm.equals("ENSINO MEDIO")) {
                formacao = EnumFormacao.ENSINO_MEDIO;
                pessoaMentors.get(0).setEnumFormacao(formacao);
            } else if (selectionStatusForm.equals("ENSINO TECNICO")) {
                formacao = EnumFormacao.ENSINO_TECNICO;
                pessoaMentors.get(0).setEnumFormacao(formacao);
            } else if (selectionStatusForm.equals("GRADUACAO")) {
                formacao = EnumFormacao.GRADUACAO;
                pessoaMentors.get(0).setEnumFormacao(formacao);
            } else if (selectionStatusForm.equals("POS GRADUACAO")) {
                formacao = EnumFormacao.POS_GRADUACAO;
                pessoaMentors.get(0).setEnumFormacao(formacao);
            } else if (selectionStatusForm.equals("MESTRADO")) {
                formacao = EnumFormacao.MESTRADO;
                pessoaMentors.get(0).setEnumFormacao(formacao);
            } else if (selectionStatusForm.equals("DOUTORADO")) {
                formacao = EnumFormacao.DOUTORADO;
                pessoaMentors.get(0).setEnumFormacao(formacao);
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
                    ProcessosGerais.chamaMenuPrincipal();
                }
                EnumContato enumContato1 = EnumContato.TELEFONE;
                if (selectionStatusCont.equals("WHATSAPP")) {
                    enumContato1 = EnumContato.WHATSAPP;
                    pessoaMentors.get(0).setContatos(Collections.singletonList(enumContato1));
                } else if (selectionStatusCont.equals("FACEBOOK")) {
                    enumContato1 = EnumContato.FACEBOOK;
                    pessoaMentors.get(0).setContatos(Collections.singletonList(enumContato1));
                } else if (selectionStatusCont.equals("INSTAGRAM")) {
                    enumContato1 = EnumContato.INSTAGRAM;
                    pessoaMentors.get(0).setContatos(Collections.singletonList(enumContato1));
                } else if (selectionStatusCont.equals("LINKEDIN")) {
                    enumContato1 = EnumContato.LINKEDIN;
                    pessoaMentors.get(0).setContatos(Collections.singletonList(enumContato1));
                } else if (selectionStatusCont.equals("TWITTER")) {
                    enumContato1 = EnumContato.TWITTER;
                    pessoaMentors.get(0).setContatos(Collections.singletonList(enumContato1));
                }

                descricaoContato = JOptionPane.showInputDialog("Digite a descrição do contato:");
                if (descricaoContato == null || descricaoContato.isEmpty()) {
                    ProcessosGerais.chamaMenuPrincipal();
                }

                Contato contato = new Contato(descricaoContato, enumContato1);
                contatos.add(contato.getEnumContato());

                pessoaMentors.get(0).setDescricaoContato(descricaoContato);

                int option = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais contatos?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.NO_OPTION) {
                    cadastrarMaisContatos = false;
                }
            }


            String historicoMent = JOptionPane.showInputDialog(null, "Informe novo histórico de mentoria: ", pessoaMentors.get(0).getHistorioDeMentorias());
            if (historicoMent == null || historicoMent.isEmpty()) {
                ProcessosGerais.chamaMenuPrincipal();
            } else {
                pessoaMentors.get(0).setHistorioDeMentorias(historicoMent);
            }

            //PessoaMentorDao.salvarupdate((PessoaMentor) pessoaMentors.get(0));

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            ProcessosGerais.chamaMenuPrincipal();
        }
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
                PessoaMentorRepository pessoaRepository = new PessoaMentorRepository();
                //pessoaRepository.delete(mentor);
                pessoaMentorList.remove(mentor);
                ProcessosGerais.chamaMenuPrincipal();
                break;
            }
        }
        ProcessosGerais.chamaMenuPrincipal();
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