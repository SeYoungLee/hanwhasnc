package examples.springjdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import examples.springjdbc.config.ApplicationConfig;
import examples.springjdbc.dao.MemberDao;
import examples.springjdbc.dto.Member;


public class MemberTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MemberDao memberDao = ac.getBean( MemberDao.class);

        Member member = new Member();
        member.setEmail("hong@hong.com");
        member.setName("홍길동");
        
        int id = memberDao.insert(member);
        System.out.println("id : " + id);
        
        Member member2 = memberDao.selectById(id);
        System.out.println(member2);
    }

}
