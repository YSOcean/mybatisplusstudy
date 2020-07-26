package com.ys.mybatisplusstudy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ys.mybatisplusstudy.entry.User;
import com.ys.mybatisplusstudy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;


    /**
     * 新增一条记录
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(4L);
        user.setUserName("test insert");
        user.setUserAge("1");
        int insert = userMapper.insert(user);
        System.out.println("影响记录数："+insert);
    }

    /**
     * allEq 全部等于
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_name = ? AND id = ?)
     */
    @Test
    public void testAllEq(){
        QueryWrapper queryWrapper = new QueryWrapper();
        Map map = new HashMap<>();
        map.put("id","3");
        map.put("user_name","IT可乐");
        queryWrapper.allEq(map);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * eq 等于
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (id = ?)
     */
    @Test
    public void testEq(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id","3");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * ne 不等于
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (id <> ?)
     */
    @Test
    public void testNe(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ne("id","3");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * gt 大于
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age > ?)
     */
    @Test
    public void testGt(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt("user_age","18");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * ge 大于等于
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age >= ?)
     */
    @Test
    public void testGe(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge("user_age","18");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * lt 小于
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age < ?)
     */
    @Test
    public void testLt(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.lt("user_age","18");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * le 小于等于
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age <= ?)
     */
    @Test
    public void testLe(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.le("user_age","18");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * between 值1和值2之间,两边临界值都包含
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age BETWEEN ? AND ?)
     */
    @Test
    public void testBetween(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.between("user_age","18","25");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * notBetween 不在值1和值2之间，两边临界值都包含
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age NOT BETWEEN ? AND ?)
     */
    @Test
    public void testNoBetween(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.notBetween("user_age","18","25");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * like 模糊查询，会在参数左右两边加上 %
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_name LIKE ?)
     */
    @Test
    public void testLike(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("user_name","可乐");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * notLike NOT LIKE ‘%parameter%’
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_name NOT LIKE ?)
     */
    @Test
    public void testNotLike(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.notLike("user_name","可乐");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * likeLeft LIKE ‘%parameter’
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_name LIKE '%parameter')
     */
    @Test
    public void testLikeLeft(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.likeLeft("user_name","可乐");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * likeRight LIKE ‘parameter%’
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_name LIKE 'parameter%')
     */
    @Test
    public void testLikeRight(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.likeRight("user_name","可乐");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * isNull 判断字段为null
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_name IS NULL)
     */
    @Test
    public void testIsNull(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNull("user_name");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * isNotNull 判断字段不为null
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_name IS NOT NULL)
     */
    @Test
    public void testIsNotNull(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("user_name");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }



    /**
     * in 范围定值查询
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age IN (?,?,?))
     */
    @Test
    public void testIn(){
        QueryWrapper queryWrapper = new QueryWrapper();
        List<Integer> queryList = new ArrayList<>();
        queryList.add(18);
        queryList.add(1);
        queryList.add(25);
        queryWrapper.in("user_age",queryList);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * notIn
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age IN (?,?,?))
     */
    @Test
    public void testNotIn(){
        QueryWrapper queryWrapper = new QueryWrapper();
        List<Integer> queryList = new ArrayList<>();
        queryList.add(18);
        queryList.add(1);
        queryList.add(25);
        queryWrapper.notIn("user_age",queryList);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * inSql
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (id IN (select id from user))
     */
    @Test
    public void testInSql(){
        QueryWrapper queryWrapper = new QueryWrapper();
        //查询所有数据
        queryWrapper.inSql("id","select id from user");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * notInSql
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (id NOT IN (select id from user where id > 2))
     */
    @Test
    public void testNotInSql(){
        QueryWrapper queryWrapper = new QueryWrapper();
        //查询所有数据
        queryWrapper.notInSql("id","select id from user where id > 2");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }



    /**
     * groupBy 分组
     * 下面SQL有个问题，在MySQL8.0版本中，是可以执行下面SQL语句的，select user_name并没有出现在group by 语句中
     * 实例SQL：SELECT id,user_name,user_age FROM user GROUP BY id,user_age
     */
    @Test
    public void testGroupBy(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.groupBy("id","user_age");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }



    /**
     * orderByAsc 升序
     * 实例SQL：SELECT id,user_name,user_age FROM user ORDER BY id ASC,user_age ASC
     */
    @Test
    public void testOrderByAsc(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("id","user_age");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * orderByDesc 降序
     * 实例SQL：SELECT id,user_name,user_age FROM user ORDER BY id DESC,user_age DESC
     */
    @Test
    public void testOrderByDesc(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("id","user_age");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * orderBy 指定顺序排序
     * 实例SQL：SELECT id,user_name,user_age FROM user ORDER BY id ASC,user_age ASC
     */
    @Test
    public void testOrderBy(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderBy(true,true,"id","user_age");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }



    /**
     * having
     * 实例SQL：SELECT id,user_name,user_age FROM user GROUP BY id,user_age HAVING sum(user_age)>?
     */
    @Test
    public void testHaving(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.groupBy("id","user_age");
        queryWrapper.having("sum(user_age)>{0}","25");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * having
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (id = ? OR user_age = ?)
     */
    @Test
    public void testOr(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",1);
        queryWrapper.or();
        queryWrapper.eq("user_age",25);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * and
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE ((id = ? AND user_age <> ?))
     */
    @Test
    public void testAnd(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(i->i.eq("id",1).ne("user_age",18));
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }



    /**
     * nested
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE ((id = ? AND user_age <> ?))
     */
    @Test
    public void testNested(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(i->i.eq("id",1).ne("user_age",18));
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * apply
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (user_age>?)
     */
    @Test
    public void testApplyd(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("user_age>{0}","25 or 1=1");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * last
     * 实例SQL：SELECT id,user_name,user_age FROM user limit 1
     */
    @Test
    public void testLast(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("limit 1 ");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }



    /**
     * exists
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (EXISTS (select id from user where user_age = 1))
     */
    @Test
    public void testExists(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.exists("select id from user where user_age = 1");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    /**
     * notExists
     * 实例SQL：SELECT id,user_name,user_age FROM user WHERE (EXISTS (select id from user where user_age = 1))
     */
    @Test
    public void testNotExists(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.notExists("select id from user where user_age = 1");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }
}
