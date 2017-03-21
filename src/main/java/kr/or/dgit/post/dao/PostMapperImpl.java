package kr.or.dgit.post.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.post.dto.Post;
import kr.or.dgit.post.util.MybatisSqlSessionFactory;

public class PostMapperImpl implements PostMapper {
	private String namespace = "kr.or.dgit.post.dao.PostMapper.";
	private static final Log log = LogFactory.getLog(PostMapperImpl.class);
	private SqlSession sqlSession;
	
	public PostMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Post> findPostByObj(Map<String, Object> post) {
		log.debug("findPostByObj()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+"findPostByObj", post);
		}
	}
}
