package hello.core.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	//private final MyLogger myLogger;
	private final ObjectProvider<MyLogger> myLoggerProvider;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestURL = request.getRequestURL().toString();
		MyLogger myLogger = myLoggerProvider.getObject();
		myLogger.setRequestURL(requestURL);
		System.out.println(myLogger);

		myLogger.log("Controller Test");
		logDemoService.logic("test id");

		return "OK";
	}
	// @ResponseBody 하면 리턴값을 그대로 반환할 수 있음

}
