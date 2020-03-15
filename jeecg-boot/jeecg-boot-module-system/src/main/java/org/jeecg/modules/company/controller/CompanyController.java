package org.jeecg.modules.company.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.company.entity.Company;
import org.jeecg.modules.company.service.ICompanyService;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

 /**
 * @Description: 公司信息
 * @Author: jeecg-boot
 * @Date:   2020-03-15
 * @Version: V1.0
 */
@Slf4j
@Api(tags="公司信息")
@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private ICompanyService companyService;
	
	/**
	  * 分页列表查询
	 * @param company
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "公司信息-分页列表查询")
	@ApiOperation(value="公司信息-分页列表查询", notes="公司信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Company>> queryPageList(Company company,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<Company>> result = new Result<IPage<Company>>();
		QueryWrapper<Company> queryWrapper = QueryGenerator.initQueryWrapper(company, req.getParameterMap());
		Page<Company> page = new Page<Company>(pageNo, pageSize);
		IPage<Company> pageList = companyService.page(page, queryWrapper);
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}
	
	/**
	  *   添加
	 * @param company
	 * @return
	 */
	@AutoLog(value = "公司信息-添加")
	@ApiOperation(value="公司信息-添加", notes="公司信息-添加")
	@PostMapping(value = "/add")
	public Result<Company> add(@RequestBody Company company) {
		Result<Company> result = new Result<Company>();
		try {
			companyService.save(company);
			result.success("添加成功！");
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			result.error500("操作失败");
		}
		return result;
	}
	
	/**
	  *  编辑
	 * @param company
	 * @return
	 */
	@AutoLog(value = "公司信息-编辑")
	@ApiOperation(value="公司信息-编辑", notes="公司信息-编辑")
	@PutMapping(value = "/edit")
	public Result<Company> edit(@RequestBody Company company) {
		Result<Company> result = new Result<Company>();
		Company companyEntity = companyService.getById(company.getId());
		if(companyEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = companyService.updateById(company);
			//TODO 返回false说明什么？
			if(ok) {
				result.success("修改成功!");
			}
		}
		
		return result;
	}
	
	/**
	  *   通过id删除
	 * @param id
	 * @return
	 */
	@AutoLog(value = "公司信息-通过id删除")
	@ApiOperation(value="公司信息-通过id删除", notes="公司信息-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		try {
			companyService.removeById(id);
		} catch (Exception e) {
			log.error("删除失败",e.getMessage());
			return Result.error("删除失败!");
		}
		return Result.ok("删除成功!");
	}
	
	/**
	  *  批量删除
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "公司信息-批量删除")
	@ApiOperation(value="公司信息-批量删除", notes="公司信息-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<Company> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<Company> result = new Result<Company>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.companyService.removeByIds(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@AutoLog(value = "公司信息-通过id查询")
	@ApiOperation(value="公司信息-通过id查询", notes="公司信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Company> queryById(@RequestParam(name="id",required=true) String id) {
		Result<Company> result = new Result<Company>();
		Company company = companyService.getById(id);
		if(company==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(company);
			result.setSuccess(true);
		}
		return result;
	}

  /**
      * 导出excel
   *
   * @param request
   * @param response
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, HttpServletResponse response) {
      // Step.1 组装查询条件
      QueryWrapper<Company> queryWrapper = null;
      try {
          String paramsStr = request.getParameter("paramsStr");
          if (oConvertUtils.isNotEmpty(paramsStr)) {
              String deString = URLDecoder.decode(paramsStr, "UTF-8");
              Company company = JSON.parseObject(deString, Company.class);
              queryWrapper = QueryGenerator.initQueryWrapper(company, request.getParameterMap());
          }
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }

      //Step.2 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      List<Company> pageList = companyService.list(queryWrapper);
      //导出文件名称
      mv.addObject(NormalExcelConstants.FILE_NAME, "公司信息列表");
      mv.addObject(NormalExcelConstants.CLASS, Company.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("公司信息列表数据", "导出人:Jeecg", "导出信息"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
  }

  /**
      * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          MultipartFile file = entity.getValue();// 获取上传文件对象
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<Company> listCompanys = ExcelImportUtil.importExcel(file.getInputStream(), Company.class, params);
              companyService.saveBatch(listCompanys);
              return Result.ok("文件导入成功！数据行数:" + listCompanys.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.ok("文件导入失败！");
  }

}
