<%@page import="com.bvp.daafobs.DAOImpl.DaafobsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.bvp.daafobs.beans.Subject"%>

<%!int range1 = 0, range2 = 0, range3 = 0, range4 = 0;

String[] array = null;
%>

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
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Grade Point');
		data.addColumn('number', 'Students');
		data.addRows([ [ '1-3',
<%=range1%>
	], [ '4-6',
<%=range2%>
	],
				[ '7-8',
<%=range3%>
	], [ '9-10',
<%=range4%>
	] ]);

		// Set chart options
		var options = {
			'title' : 'Performance Report of Subject',
			'width' : 600,
			'height' : 400
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.BarChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>

</head>
<body>
	<h1>Subject Analysis</h1>
	<form id="SelectSemester" action="SubjectAnalysis.jsp" method="get">
		<select name="semester" onchange="this.form.submit()">
			<option value="<%=request.getParameter("semester") != null && !request.getParameter("semester").isEmpty() ? request.getParameter("semester") : "" %>"><%=request.getParameter("semester") != null && !request.getParameter("semester").isEmpty() ? "Semester " +request.getParameter("semester") : "Select.." %></option>
			<option value="3">Sem 3</option>
			<option value="4">Sem 4</option>
			<option value="5">Sem 5</option>
			<option value="6">Sem 6</option>
			<option value="7">Sem 7</option>
			<option value="8">Sem 8</option>
		</select>
		<form>

			<%
				int i = 0;
				String chosenSub = null;
				DaafobsDAOImpl dao = new DaafobsDAOImpl();
				ArrayList<String> arr = dao.reteriveSubjectBySem(request.getParameter("semester"));
			%>
			<form id="SelectSubject" action="SubjectAnalysis.jsp" method="get">
				<select name="subject" onchange="this.form.submit()">
					<option value="">Select..</option>
					<option />
					<%
						for (String sub : arr) {
					%>
					<option value="<%=++i%>"><%=sub%></option>
					<%
						
						}
					%>
				</select>
			</form>
			<%
				if (request.getParameter("subject") != null && !request.getParameter("subject").isEmpty()) {
					String result = dao.analyzeBySubject(request.getParameter("subject"),
							Integer.parseInt(
									request.getAttribute("semester") == null || (request.getAttribute("semester") != null
											&& request.getAttribute("semester").equals("")) ? "0"
													: (String) request.getAttribute("semester")),
							2017);
					System.out.println(result);
					array = result.split("\\|");

					// get 4 counts for graph
					String[] temp = null;
					range1=0;range2=0;range3=0;range4=0;
							
					for (String aar : array) {
						temp = aar.split(",");
						if (Integer.parseInt(temp[7]) > 0 && Integer.parseInt(temp[7]) < 4)
							range1++;
						else if (Integer.parseInt(temp[7]) > 3 && Integer.parseInt(temp[7]) < 7)
							range2++;
						else if (Integer.parseInt(temp[7]) > 5 && Integer.parseInt(temp[7]) < 9)
							range3++;
						else if (Integer.parseInt(temp[7]) > 8 && Integer.parseInt(temp[7]) < 11)
							range4++;
						
						
					}
					

					System.out.println(range1);
					System.out.println(range2);
					System.out.println(range3);
					System.out.println(range4);
					
					String[][] matrix = new String[array.length][];
					int r = 0;

					for (String row : array) {
						matrix[r++] = row.split(",");
					}
				}
			%>

				<h2><%= array!=null ? array[0].split(",")[0] : ""%></h2>

				<%
					if (request.getParameter("subject") != null && !request.getParameter("subject").isEmpty()) {
				%>
				<div id="chart_div"></div>
				<%
					array = null;
					}
				%>
</body>
</html>


