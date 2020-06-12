package com.smd.employee.mapper;

import com.smd.employee.annotation.HmMapper;
import com.smd.employee.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: itsmdhealth
 * @Package: com.smd.employee.mapper
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: yyxn2
 * @CreateDate: 2020/2/19 18:07
 * @UpdateUser: yyxn2
 * @UpdateDate: 2020/2/19 18:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
//@HmMapper
public interface HealthMgMapper {
//    Map<String, Object> queryEmployArchives(@Param("sfzh") String sfzh);
    Map<String, Object> queryEmployArchives(Map<String,Object> params);

    Map<String, Object> getEmployeeInfoByCid(@Param("sfzh")  String sfzh,@Param("mobile")  String telephone);

    int saveRyRegInfo(User user);

    Map<String, Object> queryTempRouteInfoBycid(Map<String, Object> params);

    int saveryTempinfo(Map<String, Object> params);

    int saveryRoutenfo(Map<String, Object> params);

    Map<String, Object> queryTempRouteInfoByCidAndaddtime(@Param("sfzh")  String sfzh,@Param("addtime")  String addtime,@Param("mobile")  String mobile);

    void updateryTempinfo(Map<String, Object> params);

    void updateryRoutenfo(Map<String, Object> params);

    List<Map<String, Object>> queryHealthReportByxpage(Map<String, Object> params);
}
