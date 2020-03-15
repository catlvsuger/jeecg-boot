package org.jeecg.modules.product.service.impl;

import org.jeecg.modules.product.entity.ProductModel;
import org.jeecg.modules.product.mapper.ProductModelMapper;
import org.jeecg.modules.product.service.IProductModelService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 产品型号
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Service
public class ProductModelServiceImpl extends ServiceImpl<ProductModelMapper, ProductModel> implements IProductModelService {

}
