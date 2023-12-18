package com.hendisantika.jwtauthorizationauthentication.security;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

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

    public JwtTokenProvider() {
        byte[] keyByte;
        String secret = "jEcHf0ezTD9YxvjPUP7MWdGs4EE6x4GrgHVwh+6wgLUUpOv6exXNYEVgV4mY0Sft4PJxdvv7gRuL5fGyLPrn4w==";
        keyByte = Decoders.BASE64.decode(secret);
        key = Keys.hmacShaKeyFor(keyByte);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
        this.jwtTokenValidateMillisecondRemember = 1000 * 86_400;
        this.jwtTokenValidateMilliseconds = 1000 * 3_600;
    }

    public String createJwtToken(Authentication authentication, boolean rememberMe) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        long now = (new Date()).getTime();
        Date validate;
        if (rememberMe)
            validate = new Date(now + jwtTokenValidateMillisecondRemember);
        else
            validate = new Date(now + jwtTokenValidateMilliseconds);

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validate)
                .compact();
    }
}
