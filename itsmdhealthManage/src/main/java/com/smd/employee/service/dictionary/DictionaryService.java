package com.smd.employee.service.dictionary;

import com.smd.employee.mapper.DictionaryMapper;
import com.smd.employee.model.vo.dic.DictionaryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DictionaryService {

    @Resource
    private DictionaryMapper dictionryMapper;

    /**
     * @author K0570200
     * 根据传入分类编码，获取对应数据数据字典
     * 传入空，默认查所有
     */
    public  Map<String, List<DictionaryVo>> queryDictionary(List<String> parentCode) {

        List<DictionaryVo> list= dictionryMapper.queryDictionary(parentCode);
        Map<String, List<DictionaryVo>> map =
                list.stream()
                        .collect(Collectors.groupingBy(DictionaryVo:: getParent_code));
        return map;
    }

}
