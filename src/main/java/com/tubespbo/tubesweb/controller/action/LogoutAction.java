package com.tubespbo.tubesweb.controller.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LogoutAction implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Ambil sesi yang ada, jangan buat baru
        if (session != null) {
            session.invalidate(); // Hapus sesi
        }
        request.setAttribute("successMessage", "Anda telah berhasil logout.");
        return "login.jsp"; // Arahkan kembali ke halaman login
    }
}