<%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/3/28
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = "" >
    请输入起始整数：<input type = "text" value = "1" name="v1"><br>
    请输入终止整数：<input type = "text" value = "50" name="v2">
    <input type="submit" value="显示结果" name = "submit">
</form>
<%
    String a = request.getParameter("v1");
    String b = request.getParameter("v2");
    int c;
    if(a!=null){
        c=Integer.parseInt(a);
    }else
        c=0;
    int d;
    if(a!=null){
        d=Integer.parseInt(b);
    }else
        d=0;
    int i,j=0;
    for(i = c;i < d;i++){
        for(j = 2;j < i;j++){
            if(i % j == 0){
                break;
            }
        }
        if(j == i){
            out.print(i + "\t");
        }
    }
%>
</body>
</html>
