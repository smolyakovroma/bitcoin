package core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Block {
    @NonNull
    private String prevHash;
    private String hash;
    @NonNull
    private List<Transaction> list;
    @NonNull
    private Date timestamp;

    public Block(String prevHash, List<Transaction> list, Date timestamp) {
        this.prevHash = prevHash;
        this.list = list;
        this.timestamp = timestamp;
        this.hash = calculateHash(this);
    }

    public static String calculateHash(Block block) {
        return DigestUtils.sha256Hex(block.list.toString() + block.timestamp);
    }
}
