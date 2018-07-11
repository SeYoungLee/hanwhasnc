package examples.mvcexam01.controller;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import examples.mvcexam01.dto.LoginInfo;

public class LoginInfoArgumentResolver implements HandlerMethodArgumentResolver{

	// 메소드(A a, LoginInfo b, C c)
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if(parameter.getParameterType() == LoginInfo.class) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setId("urstory");
		loginInfo.setName("kim");
		return loginInfo;
	}

}
