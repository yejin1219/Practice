<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="servlet.model.MemberVO" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
</head>
<body>
<%
 String password = request.getParameter("password"); 
  List<MemberVO> list = (List)request.getAttribute("list");

%>
    <div class="container">
        <h2>내 정보 조회</h2>
        <form action="search">
            <input type="password" name="password"><input type="submit" value="조회">
        </form>

        <hr>

        <h2>Free Pet's 명단 리스트</h2>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>PASSWORD</th>
                <th>NAME</th>
                <th>NICKNAME</th>
                <th>GENDER</th>
            </tr>
            
     
            <% 
            if(list!=null){
            for(int i =0; i<list.size(); i++){%>
            	
            <tr>
               <td><%=list.get(i).getId() %></td>
               <td><%=list.get(i).getPassword() %></td>
               <td><%=list.get(i).getName() %></td>
               <td><%=list.get(i).getNickname() %></td>
               <td><%=list.get(i).getGender() %></td>
            </tr>
            <%
            } }
            %>
            
        </table>
    </div>

</body>
</html>