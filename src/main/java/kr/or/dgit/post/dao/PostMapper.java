package kr.or.dgit.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.post.dto.Post;

public interface PostMapper {
	List<Post> findPostByObj(Map<String, Object> post);
}
