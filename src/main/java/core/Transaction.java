package core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.codec.digest.DigestUtils;

@Getter
@ToString
@EqualsAndHashCode
public class Transaction {
    private String sender;
    private String recepient;
    private float amount;
    private String hashTx;

    public Transaction(String sender, String recepient, float amount) {
        this.sender = sender;
        this.recepient = recepient;
        this.amount = amount;
        this.hashTx = DigestUtils.sha256Hex(sender+recepient+amount);
    }
}
