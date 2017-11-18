package merkletree;

import core.Transaction;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class MerkleTree {

    List<Leaf> listTx;

    public MerkleTree(List<Transaction> list) {
        listTx = new ArrayList<Leaf>();
        String hash;
        for (int i = 0; i < list.size(); i++) {

            Leaf leaf = new Leaf();
            leaf.setLeftTx(list.get(i));
            hash = leaf.getLeftTx().getHashTx();
            if (++i != list.size()) {
                leaf.setRightTx(list.get(i));
                hash += leaf.getRightTx().getHashTx();
            }
            leaf.setHashLeaf(DigestUtils.sha256Hex(hash));

            listTx.add(leaf);
        }
        List<Leaf> listTxTemp = new ArrayList<Leaf>(listTx);
        Leaf root = generateTree(listTxTemp);


    }

    private Leaf generateTree(List<Leaf> listTxTemp) {
        while (listTxTemp.size()!= 1){
            listTxTemp = getNewList(listTxTemp);
        }
        return listTxTemp.get(0);
    }
    private List<Leaf> getNewList(List<Leaf> listTxTemp) {

        String hash;
        List<Leaf> newTxTemp = new ArrayList<Leaf>();
        for (int i = 0; i < listTxTemp.size(); i++) {
            Leaf parentLeaf = new Leaf();
            listTxTemp.get(i).setParentLeaf(parentLeaf);
            hash = listTxTemp.get(i).getHashLeaf();
            if (++i != listTxTemp.size()) {
                listTxTemp.get(i).setParentLeaf(parentLeaf);
                hash += listTxTemp.get(i).getHashLeaf();
            }
            parentLeaf.setHashLeaf(DigestUtils.sha256Hex(hash));
            newTxTemp.add(parentLeaf);
        }
        return newTxTemp;
    }


    @Setter
    @Getter
    @EqualsAndHashCode
    @ToString
    public class Leaf {

        private Leaf parentLeaf;
        private Transaction leftTx;
        private Transaction rightTx;

        private String hashLeaf;


    }

    @Setter
    @Getter
    @EqualsAndHashCode
    @ToString
    public class TreeNode{
        private TreeNode leftNode;
        private TreeNode rightNode;
        private String hashTreeNode;
    }

}
