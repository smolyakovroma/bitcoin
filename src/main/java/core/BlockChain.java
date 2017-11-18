package core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class BlockChain {

    private List<Block> chain = new ArrayList<Block>();

    public BlockChain() {
        this.chain.add(CreateGenesisBlock());
    }

    private Block CreateGenesisBlock() {
        List<Transaction> transactions = Arrays.asList(new Transaction("Satoshi", "Satoshi", 1000000f));
        return new Block("",transactions, new Date());
    }

    public void addBlock(List<Transaction> list){
        Block block = new Block(getLatestBlock().getHash(), list, new Date());
        chain.add(block);
    }

    public Block getLatestBlock() {
        return chain.get(chain.size()-1);
    }

    public boolean isValidChain(){
        for (int i = chain.size()-1; i > 0; i--) {
            if(!chain.get(i).getHash().equals(Block.calculateHash(chain.get(i)))) return false;
            if(!chain.get(i).getPrevHash().equals(chain.get(i-1).getHash())) return false;
        }
        return true;
    }
}
