package merkletree;

import core.Transaction;

import java.util.ArrayList;

public class MainMerkle {
    public static void main(String[] args) {



        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction("A", "B", 1f));
        list.add(new Transaction("A", "B", 2f));
        list.add(new Transaction("C", "B", 3f));
        list.add(new Transaction("D", "D", 4f));
//        list.add(new Transaction("A", "B", 5f));

        new MerkleTree(list);

    }
}
