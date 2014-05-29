


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
public class Resepsionis {
    public int daftar(Pasien _pasien) throws Exception {
        String S =  _pasien.getnoktp() + ","
                    + "'"  +  _pasien.getnama() + "'" + ","
                    + "'"  + _pasien.getalamat() + "'" + ","
                    + "'"  + _pasien.getnotelp() + "'" + ","
                    + "'"  + _pasien.getidpasien() + "'" + ","
                    + "'"  + _pasien.gettempatlahir() + "'" + ","
                    + "'"  + _pasien.gettanggallahir() + "'" + ","
                    + "'"  + _pasien.getnamabapak() + "'" + ","
                    + "'"  + _pasien.getnamaibu() + "'" + ","
                    + "'"  +_pasien.getalamatdarurat() + "'" + ","
                    + "'"  + _pasien.getnotelpdarurat() + "'";
        String query = "INSERT INTO pasien VALUES(" + S + ")";
        
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        int temp = stt.executeUpdate(query);
        conn.close();
        return temp;
    }
    
    public boolean checkdaftar(Pasien _pasien) throws Exception {
        String query = "SELECT * FROM pasien WHERE id_pasien = " + _pasien.getidpasien();
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        ResultSet rs = stt.executeQuery(query);
        String s = null;
        while(rs.next()) {
            s = rs.getString("id_pasien");
            System.out.println(s);
        }
        conn.close();
        if(s==null) return false;
        else return true;
    }
    
    public int assignpasien(Pasien _pasien, int _idruangan) throws Exception {
        String S =  _idruangan + "," + _pasien.getidpasien();
        String query = "INSERT INTO antrian VALUE(" + S + ")";
        
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        int temp = stt.executeUpdate(query);
        conn.close();
        return temp;
    }
    
//    public static void main(String [] args) throws Exception {
//        java.sql.Date date = new Date(1990, 4, 8);
//        Pasien myPasien = new Pasien("347223384", "andiganteng2", "jalan ganteng", "08119112603", "6", "Jakarta", date, "Rifol Sartuni", "Dewi Taviana Walida", "Jl Pulomas Barat VG/5", "0811133289");
//        Resepsionis myResepsionis = new Resepsionis();
//        int i = myResepsionis.daftar(myPasien);
//        System.out.println(i);
//        myResepsionis.assignpasien(myPasien, 3);
//        System.out.println(myResepsionis.checkdaftar(myPasien));
//    }
    
}
