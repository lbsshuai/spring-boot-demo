package encryption;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author lbs
 * @dete
 */
public class MD5 {

    public static final String KEY_MD5 = "MD5";

    public static String getResult(String inputStr){
        System.out.println("====加密前数据："+ inputStr);
        BigInteger bigInteger = null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("MD5加密后："+ bigInteger.toString(16));
        return bigInteger.toString(16);
    }

    public static void main(String[] args){
        String inputStr ="加密666666";
        getResult(inputStr);

    }
}
