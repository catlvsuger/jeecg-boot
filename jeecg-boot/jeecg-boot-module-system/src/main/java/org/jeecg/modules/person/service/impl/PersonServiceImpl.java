package org.jeecg.modules.person.service.impl;

import org.jeecg.modules.person.entity.Person;
import org.jeecg.modules.person.mapper.PersonMapper;
import org.jeecg.modules.person.service.IPersonService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 人员信息
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
