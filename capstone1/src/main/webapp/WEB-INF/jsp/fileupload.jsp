<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" /> 

    <form method="POST" action="/fileuploadsubmit" enctype="multipart/form-data">
        <table>
            <tr>
                <td><form:label path="file">Select a file to upload</form:label></td>
                <td><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
    
 <jsp:include page="include/footer.jsp" /> 