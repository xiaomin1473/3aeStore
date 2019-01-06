package store.ae.api.mall;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.common.exception.mall.AbsentException;
import store.ae.dto.mall.goods.ListExposer;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsSku;
import store.ae.service.mall.goods.GoodsService;
import store.ae.vo.mall.goods.brand.BrandVo;
import store.ae.vo.mall.goods.category.CategoryVo;

@Controller
@RequestMapping("/goods") // url:/模块/资源/{id}/细分
public class GoodsController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GoodsService goodsService;
	
	private final String ERROR_INFO = "错误信息\n【商品管理】";
	
	@RequestMapping(value = "/category", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public ListExposer<CategoryVo> categorieList(){
		
		ListExposer<CategoryVo> result;
		
		try {
			List<CategoryVo> categoryVoList = goodsService.getCategoryList();

			result = new ListExposer<CategoryVo>(0, "成功", categoryVoList);
		} catch (AbsentException e) {
			logger.error("{} 类目列表获取失败 {}", ERROR_INFO, e.getMessage());
			
			result = new ListExposer<CategoryVo>(-1, "失败");
		}
		
		catch (Exception e) {
			logger.error("{} 系统异常 {}",ERROR_INFO, e.getMessage());
			
			result = new ListExposer<CategoryVo>(-1, "系统异常");
		}
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/category/{categoryType}/{offset}/{limit}", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Goods> goodsListByCategory(@PathVariable("categoryType") Long categoryType,
										   @PathVariable("offset") int offset,
										   @PathVariable("limit") int limit) {
		// 获取列表json

		return goodsService.getGoodsListByCategory(categoryType, offset, limit);
	}
	
	@RequestMapping(value = "/brand", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public ListExposer<BrandVo> brandList() {
		ListExposer<BrandVo> result;
		 
		try {
			List<BrandVo> brandVoList = goodsService.getBrandList();
			
			result = new ListExposer<BrandVo>(0, "成功", brandVoList);
		} catch (Exception e) {
			logger.error("{} 系统异常 {}",ERROR_INFO, e.getMessage());
			
			result = new ListExposer<>(-1, "程序异常");
		}
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/brand/{brandId}/{offset}/{limit}", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Goods> goodsListByBrand(@PathVariable("brandId") Long brandId,
										   @PathVariable("offset") int offset,
										   @PathVariable("limit") int limit) {
		// 获取列表json

		return goodsService.getGoodsListByBrandId(brandId, offset, limit);
	}
	
	
	@RequestMapping(value = "/detail/{goodsId}", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Goods goodsDetail(@PathVariable("goodsId") Long goodsId) {

		// 获取列表json

		return goodsService.getGoodsDetailById(goodsId);
	}
	
	@RequestMapping(value = "/detail/{goodsId}/{goodsSkuId}", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public GoodsSku goodsSku(@PathVariable("goodsId") Long goodsId,
											 @PathVariable("goodsSkuId") Long goodsSkuId) {

		// 获取列表json

		return goodsService.getGoodsSkuById(goodsSkuId);
	}
	
	
	@RequestMapping(value = "/evaluate/{goodsId}", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<GoodsEvaluate> goodsEvaluate(@PathVariable("goodsId") Long goodsId) {
		// 获取列表json

		return goodsService.getGoodsEvaluateById(goodsId);
	}
}
