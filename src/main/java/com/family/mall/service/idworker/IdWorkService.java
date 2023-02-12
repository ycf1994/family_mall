package com.family.mall.service.idworker;

import com.family.mall.entity.IdWorkerDO;
import com.family.mall.mapper.IdWorkerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IdWorkService implements IIdWorkService{

    @Autowired
    private IdWorkerMapper idWorkerMapper;

    @Override
    public Long getId() {
        IdWorkerDO idWorkerDO = new IdWorkerDO();
        idWorkerDO.setValue(1);
        idWorkerMapper.insert(idWorkerDO);
        Long id = idWorkerDO.getId();
        idWorkerMapper.deleteById(id);
        return id;
    }
}
