/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author chris
 */
public class PasswordHasher {
    
    private static final String HASH_ALGORITHM = "SHA-512";
    private static final int MAX_HASH_LENGTH = 50;
    
    public static String hashPassword(String plainPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashedBytes = md.digest(plainPassword.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            String truncatedHash = hexString.toString().substring(0, Math.min(hexString.length(), MAX_HASH_LENGTH));
            return truncatedHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String plainPassword = "secret_password";
        String hashedPassword = hashPassword(plainPassword);
        System.out.println("Hashed password: " + hashedPassword);
    }
}