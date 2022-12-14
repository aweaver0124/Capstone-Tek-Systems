<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container-account" id="myAccount" items="${user}">
    <div id="user-flex">
        <div id="user-info">
            <div>
                <h1>Hello, ${user.firstName}!</h1>
                <br>
                <h2>Your Information</h2>
                <br>
                <h3>Signed in as:</h3>
                <p>${user.username}</p>
                <br>
                <h3>First Name:</h3>
                <p>${user.firstName}</p>
                <br>
                <h3>Last Name:</h3>
                <p>${user.lastName}</p>
                <br>
                <h3>State:</h3>
                <p>${user.state}</p>
            </div>
            <div id="edit-button">
                <a href="/editUser"><button class="hvr-ripple-out">Edit</button></a>
            </div>
            
            <div id="decoration">
                <img src="../../pub/images/popart-laying-dogs.webp" alt="popart pets" height="200px" width="300px">
                <img src="../../pub/images/popart-laying-cat.png" alt="popart pets" height="100px" width="200px"> 
            </div>
        </div>
       
    </div>

    <div id="pets-hyperlink">
        <h2>Your Pets</h2>
        <c:forEach items="${user.pets}" var="pet">
            <a href="/petcard?id=${pet.id}"><h3>${pet.name}</h3></a>
        </c:forEach>
    </div>
</div>




<jsp:include page="include/footer.jsp" /> 