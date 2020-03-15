package org.jeecg.modules.test.service.impl;

import org.jeecg.modules.test.entity.TestType;
import org.jeecg.modules.test.mapper.TestTypeMapper;
import org.jeecg.modules.test.service.ITestTypeService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 测试分类
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Service
public class TestTypeServiceImpl extends ServiceImpl<TestTypeMapper, TestType> implements ITestTypeService {

}
