package code;

public class main {

    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();

        // Add some blocks to the blockchain
        blockchain.addBlock(new Block(1, System.currentTimeMillis(), "Block 1 Data", blockchain.getBlockchain().get(blockchain.getBlockchain().size() - 1).getHash()));
        blockchain.addBlock(new Block(2, System.currentTimeMillis(), "Block 2 Data", blockchain.getBlockchain().get(blockchain.getBlockchain().size() - 1).getHash()));

        // Print the blockchain
        System.out.println("Blockchain:");
        for (Block block : blockchain.getBlockchain()) {
            System.out.println("Index: " + block.getIndex());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Data: " + block.getData());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println();
        }

        // Verify the integrity of the blockchain
        boolean isBlockchainValid = blockchain.verifyBlockchain();
        System.out.println("Is Blockchain Valid? " + isBlockchainValid);
    }
}