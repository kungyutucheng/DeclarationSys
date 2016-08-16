package com.gpl.module.base.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.base.dao.PortDao;
import com.gpl.module.base.model.Port;

@Service
public class PortBiz extends BaseBiz<Port, Integer>{

	@Autowired
	private PortDao portDao;
}
