package com.scloud.discoveryeureka.entity;

import java.io.Serializable;

public class User implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.ID
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.SFZH
     *
     * @mbg.generated
     */
    private String sfzh;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.BRANCH_ID
     *
     * @mbg.generated
     */
    private String branchId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.MOBILE
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.MAIL
     *
     * @mbg.generated
     */
    private String mail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.USER_PASSWORD
     *
     * @mbg.generated
     */
    private String userPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.ADDRESS
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.ROLE_BZ
     *
     * @mbg.generated
     */
    private String roleBz;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.ADDUSER
     *
     * @mbg.generated
     */
    private String adduser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.ADDTIME
     *
     * @mbg.generated
     */
    private String addtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.UPDATEUSER
     *
     * @mbg.generated
     */
    private String updateuser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.UPDATETIME
     *
     * @mbg.generated
     */
    private String updatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SMD_USERINFO.DELETE_STATUS
     *
     * @mbg.generated
     */
    private String deleteStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_SMD_USERINFO
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.ID
     *
     * @return the value of T_SMD_USERINFO.ID
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.ID
     *
     * @param id the value for T_SMD_USERINFO.ID
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.SFZH
     *
     * @return the value of T_SMD_USERINFO.SFZH
     *
     * @mbg.generated
     */
    public String getSfzh() {
        return sfzh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.SFZH
     *
     * @param sfzh the value for T_SMD_USERINFO.SFZH
     *
     * @mbg.generated
     */
    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.NAME
     *
     * @return the value of T_SMD_USERINFO.NAME
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.NAME
     *
     * @param name the value for T_SMD_USERINFO.NAME
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.BRANCH_ID
     *
     * @return the value of T_SMD_USERINFO.BRANCH_ID
     *
     * @mbg.generated
     */
    public String getBranchId() {
        return branchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.BRANCH_ID
     *
     * @param branchId the value for T_SMD_USERINFO.BRANCH_ID
     *
     * @mbg.generated
     */
    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.MOBILE
     *
     * @return the value of T_SMD_USERINFO.MOBILE
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.MOBILE
     *
     * @param mobile the value for T_SMD_USERINFO.MOBILE
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.MAIL
     *
     * @return the value of T_SMD_USERINFO.MAIL
     *
     * @mbg.generated
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.MAIL
     *
     * @param mail the value for T_SMD_USERINFO.MAIL
     *
     * @mbg.generated
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.USER_PASSWORD
     *
     * @return the value of T_SMD_USERINFO.USER_PASSWORD
     *
     * @mbg.generated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.USER_PASSWORD
     *
     * @param userPassword the value for T_SMD_USERINFO.USER_PASSWORD
     *
     * @mbg.generated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.ADDRESS
     *
     * @return the value of T_SMD_USERINFO.ADDRESS
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.ADDRESS
     *
     * @param address the value for T_SMD_USERINFO.ADDRESS
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.ROLE_BZ
     *
     * @return the value of T_SMD_USERINFO.ROLE_BZ
     *
     * @mbg.generated
     */
    public String getRoleBz() {
        return roleBz;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.ROLE_BZ
     *
     * @param roleBz the value for T_SMD_USERINFO.ROLE_BZ
     *
     * @mbg.generated
     */
    public void setRoleBz(String roleBz) {
        this.roleBz = roleBz == null ? null : roleBz.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.ADDUSER
     *
     * @return the value of T_SMD_USERINFO.ADDUSER
     *
     * @mbg.generated
     */
    public String getAdduser() {
        return adduser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.ADDUSER
     *
     * @param adduser the value for T_SMD_USERINFO.ADDUSER
     *
     * @mbg.generated
     */
    public void setAdduser(String adduser) {
        this.adduser = adduser == null ? null : adduser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.ADDTIME
     *
     * @return the value of T_SMD_USERINFO.ADDTIME
     *
     * @mbg.generated
     */
    public String getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.ADDTIME
     *
     * @param addtime the value for T_SMD_USERINFO.ADDTIME
     *
     * @mbg.generated
     */
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.UPDATEUSER
     *
     * @return the value of T_SMD_USERINFO.UPDATEUSER
     *
     * @mbg.generated
     */
    public String getUpdateuser() {
        return updateuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.UPDATEUSER
     *
     * @param updateuser the value for T_SMD_USERINFO.UPDATEUSER
     *
     * @mbg.generated
     */
    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.UPDATETIME
     *
     * @return the value of T_SMD_USERINFO.UPDATETIME
     *
     * @mbg.generated
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.UPDATETIME
     *
     * @param updatetime the value for T_SMD_USERINFO.UPDATETIME
     *
     * @mbg.generated
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SMD_USERINFO.DELETE_STATUS
     *
     * @return the value of T_SMD_USERINFO.DELETE_STATUS
     *
     * @mbg.generated
     */
    public String getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SMD_USERINFO.DELETE_STATUS
     *
     * @param deleteStatus the value for T_SMD_USERINFO.DELETE_STATUS
     *
     * @mbg.generated
     */
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SMD_USERINFO
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sfzh=").append(sfzh);
        sb.append(", name=").append(name);
        sb.append(", branchId=").append(branchId);
        sb.append(", mobile=").append(mobile);
        sb.append(", mail=").append(mail);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", address=").append(address);
        sb.append(", roleBz=").append(roleBz);
        sb.append(", adduser=").append(adduser);
        sb.append(", addtime=").append(addtime);
        sb.append(", updateuser=").append(updateuser);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}