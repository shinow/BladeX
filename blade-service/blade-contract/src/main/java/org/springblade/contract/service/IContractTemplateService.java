package org.springblade.contract.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springblade.abutment.vo.EkpVo;
import org.springblade.contract.entity.ContractTemplateEntity;
import org.springblade.contract.vo.ContractTemplateRequestVO;
import org.springblade.contract.vo.ContractTemplateResponseVO;
import org.springblade.core.mp.base.BaseService;
import org.springblade.core.tool.api.R;

import java.util.List;

/**
 * 范本管理 服务类
 *
 * @author XHB
 * @date : 2020-09-24 13:57:37
 */
public interface IContractTemplateService extends BaseService<ContractTemplateEntity> {

	/**
	 * 分页查询
	 * @param page
	 * @param template
	 * @return
	 */
	IPage<ContractTemplateResponseVO> pageList(IPage<ContractTemplateEntity> page, ContractTemplateRequestVO template);

	/**
	 * 修改范本状态
	 * @param templateStatus,ids
	 * @return
	 */
	boolean updateTemplateStatus(String templateStatus,Long id);

	/**
	 * 范本是否启用
	 * @param enabled
	 * @param id
	 * @return
	 */
	boolean updateTemplateEnabled( String enabled, Long id);

	/**
	 * 重写查询，返回附件到VO
	 * @param id
	 * @return
	 */
	ContractTemplateResponseVO getById(Long id);

	/**
	 * 根据模板id查询历史版本列表
	 * @param id
	 * @return
	 */
	ContractTemplateResponseVO getByNewId(Long id);

	/**
	 * 新增範本
	 * @param templateEntity
	 * @return
	 */
	boolean save(ContractTemplateEntity templateEntity,String type);

	/**
	 * 米板新增宋声
	 * @param entity
	 * @return
	 */
    R<EkpVo> appTemplate(ContractTemplateEntity entity);
	/**
	 *根据范本名称合同范本模板编号筛选是否存在新增重复范本
	 * @param templateName
	 * @param templateCode
	 * @return
	 */
	List<ContractTemplateEntity> FilterDuplicates(String templateName, String templateCode);
}
