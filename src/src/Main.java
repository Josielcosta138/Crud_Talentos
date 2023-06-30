import model.EnumSexo;
import model.EnumtipoAreaAtuacao;
import model.PessoaTalento;
import repository.PessoaTalentoDao;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {




        String nome = JOptionPane.showInputDialog(null,"Informe o seu nome: ");

        EnumSexo pessoaTalento = EnumSexo.MASCULINO;
        Object[] selectionStatusSexo = {"MASCULINO", "FEMININO", "OUTROS"};
        String initialSelectionStatusSexo = pessoaTalento.toString();
        Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione seu sexo:",
                "Lista de Sexo", JOptionPane.QUESTION_MESSAGE, null, selectionStatusSexo, initialSelectionStatusSexo);
        EnumSexo sexo = EnumSexo.MASCULINO;
        if (selectionStatus.equals("FEMININO")) {
            sexo = EnumSexo.FEMININO;
        } else if (selectionStatus.equals("OUTROS")) {
            sexo = EnumSexo.OUTROS;
        }

        EnumtipoAreaAtuacao pessoaTalentoAtuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
        Object[] selectionStatusAtuacao = {"ANALISTA DE SISTEMAS", "MARKETING", "DIREITO EMPRESARIAL","GESTAO FINANCEIRA","MENTOR EM INOVAÇÃO",
        "EDUCAÇÃO PARA MIDIAS","QA","DESENVOLVEDOR BACK-END","DESENVOLVEDOR FRONT-END","ANALISTA DE NEGOCIO","PO","SCRUM MASTER"};
        String initialSelectionStatusAtuacao = pessoaTalentoAtuacao.toString();
        Object selectionStatus2 = JOptionPane.showInputDialog(null, "Selecione sua Área de Atuação.",
                "Lista de Especialidades", JOptionPane.QUESTION_MESSAGE, null, selectionStatusAtuacao, initialSelectionStatusAtuacao);
        EnumtipoAreaAtuacao atuacao = EnumtipoAreaAtuacao.ANALISTA_DE_SISTEMA;
        if (selectionStatus2.equals("MARKTING")) {
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


        int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe sua idade: "));
        String cidade = JOptionPane.showInputDialog(null,"Informe sua cidade: ");
        String estado = JOptionPane.showInputDialog(null,"Informe seu estado: ");
        String email = JOptionPane.showInputDialog(null,"Informe seu e-mail: ");
        String linkdin = JOptionPane.showInputDialog(null,"Informe seu linkedin: ");
        String especialidade = JOptionPane.showInputDialog(null,"Informe sua especialidade: ");
        String historicoDeMent = JOptionPane.showInputDialog(null,"Informe o histórico de mentoria: ");



        PessoaTalento pessoaTalento1 = new PessoaTalento(atuacao,nome,sexo,idade,cidade,estado,email,linkdin,especialidade,historicoDeMent);
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


        JOptionPane.showMessageDialog(null,relatorio.toString(),"Relatório Mentor",JOptionPane.INFORMATION_MESSAGE);

    }



public static void chamaRelatoriosPessoasTalentos(){
    List<PessoaTalento> pessoaTalentos = PessoaTalentoDao.buscarTodasPessoasTalento();
    RelatorioPessoaTalentoForm.emitirRelatorio(pessoaTalentos);
}


}


