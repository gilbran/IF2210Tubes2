/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigimu;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author andi
 */
public class Dokter extends Orang {
    public Dokter() {
        super();
        iddokter = -1;
        spesialis = "UNDEFINED";
    }
    
    public Dokter(int _iddokter) throws Exception {
        super();
        
        //connecting to database
        String query = "SELECT * FROM dokter WHERE id_dokter = " + _iddokter;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        ResultSet rs = stt.executeQuery(query);
        
        String _noktp = null;
        String _nama = null;
        String _alamat = null;
        String _notelp = null;
        String _spesialis = null;
        
        //retrieving
        while(rs.next()) {
            _noktp = rs.getString("noktp");
            _nama = rs.getString("nama");
            _alamat = rs.getString("alamat");
            _notelp = rs.getString("notelp");
            _spesialis = rs.getString("spesialis");
        }
        conn.close();
        
        noktp = _noktp;
        nama = _nama;
        alamat = _alamat;
        notelp = _notelp;
        iddokter = _iddokter;
        spesialis = _spesialis;
        
        assert(nama!=null);
    }
    
    public String getspesialis() {
        return spesialis;
    }
    
    public int getiddokter() {
        return iddokter;
    }
    
    public void setspesialis(String _spesialis) {
        spesialis = _spesialis;
    }
    
    public void setiddokter(int _iddokter) {
        iddokter = _iddokter;
    }
    
    public static void writexmldokter(Dokter dokter) throws Exception{
        FileWriter fw = new FileWriter("Dokter.xml");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("<Dokter>");
        pw.println("	" + dokter.getnoktp());
        pw.println("	" + dokter.getnama());
        pw.println("	" + dokter.getalamat());
        pw.println("	" + dokter.getnotelp());
        pw.println("	" + dokter.getiddokter());
        pw.println("	" + dokter.getspesialis());
        pw.println("</Dokter>");
        pw.flush();
        pw.close();
        fw.close();
    }
    
    //DATAMEMBER
    private int iddokter;
    private String spesialis;
}


