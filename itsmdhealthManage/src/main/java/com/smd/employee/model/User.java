package com.smd.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
* Title: User
* Description:用户pojo类
* Version:1.0.0  
* @author pancm
* @date 2017年9月26日
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	 /** 编号 */
	 private String id;
	 /** 姓名 */
	 private String sfzh;
	 private String name;
	 private String branchs;
	 private String telephone;
	 private String email;
	 /** 密码*/
	 private String password;
	 private String address;
	 private String role_bz;
	 //private String gw_status;
	 private String adduser;
	 private String addtime;
	 private String updateuser;
	 private String updatetime;


}
