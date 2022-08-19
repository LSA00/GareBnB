package garebnb.common.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAspect {
	protected Log log =
			LogFactory.getLog(LoggerAspect.class);
	static String name = "";
	static String type = "";
	
	@Around("execution(* garebnb..controller.*Controller.*(..)) or execution(* garebnb..service.*Impl.*(..)) or execution(* garebnb..dao.*DAO.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable{
		if(type.indexOf("Controller")>-1) {
			name = "Controller \t: ";
		} else if(type.indexOf("DAO") > -1) {
			name = "DAO \t\t: ";
		}
		log.debug(name + type + "." + joinPoint.getSignature().getName()+"()");
		return joinPoint.proceed();
	}
}
