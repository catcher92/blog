package com.catcher92.blog.service.impl;

import com.catcher92.blog.dao.SysUserDaoService;
import com.catcher92.blog.po.SysUserPo;
import com.catcher92.blog.service.SysUserService;
import com.catcher92.blog.util.ConversionUtil;
import com.catcher92.blog.util.MD5Util;
import com.catcher92.blog.util.SecurityUtil;
import com.catcher92.blog.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired private SysUserDaoService sysUserDaoService;

    @Override
    public SysUserVo save(SysUserVo sysUserVo) {
        sysUserVo.setDeleteStatus(false);
        sysUserVo.setPassword(MD5Util.encode(sysUserVo.getPassword()));
        sysUserVo.setCreateBy(SecurityUtil.getCurrentUserName());
        sysUserVo.setCreateDate(new Date());
        sysUserVo.setUpdateBy(SecurityUtil.getCurrentUserName());
        sysUserVo.setUpdateDate(new Date());
        if (null == sysUserVo.getNickName()) {
            sysUserVo.setNickName(sysUserVo.getName());
        }
        SysUserPo sysUserPo = sysUserDaoService.save(ConversionUtil.convert(sysUserVo, SysUserPo.class));
        return ConversionUtil.convert(sysUserPo, SysUserVo.class);
    }

    @Override
    public SysUserVo findById(Long id) {
        return ConversionUtil.convert(sysUserDaoService.getById(id), SysUserVo.class);
    }

    @Override
    public int updateSelective(SysUserVo sysUserVo) {
        sysUserVo.setUpdateBy(SecurityUtil.getCurrentUserName());
        sysUserVo.setUpdateDate(new Date());
        return sysUserDaoService.updateSelective(ConversionUtil.convert(sysUserVo, SysUserPo.class));
    }
}
