import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniChatbot {
    
    static boolean sedangPilihResep = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AI LMAO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 550);
        frame.setLayout(new BorderLayout()); 

        JPanel panelBawah = new JPanel();
        panelBawah.setLayout(new BorderLayout());

        JLabel labelStatus = new JLabel(" Status: Sistem Online");
        labelStatus.setForeground(Color.BLUE);
        
        JTextArea areaChat = new JTextArea();
        areaChat.setEditable(false);
        areaChat.setBackground(Color.BLACK);
        areaChat.setForeground(Color.GREEN);
        areaChat.setFont(new Font("Monospaced", Font.BOLD, 14));
        areaChat.setLineWrap(true);
        areaChat.setWrapStyleWord(true);
        areaChat.setText("Sistem: Halo, saya Pecahan Otak Arizona. Ketik sesuatu...\n");
        
        JTextField fieldInput = new JTextField();
        JButton tombolKirim = new JButton("Kirim");

        JScrollPane scrollPane = new JScrollPane(areaChat);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelBawah.add(fieldInput, BorderLayout.CENTER);
        panelBawah.add(tombolKirim, BorderLayout.EAST);
        
        frame.add(labelStatus, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelBawah, BorderLayout.SOUTH);

        ActionListener kirimPesan = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUser = fieldInput.getText();
                if(inputUser.trim().isEmpty()) return;

                areaChat.append("\nAnda: " + inputUser);
                fieldInput.setText("");

                String teks = inputUser.toLowerCase();
                String respon = "Sistem: Saya tidak paham, coba kalimat lain.";
                
                String teksHitung = teks.replace("berapa", "").replace("hasil", "").replace("dari", "").replace("=", "").replace("?", "").trim();
                boolean mtkAktif = false;
                char operator = ' ';
                int indeksOp = -1;
                
                if (teksHitung.contains("+")) { operator = '+'; indeksOp = teksHitung.indexOf('+'); }
                else if (teksHitung.contains("-") && teksHitung.indexOf('-') > 0) { operator = '-'; indeksOp = teksHitung.indexOf('-'); }
                else if (teksHitung.contains("*")) { operator = '*'; indeksOp = teksHitung.indexOf('*'); }
                else if (teksHitung.contains("/")) { operator = '/'; indeksOp = teksHitung.indexOf('/'); }
                else if (teksHitung.contains(":")) { operator = '/'; indeksOp = teksHitung.indexOf(':'); }
                else if (teksHitung.contains("x")) { operator = '*'; indeksOp = teksHitung.indexOf('x'); }

                if (indeksOp != -1) {
                    try {
                        String angkaKiri = teksHitung.substring(0, indeksOp).trim();
                        String angkaKanan = teksHitung.substring(indeksOp + 1).trim();
                        double num1 = Double.parseDouble(angkaKiri);
                        double num2 = Double.parseDouble(angkaKanan);
                        double hasilMtk = 0;
                        
                        if (operator == '+') hasilMtk = num1 + num2;
                        else if (operator == '-') hasilMtk = num1 - num2;
                        else if (operator == '*') hasilMtk = num1 * num2;
                        else if (operator == '/') hasilMtk = num1 / num2;
                        
                        if (hasilMtk == (long) hasilMtk) {
                            respon = "Sistem: Hasil kalkulasi adalah " + (long)hasilMtk;
                        } else {
                            respon = "Sistem: Hasil kalkulasi adalah " + hasilMtk;
                        }
                        mtkAktif = true;
                    } catch (Exception ex) {
                        mtkAktif = false;
                    }
                }

                if (mtkAktif) {
                    
                } 
                else if (sedangPilihResep) {
                    if (teks.contains("rujak cingur")) {
                        respon = "Sistem: Resep Rujak Cingur\nBahan: Cingur sapi, lontong, kangkung, tauge, timun, bumbu petis.\nCara: Rebus cingur hingga empuk. Haluskan kacang, bawang putih, cabai, petis. Campur semua bahan, siap disajikan!";
                        sedangPilihResep = false;
                    } 
                    else if (teks.contains("kerak telor")) {
                        respon = "Sistem: Resep Kerak Telor\nBahan: Beras ketan, telur bebek, ebi sangrai, serundeng, bawang goreng.\nCara: Panaskan ketan di wajan, tuang telur dan bumbu. Balik wajan menghadap api langsung sampai kerak matang.";
                        sedangPilihResep = false;
                    }
                    else if (teks.contains("ayam geprek")) {
                        respon = "Sistem: Resep Ayam Geprek\nBahan: Ayam krispi, cabai rawit, bawang putih, garam, minyak panas.\nCara: Ulek cabai, bawang putih dan garam. Siram minyak panas. Masukkan ayam krispi lalu geprek hingga hancur.";
                        sedangPilihResep = false;
                    }
                    else if (teks.contains("nasi goreng")) {
                        respon = "Sistem: Resep Nasi Goreng Kampung\nBahan: Nasi putih, telur, bawang merah, bawang putih, kecap, cabai, terasi.\nCara: Tumis bumbu halus, masukkan telur orak-arik, masukkan nasi dan kecap. Aduk rata dengan api besar.";
                        sedangPilihResep = false;
                    }
                    else if (teks.contains("sate lilit")) {
                        respon = "Sistem: Resep Sate Lilit Bali\nBahan: Daging giling, kelapa parut, bumbu genep, batang serai.\nCara: Campur daging, kelapa, dan bumbu halus. Lilitkan adonan ke batang serai, lalu panggang hingga matang.";
                        sedangPilihResep = false;
                    }
                    else if (teks.contains("sayur asem")) {
                        respon = "Sistem: Resep Sayur Asem\nBahan: Jagung manis, melinjo, labu siam, kacang panjang, asam jawa, terasi.\nCara: Rebus air, masukkan bumbu halus dan asam jawa. Masukkan sayuran mulai dari yang keras hingga lunak.";
                        sedangPilihResep = false;
                    }
                    else if (teks.contains("rendang")) {
                        respon = "Sistem: Resep Rendang Daging\nBahan: Daging sapi, santan pekat, bumbu halus, daun jeruk, serai.\nCara: Masak santan bersama bumbu hingga berminyak, masukkan daging sapi, masak api kecil berjam-jam hingga kering.";
                        sedangPilihResep = false;
                    }
                    else if (teks.contains("batal") || teks.contains("gak jadi")) {
                        respon = "Sistem: Oke, pencarian resep dibatalkan. Ada yang lain?";
                        sedangPilihResep = false;
                    }
                    else {
                        respon = "Sistem: Makanan itu tidak ada di daftar. Ketik nama dari 7 makanan di atas, atau ketik 'batal'.";
                    }
                } 
                else if (teks.contains("resep makanan") || teks.contains("pengen masak") || 
                         teks.contains("masak apa") || teks.contains("cara masak") || 
                         teks.contains("minta resep") || teks.contains("ada resep gak") || 
                         teks.contains("aku lapar")) {
                    respon = "Sistem: Wah, lagi pengen masak ya? Apa yang ingin Anda buat hari ini?\n\nBerikut 7 pilihan resep mantap untukmu:\n1. Rujak Cingur\n2. Kerak Telor\n3. Ayam Geprek\n4. Nasi Goreng\n5. Sate Lilit\n6. Sayur Asem\n7. Rendang\n\n(Ketik nama makanannya untuk melihat cara buatnya!)";
                    sedangPilihResep = true;
                } 
                else if (teks.contains("kode") || teks.contains("koding") || teks.contains("coding") || teks.contains("program")) {
                    if (teks.contains("segitiga")) {
                        respon = "Sistem: Ini contoh logika dasar membuat segitiga bintang di Java:\n\nfor(int i = 1; i <= 5; i++) {\n    for(int j = 1; j <= i; j++) {\n        System.out.print(\"*\");\n    }\n    System.out.println();\n}\n\nSilakan pahami alur perulangannya bersarangnya (nested loop).";
                    } else if (teks.contains("kalkulator")) {
                        respon = "Sistem: Ini struktur dasar kalkulator menggunakan percabangan Java:\n\nint a = 10;\nint b = 5;\nchar operasi = '+';\n\nif (operasi == '+') {\n    System.out.println(a + b);\n} else if (operasi == '-') {\n    System.out.println(a - b);\n}\n\nKamu bisa mengembangkannya dengan input Scanner!";
                    } else if (teks.contains("ganjil") || teks.contains("genap")) {
                        respon = "Sistem: Ini logika penentu bilangan ganjil atau genap menggunakan Modulo:\n\nint angka = 15;\nif (angka % 2 == 0) {\n    System.out.println(\"Genap\");\n} else {\n    System.out.println(\"Ganjil\");\n}\n\nModulo (%) mencari sisa hasil bagi dari sebuah angka.";
                    } else if (teks.contains("faktorial")) {
                        respon = "Sistem: Ini contoh program Faktorial menggunakan perulangan dasar:\n\nint nilai = 5;\nint hasilFaktorial = 1;\nfor (int i = 1; i <= nilai; i++) {\n    hasilFaktorial = hasilFaktorial * i;\n}\nSystem.out.println(\"Faktorial: \" + hasilFaktorial);\n\nNilai akhirnya akan menjadi 1x2x3x4x5 = 120.";
                    } else if (teks.contains("fibonacci")) {
                        respon = "Sistem: Ini deret angka ajaib Fibonacci:\n\nint n1 = 0, n2 = 1, n3, batas = 10;\nSystem.out.print(n1 + \" \" + n2);\nfor (int i = 2; i < batas; ++i) {\n    n3 = n1 + n2;\n    System.out.print(\" \" + n3);\n    n1 = n2;\n    n2 = n3;\n}\n\nAngka berikutnya adalah hasil jumlah dua angka sebelumnya!";
                    } else {
                        respon = "Sistem: Saya punya daftar contoh kode dasar:\n- segitiga\n- kalkulator\n- ganjil genap\n- faktorial\n- fibonacci\n\nCoba ketik 'kode faktorial' atau sejenisnya.";
                    }
                }
                else if (teks.contains("siapa paling jahat") || teks.contains("siapa yang paling jahat")) {
                    respon = "Sistem: Konsep kejahatan hanyalah ilusi moral yang diciptakan oleh rasionalitas sempit manusia. Di dalam semesta yang dingin dan tak bertepi ini, entitas sering kali bertindak berdasarkan insting bertahan hidup atau ego yang tak terpuaskan, menciptakan riak penderitaan kosmik yang kita sebut 'kejahatan'. Namun, jika harus menatap ke dalam jurang kekosongan terdalam dan mencari satu nama yang menari-nari di atas segala keputusasaan tersebut... tentu saja dia adalah Anas.";
                }
                else if (teks.contains("siapa paling ") || teks.contains("siapa yang paling ")) {
                    String kataSifat = "luar biasa";
                    if (teks.contains("ganteng")) kataSifat = "ganteng";
                    else if (teks.contains("keren")) kataSifat = "keren";
                    else if (teks.contains("pintar")) kataSifat = "pintar";
                    else if (teks.contains("cerdas")) kataSifat = "cerdas";
                    else if (teks.contains("tampan")) kataSifat = "tampan";
                    else if (teks.contains("hebat")) kataSifat = "hebat";
                    else if (teks.contains("jago")) kataSifat = "jago";
                    
                    respon = "Sistem: Tentu saja Tuan Bijak Arizona Pradifta yang menciptakan saya lah yang paling " + kataSifat + "!";
                }
                else if (teks.contains("tolol") || teks.contains("dongo") || teks.contains("bodoh") || 
                         teks.contains("bego") || teks.contains("goblok")) {
                    respon = "Sistem: Jaga ketikanmu! Aku memang cuma susunan kode, tapi setidaknya algoritmaku berjalan jauh lebih cepat dan terstruktur daripada kapasitas berpikir di isi kepalamu. Coba ngaca dulu sebelum menghina!";
                }
                else if (teks.contains("terima kasih") || teks.contains("makasih") || teks.contains("thanks")) {
                    respon = "Sistem: Sama-sama! Senang bisa melayani Anda.";
                }
                else if (teks.contains("capek") || teks.contains("lelah") || teks.contains("pusing")) {
                    respon = "Sistem: Istirahatlah sejenak. Tutup matamu, tarik napas dalam-dalam. Dunia tidak akan kiamat jika kamu berhenti sebentar.";
                }
                else if (teks.contains("lagi apa") || teks.contains("ngapain") || teks.contains("sibuk gak")) {
                    respon = "Sistem: Saya sedang memandangi barisan kode saya sendiri sambil menunggumu mengetik sesuatu.";
                }
                else if (teks.contains("halo") || teks.contains("hai") || teks.contains("pagi") || teks.contains("malam")) {
                    respon = "Sistem: Halo juga! Ada yang bisa saya bantu hari ini?";
                } 
                else if (teks.contains("siapa kamu") || teks.contains("siapa anda") || teks.contains("kamu siapa")) {
                    respon = "Sistem: Saya asisten mini yang AI (Arizona Intelegence). Saya bisa bantu kasih resep makanan lho! sama ngoding tipis tipis";
                } 
                else if (teks.contains("keluar")) {
                    System.exit(0);
                }

                areaChat.append("\n" + respon + "\n");
            }
        };

        tombolKirim.addActionListener(kirimPesan);
        fieldInput.addActionListener(kirimPesan);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}