package store.ae.api.mall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.pojo.mall.goods.Brand;
import store.ae.pojo.mall.goods.Category;
import store.ae.pojo.mall.goods.Goods;
import store.ae.pojo.mall.goods.GoodsEvaluate;
import store.ae.pojo.mall.goods.GoodsSku;
import store.ae.service.mall.goods.GoodsService;

@Controller
@RequestMapping("/goods") // url:/模块/资源/{id}/细分
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/category", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Category> categorieList() {

		return goodsService.getCategoryList();
	}
	
	@RequestMapping(value = "/list/{category}/{offset}/{limit}", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Goods> goodsListByCategory(@PathVariable("category") Long category,
										   @PathVariable("offset") int offset,
										   @PathVariable("limit") int limit) {
		// 获取列表json

		return goodsService.getGoodsListByCategory(category, offset, limit);
	}
	
	@RequestMapping(value = "/brand", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Brand> brandList() {
		// 获取列表json

		return goodsService.getBrandList();
	}
	
	
	
	@RequestMapping(value = "/list/{brandId}/{offset}/{limit}", 
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
