package com.ji.spring002;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ji.spring002.book.Book;
import com.ji.spring002.dog.Dog;

// Spring : Java에서 IoC로 DI 해주는 Framework
//		평소) 객체를 .java에서 만들었음
//		현재) 객체를 외부 파일(.xml)에 만들기 > .java에서 불러서 사용할 수 있게끔

//		IoC(제어의 역전) - Inversion of Control
//			프로그램의 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것
//		DI(의존성 주입) - Dependency Injection
//			이런 제어의 역전 패턴을 달성하는 방법 중 하나

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		// 원래 객체 생성 > Dog d = new Dog("개",3);
		
		
		// nov292Beans.xml 불러오기 > xml 파일에 등록해놓은 객체를 만들어서
		//	AbstractApplicationContext : Bean 객체를 생성하고 관리하는 기능.
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("nov292Beans.xml");
		
		// aac가 없어질 때 등록해 놓은 객체들 다 없애라
		aac.registerShutdownHook();
		
		Dog d = aac.getBean("d", Dog.class);	// xml 객체 불러오기
		System.out.println(d);
		
		//	DI(의존성 주입)
		//		xml에서 객체를 만들고, 속성값 넣고 java에서 가져다 쓰는 형태
		
		Dog d2 = aac.getBean("d2",Dog.class);
		System.out.println(d2.getName() + d2.getAge());
		
		Dog d3 = aac.getBean("d3",Dog.class);
		System.out.println("이름 : "+d3.getName()+",나이 : "+d3.getAge());
		
		Book b1 = aac.getBean("b1",Book.class);
		Book b2 = aac.getBean("b2",Book.class);
		
		System.out.println("책이름 : "+b1.getName()+"\n가격 : "+b1.getPrice()+"\n==========\n");
		System.out.println("책이름 : "+b2.getName()+"\n가격 : "+b2.getPrice());
		
		// aac 없애기
		aac.close();

		return "index";
		
	}
	
}
