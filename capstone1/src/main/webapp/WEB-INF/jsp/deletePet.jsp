<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container">
    <div id="removed" items="${petToRemove}">
        <h1>Successfully Removed ${petToRemove.name}</h1>
    </div>
</div>



<jsp:include page="include/footer.jsp" /> 