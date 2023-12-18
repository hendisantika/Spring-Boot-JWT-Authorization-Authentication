package com.hendisantika.jwtauthorizationauthentication.security;

import org.springframework.web.filter.GenericFilterBean;

/**
 * Created by IntelliJ IDEA.
 * Project : Spring Boot JWT Authorization Authentication
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/18/23
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class JwtFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;
}
