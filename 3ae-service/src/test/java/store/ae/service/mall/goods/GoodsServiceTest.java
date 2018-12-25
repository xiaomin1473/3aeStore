package store.ae.service.mall.goods;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.mall.goods.Goods;
import store.ae.vo.mall.goods.CategoryList;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/mall/config/mall-dao.xml",
	"classpath:store/ae/service/mall/config/mall-service.xml"})
public class GoodsServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GoodsService goodsService;

	@Test
	public void testGetCategoryList() {
		List<CategoryList> categories = goodsService.getCategoryList();
		
		logger.info("分类列表如下: \n" + categories);
	}

	@Test
	public void testGetGoodsListByCategory() {
		long categoryType = 1010101;
		int offset = 0;
		int limit = 10;
		List<Goods> goods = goodsService.getGoodsListByCategory(categoryType, offset, limit);
		logger.info("根据分类查询商品列表如下: \n" + goods);
	}

	@Test
	public void testGetBrandList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsListByBrandId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsDetailById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllGoodsSkuById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsSkuById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGoodsEvaluateById() {
		fail("Not yet implemented");
	}

}
