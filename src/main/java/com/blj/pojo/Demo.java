package com.blj.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 测试实体类
 */
@ApiModel("用户实体类")
public class Demo {
    @ApiModelProperty("用户id")
    private int id;
    @ApiModelProperty("用户姓名")
    private String name;
   @ApiModelProperty("备注信息")
    private String remarks;//备注信息

    @ApiModelProperty("修改时间")
    private Date creatTime;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
