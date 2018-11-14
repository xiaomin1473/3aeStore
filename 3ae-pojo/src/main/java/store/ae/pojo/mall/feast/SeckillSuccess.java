package store.ae.pojo.mall.feast;

import java.util.Date;

public class SeckillSuccess {
	private long seckillId;
	
	private long userPhone;
	
	private short state;
	
	private Date gmtCreate;
	
	// 多对一
	private Seckill seckill;
	

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SeckillSuccess [seckillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", gmtCreate=" + gmtCreate + "]";
	}
	
	
}
