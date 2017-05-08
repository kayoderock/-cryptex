package com.sureife.cryptex.crypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by sureife on 24/04/2017.
 */
public class CryptoUtils {

    private static final String ALGORITHM = "AES";

    private static final String TRANSFORMATION = "AES";

    static void encrypt(String key, File plaintextFile,File ciphertextFile) throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, plaintextFile, ciphertextFile);
    }

    static void decrypt(String key,File ciphertextFile, File plaintextFile) throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, ciphertextFile, plaintextFile);
    }

    private static void doCrypto(int cipherMode, String key,File input,File output) throws CryptoException {
        Key secret = new SecretKeySpec(key.getBytes(),ALGORITHM);

        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode,secret);

            FileInputStream inputStream = new FileInputStream(input);
            byte[] inputBytes = new byte[(int) input.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(output);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | IOException | IllegalBlockSizeException | BadPaddingException e ) {
            throw  new CryptoException("Error Encrypting/Decrypting file",e);
        }
    }
}
