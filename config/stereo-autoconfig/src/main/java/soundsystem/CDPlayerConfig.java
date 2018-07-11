package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @ComponentScan은 @Component가 붙은 객체를 찾아서 빈으로 성한다.
// @Component를 상속받고 있는 애노테이션들도 찾는다.
// 대표적으로 @Controller, @Service, @Repository 등이 있다.
@Configuration
@ComponentScan
public class CDPlayerConfig {

    @Bean("twiceDisc")
    public CompactDisc twiceDisc(){
        return new TwiceDisc();
    }

}
