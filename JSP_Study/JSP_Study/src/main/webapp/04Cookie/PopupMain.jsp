<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/9/23
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String popupMode = "on";  // 팝업창 노출 여부
%>
<html>
<head>
    <title>popup with no cookie</title>
  <style>
      div#popup{
          position: absolute;
          top: 100px;
          left: 50px;
          color: yellow;
          width: 270px;
          height: 100px;
          background-color: gray;
      }
      div#popup>div{
          background-color: #ffffff;
          top: 0px;
          border: 1px solid gray;
          padding: 10px;
          color: black;
      }

      .algcenter{
          text-align: center;
      }
  </style>

    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script>
        /* closeBtn 버튼을 누르면 popup을 숨기게 한다. */
        $(function(){
            $('#closeBtn').click(function(){
                $('#popup').hide();
            })
        });
    </script>
</head>
<body>
    <%
        for(int i=1; i<=10; i++){
            out.print("현재 팝업창은 "+popupMode+ " 상태입니다. <br>");
        }

        if(popupMode.equals("on")){
    %>

    <!-- 팝업창 화면 -->
    <div id="popup">
        <h2 class="algcenter">공지사항 팝업입니다.</h2>
        <div class="algcenter">
            <form name="popfrm">
                <input type="checkbox" id="inactiveToday" value="1"/>
                하루동안 열지 않음
                <input type="button" id="closeBtn" value="닫기"/>
            </form>
        </div>
    </div>

    <%
        }
    %>
</body>
</html>
