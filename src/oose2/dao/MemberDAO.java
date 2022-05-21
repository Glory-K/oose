package oose2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import javax.sql.DataSource;

import oose2.MariaDBConnector;
import oose2.dto.MemberDTO;


public class MemberDAO {
    private static MemberDAO instance;
    private static DataSource ds;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Statement st;
    MariaDBConnector maria;

    public MemberDAO()
    {
        conn = null;
        pstmt = null;
        st = null;
        rs = null;
    }


    public static MemberDAO getInstance()
    {
        if(instance == null)
            instance = new MemberDAO();
        return instance;
    }

    public void add(MemberDTO memberDTO) throws Exception
    {
        String sql = "insert into ordianrymember(id, pw, name, address, phoneNum, info_agree_date, regular) values(?,?,?,?,?,?,?)";

        conn = maria.getInstance().sqlLogin();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberDTO.getId());
        pstmt.setString(2, memberDTO.getPw());
        pstmt.setString(3, memberDTO.getName());
        pstmt.setString(4, memberDTO.getAddress());
        pstmt.setString(5, memberDTO.getPhoneNum());
        pstmt.setString(6, memberDTO.getPhoneNum());
        pstmt.setBoolean(7, memberDTO.isRegular());
        try
        {
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        pstmt.close();
        conn.close();
    }

    public boolean overlapCheck(String id) throws Exception
    {
        String sql = "select * from ordinarymember where id = ?";
        boolean check = false;

        conn = maria.getInstance().sqlLogin();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();

        if (rs.next() == true)
            check = true;

        rs.close();
        pstmt.close();
        conn.close();

        return check;
    }

    public ArrayList<MemberDTO> searchByName(String search_name) throws Exception
    {
        ArrayList<MemberDTO> member_list = new ArrayList<MemberDTO>();
        String sql = "select * from ordinarymember where name = ?";
        conn = maria.getInstance().sqlLogin();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, search_name);
        rs = pstmt.executeQuery();

        try
        {
            while (rs.next())
            {
                String id = rs.getString("id");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNum = rs.getString("phoneNum");
                String info_agree_date = rs.getString("info_agree_date");
                boolean regular = rs.getBoolean("regular");
                MemberDTO memberDTO = new MemberDTO(id, pw, name, address, phoneNum, info_agree_date, regular);
                member_list.add(memberDTO);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        rs.close();
        pstmt.close();
        conn.close();

        return member_list;
    }

    public ArrayList<MemberDTO> findAll() throws Exception
    {
        ArrayList<MemberDTO> member_list = new ArrayList<MemberDTO>();
        String sql = "select * from ordinarymember";

        conn = maria.getInstance().sqlLogin();
        st = conn.createStatement();
        rs = st.executeQuery(sql);

        try
        {
            while (rs.next())
            {
                String id = rs.getString("id");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNum = rs.getString("phoneNum");
                String info_agree_date = rs.getString("info_agree_date");
                boolean regular = rs.getBoolean("regular");
                MemberDTO memberDTO = new MemberDTO(id, pw, name, address, phoneNum, info_agree_date, regular);
                member_list.add(memberDTO);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        rs.close();
        st.close();
        conn.close();

        return member_list;
    }
}
