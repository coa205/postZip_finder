package kr.or.dgit.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.post.dto.Post;
import kr.or.dgit.post.service.PostService;

public class PostServiceTest {
	private static PostService postService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		postService = new PostService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		postService = null;
	}

	@Test 
	public void bTestFindPostByObj(){
		Map<String, Object> post = new HashMap<String, Object>();
		post.put("zipcode", "42287");
		post.put("sido", "대구광역시");
		post.put("doro", "고산로");
		
		List<Post> Lists = postService.findPostByObj(post);
		Assert.assertNotNull(Lists);
	}

}
