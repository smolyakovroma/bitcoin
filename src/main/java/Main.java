import core.Block;
import core.BlockChain;
import core.Transaction;
import lombok.SneakyThrows;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Main {

    private static BlockChain chain = new BlockChain();
    @SneakyThrows
    public static void main(String[] args) {

        String str = "HELLO WORLD!";
        System.out.println(DigestUtils.sha256Hex(str.getBytes()));
        System.out.println(DigestUtils.sha256Hex(str.toString()));
        String str2 = "HELLO WORLD";
        System.out.println(DigestUtils.sha256Hex(str2.getBytes()));
//        Transaction tx1 = new Transaction("Alice", "Bob", 100f);
//        Transaction tx2 = new Transaction("Alice", "Carol", 1.5f);
//        ArrayList<Transaction> transactions = new ArrayList<>();
//        transactions.add(tx1);
//        transactions.add(tx2);
//        chain.addBlock(transactions);
//        Block latestBlock = chain.getLatestBlock();
//        System.out.println(latestBlock);
//        System.out.println(chain.isValidChain());
//
//        latestBlock.getList().add(new Transaction("Alice", "Chuck", 1000f));
//        System.out.println(latestBlock);
//        System.out.println(Block.calculateHash(latestBlock));
//        System.out.println(chain.isValidChain());
    }
}
