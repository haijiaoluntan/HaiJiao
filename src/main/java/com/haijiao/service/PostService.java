package com.haijiao.service;

import com.haijiao.pojo.Post;
import com.haijiao.pojo.ShowPost;

import java.util.List;

public interface PostService {
    
    Integer addPost(Post post);
    
    List<ShowPost> getShowPostList(Integer pageSize, Integer currentPage);
}
