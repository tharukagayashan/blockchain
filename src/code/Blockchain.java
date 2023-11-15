package code;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain;

    // Constructor
    public Blockchain() {
        blockchain = new ArrayList<>();
        // Create the genesis block
        addBlock(new Block(0, System.currentTimeMillis(), "0", new Certificate("Genesis Recipient", "Genesis Course", "Genesis Instructor")));
    }

    // Add a new block to the blockchain
    public void addBlock(Block block) {
        blockchain.add(block);
    }

    // Add a new block with a certificate
    public void addCertificate(Certificate certificate) {
        Block newBlock = new Block(blockchain.size(), System.currentTimeMillis(), blockchain.get(blockchain.size() - 1).getHash(), certificate);
        addBlock(newBlock);
    }

    // Verify the integrity of the blockchain
    public boolean verifyBlockchain() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            // Check if the stored hash is correct
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }

            // Check if the calculated hash is correct
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    // Get the blockchain
    public List<Block> getBlockchain() {
        return blockchain;
    }

}
