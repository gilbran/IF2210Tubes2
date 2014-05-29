/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigimu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author andi
 */
public class Perawatan {
    public Perawatan() {
        idperawatan = 0;
        nama = "UNDEFINED";
        deskripsi = "UNDEFINED";
    }
    
    public Perawatan(int _idperawatan) throws Exception {
        idperawatan = _idperawatan;
        
        //connecting to database
        String query = "SELECT * FROM perawatan WHERE id_perawatan = " + _idperawatan;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        ResultSet rs = stt.executeQuery(query);
        
        String _nama = null;
        String _deskripsi = null;
        
        //retrieving
        while(rs.next()) {
            _nama = rs.getString("nama");
            _deskripsi = rs.getString("deskripsi");
        }
        conn.close();
        
        nama = _nama;
        deskripsi = _deskripsi;
    }
    
    public int getidperawatan() {
        return idperawatan;
    }
    
    public String getnama() {
        return nama;
    }
    
    public String getdeskripsi() {
        return deskripsi;
    }
    
    public int getharga() {
        return harga;
    }
    
    public void setidperawatan(int _idperawatan) {
        idperawatan = _idperawatan;
    }
    public void setnama(String _nama) {
        nama = _nama;
    }
    
    public void setdeskripsi(String _deskripsi) {
        deskripsi = _deskripsi;
    }
    
    public void setharga(int _harga) {
        harga = _harga;
    }
    
    private int idperawatan;
    private String nama;
    private String deskripsi;
    private int harga;
}
