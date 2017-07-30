package com.kingfish.show.conf;

import com.kingfish.show.constants.Cookies;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = Cookies.MAX_AGE) //7天失效
public class RedisSessionConfig {
}
