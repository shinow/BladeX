package org.springblade.contract.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springblade.core.tool.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springblade.core.mp.base.BaseEntity;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * 采购类：活动执行合同 实体类
 *
 * @author 王策
 * @date : 2020-12-10 22:28:03
 */
@Getter
@Setter
@TableName("cgl_activity_execution_contract")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "CglActivityExecutionContract对象", description = "采购类：活动执行合同")
public class CglActivityExecutionContractEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 甲方
	 */
    @ApiModelProperty(value="甲方")
	private String cglPartyA;
	/**
	 * 乙方
	 */
    @ApiModelProperty(value="乙方")
	private String cglPartyB;
	/**
	 * 活动
	 */
    @ApiModelProperty(value="活动")
	private String cglActivity;
	/**
	 * 区域
	 */
    @ApiModelProperty(value="区域")
	private String cglArea;
	/**
	 * 本活动执行发起时间
	 */
    @ApiModelProperty(value="本活动执行发起时间")
	private String cglByTheTime;
	/**
	 * 本活动执行截止时间
	 */
    @ApiModelProperty(value="本活动执行截止时间")
	private String cglAsOfTime;
	/**
	 * 附件二
	 */
    @ApiModelProperty(value="附件二")
	private String cglAttachmentTwo;
	/**
	 * 附件三
	 */
    @ApiModelProperty(value="附件三")
	private String cglAttachmentThree;
	/**
	 * 附件一
	 */
    @ApiModelProperty(value="附件一")
	private String cglAttachmentOne;
	/**
	 * 本活动总费用
	 */
    @ApiModelProperty(value="本活动总费用")
	private String cglTotalCost;
	/**
	 * 活动场次
	 */
    @JsonSerialize(nullsUsing = NullSerializer.class)
    @ApiModelProperty(value="活动场次")
	private Integer cglSession;
	/**
	 * 甲、乙双方同意按约定向乙方付款
	 */
    @ApiModelProperty(value="甲、乙双方同意按约定向乙方付款")
	private String cglPayment;
	/**
	 * 首款付款签订后天数
	 */
    @JsonSerialize(nullsUsing = NullSerializer.class)
    @ApiModelProperty(value="首款付款签订后天数")
	private Integer cglNumberOfDays;
	/**
	 * 一次性支付剩余款项比例
	 */
    @ApiModelProperty(value="一次性支付剩余款项比例")
	private Double cglProportion;
	/**
	 * 其他方式
	 */
    @ApiModelProperty(value="其他方式")
	private String cglOtherWay;
	/**
	 * 乙方开户行
	 */
    @ApiModelProperty(value="乙方开户行")
	private String cglBankOf;
	/**
	 * 乙方户名
	 */
    @ApiModelProperty(value="乙方户名")
	private String cglAccountName;
	/**
	 * 乙方账号
	 */
    @ApiModelProperty(value="乙方账号")
	private String cglAccount;
	/**
	 * 乙方提供增值税发票【】%
	 */
    @ApiModelProperty(value="乙方提供增值税发票【】%")
	private Double cglInvoice;
	/**
	 * 8项日期要求
	 */
    @ApiModelProperty(value="8项日期要求")
	private String cglDateOfRequest;
	/**
	 * 2.1项日期要求
	 */
    @ApiModelProperty(value="2.1项日期要求")
	private String cglDateOfRequest1;
	/**
	 * 延期后支付违约金比例
	 */
    @ApiModelProperty(value="延期后支付违约金比例")
	private Double cglBreachOfContract;
	/**
	 * 活动策划方案
	 */
    @ApiModelProperty(value="活动策划方案")
	private String cglPlanningScheme;
	/**
	 * 附件二：活动排期
	 */
    @ApiModelProperty(value="附件二：活动排期")
	private String cglScheduling;
	/**
	 * 附件三：价格
	 */
    @ApiModelProperty(value="附件三：价格")
	private String cglThePrice;
	/**
	 * 附件四：考核标准
	 */
    @ApiModelProperty(value="附件四：考核标准")
	private String cglInspectionStandard;

}