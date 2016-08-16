package com.gpl.module.base.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.base.dao.CurrencyDao;
import com.gpl.module.base.model.Currency;

@Service
public class CurrencyBiz extends BaseBiz<Currency, Integer>{

	@Autowired
	private CurrencyDao currencyDao;
	
}
