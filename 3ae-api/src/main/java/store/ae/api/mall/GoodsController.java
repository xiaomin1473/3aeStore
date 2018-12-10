package store.ae.api.mall;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.pojo.mall.goods.Category;
import store.ae.service.mall.goods.GoodsService;

@Controller
@RequestMapping("/goods") // url:/模块/资源/{id}/细分
public class GoodsController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/category", 
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Category> list() {
		// 获取列表json
		List<Category> categories = goodsService.getCategory();
		
		return categories;
	}
}
