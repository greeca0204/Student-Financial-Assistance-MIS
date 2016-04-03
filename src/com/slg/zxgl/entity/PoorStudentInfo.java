package com.slg.zxgl.entity;

public class PoorStudentInfo {
	private Poorinfo poor = null;
	private StudentInfo stu = null;
	public PoorStudentInfo(Poorinfo poor, StudentInfo stu) {
		super();
		this.poor = poor;
		this.stu = stu;
	}
	public String getStuAccname(){
		return stu.getAccname();
	}
	public String getStuName(){
		return stu.getName();
	}
	public String getPoorName(){
		String ret = "����֤";
		switch (poor.getPoorgrade()) {
		case 1:
			ret  = "һ������";
			break;

		case 2:
			ret  = "����";
			break;

		case 3:
			ret  = "�ر�����";
			break;

		default:
			break;
		}
		return ret;
	}
	public String getStuPoliticsStatus(){
		return stu.getPoliticsStatus();
	}
	public String getStuNationality(){
		return stu.getNationality();
	}
	public String getStuGender(){
		if("M".equals(stu.getGender())){
			return "��";
		}
		else{
			return "Ů";
		}
	}
	public String getStuIdentification(){
		return stu.getIdentification();
	}
	public String getStuPhone(){
		return stu.getPhone();
	}
	public String getStuAddress(){
		return stu.getAddress();
	}
	public String getStuClassName(){
		return stu.getClassname();
	}
	public String getStuGradename(){
		return stu.getGradename();
	}
	public String getStuCollegename(){
		return stu.getCollegename();
	}
	public String getStuMajorname(){
		return stu.getMajorname();
	}
	public String getPoorHomePeople(){
		return poor.getHomepeople()+"";
	}
	public String getPoorHomeIncome(){
		return poor.getHomeincome() +"";
	}
	public int getStuId(){
		return stu.getId();
	}
	public int getId(){
		return poor.getId();
	}
	public int getPoorGrade(){
		return poor.getPoorgrade();
	}
}
