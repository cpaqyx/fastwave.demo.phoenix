package fastwave.demo.phoenix.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import fastwave.demo.phoenix.entity.ResultEntity;
import fastwave.demo.phoenix.service.UserService;

/**
 * @autor cp
 * @Date 2018/10/28
 */
@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    @Qualifier("phoenixJdbcTemplate")
    JdbcTemplate  jdbcTemplate;
    
    public ResultEntity createtable() {
    	try
    	{
    		String deleteSql = "drop table USER";
    		jdbcTemplate.execute(deleteSql);
    	}
    	catch(Exception ee)
    	{
    		System.out.println("表不存在");
    	}
    	String createSql = "create table IF NOT EXISTS USER (ID INTEGER not null primary key, NAME varchar(20), AGE INTEGER)";
    	jdbcTemplate.execute(createSql);
    	return new ResultEntity(true,"更创建成功！");
	}

    public ResultEntity add() {
    	int num=(int)(Math.random()*100);
    	String sql =String.format("upsert into USER (ID,NAME,AGE) VALUES (%d,'%s',%d)", num , "cp" + num, num);
    	 int result = jdbcTemplate.update(sql);
    	 return result > 0 ? new ResultEntity(true,"插入成功！"):new ResultEntity(false,"插入失败！");
    }

    public ResultEntity delete() {
    	Map<String, Object> maxRow = jdbcTemplate.queryForMap("select max(ID) as id from USER"); 
    	if(null != maxRow)
    	{
    		int maxId = Integer.valueOf(maxRow.get("id").toString());
    		String sql = String.format("delete from USER where ID=%d",  maxId);
    		int result =jdbcTemplate.update(sql);
    		return result > 0 ? new ResultEntity(true,"删除成功！"):new ResultEntity(false,"删除失败！");
    	}
    	return new ResultEntity(false,"没有可以删除的数据！");
    }

    public ResultEntity update() {
    	Map<String, Object> maxRow = jdbcTemplate.queryForMap("select max(ID) as id from USER"); 
    	if(null != maxRow)
    	{
    		int maxId = Integer.valueOf(maxRow.get("id").toString());
    		String sql =String.format("upsert into USER (id,name ) VALUES ('%d','%s')", maxId , "已更新");
	       	 int result = jdbcTemplate.update(sql);
	       	 return result > 0 ? new ResultEntity(true,"更新成功！"):new ResultEntity(false,"更新失败！");
    	}
    	return new ResultEntity(false,"没有找到更新的数据！");
    }

    public List<Map<String, Object>> query() {
        return jdbcTemplate.queryForList("select * from USER ");
    }
}
