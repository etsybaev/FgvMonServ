

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Import/export files</title>
</head>
<body>
    <form id="fileuploadForm" action="/importexport/fileupload" method="POST" enctype="multipart/form-data">
        <label for="file">File</label>
        <input id="file" type="file" name="file" />
        <p><button type="submit">Upload</button></p>
    </form>


    <p><a href="/importexport/download">Download</a></p>

</body>
</html>
