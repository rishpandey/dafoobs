<%@page import="com.bvp.daafobs.beans.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	session.setAttribute("student_id", "100");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>

	<%
		ArrayList<Subject> arr = (ArrayList<Subject>) request.getAttribute("details");
	%>
	<div>

		<form name="f2" method="post" action="EnterResultController">

			<br> <br> <br>

			<h3>Enter Result</h3>
			<br> <br>

			<table >
				<tr>
					<td>SR No</td>
					<td>SUBJECT NAME</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					
					
					
					<td>CREDIT VALUE</td>
					<td>UE</td>
					<td>IA</td>
					<td>TW&P</td>
					<td>TW&O</td>
					<td>RESULT</td>
					<td>GP</td>
				</tr>
				<%
					for (int i = 0; i < arr.size(); i++) {
				%>
				<tr>
					<td><%=i + 1%></td>
					<%String s=arr.get(i).getSubject1();%>
					
					<td><input type="text" name="subject<%=i + 1%>" value="<%out.println(s); %>" readonly="readonly" style="width: 200%"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td><td></td>
					<td></td>
					<td></td>
					<td></td>
					
					
					<td><input type=text name="a_cv<%=i + 1%>" style="width: 50%"></td>
					<td><input type=text name="a_ue<%=i + 1%>" style="width: 50%"></td>
					<td><input type=text name="a_ia<%=i + 1%>" style="width: 50%"></td>
					<td><input type=text name="a_twp<%=i + 1%>" style="width: 50%"></td>
					<td><input type=text name="a_two<%=i + 1%>" style="width: 50%"></td>
					<td><input type=text name="a_result<%=i + 1%>" style="width: 50%"></td>
					<td><input type=text name="a_gp<%=i + 1%>" style="width: 50%"></td>
				</tr>

				<%
					}
				%>
			</table>



			<br> <br> <input type="submit" value="Enter Details"
				onClick="">

		</form>





	</div>

</body>
</html>