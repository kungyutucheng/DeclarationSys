package com.gpl.module.base.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.base.dao.TradeTypeDao;
import com.gpl.module.base.model.TradeType;

@Service
public class TradeTypeBiz extends BaseBiz<TradeType, Integer>{

	@Autowired
	private TradeTypeDao tradeTypeDao;
}
