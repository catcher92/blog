package com.catcher92.blog.service;

import com.catcher92.blog.validate.UpdateGroup;
import com.catcher92.blog.vo.SysUserVo;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Validated
public interface SysUserService {

    /**
     * 新增用户
     * @param sysUserVo
     * @return
     */
    SysUserVo save(@NotNull @Valid SysUserVo sysUserVo);

    /**
     * 通过id查找
     * @param id
     * @return
     */
    SysUserVo findById(@NotNull(message = "id不能为空") Long id);

    @Validated({Default.class, UpdateGroup.class})
    int updateSelective(@NotNull @Valid SysUserVo sysUserVo);
}
