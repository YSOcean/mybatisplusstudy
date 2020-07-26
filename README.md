## MyBatis Plus 教程





### 构造条件器详细用法
| 方法名 | 说明 | 用法实例 | 等价SQL |
| :-----| :-----| ----: | :----: |
| 官网地址| https://mp.baomidou.com/guide/wrapper.html#abstractwrapper| ----: | :----: |
| allEq(Map<R, V> params) | 全部等于 | map.put("id","3");map.put("user_name","IT可乐");allEq(map) | user_name = "IT可乐" AND id = 3 |
| eq(R column, Object val) | 等于 = | eq("id","3") | id = 3 |
| ne(R column, Object val) | 不等于 <> | ne("id", "3") | id <> 3 |
| gt(R column, Object val) | 大于 > | gt("user_age","18") | user_age > 18 |
| ge(R column, Object val) | 大于等于 >= | ge("user_age","18") | user_age >= 18 |
| lt(R column, Object val) | 小于 < | lt("user_age","18") | user_age < 18 |
| le(R column, Object val) | 小于等于 <= | le("user_age","18") | user_age <= 18 |
| between(R column, Object val1, Object val2) | BETWEEN 值1 AND 值2  | between("user_age","18","25") | user_age BETWEEN 18 AND 25 |
| notBetween(R column, Object val1, Object val2) | NOT BETWEEN 值1 AND 值2  | notBetween("user_age","18","25") | user_age NOT BETWEEN 18 AND 25 |
| like(R column, Object val) | LIKE '%值%' | like("user_name","可乐") | like ‘%可乐%’ |
| notLike(R column, Object val) | NOT LIKE '%值%' | notLike("user_name","可乐") | not like ‘%可乐%’ |
| likeLeft(R column, Object val) | LIKE '%值' | likeLeft("user_name","可乐") | like ‘%可乐’ |
| likeRight(R column, Object val) | LIKE '值%' | likeRight("user_name","可乐") | like ‘可乐%’ |
| isNull(R column) | 字段 IS NULL | isNull("user_name") | user_name IS NULL |
| isNotNull(R column) | 字段 IS NOT NULL | isNotNull("user_name") | user_name IS NOT NULL |
| in(R column, Collection<?> value) | 字段 IN (value.get(0), value.get(1), ...) | in("user_age",{1,2,3}) | user_age IN (?,?,?) |
| notIn(R column, Collection<?> value) | 字段 NOT IN (value.get(0), value.get(1), ...) | notIn("user_age",{1,2,3}) | user_age NOT IN (?,?,?) |
| inSql(R column, String inValue) | 字段 IN ( sql语句 ) | inSql("id","select id from user") | id IN (select id from user) |
| notInSql(R column, String inValue) | 字段 NOT IN ( sql语句 ) | notInSql("id","select id from user where id > 2") | id NOT IN (select id from user where id > 2 |
| groupBy(R... columns) | 分组：GROUP BY 字段, ... | groupBy("id","user_age") | GROUP BY id,user_age |
| orderByAsc(R... columns) | 排序：ORDER BY 字段, ... ASC | orderByAsc("id","user_age") | ORDER BY id ASC,user_age ASC |
| orderByDesc(R... columns) | 排序：ORDER BY 字段, ... DESC | orderByDesc("id","user_age") | ORDER BY id DESC,user_age DESC |
| orderBy(boolean condition, boolean isAsc, R... columns) | ORDER BY 字段, ... | orderBy(true,true,"id","user_age") | ORDER BY id ASC,user_age ASC |
| having(String sqlHaving, Object... params) | HAVING ( sql语句 ) | having("sum(user_age)>{0}","25") | HAVING sum(user_age)>25 |
| or() | 拼接 OR | eq("id",1).or().eq("user_age",25) | id = 1 OR user_age = 25 |
| and(Consumer<Param> consumer) | AND 嵌套 | and(i->i.eq("id",1).ne("user_age",18)) | id = 1 AND user_age <> 25 |
| nested(Consumer<Param> consumer) | 正常嵌套 不带 AND 或者 OR | nested(i->i.eq("id",1).ne("user_age",18)) | id = 1 AND user_age <> 25 |
| apply(String applySql, Object... params) | 拼接 sql(不会有SQL注入风险) | apply("user_age>{0}","25 or 1=1") | user_age >'25 or 1=1' |
| last(String lastSql) | 拼接到 sql 的最后,多次调用以最后一次为准(有sql注入的风险) | last("limit 1") | limit 1  |
| exists(String existsSql) | 拼接 EXISTS ( sql语句 ) | exists("select id from user where user_age = 1") | EXISTS (select id from user where user_age = 1) |
| notExists(String notExistsSql) | 拼接 NOT EXISTS ( sql语句 ) | notExists("select id from user where user_age = 1") | NOT EXISTS (select id from user where user_age = 1) |




