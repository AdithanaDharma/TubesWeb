package com.tubespbo.tubesweb.controller.action;

import com.tubespbo.tubesweb.model.Pengguna;
import com.tubespbo.tubesweb.model.Produk;
import com.tubespbo.tubesweb.model.service.ProdukService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class DashboardAction implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        // Periksa apakah ada sesi dan atribut "user" di dalamnya
        if (session == null || session.getAttribute("user") == null) {
            // Jika tidak, arahkan pengguna ke halaman login dengan pesan error
            request.setAttribute("errorMessage", "Silakan login untuk mengakses halaman ini.");
            return "login.jsp";
        }

        // Jika sesi valid, lanjutkan untuk memuat data dasbor
        ProdukService produkService = new ProdukService();

        // Ambil semua data produk dari database
        List<Produk> produkList = produkService.getAllProduk();

        // Set daftar produk sebagai atribut pada request agar bisa diakses di JSP
        request.setAttribute("daftarProduk", produkList);

        // Kembalikan nama file JSP yang akan ditampilkan
        return "dashboard.jsp";
    }
}