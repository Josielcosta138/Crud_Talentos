import model.*;
import relatorios.RelatorioPessoaTalento;
import repository.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.table.TableColumn;

import static com.sun.javafx.fxml.expression.Expression.add;

public class RelatorioPessoaTalentoForm extends JPanel{
    private static final long serialVersionUID = 1L;
    public static final String[] nomeColunas =
            {"Área de Atuação", "Nome","Sexo","Idade","Cidade", "Estado","E-mail", "Linkedin", "Especialidade", "Historico de Mentorias"};
    protected JTable table;
    protected JScrollPane scroller;
    protected RelatorioPessoaTalento tabela;

    public RelatorioPessoaTalentoForm(Vector<PessoaTalento> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<PessoaTalento> vetorDados) {
        tabela = new RelatorioPessoaTalento(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

//        TableColumn colunaEscondida = table.getColumnModel().getColumn(RelatorioHospede.INDEX_ESCONDIDO);
//        colunaEscondida.setMinWidth(2);
//        colunaEscondida.setPreferredWidth(2);
//        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<PessoaTalento> pessoaTalentos) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    //colocar aqui o ChamaMenuPrincipal
                }

            });
            Vector<PessoaTalento> vetorDados = new Vector<PessoaTalento>();
            for (PessoaTalento pessoaTalento : pessoaTalentos) {
                vetorDados.add(pessoaTalento);
            }

            frame.getContentPane().add(new RelatorioPessoaTalentoForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}