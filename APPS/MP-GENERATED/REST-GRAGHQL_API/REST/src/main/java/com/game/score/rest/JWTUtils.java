/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.11
	* - name      : REST.JWTUtils
	* - file name : REST.JWTUtils.vm
*/
package com.game.score.rest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JWTUtils {

    public static final String SECRET_KEY = "toutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouTtoutouT";

    //https://github.com/jhipster/generator-jhipster/blob/b1020ac3a37c7252405d0e116f59db630c01e4d5/generators/server/templates/src/main/java/package/security/jwt/TokenProvider.java.ejs#L63
    public static final byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

    public static final Key key = Keys.hmacShaKeyFor(keyBytes);

    public static String issueToken(String login, UriInfo uriInfo) {
        return issueToken(login, uriInfo.getAbsolutePath().toString());
    }

    public static String issueToken(String login, String uriAbsolutePath) {
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriAbsolutePath)
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(key)
                .compact();
        return jwtToken;
    }

    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void validateToken(String token) throws NoSuchAlgorithmException {
        Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }

    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //Let's set the JWT Claims
        long nowMillis = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(new Date(nowMillis))
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(key)
                //.signWith(signatureAlgorithm, signingKey)
        ;

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static String getSubjectFromToken(String token) {
        return decodeJWT(token).getSubject();
    }

}
