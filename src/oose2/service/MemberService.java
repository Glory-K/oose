package oose2.service;

import java.util.ArrayList;

import oose2.dto.MemberDTO;
import oose2.dao.MemberDAO;

public class MemberService
{

    private final MemberDAO memberDAO = MemberDAO.getInstance();


    public void add(MemberDTO memberDTO) throws Exception
    {
        memberDAO.add(memberDTO);
    }

    public boolean overlapCheck(String id) throws Exception
    {
        return memberDAO.overlapCheck(id);
    }

    public ArrayList<MemberDTO> searchByName(String name) throws Exception
    {
        return memberDAO.searchByName(name);
    }

    public ArrayList<MemberDTO> findAll() throws Exception
    {
        return memberDAO.findAll();
    }
}