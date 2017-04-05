package com.qccr.livtrip.biz.service.destination.impl;

import com.qccr.livtrip.biz.service.destination.StateService;
import com.qccr.livtrip.dal.destination.StateDao;
import com.qccr.livtrip.model.destination.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/4 11:40 Exp $$
 */
@Service
public class StateServiceImpl implements StateService{

    @Autowired
    private StateDao stateDao;

    @Override
    public int insert(State state) {
        return stateDao.insert(state);
    }
}
