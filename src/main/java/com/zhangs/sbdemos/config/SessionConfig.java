package com.zhangs.sbdemos.config;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1000)
public class SessionConfig {
    //冒号后的值为没有配置文件时，制动装载的默认值
    @Value("${spring.redis.host:localhost}")
    String hostname;
    @Value("${spring.redis.port:6379}")
    int port;

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(hostname, port);
        return lettuceConnectionFactory;
    }

    public static void main(String[] args) throws Exception {
        String ip = "47.95.196.158";
        // 判断是否为IP地址
        boolean isIpAddress = Util.isIpAddress("12123.34"); // false
        isIpAddress = Util.isIpAddress(ip); // true

        // IP地址与long互转
        long ipLong = Util.ip2long(ip); // 794805406
        String strIp = Util.long2ip(ipLong); // 47.95.196.158

        // 根据IP搜索地址信息
        DbConfig config = new DbConfig();
        String dbfile = "F:\\data\\ip2region.db"; // 这个文件若没有请到以下地址下载：
        // https://gitee.com/lionsoul/ip2region/tree/master/data
        DbSearcher searcher = new DbSearcher(config, dbfile);

        // 二分搜索
        long start = System.currentTimeMillis();
        DataBlock block1 = searcher.binarySearch(ip);
        long end = System.currentTimeMillis();
        System.out.println(block1.getRegion()); // 中国|华东|浙江省|杭州市|阿里巴巴
        System.out.println("使用二分搜索，耗时：" + (end - start) + " ms"); // 1ms

        // B树搜索（更快）
        start = System.currentTimeMillis();
        DataBlock block2 = searcher.btreeSearch(ip);
        end = System.currentTimeMillis();
        System.out.println("使用B树搜索，耗时：" + (end - start) + " ms"); // 0ms
    }
}

