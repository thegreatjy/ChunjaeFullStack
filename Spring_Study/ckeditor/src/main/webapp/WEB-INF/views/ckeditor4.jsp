<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/25/23
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
  <script src="/resources/ckeditor/ckeditor.js"></script>
  <!-- <script src="ckeditor.js"></script> -->
</head>
<body>

<div class="mb-3">
    <form method="post" action="/upload">
    <textarea class="form-control" id="content" name="content" rows="3"></textarea>
    <script>
        var ckeditor_config = {
            width: "100%",
            height:"400px",
            image_previewText: '이건어디에',
            resize_enabled : false,
            enterMode : CKEDITOR.ENTER_BR,
            shiftEnterMode : CKEDITOR.ENTER_P,
            filebrowserUploadUrl : "/food/imageUpload.do"
    };

    CKEDITOR.replace("content", ckeditor_config);

    //이미지 업로드가 끝나고 실행하는 함수
    CKEDITOR.on( 'dialogDefinition', function( ev ) {
        // Take the dialog name and its definition from the event data.
        let dialogName = ev.data.name;
        let dialogDefinition = ev.data.definition;


        let uploadTab = dialogDefinition.getContents( 'Upload' );
        let uploadButton = uploadTab.get('uploadButton');

        uploadButton['filebrowser']['onSelect'] = function( fileUrl, errorMessage ) {

        }

    });
    </script>
    <input type="submit" value="전송">
    </form>
</div>
</body>
</html>
