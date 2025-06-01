package com.tubespbo.tubesweb.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetailTransaksi implements Serializable {
    private int idDetail;
    private String noPesanan;
    private Produk produk;
    private String nama;
    private BigDecimal harga;
    private int kuantitas;
    private BigDecimal subtotal;

    public DetailTransaksi() {
    }

    public DetailTransaksi(int idDetail, String noPesanan, Produk produk, String nama, BigDecimal harga, int kuantitas, BigDecimal subtotal) {
        this.idDetail = idDetail;
        this.noPesanan = noPesanan;
        this.produk = produk;
        this.nama = nama;
        this.harga = harga;
        this.kuantitas = kuantitas;
        this.subtotal = subtotal;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public String getNoPesanan() {
        return noPesanan;
    }

    public void setNoPesanan(String noPesanan) {
        this.noPesanan = noPesanan;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
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

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetailTransaksi{" +
                "idDetail=" + idDetail +
                ", noPesanan='" + noPesanan + '\'' +
                ", produk=" + (produk != null ? produk.getKodeProduk() : "null") + // Hanya kode produk untuk ringkasan
                ", namaProdukSaatTransaksi='" + nama + '\'' +
                ", hargaSatuanSaatTransaksi=" + harga +
                ", kuantitas=" + kuantitas +
                ", subtotal=" + subtotal +
                '}';
    }
}
