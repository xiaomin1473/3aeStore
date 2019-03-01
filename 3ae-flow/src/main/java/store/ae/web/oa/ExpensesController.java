package store.ae.web.oa;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import store.ae.pojo.oa.Apply;
import store.ae.pojo.oa.Payment;
import store.ae.pojo.oa.Verify;
import store.ae.service.oa.ExpensesService;

@Controller
@RequestMapping("/expenses")
public class ExpensesController extends BaseController {
	
	@Autowired
	private ExpensesService expensesService;
	
	
	@RequestMapping(value = "/apply/list",
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Apply> applyList(){
		
		List<Apply> lists = expensesService.getApplyList();
		
		return lists;
	}
	
	
	@RequestMapping(value = "/apply/add",
			method = RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addApply(@RequestParam Map<String, String> params) throws UnsupportedEncodingException{
		
		String sss = URLDecoder.decode(params.get("classType"), "UTF-8");
		System.out.println(sss);
		
		return "添加成功";
	}
	
	
	
	@RequestMapping(value = "/verify/list",
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Verify> verifyList(){
		
		List<Verify> lists = expensesService.getVerifyList();
		
		return lists;
	}
	
	@RequestMapping(value = "/payment/list",
			method = RequestMethod.GET,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Payment> paymentList(){
		
		List<Payment> lists = expensesService.getPaymentList();
		
		return lists;
	}
}