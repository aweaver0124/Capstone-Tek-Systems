<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container" items="${user}">
    <div id="hello">
        <h1>Welcome, ${user.firstName}!</h1>
    </div>
    <h2 id="title">Your Pets</h2>
    <div id="pet-thumbnail-container" class="fade-in">
            <c:forEach items="${pets}" var="pet">
                <a href="/petcard?id=${pet.id}">
                    <div class="hvr-shadow-radial">
                        <img src="${pet.image}" alt="${pet.name}" height="300px" width="300px">
                        <h3>${pet.name}</h3>
                        <p>Click for Details</p>
                    </div>
                </a>
            </c:forEach>
    </div>
    <img id="popart" src="../../pub/images/popart-dogandcat.webp" alt="dog and cat" height="300px" width="320px"/>
</div>




<jsp:include page="include/footer.jsp" /> 