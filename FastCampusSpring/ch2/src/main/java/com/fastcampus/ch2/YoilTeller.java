package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//년 월 일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {

//	public static void main(String[] args) {
	@RequestMapping("/getYoil")
		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//브라우저 출력을 위해서는 main함수의 HttpServletResponse response 객체를 작성해주면 톰캣이 만들어서
		//response 변수로 전달해줘서 브라우저에서 출력할 수 있음
		
		//3단계로 진행 
		//1. 호출할 때 넘어온 입력값을 받는다
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		//가가가가가가ㅏㄱ가ㅏ가가가각가ㅏㄱ
		//2. 입력받은 값을 작업
		//문자열이니깐 숫자로 형변환을 함
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy,mm-1, dd);
		
		//요일을 알아낼 수 있는데 1.일요일, 2. 월요일 ..
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = "일월화수목금토".charAt(dayOfweek);
		
		//3.결과를 출력
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8"); //인코딩을 안하면 한글이 깨짐
		PrintWriter out = response.getWriter(); //response 객체에서 브라우저로 출력할 수 있도록 출력스트림을 얻어야 함
		out.println(year + "년" + month + "월" + day + "일은");
		out.println(yoil + "요일입니다.");
	}

}
