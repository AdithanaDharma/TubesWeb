package com.tubespbo.tubesweb.model.service;

import com.tubespbo.tubesweb.model.DetailTransaksi;
import com.tubespbo.tubesweb.model.JudulTransaksi;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaksiService {

    private static final Logger LOGGER = Logger.getLogger(TransaksiService.class.getName());

    public boolean addTransaksi(JudulTransaksi judul) {
        Connection conn = null;
        PreparedStatement psJudul = null;
        PreparedStatement psDetail = null;
        boolean success = false;

        String insertJudulSql = "INSERT INTO transaksi (noPesanan, namaPembeli, tanggalTransaksi, total) VALUES (?, ?, ?, ?)";
        String insertDetailSql = "INSERT INTO detail_transaksi (noPesanan, kodeProduk, nama, harga, kuantitas, subtotal) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = DBHandler.getConnection();
            conn.setAutoCommit(false); // Mulai transaksi

            // Insert judul transaksi
            psJudul = conn.prepareStatement(insertJudulSql);
            psJudul.setString(1, judul.getNoPesanan());
            psJudul.setString(2, judul.getNamaPembeli());
            psJudul.setDate(3, java.sql.Date.valueOf(judul.getTanggalTransaksi()));
            psJudul.setBigDecimal(4, judul.getTotalTransaksi());
            psJudul.executeUpdate();

            // Insert detail transaksi
            psDetail = conn.prepareStatement(insertDetailSql);
            for (DetailTransaksi detail : judul.getDetails()) {
                psDetail.setString(1, judul.getNoPesanan());
                psDetail.setString(2, detail.getProduk().getKodeProduk());
                psDetail.setString(3, detail.getNama());
                psDetail.setBigDecimal(4, detail.getHarga());
                psDetail.setInt(5, detail.getKuantitas());
                psDetail.setBigDecimal(6, detail.getSubtotal());
                psDetail.addBatch();
            }
            psDetail.executeBatch();

            conn.commit(); // Commit transaksi jika semua berhasil
            success = true;
            LOGGER.log(Level.INFO, "Transaksi berhasil ditambahkan: {0}", judul.getNoPesanan());

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Gagal menambahkan transaksi: " + judul.getNoPesanan(), ex);
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback jika terjadi error
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Gagal melakukan rollback transaksi", e);
                }
            }
        } finally {
            closeResources(psDetail, psJudul);
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Gagal mengembalikan auto-commit ke true", ex);
                }
            }
            DBHandler.closeConnection(conn);
        }
        return success;
    }

    private void closeResources(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception ex) {
                    LOGGER.log(Level.WARNING, "Gagal menutup resource database.", ex);
                }
            }
        }
    }
}