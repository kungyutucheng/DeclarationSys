package com.gpl.module.entry.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.entry.dao.EntryConDao;
import com.gpl.module.entry.model.EntryCon;

@Service
public class EntryConBiz extends BaseBiz<EntryCon, Integer>{

	@Autowired
	private EntryConDao entryConDao;
}
