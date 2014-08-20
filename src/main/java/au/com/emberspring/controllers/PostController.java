package au.com.emberspring.controllers;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import au.com.emberspring.domain.Blog;
import au.com.emberspring.domain.Post;
import au.com.emberspring.ember.EmberModel;
import au.com.emberspring.ember.EmberModel;
import au.com.emberspring.service.BlogService;

@RestController
@RequestMapping("posts")
public class PostController {
	
	private final transient BlogService blogService;
	
	@Autowired
	public PostController(final BlogService blogService) {
		this.blogService = blogService;
	}

    @RequestMapping(
    		value = "{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public EmberModel getBlog(@RequestBody Post post, @PathVariable("id") final long postId) {
        return new EmberModel.Builder(post)
        		.addMeta("serverSaid", String.format("Received PUT request for Post(%d) successfully", postId))
        		.build();
    }

}
