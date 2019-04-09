package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private  static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        INumbergenerator InumberGenerator = context.getBean("numberGenerator",INumbergenerator.class);

        //call metgod next() to get a random numebr

        int number = InumberGenerator.next();

        log.info("number = {}",number);

        // get game bean from context(container)
        IGame iGame = context.getBean(IGame.class);

        iGame.reset();

        //close context (container)

        context.close();

    }
}
