package kr.or.dgit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.post.dao.PostMapper;
import kr.or.dgit.post.dao.PostMapperImpl;
import kr.or.dgit.post.dto.Post;
import kr.or.dgit.post.util.MybatisSqlSessionFactory;

public class PostService {
	public List<Post> findPostByObj(Map<String, Object> post) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			PostMapper postMapper = new PostMapperImpl(sqlSession);
			return postMapper.findPostByObj(post);
		}
	}
}
