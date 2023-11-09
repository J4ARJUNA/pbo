package pelanggan;
import java.sql.*;
import javax.swing.JOptionPane;
import juna_pbo.koneksi;

public class clsPelanggan {
    protected String kodep,namap,jkp,alamatp,tlpp;
    protected int flag;
    public String getKodep() {
        return kodep;
    }
    public void setKodep(String kodep) {
        this.kodep = kodep;
    }
    public String getNamap() {
        return namap;
    }
    public void setNamap(String namap) {
        this.namap = namap;
    }
    public String getJkp() {
        return jkp;
    }
    public void setJkp(String jkp) {
        this.jkp = jkp;
    }
    public String getAlamatp() {
        return alamatp;
    }
    public void setAlamatp(String alamatp) {
        this.alamatp = alamatp;
    }
    public String getTlpp() {
        return tlpp;
    }
    public void setTlpp(String tlpp) {
        this.tlpp = tlpp;
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
            String sql = "insert into tabelpelanggan values(";
                    sql+="'"+getKodep()+"',";
                    sql+="'"+getNamap()+"',";
                    sql+="'"+getJkp()+"',";
                    sql+="'"+getAlamatp()+"',";
                    sql+="'"+getTlpp()+"');";
            st.executeUpdate(sql);
            setFlag(1);
            st.close();
            cn.close();
            JOptionPane.showMessageDialog(null,"Data pelanggan disimpan","SIMPAN",
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
            String sql = "update tabelpelanggan set ";
                    sql+="nama='"+getNamap()+"',";
                    sql+="jenis_kelamin='"+getJkp()+"',";
                    sql+="alamat='"+getAlamatp()+"',";
                    sql+="telp='"+getTlpp()+"'";
                    sql+="where kdpelanggan='"+getKodep()+"'";
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
            String sql ="delete from tabelpelanggan ";
                    sql+="where kdpelanggan='"+getKodep()+"'";
                    
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
            String sql ="select * from tabelpelanggan";
                    sql+="where kdpelanggan='"+getKodep()+"'";
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next())
            {
                setFlag(4);
                setKodep(rs.getString("kdpelanggan"));
                setNamap(rs.getString("nmpelanggan"));
                setJkp(rs.getString("jenis_kelamin"));
                setAlamatp(rs.getString("alamat"));
                setTlpp(rs.getString("telp"));
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
            String sql ="select count(kdpelanggan) from tabelpelanggan";
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                if(Integer.parseInt(rs.getString(1))==0)
                {setKodep("P001");
                st.close();
                rs.close();     
            } else
                {
                    sql="select Max(mid(kdpelanggan,2,4))from tabelpelanggan";
                    rs = st.executeQuery(sql);
                    rs.next();
                    hit = (Integer.parseInt(rs.getString(1)))+1;
                    if(hit<10){
                        setKodep("P00"+hit);
                    }else if(hit<100){
                        setKodep("P0"+hit);
                    }else if(hit<1000){
                        setKodep("P"+hit);
                    }
                    st.close();
                    rs.close();  
                }
            }  
        }catch(SQLException sqe){}
    }
}
