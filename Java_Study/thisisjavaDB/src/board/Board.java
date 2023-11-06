package board;

import lombok.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Timestamp bdate;

    Board(String btitle, String bcontent, String bwriter){
        super();
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }
}
