import com.github.nechai.spring.ContextConfiguration;
import com.github.nechai.spring.ITeamHero;
import com.github.nechai.spring.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
    @Test
    void createContextByXml() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        final IronMan beanIronMan = context.getBean(IronMan.class);
        beanIronMan.getName();
    }

    @Test
    void createContextByConfigFile() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ContextConfiguration.class);
        context.refresh();
        final IronMan beanIronMan = context.getBean(IronMan.class);
        beanIronMan.getName();
    }

    @Test
    void createContextByAnnotations() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpiderMan.class);
        context.refresh();
        final SpiderMan beanSpiderMan = context.getBean(SpiderMan.class);
        beanSpiderMan.getName();
    }

    @Test
    void injectFromField() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.nechai.spring");
        context.refresh();
        final Tor beanTor = context.getBean(Tor.class);
        beanTor.getName();
        beanTor.getSuperPower().getName(Tor.class.getSimpleName());
    }

    @Test
    void injectFromSetter() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.nechai.spring");
        context.refresh();
        final SuperMan beanSuperMan = context.getBean(SuperMan.class);
        beanSuperMan.getName();
        beanSuperMan.getSuperPower().getName(SuperMan.class.getSimpleName());
    }

    @Test
    void injectFromConstructor() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.nechai.spring");
        context.refresh();
        final Wolverine beanWolverine = context.getBean(Wolverine.class);
        beanWolverine.getName();
        beanWolverine.getSuperPower().getName(Wolverine.class.getSimpleName());
    }

    @Test
    void inject2Beans() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.nechai.spring");
        context.refresh();
        final Phoenix beanPhoenix = context.getBean(Phoenix.class);
        beanPhoenix.getName();
        beanPhoenix.getSuperPower1().getName(Phoenix.class.getSimpleName());
        beanPhoenix.getSuperPower2().getName(Phoenix.class.getSimpleName());
    }

    @Test
    void injectListBean() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.nechai.spring");
        context.refresh();
        context.getBean(ITeamHero.class);
        System.out.println(context.getBean(ITeamHero.class).toString());
    }

    @Test
    void injectValueFomProps() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.nechai.spring");
        context.refresh();
        final SpiderMan beanSpiderMan = context.getBean(SpiderMan.class);
        beanSpiderMan.getName();
        System.out.println(beanSpiderMan.getAge());
    }
    @Test
    void methodWithTimeAnnotation() throws ClassNotFoundException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.nechai.spring");
        context.refresh();
        context.getBean(ITeamHero.class).exec();
        context.getBean(ITeamHero.class).toString();
    }
}
