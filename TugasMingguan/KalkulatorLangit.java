import javax.swing.*;
import java.awt.*;

public class KalkulatorLangit {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pengukur Jarak Angkasa");
        frame.setSize(350, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        JLabel lblInput = new JLabel("Jarak (Tahun Cahaya):");
        JTextField txtInput = new JTextField(10); // Kotak teks untuk mengetik angka
        JButton btnHitung = new JButton("Konversi ke KM");
        JLabel lblHasil = new JLabel("Hasil: 0 km");
        lblHasil.setFont(new Font("Arial", Font.BOLD, 14));

        // Aksi ketika tombol ditekan
        btnHitung.addActionListener(e -> {
            try {
                double tahunCahaya = Double.parseDouble(txtInput.getText());
                double km = tahunCahaya * 9.461e12; // 1 Tahun Cahaya = ~9.46 triliun km
                lblHasil.setText(String.format("Hasil: %.2e km", km)); // Format eksponensial (scientific)
            } catch (NumberFormatException ex) {
                lblHasil.setText("Masukkan angka yang valid!"); // Pesan error jika input bukan angka
            }
        });

        frame.add(lblInput);
        frame.add(txtInput);
        frame.add(btnHitung);
        frame.add(lblHasil);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}