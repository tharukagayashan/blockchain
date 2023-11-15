package code;

import java.util.List;

public class main {

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        // Issue a certificate
        Certificate certificate = new Certificate("John Doe", "Blockchain 101", "Dr. Smith");
        blockchain.addCertificate(certificate);

        // Verify the blockchain
        System.out.println("Is the blockchain valid? " + blockchain.verifyBlockchain());

        List<Block> chain = blockchain.getBlockchain();
        Block lastBlock = chain.get(chain.size() - 1);

        Certificate lastCertificate = lastBlock.getData();
        System.out.println("Certificate Details:");
        System.out.println("Recipient: " + lastCertificate.getRecipient());
        System.out.println("Course: " + lastCertificate.getCourse());
        System.out.println("Instructor: " + lastCertificate.getInstructor());
    }

}