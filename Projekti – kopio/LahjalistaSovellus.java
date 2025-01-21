import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Lahja {
    private String nimi;
    private String saaja;
    private double hinta;

    public Lahja(String nimi, String saaja, double hinta) {
        this.nimi = nimi;
        this.saaja = saaja;
        this.hinta = hinta;
    }

    public String getNimi() {
        return nimi;
    }

    public String getSaaja() {
        return saaja;
    }

    public double getHinta() {
        return hinta;
    }
}

public class LahjalistaSovellus{
 

    private JFrame frame;
    private JTextField lahjanNimiField;
    private JTextField saajanNimiField;
    private JTextField hintaField;
    private JLabel kokonaisHintaLabel;
    private DefaultTableModel tableModel;
    private ArrayList<Lahja> lahjat;

    public LahjalistaSovellus() {
        lahjat = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        
        frame = new JFrame("Lahjalista");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        
        JPanel formPanel = new JPanel(new GridLayout(6, 3));
        formPanel.setBorder(BorderFactory.createTitledBorder("Lissää lahja"));

        formPanel.add(new JLabel("Lahjan nimi:"));
        lahjanNimiField = new JTextField();
        formPanel.add(lahjanNimiField);

        formPanel.add(new JLabel("Saajan nimi:"));
        saajanNimiField = new JTextField();
        formPanel.add(saajanNimiField);

        formPanel.add(new JLabel("Hinta:"));
        hintaField = new JTextField();
        formPanel.add(hintaField);

        JButton Button = new JButton("Lisää");
        formPanel.add(Button);
        

        

        frame.add(formPanel, BorderLayout.NORTH);

        
        tableModel = new DefaultTableModel(new String[]{"Lahja", "Saaja", "Hinta"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        frame.add(tableScrollPane, BorderLayout.CENTER);

        
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addGift();
            }
        });

        frame.setVisible(true);
    }

    private void addGift() {
        String lahjanNimi = lahjanNimiField.getText().trim();
        String saajanNimi = saajanNimiField.getText().trim();
        String hintaText = hintaField.getText().trim();

        

        try {
            double hinta = Double.parseDouble(hintaText);
            if (hinta < 0) {
                throw new NumberFormatException();
            }

            Lahja lahja = new Lahja(lahjanNimi, saajanNimi, hinta);
            lahjat.add(lahja);

            tableModel.addRow(new Object[]{lahjanNimi, saajanNimi, String.format("%.2f", hinta)});
            updateTotalCost();

            lahjanNimiField.setText("");
            saajanNimiField.setText("");
            hintaField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Hinta ei ole kelvollinen numero!", "Virhe", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTotalCost() {
        double totalCost = lahjat.stream().mapToDouble(Lahja::getHinta).sum();
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LahjalistaSovellus::new);
    }
}
