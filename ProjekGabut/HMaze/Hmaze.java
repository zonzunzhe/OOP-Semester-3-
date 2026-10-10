import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class lolok {
    private static boolean isPlaying = false;
    private static int dotx = -50;
    private static int doty = -50;

    public static void main(String[] args) {
        JFrame lolok = new JFrame("Tes Besar Lolok - Haunted Maze");
        lolok.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lolok.setSize(600, 600);
        lolok.setLocationRelativeTo(null);
        lolok.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel startPanel = new JPanel(new GridBagLayout());
        startPanel.setBackground(Color.BLACK);
        
        JButton startButton = new JButton("MULAI GAME");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setBackground(Color.RED);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        
        startButton.addActionListener(e -> {
            dotx = -50;
            doty = -50;
            cardLayout.show(mainPanel, "MazeScreen");
            isPlaying = false;
        });
        startPanel.add(startButton);

        JPanel mazePanel = new JPanel() {
            // KOORDINAT YANG BENAR
            Rectangle path1 = new Rectangle(50, 50, 450, 50);
            Rectangle path2 = new Rectangle(450, 50, 50, 400);
            Rectangle path3 = new Rectangle(50, 400, 450, 50);
            Rectangle path4 = new Rectangle(50, 250, 50, 150); // Jalur baru berbelok naik
            
            Rectangle startArea = new Rectangle(50, 50, 50, 50);
            Rectangle finishArea = new Rectangle(50, 250, 50, 50); // Titik finish di ujung jalur 4

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(Color.WHITE);
                g.fillRect(path1.x, path1.y, path1.width, path1.height);
                g.fillRect(path2.x, path2.y, path2.width, path2.height);
                g.fillRect(path3.x, path3.y, path3.width, path3.height);
                g.fillRect(path4.x, path4.y, path4.width, path4.height);

                g.setColor(Color.GREEN);
                g.fillRect(startArea.x, startArea.y, startArea.width, startArea.height);

                g.setColor(Color.RED);
                g.fillRect(finishArea.x, finishArea.y, finishArea.width, finishArea.height);

                g.setColor(Color.BLUE);
                g.fillOval(dotx - 5, doty - 5, 10, 10);
            }
        };

        mazePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                dotx = e.getX();
                doty = e.getY();
                mazePanel.repaint();
                Point cursor = e.getPoint();
                
                // KOORDINAT LOGIKA DISAMAKAN PERSIS DENGAN GAMBAR DI ATAS
                Rectangle path1 = new Rectangle(50, 50, 50, 50);
                Rectangle path2 = new Rectangle(450, 50, 50, 400);
                Rectangle path3 = new Rectangle(50, 400, 450, 50);
                Rectangle path4 = new Rectangle(50, 250, 50, 150); 
                Rectangle startArea = new Rectangle(50, 50, 50, 50);
                Rectangle finishArea = new Rectangle(50, 250, 50, 50); 

                if (!isPlaying) {
                    if (startArea.contains(cursor)) {
                        isPlaying = true;
                    }
                } else {
                    boolean onSafePath = path1.contains(cursor) || path2.contains(cursor) || path3.contains(cursor) || path4.contains(cursor);
                    
                    if (finishArea.contains(cursor)) {
                        isPlaying = false;
                        cardLayout.show(mainPanel, "JumpscareScreen");
                    } else if (!onSafePath) {
                        isPlaying = false;
                        JOptionPane.showMessageDialog(lolok, "Kursor keluar jalur! Silakan ulangi.");
                        cardLayout.show(mainPanel, "StartScreen");
                    }
                }
            }
        });

        JPanel jumpscarePanel = new JPanel(new BorderLayout());
        jumpscarePanel.setBackground(Color.BLACK);

        JLabel imageLabel = new JLabel("", SwingConstants.CENTER);
        
        File imgFile = new File("jumpscare.jpg");
        if (imgFile.exists()) {
            ImageIcon icon = new ImageIcon("jumpscare.jpg");
            Image img = icon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } else {
            imageLabel.setText("<html><h1 style='color:red;'>JUMPSCARE BOO!!!</h1><p style='color:white;'>Taruh file 'jumpscare.jpg' di folder ini</p></html>");
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> cardLayout.show(mainPanel, "StartScreen"));

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(restartButton);
        buttonPanel.add(quitButton);

        jumpscarePanel.add(imageLabel, BorderLayout.CENTER);
        jumpscarePanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(startPanel, "StartScreen");
        mainPanel.add(mazePanel, "MazeScreen");
        mainPanel.add(jumpscarePanel, "JumpscareScreen");

        lolok.add(mainPanel);
        lolok.setVisible(true);
    }
}