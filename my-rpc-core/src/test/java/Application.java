import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import service.TcpService;

@EnableAutoConfiguration
@ComponentScan("service")
public class Application {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

        TcpService tcpService = context.getBean(TcpService.class);
        tcpService.start();
    }
}
