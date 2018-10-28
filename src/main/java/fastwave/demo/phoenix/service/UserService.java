package fastwave.demo.phoenix.service;

import java.util.List;
import java.util.Map;

import fastwave.demo.phoenix.entity.ResultEntity;

/**
 * @autor kevin.dai
 * @Date 2017/12/27
 */
public interface UserService {
	
	ResultEntity createtable();

    ResultEntity add();

    ResultEntity delete();

    ResultEntity update();

    List<Map<String, Object>> query();
}
