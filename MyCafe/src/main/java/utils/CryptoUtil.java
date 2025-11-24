package main.java.utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.*;
import java.security.Key;

public class CryptoUtil
{
	private static final byte[] KEY = "0123456789abcdef".getBytes();

    public static void encrypt(String inFile, String outFile) throws Exception
    {
        doCrypto(Cipher.ENCRYPT_MODE, inFile, outFile);
    }

    public static void decrypt(String inFile, String outFile) throws Exception
    {
        doCrypto(Cipher.DECRYPT_MODE, inFile, outFile);
    }

    private static void doCrypto(int mode, String inFile, String outFile) throws Exception
    {
        Key secretKey = new SecretKeySpec(KEY, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(mode, secretKey);
        byte[] input = Files.readAllBytes(Paths.get(inFile));
        byte[] output = cipher.doFinal(input);
        Files.write(Paths.get(outFile), output);
    }
}
