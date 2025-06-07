package com.tubespbo.tubesweb.controller.action;

import com.tubespbo.tubesweb.model.Pengguna;
import com.tubespbo.tubesweb.model.service.PenggunaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String nama = request.getParameter("nama");
        String password = request.getParameter("password");

        PenggunaService penggunaService = new PenggunaService();
        Pengguna pengguna = penggunaService.validatePengguna(nama, password);

        if (pengguna != null) {
            // Jika validasi berhasil, buat sesi
            HttpSession session = request.getSession(true);
            session.setAttribute("user", pengguna);

            // PERUBAHAN: Kembalikan perintah redirect, bukan forward ke JSP.
            // Biarkan DashboardAction yang menangani logika untuk menampilkan dasbor.
            return "redirect:controller?action=dashboard";

        } else {
            // Jika validasi gagal, kembali ke halaman login dengan pesan error (ini tetap forward)
            request.setAttribute("errorMessage", "Nama pengguna atau password salah.");
            return "login.jsp";
        }
    }
}