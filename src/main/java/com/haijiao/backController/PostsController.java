package com.haijiao.backController;

import com.haijiao.pojo.LayuiJSON;
import com.haijiao.pojo.Post;
import com.haijiao.pojo.User;
import com.haijiao.service.impl.PostServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hai")
public class PostsController {

    @Autowired
    PostServiceImpl postService;

    @RequestMapping("selpost")
    public ResponseEntity<?> SelUser(@Param("page") String page, @Param("pageSize") String pageSize){
        System.out.println("进入查询所有用户方法");
        System.out.println("获取的行数"+page+"获取的size"+pageSize);
        Integer page1=1;
        Integer pageSize1=6;
        if(page!=null){
            page1=Integer.parseInt(page);
        }
        if(pageSize!=null){
            pageSize1=Integer.parseInt(pageSize);
        }
        Integer p=(page1-1)*pageSize1;
        Integer num=postService.NumPost();
        List<Post> PostCurr=postService.CurrPost(p,pageSize1);
        List<Post> posts=postService.AllPost();
        LayuiJSON jsonx=new LayuiJSON();
        if(num!=null){
            jsonx.setCount(num);
            jsonx.setData(PostCurr);
            jsonx.setTotal(posts);
            jsonx.setCode(0);
            return new ResponseEntity<>(jsonx, HttpStatus.OK);
        }else{
            jsonx.setCount(num);
            jsonx.setData(PostCurr);
            jsonx.setTotal(posts);
            jsonx.setCode(2);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }
    }
}
