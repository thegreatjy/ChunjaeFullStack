package resources;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// DAO

public class MyBatisConfig {
    // DB 접속 정보
    // 데이터베이스 이름 : thisisjava
    // DB 사용자 계정 : root
    // 해당 계정 비밀번호 : 12345
    private String url = "jdbc:mariadb://127.0.0.1:3306/thisisjava";
    private String user = "root";
    private String pass = "12345";

    // 접속(session, DB와 java 프로그램을 연결)을 관리해주는 객체
    private SqlSessionFactory sqlSessionFactory;

    private MyBatisConfig(){
        try {
            // xml : 규칙적으로 데이터를 표현하는 문서
            String resource = "thisisjava/myconfig.xml";
            // DB와 연결시키는 xml을 불러와 인풋스트림 설정
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 접속(session, DB와 java 프로그램을 연결)을 관리해주는 Factory 객체 생성
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
            e.printStackTrace();
        }
    }


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
