<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String popupMode = "on";

  Cookie[] cookies = request.getCookies();
  if(cookies != null){
    for(Cookie c: cookies){
      String cookieName = c.getName();
      String cookieValue = c.getValue();

      if(cookieName.equals("PopupClose")){
        popupMode = cookieValue;
      }
    }
  }
%>
<html>
<head>
  <title>popup with cookie</title>
  <style>
    div#popup{
      position: absolute;
      top: 100px;
      left: 50px;
      width: 270px;
      height: 100px;
      background-color: rgb(128,128,128);
      color: white; /* 팝업 글자색 */
    }
    div#popup>div{
      background-color: #ffffff;
      top: 0px;
      border: 1px solid rgb(128,128,128);
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

        // input 태그 checkbox 타입 id="inactiveToday" checked 설정되어 있는 요소
        // 해당 요소의 값을 읽어오기: val()
        var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();

        // ajax는 비동기 http 요청을 보내는 jquery 함수

        if(chkVal == 1){
          $.ajax({
            url: './PopupCookie.jsp', // 요청을 보낼 페이지 url
            type: 'get', // http 메서드
            data: {inactiveToday : chkVal}, // 서버로 보낼 데이터
            dataType: "text", // 서버로부터 받을 response 데이터 타입
            success: function(resData){ // 요청 성공 시, 실행할 콜백 함수
              if(resData != '') // 응답 메세지가 있다면
                location.reload(); // 페이지 새로고침
            }
          });
        }
      });
    });
  </script>
</head>
<body>
<h2>팝업 메인 페이지 </h2>
<%
  for(int i=1; i<=10; i++){
    out.print("현재 팝업창은 " + popupMode + " 상태입니다.<br>");
  }

  if(popupMode.equals("on")){
%>

<!-- 팝업창 화면 -->
<div id="popup">
  <h2 class="algcenter">공지사항 팝업입니다.</h2>
  <div class="algcenter">
    <form name="popfrm">
      <input type="checkbox" id="inactiveToday" value="1">
      하루동안 열지 않음
      <input type="button" id="closeBtn" value="닫기">
    </form>
  </div>
</div>

<%
  }
%>

</body>
</html>