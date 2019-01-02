package store.ae.service.mall.goods;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.mall.goods.Goods;
import store.ae.vo.mall.goods.category.CategoryVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/mall/config/mall-dao.xml",
	"classpath:store/ae/service/mall/config/mall-service.xml"})
public class GoodsServiceTest {
	
	@Autowired
	private GoodsService goodsService;

	@Test
	public void testGetCategoryList() {
		List<CategoryVo> categories = goodsService.getCategoryList();
		
		Assert.assertTrue(categories != null);
	}

	@Test
	public void testGetGoodsListByCategory() {
		long categoryType = 1010101;
		int offset = 0;
		int limit = 10;
		List<Goods> goods = goodsService.getGoodsListByCategory(categoryType, offset, limit);

		Assert.assertTrue(goods != null);
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
