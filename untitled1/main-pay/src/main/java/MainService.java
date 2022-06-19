import cn.service.interfaces.PayService;

import java.util.ServiceLoader;

public class MainService {

    public static void main(String[] args) {
        ServiceLoader<PayService> services=ServiceLoader.load(PayService.class);
        System.out.println(services);
        for(PayService service:services){
            System.out.println("1");
            service.pay();
        }
    }

}
