<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bvp.daafobs.DAOImpl.DaafobsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.bvp.daafobs.beans.Subject"%>

<%
	if (request.getParameter("semester") != null && !request.getParameter("semester").equals("")) {
		request.setAttribute("semester", request.getParameter("semester"));
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.bundle.js"></script>
</head>
<body>
	<h1>Yearly Analysis</h1>
	<form action="YearAnalysis.jsp" method="get" id="SelectYear">
		From Year:<br> <input type="text" name="startYear" value=""><br>
		To Year:<br> <input type="text" name="endYear" value=""><br>
		<br> <input type="submit" value="Submit">
	</form>

	<%
		if (!request.getParameter("startYear").isEmpty()) {
			int i = 0;
			DaafobsDAOImpl dao = new DaafobsDAOImpl();
			String result = dao.analyzeByYear(request.getParameter("startYear"), request.getParameter("endYear"));
			String[] array = result.split("..");
			
		}
	%>

	<h3>
		Analysis String :
		<%="<br>"%>

		<%
			i = 1;

			for (String subject : subjects) {
				out.println(subject + " : ");
				for (int q = 0; avg.length > 1 && q < avg[i - 1] * 2; q++) {
					out.println("*");
				}
				i++;
				out.println("<br>");
			}
		%>
	</h3>
</body>
</html>


