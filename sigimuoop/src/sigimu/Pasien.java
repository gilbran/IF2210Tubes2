/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigimu;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author andi
 */
public class Pasien extends Orang {
    public Pasien() {
        super();
        idpasien = -1;
        tempatlahir = "UNDEFINED";
        namabapak = "UNDEFINED";
        namaibu = "UNDEFINED";
        alamatdarurat = "UNDEFINED";
        notelpdarurat = "UNDEFINED";
    }
    
    public Pasien(int _idpasien) throws Exception {
        super();
        
        //connecting to database
        String query = "SELECT * FROM pasien WHERE id_pasien = " + _idpasien;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        ResultSet rs = stt.executeQuery(query);
        
        String _noktp = null;
        String _nama = null;
        String _alamat = null;
        String _notelp = null;
        String _tempatlahir = null;
        Date _tanggallahir = null;
        String _namabapak = null;
        String _namaibu = null;
        String _alamatdarurat = null;
        String _notelpdarurat = null;
        
        //retrieving
        while(rs.next()) {
            _noktp = rs.getString("noktp");
            _nama = rs.getString("nama");
            _alamat = rs.getString("alamat");
            _notelp = rs.getString("notelp");
            _tempatlahir = rs.getString("tempatlahir");
            _tanggallahir = rs.getDate("tanggallahir");
            _namabapak = rs.getString("namabapak");
            _namaibu = rs.getString("namaibu");
            _alamatdarurat = rs.getString("alamatdarurat");
            _notelpdarurat = rs.getString("notelpdarurat");
        }
        conn.close();
        
        noktp = _noktp;
        nama = _nama;
        alamat = _alamat;
        notelp = _notelp;
        idpasien = _idpasien;
        tempatlahir = _tempatlahir;
        tanggallahir = _tanggallahir;
        namabapak = _namabapak;
        namaibu = _namaibu;
        alamatdarurat = _alamatdarurat;
        notelpdarurat = _notelpdarurat;
    }
    
    public int getidpasien() {
        return idpasien;
    }
    
    public String gettempatlahir() {
        return tempatlahir;
    }
    
    public Date gettanggallahir() {
        return tanggallahir;
    }
    
    public String getnamabapak() {
        return namabapak;
    }
    
    public String getnamaibu() {
        return namaibu;
    }
    
    public String getalamatdarurat() {
        return alamatdarurat;
    }
    
    public String getnotelpdarurat() {
        return notelpdarurat;
    }
    
    public void setidpasien(int _idpasien) {
        idpasien = _idpasien;
    }
    
    public void settempatlahir(String _tempatlahir) {
        tempatlahir = _tempatlahir;
    }
    
    public void settanggallahirn(Date _tanggallahir) {
        tanggallahir = _tanggallahir;
    }
    
    public void setnamabapak(String _namabapak) {
        namabapak = _namabapak;
    }
    
    public void setnamaibu(String _namaibu) {
        namaibu = _namaibu;
    }
    
    public void setalamatdarurat(String _alamatdarurat) {
        alamatdarurat = _alamatdarurat;
    }
    
    public void setnotelpdarurat(String _notelpdarurat) {
        notelpdarurat = _notelpdarurat;
    }
    
    private int idpasien;
    private String tempatlahir;
    private Date tanggallahir;
    private String namabapak;
    private String namaibu;
    private String alamatdarurat;
    private String notelpdarurat;
}



