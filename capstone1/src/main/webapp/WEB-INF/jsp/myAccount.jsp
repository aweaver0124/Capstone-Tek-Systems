<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container" id="myAccount" items="${user}">
    <h1>Hello, ${user.firstName}!</h1>
    <div>
        <h2>Your Information</h2>
        <p><strong>Signed in as: </strong> ${user.username}</p>
        <br>
        <p><strong>First Name: </strong> ${user.firstName}</p>
        <br>
        <p><strong>Last Name: </strong> ${user.lastName}</p>
        <br>
        <p><strong>State: </strong> ${user.state}</p>
    </div>
    <div>
        <h2>Your Pets</h2>
        <c:forEach items="${user.pets}" var="pet">
            <a href="/petcard?id=${pet.id}"><h3>${pet.name}</h3></a>
        </c:forEach>
    </div>
</div>




<jsp:include page="include/footer.jsp" /> 