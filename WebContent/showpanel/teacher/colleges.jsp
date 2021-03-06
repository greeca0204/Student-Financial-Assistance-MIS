<%@page import="com.slg.zxgl.entity.CollegeInfo"%>
<%@page import="com.slg.zxgl.entity.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center" style="margin-top: 10px">
	<%
		List<CollegeInfo> colleges = (List<CollegeInfo>) session.getAttribute("colleges");
		int pageNumber = 1;
		try {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		} catch (Exception e) {
		}
		int allpages = colleges != null ? (colleges.size() / 10 + ((colleges.size() % 10 == 0) ? 0 : 1)) : 0;
		if (pageNumber > allpages) {
			pageNumber = allpages;
		}
	%>
	<table width="95%">
		<tr align="center" height="25px">
			<th colspan="4">学院信息</th>
		</tr>
		<tr align="center" height="25px">
			<td colspan="1"></td>
			<td colspan="2" align="right"><form
					action="teacher/search.action" method="post">
					<input type="hidden" name="type" value="college" /> <input
						type="search" name="word" /><input type="submit" value="搜索" />
				</form></td>
		</tr>
		<tr align="center" height="25px">
			<td width="10%">序号</td>
			<td width="60%">学院名称</td>
			<td width="30%">学院简称</td>
		</tr>
		<%
			if (colleges != null) {

				for (int i = 0; i < 10; i++) {
					int idx = i + 10 * (pageNumber - 1);
					if (idx >=  colleges.size()) {
						break;
					}
					 CollegeInfo co =  colleges.get(idx);
		%><tr align="center" height="25px">
			<td width="10%"><%=i + 1%></td>
			<td width="30%"><a
				href="teacher/show.action?type=college&id=<%=idx%>"><%=co.getName()%></a></td>
			<td width="30%"><%=co.getShortname()%></td>
		</tr>
		<%
			}
		%><tr>
			<td colspan="5" align="right"><a
				href="teacher.jsp?pageNumber=<%=pageNumber - 1%>"><input
					value="上一页 " type="button" <%if (pageNumber <= 1) {%>
					disabled="disabled" <%}%> /></a>|<input type="text"
				value="<%=pageNumber%>/<%=allpages%>" size="2"
				style="text-align: center" disabled="disabled" /> |<a
				href="teacher.jsp?pageNumber=<%=pageNumber + 1%>"><input
					value="下一页 " <%if (pageNumber >= allpages) {%> disabled="disabled"
					<%}%> type="button" /></a></td>
		</tr>
		<%
			} else {
		%><tr align="center" height="25px">
			<th colspan="4">无学院信息</th>
		</tr>
		<%
			}
		%>
	</table>
</div>