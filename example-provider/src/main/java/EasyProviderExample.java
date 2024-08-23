import com.example.common.model.User;
import com.example.common.service.UserService;
import config.RpcConfig;
import registry.LocalRegistry;
import server.HttpServer;
import server.VertxHttpServer;

/**
 * 简单服务提供示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();

        //注册服务
        LocalRegistry.register(UserService.class.getName(),  UserServiceImpl.class);
        // 启动 web 服务器
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(rpcConfig.getServerPort());
    }
}