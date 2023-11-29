package com.ji.spring001;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// servlet-context.xml의 beans에서 prefix인 "/WEB-INF/views/"와 중간 경로인 return 부분의 "index"와
		// serfix인 ".jsp"가 합쳐져서
		// /WEB-INF/views/index.jsp 라는 view 파일 경로로 이동해서
		// 클라이어트에게 응답을 해주는 형태.
		return "index";
		
	}
	
}

// @ : annotation
//		- 사전적 의미 : [주석]
//		코드 사이에 주석처럼 쓰이며 기능을 수행하도록 하는 기술
//		- 코드 작성 문법 에러를 체크하도록 정보를 제공
//		- 이 개발 툴이 코드를 자동으로 생성할 수 있게 해줌
//		- 실행시에 특정 기능을 수행하도록 도와줌!

//	Spring의 대표적인 Annotation 종류 :
//		1.  @Controller : Spring의 Controller.(정의해주는 것.정의해야 컨트롤러로 사용 가능함!)
//		2.	 @AutoWired : 속성, setter, 생성자에서 사용
//		3.	 @RequestMapping : 요청에 따라 어떤 Controller, 어떤 Method가 처리 될 지 Mapping 하기 위해서 사용.
//			value : 요청받을 주소(URL,경로)을 설정
//			method : 어떤 요청으로 받을 지 설정(GET,POST,PUT,DELETE,FETCH,...)
//				W3C(표준 개발 기구, World Wide Web Consortium)에서
//				PUT, DELETE, FETCH 들이 과연 유용한가? 라는 질의. > GET/POST 위주로 사용함.
//		4.  @RequestParam : 요청 파라미터 설정
//		5.  @RestController : Controller중에서 view쪽으로 응답하지 않는 Controller
//			data(xml,json) 등을 return 해주는게 목적 (Spring 4.x 버전 부터 제공함)
//		6.  @ResponseBody : 자바 객체를 HTTP 요청의 body 내용으로 Mapping 해주는 역할.
//			RestController = Controller + ResponseBody
//		7.  @Service : 비즈니스 로직을 수행하는 class를 나타낼 때
//			비즈니스 로직(Buisness Logic) : 사용자 눈에는 안보이지만, 사용자가 원하는 결과물을 올바르게 도출할
//			수 있도록 짜여진 코드(eg. DAO(Model))
//		8.  @XmlRootElement / @XmlElement : OXM(Object Xml Mapping)을 하기 위해 사용
//			> 특정 데이터를 XML 형태로 만들어주는 것 : 마샬링(mashalling)
//			> XML 데이터를 특정 데이터로 만들어주는 것 : 언마샬링(unmashalling)
//			XmlRootElement : Javabean의 Class명 위에 명시함
//			XmlElement : javabean의 모든 setter에 명시