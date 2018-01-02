package com.catcher92.blog.dao;

import com.catcher92.blog.po.SysUserPo;
import com.catcher92.framework.entity.Page;

public interface SysUserDaoService {

    SysUserPo save(SysUserPo sysUserPo);

    SysUserPo getById(Long id);

    Page<SysUserPo> find(SysUserPo sysUserPo, Page<SysUserPo> page);

    int updateSelective(SysUserPo sysUserPo);
}
