package yun520.xyz.javastudy.手写Async异步注解;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Thread01 {
    int i=0;
    @MyAsync
    public void asyncLog(){
        try {
          Thread thread = Thread.currentThread();

          i++;
            thread.setName("线程"+i);
            log.info("目标方法正在执行...阻塞3s");
            Thread.sleep(3000);
            log.info("<2>"+thread.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}