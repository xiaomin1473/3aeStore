package store.ae.dao.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Access {
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库链接信息
		Reader reader = Resources.getResourceAsReader("com/ae/dao/init/config.xml");
		
		// 通过配置文件构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		// 通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
		
	}
}
