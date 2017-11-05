<%@include file="header.jsp"%>
<html>

<body>
	<div id="container">
		<spring:form action="${pageContext.request.contextPath}/book"
			modelAttribute="ticket" id="bookForm"
			onsubmit="return validateForm('bookForm');">
			<table>
				<tr>
					<td>Source</td>
					<td class="date"><spring:select path="source" id="source"
							onclick="selectDest();">
							<spring:option value="select" label="select"></spring:option>
							<spring:options items="${sources}" />
						</spring:select></td>


				</tr>
				<tr>
					<td>Destination</td>
					<td class="date"><spring:select path="destination" id="dest"
							onclick="selectDest();">
							<spring:option value="select">select</spring:option>
							<spring:options items="${destinations}" />
						</spring:select></td>
				</tr>
				<tr>
					<td>Journey Date</td>
					<td class="date"><spring:input  type="date" path="date1"
							id="date" /></td>
					<td ><spring:errors path="date1" cssClass="error"></spring:errors></td>

				</tr>
				<tr>
					<td>Travels</td>
					<td class="date"><spring:select path="travels" id="travels">
							<spring:option value="select" label="select"></spring:option>
							<spring:options items="${travelsList}" />
						</spring:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>