package soundsystem;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 메소드 실행시간을 구하라. hint : ThreadLocal
@Aspect
public class PlayAdvice {
    public PlayAdvice(){
        System.out.println("PlayAdvice 생성자");
    }
    @Before("execution(* soundsystem.MediaPlayer.*(..))")
    public void before(JoinPoint joinPoint){
    	TimerContext.local.set(System.nanoTime());
        System.out.println("메소드 호출 전 실행 : " + joinPoint.getTarget().getClass().getName() );
    }

    @After("execution(* soundsystem.MediaPlayer.*(..))")
    public void after(JoinPoint joinPoint){
    	long start = TimerContext.local.get();
    	long end = System.nanoTime();
    	long time = end - start;
        System.out.println("메소드 호출 후 실행 : " + 
    	     joinPoint.getTarget().getClass().getName() + " : " + time );
    }

    @AfterThrowing(pointcut="execution(* soundsystem.MediaPlayer.*(..))", 
    			throwing="ex")
    public void exceptionHandler(JoinPoint joinPoint, Exception ex){
    	System.out.println("exception이 발생한 클래스 : " 
    			+ joinPoint.getTarget().getClass());
    	System.out.println("exception이 발생한 메소드 : " 
    			+ joinPoint.getSignature().getName());
    	System.out.println("발생한 Exception : " + ex.getMessage());
    }
}
