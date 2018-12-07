package com.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;

/**
 * 商品管理 service
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private TbItemMapper tbItemMapper;
	
	/**
	 *  框架整合测试方法
	 *  查询商品信息
	 */
	@Override
	public TbItem getTbItemById(Long itemId) {
		// 根据主键查询tbitem
//		TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andIdEqualTo(itemId);
		// 执行查询
		List<TbItem> list = tbItemMapper.selectByExample(example);
		
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

		
}
