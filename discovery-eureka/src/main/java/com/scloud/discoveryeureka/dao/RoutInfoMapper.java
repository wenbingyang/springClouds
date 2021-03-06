package com.scloud.discoveryeureka.dao;

import com.scloud.discoveryeureka.entity.RoutInfo;
import java.util.List;

public interface RoutInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SMD_ROUTEINFO
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SMD_ROUTEINFO
     *
     * @mbg.generated
     */
    int insert(RoutInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SMD_ROUTEINFO
     *
     * @mbg.generated
     */
    RoutInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SMD_ROUTEINFO
     *
     * @mbg.generated
     */
    List<RoutInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SMD_ROUTEINFO
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RoutInfo record);
}