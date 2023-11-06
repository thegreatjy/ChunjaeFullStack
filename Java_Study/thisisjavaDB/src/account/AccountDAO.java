package account;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import thisisjava.ObjectMapper;

import java.util.ArrayList;

public class AccountDAO {
    SqlSessionFactory sqlSessionFactory;

    public void init(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // AccountMapper.xml에 정의된 SQL문과 연결된다.
    public ArrayList<Account> getAccounts (String type) {
        // sql session: conn+stmt, jdbc 처리를 함 (sql문 처리, 조회 결과를 받아온다)
        // sql문 + 메서드 + 데이터 타입(스키마) 을 알려줘야 한다.

        // openSession: MyBatis에서 실제 SQL 실행을 담당하는 컴포넌트
        SqlSession session = sqlSessionFactory.openSession();
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        ArrayList<Account> objectsList;

        objectsList = mapper.getAccounts();

        return objectsList;
    }
}
