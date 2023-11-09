package juna_pbo;

import java.sql.*;
import juna_pbo.koneksi;
import javax.swing.JOptionPane;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRDesignViewer;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;


public class clsBarang {
    protected String kode,nama,sat;
    protected int hrg,stok,flag;
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String,Object> pm = new HashMap<String,Object>();

    public void cetak(){
        try{
            koneksi k = new koneksi();
            Connection cn =  k.openKoneksi();
            File f =   new File("src/juna_pbo/report_nilai.jrxml");
            jasperDesign = JRXmlLoader.load(f);
            pm.clear();
            
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, pm, cn);
            JasperViewer.viewReport(jasperPrint, false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public int getHrg() {
        return hrg;
    }

    public void setHrg(int hrg) {
        this.hrg = hrg;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    public void simpan(){
        try{
            koneksi k = new koneksi();
            Connection cn =  k.openKoneksi();
            Statement st = cn.createStatement();
            String sql = "insert into tabelbarang values(";
                    sql+="'"+getKode()+"',";
                    sql+="'"+getNama()+"',";
                    sql+="'"+getSat()+"',";
                    sql+="'"+getHrg()+"',";
                    sql+="'"+getStok()+"');";
            st.executeUpdate(sql);
            setFlag(1);
            st.close();
            cn.close();
            JOptionPane.showMessageDialog(null,"Data barang disimpan","SIMPAN",
                JOptionPane.INFORMATION_MESSAGE);
        }   catch(SQLException sqe){
            JOptionPane.showMessageDialog(null,"Data gagal disimpan","GAGAL DISIMPAN",
                JOptionPane.INFORMATION_MESSAGE);
        }
            
    }
     public void ubah()
    {
        try
        {
            koneksi k = new koneksi();
            Connection cn =  k.openKoneksi();
            Statement st = cn.createStatement();
            String sql = "update tabelbarang set ";
                    sql+="nmbrg='"+getNama()+"',";
                    sql+="sat='"+getSat()+"',";
                    sql+="hrgbrg='"+getHrg()+"',";
                    sql+="stok='"+getStok()+"'";
                    sql+="where kdbrg='"+getKode()+"'";
            st.executeUpdate(sql);
            setFlag(2);
            st.close();
            cn.close();
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate","UDPATE",
                JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException sqe){
            JOptionPane.showMessageDialog(null,"Data gagal diupdate","GAGAL DIUPDATE",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void hapus()
    {
        try
        {
            koneksi k = new koneksi();
            Connection cn =  k.openKoneksi();
            Statement st = cn.createStatement();
            String sql ="delete from tabelbarang ";
                    sql+="where kdbrg='"+getKode()+"'";
                    
            st.executeUpdate(sql);
            setFlag(3);
            st.close();
            cn.close();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus","HAPUS",
                JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException sqe){
            JOptionPane.showMessageDialog(null,"Data gagal dihapus","GAGAL DIHAPUS",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void tampil()
    {
        try
        {
            koneksi k = new koneksi();
            Connection cn =  k.openKoneksi();
            Statement st = cn.createStatement();
            String sql ="select * from tabelbarang";
                    sql+="where kdbrg='"+getKode()+"'";
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next())
            {
                setFlag(4);
                setKode(rs.getString("kdbrg"));
                setNama(rs.getString("nmbrg"));
                setSat(rs.getString("sat"));
                setHrg(rs.getInt("hrgbrg"));
                setStok(rs.getInt("stok"));
                st.close();
                rs.close();
            }
        }
        catch(SQLException sqe)
        {}
    }
   
    public void autoKode(){
        try{
            int hit = 0;
            koneksi k = new koneksi();
            Connection cn =  k.openKoneksi();
            Statement st = cn.createStatement();
            String sql ="select count(kdbrg) from tabelbarang";
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                if(Integer.parseInt(rs.getString(1))==0)
                {setKode("B001");
                st.close();
                rs.close();     
            }
            else
                {
                    sql="select Max(mid(kdbrg,2,4))from tabelbarang";
                    rs = st.executeQuery(sql);
                    rs.next();
                    hit = (Integer.parseInt(rs.getString(1)))+1;
                    if(hit<10){
                        setKode("B00"+hit);
                    }else if(hit<100){
                        setKode("B0"+hit);
                    }else if(hit<1000){
                        setKode("B"+hit);
                    }
                    st.close();
                    rs.close();  
                }
            }  
        }catch(SQLException sqe){
                        
                        }
    }
    
}
