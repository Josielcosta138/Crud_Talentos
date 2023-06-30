package repository;

import model.PessoaTalento;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaTalentoDao {

    static List<PessoaTalento> pessoaTalentoList = new ArrayList<>();

    public static void salvarPessoaTalento(PessoaTalento pessoaTalento){
        pessoaTalentoList.add(pessoaTalento);
    }

    public static List<PessoaTalento> buscarTodasPessoasTalento(){
        return pessoaTalentoList;
    }

    public static void alterarPessoaTalenti(PessoaTalento pessoaTalento){

    }

    public static void excluirPessoasTalento(PessoaTalento pessoaTalento){
        pessoaTalentoList.remove(pessoaTalento);
        JOptionPane.showMessageDialog(null,"Mentor removido com sucesso!");
    }


}
