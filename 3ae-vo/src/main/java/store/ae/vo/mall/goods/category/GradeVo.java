package store.ae.vo.mall.goods.category;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class GradeVo {
	@SerializedName("name")
	private String categoryName;
	
	@SerializedName("type")
	private long categoryType;

	@SerializedName("child")
	List<CategoryVo> categoryVoList;
}
