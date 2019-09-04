package com.haijiao.mapper;

import com.haijiao.pojo.Post;
import com.haijiao.pojo.ShowPost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {
    
    /**
     * 发表新帖
     * @param post
     * @return
     */
    @Insert("insert into posts values(null, #{uid}, #{title}, #{type}, #{pubDate}, #{jing}, #{top}, #{jie}, #{browse}, #{reward}, #{rstate}, #{content})")
    Integer addPost(Post post);
    
    /**
     * 获得展示帖列表
     * @return
     */
    List<ShowPost> getShowPostList(Integer pageSize, Integer currentPage);
    
    
    Integer getShowPostListTotal();
}
