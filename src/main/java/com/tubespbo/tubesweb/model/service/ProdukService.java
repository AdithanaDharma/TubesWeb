package com.tubespbo.tubesweb.model.service;

import com.tubespbo.tubesweb.model.Produk;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

public class ProdukService {

    private static final Logger LOGGER = Logger.getLogger(ProdukService.class.getName());

    final String INSERT_SQL = "INSERT INTO produk(kodeProduk, nama, harga, stok) VALUES (?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE produk SET nama = ?, harga = ?, stok = ? WHERE kodeProduk = ?";
    final String DELETE_SQL = "DELETE FROM produk WHERE kodeProduk = ?";
    final String SELECT_ALL_SQL = "SELECT kodeProduk, nama, harga, stok FROM produk";
    final String SELECT_PAGINATED_SQL = "SELECT kodeProduk, nama, harga, stok FROM produk LIMIT ?, ?";
    final String COUNT_SQL = "SELECT COUNT(kodeProduk) AS total FROM produk";
    final String SELECT_ONE_SQL = "SELECT kodeProduk, nama, harga, stok FROM produk WHERE kodeProduk = ?";

    public ProdukService() {
    }

    public boolean addProduk(Produk produk) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean success = false;
        try {
            conn = DBHandler.getConnection();
            ps = conn.prepareStatement(INSERT_SQL);
            ps.setString(1, produk.getKodeProduk());
            ps.setString(2, produk.getNama());
            ps.setBigDecimal(3, produk.getHarga());
            ps.setInt(4, produk.getStok());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                LOGGER.log(Level.INFO, "Produk added successfully: {0}", produk.getKodeProduk());
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error adding produk: " + produk.getKodeProduk(), ex);
        } finally {
            closeResources(ps, conn);
        }
        return success;
    }

    public boolean updateProduk(Produk produk) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean success = false;
        try {
            conn = DBHandler.getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, produk.getNama());
            ps.setBigDecimal(2, produk.getHarga());
            ps.setInt(3, produk.getStok());
            ps.setString(4, produk.getKodeProduk());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                LOGGER.log(Level.INFO, "Produk updated successfully: {0}", produk.getKodeProduk());
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error updating produk: " + produk.getKodeProduk(), ex);
        } finally {
            closeResources(ps, conn);
        }
        return success;
    }

    public boolean deleteProduk(String kodeProduk) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean success = false;
        try {
            conn = DBHandler.getConnection();
            ps = conn.prepareStatement(DELETE_SQL);
            ps.setString(1, kodeProduk);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                LOGGER.log(Level.INFO, "Produk deleted successfully: {0}", kodeProduk);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error deleting produk: " + kodeProduk, ex);
        } finally {
            closeResources(ps, conn);
        }
        return success;
    }

    public List<Produk> getAllProduk() {
        List<Produk> produkList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBHandler.getConnection();
            ps = conn.prepareStatement(SELECT_ALL_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                produkList.add(mapResultSetToProduk(rs));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error getting all produk", ex);
        } finally {
            closeResources(rs, ps, conn);
        }
        return produkList;
    }

    public List<Produk> getProdukPaginated(int offset, int limit) {
        List<Produk> produkList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBHandler.getConnection();
            ps = conn.prepareStatement(SELECT_PAGINATED_SQL);
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            while (rs.next()) {
                produkList.add(mapResultSetToProduk(rs));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error getting paginated produk", ex);
        } finally {
            closeResources(rs, ps, conn);
        }
        return produkList;
    }

    public Produk getProdukByKode(String kodeProduk) {
        Produk produk = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBHandler.getConnection();
            ps = conn.prepareStatement(SELECT_ONE_SQL);
            ps.setString(1, kodeProduk);
            rs = ps.executeQuery();
            if (rs.next()) {
                produk = mapResultSetToProduk(rs);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error getting produk by kode: " + kodeProduk, ex);
        } finally {
            closeResources(rs, ps, conn);
        }
        return produk;
    }

    public int getTotalProdukCount() {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBHandler.getConnection();
            ps = conn.prepareStatement(COUNT_SQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error getting produk count", ex);
        } finally {
            closeResources(rs, ps, conn);
        }
        return count;
    }

    private Produk mapResultSetToProduk(ResultSet rs) throws SQLException {
        String kodeProduk = rs.getString("kodeProduk");
        String nama = rs.getString("nama");
        BigDecimal harga = rs.getBigDecimal("harga");
        int stok = rs.getInt("stok");
        return new Produk(kodeProduk, nama, harga, stok);
    }

    private void closeResources(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    if (resource instanceof Connection) {
                        DBHandler.closeConnection((Connection) resource);
                    } else {
                        resource.close();
                    }
                } catch (Exception ex) {
                    LOGGER.log(Level.WARNING, "Failed to close database resource.", ex);
                }
            }
        }
    }
}