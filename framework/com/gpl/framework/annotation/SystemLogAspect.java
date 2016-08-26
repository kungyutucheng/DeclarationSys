package com.gpl.framework.annotation;

import java.lang.reflect.Method;
import java.util.jar.Attributes.Name;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.util.JSONUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gpl.authorization.model.User;
import com.gpl.framework.context.UserContext;
import com.gpl.module.log.biz.SystemLogBiz;
import com.gpl.module.log.model.SystemLog;

@Aspect
@Component
public class SystemLogAspect {

	@Autowired
	private SystemLogBiz systemLogBiz;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SystemLogAspect.class);
	
	/**
	 * biz层切入点
	 */
	@Pointcut("@annotation(com.gpl.framework.annotation.SystemBizLog)")
	public void bizAspect(){
		
	}
	
	/**
	 * controller层切入点
	 */
	@Pointcut("@annotation(com.gpl.framework.annotation.SystemControllerLog)")
	public void controllerAspect(){
		
	}
	
	/**
	 * 用于拦截controller层记录用户操作
	 * @param joinPoint
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		//获取当前用户
		User user = UserContext.getContext().getUser();
		//获取请求的ip
		String ip = request.getRemoteAddr();
		try{
			SystemLog log = new SystemLog();
			log.setAccount(user.getAccount());
			log.setDescription(getControllerMethodDesc(joinPoint));
			log.setMethod(joinPoint.getTarget().getClass().getName() + "-" + joinPoint.getSignature().getName() + "()");
			log.setType(1);
			systemLogBiz.save(log);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * 用于拦截biz层的异常信息
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "bizAspect()",throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint , Throwable e){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		User user = UserContext.getContext().getUser();
		String params = "";
		if(joinPoint.getArgs() != null && joinPoint.getArgs().length > 0){
			for(int i = 0 ; i < joinPoint.getArgs().length ; i++){
				params += joinPoint.getArgs()[i] + ";";
			}
		}
		
		try{
			SystemLog log = new SystemLog();
			log.setAccount(user.getAccount());
			log.setDescription(getServiceMethodDesc(joinPoint));
			log.setDetail(e.getMessage());
			log.setType(2);
			log.setEcode(e.getClass().getName());
			log.setMethod(joinPoint.getTarget().getClass().getName() + "-" + joinPoint.getSignature().getName() + "()");
			log.setParams(params);
			systemLogBiz.save(log);
		}catch(Exception e1){
			LOGGER.error(e1.getMessage());
		}
	}
	
	/**
	 * 获取注解中对方法的描述，用于biz层
	 * @param joinPoint
	 * @return
	 * @throws ClassNotFoundException
	 */
	private String getServiceMethodDesc(JoinPoint joinPoint) throws ClassNotFoundException {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object [] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method [] methods = targetClass.getMethods();
		String desc = "";
		for(Method method : methods){
			if(method.getName().equals(methodName)){
				Class [] clazzs = method.getParameterTypes();
				if(clazzs.length == arguments.length){
					desc = method.getAnnotation(SystemBizLog.class).desc();
				}
			}
		}
		return desc;
	}

	/**
	 * 获取注解中对方法的描述，用于controller层
	 * @param joinPoint
	 * @return
	 * @throws ClassNotFoundException
	 */
	private String getControllerMethodDesc(JoinPoint joinPoint) throws ClassNotFoundException {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object [] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method [] methods = targetClass.getMethods();
		String desc = "";
		for(Method method : methods){
			if(method.getName().equals(methodName)){
				Class [] clazzs = method.getParameterTypes();
				if(clazzs.length == arguments.length){
					desc = method.getAnnotation(SystemControllerLog.class).desc();
					break;
				}
			}
		}
		return desc;
	}
	
}
