package com.bing.lan.mainLib.comm.bean;

import java.util.Date;

public class Groups {

    private Long id;

    private String groupName;

    private String groupNumber;

    private Long groupOwnerId;

    private Date updateTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Long getGroupOwnerId() {
        return groupOwnerId;
    }

    public void setGroupOwnerId(Long groupOwnerId) {
        this.groupOwnerId = groupOwnerId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}