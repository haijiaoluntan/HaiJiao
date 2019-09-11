package com.haijiao.backController;


import com.haijiao.pojo.Admin;
import com.haijiao.pojo.DataAuth;
import com.haijiao.pojo.LayuiJSON;
import com.haijiao.pojo.OperAuth;
import com.haijiao.service.impl.RankServiceImpl;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hai")
public class RankController {
    @Autowired
    RankServiceImpl rankService;

    @RequestMapping("seladmin")
    public ResponseEntity<?> SelAdmin(@Param("page") String page,@Param("pageSize") String pageSize){
        System.out.println("进入查询所有管理员方法");
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
        Integer num=rankService.AdminNum();
        List<Admin> adminCurr=rankService.currAdmin(p,pageSize1);
        List<Admin> admin=rankService.FindAllAdmin();
        LayuiJSON jsonx=new LayuiJSON();
        if(num!=null){
            jsonx.setCount(num);
            jsonx.setData(adminCurr);
            jsonx.setTotal(admin);
            jsonx.setCode(0);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }else{
            jsonx.setCount(num);
            jsonx.setData(adminCurr);
            jsonx.setTotal(admin);
            jsonx.setCode(2);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }
    }

    @RequestMapping("seldata")
    public ResponseEntity<?> FindData(Integer aid){
        System.out.println("进入查询数据权限的方法");
        System.out.println("获取的管理员id:"+aid);
        List<DataAuth> dataAuthList=rankService.FindData(aid);
        LayuiJSON jsonx=new LayuiJSON();
        if(dataAuthList!=null){
            jsonx.setData(dataAuthList);
            jsonx.setCode(1);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }else{
            jsonx.setCode(2);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }
    }

    @RequestMapping("seloper")
    public ResponseEntity<?> FindOper(Integer aid){
        System.out.println("进入查询操作权限的方法");
        System.out.println("获取的管理员id:"+aid);
        List<OperAuth> operAuthList=rankService.FindOper(aid);
        LayuiJSON jsonx=new LayuiJSON();
        if(operAuthList!=null){
            jsonx.setData(operAuthList);
            jsonx.setCode(1);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }else{
            jsonx.setCode(2);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }
    }

    @RequestMapping("dataupd")
    public ResponseEntity<?> DataUpdate(Integer state, Integer aid, Integer did){
        System.out.println("进入分配数据权限的方法");
        System.out.println("获取的管理员state:"+state+"aid是"+aid+"did是"+did);
        Integer i=rankService.DataUpdate(state,aid,did);
        LayuiJSON jsonx=new LayuiJSON();
        if(i!=null){
            jsonx.setCode(1);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }else{
            jsonx.setCode(2);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }
    }

    @RequestMapping("operupd")
    public ResponseEntity<?> OperUpdate(Integer state, Integer aid, Integer oid){
        System.out.println("进入分配数据权限的方法");
        System.out.println("获取的管理员state:"+state+"aid是"+aid+"did是"+oid);
        Integer i=rankService.OperUpdate(state,aid,oid);
        LayuiJSON jsonx=new LayuiJSON();
        if(i!=null){
            jsonx.setCode(1);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }else{
            jsonx.setCode(2);
            return new ResponseEntity<>(jsonx,HttpStatus.OK);
        }
    }

    @RequestMapping("yanoper")
    public ResponseEntity<?> YanOper(String admin, Integer oid){
        System.out.println("进入操作权限验证的方法");
        System.out.println("获取的管理员admin是"+admin+"did是"+oid);
        Integer aid=rankService.aidByAdmin(admin);
        Integer state=rankService.selOS(aid,oid);
        return new ResponseEntity<>(state,HttpStatus.OK);
    }

    @RequestMapping("yandata")
    public ResponseEntity<?> YanDate(String admin, Integer did){
        System.out.println("进入数据权限验证的方法");
        System.out.println("获取的管理员admin是"+admin+"did是"+did);
        Integer aid=rankService.aidByAdmin(admin);
        Integer state=rankService.selOS(aid,did);
        return new ResponseEntity<>(state,HttpStatus.OK);
    }
}
