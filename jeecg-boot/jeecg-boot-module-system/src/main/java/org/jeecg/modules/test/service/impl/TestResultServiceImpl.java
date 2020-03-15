package org.jeecg.modules.test.service.impl;

import org.jeecg.modules.test.entity.TestResult;
import org.jeecg.modules.test.mapper.TestResultMapper;
import org.jeecg.modules.test.service.ITestResultService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 测试结果
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Service
public class TestResultServiceImpl extends ServiceImpl<TestResultMapper, TestResult> implements ITestResultService {

}
