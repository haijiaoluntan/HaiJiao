package com.haijiao.mapper;

import com.haijiao.pojo.Post;
import com.haijiao.pojo.ShowPost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {
    
    /**
     * 发表新帖
     * @param post
     * @return
     */
    @Insert("insert into posts values(null, #{uid}, #{title}, #{type}, #{pubDate}, #{jing}, #{top}, #{jie}, #{browse}, #{reward}, #{rstate}, #{content}, 0)")
    Integer addPost(Post post);
    
    /**
     * 根据分类获得展示帖列表
     * @param pageSize
     * @param currentPage
     * @param type
     * @param state
     * @return
     */
    List<ShowPost> getShowPostList(Integer pageSize, Integer currentPage, Integer type, Integer state, Integer dateOrComm);
    
    /**
     * 相应分类总记录数
     * @param type
     * @param state
     * @return
     */
    Integer getShowPostListTotal(Integer type, Integer state);
    
    /**
     * 本周热议
     * @return
     */
    List<ShowPost> getWeekList();
    
    /**
     * 根据pid获得帖子详情
     * @param pid
     * @return
     */
    ShowPost getShowPostByPid(Integer pid);
    
    /**
     * 更新浏览数
     * @param pid
     * @return
     */
    @Update("update posts set browse = (browse + 1) where pid = #{pid}")
    Integer updBrowse(Integer pid);
    
    /**
     * 根据pid查询帖子，用于修改、编辑
     * @param pid
     * @return
     */
    @Select("select pid, title, type, reward, content from posts where pid = #{pid}")
    Post getPostByPid(Integer pid);
    
    /**
     * 修改、编辑帖子
     * @param post
     * @return
     */
    @Update("update posts set title = #{title}, type = #{type}, content = #{content} where pid = #{pid}")
    Integer updPost(Post post);
    
    /**
     * 帖子加精
     * @param pid
     * @return
     */
    @Update("update posts set jing = 1 where pid = #{pid}")
    Integer addJing(Integer pid);
    
    /**
     * 帖子取消加精
     * @param pid
     * @return
     */
    @Update("update posts set jing = 0 where pid = #{pid}")
    Integer cancelJing(Integer pid);
    
    /**
     * 帖子置顶
     * @param pid
     * @return
     */
    @Update("update posts set top = 1 where pid = #{pid}")
    Integer addTop(Integer pid);
    
    /**
     * 帖子取消置顶
     * @param pid
     * @return
     */
    @Update("update posts set top = 0 where pid = #{pid}")
    Integer cancelTop(Integer pid);
    
    /**
     * 完结帖子
     * @param pid
     * @return
     */
    @Update("update posts set jie = 1, rstate = 1 where pid = #{pid}")
    Integer doJie(Integer pid);
}
