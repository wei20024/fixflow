package com.founder.fix.fixflow.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.founder.fix.fixflow.core.IdentityService;
import com.founder.fix.fixflow.core.ProcessEngine;
import com.founder.fix.fixflow.core.impl.Page;
import com.founder.fix.fixflow.core.impl.bpmn.behavior.ProcessDefinitionBehavior;
import com.founder.fix.fixflow.core.impl.identity.UserTo;
import com.founder.fix.fixflow.core.impl.util.StringUtil;
import com.founder.fix.fixflow.core.model.ProcessDefinitionQuery;
import com.founder.fix.fixflow.service.UserGroupService;
import com.founder.fix.fixflow.shell.FixFlowShellProxy;
import com.founder.fix.fixflow.util.Pagination;
@Scope("prototype")
@Service
public class UserGroupServiceImpl implements UserGroupService {

private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Map<String, Object> getAllUsers(Map<String, Object> params) throws SQLException {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String userId = StringUtil.getString(params.get("userId"));
		ProcessEngine processEngine = getProcessEngine(userId);
		IdentityService identityService = processEngine.getIdentityService();
		try{
			String pageI = StringUtil.getString(params.get("pageIndex"));
			String rowI = StringUtil.getString(params.get("pageSize"));
			int pageIndex=1;
			int rowNum   =15;
			if(StringUtil.isNotEmpty(pageI)){
				pageIndex = Integer.valueOf(pageI);
			}
			if(StringUtil.isNotEmpty(rowI)){
				rowNum = Integer.valueOf(rowI);
			}
			
			Map<String,Object> queryMap = new HashMap<String,Object>();
			String queryUserId = StringUtil.getString(params.get("queryUserId"));
			if(StringUtil.isNotEmpty(queryUserId)){
				queryMap.put("USERID", queryUserId);
			}
			String queryUserName = StringUtil.getString(params.get("queryUserName"));
			if(StringUtil.isNotEmpty(queryUserName)){
				queryMap.put("USERNAME", queryUserName);
			}
			List<UserTo> userTos = identityService.getUserTos(new Page(pageIndex,rowNum), queryMap);
			//取值错误，要更改 为了先测试 应该有方法取总数!!!!!!!!!!!!!!!!!!
			int count = 0;
			if(userTos != null){
				count = userTos.size();
			}
			List<Map<String,Object>> userList = new ArrayList<Map<String,Object>>();
			Pagination page = new Pagination(pageIndex,rowNum);
			page.setTotal(count);
			if(userTos!=null){
				for(UserTo user:userTos){
					Map<String,Object> userMap = user.getPropertyMap();
					userList.add(userMap);
				}
			}
			resultMap.put("dataList", userList);
			resultMap.put("pageInfo", page);
		}finally{
			FixFlowShellProxy.closeProcessEngine(processEngine, false);
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> getAllGroup(Map<String, Object> filter) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	private ProcessEngine getProcessEngine(Object userId) throws SQLException{
		if(connection!=null){
			return FixFlowShellProxy.createProcessEngine(userId,connection);
		}else{
			return FixFlowShellProxy.createProcessEngine(userId);
		}
	}

}
