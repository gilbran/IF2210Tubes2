/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigimu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author andi
 */
public class Ruangan {
    public Ruangan() {
        idruangan = -1;
        dokterbertugas = new Dokter();
        antrian = new Antrian();
    }
    
    public Ruangan(int _idruangan, int _iddokterbertugas) throws Exception{
        idruangan = -_idruangan;
        antrian = new Antrian();
        dokterbertugas = new Dokter(_iddokterbertugas);
        
        String query = "SELECT id_pasien FROM antrian WHERE id_ruangan = " + _idruangan;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        ResultSet rs = stt.executeQuery(query);
        int _idpasien = -1;
        while(rs.next()) {
            _idpasien = rs.getInt("id_pasien");
            antrian.push(new Pasien(_idpasien));
            System.out.println(_idpasien);
        }
        conn.close();
        
    }
    
    public int getidruangan() {
        return idruangan;
    }
    
    public Dokter getiddokterbertugas() {
        return dokterbertugas;
    }
    
    public Antrian getantrian() {
        return antrian;
    }
    
    public Pasien getcurrentpasien() {
        return antrian.getdata(antrian.gethead());
    }
    
    public void setidruangan(int _idruangan) {
        idruangan = _idruangan;
    }
    
    public void setiddokterbertugas(Dokter _dokterbertugas) {
        dokterbertugas = _dokterbertugas;
    }
    
    public void updateantrian() throws Exception{
        String query = "SELECT id_pasien FROM antrian WHERE id_ruangan =" + idruangan;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        ResultSet rs1 = stt.executeQuery(query);
        int _idpasien = -1;
        while(rs1.next()) {
            _idpasien = rs1.getInt("id_pasien");
//            System.out.println(_idpasien);
            Pasien P = new Pasien(_idpasien);
            if(!checkpasien(_idpasien)) {
                antrian.push(new Pasien(_idpasien));
            }
        }
        conn.close();
//        antrian = getlatestantrian();
    }
    
    public Resep makeresep(int _resepid, int size, String _perawatanid) throws Exception {
        Resep R = new Resep();
        R.setid(_resepid);
        R.setdokter(dokterbertugas);
	Calendar cal = Calendar.getInstance();
        java.sql.Date date = new Date(cal.getTimeInMillis());
        R.settanggal(date);
        R.setpasien(antrian.peek());
        R.setstatusbayar(false);
        for(int i=0;i<size;i++) {
            R.setaperawatan(i, new Perawatan(_perawatanid.charAt(i)));
            R.setdamagecost(R.getdamagecost()+R.getaperawatan(i).getharga());
            R.settanggal(date);
        }
        return R;
    }
    
    public void inputResep(Resep R) throws Exception {
        String query = "INSERT INTO resep VALUE(" + "'" +  R.getidresep() + "', "  + "'" + R.getpasien().getidpasien() + "', " + "'" + R.getdokter().getiddokter() + "', " +  "'" + R.gettanggal() + "', " + "'" + R.getdamagecost() + "', " + "'" + R.getstatusbayar() + "')";
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        int rs = stt.executeUpdate(query);
        
        int i = 0;
        while(R.getaperawatan(i).getidperawatan()!=-1) {
            query = "INSERT INTO perawatanhistory VALUE('" + R.getidresep() + "', '" + R.getpasien().getidpasien() + "')";
            stt = conn.createStatement();
            rs = stt.executeUpdate(query);
        }
        conn.close();
    }
    
    /**
     *
     * @throws Exception
     */
    public void pasiendone() throws Exception {
        antrian.Pop();
        updateantrian();
    }
    
    public void erasealltoday() throws Exception {
        String query = "DELETE FROM antrian";
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        stt.executeUpdate(query);
        conn.close();
    }
    
    public Antrian getlatestantrian() throws Exception {
        Antrian temp = new Antrian(antrian.getsize());
        String query = "SELECT idpasien FROM antrian WHERE id_ruangan = " + idruangan;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        ResultSet rs1 = stt.executeQuery(query);
        int _idpasien = -1;
        while(rs1.next()) {
            _idpasien = rs1.getInt("idpasien");
            System.out.println(_idpasien);
            Pasien P = new Pasien(_idpasien);
            temp.push(new Pasien(_idpasien));
        }
        conn.close();
        return temp;
    }
    
    public boolean checkpasien(int _idpasien) throws Exception{
        String query = "SELECT id_pasien FROM antrian WHERE id_pasien =" + _idpasien;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        ResultSet rs = stt.executeQuery(query);
        
        if(rs.next()) {
            conn.close();
            return true;
        }
        else {
            conn.close();
            return false;
        }
        
    }
    
    private int idruangan;
    private Dokter dokterbertugas;
    private Antrian antrian;
}
