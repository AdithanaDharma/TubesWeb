package com.tubespbo.tubesweb.model;

import java.io.Serializable;

public class Pengguna implements Serializable {
    private String nama;
    private String password;
    private String recovery;

    public Pengguna() {
    }

    public Pengguna(String nama, String password, String recovery) {
        this.nama = nama;
        this.password = password;
        this.recovery = recovery;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }

    @Override
    public String toString() {
        return "Pengguna{" +
                "nama='" + nama + '\'' +
                ", password='" + "[REDACTED]" + '\'' +
                ", recovery='" + recovery + '\'' +
                '}';
    }
}