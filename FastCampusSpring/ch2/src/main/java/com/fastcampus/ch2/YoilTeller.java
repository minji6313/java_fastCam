package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//�� �� ���� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller {

//	public static void main(String[] args) {
	@RequestMapping("/getYoil")
		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//������ ����� ���ؼ��� main�Լ��� HttpServletResponse response ��ü�� �ۼ����ָ� ��Ĺ�� ����
		//response ������ �������༭ ���������� ����� �� ����
		
		//3�ܰ�� ���� 
		//1. ȣ���� �� �Ѿ�� �Է°��� �޴´�
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. �Է¹��� ���� �۾�
		//���ڿ��̴ϱ� ���ڷ� ����ȯ�� ��
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy,mm-1, dd);
		
		//������ �˾Ƴ� �� �ִµ� 1.�Ͽ���, 2. ������ ..
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = "�Ͽ�ȭ�������".charAt(dayOfweek);
		
		//3.����� ���
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8"); //���ڵ��� ���ϸ� �ѱ��� ����
		PrintWriter out = response.getWriter(); //response ��ü���� �������� ����� �� �ֵ��� ��½�Ʈ���� ���� ��
		out.println(year + "��" + month + "��" + day + "����");
		out.println(yoil + "�����Դϴ�.");
	}

}