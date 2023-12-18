package com.hendisantika.jwtauthorizationauthentication.request;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : Spring Boot JWT Authorization Authentication
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/18/23
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
    private boolean rememberMe;
}
