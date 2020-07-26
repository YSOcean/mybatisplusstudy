package com.ys.mybatisplusstudy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ys.mybatisplusstudy.entry.User;
import com.ys.mybatisplusstudy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusstudyApplicationTests {

    @Autowired
    private UserMapper userMapper;


    /**
     * 新增一条记录
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(3L);
        user.setUserName("test insert");
        user.setUserAge("1");
        int insert = userMapper.insert(user);
        System.out.println("影响记录数："+insert);
    }

    /**
     * 根据id删除一条记录
     */
    @Test
    public void testDeleteById(){
        int num = userMapper.deleteById(3L);
        System.out.println("删除的记录数为："+num);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",3L);
        userMapper.delete(wrapper);
    }

    /**
     * 构造相关条件删除记录
     */
    @Test
    public void testDelete(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("USER_NAME","test insert");
        int num = userMapper.delete(wrapper);
        System.out.println("删除的记录数为："+num);
    }





    /**
     * 查询User表所有记录
     */
    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(x-> System.out.println(x.getId()+"-"+x.getUserName()+"-"+x.getUserAge()));
    }

    /**
     * 根据id修改
     * UPDATE user SET user_name=?, user_age=? WHERE (id = ?)
     */
    @Test
    public void testudpateById(){
        User user = new User();
        user.setUserAge("25");
        user.setUserName("test update");
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id","3");
        int num = userMapper.update(user, updateWrapper);
        System.out.println("修改的记录数为："+num);
    }

    /**
     * 查询指定记录
     * SELECT id,user_name,user_age FROM user WHERE (user_name = ?)
     */
    @Test
    public void testSelectWrapper(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_name","IT可乐");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(x-> System.out.println(x.getId()+"-"+x.getUserName()+"-"+x.getUserAge()));
    }
}


