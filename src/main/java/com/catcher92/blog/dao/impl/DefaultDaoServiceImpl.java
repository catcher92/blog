package com.catcher92.blog.dao.impl;

import com.catcher92.framework.entity.BaseExample;
import com.catcher92.framework.entity.BasePo;
import com.catcher92.framework.entity.Page;
import com.catcher92.framework.mapper.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

import java.util.List;

public class DefaultDaoServiceImpl<K extends BasePo, V extends BaseExample> {

    private BaseMapper<K, V> mapper;

    public void setMapper(BaseMapper<K, V> mapper) {
        this.mapper = mapper;
    }

    public K save(K entity) {
        mapper.insert(entity);
        return entity;
    }

    public K saveSelective(K entity) {
        mapper.insertSelective(entity);
        return entity;
    }

    public int delete(K entity) {
        return mapper.deleteByPrimaryKey(entity.getId());
    }

    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int deleteByExample(V example) {
        return mapper.deleteByExample(example);
    }

    public int update(K entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateSelective(K entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public int updateByExample(K entity, V example) {
        return mapper.updateByExample(entity, example);
    }

    public int updateByExampleSelective(K entity, V example) {
        return mapper.updateByExampleSelective(entity, example);
    }

    public long count(V example) {
        return mapper.countByExample(example);
    }

    public K getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public K get(V example) {
        List<K> list = mapper.selectByExample(example);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List<K> find(V example) {
        return mapper.selectByExample(example);
    }

    public Page<K> find(V example, Page<K> page) {
        String orderBy = "id desc";
        if (null != page.getOrderBy() && !page.getOrderBy().trim().isEmpty()) {
            orderBy = page.getOrderBy();
        }
        com.github.pagehelper.Page<Object> pageHelper = PageHelper.startPage(page.getPageNo(), page.getPageSize(), orderBy);
        List<K> list = mapper.selectByExample(example);
        page.setTotal(pageHelper.getTotal());
        page.setList(list);
        return page;
    }
}
