package com.tubespbo.tubesweb.model.service;

import com.tubespbo.tubesweb.model.Pengguna; //
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PenggunaService {

    private static final Logger LOGGER = Logger.getLogger(PenggunaService.class.getName());

    // SQL query to find a user with a matching username and password.
    final String VALIDATE_USER_SQL = "SELECT nama, password, recovery FROM user WHERE nama = ? AND password = ?";

    // SQL query to find a user by their username.
    final String SELECT_BY_NAME_SQL = "SELECT nama, password, recovery FROM user WHERE nama = ?";

    public Pengguna validatePengguna(String nama, String password) {
        Pengguna pengguna = null;
        // The try-with-resources statement ensures that each resource is closed automatically.
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement(VALIDATE_USER_SQL)) {

            ps.setString(1, nama);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                // If a record is found, it means the username and password are correct.
                if (rs.next()) {
                    // Map the data from the database row to a Pengguna object.
                    pengguna = mapResultSetToPengguna(rs);
                    LOGGER.log(Level.INFO, "Validation successful for user: {0}", nama);
                } else {
                    // If no record is found, the credentials are incorrect.
                    LOGGER.log(Level.WARNING, "Validation failed for user: {0}", nama);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error during user validation: " + nama, ex);
        }
        return pengguna; // Returns the user object if login is successful, or null if it fails.
    }

    public Pengguna getPenggunaByNama(String nama) {
        Pengguna pengguna = null;
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_NAME_SQL)) {

            ps.setString(1, nama);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pengguna = mapResultSetToPengguna(rs);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error getting user by name: " + nama, ex);
        }
        return pengguna;
    }

    private Pengguna mapResultSetToPengguna(ResultSet rs) throws SQLException {
        return new Pengguna(
                rs.getString("nama"),
                rs.getString("password"),
                rs.getString("recovery")
        );
    }
}