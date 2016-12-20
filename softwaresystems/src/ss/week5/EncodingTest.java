package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import java.util.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";
        String input2 = "4d6f64756c652032";
        String input3 = "Hello World";
        String input4 = "010203040506";
        String input5 = "U29mdHdhcmUgU3lzdGVtcw==";
        byte[] a = Base64.getDecoder().decode(input4);
        byte[] b = Hex.decodeHex(input2.toCharArray());

        System.out.println(Hex.encodeHexString(input.getBytes()));
        System.out.println(new String(b));
        System.out.println(new String(Base64.getEncoder().encode(input3.getBytes())));
        System.out.println(new String(Base64.getEncoder().encode(a)));
        System.out.println(new String(Base64.getDecoder().decode(input5.getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("a".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aa".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aaa".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aaaa".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aaaaa".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aaaaaa".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aaaaaaa".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aaaaaaaa".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aaaaaaaaa".getBytes())));
        System.out.println(new String(Base64.getEncoder().encode("aaaaaaaaaa".getBytes())));
    }
}