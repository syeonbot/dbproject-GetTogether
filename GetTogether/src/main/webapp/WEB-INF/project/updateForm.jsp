<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 수정</title>
<link rel=stylesheet href="<c:url value='/css/common.css'/>" type="text/css">
<link rel=stylesheet href="<c:url value='/css/project.css'/>" type="text/css">
<%@ include file="/WEB-INF/components/nav.jsp" %>
</head>
<body onload='javascript:test();'>
<script>
const goProjectDetail = () => {
    location.href="/GetTogether/project/detail?pid=${project.pid}";
}


</script>

<div>
<form method="POST" action="<c:url value='/project/update' /> ">
	<input type="hidden" name ="pid" value="${project.pid}">
		<table style="margin-top: 2%;">
			<tr><th>프로젝트 수정</th><th></th></tr>
			<tr>
				<td id="element">프로젝트 제목</td>
				<td id="content"><input type="text" name ="title" value="${project.title}" required></td>
			</tr>
			<tr>
				<td id="element">부제목</td>
				<td id="content"><input type="text" name = "subtitle" value="${project.subtitle}" required></td>
			</tr>
			<tr>
				<td id="element">수행기간</td>
				<td id="content">
				<input type="date" name = "executionStart" size="17" value="${project.executionStart}" required> ~ <input type="date" name = "executionEnd" size="17" value="${project.executionEnd}"required>
				</td>
			</tr>
			<tr>
				<td id="element">모집기간</td>
				<td id="content">
				<input type="date" name = "applicationStart" size="17" value="${project.applicationStart}"required> ~ <input type="date" name="applicationEnd" size="17" value="${project.applicationEnd}"required>
				</td>
			</tr>
			<tr>
				<td id="element">모집인원</td>
				<td id="content"><input type="text" style="width: 30px;" name="applicationNum" value="${project.applicationNum}"required>명
				</td>
			</tr>
			<tr>
				<td id="element">기술 분야</td>
				<td id="content"><select name="field"required>
						<option value="" selected>분야 선택</option>
						<option value="IoT">IoT</option>
						<option value="모바일">모바일</option>
						<option value="데스크톱 SW">데스크톱 SW</option>
						<option value="인공지능">인공지능</option>
						<option value="보안">보안</option>
						<option value="가상현실">가상현실</option>
						<option value="빅데이터">빅데이터</option>
						<option value="자동제어기술">자동제어기술</option>
						<option value="블록체인">블록체인</option>
						<option value="영상처리">영상처리</option>
						<option value="웹">웹</option>
						<option value="기타">기타</option>
				</select>
						
						</td>
			</tr>
			<tr>
				<td id="element">목표</td>
				<td id="content"><input type="text" name="goal" value="${project.goal}"required></td>
			</tr>
			<tr>
				<td id="element" style="height: 100px;">프로젝트 개요</td>
				<td><textarea rows="10" style="width: 99%;" name="description" required>${project.description}</textarea></td>
			</tr>
			<tr>
				<td id="element" style="height: 70px;">필요 기술</td>
				<td id="content">
				<input type="checkbox" name="language" value="기타" checked > 기타
					<input type="checkbox" name="language" value="C" > C
					<input type="checkbox" name="language" value="C++"> C++
					<input type="checkbox" name="language"value="C#"> C#
					<input type="checkbox" name="language" value="Java"> Java
					<input type="checkbox" name="language" value="JavaScript"> JavaScript
					<input type="checkbox" name="language" value="Python"> Python
					<input type="checkbox" name="language" value="Visual Basic"> Visual Basic
					<input type="checkbox" name="language" value="PHP"> PHP
					<!-- <br /> -->
					<input type="checkbox" name="language" value="SQL"> SQL
					<input type="checkbox" name="language" value="CSS"> CSS
					<input type="checkbox" name="language" value="HTML"> HTML
					<input type="checkbox" name="language" value="R"> R
					
				</td>
			</tr>
			<tr>
				<td id="btn" style="background-color: #F6F8ED;"></td>
				<td  id="content" style="text-align: right; border: 0;background-color: #F6F8ED;">
					<input class="submit" style = "cursor:pointer" name="save" value="저장" type="submit">
					<input class="reset" style = "cursor:pointer" type="button" name="cancel" value="취소" onClick="goProjectDetail();"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>