package store.ae.vo.mall.goods;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import store.ae.vo.mall.goods.category.GradeVo;

@Data
public class CategoryList {
	
	@SerializedName("name")
	private String categoryName;
	
	@SerializedName("type")
	private long categoryType;
	
	@SerializedName("child")
	List<GradeVo> gradeVoList;
}
