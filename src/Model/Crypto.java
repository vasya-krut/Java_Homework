package Model;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Crypto {
    private Cipher cipher;
    private int blockSize;
    private SecretKey secretKey;
    public  final List<Integer> listBlockSize = Arrays.asList(128, 192, 256);

    public void createKey(int blockSize) throws Exception {
        this.blockSize = blockSize;

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(this.blockSize); // block size
        secretKey = keyGenerator.generateKey();

        cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)
    }

    private String encryptString(String plainText) throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    private String decryptString(String encryptedText) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }

    public void encryptFile(String fileName) {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(encryptString(line) + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        writeBuffer(buffer, fileName);
    }

    public void decryptFile(String fileName) {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(decryptString(line) + '\n');
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        writeBuffer(buffer, fileName);
    }

    private void writeBuffer(StringBuilder buffer, String fileName){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
            writter.write(buffer.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
