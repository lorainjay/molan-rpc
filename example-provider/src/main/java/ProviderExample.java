import com.example.common.service.UserService;
import com.molan.rpc.RpcApplication;
import com.molan.rpc.config.RegistryConfig;
import com.molan.rpc.config.RpcConfig;
import com.molan.rpc.model.ServiceMetaInfo;
import com.molan.rpc.registry.LocalRegistry;
import com.molan.rpc.registry.Registry;
import com.molan.rpc.registry.RegistryFactory;
import com.molan.rpc.server.HttpServer;
import com.molan.rpc.server.VertxHttpServer;

public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}