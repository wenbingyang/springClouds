package com.smd.employee.model.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseModel implements Serializable {
	/* 主键 */
	private String id;	

	/* 逻辑删除标识 */
	private int deletestatus;
	
	/* 创建人 */
	private String adduser;
	
	/* 创建时间*/
	private String addtime;
	
	/* 修改人 */
	private String updateuser;
	
	/* 创建时间 */
	private String updatetime;
	

}
