package com.gpl.module.base.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.base.dao.ChargeTypeDao;
import com.gpl.module.base.model.ChargeType;

@Service
public class ChargeTypeBiz extends BaseBiz<ChargeType, Integer>{

	@Autowired
	private ChargeTypeDao chargeTypeDao;
	
}
