import java.util.Base64;
import java.util.Base64.Decoder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    public static void main(String[] args) throws Exception {
        String key = "8iE3bf1se6N76HGPP8S0Xw==";
        String iv = "cHml3oX848/0uBwDJtChOA==";
        String c = "QDr9NZNG9Bgc3TTnfRuqjjzf/kVSYwbP7F9mR4GQZ/IneIh7HTc/xnwzEeVB" +
                "cH3pPlIbLFySKZruedJc9X87CGNDJ1f2Dat8BR3Ypbei5Q42xc306/AkSuGsjfqb" +
                "X9/ELxmdKn7MyvY/Jbc0v0AJHV6odgNzygKRRrFJcUIF/50=";

        byte[] decoded_key = Base64_decoder(key);
        byte[] decoded_iv = Base64_decoder(iv);
        byte[] decoded_c = Base64_decoder(c);

        String plain_text = Aes_decoder(decoded_key,decoded_iv,decoded_c);

        System.out.println(plain_text);
    }
    //base64방식으로 encoding 된 String 을 넘겨주면
    //byte[]로 변환후 base64 방식으로 디코딩하여 return 해주는 메소드
    public static byte[] Base64_decoder(String encoded_string){
        Decoder decoder = Base64.getDecoder();
        byte[] decoded_bytes = decoder.decode(encoded_string.getBytes());
        return decoded_bytes;
    }
    //key, iv, cipher_text를 넘겨주면 복호화하여 plain text를 return 해주는 메소드
    public static String Aes_decoder(byte[] key, byte[] iv, byte[] cipher_text) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        SecretKeySpec KEY = new SecretKeySpec(key, "AES");
        IvParameterSpec IV = new IvParameterSpec(iv);
        c.init(Cipher.DECRYPT_MODE,KEY, IV);

        String plain_text = new String(c.doFinal(cipher_text));

        return plain_text;
    }
}

/*
* key, iv, cipher-text를 이용해 plain-text를 구하시오
* 각 값들은 Base64로 인코딩되어 제공됨 > Base64 인코딩을 공부해보자
*
* 암호화 모드는 AES/CBC/PKCS5PADDING 임 > PKCS5PADDING 에 대해 조사해보자
*
* Java JCA/JCE를 활용해 작성
*
* 제출 : 복호화된 plain text / 구현한 Code
* */