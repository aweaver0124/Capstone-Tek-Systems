<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="page-container-add" items="${currentPet}">
    <div id="vax-submit-contain">
        <h3 class="first-then">First, </h3>
        <div id="add-vax-form" class="fade-in">
            <h3>Which vaccination did ${currentPet.name} receive?</h3>
                <form action="/addVaccination/submit" method="GET">
                    <div class="mb-3">
                        <label for="vaxName" class="form-label"><strong>Select Vaccination Name</strong></label>
                        <select class="form-control" name="vaxName" value="${vaxName}">
                            <c:forEach items="${vaccines}" var="vax">
                                <option value="${vax.name}">${vax.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                <input type="hidden" name="petId" value="${petId}" />
                <div class="mb-3" id="addvax-btn"><button type="submit" id="animate" class="btn btn-primary">Next</button></div>
            </form>
        </div>
        <h3 class="first-then">Then...</h3>
        <div id="add-vax-form-cont">
            <h3>Tell us where and when.</h3>
            <form action="/addVaccination/submit" method="POST">
            <div class="mb-3">
                <label for="clinicName" class="form-label"><strong>Name of Clinic</strong></label>
                <input type="text" value="${form.clinicName}" name="clinicName" class="form-control" id="clinicName" aria-describedby="clinicNameHelp"/> 
                <div id="clinicNameHelp" class="form-text">Please enter the clinic name.</div>
            </div>
            <div class="mb-3">
                <label for="dateReceived" class="form-label"><strong>Date Received</strong></label>
                <input type="text" value="${form.dateReceived}" name="dateReceived" class="form-control" id="dateReceived" aria-describedby="dateReceivedHelp"/> 
                <div id="dateReceivedHelp" class="form-text">Please enter the date which it was give in YYYY/MM/DD format.</div> 
            </div>
            <div class="mb-3">
                <label for="expirationDate" class="form-label"><strong>Expiration Date</strong></label>
                <input type="text" value="${form.expirationDate}" name="expirationDate" class="form-control" id="expirationDate" aria-describedby="expirationDateHelp"/> 
                <div id="expirationDateHelp" class="form-text">Please enter the date which it will expire in YYYY/MM/DD format.</div> 
            </div>
            <div class="mb-3" id="addvax-btn-2"><button type="submit" class="btn btn-primary">Submit </button></div>
                <f:if test="${bindingResult.hasErrors()}">
                        <c:forEach items="${bindingResult.getAllErrors()}" var="error">
                            <p class="signup-error">${error.getDefaultMessage()}</p>
                        </c:forEach>
                </f:if>
            </form>
        </div>
    </div>
</div>

<script>

    var hidden = document.getElementById("add-vax-form-cont").className("hidden");
    var btn = document.getElementById("animate");
    btn.addEventListener('click', function addAnimation(e){
            e.preventDefault()
            hidden.classList.remove("hidden");
            hidden.className = "fade-in";
    })
    
    </script>

<jsp:include page="include/footer.jsp" />