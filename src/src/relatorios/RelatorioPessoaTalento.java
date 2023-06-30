package relatorios;
import model.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class RelatorioPessoaTalento extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    public static final int INDEX_ENUMTIPOAREAATUACAO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_ENUMSEXO = 2;
    public static final int INDEX_IDADE = 3;
    public static final int INDEX_CIDADE = 4;
    public static final int INDEX_ESTADO = 5;
    public static final int INDEX_EMAIL = 6;
    public static final int INDEX_LIKDIN = 7;
    public static final int INDEX_ESPECIALIDADE = 8;
    public static final int INDEX_HISTORICODEMENTORIAS = 9;
    public static final int INDEX_ESCONDIDO = 10;

    protected String[] nomeColunas;
    protected Vector<PessoaTalento> vetorDados;

    public RelatorioPessoaTalento(String[] columnNames, Vector<PessoaTalento> vetorDados) {
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
        PessoaTalento registroPessoa = (PessoaTalento) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_ENUMTIPOAREAATUACAO:
                return registroPessoa.getEnumtipoAreaAtuacao();
            case INDEX_NOME:
                return registroPessoa.getNome();
            case INDEX_ENUMSEXO:
                return registroPessoa.getEnumSexo();
            case INDEX_IDADE:
                return registroPessoa.getIdade();
            case INDEX_CIDADE:
                return registroPessoa.getCidade();
            case INDEX_ESTADO:
                return registroPessoa.getEstado();
            case INDEX_EMAIL:
                return registroPessoa.getEmail();
            case INDEX_LIKDIN:
                return registroPessoa.getLinkdin();
            case INDEX_ESPECIALIDADE:
                return registroPessoa.getEspecialidade();
            case INDEX_HISTORICODEMENTORIAS:
                return registroPessoa.getEspecialidade();
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
