package com.family.mall.service.common;

import com.family.mall.entity.ControllerLogDO;
import com.family.mall.mapper.ControllerLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {
    @Autowired
    private ControllerLogMapper controllerLogMapper;

    @Async("asyncPool")
    public void writeControllerLog(ControllerLogDO logDO){
        controllerLogMapper.insert(logDO);
    }
}
