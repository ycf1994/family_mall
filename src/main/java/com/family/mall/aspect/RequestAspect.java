package com.family.mall.aspect;

import com.alibaba.fastjson.JSON;
import com.family.mall.ContextHolder;
import com.family.mall.entity.ControllerLogDO;
import com.family.mall.expection.MallException;
import com.family.mall.model.vo.MallResponseVO;
import com.family.mall.model.vo.ResponseEnum;
import com.family.mall.service.common.AsyncService;
import com.family.mall.service.idworker.IIdWorkService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class RequestAspect {

    @Autowired
    private IIdWorkService idWorkService;
    @Autowired
    private AsyncService asyncService;

    // 用于拦截标签
    @Pointcut("execution(public * com.family.mall.controller..*.*(..))")
    private void logPattern() {
    }

    /**
     * 环绕
     *
     * @param joinPoint 切入点
     * @return
     * @throws Throwable
     */
    @Around("logPattern()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        ContextHolder.setClueId(System.currentTimeMillis()+"_"+idWorkService.getId());
        String uri = request.getRequestURI();
        String req = JSON.toJSONString(joinPoint.getArgs());

        MallResponseVO responseVO = invoke(joinPoint);

        ControllerLogDO logDO = new ControllerLogDO();
        logDO.setRequestUrl(uri);
        logDO.setRt(responseVO.getRt().intValue());
        logDO.setRequestBody(req);
        logDO.setResponseBody(JSON.toJSONString(responseVO));
        logDO.setClueId(ContextHolder.getClueId());
        logDO.setTime(new Date());
        logDO.setSuccess(responseVO.getSuccess().toString());
        asyncService.writeControllerLog(logDO);
        return responseVO;
    }

    private MallResponseVO invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return MallResponseVO.success(joinPoint.proceed(),System.currentTimeMillis()-start);
        } catch (MallException e) {
            return MallResponseVO.fail(e,System.currentTimeMillis()-start);
        }catch (Exception e){
            return MallResponseVO.fail(ResponseEnum.ERROR,System.currentTimeMillis()-start);
        }
    }
}
