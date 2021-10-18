package com.zhiku.elearning.service;

import org.springframework.stereotype.Service;

/**
 * @author: SongyangJi
 * @description:
 * @since: 2021/10/18
 */

@Service
public class JustForTestService {
    String x = "for test";

    @Override
    public String toString() {
        return "JustForTestService{" +
                "x='" + x + '\'' +
                '}';
    }
}
