package store.ae.service.mall.goods;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.ae.dao.mall.goods.GoodsDao;
import store.ae.pojo.mall.goods.Category;
import store.ae.pojo.mall.goods.Goods;

@Service
public class GoodsServiceImpl implements GoodsService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GoodsDao goodsDao;
	




	@Override
	public Goods getGoodsById(long GoodsId) {
		long goodsId = 1000L;
		
		Goods iphone = goodsDao.queryById(goodsId);
		
		
		return null;
	}





	@Override
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	

}