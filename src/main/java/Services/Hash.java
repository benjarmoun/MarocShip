package Services;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash {
    public static String MD5(String s) throws Exception {
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return new BigInteger(1,m.digest()).toString(16);
    }
}
