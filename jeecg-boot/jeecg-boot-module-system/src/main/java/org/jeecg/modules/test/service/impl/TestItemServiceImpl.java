package org.jeecg.modules.test.service.impl;

import org.jeecg.modules.test.entity.TestItem;
import org.jeecg.modules.test.mapper.TestItemMapper;
import org.jeecg.modules.test.service.ITestItemService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 测试项
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Service
public class TestItemServiceImpl extends ServiceImpl<TestItemMapper, TestItem> implements ITestItemService {

}
