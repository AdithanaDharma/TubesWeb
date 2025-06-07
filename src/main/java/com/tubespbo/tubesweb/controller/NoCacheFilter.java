package com.tubespbo.tubesweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter ini mencegah browser menyimpan cache untuk halaman-halaman yang dilindungi.
 * Ini menyelesaikan masalah di mana pengguna bisa menekan tombol "back" setelah logout
 * dan melihat halaman yang sebelumnya di-cache.
 */
@WebFilter("/controller") // Terapkan filter ini ke semua request yang melalui ControllerServlet
public class NoCacheFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) res;

        // Set header untuk mencegah caching
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        httpResponse.setDateHeader("Expires", 0); // Proxies.

        // Lanjutkan rantai filter
        chain.doFilter(req, res);
    }

    // Metode init dan destroy bisa dikosongkan jika tidak ada inisialisasi/pembersihan khusus
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}