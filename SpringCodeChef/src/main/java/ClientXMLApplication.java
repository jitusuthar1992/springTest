import com.journaldev.spring.di.beans.MyXMLApplication;
import com.journaldev.spring.di.component.AsyncCaller;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientXMLApplication {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "src/main/webapp/WEB-INF/applicationContext.xml");
        MyXMLApplication app = context.getBean(MyXMLApplication.class);

        app.processMessage("Hi Pankaj", "pankaj@abc.com");

        AsyncCaller asyncCaller = context.getBean(AsyncCaller.class);
        asyncCaller.wrongWayToCall();
        asyncCaller.rightWayToCall();
        // close the context
        context.close();
    }

}
