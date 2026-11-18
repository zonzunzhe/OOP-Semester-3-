import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class HantuDesktop {
    public static void main(String[] args) {
        // 1. Top-Level Container (JFrame)
        JFrame frame = new JFrame();
        frame.setUndecorated(true); // Menghilangkan border atas, tombol minimize, dan close
        frame.setBackground(new Color(0, 0, 0, 0)); // Hack: Membuat jendela 100% transparan!
        frame.setSize(800, 600);
        frame.setLayout(null); // Layout Manager dinonaktifkan (Absolute Layout) agar posisi bisa diatur bebas
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Atomic Component (JButton)
        JButton tombolHantu = new JButton("👻 Coba Klik Aku!");
        tombolHantu.setFont(new Font("Arial", Font.BOLD, 20));
        tombolHantu.setBounds(300, 250, 250, 60);

        // 3. Event Handling (Interaksi Mouse)
        tombolHantu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Saat kursor mouse masuk ke area tombol, tombol akan pindah posisi secara acak
                Random rand = new Random();
                int xBaru = rand.nextInt(frame.getWidth() - tombolHantu.getWidth());
                int yBaru = rand.nextInt(frame.getHeight() - tombolHantu.getHeight());
                tombolHantu.setLocation(xBaru, yBaru);
            }
        });

        // Event Handling tambahan (berjaga-jaga jika entah bagaimana user berhasil klik)
        tombolHantu.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Hebat, kamu berhasil menangkapnya!");
            System.exit(0);
        });

        // Fitur darurat: Tekan tombol ESCape di keyboard untuk menutup aplikasi
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
            }
        });
        
        frame.add(tombolHantu);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true); // Agar bisa menerima input keyboard ESC
        frame.setVisible(true);
    }
}