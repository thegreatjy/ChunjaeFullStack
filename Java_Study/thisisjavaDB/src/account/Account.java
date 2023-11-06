package account;

import lombok.*;

// VO, DTO?

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    private String ano;
    private String owner;
    private int balance;

}
