/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigimu;

/**
 *
 * @author andi
 */
public class Orang {
    public Orang() {
        noktp = "UNDEFINED";
        nama = "UNDEFINED";
        alamat = "UNDEFINED";
        notelp = "UNDEFINED";
    }
    
    public Orang(String _noktp, String _nama, String _alamat, String _notelp) {
        noktp = _noktp; //nokp sebagai id
        nama = _nama;
        alamat = _alamat;
        notelp = _notelp;
    }
    
    public String getnoktp() {
        return noktp;
    }
    
    public String getnama() {
        return nama;
    }
    
    public String getalamat() {
        return alamat;
    }
    
    public String getnotelp() {
        return notelp;
    }
    
    public void setnoktp(String _noktp) {
        noktp = _noktp;
    }
    
    public void setnama(String _nama) {
        nama = _nama;
    }
    
    public void setalamat(String _alamat) {
        alamat = _alamat;
    }
    
    public void setnotelp(String _notelp) {
        notelp = _notelp;
    }
    
    //DATAMEMBER
    protected String noktp;
    protected String nama;
    protected String alamat;
    protected String notelp;
}

