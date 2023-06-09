package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception {
		//Hello hello = new Hello();
		//hello.main();
		//현재 main은 private라서 외부 호출이 불가능
		
		// Spring framework이 Reflection API를 많이 사용함
		// Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능제공
		// java.lang.reflect 패키지를 제공
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		// Hello 클래스의 Class 객체 (클래스의 정보를 담고 있는 객체)를 얻어옴
		// 클래스 객체는 class에 대한 정보를 전부 가지고 있기 때문에 객체 생성, 멤버 불러오기 등 다 가능
		Hello hello = (Hello)helloClass.newInstance();  //Class 객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello); //hello.main() 한것과 똑같다.
	}

}
