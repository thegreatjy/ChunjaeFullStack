package fileupload;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class MyFileDAO extends DBConnPool {
    // 새로운 게시물을 입력합니다.
    public int insertFile(MyFileDTO dto) {
        int applyResult = 0;
        try {
            String query = "INSERT INTO myfile (title, cate, ofile, sfile) VALUES ("+dto.getTitle()+", "+dto.getCate()+", "+dto.getOfile()+", "+dto.getSfile()+")";

            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if(rs != null) applyResult = 1;
        }
        catch (Exception e) {
            System.out.println("INSERT 중 예외 발생");
            e.printStackTrace();
        }
        return applyResult;
    }

    public List<MyFileDTO> myFileList() {
        List<MyFileDTO> fileList = new Vector<MyFileDTO>();

        String query = "SELECT * FROM myfile ORDER BY idx DESC";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                MyFileDTO dto = new MyFileDTO();
                dto.setIdx(rs.getString(1));
                dto.setTitle(rs.getString(2));
                dto.setCate(rs.getString(3));
                dto.setOfile(rs.getString(4));
                dto.setSfile(rs.getString(5));
                dto.setPostdate(rs.getString(6));

                fileList.add(dto);
            }
        }
        catch (Exception e) {
            System.out.println("SELECT 시 예외 발생");
            e.printStackTrace();
        }

        return fileList;
    }
}