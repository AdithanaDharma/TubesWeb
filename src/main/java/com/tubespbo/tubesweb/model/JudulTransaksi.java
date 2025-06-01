package com.tubespbo.tubesweb.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;

public class JudulTransaksi implements Serializable  {
    private String noPesanan;
    private String namaPembeli;
    private LocalDate tanggalTransaksi;
    private BigDecimal totalTransaksi;

    private List<DetailTransaksi> details;

    public JudulTransaksi() {
    }

    public JudulTransaksi(String noPesanan, String namaPembeli, LocalDate tanggalTransaksi, BigDecimal totalTransaksi) {
        this.noPesanan = noPesanan;
        this.namaPembeli = namaPembeli;
        this.tanggalTransaksi = tanggalTransaksi;
        this.totalTransaksi = totalTransaksi;
    }

    public String getNoPesanan() {
        return noPesanan;
    }

    public void setNoPesanan(String noPesanan) {
        this.noPesanan = noPesanan;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public LocalDate getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(LocalDate tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public BigDecimal getTotalTransaksi() {
        return totalTransaksi;
    }

    public void setTotalTransaksi(BigDecimal totalTransaksi) {
        this.totalTransaksi = totalTransaksi;
    }

    public List<DetailTransaksi> getDetails() {
        return details;
    }

    public void setDetails(List<DetailTransaksi> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "noPesanan='" + noPesanan + '\'' +
                ", namaPembeli='" + namaPembeli + '\'' +
                ", tanggalTransaksi=" + tanggalTransaksi +
                ", totalTransaksi=" + totalTransaksi +
                ", details=" + details +
                '}';
    }
}
