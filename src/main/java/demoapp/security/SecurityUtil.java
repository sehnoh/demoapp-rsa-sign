package demoapp.security;

import java.io.InputStream;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SecurityUtil {

    private SecurityUtil() {
    }

    public static KeyPair getKeyPairFromKeyStore() throws Exception {
        InputStream in = SecurityUtil.class.getResourceAsStream("/ssl/server.jks");

        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        keyStore.load(in, "password".toCharArray()); // keystore password
        KeyStore.PasswordProtection keyPassword =
                new KeyStore.PasswordProtection("password".toCharArray()); // key password

        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("server", keyPassword);

        java.security.cert.Certificate cert = keyStore.getCertificate("server");
        PublicKey publicKey = cert.getPublicKey();
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();

        return new KeyPair(publicKey, privateKey);
    }

    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes(UTF_8));
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String cipherText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(cipherText);
        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(decriptCipher.doFinal(bytes), UTF_8);
    }

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = getKeyPairFromKeyStore();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("publicKey=" + publicKey.toString());
        System.out.println("privateKey=" + privateKey.toString());

        String message = "This is classified information!";
        System.out.println("message=" + message);

        //Encrypt the message
        String encrypted = encrypt(message, keyPair.getPublic());
        System.out.println("encrypted=" + encrypted);

        String decrypted = decrypt(encrypted, keyPair.getPrivate());
        System.out.println("decrypted=" + decrypted);
    }

}
