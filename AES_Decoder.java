import java.util.Base64;

public class AES_Decoder {
    public static void main(String[] args){
        String key = "8iE3bf1se6N76HGPP8S0Xw==";
        String iv = "cHml3oX848/0uBwDJtChOA==";
        String c = "QDr9NZNG9Bgc3TTnfRuqjjzf/kVSYwbP7F9mR4GQZ/IneIh7HTc/xnwzEeVBc" +
                "H3pPlIbLFySKZruedJc9X87CGNDJ1f2Dat8BR3Ypbei5Q42xc306/AkSuGsjfqb" +
                "X9/ELxmdKn7MyvY/Jbc0v0AJHV6odgNzygKRRrFJcUIF/50=";

        byte[] decoded_key = base64_decoder(key);
        byte[] decoded_iv = base64_decoder(iv);
        byte[] decoded_c = base64_decoder(c);





    }
    //base64방식으로 encoding된 String을 넘겨주면 
    //byte[]로 변환해 base64 방식으로 디코딩해주는 메소드
    public static byte[] base64_decoder(String encoded_string){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded_bytes = decoder.decode(encoded_string.getBytes());
        return decoded_bytes;
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