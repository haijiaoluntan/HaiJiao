
package com.haijiao.service.impl;

import com.haijiao.mapper.PostMapper;
import com.haijiao.pojo.Post;
import com.haijiao.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostMapper postMapper;
    
    @Override
    public Integer addPost(Post post) {
        return postMapper.addPost(post);
    }
}
