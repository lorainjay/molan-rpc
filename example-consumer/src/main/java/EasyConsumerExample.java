import com.example.common.model.User;
import com.example.common.service.UserService;
import com.molan.rpc.RpcApplication;
import com.molan.rpc.config.RpcConfig;
import com.molan.rpc.proxy.ServiceProxyFactory;

public class EasyConsumerExample {

    public static void main(String[] args) {
        // 静态代理
//        UserService userService = new UserServiceProxy();
        // 动态代理
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
//        System.out.println("name:" + rpcConfig.getName());
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
//        UserService userService = null;
        User user = new User();
        user.setName(rpcConfig.getName());
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNumber();
        System.out.println("获取到number: "  + number);
    }
}
