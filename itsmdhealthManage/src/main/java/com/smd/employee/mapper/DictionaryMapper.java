package com.smd.employee.mapper;

import com.smd.employee.model.vo.dic.DictionaryVo;

import java.util.List;

public interface DictionaryMapper {
    //数据字典下拉框
    List<DictionaryVo> queryDictionary(List<String> parentCode);
}
