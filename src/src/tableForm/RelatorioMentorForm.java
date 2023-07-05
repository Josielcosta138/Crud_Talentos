package tableForm;

import model.PessoaMentor;
import modelController.ProcessosGerais;
import relatorios.RelatorioPessoaMentor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class RelatorioMentorForm extends JPanel {
    private static final long serialVersionUID = 1L;
    public static final String[] nomeColunas =
            {"Nome", "Sexo", "Idade", "Cidade", "Historico de Mentorias", "Formação ", "Area de atuação", "Contato",  "Descrição Contato"};
    protected JTable table;
    protected JScrollPane scroller;
    protected RelatorioPessoaMentor tabela;
    protected Vector<PessoaMentor> vetorDados;

    public RelatorioMentorForm(Vector<PessoaMentor> vetorDados) {
        this.vetorDados = vetorDados;
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<PessoaMentor> vetorDados) {
        tabela = new RelatorioPessoaMentor(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
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

            Vector<PessoaMentor> vetorDados = new Vector<>(pessoaMentors);

            frame.getContentPane().add(new RelatorioMentorForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
