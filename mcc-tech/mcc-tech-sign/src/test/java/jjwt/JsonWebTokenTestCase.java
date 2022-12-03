package jjwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * @author matemaster
 */
@Slf4j
public class JsonWebTokenTestCase {

    @Test
    public void createHeader() {
        String unsecuredJwt = Jwts.builder()
                .setHeader(Maps.<String, Object>of("alg", "none").build())
                .compact();
        log.debug(unsecuredJwt);
    }

    @Test
    public void createPayload() {
        String unsecuredJwt = Jwts.builder()
                .setId(UUID.randomUUID().toString().replace("-", ""))
                .setIssuer("MateMaster")
                .setSubject("有效负载测试")
                .setAudience("audience")
                .setExpiration(Date.from(LocalDateTime.now().plusDays(1L).atZone(ZoneId.systemDefault()).toInstant()))
                .setNotBefore(Date.from(LocalDateTime.now().plusMinutes(1L).atZone(ZoneId.systemDefault()).toInstant()))
                .setIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .compact();
        log.debug(unsecuredJwt);
    }

    @Test
    public void createUnsecuredJwt() {
        String unsecuredJwt = Jwts.builder()
                .setHeader(Maps.<String, Object>of("alg", "none").build())
                .setId(UUID.randomUUID().toString().replace("-", ""))
                .setIssuer("MateMaster")
                .setSubject("有效负载测试")
                .setAudience("audience")
                .setIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.of("GMT+8")).toInstant()))
                .setExpiration(Date.from(LocalDateTime.now().plusDays(1L).atZone(ZoneId.of("GMT+8")).toInstant()))
                .setNotBefore(Date.from(LocalDateTime.now().plusMinutes(1L).atZone(ZoneId.of("GMT+8")).toInstant()))
                .compact();
        log.debug(unsecuredJwt);
    }

    @Test
    public void illegalJwt() throws InterruptedException {
        String illegalJwt1 = Jwts.builder()
                .setId(UUID.randomUUID().toString().replace("-", ""))
                .setIssuer("MateMaster")
                .setSubject("有效负载测试")
                .setAudience("audience")
                .setIssuedAt(Date.from(LocalDateTime.now().minusDays(1L).atZone(ZoneId.of("GMT+8")).toInstant()))
                .setExpiration(Date.from(LocalDateTime.now().plusSeconds(30).atZone(ZoneId.of("GMT+8")).toInstant()))
                .setNotBefore(Date.from(LocalDateTime.now().plusMinutes(1L).atZone(ZoneId.of("GMT+8")).toInstant()))
                .compact();


        Jwts.parserBuilder()
                .build().parseClaimsJwt(illegalJwt1);

        String illegalJwt2 = Jwts.builder()
                .setId(UUID.randomUUID().toString().replace("-", ""))
                .setIssuer("MateMaster")
                .setSubject("有效负载测试")
                .setAudience("audience")
                .setIssuedAt(Date.from(LocalDateTime.now().plusDays(1L).atZone(ZoneId.of("GMT+8")).toInstant()))
                .setExpiration(Date.from(LocalDateTime.now().plusSeconds(30).atZone(ZoneId.of("GMT+8")).toInstant()))
                .setNotBefore(Date.from(LocalDateTime.now().atZone(ZoneId.of("GMT+8")).toInstant()))
                .compact();

        Jwts.parserBuilder()
                .requireIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.of("GMT+8")).toInstant()))
                .setAllowedClockSkewSeconds(200L)
                .build().parseClaimsJwt(illegalJwt2);
    }


}
