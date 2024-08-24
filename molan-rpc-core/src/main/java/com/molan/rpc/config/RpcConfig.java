package com.molan.rpc.config;


import lombok.Data;
import com.molan.rpc.serializer.SerializerKeys;

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

    /**
     * 是否开启mock
     */
    private boolean mock = false;

    /**
     * 序列化器类型
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();
}
