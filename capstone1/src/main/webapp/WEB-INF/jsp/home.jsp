<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container" items="${user}">
    <h1>Welcome, ${user.firstName}!</h1>

    <h2 id="title">Your Pets</h2>
    <div id="pet-thumbnail-container">
        <img src="../../pub/images/pawprints.jpg" alt="pawprints" height="700px" width="500px" />
            <c:forEach items="${pets}" var="pet">
                <a href="/petcard?id=${pet.id}">
                    <div class="pet-thumbnail">
                        <img src="${pet.image}" alt="${pet.name}" height="300px" width="300px">
                        <h3 class="hvr-grow">${pet.name}</h3>
                        <p>Click for Details</p>
                    </div>
                </a>
            </c:forEach>
        <img src="../../pub/images/pawprints.jpg" alt="pawprints" height="700px" width="500px" />
    </div>
</div>

<script>

</script>

<jsp:include page="include/footer.jsp" /> 