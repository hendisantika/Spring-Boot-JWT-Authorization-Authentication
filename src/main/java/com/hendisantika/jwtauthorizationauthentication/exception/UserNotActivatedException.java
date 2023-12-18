package com.hendisantika.jwtauthorizationauthentication.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by IntelliJ IDEA.
 * Project : Spring Boot JWT Authorization Authentication
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/18/23
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
public class UserNotActivatedException extends AuthenticationException {

    public UserNotActivatedException(String explanation) {
        super(explanation);
    }

    public UserNotActivatedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
