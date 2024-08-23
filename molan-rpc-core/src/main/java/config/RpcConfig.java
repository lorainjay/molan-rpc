package config;


import lombok.Data;

/**
 * Rpc 框架全局配置
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "molan-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

}
