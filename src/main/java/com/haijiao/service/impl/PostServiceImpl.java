
package com.haijiao.service.impl;

import com.haijiao.mapper.PostMapper;
import com.haijiao.pojo.Post;
import com.haijiao.pojo.ShowPost;
import com.haijiao.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostMapper postMapper;
    
    @Override
    public Integer addPost(Post post) {
        return postMapper.addPost(post);
    }
    
    @Override
    public List<ShowPost> getShowPostList(Integer pageSize, Integer currentPage, Integer type, Integer state, Integer dateOrComm) {
        return postMapper.getShowPostList(pageSize, currentPage, type, state, dateOrComm);
    }
    
    @Override
    public Integer getShowPostListTotal(Integer type, Integer state) {
        return postMapper.getShowPostListTotal(type, state);
    }
    
    @Override
    public List<ShowPost> getWeekList() {
        return postMapper.getWeekList();
    }
    
    @Override
    public ShowPost getShowPostByPid(Integer pid) {
        return postMapper.getShowPostByPid(pid);
    }
    
    @Override
    public Integer updBrowse(Integer pid) {
        return postMapper.updBrowse(pid);
    }
    
    @Override
    public Post getPostByPid(Integer pid) {
        return postMapper.getPostByPid(pid);
    }
    
    @Override
    public Integer updPost(Post post) {
        return postMapper.updPost(post);
    }
    
    @Override
    public Integer addJing(Integer pid) {
        return postMapper.addJing(pid);
    }
    
    @Override
    public Integer cancelJing(Integer pid) {
        return postMapper.cancelJing(pid);
    }
    
    @Override
    public Integer addTop(Integer pid) {
        return postMapper.addTop(pid);
    }
    
    @Override
    public Integer cancelTop(Integer pid) {
        return postMapper.cancelTop(pid);
    }
    
    @Override
    public Integer doJie(Integer pid) {
        return postMapper.doJie(pid);
    }
    
    
}
