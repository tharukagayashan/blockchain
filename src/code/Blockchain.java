package code;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain;

    public Blockchain(){
        blockchain = new ArrayList<>();
        // create the genesis block
        addBlock(new Block(0, System.currentTimeMillis(), "0","Genesis Block"));
    }

    public void addBlock(Block block) {
        blockchain.add(block);
    }

    public List<Block> getBlockchain() {
        return blockchain;
    }

    public boolean verifyBlockchain(){
        for(int i = 1; i < blockchain.size(); i++){
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i-1);

            if(!currentBlock.getPreviousHash().equals(previousBlock.getHash())){
                System.out.println("Current Hashes not equal");
                System.out.println("Block " + i + " (Current): " + currentBlock.getPreviousHash());
                System.out.println("Block " + (i - 1) + " (Previous): " + previousBlock.getHash());
            }

            if(!currentBlock.getHash().equals(currentBlock.calculateHash())){
                System.out.println("Previous Hashes not equal");
                System.out.println("Block " + i + " (Current): " + currentBlock.getHash());
                System.out.println("Calculated Hash: " + currentBlock.calculateHash());
                return false;
            }
        }
        return true;
    }

}
