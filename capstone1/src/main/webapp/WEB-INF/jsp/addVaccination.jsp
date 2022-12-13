<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="page-container" items="${currentPet}">
    <div id="add-vax-form">
    <h3>Which vaccination did ${currentPet.name} receive?</h3>
        <form action="/addVaccination/submit" method="GET">
            <select name="vaxName" value="${vaxName}">
                <c:forEach items="${vaccines}" var="vax">
                    <option value="${vax.name}">${vax.name}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="petId" value="${petId}" />
            <button type="submit">Next</button>
        </form>
    </div>
    <div id="append">
        <div id="add-vax-form-cont">
            <h3>Tell us where and when.</h3>
            <form action="/addVaccination/submit" method="POST">
            <div>
                <label for="clinicName" class="form-label"><strong>Name of Clinic</strong></label>
                <input type="text" value="${form.clinicName}" name="clinicName" class="form-control" id="clinicName" /> 
            </div>
            <div>
                <label for="dateReceived" class="form-label"><strong>Date Received (Format: YYYY/MM/DD)</strong></label>
                <input type="text" value="${form.dateReceived}" name="dateReceived" class="form-control" id="dateReceived" /> 
            </div>
            <div>
                <label for="expirationDate" class="form-label"><strong>Expiration Date (Format: YYYY/MM/DD)</strong></label>
                <input type="text" value="${form.expirationDate}" name="expirationDate" class="form-control" id="expirationDate" /> 
            </div>
                <button type="submit">Submit</button>
    
                <f:if test="${bindingResult.hasErrors()}">
    
                        <c:forEach items="${bindingResult.getAllErrors()}" var="error">
                            <p class="signup-error">${error.getDefaultMessage()}</p>
                        </c:forEach>
        
                </f:if>
            </form>
        </div>
    </div>


<jsp:include page="include/footer.jsp" />