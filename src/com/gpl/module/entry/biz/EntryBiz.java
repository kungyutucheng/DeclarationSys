package com.gpl.module.entry.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.entry.dao.EntryDao;
import com.gpl.module.entry.model.Entry;

@Service
public class EntryBiz extends BaseBiz<Entry, Integer>{

	@Autowired
	private EntryDao entryDao;
	
}
