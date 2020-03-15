package org.jeecg.modules.company.service.impl;

import org.jeecg.modules.company.entity.Company;
import org.jeecg.modules.company.mapper.CompanyMapper;
import org.jeecg.modules.company.service.ICompanyService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 公司信息
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
