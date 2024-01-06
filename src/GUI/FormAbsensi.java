package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;

public class FormAbsensi extends javax.swing.JFrame {
    // Membuat koneksi database
    private Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/uas_kepegawaian"; // Sesuaikan dengan URL database Anda
    private final String user = "root"; // Ganti dengan username database Anda
    private final String password = ""; // Ganti dengan password database Anda
    
    public FormAbsensi() {
        initComponents();    
        // Menambahkan action listener untuk melakukan pencarian saat teks diubah pada tfCari
        tfCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent evt) {
                performSearch();
            }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent evt) {
                performSearch();
            }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent evt) {
                performSearch();
            }
            private void performSearch() {
                String searchText = tfCari.getText().trim();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tabelAbsensi.getModel());
                tabelAbsensi.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
    }
        });
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation(
            (screenSize.width - frameSize.width) / 2, 
            (screenSize.height - frameSize.height) / 2
        ); // Menentukan lokasi frame agar berada di tengah layar
        
        try {
            conn = DriverManager.getConnection(url, user, password);
            // Menambahkan pemanggilan isiComboBoxNIP() di sini
            populateNipComboBox();
            // Tambahkan beberapa pernyataan pencetakan (opsional)
            System.out.println("ComboBox diisi dengan NIP:");
            for (int i = 0; i < cbNip.getItemCount(); i++) {
                System.out.println(cbNip.getItemAt(i));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        // Setelah menambahkan data ke dalam database, tampilkan data di tabelAbsensi
        refreshTableAbsensi();
        cbNip.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfMasuk = new javax.swing.JTextField();
        tfIzin = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jdRekap = new com.toedter.calendar.JDateChooser();
        cbNip = new javax.swing.JComboBox<>();
        btnCetak = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAbsensi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("REKAP ABSENSI PEGAWAI");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("NIP");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Jumlah Masuk");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Tanggal Rekap");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Jumlah Izin");

        tfMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMasukActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cbNip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih NIP-" }));
        cbNip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNipActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Cari");

        tfCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnKembali)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdRekap, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(cbNip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(tfIzin, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(tfCari))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIzin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdRekap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnEdit)
                            .addComponent(btnHapus)
                            .addComponent(btnReset)
                            .addComponent(btnKembali)
                            .addComponent(btnCetak))
                        .addGap(18, 50, Short.MAX_VALUE))))
        );

        tabelAbsensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIP", "Nama Pegawai", "Jabatan", "Tanggal Rekap", "Jumlah Masuk", "Jumlah Izin"
            }
        ));
        jScrollPane1.setViewportView(tabelAbsensi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMasukActionPerformed
        
    }//GEN-LAST:event_tfMasukActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        FormMenu Formberanda = new FormMenu();
        Formberanda.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
        // Ambil nilai yang dipilih dari ComboBox cbNip
        String selectedNipNama = cbNip.getSelectedItem().toString();
        
        // Pisahkan nilai NIP dan nama pegawai
        String[] nipNamaArray = selectedNipNama.split(" - ");
        String nip = nipNamaArray[0];
        String namaPegawai = nipNamaArray[1];
        
        // Ambil nilai dari jdRekap, tfMasuk, tfIzin
        java.util.Date tanggalRekap = jdRekap.getDate();
        java.sql.Date sqlDateRekap = new java.sql.Date(tanggalRekap.getTime());
        String jumlahMasuk = tfMasuk.getText();
        String jumlahIzin = tfIzin.getText();
        
        // Simpan data ke dalam data_absensi
        String sql = "INSERT INTO data_absensi (id_pegawai, tanggal_rekap, jumlah_masuk, jumlah_izin) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, getIdPegawaiByNip(nip));
        statement.setDate(2, sqlDateRekap);
        statement.setString(3, jumlahMasuk);
        statement.setString(4, jumlahIzin);
        
        // Eksekusi pernyataan SQL untuk menyimpan data
        int rowsInserted = statement.executeUpdate();
        
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            // Setelah berhasil menambahkan data, refresh tabelAbsensi
            refreshTableAbsensi();
            // Mereset setiap inputan setelah selesai menambahkan data
            resetInput();
            
            // Menempatkan fokus pada JTextField tfNip
            cbNip.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data ke database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private int getIdPegawaiByNip(String nip) throws SQLException {
        String sql = "SELECT id FROM data_pegawai WHERE nip=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nip);
        ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
             throw new SQLException("ID pegawai tidak ditemukan untuk NIP: " + nip);
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    // Ambil baris yang dipilih pada tabelAbsensi
    int selectedRow = tabelAbsensi.getSelectedRow();
    // Periksa apakah ada baris yang dipilih
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan diedit", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Ambil data dari baris yang dipilih
    String nip = tabelAbsensi.getValueAt(selectedRow, 0).toString();
    String tanggalRekap = tabelAbsensi.getValueAt(selectedRow, 3).toString();
    String jumlahMasuk = tabelAbsensi.getValueAt(selectedRow, 4).toString();
    String jumlahIzin = tabelAbsensi.getValueAt(selectedRow, 5).toString();

    // Membuat dialog untuk pengeditan
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2));
    JLabel lblNip = new JLabel("NIP: ");
    JLabel lblTanggalRekap = new JLabel("Tanggal Rekap: ");
    JLabel lblJumlahMasuk = new JLabel("Jumlah Masuk: ");
    JLabel lblJumlahIzin = new JLabel("Jumlah Izin: ");
    JTextField tfNip = new JTextField(nip);
    JTextField tfTanggalRekap = new JTextField(tanggalRekap);
    JTextField tfJumlahMasuk = new JTextField(jumlahMasuk);
    JTextField tfJumlahIzin = new JTextField(jumlahIzin);

    // Mengatur JTextField agar tidak bisa diubah
    tfNip.setEditable(false);
    tfTanggalRekap.setEditable(false);

    // Menambahkan komponen ke dalam panel
    panel.add(lblNip);
    panel.add(tfNip);
    panel.add(lblTanggalRekap);
    panel.add(tfTanggalRekap);
    panel.add(lblJumlahMasuk);
    panel.add(tfJumlahMasuk);
    panel.add(lblJumlahIzin);
    panel.add(tfJumlahIzin);

    // Menampilkan dialog pengeditan
    int result = JOptionPane.showConfirmDialog(this, panel, "Edit Data Absensi",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    // Jika pengguna menekan OK
    if (result == JOptionPane.OK_OPTION) {
        try {
            // Mengupdate data pada tabel data_absensi di database
            String sql = "UPDATE data_absensi SET jumlah_masuk=?, jumlah_izin=? WHERE id_pegawai = (SELECT id FROM data_pegawai WHERE nip = ?) AND tanggal_rekap = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, tfJumlahMasuk.getText());
            statement.setString(2, tfJumlahIzin.getText());
            statement.setString(3, nip);
            statement.setString(4, tanggalRekap);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Setelah berhasil mengedit data, refresh tabelAbsensi
                refreshTableAbsensi();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengedit data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // Ambil baris yang dipilih pada tabelAbsensi
        int selectedRow = tabelAbsensi.getSelectedRow();
        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
        }
        
        // Konfirmasi penghapusan dengan pengguna
        int option = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
        // Ambil NIP dan tanggal rekap dari baris yang dipilih
        String nip = tabelAbsensi.getValueAt(selectedRow, 0).toString();
        String tanggalRekap = tabelAbsensi.getValueAt(selectedRow, 3).toString();

        // Hapus data dari tabelAbsensi
        DefaultTableModel model = (DefaultTableModel) tabelAbsensi.getModel();
        model.removeRow(selectedRow);

        // Hapus data dari tabel data_absensi di database
        deleteDataAbsensiFromDatabase(nip, tanggalRekap);
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Mengosongkan nilai pada semua field input
        cbNip.setSelectedIndex(0);
        jdRekap.setDate(null);
        tfMasuk.setText("");
        tfIzin.setText("");
        cbNip.requestFocus();
    }//GEN-LAST:event_btnResetActionPerformed

    private void cbNipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNipActionPerformed

    }//GEN-LAST:event_cbNipActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
    int option = JOptionPane.showConfirmDialog(this, "Apakah Anda ingin mencetak data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (option == JOptionPane.YES_OPTION) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Membuat tabel yang akan dicetak
                JTable tableToPrint = new JTable(tabelAbsensi.getModel());
                // Mengambil model tabel
                TableModel model = tableToPrint.getModel();
                // Menghitung jumlah kolom dan baris
                int rowCount = model.getRowCount();
                int colCount = model.getColumnCount();

                // Mengatur font untuk judul tabel
                Font titleFont = new Font("Arial", Font.BOLD, 16);
                g2d.setFont(titleFont);
                // Sesuaikan koordinat x dan y untuk judul tabel
                g2d.drawString("DATA REKAP ABSENSI", 20, 20);

                // Mengatur font untuk judul kolom
                Font font = new Font("Arial", Font.BOLD, 12);
                g2d.setFont(font);

                // Menggambar judul kolom
                int titleHeight = tableToPrint.getTableHeader().getHeight();
                for (int col = 0; col < colCount; col++) {
                    String title = model.getColumnName(col);
                    // Sesuaikan koordinat x dan y untuk kolom NIP
                    if (col == 0) {
                        g2d.drawString(title, col * 100 + 20, titleHeight + 60);
                    } else {
                        g2d.drawString(title, col * 100, titleHeight + 60);
                    }
                }

                // Mengatur font kembali ke default
                font = new Font("Arial", Font.PLAIN, 10);
                g2d.setFont(font);

                // Menggambar baris data
                for (int row = 0; row < rowCount; row++) {
                    // Sesuaikan koordinat y agar data tidak terlalu ke atas
                    int y = (row + 2) * 15 + titleHeight + 60;
                    for (int col = 0; col < colCount; col++) {
                        Object value = model.getValueAt(row, col);
                        // Sesuaikan koordinat x dan y untuk kolom NIP
                        if (col == 0) {
                            g2d.drawString(value.toString(), col * 100 + 20, y);
                        } else {
                            g2d.drawString(value.toString(), col * 100, y);
                        }
                    }
                }
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();

        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Gagal mencetak data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCariActionPerformed
        tampilkanDataDariDatabase();
    }//GEN-LAST:event_tfCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbNip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdRekap;
    private javax.swing.JTable tabelAbsensi;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfIzin;
    private javax.swing.JTextField tfMasuk;
    // End of variables declaration//GEN-END:variables

    private void populateNipComboBox() {
    try {
        // Bersihkan ComboBox sebelum menambahkan data
        cbNip.removeAllItems();
        // Tambahkan opsi "--Pilih NIP--"
        cbNip.addItem("--Pilih NIP--");

        // Ambil data NIP dari tabel data_pegawai
        String sql = "SELECT * FROM data_pegawai";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        // Tambahkan NIP ke dalam ComboBox
        while (resultSet.next()) {
            String nip = resultSet.getString("nip");
            String namaPegawai = resultSet.getString("nama_pegawai");
            // Gabungkan NIP dan nama_pegawai dalam format yang diinginkan
            String displayValue = nip + " - " + namaPegawai;
            
            // Tambahkan ke ComboBox
            cbNip.addItem(displayValue);
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}

    // Metode untuk menampilkan data di tabelAbsensi
    private void refreshTableAbsensi() {
    try {
        // Bersihkan tabelAbsensi
        DefaultTableModel model = (DefaultTableModel) tabelAbsensi.getModel();
        model.setRowCount(0);

        // Ambil data dari tabel data_absensi dengan join tabel data_pegawai
        String sql = "SELECT data_pegawai.nip, data_pegawai.nama_pegawai, data_pegawai.jabatan, "
                   + "data_absensi.tanggal_rekap, data_absensi.jumlah_masuk, data_absensi.jumlah_izin "
                   + "FROM data_absensi "
                   + "JOIN data_pegawai ON data_absensi.id_pegawai = data_pegawai.id";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        // Tambahkan data ke dalam tabelAbsensi
        while (resultSet.next()) {
            String nip = resultSet.getString("nip");
            String namaPegawai = resultSet.getString("nama_pegawai");
            String jabatan = resultSet.getString("jabatan");
            String tanggalRekap = resultSet.getString("tanggal_rekap");
            String jumlahMasuk = resultSet.getString("jumlah_masuk");
            String jumlahIzin = resultSet.getString("jumlah_izin");

            // Tambahkan baris baru ke dalam tabelAbsensi
            model.addRow(new Object[]{nip, namaPegawai, jabatan, tanggalRekap, jumlahMasuk, jumlahIzin});

            // Pernyataan pencetakan (opsional)
            System.out.println("Added row: " + nip + ", " + namaPegawai + ", " + jabatan + ", " + tanggalRekap + ", " + jumlahMasuk + ", " + jumlahIzin);
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}

    private void deleteDataAbsensiFromDatabase(String nip, String tanggalRekap) {
    try {
        // Lakukan penghapusan data_absensi berdasarkan NIP dan tanggal rekap
        String sql = "DELETE FROM data_absensi WHERE id_pegawai = (SELECT id FROM data_pegawai WHERE nip = ?) AND tanggal_rekap = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nip);
        statement.setString(2, tanggalRekap);
        int rowsDeleted = statement.executeUpdate();

        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data dari database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menghapus data dari database", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void resetInput() {
        cbNip.setSelectedIndex(0);
        jdRekap.setDate(null);
        tfMasuk.setText("");
        tfIzin.setText(""); 
    }

    private void tampilkanDataDariDatabase() {
    try {
        String searchKeyword = tfCari.getText().trim(); // Get search keyword from tfCari
        // SQL query to retrieve data with optional search filter
        String sql = "SELECT nip, nama_pegawai, tempat_lahir, tanggal_lahir, alamat, telepon, jabatan FROM data_pegawai"
                + (searchKeyword.isEmpty() ? "" : " WHERE nama_pegawai LIKE ?");
        PreparedStatement statement = conn.prepareStatement(sql);

        if (!searchKeyword.isEmpty()) {
            statement.setString(1, "%" + searchKeyword + "%");
        }

        ResultSet resultSet = statement.executeQuery();
        DefaultTableModel model = (DefaultTableModel) tabelAbsensi.getModel();
        model.setRowCount(0); // Menghapus semua baris yang ada dalam tabel

        while (resultSet.next()) {
            String nip = resultSet.getString("nip");
            String nama = resultSet.getString("nama_pegawai");
            String tempatLahir = resultSet.getString("tempat_lahir");
            String strTanggalLahir = resultSet.getString("tanggal_lahir");
            String alamat = resultSet.getString("alamat");
            String telepon = resultSet.getString("telepon");
            String jabatan = resultSet.getString("jabatan");
            model.addRow(new Object[]{nip, nama, tempatLahir, strTanggalLahir, alamat, telepon, jabatan});
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
  }
}
