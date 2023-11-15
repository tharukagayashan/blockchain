package code;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    private int index;
    private long timestamp;
    private String previousHash;
    private Certificate data;
    private String hash;

    // Modify the constructor to accept Certificate as data
    public Block(int index, long timestamp, String previousHash, Certificate data) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.data = data;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        try {
            String value = index + timestamp + previousHash + data;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(value.getBytes());
            StringBuilder hexHash = new StringBuilder();

            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexHash.append('0');
                }
                hexHash.append(hex);
            }
            return hexHash.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getIndex() {
        return index;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public String getPreviousHash() {
        return previousHash;
    }
    public String getHash() {
        return hash;
    }
    public Certificate getData() {
        return data;
    }
}
