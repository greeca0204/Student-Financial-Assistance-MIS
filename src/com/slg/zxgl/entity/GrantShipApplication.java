package com.slg.zxgl.entity;

public class GrantShipApplication {
	private ApplicationInfo app;
	private GrantShip ship;
	private StudentInfo stu;
	private Poorinfo poor;
	
	public GrantShipApplication(ApplicationInfo app, GrantShip ship, StudentInfo stu, Poorinfo poor) {
		super();
		this.app = app;
		this.ship = ship;
		this.stu = stu;
		this.setPoor(poor);
	}

	public String getAppName() {
		return app.getName();
	}

	public String getStuName() {
		return stu.getName();
	}

	public String getStuAccname(){
		return stu.getAccname();
	}
	public boolean isCheck(){
		if(app.getCheck()==0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public String getStatus() {
		if (app.getCheck() == 1) {
			return "���ͨ��";
		} else if (app.getCheck() == 2) {
			return "���δͨ��";
		}
		return "δ���";
	}

	public String getStuGender(){
		if("M".equals(stu.getGender())){
			return "��";
		}else{
			return "Ů";
		}
	}
	public String getStuPhone(){
		return stu.getPhone();
	}
	public String getStuCollegename(){
		return stu.getCollegename();
	}
	public String getStuGradename(){
		return stu.getGradename();
	}
	public String getStuMajorname(){
		return stu.getMajorname();
	}
	public String getShipName(){
		return app.getName();
	}
	public String getShipNumber(){
		
		return ship.getNumber();
	}
	public String getShipMoney(){
		return ship.getMoney()+"Ԫ";
	}
	public String getShipStype(){
		return ship.getStype();
	}
	public String getShipRequest(){
		return ship.getRequest();
	}
	public int getAppId(){
		return app.getId();
	}
	public String getStuClassName(){
		stu.getCollegename();
		stu.getGradename();
		stu.getMajorname();
		return stu.getClassname();
	}
	public String getStuAddress(){
		return stu.getAddress();
	}
	public String getStuIdentification(){
		return stu.getIdentification();
	}
	public String getStuNationality(){
		return stu.getNationality();
	}
	public String getStuPoliticsStatus(){
		stu.getNationality();
		return stu.getPoliticsStatus();
	}
	public int getShipId(){
		return app.getId();
	}

	public Poorinfo getPoor() {
		return poor;
	}

	public void setPoor(Poorinfo poor) {
		this.poor = poor;
	}
}
