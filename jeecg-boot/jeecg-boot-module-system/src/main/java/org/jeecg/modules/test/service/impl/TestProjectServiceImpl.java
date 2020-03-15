package org.jeecg.modules.test.service.impl;

import org.jeecg.modules.test.entity.TestProject;
import org.jeecg.modules.test.mapper.TestProjectMapper;
import org.jeecg.modules.test.service.ITestProjectService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 案件
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Service
public class TestProjectServiceImpl extends ServiceImpl<TestProjectMapper, TestProject> implements ITestProjectService {

}
