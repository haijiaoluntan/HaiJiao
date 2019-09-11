
package com.haijiao.service;

import com.haijiao.pojo.Post;
import com.haijiao.pojo.ShowPost;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PostService {
    
    Integer addPost(Post post);
    
    List<ShowPost> getShowPostList(Integer pageSize, Integer currentPage, Integer type, Integer state, Integer dateOrComm);
    
    Integer getShowPostListTotal(Integer type, Integer state);
    
    List<ShowPost> getWeekList();
    
    ShowPost getShowPostByPid(Integer pid);
    
    Integer updBrowse(Integer pid);
    
    Post getPostByPid(Integer pid);
    
    Integer updPost(Post post);
    
    Integer addJing(Integer pid);
    
    Integer cancelJing(Integer pid);
    
    Integer addTop(Integer pid);
    
    Integer cancelTop(Integer pid);
    
    Integer doJie(Integer pid);
    
    List<ShowPost> getTopList();
    
    List<ShowPost> getIndexPostList(Integer state);
    
    List<ShowPost> getPostsListByUid(Integer uid);
    
    List<ShowPost> getPostsList(Integer uid);

    List<Post> AllPost();

    List<Post> CurrPost(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

    Integer NumPost();
}

