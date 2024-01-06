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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FormGaji extends javax.swing.JFrame {  
    
    private Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/uas_kepegawaian"; // Sesuaikan dengan URL database Anda
    private final String user = "root"; // Ganti dengan username database Anda
    private final String password = "";
    
    public FormGaji() {
        initComponents();
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
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tabelGaji.getModel());
                tabelGaji.setRowSorter(sorter);
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
            populateNipComboBox();
            cbNip.setSelectedIndex(0);
            cbNip.addActionListener((evt) -> {
                // Pemanggilan refreshTableGaji untuk memperbarui tabel dengan data terbaru
                refreshTableGaji();
            });
        
            System.out.println("ComboBox diisi dengan NIP:");
            for (int i = 0; i < cbNip.getItemCount(); i++) {
                System.out.println(cbNip.getItemAt(i));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        // Setelah menambahkan data ke dalam database, tampilkan data di tabelGaji
        refreshTableGaji();
        resetInput();
        cbNip.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfGaji = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        cbNip = new javax.swing.JComboBox<>();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jdGaji = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelGaji = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("PENGGAJIAN PEGAWAI");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Status");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Jumlah Gaji");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Status-", "Diterima", "Belum Diterima" }));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("NIP");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        cbNip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih NIP-" }));
        cbNip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNipActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Tanggal Gajihan");

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
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTambah)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKembali)
                                .addGap(18, 18, 18)
                                .addComponent(btnCetak)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbNip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdGaji, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbStatus, 0, 243, Short.MAX_VALUE)
                                    .addComponent(tfGaji, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(tfCari))
                                .addGap(47, 47, 47))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jdGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit)
                    .addComponent(btnReset)
                    .addComponent(btnKembali)
                    .addComponent(btnCetak))
                .addGap(31, 31, 31))
        );

        tabelGaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIP", "Nama Pegawai", "Jabatan", "Tanggal Gajihan", "Jumlah Gaji", "Status"
            }
        ));
        jScrollPane1.setViewportView(tabelGaji);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
    try {
        // Ambil nilai yang dipilih dari ComboBox cbNip
        String selectedNipNama = cbNip.getSelectedItem().toString();

        // Pisahkan nilai NIP dan nama pegawai
        String[] nipNamaArray = selectedNipNama.split(" - ");
        String nip = nipNamaArray[0];
        String namaPegawai = nipNamaArray[1];
        Date tanggalGajian = jdGaji.getDate();
        String jumlahGaji = tfGaji.getText();
        String status = cbStatus.getSelectedItem().toString();

        // Simpan data ke dalam data_gaji
        String sql = "INSERT INTO data_gaji (id_pegawai, tanggal_gaji, jumlah_gaji, status) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, getIdPegawaiByNip(nip));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(tanggalGajian);
        statement.setString(2, formattedDate);
        statement.setString(3, jumlahGaji);
        statement.setString(4, status);

        // Eksekusi pernyataan SQL untuk menyimpan data
        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE);           
            // Setelah berhasil menambahkan data, refresh tabelGaji
            refreshTableGaji();
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

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        FormMenu Formberanda = new FormMenu();
        Formberanda.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void cbNipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNipActionPerformed

    }//GEN-LAST:event_cbNipActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
    try {
        // Periksa apakah ada baris yang dipilih di tabelGaji
        int selectedRow = tabelGaji.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode jika tidak ada baris yang dipilih
        }

        // Ambil nilai NIP dari baris yang dipilih di tabelGaji
        String nip = tabelGaji.getValueAt(selectedRow, 0).toString();

        // Konfirmasi pengguna sebelum menghapus data
        int dialogResult = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Hapus data dari tabel data_gaji berdasarkan NIP
            String deleteSql = "DELETE FROM data_gaji WHERE id_pegawai=?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
            deleteStatement.setInt(1, getIdPegawaiByNip(nip));
            int rowsDeleted = deleteStatement.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Setelah berhasil menghapus data, refresh tabelGaji
                refreshTableGaji();
                resetInput();

                // Menempatkan fokus pada JComboBox cbNip
                cbNip.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data dari database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetInput();
        cbNip.requestFocus();
    }//GEN-LAST:event_btnResetActionPerformed

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
                JTable tableToPrint = new JTable(tabelGaji.getModel());
                // Mengambil model tabel
                TableModel model = tableToPrint.getModel();
                // Menghitung jumlah kolom dan baris
                int rowCount = model.getRowCount();
                int colCount = model.getColumnCount();

                // Mengatur font untuk judul tabel
                Font titleFont = new Font("Arial", Font.BOLD, 16);
                g2d.setFont(titleFont);
                // Sesuaikan koordinat x dan y untuk judul tabel
                g2d.drawString("DATA PENGGAJIAN PEGAWAI", 20, 20);

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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    // Ambil baris yang dipilih pada tabelGaji
    int selectedRow = tabelGaji.getSelectedRow();
    // Periksa apakah ada baris yang dipilih
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan diedit", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Ambil data dari baris yang dipilih
    String nip = tabelGaji.getValueAt(selectedRow, 0).toString();
    String tanggalPenggajian = tabelGaji.getValueAt(selectedRow, 3).toString();
    String jumlahGaji = tabelGaji.getValueAt(selectedRow, 4).toString();
    String status = tabelGaji.getValueAt(selectedRow, 5).toString();

    // Membuat dialog untuk pengeditan
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2));
    JLabel lblNip = new JLabel("NIP: ");
    JLabel lblTanggalPenggajian = new JLabel("Tanggal Penggajian: ");
    JLabel lblJumlahGaji = new JLabel("Jumlah Gaji: ");
    JLabel lblStatus = new JLabel("Status: ");
    JTextField tfNip = new JTextField(nip);
    JTextField tfTanggalPenggajian = new JTextField(tanggalPenggajian);
    JTextField tfJumlahGaji = new JTextField(jumlahGaji);
    JTextField tfStatus = new JTextField(status);

    // Mengatur JTextField agar tidak bisa diubah
    tfNip.setEditable(false);

    // Menambahkan komponen ke dalam panel
    panel.add(lblNip);
    panel.add(tfNip);
    panel.add(lblTanggalPenggajian);
    panel.add(tfTanggalPenggajian);
    panel.add(lblJumlahGaji);
    panel.add(tfJumlahGaji);
    panel.add(lblStatus);
    panel.add(tfStatus);

    // Menampilkan dialog pengeditan
    int result = JOptionPane.showConfirmDialog(this, panel, "Edit Data Penggajian",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    // Jika pengguna menekan OK
    if (result == JOptionPane.OK_OPTION) {
        try {
            // Mengupdate data pada tabel data_gaji di database
            String sql = "UPDATE data_gaji SET jumlah_gaji=?, status=? WHERE id_pegawai = (SELECT id FROM data_pegawai WHERE nip = ?) AND tanggal_gaji = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, tfJumlahGaji.getText());
            statement.setString(2, tfStatus.getText());
            statement.setString(3, nip);
            statement.setString(4, tanggalPenggajian);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Setelah berhasil mengedit data, refresh tabelGaji
                refreshTableGaji();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengedit data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbNip;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdGaji;
    private javax.swing.JTable tabelGaji;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfGaji;
    // End of variables declaration//GEN-END:variables

    private void populateNipComboBox() {
        try {
            // Bersihkan ComboBox sebelum menambahkan data
            cbNip.removeAllItems();
            // Tambahkan opsi "--Pilih NIP--"
            cbNip.addItem("-Pilih NIP-");

            // Ambil data NIP dan nama_pegawai dari tabel data_pegawai
            String sql = "SELECT nip, nama_pegawai FROM data_pegawai";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Tambahkan NIP dan nama_pegawai ke dalam ComboBox
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

    private void resetInput() {
        cbNip.setSelectedIndex(0);
        jdGaji.setDate(null);
        tfGaji.setText("");
        cbStatus.setSelectedIndex(0);
    }
    
        private void refreshTableGaji() {
        try {
            // Bersihkan tabelGaji
            DefaultTableModel model = (DefaultTableModel) tabelGaji.getModel();
            model.setRowCount(0);

            // Ambil data dari tabel data_gaji dengan join tabel data_pegawai dan data_gaji
            String sql = "SELECT dp.nip, dp.nama_pegawai, dp.jabatan, dg.jumlah_gaji, dg.status, dg.tanggal_gaji "
                    + "FROM data_gaji dg "
                    + "JOIN data_pegawai dp ON dg.id_pegawai = dp.id ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Tambahkan data ke dalam tabelGaji
            while (resultSet.next()) {
                String nip = resultSet.getString("nip");
                String namaPegawai = resultSet.getString("nama_pegawai");
                String jabatan = resultSet.getString("jabatan");
                String jumlahGaji = resultSet.getString("jumlah_gaji");
                String status = resultSet.getString("status");
                String formattedDate = resultSet.getString("tanggal_gaji");

                // Tambahkan baris baru ke dalam tabelGaji tanpa mengatur ulang model
                addRowToTable(nip, namaPegawai, jabatan, jumlahGaji, status, formattedDate);

                // Pernyataan pencetakan (opsional)
                System.out.println("Added row: " + nip + ", " + namaPegawai + ", " + jabatan + ", " + jumlahGaji + ", " + status + ", " + formattedDate);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }


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

    private void addRowToTable(String nip, String namaPegawai, String jabatan, String jumlahGaji, String status, String formattedDate) {
        // Menampilkan data pegawai di tabelGaji
        DefaultTableModel model = (DefaultTableModel) tabelGaji.getModel();
        model.addRow(new Object[]{nip, namaPegawai, jabatan, formattedDate, jumlahGaji, status});
    }

    private void tampilkanDataDariDatabase() {
    try {
        String searchKeyword = tfCari.getText().trim(); // Get search keyword from tfCari
        // SQL query to retrieve data with optional search filter
        String sql = "SELECT nip, nama_pegawai,jabatan FROM data_pegawai"
                + (searchKeyword.isEmpty() ? "" : " WHERE nama_pegawai LIKE ?");
        PreparedStatement statement = conn.prepareStatement(sql);

        if (!searchKeyword.isEmpty()) {
            statement.setString(1, "%" + searchKeyword + "%");
        }

        ResultSet resultSet = statement.executeQuery();
        DefaultTableModel model = (DefaultTableModel) tabelGaji.getModel();
        model.setRowCount(0); // Menghapus semua baris yang ada dalam tabel

        while (resultSet.next()) {
            String nip = resultSet.getString("nip");
            String nama = resultSet.getString("nama_pegawai");
            String jabatan = resultSet.getString("jabatan");
            model.addRow(new Object[]{nip, nama, jabatan});
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
  }
}
