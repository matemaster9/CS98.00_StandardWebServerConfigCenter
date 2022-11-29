package cs.matemaster.tech.sign.util;

import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * @author matemaster
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JWTUtil {

    private static final JwtBuilder hmacJwt;
    private static final JwtParser hmacJwtParser;
    private static final JwtBuilder rsaJwt;
    private static final JwtParser rsaJwtParser;



    public static byte[] getSignatureSecretKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
    }

    static {
        // HMAC JWT
        byte[] secretKeyByteArray = {41, -80, -38, 94, 1, -65, 81, -121, -15, -31, 87, -51, 30, 34, 107, -8, 92, 27, 113,
                28, 77, 126, 36, 70, -102, -3, 6, -108, 17, 70, 30, -94, -100, -101, -19, 9, -79, -112, 10, -110, -101,
                -36, -127, -27, 72, 72, -20, 30, 62, -73, 42, -31, 16, -55, -114, -22, -2, -47, 71, -110, -102, -23, 54, -12};
        hmacJwt = Jwts.builder().signWith(Keys.hmacShaKeyFor(secretKeyByteArray));
        hmacJwtParser = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secretKeyByteArray)).build();

        // RSA JWT
        String RSAPublicKey = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAsk7dV3UbiBmB075MeF8q9Wno4iicsDNg2quRrKYBPcLeQ" +
                "JPVhdTrw9vF9BA1h+qpR5ygIu9DSDDLwL4wdALZvcrFcrHhiHvT/HH2hrLZPQim6IScgxKx/ZhG+yFoGiFgx3SL8DVLwEKhPr8LTIhO" +
                "IOD8xhCldjqNPgm6r56rP1T99DI+SaOPQTAj2lx2kwlFvOhCf6WeF7bZWqeBd8vDHQV1kzL6bajQjM2/VQtTK0kpJZyxW7qkFQU+oVG" +
                "sw6eu1zEbRXxiivUTkHDf27DmeUT8CHnXgL9jBIpV7rjv5t+7J1VAMgTJAK1niJfaEGHVjQqe8nK+kGX8RMGAIV03+e67Y2At0MaR4S" +
                "LFn2yuhnzwTart+gRFmDNAkNQq4jG+Hn+S3LtSljI8YqMgExjOeMb5zGEkqEZWN8b08WqunM0a/Px7zyjeniZfNYK1oPOyjl+oX9zWj" +
                "8zYlcAji0bV3N2kXZnYgkx+cxSK2x3lwV3pQOm/FYHfCxlcJ96tH9wB4dCrmivRShX1Q600eH28mmRzq3KoDl7JMCXa44z6MCDaF2b2" +
                "NEr21aHm90jVs8lN1DLmtnge9/1D7pwQcVQdjV5/bxUQh7t3+Em7BL01gqpYcbA7KpNyIfPqj28uAR49Ci4EZ2kqhpyr2VTmSrGm33p" +
                "Lt7zNi8vgTUxNG7aYsbUCAwEAAQ==";
        String RSAPrivateKey = "MIIJQwIBADANBgkqhkiG9w0BAQEFAASCCS0wggkpAgEAAoICAQCyTt1XdRuIGYHTvkx4Xyr1aejiKJywM2Daq5Gsp" +
                "gE9wt5Ak9WF1OvD28X0EDWH6qlHnKAi70NIMMvAvjB0Atm9ysVyseGIe9P8cfaGstk9CKbohJyDErH9mEb7IWgaIWDHdIvwNUvAQqE+" +
                "vwtMiE4g4PzGEKV2Oo0+Cbqvnqs/VP30Mj5Jo49BMCPaXHaTCUW86EJ/pZ4Xttlap4F3y8MdBXWTMvptqNCMzb9VC1MrSSklnLFbuqQ" +
                "VBT6hUazDp67XMRtFfGKK9ROQcN/bsOZ5RPwIedeAv2MEilXuuO/m37snVUAyBMkArWeIl9oQYdWNCp7ycr6QZfxEwYAhXTf57rtjYC" +
                "3QxpHhIsWfbK6GfPBNqu36BEWYM0CQ1CriMb4ef5Lcu1KWMjxioyATGM54xvnMYSSoRlY3xvTxaq6czRr8/HvPKN6eJl81grWg87KOX" +
                "6hf3NaPzNiVwCOLRtXc3aRdmdiCTH5zFIrbHeXBXelA6b8Vgd8LGVwn3q0f3AHh0KuaK9FKFfVDrTR4fbyaZHOrcqgOXskwJdrjjPow" +
                "INoXZvY0SvbVoeb3SNWzyU3UMua2eB73/UPunBBxVB2NXn9vFRCHu3f4SbsEvTWCqlhxsDsqk3Ih8+qPby4BHj0KLgRnaSqGnKvZVOZ" +
                "Ksabfeku3vM2Ly+BNTE0btpixtQIDAQABAoICAGle86zAVuHJ+Q/xkG0+CDv5N5eW2mnCIwV2iGLXwzoFU6Qj+PXayuz2jnfZsFi+0w" +
                "SvyW57qG4b7/zaJ/YWzSg8kQxjlF08mBzCGCanwHsyBri3zWoj/S1Y9PFpX4S5nuCfvibYyAg5F+LlsT6r+kexzY8avT0uAtPbmgg4o" +
                "wiNKHpLysVns7uZQEbFh4kC3MRzGQEoFVH8S1woSvlJX+dhl4bChH2TWpMq71vJkn+s/3TrsV/83wRREh7xDkCdclRW/7/DbtShWcts" +
                "+M1yL/EQVESKBFFgSJqhSYEGpzbvlkD7PzGP5FzTHLD60/IEbtenpCCwsG7S5g6XrymIVhAONS5kGivq6ifhrZkiRTVfe1kPxvXx6se" +
                "1Df7w3qd7lX1Un+z4yAHqtfWJ5+6hvDpJUvapi9PpUHKqI8OgOdX4XqqqKSbzWOi6Cer6ZNDq48ivwQbKCHywGPzgCXbkFgsxTwfAN2" +
                "oBrod4TtiKR5I7OPD3KPVkGQvrqn6w20abmTA3DhW0qOHQKBoWJ+ELv4C5lJhi4G+c5QBrspfpNFpibP4JwB8GOI1YVrtHybHT/IOYo" +
                "KMomJtOmfqD56ftgITtOot3Y56VH79XuIYYdgJBGNXQql8GjTkcSzpUG9GLT4/vkBzkEgK6q/nPmyOcTYqQvANio0EXVMEivjA/gt4B" +
                "AoIBAQDsbHrMbgMYR4L2WgT6q83cIviVXr8m0AHxJa8j9enN7bNECu/oA1mmERce9KPWBN46f2ExibTEGjuBZkbJorRnNJk/R86OACO" +
                "LPXzddJkVVC4aMuAx3X9oIwZ5uZTMSg0peXdpm4Y4l+ONFMAMYucnf6wD6amPgvximmHpjMKDRznvL+nYZgpkMc4tRNLGuWY0cjH15e" +
                "Hzuvgc05hh+TUw9bDk2Ogmxh4ZERwkIUsXa8RXsDmYovNzymbJUXJjfbA24pKUYCCiL65v2pphrWKhIjX1VXq4MaV8b9NTdF3fcPh4z" +
                "OblMHo2v72MokQfWrqFdg7h0z+XL5lcsi8H0jo1AoIBAQDBEn7VpcXjE+cMcBRcl4Pyve1pX+QF9Eb/lxc8sVDex+EYZZ1177Jz27Vi" +
                "K9B/JrnIu84kMyGIkHmbdw6ZbA5Z/AYmFEKfZ4tKQPJr+QugBKd9qn6Olmyh7vl/hbm1ghD5vJjehh3auGUqoMEykuQ9yA6/GXEfO3M" +
                "2+cIFsP7nPHcBLSFOZeXuDC5T643r1hZWB/qjPke/nRe6N4r4KF9EAJvmMidQijF2w1ZUxebSsWiCVuKNuEnlDFoTcacoW3lAmic6xH" +
                "9W5iBbV3TvBwAAyJEbyt9AO1N0Y+thi8Qup5z6/6TsIbdxBBETqPxjnBmmwnn6tVExSX9RGd0a14mBAoIBAQC7+pS4rk/vogxS68hBt" +
                "xB7E6MqwKajqYehwSC8Ku63OWPrmfaeNuu0yqnjhwgtRrmbMWSKCr+bnG/rtvJZp/BgjsW6NtHYveuE7mK1gdulxcTSN9liTIbcudyQ" +
                "NCpHNCm67EUxxuK1ZK8coX8BWjIIic6vXb3fyXn6vF1VYQHXd25s61+3G4rvl1ojTDF6qDbHRHTM2vcI34QfB26Fl6vfPbpkesI68hN" +
                "EQwJpB7+444q9XfStlAKV8jw/nW6iBHFzcjqxlqzbx6WeceWF/GILVDQq2Mg2Y+L8Sb1xAXkSC7TD98cuO5kwpsuDYhFgDLd5HiE/FM" +
                "Pe5Y2+0j3qrhBxAoIBAQCkAoosA35uv+Ft92fUoAE+m4iqEwMo67HEPR1IOXhxR2o3x1pTbSMyuFkE5CNhYAxCMQeUSLsbv18OabzFJ" +
                "72pQyYWAu/1aYgxs6o7fnwZmtqNLeAEUFRH2zGm2no/bhXtkABsR5Hk0u9dnuF/jLjGosOkIoCt/1qIQPJI02o2FG8jWKsKZhVEeqSA" +
                "NYGB7YNb4btQIP/iDhix36z10ZXbtoi4q7IqALq0IIudx9+k63/T+OrLaNmc8Tkze0B8T/hYoJrimTlzIFosPcbfphqij7501YmAjuT" +
                "94kN5wbkNyOTZc4Et9hZWsxWulcaQ93Hy7xGfn5cxPzYgNtBUlPQBAoIBAChkcN++QJKa0b6PNTyISrTGMsPJscByOmXx1m1rm9vcbB" +
                "RNtfJGrWXokhO8+7WNHojzTeh+nUF0eDgSxAyGyGua/9KNXVriHAmlOekIH7th+3xSt2QXnkB/+ACQdCmL+pGVgVMFm0nJomcTLjfsM" +
                "u6IoG1W5dNpMnzoRzRLPx2RxP9lQuxaNzwZ4BqNCBit6JIPMThfQQawezO+RpKzh1VHMf3mnmi3ci+5f6jYkDaROQx/XwL6ElzTqMoG" +
                "0TQKbTSCD9zlMmSo5kzXZw4AUYF3Z11O+GIebj1zDrOyOmLI1gCRs/nIakOMUV7rJwVy4JcYW8wzbH0lPXUPbB0MivE=";
        rsaJwt = Jwts.builder().signWith(SecurityUtil.toRSAPrivateKey(RSAPrivateKey));
        rsaJwtParser = Jwts.parserBuilder().setSigningKey(SecurityUtil.toRSAPublicKey(RSAPublicKey)).build();
    }
}
