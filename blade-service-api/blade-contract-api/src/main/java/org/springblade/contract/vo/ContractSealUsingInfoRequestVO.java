package org.springblade.contract.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.contract.entity.ContractSealUsingInfoEntity;
import org.springblade.core.mp.base.BaseEntity;

import java.time.LocalDateTime;

/**
 * 用印名称 请求模型VO
 *
 * @NotNull 验证对象是否不为null, 无法查检长度为0的字符串
 * @NotBlank 检查约束 (字符串) 是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
 * @NotEmpty 检查(集合)约束元素是否为NULL或者是EMPTY.
 *
 * @author szw
 * @date : 2020-09-24 01:27:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "用印名称请求对象")
public class ContractSealUsingInfoRequestVO extends ContractSealUsingInfoEntity {

	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用印时间")
	private LocalDateTime signTime;

    @ApiModelProperty(value="用印人")
	private Long signPerson;

    @ApiModelProperty(value="用印说明")
	private String signRemark;

    @ApiModelProperty(value="关联合同id")
	private Long refContractId;

}