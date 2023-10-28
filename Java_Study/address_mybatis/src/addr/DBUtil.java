package addr;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// DB와 소통하는 객체
public class DBUtil {
	// DB 접속 정보
	// 데이터베이스 이름 : addr_prg
	// DB 사용자 계정 : root
	// 해당 계정 비밀번호 : 12345
	String url = "jdbc:mariadb://127.0.0.1:3306/addr_prg";
	String user = "root";
	String pass = "12345";

	// 접속(session, DB와 java 프로그램을 연결)을 관리해주는 객체
	SqlSessionFactory sqlSessionFactory;

	// DB와 연결 초기화
	public void init() {
		try {
			// xml : 규칙적으로 데이터를 표현하는 문서
			String resource = "addr/myconfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 접속(session, DB와 java 프로그램을 연결)을 관리해주는 객체
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
			e.printStackTrace();
		}
	}

	// AddrMapper.xml에 정의된 SQL문과 연결된다.
	// 주소록 전체를 받아온다.
	public ArrayList<Addr> getAddresses() {
		// sql session: conn+stmt, jdbc 처리를 함 (sql문 처리, 조회 결과를 받아온다)
		// sql문 + 메서드 + 데이터 타입(스키마) 을 알려줘야 한다.

		// openSession: MyBatis에서 실제 SQL 실행을 담당하는 컴포넌트
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		ArrayList<Addr> addrList = mapper.getAddresses();
		
		return addrList;
	}

	// 매개변수 주소록을 insert
	public void insertAddress(String name, String address, String phone) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		Addr addr = new Addr(name, address, phone);
		mapper.insertAddress(addr);
		// 데이터 변경이 있을 때, session.commit()을 해주어야 한다. select(검색)할 때에는 안 해줘도 됨.
		session.commit(); // update, delete, insert
	}

	// 매개변수 주소록을 update
	public void updateAddress(int id, String name, String address, String phone) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		Addr addr = new Addr(id, name, address, phone);
		mapper.updateAddress(addr);
		// 데이터 변경이 있을 때, session.commit()을 해주어야 한다. select(검색)할 때에는 안 해줘도 됨.
		session.commit(); // update, delete, insert
	}

	// 매개변수 주소록을 delete
	public void deleteAddress(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		mapper.deleteAddress(id);
		// 데이터 변경이 있을 때, session.commit()을 해주어야 한다. select(검색)할 때에는 안 해줘도 됨.
		session.commit(); // update, delete, insert
	}
	
}
