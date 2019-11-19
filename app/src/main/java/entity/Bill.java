package entity;
//订单类

import java.util.Date;

public class Bill {

	private int id;
	//订单用户的个人信息
	private int user_id;
	//订单回收员的信息
	private int collector_id;
	//下单的地址
	private String Bill_address;
	//手机号码
	private  String phone;
	//订单现在的状态
	private String state;
	//订单的价格
	private String price;
	//订单的下单时间
	private Date date;
	//订单最后回收到那个回收站总部
	private String headquarters;
	//订单是否被总部收取
	private Boolean Whether_recovery;
	//订单是否被下单处理，并返款给客户
	private Boolean returnMonenyforcustomer;
	//订单返回给客户的钱
	private Double price_forcustomer;
	//备注信息
	private String messageString;
	
	

	//构造方法（无参数）
	public Bill() {
		super();
		
	}

	//构造方法（有参数）


	public Bill(int id, int user_id, int collector_id, String bill_address, String phone, String state, String price,
			Date date, String headquarters, Boolean whether_recovery, Boolean returnMonenyforcustomer,
			Double price_forcustomer, String messageString) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.collector_id = collector_id;
		Bill_address = bill_address;
		this.phone = phone;
		this.state = state;
		this.price = price;
		this.date = date;
		this.headquarters = headquarters;
		Whether_recovery = whether_recovery;
		this.returnMonenyforcustomer = returnMonenyforcustomer;
		this.price_forcustomer = price_forcustomer;
		this.messageString = messageString;
	}

	public Bill(int id, int user_id, int collector_id, String bill_address, String phone, String state, String price, Date date, String headquarters, Boolean whether_recovery, Boolean returnMonenyforcustomer, Double price_forcustomer) {
		this.id = id;
		this.user_id = user_id;
		this.collector_id = collector_id;
		Bill_address = bill_address;
		this.phone = phone;
		this.state = state;
		this.price = price;
		this.date = date;
		this.headquarters = headquarters;
		Whether_recovery = whether_recovery;
		this.returnMonenyforcustomer = returnMonenyforcustomer;
		this.price_forcustomer = price_forcustomer;
	}

	public Bill(int user_id, String bill_address, String phone, String state, String price, Date date,
				String headquarters, Boolean whether_recovery, Boolean returnMonenyforcustomer) {
		super();
		this.user_id = user_id;
		Bill_address = bill_address;
		this.phone = phone;
		this.state = state;
		this.price = price;
		this.date = date;
		this.headquarters = headquarters;
		Whether_recovery = whether_recovery;
		this.returnMonenyforcustomer = returnMonenyforcustomer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCollector_id() {
		return collector_id;
	}

	public void setCollector_id(int collector_id) {
		this.collector_id = collector_id;
	}

	public String getBill_address() {
		return Bill_address;
	}

	public void setBill_address(String bill_address) {
		Bill_address = bill_address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public Boolean getWhether_recovery() {
		return Whether_recovery;
	}

	public void setWhether_recovery(Boolean whether_recovery) {
		Whether_recovery = whether_recovery;
	}

	public Boolean getReturnMonenyforcustomer() {
		return returnMonenyforcustomer;
	}

	public void setReturnMonenyforcustomer(Boolean returnMonenyforcustomer) {
		this.returnMonenyforcustomer = returnMonenyforcustomer;
	}

	public Double getPrice_forcustomer() {
		return price_forcustomer;
	}

	public void setPrice_forcustomer(Double price_forcustomer) {
		this.price_forcustomer = price_forcustomer;
	}

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	
	
}
