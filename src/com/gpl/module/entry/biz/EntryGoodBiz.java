package com.gpl.module.entry.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.entry.dao.EntryGoodDao;
import com.gpl.module.entry.model.EntryGood;

@Service
public class EntryGoodBiz extends BaseBiz<EntryGood, Integer>{

	@Autowired
	private EntryGoodDao entryGoodDao;
}
