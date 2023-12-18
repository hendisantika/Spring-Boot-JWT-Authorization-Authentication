package com.hendisantika.jwtauthorizationauthentication.security;

import io.jsonwebtoken.JwtParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : Spring Boot JWT Authorization Authentication
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/18/23
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JwtTokenProvider {

    private static final String AUTHORITIES_KEY = "auth";
    private final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    private final long jwtTokenValidateMillisecondRemember;
    private final long jwtTokenValidateMilliseconds;

    private final Key key;
    private final JwtParser jwtParser;
}
