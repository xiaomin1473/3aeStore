package store.ae.vo.mall.goods.category;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class SeriesVo {
	@SerializedName("name")
	private String categoryName;
	
	@SerializedName("type")
	private Long categoryType;

	@SerializedName("child")
	List<GradeVo> GradeVoList;
}
