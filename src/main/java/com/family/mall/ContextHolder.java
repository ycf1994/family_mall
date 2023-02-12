package com.family.mall;

import com.family.mall.model.dto.UserDTO;
import org.slf4j.MDC;

import java.io.Serializable;

public class ContextHolder implements Serializable {
    private static ThreadLocal<UserDTO> userLocal = new ThreadLocal<>();
    private static ThreadLocal<String> clueIdLocal = new ThreadLocal<>();

    public static void setUser(UserDTO user){
        userLocal.set(user);
    }

    public static void setClueId(String clueId){
        clueIdLocal.set(clueId);
        MDC.put("clueId",clueId);
    }

    public static UserDTO getUser(){
        return userLocal.get();
    }

    public static String getClueId(){
        return clueIdLocal.get();
    }

}
