package org.springblade.contract.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springblade.contract.mapper.ContractTemplateMapper;
import org.springblade.contract.vo.ContractTemplateRequestVO;
import org.springblade.contract.vo.ContractTemplateResponseVO;
import org.springblade.contract.wrapper.ContractTemplateWrapper;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.contract.entity.ContractTemplateEntity;
import org.springblade.contract.service.IContractTemplateService;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.resource.feign.IFileClient;
import org.springblade.resource.vo.FileVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 范本管理 服务实现类
 *
 * @author XHB
 * @date : 2020-09-24 13:57:38
 */
@Service
@AllArgsConstructor
public class ContractTemplateServiceImpl extends BaseServiceImpl<ContractTemplateMapper, ContractTemplateEntity> implements IContractTemplateService {

	private ContractTemplateMapper templateMapper;

	private IFileClient fileClient;
	@Override
	public IPage<ContractTemplateEntity> pageList(IPage<ContractTemplateEntity> page, ContractTemplateEntity template) {
		return baseMapper.pageList(page, template);
	}

	/**
	 * 修改范本状态
	 * @param templateStatus,id
	 * @param id
	 * @return
	 */
	@Override
	public boolean updateTemplateStatus(String templateStatus, Long  id) {
		return templateMapper.updateTemplateStatus(templateStatus, id);
	}

	/**
	 * 返回文件vo
	 * @param id
	 * @return
	 */
	@Override
	public ContractTemplateResponseVO getById(Long id) {
		//查询实体数据
		ContractTemplateEntity templateEntity=baseMapper.selectById(id);
		//将实体数据存入vo
		ContractTemplateResponseVO templateResponseVO= ContractTemplateWrapper.build().entityVO(templateEntity);
		//判断vo的文件id是否为空
		if (Func.isNoneBlank(templateResponseVO.getAttachedFiles())){
			//根据文件id查询关联的文件信息
			R<List<FileVO>> result = fileClient.getByIds(templateResponseVO.getAttachedFiles());
			//潘顿查询是否成功
			if (result.isSuccess()){
				//将文件信息set到vo 的 list
				templateResponseVO.setTemplateFileVOList(result.getData());
			}
		}
		//返回vo
		return templateResponseVO;
	}
	/**
	 * 根据模板id查询历史版本列表
	 * @param id
	 * @return
	 */
	@Override
	public ContractTemplateResponseVO getByNewId(Long id) {
		List<ContractTemplateEntity> templateEntityList=new ArrayList<>();
		//根据最新版本id查询最新范本数据
		ContractTemplateEntity templateEntity = baseMapper.selectById(id);
		while (templateEntity.getOriginalTemplateId()!=null) {
			templateEntity = baseMapper.selectById(templateEntity.getOriginalTemplateId());
			templateEntityList.add(templateEntity);
		}
		//将实体数据存入vo
		ContractTemplateResponseVO templateResponseVO= ContractTemplateWrapper.build().entityVO(templateEntity);
		templateResponseVO.setTemplateEntityOldVOList(templateEntityList);

		return templateResponseVO;
	}


	/**
	 * 新增范本，规范生成范本编号
	 * @param entity
	 * @return
	 */
	@Override
	public boolean save(ContractTemplateEntity entity) {

		return super.save(entity);
	}

}