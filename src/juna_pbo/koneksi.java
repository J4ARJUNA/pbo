package juna_pbo;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class koneksi {
    private Connection koneksi;
    public Connection openKoneksi() throws SQLException{
        if(koneksi==null){
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/juna_pbo","root","");
        }
        return koneksi;
    }
}
