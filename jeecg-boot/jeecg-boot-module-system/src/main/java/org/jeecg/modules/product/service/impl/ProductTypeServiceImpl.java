package org.jeecg.modules.product.service.impl;

import org.jeecg.modules.product.entity.ProductType;
import org.jeecg.modules.product.mapper.ProductTypeMapper;
import org.jeecg.modules.product.service.IProductTypeService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 产品分类
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

}
