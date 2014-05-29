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
class Antrian {
    //gangof5
    public Antrian() {
        size = DEFAULT_SIZE;
        head = 0;
        tail = 0;
        nbelmt = 0;
        data = new Pasien[size];
    }
    
    public Antrian(int _size) {
        size = _size;
        head = 0;
        tail = 0;
        nbelmt = 0;
        data = new Pasien[size];
    }
    
    //gettersetter
    public int getsize() {
        return size;
    }
    
    public int gethead() {
        return head;
    }
    
    public int gettail() {
        return tail;
    }
    
    public int getnbelmt() {
        return nbelmt;
    }
    
    public Pasien getdata(int index) {
        return data[index];
    }
    
    public void setsize(int _size) {
        size = _size;
    }
    
    public void sethead(int _head) {
        head = _head;
    } 
    
    public void settail(int _tail) {
        tail = _tail;
    }
    
    public void setnbelmt(int _nbelmt) {
        nbelmt = _nbelmt;
    }
    
    public void setdata(int index, Pasien _data) {
        data[index] = _data;
    }
    
    public Pasien peek() {
        return data[head];
    }
    
    //tester
    public void print() {
        System.out.println("size = " + size);
        System.out.println("head = " + head);
        System.out.println("size = " + tail);
        System.out.println("nbelmt = " + nbelmt);
        System.out.println("data = ");
//        for(int i=0;i<size;i++) {
//            System.out.print("(" + data + ") ");
//        }
    }
    
    public void init() {
        /*not implemented yet*/
    }
    
    public void push(Pasien _data) {
//        if(isfull()) System.out.println("Queue Full!, cant Push");
//	else {
//            if(isempty()) {
//                data[tail] = _data;
//            }
//            else {
//                tail++;
//                data[tail] = _data;
//            }
//        }
        if(isempty()) {
            data[tail] = _data;
            nbelmt++;
        }
        else {
            tail++;
            data[tail] = _data;
            nbelmt++;
        }
    }
    
    public Pasien Pop() throws Exception {
	if(isempty()) return data[-1];
	else {
		int temp = head;
		if(nbelmt!=1) {
			if(head==size-1) head = 0;
			else head++;
		}
        
        String query = "DELETE FROM antrian WHERE id_pasien = " + data[temp].getidpasien();
        GetConnection getCon = new GetConnection();
        Connection conn = getCon.getConnection();
        Statement stt = conn.createStatement();
        stt.executeUpdate(query);
        conn.close();
        
        nbelmt--;
        return data[temp];
	}
    }
    
    public boolean isempty() {
        if(nbelmt==0) return true;
        else return false;
    }
    
    public boolean isfull() {
        if(nbelmt==size) return true;
        else return false;
    }
    
    public void kickback(int index) {
        for(int i=index;i!=tail;i++) {
            if(i>size-1) {
                i=0;
            }
            Pasien tempdata = data[i];
            data[i] = data[getnextindex(i)];
            data[getnextindex(index)] = tempdata;
        }
    }
    
    public int getnextindex(int index) {
        if(index>size-1) return 0;
        else return index+1;
    }
    
    //constants
    private final int DEFAULT_SIZE = 100;
    
    //datamember
    private int size;
    private int head;
    private int tail;
    private int nbelmt;
    private Pasien[] data;
}

