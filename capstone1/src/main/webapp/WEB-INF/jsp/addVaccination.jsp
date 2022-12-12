<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="page-container">
    <form action="/addVaccination/submit" method="GET">
        <label for="cars">Which vaccine did your pet receive?</label>
        <select>
            <c:forEach items="${vaccines}" var="vaccine">
                <option name="vaxName" value="${vaxName}">${vaccine.name}</option>
            </c:forEach>
        </select>
        
        <button type="submit">Next</button>
    </form>
</div>


    <jsp:include page="include/footer.jsp" />