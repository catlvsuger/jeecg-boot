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
 * @Description: 测试结果
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Data
@TableName("anci_test_result")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="anci_test_result对象", description="测试结果")
public class TestResult {
    
	/**主键ID*/
	@TableId(type = IdType.UUID)
    @ApiModelProperty(value = "主键ID")
	private java.lang.String id;
	/**标准编号*/
	@Excel(name = "标准编号", width = 15)
    @ApiModelProperty(value = "标准编号")
	private java.lang.String standardCode;
	/**条款号*/
	@Excel(name = "条款号", width = 15)
    @ApiModelProperty(value = "条款号")
	private java.lang.String clause;
	/**条款名称*/
	@Excel(name = "条款名称", width = 15)
    @ApiModelProperty(value = "条款名称")
	private java.lang.String name;
	/**案件ID*/
	@Excel(name = "案件ID", width = 15)
    @ApiModelProperty(value = "案件ID")
	private java.lang.String caseId;
	/**要求*/
	@Excel(name = "要求", width = 15)
    @ApiModelProperty(value = "要求")
	private java.lang.String requirement;
	/**现象记录*/
	@Excel(name = "现象记录", width = 15)
    @ApiModelProperty(value = "现象记录")
	private java.lang.String resultRemark;
	/**结论*/
	@Excel(name = "结论", width = 15)
    @ApiModelProperty(value = "结论")
	private java.lang.String verdict;
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
