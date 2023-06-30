import model.EnumSexo;
import model.EnumtipoAreaAtuacao;
import model.PessoaTalento;
import repository.PessoaTalentoDao;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        String nome = JOptionPane.showInputDialog(null,"Informe nome?");

        EnumSexo pessoaTalento = EnumSexo.MASCULINO;
        Object[] selectionStatusSexo = {"MASCULINO", "FEMININO", "OUTROS"};
        String initialSelectionStatusSexo = pessoaTalento.toString();
        Object selectionStatus = JOptionPane.showInputDialog(null, "Selecione sexo.",
                "Lista de Sexo", JOptionPane.QUESTION_MESSAGE, null, selectionStatusSexo, initialSelectionStatusSexo);
        EnumSexo sexo = EnumSexo.MASCULINO;
        if (selectionStatus.equals("FEMININO")) {
            sexo = EnumSexo.FEMININO;
        } else if (selectionStatus.equals("OUTROS")) {
            sexo = EnumSexo.OUTROS;
        }

        EnumtipoAreaAtuacao pessoaTalentoAtuacao = EnumtipoAreaAtuacao.ANALISTADESISTEMA;
        Object[] selectionStatusAtuacao = {"ANALISTA DE SISTEMA", "MARKTING", "DIREITO EMPRESARIAL","GESTAO FINANCEIRA","MENTOR EM INOVACAO",
        "EDUCAOÇÃO PARA MIDIAS","QA","DESENVOLVEDO RBACK-END","DESENVOLVEDOR FRONT-END","ANALISTA DE NEGOCIO","PO","SCRUMMASTER"};
        String initialSelectionStatusAtuacao = pessoaTalentoAtuacao.toString();
        Object selectionStatus2 = JOptionPane.showInputDialog(null, "Selecione Atuação.",
                "Lista de Especialidades", JOptionPane.QUESTION_MESSAGE, null, selectionStatusAtuacao, initialSelectionStatusAtuacao);
        EnumtipoAreaAtuacao atuacao = EnumtipoAreaAtuacao.ANALISTADESISTEMA;
        if (selectionStatus2.equals("MARKTING")) {
            atuacao = EnumtipoAreaAtuacao.MARKTING;
        } else if (selectionStatus2.equals("DIREITO EMPRESARIAL")) {
            atuacao = EnumtipoAreaAtuacao.DIREITOEMPRESARIAL;
        } else if (selectionStatus2.equals("DIREITO EMPRESARIAL")) {
            atuacao = EnumtipoAreaAtuacao.DIREITOEMPRESARIAL;
        } else if (selectionStatus2.equals("GESTAO FINANCEIRA")) {
            atuacao = EnumtipoAreaAtuacao.GESTAOFINANCEIRA;
        } else if (selectionStatus2.equals("MENTOR EM INOVACAO")) {
            atuacao = EnumtipoAreaAtuacao.MENTOREMINOVACAO;
        } else if (selectionStatus2.equals("EDUCAOÇÃO PARA MIDIAS")) {
            atuacao = EnumtipoAreaAtuacao.EDUCAOPARAMIDIAS;
        } else if (selectionStatus2.equals("QA")) {
            atuacao = EnumtipoAreaAtuacao.QA;
        } else if (selectionStatus2.equals("DESENVOLVEDO RBACK-END")) {
            atuacao = EnumtipoAreaAtuacao.DESENVOLVEDORBACKEND;
        } else if (selectionStatus2.equals("DESENVOLVEDOR FRONT-END")) {
            atuacao = EnumtipoAreaAtuacao.DESENVOLVEDORFRONTEND;
        } else if (selectionStatus2.equals("ANALISTA DE NEGOCIO")) {
            atuacao = EnumtipoAreaAtuacao.ANALISTADENEGOCIO;
        } else if (selectionStatus2.equals("PO")) {
            atuacao = EnumtipoAreaAtuacao.PO;
        } else if (selectionStatus2.equals("SCRUMMASTER")) {
            atuacao = EnumtipoAreaAtuacao.SCRUMMASTER;
        }


        int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe idade?"));
        String cidade = JOptionPane.showInputDialog(null,"Informe sua cidade?");
        String estado = JOptionPane.showInputDialog(null,"Informe seu estado?");
        String email = JOptionPane.showInputDialog(null,"Informe seu email?");
        String linkdin = JOptionPane.showInputDialog(null,"Informe seu linkdin ?");
        String especialidade = JOptionPane.showInputDialog(null,"Informe a epecialidade ?");
        String historicoDeMent = JOptionPane.showInputDialog(null,"Informe o historico de mentoria?");



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


        JOptionPane.showMessageDialog(null,relatorio.toString(),"Relatório Mentor ",JOptionPane.INFORMATION_MESSAGE);

    }
}