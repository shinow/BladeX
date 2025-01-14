/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.springblade.system.user.feign;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.springblade.core.cache.utils.CacheUtil;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.system.entity.UserDepartEntity;
import org.springblade.system.user.dto.UserDTO;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.entity.UserInfo;
import org.springblade.system.user.service.IUserDepartService;
import org.springblade.system.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springblade.core.cache.constant.CacheConstant.SYS_CACHE;

/**
 * 用户服务Feign实现类
 *
 * @author Chill
 */
@RestController
@AllArgsConstructor
public class UserClient implements IUserClient {

	private IUserService service;
	private IUserDepartService departService;

	@Override
	@GetMapping(USER_INFO_BY_ID)
	public R<User> userInfoById(Long userId) {
		return R.data(service.getById(userId));
	}

	@Override
	public R<User> userInfoByUserName(String userName) {
		return R.data(service.getByUserName(userName));
	}

	@Override
	@GetMapping(USER_INFO_BY_ACCOUNT)
	public R<User> userByAccount(String tenantId, String account) {
		return R.data(service.userByAccount(tenantId, account));
	}

	@Override
	@GetMapping(USER_INFO_BY_COED)
	public R<User> userByCode(String tenantId, String code) {
		return R.data(service.userByCode(tenantId, code));
	}

	@Override
	@GetMapping(USER_INFO)
	public R<UserInfo> userInfo(String tenantId, String account) {
		return R.data(service.userInfo(tenantId, account));
	}

	@Override
	@PostMapping(SAVE_USER)
	public R<Boolean> saveUser(@RequestBody UserDTO user) {
		return R.data(service.submit(user));
	}

	@Override
	@PostMapping(SAVE_USER_BACH_API)
	public R<Boolean> saveOrUpdateBatch(List<User> user) {
		CacheUtil.clear(SYS_CACHE);
		return R.data(service.saveBatchUser(user));
	}

	@Override
	@PostMapping(SAVE_USER_DEPART_BACH_API)
	public R<Boolean> saveOrUpdateBatchDepart(List<UserDepartEntity> userDepart) {
		return R.data(departService.saveOrUpdateBatch(userDepart));
	}

	@Override
	@PostMapping(REMOVE_USER)
	public R<Boolean> removeUser(String tenantIds) {
		return R.data(service.remove(Wrappers.<User>query().lambda().in(User::getTenantId, Func.toLongList(tenantIds))));
	}

	@Override
	@GetMapping(USER_INFO_BY_DEPTID_AND_POSTID)
	public R<List<User>> userInfoByDeptAndPost(String deptId, String postId) {
		return R.data(service.userInfoByDeptIdAndPostId(deptId,postId));
	}

	@Override
	@GetMapping(USER_INFO_BY_USERID_ARRAY)
	public R<List<User>> userInfoByUserIds(String userIds) {
		return R.data(service.userInfoByUserIds(userIds));
	}

	@Override
	@GetMapping(USER_INFO_BY_BENCH_MINISTER)
	public R<List<User>> userInfoByBenchMinister(String benchUserId) {
		return R.data(service.userInfoByBenchMinister(benchUserId));
	}

	@Override
	@GetMapping(GET_ID_BY_LUNID)
	public R<Long> getUserIdByAssociationId(String associationId) {
		return R.data(service.getUserIdByAssociationId(associationId));
	}
}
