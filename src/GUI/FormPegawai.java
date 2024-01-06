package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class FormPegawai extends javax.swing.JFrame {  
    // Membuat koneksi database
    private Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/uas_kepegawaian"; // Sesuaikan dengan URL database Anda
    private final String user = "root"; // Ganti dengan username database Anda
    private final String password = ""; // Ganti dengan password database Anda
    
    public FormPegawai() {
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
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tabelPegawai.getModel());
                tabelPegawai.setRowSorter(sorter);
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
            tampilkanDataDariDatabase(); // Memanggil metode untuk menampilkan data dari database
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        tfNip.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfNip = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfTempat = new javax.swing.JTextField();
        tfAlamat = new javax.swing.JTextField();
        tfTelepon = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        cbJabatan = new javax.swing.JComboBox<>();
        btnKembali = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();
        jdTanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPegawai = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("DATA PEGAWAI");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("NIP");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Nama Pegawai");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Tanggal Lahir");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Tempat Lahir");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Alamat");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("Telepon");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Jabatan");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
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

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        cbJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Jabatan-", "Leader", "Manager", "Staff", "Karyawan" }));

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        tfCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCariActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setText("Cari");

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnTambah)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEdit)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(btnHapus)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnReset)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnKembali)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCetak))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jdTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                        .addComponent(tfNip, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                        .addComponent(tfNama, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                        .addComponent(tfTempat, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                                    .addGap(60, 60, 60)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfAlamat)
                    .addComponent(tfTelepon)
                    .addComponent(cbJabatan, 0, 238, Short.MAX_VALUE)
                    .addComponent(tfCari))
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(tfTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addComponent(jdTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnReset)
                    .addComponent(btnKembali)
                    .addComponent(btnCetak))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tabelPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIP", "Nama Pegawai", "Tempat Lahir", "Tanggal Lahir", "Alamat", "Telepon", "Jabatan"
            }
        ));
        jScrollPane2.setViewportView(tabelPegawai);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        FormMenu Formberanda = new FormMenu();
        Formberanda.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // Mengambil nilai dari inputan
        String nip = tfNip.getText();
        String nama = tfNama.getText();
        String tempatLahir = tfTempat.getText();
        Date tanggalLahir = jdTanggal.getDate();
        String alamat = tfAlamat.getText();
        String telepon = tfTelepon.getText();
        String jabatan = cbJabatan.getSelectedItem().toString();

        // Mengubah tanggal menjadi string dengan format MySQL
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strTanggalLahir = sdf.format(tanggalLahir);

        // Menambahkan data ke dalam tabel
        DefaultTableModel model = (DefaultTableModel) tabelPegawai.getModel();
        model.addRow(new Object[]{nip, nama, tempatLahir, strTanggalLahir, alamat, telepon, jabatan});

        // Menyimpan data ke dalam database
        try {
            String sql = "INSERT INTO data_pegawai (nip, nama_pegawai, tempat_lahir, tanggal_lahir, alamat, telepon, jabatan) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nip);
            statement.setString(2, nama);
            statement.setString(3, tempatLahir);
            statement.setString(4, strTanggalLahir);
            statement.setString(5, alamat);
            statement.setString(6, telepon);
            statement.setString(7, jabatan);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            
            // Mereset setiap inputan setelah selesai menambahkan data
            resetInput();
            tfNip.requestFocus();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data ke database");
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        tfNip.setText("");
        tfNama.setText("");
        jdTanggal.setDate(null);
        tfTempat.setText("");
        tfAlamat.setText("");
        tfTelepon.setText("");
        cbJabatan.setSelectedIndex(0); // Mengatur combobox kembali ke indeks pertama ("-Pilih Jabatan-")
        tfNip.requestFocus();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int selectedRow = tabelPegawai.getSelectedRow();
        if (selectedRow == -1) {
        // Jika tidak ada baris yang dipilih
        JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
        // Menampilkan dialog konfirmasi
        int option = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Mendapatkan nilai NIP dari baris yang dipilih
            String nip = tabelPegawai.getValueAt(selectedRow, 0).toString();

            // Menghapus data dari tabel
            DefaultTableModel model = (DefaultTableModel) tabelPegawai.getModel();
            model.removeRow(selectedRow);

            // Menghapus data dari database
            try {
                String sql = "DELETE FROM data_pegawai WHERE nip=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, nip);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                
                // Menempatkan fokus pada JTextField tfNip
                tfNip.requestFocus();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Gagal menghapus data dari database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = tabelPegawai.getSelectedRow();
        if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
        // Mengambil data dari baris yang dipilih
        String nip = tabelPegawai.getValueAt(selectedRow, 0).toString();
        String nama = tabelPegawai.getValueAt(selectedRow, 1).toString();
        String tempatLahir = tabelPegawai.getValueAt(selectedRow, 2).toString();
        String strTanggalLahir = tabelPegawai.getValueAt(selectedRow, 3).toString();
        String alamat = tabelPegawai.getValueAt(selectedRow, 4).toString();
        String telepon = tabelPegawai.getValueAt(selectedRow, 5).toString();
        String jabatan = tabelPegawai.getValueAt(selectedRow, 6).toString();

        // Mengisi input dengan data yang diambil
        tfNip.setText(nip);
        tfNama.setText(nama);
        tfTempat.setText(tempatLahir);
        jdTanggal.setDate(java.sql.Date.valueOf(strTanggalLahir)); // Mengonversi string ke java.sql.Date
        tfAlamat.setText(alamat);
        tfTelepon.setText(telepon);
        cbJabatan.setSelectedItem(jabatan);

        // Menampilkan dialog konfirmasi pengeditan
        int option = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengubah data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            // Memperbarui data di tabel
            DefaultTableModel model = (DefaultTableModel) tabelPegawai.getModel();
            model.setValueAt(tfNip.getText(), selectedRow, 0);
            model.setValueAt(tfNama.getText(), selectedRow, 1);
            model.setValueAt(tfTempat.getText(), selectedRow, 2);
            model.setValueAt(new SimpleDateFormat("yyyy-MM-dd").format(jdTanggal.getDate()), selectedRow, 3);
            model.setValueAt(tfAlamat.getText(), selectedRow, 4);
            model.setValueAt(tfTelepon.getText(), selectedRow, 5);
            model.setValueAt(cbJabatan.getSelectedItem().toString(), selectedRow, 6);

            // Memperbarui data di database
            try {
                String sql = "UPDATE data_pegawai SET nama_pegawai=?, tempat_lahir=?, tanggal_lahir=?, alamat=?, telepon=?, jabatan=? WHERE nip=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, tfNama.getText());
                statement.setString(2, tfTempat.getText());
                statement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(jdTanggal.getDate()));
                statement.setString(4, tfAlamat.getText());
                statement.setString(5, tfTelepon.getText());
                statement.setString(6, cbJabatan.getSelectedItem().toString());
                statement.setString(7, tfNip.getText());

                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");

                // Mengatur ulang input setelah pengeditan
                resetInput();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Gagal mengubah data di database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCariActionPerformed
        tampilkanDataDariDatabase();
    }//GEN-LAST:event_tfCariActionPerformed

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
                JTable tableToPrint = new JTable(tabelPegawai.getModel());
                // Mengambil model tabel
                TableModel model = tableToPrint.getModel();
                // Menghitung jumlah kolom dan baris
                int rowCount = model.getRowCount();
                int colCount = model.getColumnCount();

                // Mengatur font untuk judul tabel
                Font titleFont = new Font("Arial", Font.BOLD, 16);
                g2d.setFont(titleFont);
                // Sesuaikan koordinat x dan y untuk judul tabel
                g2d.drawString("DATA PEGAWAI", 20, 20);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbJabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdTanggal;
    private javax.swing.JTable tabelPegawai;
    private javax.swing.JTextField tfAlamat;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNip;
    private javax.swing.JTextField tfTelepon;
    private javax.swing.JTextField tfTempat;
    // End of variables declaration//GEN-END:variables

    private void tampilkanDataDariDatabase() {
        try {
        String searchKeyword = tfCari.getText().trim(); // Dapatkan kata kunci pencarian dari tfCari
        // Kueri SQL untuk mengambil data dengan filter pencarian opsional
        String sql = "SELECT nip, nama_pegawai, tempat_lahir, tanggal_lahir, alamat, telepon, jabatan FROM data_pegawai"
                + (searchKeyword.isEmpty() ? "" : " WHERE nama_pegawai LIKE ?");
        PreparedStatement statement = conn.prepareStatement(sql);

        if (!searchKeyword.isEmpty()) {
            statement.setString(1, "%" + searchKeyword + "%");
        }

        ResultSet resultSet = statement.executeQuery();
        DefaultTableModel model = (DefaultTableModel) tabelPegawai.getModel();
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

    private void resetInput() {
        tfNip.setText("");
        tfNama.setText("");
        jdTanggal.setDate(null);
        tfTempat.setText("");
        tfAlamat.setText("");
        tfTelepon.setText("");
        cbJabatan.setSelectedIndex(0);
    }
}
