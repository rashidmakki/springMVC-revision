package com.gateway.apigateway.util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

        //requirement :
        public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

        //    public static final long JWT_TOKEN_VALIDITY =  60;
        private String secret = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";


        //validate token
        public boolean validateToken(String token) {
            try {
                Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

//        private Key getSignKey(){
//         byte[] keyBytes = Decoders.BASE64.decode(secret);
//         return Keys.hmacShaKeyFor(keyBytes);
//        }

}
