package relatorios;
import model.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class RelatorioPessoaMentor extends javax.swing.table.AbstractTableModel{
    private static final long serialVersionUID = 1L;
    public static final int INDEX_NOME = 0;
    public static final int INDEX_ENUMSEXO = 1;
    public static final int INDEX_IDADE = 2;
    public static final int INDEX_CIDADE = 3;
    public static final int INDEX_HISTORICODEMENTORIAS = 4;
    public static final int INDEX_FORMACAO = 5;
    public static final int INDEX_AREAATUACAO = 6;
    public static final int INDEX_CONTATO = 7;
    public static final int INDEX_ESCONDIDO = 8;

    protected String[] nomeColunas;
    protected Vector<PessoaMentor> vetorDados;

    public RelatorioPessoaMentor(String[] columnNames, Vector<PessoaMentor> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        PessoaMentor registroPessoa = (PessoaMentor) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NOME:
                return registroPessoa.getNome();
            case INDEX_ENUMSEXO:
                return registroPessoa.getEnumSexo();
            case INDEX_IDADE:
                return registroPessoa.getIdade();
            case INDEX_CIDADE:
                return registroPessoa.getEnumCidades();
            case INDEX_HISTORICODEMENTORIAS:
                return registroPessoa.getHistorioDeMentorias();
            case INDEX_FORMACAO:
                return registroPessoa.getEnumFormacao();
            case INDEX_AREAATUACAO:
                return registroPessoa.getEnumtipoAreaAtuacao();
            case INDEX_CONTATO:
                return registroPessoa.getContatos();

            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}
