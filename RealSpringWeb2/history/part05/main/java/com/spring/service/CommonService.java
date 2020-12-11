package com.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.repository.CommonDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonService {

    final public CommonDao dao;

    @Transactional
    public List<Map<String, Object>> getCodeList(Map params) {
        log.debug(">>" + params.toString());
        List<Map<String, Object>> resultList = dao.selectList("common.selectItems", params);
        return resultList;
    }

}
