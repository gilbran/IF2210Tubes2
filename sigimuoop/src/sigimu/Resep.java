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
public class Resep {
    public Resep() {
        idresep = -1;
        pasien = new Pasien();
        dokter = new Dokter();
        aperawatan = new Perawatan[10];
        damagecost = 0;
    }
    
    public Resep(int _idresep) throws Exception {
        idresep = _idresep;
        
        String query1 = "SELECT * FROM resep WHERE id_resep = " + _idresep;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt1 = conn.createStatement();
        ResultSet rs1 = stt1.executeQuery(query1);
        
        int _idpasien = -1;
        int _iddokter = -1;
        Date _tanggal = null;
        int _damagecost = -1;
        boolean _statusbayar = false;
        
        //retrieving
        while(rs1.next()) {
            _idpasien = rs1.getInt("idpasien");
            _iddokter = rs1.getInt("iddokter");
            _tanggal = rs1.getDate("tanggal");
            _damagecost = rs1.getInt("damagecost");
            _statusbayar = rs1.getBoolean("statusbayar");
        }
        
        pasien = new Pasien(_idpasien);
        dokter = new Dokter(_iddokter);
        tanggal = _tanggal;
        damagecost = _damagecost;
        aperawatan = new Perawatan[10];
        statusbayar = _statusbayar;
        
        String query2 = "SELECT * FROM perawatanhistoy WHERE id_resep = " + _idresep;
        Statement stt2 = conn.createStatement();
        ResultSet rs2 = stt1.executeQuery(query2);
        int i=0;
        int _idperawatan = -1;
        //retrieving and assigning aperawatan
        while(rs2.next()) {
            i++;
            aperawatan[i] = new Perawatan(_idperawatan);
        }
        conn.close();
    }
    
    public int getidresep() {
        return idresep;
    }
    
    public Pasien getpasien() {
        return pasien;
    }
    
    public Dokter getdokter() {
        return dokter;
    }
    
    public Date gettanggal() {
        return tanggal;
    }
    
    public Perawatan getaperawatan(int i) {
        return aperawatan[i];
    }
    
    public int getdamagecost() {
        return damagecost;
    }
    
    public boolean getstatusbayar() {
        return statusbayar;
    }
    
    public void setid(int _idresep) {
        idresep = _idresep;
    }
    
    public void setpasien(Pasien _pasien) {
        pasien = _pasien;
    }
    
    public void setdokter(Dokter _dokter) {
        dokter = _dokter;
    }
    
    public void settanggal(Date _tanggal) {
        tanggal = _tanggal;
    }
    
    public void setaperawatan(int i, Perawatan _perawatan) {
        aperawatan[i] = _perawatan;
    }
    
    public void setdamagecost(int _damagecost) {
        damagecost = _damagecost;
    }
    
    public void setstatusbayar(boolean _statusbayar) {
        statusbayar = _statusbayar;
    }
    
    private int idresep;
    private Pasien pasien;
    private Dokter dokter;
    private Date tanggal;
    private Perawatan[] aperawatan;
    private int damagecost;
    private boolean statusbayar;
}
