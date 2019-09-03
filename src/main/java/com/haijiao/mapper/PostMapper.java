
package com.haijiao.mapper;

import com.haijiao.pojo.Post;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper {
    

/**
     * 发表新帖
     * @param post
     * @return
     */

    @Insert("insert into posts values(null, #{uid}, #{title}, #{type}, #{pubdate}, #{jing}," +
            " #{top}, #{jie}, #{browse}, #{reward}, #{rstate}, #{content})")
    Integer addPost(Post post);
}

