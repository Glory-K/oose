package oose2.dto;

import java.sql.Date;

public class MemberDTO {
    String id;
    String pw;
    String name;
    String address;
    String phoneNum;
    String info_agree_date;
    boolean regular;

    public MemberDTO()
    {

    }

    public MemberDTO(String id, String pw, String name,String address, String phoneNum, String info_agree_date, boolean regular)
    {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.info_agree_date = info_agree_date;
        this.regular = regular;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getInfo_agree_date() {
        return info_agree_date;
    }

    public void setInfo_agree_date(String info_agree_date) {
        this.info_agree_date = info_agree_date;
    }

    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }
}