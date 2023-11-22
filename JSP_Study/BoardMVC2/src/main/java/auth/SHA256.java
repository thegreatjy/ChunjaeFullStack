package auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA256 {
    // sha-256 암호화 해시값 리턴
    public static String encrypt(String text) throws NoSuchAlgorithmException {
        // SHA256 알고리즘 객체 생성
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // salt
        text += getSalt();

        md.update(text.getBytes());

        return bytesToHex(md.digest());
    }

    private static String getSalt() {
        /*
        //1. Random, byte 객체 생성
        SecureRandom r = new SecureRandom ();
        byte[] salt = new byte[20];

        //2. 난수 생성
        r.nextBytes(salt);

        //3. byte To String (10진수의 문자열로 변경)
        StringBuffer sb = new StringBuffer();
        for(byte b : salt) {
            sb.append(String.format("%02x", b));
        };

        return sb.toString();
         */
        // db 속성에 salt가 없어서 임의로 지정
        String salt = "randomString";
        return salt;
    }

    // 10진수의 문자열로 변경
    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}