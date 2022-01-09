package yun520.xyz.javastudy.手写Async异步注解;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExtThreadAsyncAop {
    @Around(value ="@annotation(yun520.xyz.javastudy.手写Async异步注解.MyAsync)")
    public Object around(ProceedingJoinPoint joinPoint){
        try {
            log.info(">环绕通知开始执行<");
            //SneakyThrows异常抛出的
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    joinPoint.proceed();//目标方法
                }
            }).start();
//            new Thread(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    joinPoint.proceed();//目标方法
//                }
//            }).start();
            log.info(">环绕通知结束执行<");
            return "环绕通知";
        }catch (Throwable throwable){
            return "系统错误";
        }
    }

}
