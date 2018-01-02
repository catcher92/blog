package com.catcher92.blog.dao.impl;

import com.catcher92.blog.dao.SysUserDaoService;
import com.catcher92.blog.mapper.SysUserPoMapper;
import com.catcher92.blog.po.SysUserPo;
import com.catcher92.blog.po.SysUserPoExample;
import com.catcher92.framework.entity.Page;
import com.catcher92.framework.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserDaoServiceImpl extends DefaultDaoServiceImpl<SysUserPo, SysUserPoExample, SysUserPoMapper> implements SysUserDaoService {

    public SysUserDaoServiceImpl(SysUserPoMapper mapper) {
        super(mapper);
    }

    @Override
    public Page<SysUserPo> find(SysUserPo sysUserPo, Page<SysUserPo> page) {
        return find(initExample(sysUserPo), page);
    }

    private SysUserPoExample initExample(SysUserPo sysUserPo) {
        SysUserPoExample example = new SysUserPoExample();
        SysUserPoExample.Criteria criteria = example.createCriteria();
        if (null != sysUserPo) {

        }
        return example;
    }
}
