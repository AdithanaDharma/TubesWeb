package com.tubespbo.tubesweb.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produk implements Serializable {
    private String kodeProduk;
    private String nama;
    private BigDecimal harga;
    private int stok;

    public Produk() {
    }

    public Produk(String kodeProduk, String nama, BigDecimal harga, int stok) {
        this.kodeProduk = kodeProduk;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Produk{" +
                "kodeProduk='" + kodeProduk + '\'' +
                ", nama='" + nama + '\'' +
                ", harga=" + harga +
                ", stok=" + stok +
                '}';
    }
}
