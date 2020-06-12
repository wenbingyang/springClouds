package com.smd.employee.service.health;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smd.employee.mapper.HealthMgMapper;
import com.smd.employee.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: itsmdhealth
 * @Package: com.smd.employee.service.health
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: yyxn2
 * @CreateDate: 2020/2/19 17:54
 * @UpdateUser: yyxn2
 * @UpdateDate: 2020/2/19 17:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@Slf4j
@Service
public class HealthMgService {

    @Resource
    private HealthMgMapper  healthMgMapper;

    public Map<String, Object> queryEmployArchives(Map<String,Object> params){
        return  healthMgMapper.queryEmployArchives(params);
    }

    public Map<String, Object> getEmployeeInfoByCid(String sfzh,String telephone){
        return  healthMgMapper.getEmployeeInfoByCid(sfzh,telephone);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void ryRegisterOperator(User params) {
            if (!StringUtils.isEmpty((String)params.getSfzh())){
                healthMgMapper.saveRyRegInfo(params);
            }
    }

    public  Map<String,Object> queryTempRouteInfoBycid(Map<String,Object> params) {
        if (!StringUtils.isEmpty((String) params.get("sfzh"))){
          return healthMgMapper.queryTempRouteInfoBycid(params);
        }
        return  null;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void saveTempRouteInfo(Map<String, Object> params) {
        healthMgMapper.saveryTempinfo(params);
        healthMgMapper.saveryRoutenfo(params);
    }

    public Map<String, Object> queryTempRouteInfoByCidAndaddtime( String sfzh,  String addtime, String mobile){
        return  healthMgMapper.queryTempRouteInfoByCidAndaddtime(sfzh,addtime,mobile);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void updateTempRouteInfo(Map<String, Object> params) {
        healthMgMapper.updateryTempinfo(params);
        healthMgMapper.updateryRoutenfo(params);
    }

    public PageInfo queryHealthReportByxpage(Map<String,Object> params){
        PageHelper.startPage(Integer.parseInt(params.get("pageNum").toString()) ,Integer.parseInt(params.get("pageSize").toString()));
        PageInfo<Map<String,Object>> pageInfo = null;
        List<Map<String, Object>> Rydjlist= healthMgMapper.queryHealthReportByxpage(params);
        pageInfo = new PageInfo<>(Rydjlist);
        return  pageInfo;

    }

}
