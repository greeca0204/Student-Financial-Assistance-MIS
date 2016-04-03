package com.slg.zxgl.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slg.zxgl.dao.impl.AdminLogDaoImpl;
import com.slg.zxgl.dao.impl.JobDaoImpl;
import com.slg.zxgl.dao.impl.MessageDaoImpl;
import com.slg.zxgl.dao.impl.SchoolInfoDaoImpl;
import com.slg.zxgl.dao.impl.StudentDaoImpl;
import com.slg.zxgl.dao.impl.TeacherDaoImpl;
import com.slg.zxgl.dao.impl.UserDaoImpl;
import com.slg.zxgl.db.AdminLogUtil;
import com.slg.zxgl.entity.AdminLog;
import com.slg.zxgl.entity.ClassInfo;
import com.slg.zxgl.entity.CollegeInfo;
import com.slg.zxgl.entity.GradeInfo;
import com.slg.zxgl.entity.GrantShip;
import com.slg.zxgl.entity.Job;
import com.slg.zxgl.entity.MajorInfo;
import com.slg.zxgl.entity.Manager;
import com.slg.zxgl.entity.Message;
import com.slg.zxgl.entity.PoorStudentInfo;
import com.slg.zxgl.entity.StudentInfo;
import com.slg.zxgl.entity.Teacher;
import com.slg.zxgl.entity.User;

@WebServlet(name = "Manager.SearchServlet", urlPatterns = { "/manager/search.action" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("manager:search.action");
		request.setCharacterEncoding("UTF-8");
		// ��ת
		HttpServletRequest hreq = (HttpServletRequest) request;
		String path = hreq.getContextPath();
		String basePath = hreq.getScheme() + "://" + hreq.getServerName() + ":" + hreq.getServerPort() + path;
		HttpSession session = request.getSession();

		String type = request.getParameter("type");
		System.out.println("��ѯ" + type);
		String res = "search";
		if (type != null) {
			res = res + "_" + type;
		}
		System.out.println("��ѯ" + type);

		String action = request.getParameter("action");
		User user = (User) session.getAttribute("user");

		if ("show".equals(action)) {
			res = res + "_" + action;
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Object show = ((List<?>) session.getAttribute(type + "s")).get(id);
				System.out.println(show);
				session.setAttribute("show", show);
			} catch (Exception e) {
			}
		} else if ("return".equals(action)) {
			res = "search" + "_" + type;
		} else {
			try {
				AdminLogUtil.logAdminOperation(user.getId(), "��ѯ" + type);
			} catch (Exception e) {
			}
			if ("stu".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<StudentInfo> stus = null;
				if (word == null || "".equals(word)) {
					stus = getAllStudents();
				} else {
					stus = getStudentsByWord(word);
				}
				System.out.println(stus);
				session.setAttribute("stus", stus);
			} else if ("log".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<AdminLog> logs = null;
				if (word == null || "".equals(word)) {
					logs = getAllLogs();
				} else {
					logs = getLogsByWord(word);
				}
				System.out.println(logs);
				session.setAttribute("logs", logs);
			} else if ("admin".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<Manager> admins = null;
				if (word == null || "".equals(word)) {
					admins = getAllAdmins();
				} else {
					admins = getAdminsByWord(word);
				}
				System.out.println(admins);
				session.setAttribute("admins", admins);
			} else if ("tea".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<Teacher> teas = null;
				if (word == null || "".equals(word)) {
					teas = getAllTeachers();
				} else {
					teas = getTeachersByWord(word);
				}
				System.out.println(teas);
				session.setAttribute("teas", teas);
			} else if ("info".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<Message> infos = null;
				if (word == null || "".equals(word)) {
					infos = getAllInfos(0);
				} else {
					infos = getInfosByWord(0, word);
				}
				System.out.println(infos);
				session.setAttribute("infos", infos);
			} else if ("college".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<CollegeInfo> colleges = null;
				if (word == null || "".equals(word)) {
					colleges = getAllCollegeInfos();
				} else {
					colleges = getCollegeInfosByWord(word);
				}
				System.out.println(colleges);
				session.setAttribute("colleges", colleges);
			} else if ("class".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<ClassInfo> infos = null;
				if (word == null || "".equals(word)) {
					infos = getClasss();
				} else {
					infos = getClasssByWord(word);
				}
				System.out.println(infos);
				session.setAttribute("classs", infos);
			} else if ("poorstu".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<PoorStudentInfo> poorstus = null;
				if (word == null || "".equals(word)) {
					poorstus = getAllPoorstus();
				} else {
					poorstus = getPoorstusByWord(word);
				}
				System.out.println(poorstus);
				session.setAttribute("poorstus", poorstus);
			} else if ("grantship".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<GrantShip> grantships = null;
				if (word == null || "".equals(word)) {
					grantships = getAllGrantShips();
				} else {
					grantships = getGrantShipsByWord(word);
				}
				System.out.println(grantships);
				session.setAttribute("grantships", grantships);
			} else if ("job".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<Job> jobs = null;
				if (word == null || "".equals(word)) {
					jobs = getAllJobs();
				} else {
					jobs = getJobsByWord(word);
				}
				System.out.println(jobs);
				session.setAttribute("jobs", jobs);

			} else if ("grade".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<GradeInfo> grades = null;
				if (word == null || "".equals(word)) {
					grades = getAllGrades();
				} else {
					grades = getGradesByWord(word);
				}
				System.out.println(grades);
				session.setAttribute("grades", grades);
			} else if ("major".equals(type)) {
				String word = request.getParameter("word");
				System.out.println("�ؼ��֣�" + word);
				List<MajorInfo> majors = null;
				if (word == null || "".equals(word)) {
					majors = getAllMajors();
				} else {
					majors = getMajorsByWord(word);
				}
				System.out.println(majors);
				session.setAttribute("majors", majors);
			}
		}
		System.out.println("��ѯ" + res);
		session.setAttribute("result", res);
		response.sendRedirect(basePath + "/manager.jsp");
	}

	private List<AdminLog> getLogsByWord(String word) {
		return new AdminLogDaoImpl().getLogsByWord(word);
	}

	private List<AdminLog> getAllLogs() {
		return getLogsByWord(null);
	}

	private List<Job> getJobsByWord(String word) {
		return new JobDaoImpl().getJobsByWord(word);
	}

	private List<Job> getAllJobs() {
		return new JobDaoImpl().getAllJobs();
	}

	private List<GrantShip> getGrantShipsByWord(String word) {
		return new SchoolInfoDaoImpl().getGrantShips(word);
	}

	private List<GrantShip> getAllGrantShips() {
		return new SchoolInfoDaoImpl().getGrantShips(null);
	}

	private List<PoorStudentInfo> getPoorstusByWord(String word) {
		return new StudentDaoImpl().getPoorstusByWord(word);
	}

	private List<PoorStudentInfo> getAllPoorstus() {
		return new StudentDaoImpl().getPoorstusByWord(null);
	}

	private List<Manager> getAdminsByWord(String word) {
		return new UserDaoImpl().getAllAdmins(word);
	}

	private List<Manager> getAllAdmins() {
		return new UserDaoImpl().getAllAdmins(null);
	}

	private List<MajorInfo> getMajorsByWord(String word) {
		return new SchoolInfoDaoImpl().getMajors(word);
	}

	private List<MajorInfo> getAllMajors() {
		return new SchoolInfoDaoImpl().getMajors(null);
	}

	private List<GradeInfo> getGradesByWord(String word) {
		return new SchoolInfoDaoImpl().getGrades(word);
	}

	private List<GradeInfo> getAllGrades() {
		return new SchoolInfoDaoImpl().getGrades(null);
	}

	private List<ClassInfo> getClasssByWord(String word) {
		return new SchoolInfoDaoImpl().getClasss(word);
	}

	private List<ClassInfo> getClasss() {
		return new SchoolInfoDaoImpl().getClasss(null);
	}

	private List<CollegeInfo> getCollegeInfosByWord(String word) {
		return new SchoolInfoDaoImpl().getColleges(word);
	}

	private List<CollegeInfo> getAllCollegeInfos() {
		return new SchoolInfoDaoImpl().getColleges(null);
	}

	private List<Message> getInfosByWord(int userType, String word) {
		return new MessageDaoImpl().getMessageByWord(userType, word);
	}

	private List<Message> getAllInfos(int userType) {
		return new MessageDaoImpl().getAllMessages(userType, 0);
	}

	private List<StudentInfo> getStudentsByWord(String word) {
		return new StudentDaoImpl().getStudentsByWord(word);
	}

	private List<StudentInfo> getAllStudents() {
		return new StudentDaoImpl().getAllStudents();
	}

	private List<Teacher> getTeachersByWord(String word) {
		return new TeacherDaoImpl().getTeachersByWord(word);
	}

	private List<Teacher> getAllTeachers() {
		return new TeacherDaoImpl().getTeachersByWord(null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
