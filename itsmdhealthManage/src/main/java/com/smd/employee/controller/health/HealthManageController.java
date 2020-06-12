package com.smd.employee.controller.health;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.smd.employee.constant.HealthManageConst;
import com.smd.employee.model.User;
import com.smd.employee.model.result.RequestResult;
import com.smd.employee.model.vo.dic.DictionaryVo;
import com.smd.employee.service.dictionary.DictionaryService;
import com.smd.employee.service.health.HealthMgService;
import com.smd.employee.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

import static com.smd.employee.util.CollectionUtils.map;


/**
 * @ProjectName: itsmdhealth
 * @Package: com.smd.employee.controller
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: yyxn2
 * @CreateDate: 2020/2/18 22:25
 * @UpdateUser: yyxn2
 * @UpdateDate: 2020/2/18 22:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */

@Controller
@Slf4j
//@RequestMapping(value = "/hlmg")
public class HealthManageController {

    @Resource
    private HealthMgService healthMgService;

    @Resource
    private DictionaryService dictionaryService;

    @GetMapping("/su1")
    public String success1() {
        //重定向到list接口
        return "redirect:/list1";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "user/login";
    }

//    public String toAdd(HttpSession session) {
    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
        List<String> parentCode = new ArrayList<String>();
        parentCode.add("jsDepartment");
        Map<String, List<DictionaryVo>> dictiMap = dictionaryService.queryDictionary(parentCode);
        if (!StringUtils.isEmpty(dictiMap.get("jsDepartment"))){
//            session.setAttribute("jsDepartment", dictiMap.get("jsDepartment"));
            model.addAttribute("jsDepartment", dictiMap.get("jsDepartment"));
            return "user/userAdd";
        }
       return  "hello";
    }

    @GetMapping("/list")
    public String list(Model model,@RequestParam(value = "name", required = true) String name,
                       @RequestParam(value = "sfzh", required = true) String sfzh,
                       @RequestParam(value = "mobile", required = true) String mobile,
                       @RequestParam(value = "branchName", required = true) String branchName,
                       @RequestParam(value = "branchId", required = true) String branchId,
                       @RequestParam(value = "djStartTime", required = false) String djStartTime,
                       @RequestParam(value = "djEndTime", required = false) String djEndTime,
                       @RequestParam(value = "pageNum", required = true) String pageNum,
                       @RequestParam(value = "pageSize", required = true) String pageSize
    ) {
//        System.out.println("Thymeleaf查询所有");
//        model.addAttribute("users", "te");
       // return "templates/login";
        Map<String,Object> user = new HashMap<String,Object>();
        user.put("name",name);
        user.put("sfzh",sfzh);
        user.put("mobile",mobile);
        user.put("branchName",branchName);
        user.put("branchId",branchId);
        //根据当前日期和身份证号查询当天的温度和路程信息，若有绑定user传递回显页面
        String date = Utils.getDate();
        Map<String, Object> employRecord = new HashMap<String, Object>();
        employRecord = healthMgService.queryTempRouteInfoByCidAndaddtime(sfzh, date,mobile);

        //分页查询
        Map<String,Object> param = new HashMap<String,Object>();
        if (!StringUtils.isEmpty(employRecord)){
            user.put("empRecord", employRecord);
            if (!StringUtils.isEmpty(employRecord.get("role_bz")) && "1".equals(employRecord.get("role_bz"))){
                param.put("isBz","1");//部长
            }

        }



        param.put("sfzh",sfzh);
        param.put("mobile",mobile);
        //默认当天
        //param.put("addtime",date);
        param.put("branchId",branchId);
        //默认当天
        //默认当天
        if (StringUtils.isEmpty(djStartTime) && StringUtils.isEmpty(djEndTime) ){
            param.put("djStartTime",date);
            param.put("djEndTime",date);
        }else {
            param.put("djStartTime",djStartTime);
            param.put("djEndTime",djEndTime);
        }

        param.put("pageNum",pageNum);
        param.put("pageSize",pageSize);
        PageInfo pageInfo = healthMgService.queryHealthReportByxpage(param);
        user.put("list",pageInfo);

        model.addAttribute("user", user);
        model.addAttribute("userJson", JSON.toJSONString(user));

        return "user/list";

    }

    @PostMapping(value = "/searchHealthReportByPageAndtime", produces="application/json;charset=utf-8" )
    @ResponseBody
    public RequestResult searchHealthReportByPageAndtime(@RequestBody Map<String,Object> param) {

        try {
            //分页查询
            //Map<String,Object> params = new HashMap<String,Object>();
            ////默认当天
            //params.put("sfzh",param.get("sfzh"));
            ////param.put("mobile",param.get("mobile"));
            ////param.put("branchId",branchId);
            //params.put("djStartTime",param.get("djStartTime"));//小写的time与大写Time注意
            //params.put("djEndTime",param.get("djEndTime"));
            //params.put("pageNum",param.get("pageNum"));
            //params.put("pageSize",param.get("pageSize"));
            //根据当前日期和身份证号查询当天的温度和路程信息，若有绑定user传递回显页面
            String date = Utils.getDate();
            Map<String, Object> employRecord = new HashMap<String, Object>();
            if (!StringUtils.isEmpty(param.get("sfzh") ) &&  (!StringUtils.isEmpty(param.get("mobile"))) && (!StringUtils.isEmpty(param.get("djStartTime") )) && (!StringUtils.isEmpty(param.get("djEndTime") )) ){
                employRecord = healthMgService.getEmployeeInfoByCid((String) param.get("sfzh"),(String)param.get("mobile "));
            }else if (!StringUtils.isEmpty(param.get("sfzh") ) &&  (!StringUtils.isEmpty(param.get("mobile")))){
                employRecord = healthMgService.queryTempRouteInfoByCidAndaddtime((String) param.get("sfzh"), date,(String)param.get("mobile "));
            }


            //分页查询
            if (!StringUtils.isEmpty(employRecord)){
                if (!StringUtils.isEmpty(employRecord.get("role_bz")) && "1".equals(employRecord.get("role_bz"))){
                    param.put("isBz","1");//部长
                }
                if (!StringUtils.isEmpty(employRecord.get("branch_id")) && "35".equals(employRecord.get("branch_id"))){
                    param.put("isLd","1");//领导
                }
            }
            //默认当天
            if (StringUtils.isEmpty(param.get("djStartTime")) && StringUtils.isEmpty(param.get("djEndTime")) ){
                param.put("djStartTime",date);
                param.put("djEndTime",date);
            }


            PageInfo pageInfo  =   healthMgService.queryHealthReportByxpage(param);
//            List<String> columns = Arrays.asList(
//                    "人员姓名","供应商","推荐级别","项目经理","技术方向","推荐状态", "登记时间");
            Map<String,Object> resultData = new HashMap<>();
//            resultData.put("columns",columns);
            resultData.put("list",pageInfo);
            return new RequestResult().of(map(resultData,"data"));
        } catch (Exception e) {
             e.printStackTrace();
            return new RequestResult().setError(true).setErrorDesc(HealthManageConst.SYSTEM_ERROR);

        }

    }

    @GetMapping("/search")
    public String search(Model model,@RequestParam(value = "name", required = true) String name,
                         @RequestParam(value = "sfzh", required = true) String sfzh,
                         @RequestParam(value = "mobile", required = true) String mobile,
                         @RequestParam(value = "branchName", required = true) String branchName,
                         @RequestParam(value = "branchId", required = true) String branchId) {
//        System.out.println("Thymeleaf查询所有");

        // return "templates/login";
        Map<String,Object> userObj = new HashMap<String,Object>();
        userObj.put("name",name);
        userObj.put("sfzh",sfzh);
        userObj.put("mobile",mobile);
        userObj.put("branchName",branchName);
        userObj.put("branchId",branchId);

        Map<String, Object> sfbzObj = healthMgService.getEmployeeInfoByCid( sfzh,mobile);
        if (!StringUtils.isEmpty(sfbzObj.get("role_bz")) && "1".equals(sfbzObj.get("role_bz")) ) {
            userObj.put("isBz","1");//部长
        }else {
            userObj.put("isBz","0");//非部长
        }


        model.addAttribute("userObj", userObj);


        List<String> parentCode = new ArrayList<String>();
        parentCode.add("jsDepartment");
        Map<String, List<DictionaryVo>> dictiMap = dictionaryService.queryDictionary(parentCode);
        if (!StringUtils.isEmpty(dictiMap.get("jsDepartment"))){
//            session.setAttribute("jsDepartment", dictiMap.get("jsDepartment"));
            model.addAttribute("jsDepartment", dictiMap.get("jsDepartment"));
        }

        return "user/uesr_search";
    }


    /**
     * 新增登记人员
     *@RequestBody 格式是json 页面提交表单用ajax
     */
    @RequestMapping(value = "/regEmploy",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult regEmploy(User params){
            try {
                //todo 非空校验
                if (StringUtils.isEmpty((String)params.getSfzh())){
                   String   res = "身份证号不能为空,请您完善！";
                    return new RequestResult().setError(true).setErrorDesc(res);
                }

                Map<String, Object> sfzhObj = healthMgService.getEmployeeInfoByCid( params.getSfzh(),params.getTelephone());
                if (!StringUtils.isEmpty(sfzhObj)) {
                    return new RequestResult().setError(true).setErrorDesc("您已注册手机，请勿重复注册");
                }
                Map<String, Object> sfzhObj1 = healthMgService.getEmployeeInfoByCid( null,params.getTelephone());
                if (!StringUtils.isEmpty(sfzhObj1)) {
                    return new RequestResult().setError(true).setErrorDesc("该手机已被其他人注册，请勿注册");
                }
                params.setAddtime(Utils.getDateTime());
                //新增人员登记
                healthMgService.ryRegisterOperator(params);
                return new RequestResult().setError(false).setErrorDesc("");
//                return RequestResult.of(map(false, "data"));
            }catch (Exception e){
                e.printStackTrace();
                return new RequestResult().setError(true).setErrorDesc(HealthManageConst.SYSTEM_ERROR);
            }
    }

    /**
     * 新增或更新疫情自报
     *@RequestBody 格式是json 页面提交表单用ajax
     */
    @RequestMapping(value = "/regTempRoute",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult regTempRoute(@RequestBody Map<String,Object> params){

        try {
            //TODO参数校验
//           Map<String, Object> recTemRoute = healthMgService.queryTempRouteInfoBycid(params);
            Map<String, Object> recTemRoute= healthMgService.queryTempRouteInfoByCidAndaddtime((String)params.get("sfzh"), (String)params.get("addtime"),(String)params.get("mobile"));
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("empRecord", recTemRoute);
            if (!StringUtils.isEmpty(recTemRoute)){
               //更新
                healthMgService.updateTempRouteInfo(params);
                return new RequestResult().of(map(resultMap, "data")).setCode(2);
            }else {
                //插入
                healthMgService.saveTempRouteInfo(params);
//                return new RequestResult().of(map(true, "data")).setCode(2);
                return new RequestResult().of(map(resultMap, "data")).setCode(2);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RequestResult().setError(true).setErrorDesc(HealthManageConst.SYSTEM_ERROR);
        }
    }
    /**
     * 查询员工档案
     */
    @PostMapping(value = "/queryEmployArchives", produces="application/json;charset=utf-8" )
    @ResponseBody
    public RequestResult queryEmployArchives(@RequestBody String request) {
        try {
            Map<String, Object>  requestDto = JSONObject.parseObject(request, new TypeReference<Map<String, Object>>(){});
//            Map<String, Object> employRecord = healthMgService.queryEmployArchives(requestDto.get("telephone"));
            Map<String, Object> employRecord = healthMgService.queryEmployArchives(requestDto);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("empRecord", employRecord);
            if (!StringUtils.isEmpty(employRecord)){
                return new RequestResult().of(map(resultMap, "data")).setCode(2);
            }
          //  return RequestResult.of(map(resultMap, "data"));
            return  new RequestResult().setError(true).setErrorDesc(HealthManageConst.LOGIN_ERROR);

        } catch (Exception e) {
//            log.error("HealthManageController.queryEmployArchives error", e);
            return new RequestResult().setError(true).setErrorDesc(HealthManageConst.SYSTEM_ERROR);
        }
    }


    @GetMapping(value = "/queryEmployArchives1")
    @ResponseBody
    public RequestResult queryEmployArchives1(@RequestParam(value = "sfzh", required = true) String sfzh) {
        try {

            Map<String, Object> employRecord = healthMgService.getEmployeeInfoByCid(sfzh,null);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("empRecord", employRecord);
            if (!StringUtils.isEmpty(employRecord)){
                return new RequestResult().of(map(resultMap, "data")).setCode(2);
            }
            //  return RequestResult.of(map(resultMap, "data"));
            return  new RequestResult().setError(true).setErrorDesc(HealthManageConst.LOGIN_ERROR);

        } catch (Exception e) {
            log.error("HealthManageController.queryEmployArchives error", e);
            return new RequestResult().setError(true).setErrorDesc(HealthManageConst.SYSTEM_ERROR);
        }
    }
}
