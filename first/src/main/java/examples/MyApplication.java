package examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplication {

	public static void main(String[] args) {
//      스프링을 사용할 때는 인스턴스 생성을 DI 컨테이너에게 맡긴다.
//		Dice dice = new Dice();

		ApplicationContext applicationContext
			= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Player player = applicationContext.getBean(Player.class);
		player.play();
		
//		Dice dice = (Dice)applicationContext.getBean("dice");
//		System.out.println(dice.get());
//		
//		Dice dice2 = applicationContext.getBean(Dice.class);
//		
//		Dice dice3 = applicationContext.getBean("dice", Dice.class);
	}

}
