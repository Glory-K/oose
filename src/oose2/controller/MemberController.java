package oose2.controller;

import oose2.dto.MemberDTO;
import oose2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MemberController implements Controller
{
    private final MemberService memberService = new MemberService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException
    {
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("\n-------------MemberController---------------\n");
        System.out.println("---------------url-------------\n" + url);

        try
        {
            if (url.equals("/member/regist"))
            {
                if (request.getMethod().equals("GET"))
                {
                    modelAndView.setViewName("/member/member_regist");
                }
                else if (request.getMethod().equals("POST"))
                {
                    if (request.getParameter("action").equals("등록"))
                    {
                        try
                        {
                            String id = request.getParameter("id");
                            String pw = request.getParameter("pw");
                            String name = request.getParameter("name");
                            String address = request.getParameter("address");
                            String phoneNum = request.getParameter("phoneNum");
                            String info_agree_date = request.getParameter("info_agree_date");
                            boolean regular = Boolean.getBoolean(request.getParameter("regular"));

                            if (memberService.overlapCheck(id))
                            {
                                String pageUrl = "/front/member/regist";
                                alert(request, response, pageUrl, "이미 사용중인 아이디 입니다.");
                            }
                            else
                            {
                                MemberDTO memberDTO = new MemberDTO(id, pw, name, address, phoneNum, info_agree_date, regular);
                                memberService.add(memberDTO);

                                ArrayList<MemberDTO> memberDTOArrayList = memberService.findAll();
                                modelAndView.setViewName("member/member_list");
                                modelAndView.getModel().put("members", memberDTOArrayList);
                            }
                        }
                        catch(Exception e)
                        {
                            String pageUrl = "/front/member/regist";
                            alert(request, response, pageUrl, "다시 입력바람");
                        }
                    }
                    else if (request.getParameter("action").equals("돌아가기"))
                    {
                        modelAndView.setViewName("index");
                    }
                }
            }
            else if (url.equals("/member/list"))
            {
                ArrayList<MemberDTO> memberDTOArrayList = memberService.findAll();

                System.out.println("Method = " + request.getMethod());

                if (request.getMethod().equals("GET"))
                {
                    System.out.println("\nrequest.getMethod().equals(\"GET\")");

                    modelAndView.setViewName("member/member_list");
                    modelAndView.getModel().put("members", memberDTOArrayList);
                }
                else if (request.getMethod().equals("POST"))
                {
                    System.out.println("\nrequest.getMethod().equals(`POST`)");
                    System.out.println("\nrequest parameter = " + request.getParameter("action"));


                    if(request.getParameter("action").equals("검색"))
                    {
                        System.out.println("\nrequest.getParameter(\"action\").equals(\"조회\")");
                        try
                        {
                            System.out.println("try");
                            String member_name = request.getParameter("name");
                            System.out.println("\nmember_name = " + member_name);

                            if (!(member_name.equals("")))
                            {
                                String name = member_name;
                                memberDTOArrayList = memberService.searchByName(name);
                            }

                            modelAndView.setViewName("member/member_list");
                            modelAndView.getModel().put("members", memberDTOArrayList);
                        }
                        catch(Exception e)
                        {
                            String pageUrl = "/front/member/list";
                            alert(request, response, pageUrl, "조회안됨.");
                        }
                    }
                    else if(request.getParameter("action").equals("뒤로가기"))
                    {
                        System.out.println("\nCancel\n");

                        modelAndView.setViewName("index");
                    }
                }
            }
            else
            {
                modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("\nViewName = "+modelAndView.getViewName() +"\n");
        return modelAndView;
    }

    public void alert(HttpServletRequest request, HttpServletResponse response, String url, String msg) throws IOException
    {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script>alert('" + msg + "'); location.href='" + url + "';</script>");
        writer.close();
    }
}