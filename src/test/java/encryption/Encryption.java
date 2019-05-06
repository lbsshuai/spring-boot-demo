package encryption;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

/**
 * @author lbs
 * @dete
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Encryption {

    @Test
    public void encryptionTest(){
    }

   /* private String rsaEncryption(String src, PublicKey publicKey){
        try {
            Cipher cip = Cipher.getInstance("RSA");
            cip.init(cip.ENCRYPT_MODE, publicKey);
            byte[] bytes = cip.doFinal(src.getBytes());
            return new String(BASE64EncoderStream.encode(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return src;
    }
*/

}
