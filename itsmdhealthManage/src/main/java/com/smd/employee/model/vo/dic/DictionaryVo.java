package com.smd.employee.model.vo.dic;

import lombok.Data;

/**
 * @Description: 数据字典
 * @Version: 1.0
 */
@Data
public class DictionaryVo {

    private String id;

    private String parent_code;

    private String parent_name;

    /**
     *value
     */
    private String children_code;

    /**
     *显示的名称
     */
    private String children_name;


    private String orderNum;

    /**
     *状态     1：正常      2：删除
     */
    private String status;

}
