package com.kingfish.show.conf;

import com.kingfish.show.constants.Cookies;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = Cookies.MAX_AGE) //跟cookie保持一致
public class RedisSessionConfig {
}
