/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigimu;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author andi
 */
public class Kasir {
    public int bayar(int _idresep) throws Exception {
        String query = "UPDATE resep SET statusbayar = 1 WHERE id_resep = " + _idresep;
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        int temp = stt.executeUpdate(query);
        conn.close();
        return temp;
    }
}
