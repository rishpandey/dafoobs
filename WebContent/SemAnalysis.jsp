<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bvp.daafobs.DAOImpl.DaafobsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.bvp.daafobs.beans.Subject"%>

<%!ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> subjects = new ArrayList<String>();
	String[] array = null;
	double[] avg = null;%>

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
	src="https://www.gstatic.com/charts/loader.js"></script>

<%
			int i = 0;
			DaafobsDAOImpl dao = new DaafobsDAOImpl();
			String result = dao.analyzeBySemester(Integer.parseInt(request.getAttribute("semester") == null
					|| (request.getAttribute("semester") != null && request.getAttribute("semester").equals("")) ? "0"
							: (String) request.getAttribute("semester")));
			//		System.out.println(result);
			array = result.split(",");

			for (i = 0; i < array.length; i++)
				System.out.print(i + " : " + array[i] + " / ");

			System.out.println();

			for (i = 7; i <= array.length; i += 8) {
				System.out.print(i + " ");
				list.add(array[i]);
			}

			int numOfRecords = 0;
			System.out.println();
			avg = new double[list.size()];

			int j;
			for (i = 1, j = 1; i <= list.size(); i++, j++) {
				if (j > 7)
					j = 1;
				if (j % 7 == 0) {
					avg[6] += Integer.parseInt(list.get(i - 1));
					numOfRecords++;
					System.out.print("7 ");
				} else if (j % 6 == 0) {
					avg[5] += Integer.parseInt(list.get(i - 1));
					System.out.print("6 ");
				} else if (j % 5 == 0) {
					avg[4] += Integer.parseInt(list.get(i - 1));
					System.out.print("5 ");
				} else if (j % 4 == 0) {
					avg[3] += Integer.parseInt(list.get(i - 1));
					System.out.print("4 ");
				} else if (j % 3 == 0) {
					avg[2] += Integer.parseInt(list.get(i - 1));
					System.out.print("3 ");
				} else if (j % 2 == 0) {
					avg[1] += Integer.parseInt(list.get(i - 1));
					System.out.print("2 ");
				} else {
					avg[0] += Integer.parseInt(list.get(i - 1));
					System.out.print("1 ");
				}
			}

			for (i = 0; i < avg.length; i++)
				avg[i] = avg[i] / numOfRecords;

			System.out.println(list);
			System.out.println(Arrays.toString(avg));

			if (numOfRecords != 0)
				for (i = 0; i <= (array.length / numOfRecords) - 1; i += 8) {
					System.out.print(i + " ");
					subjects.add(array[i]);
				}
		%>

<script type="text/javascript">
	google.charts.load('current', {
		packages : [ 'corechart', 'bar' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {

		// Create the data table.
		console.log("here!");
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Grade Point');
		data.addColumn('number', 'Students');
		
		<%if (request.getParameter("semester") != null && !request.getParameter("semester").isEmpty() && avg.length>0) {%>
		data.addRows([ [ '<%=subjects.get(0)%>',<%= avg[0]%>], [ '<%=subjects.get(1)%>',<%= avg[1]%>],[ '<%=subjects.get(2)%>',<%= avg[2]%>], [ '<%=subjects.get(3)%>',<%= avg[3]%>], [ '<%=subjects.get(4)%>',<%= avg[4]%>], [ '<%=subjects.get(5)%>',<%= avg[5]%>], [ '<%=subjects.get(6)%>',<%= avg[6]%>] ]);
		<%}%>
	// Set chart options
		var options = {
			'title' : 'Performance Report of Semester <%= request.getParameter("semester") %>',
			'width' : 800,
			'height' : 600
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.BarChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
		google.visualization.events.addListener(chart, 'select', selectHandler); 

	    function selectHandler(e)     {   
	        var response = window.confirm("Go to Analysis : "+data.getValue(chart.getSelection()[0].row, 0));
	    	if(response == true){
	    		window.location.href = "SubjectAnalysis.jsp?semester=<%=request.getParameter("semester")%>&subject="+ chart.getSelection()[0].row;
	    	}
	    }
	}
</script>

</head>
<body>
	<h1>Subject Analysis</h1>
	<form id="SelectSemester" action="SemAnalysis.jsp" method="get">
		<select name="semester" onchange="this.form.submit()">
			<option value="">Select ..</option>
			<option value="3">Sem 3</option>
			<option value="4">Sem 4</option>
			<option value="5">Sem 5</option>
			<option value="6">Sem 6</option>
			<option value="7">Sem 7</option>
			<option value="8">Sem 8</option>
		</select>


		

<%if (request.getParameter("semester") != null && !request.getParameter("semester").isEmpty() && avg.length>0) {%>
		
		<div id="chart_div"></div>
<%} %>
		<%-- 	
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
			%> --%>
		</h3>
</body>
</html>


