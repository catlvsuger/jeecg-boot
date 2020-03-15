package org.jeecg.modules.test.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 案件
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Data
@TableName("anci_test_project")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="anci_test_project对象", description="案件")
public class TestProject {
    
	/**主键ID*/
	@TableId(type = IdType.UUID)
    @ApiModelProperty(value = "主键ID")
	private java.lang.String id;
	/**名称*/
	@Excel(name = "名称", width = 15)
    @ApiModelProperty(value = "名称")
	private java.lang.String name;
	/**被检测公司ID*/
	@Excel(name = "被检测公司ID", width = 15)
    @ApiModelProperty(value = "被检测公司ID")
	private java.lang.String companyId;
	/**被检测公司名称*/
	@Excel(name = "被检测公司名称", width = 15)
    @ApiModelProperty(value = "被检测公司名称")
	private java.lang.String companyName;
	/**实验室ID*/
	@Excel(name = "实验室ID", width = 15)
    @ApiModelProperty(value = "实验室ID")
	private java.lang.String laboratoryId;
	/**实验室名称*/
	@Excel(name = "实验室名称", width = 15)
    @ApiModelProperty(value = "实验室名称")
	private java.lang.String laboratoryName;
	/**产品ID*/
	@Excel(name = "产品ID", width = 15)
    @ApiModelProperty(value = "产品ID")
	private java.lang.String productId;
	/**型号ID*/
	@Excel(name = "型号ID", width = 15)
    @ApiModelProperty(value = "型号ID")
	private java.lang.String modelId;
	/**认证ID*/
	@Excel(name = "认证ID", width = 15)
    @ApiModelProperty(value = "认证ID")
	private java.lang.String certificationId;
	/**标准ID*/
	@Excel(name = "标准ID", width = 15)
    @ApiModelProperty(value = "标准ID")
	private java.lang.String standardId;
	/**条款结论ID*/
	@Excel(name = "条款结论ID", width = 15)
    @ApiModelProperty(value = "条款结论ID")
	private java.lang.String clauseResultId;
	/**描述*/
	@Excel(name = "描述", width = 15)
    @ApiModelProperty(value = "描述")
	private java.lang.String content;
	/**删除状态（0，正常，1已删除）*/
	@Excel(name = "删除状态（0，正常，1已删除）", width = 15)
    @ApiModelProperty(value = "删除状态（0，正常，1已删除）")
	private java.lang.String delFlag;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    @ApiModelProperty(value = "创建人")
	private java.lang.String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
	private java.util.Date createTime;
	/**修改人*/
	@Excel(name = "修改人", width = 15)
    @ApiModelProperty(value = "修改人")
	private java.lang.String updateBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
	private java.util.Date updateTime;
}
