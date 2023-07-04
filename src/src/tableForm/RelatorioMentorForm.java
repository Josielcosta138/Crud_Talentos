package tableForm;

import model.*;
import modelController.ProcessosGerais;
import relatorios.RelatorioPessoaMentor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import static com.sun.javafx.fxml.expression.Expression.add;

public class RelatorioMentorForm extends JPanel{
    private static final long serialVersionUID = 1L;
    public static final String[] nomeColunas =
            {"Nome","Sexo","Idade","Cidade","Estado","Historico de Mentorias","Area de atuação" ,"Contato"};
    protected JTable table;
    protected JScrollPane scroller;
    protected RelatorioPessoaMentor tabela;

    public RelatorioMentorForm(Vector<PessoaMentor> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<PessoaMentor> vetorDados) {
        tabela = new RelatorioPessoaMentor(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<PessoaMentor> pessoaMentors) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    try {
                        ProcessosGerais.chamaMenuPrincipal();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
            Vector<PessoaMentor> vetorDados = new Vector<PessoaMentor>();
            for (PessoaMentor pessoaMentor : pessoaMentors) {
                vetorDados.add(pessoaMentor);
            }

            frame.getContentPane().add(new RelatorioMentorForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}