package thisisjava;

import java.io.InputStream;
import java.util.ArrayList;

import account.Account;
import board.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import user.User;

// DAO

public class DBUtil {
    // DB 접속 정보
    // 데이터베이스 이름 : thisisjava
    // DB 사용자 계정 : root
    // 해당 계정 비밀번호 : 12345
    String url = "jdbc:mariadb://127.0.0.1:3306/thisisjava";
    String user = "root";
    String pass = "12345";

    // 접속(session, DB와 java 프로그램을 연결)을 관리해주는 객체
    SqlSessionFactory sqlSessionFactory;

    // DB와 연결 초기화
    public void init() {
        try {
            // xml : 규칙적으로 데이터를 표현하는 문서
            String resource = "thisisjava/myconfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 접속(session, DB와 java 프로그램을 연결)을 관리해주는 객체
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
            e.printStackTrace();
        }
    }

    public SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }
}
