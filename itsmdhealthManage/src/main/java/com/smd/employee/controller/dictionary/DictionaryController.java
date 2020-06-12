package com.smd.employee.controller.dictionary;


import com.smd.employee.constant.HealthManageConst;
import com.smd.employee.model.result.RequestResult;
import com.smd.employee.model.vo.dic.DictionaryVo;
import com.smd.employee.service.dictionary.DictionaryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.smd.employee.util.CollectionUtils.map;

/**
 * @ProjectName: itsmdhealth
 * @Package: com.smd.employee.controller.dictionary
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: yyxn2
 * @CreateDate: 2020/2/19 16:58
 * @UpdateUser: yyxn2
 * @UpdateDate: 2020/2/19 16:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@RestController
public class DictionaryController {
    @Resource
    private DictionaryService dictionaryService;

    @PostMapping("/queryDictionary")
    public RequestResult queryDictionary(@RequestBody List<String> parentCode) {
        try {
            Map<String, List<DictionaryVo>> dictiMap = dictionaryService.queryDictionary(parentCode);
            return  RequestResult.of(map(dictiMap,"data"));
        } catch (Exception e) {
//            e.printStackTrace();
            return new RequestResult().setError(true).setErrorDesc(HealthManageConst.SYSTEM_ERROR);
        }
    }

}
