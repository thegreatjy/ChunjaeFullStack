package thisisjava;

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
    private String bfilename;
    private byte[] bfiledata;
}
