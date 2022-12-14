<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container">
    <h1 class="signup-h1">Add Your Pet</h1>
    <div id="addpet-container">
        <div id="addpet-form-container">
        <form id="addpet-form" action="/addAPet" method="POST">
            <div class="mb-3">
                <label for="name" class="form-label"><strong>Name</strong></label>
                <input type="text" value="${form.name}" name="name" class="form-control" id="name" aria-describedby="petNameHelp"/> 
                <div id="petNameHelp" class="form-text">Please enter your pet's name.</div>
            </div>
            <div class="row">
                
            <div class="mb-3 col-6">
                <label for="species" class="form-label"><strong>Species</strong></label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="species" id="dog" value="Dog">
                    <label class="form-check-label" for="dog">
                        Dog
                    </label>
                  </div>
                  <div class="form-check">
                    <input class="form-check-input" type="radio" id="cat" name="species" value="Cat">
                    <label class="form-check-label" for="cat">
                        Cat
                    </label>
                  </div>
            </div>
            <div class="mb-3 col-6">
                <label for="gender" class="form-label"><strong>Gender</strong></label>
                <select class="form-control" id="gender" name="gender">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
            </div>

            <!-- File upload at later date -->
            <div class="mb-3">
                <label for="image" class="form-label"><strong>Image</strong></label>
                <input type="text" value="${form.image}" name="image" class="form-control" aria-describedby="imageHelp"/>
                <div id="imageHelp" class="form-text">Please select an image of your pet.</div> 
            </div>
            <div class="mb-3">
                <label for="breed" class="form-label"><strong>Breed</strong></label>
                <input type="text" value="${form.breed}" name="breed" class="form-control" id="breed" aria-describedby="breedHelp"/> 
                <div id="breedHelp" class="form-text">Please enter the breed of your pet.</div> 
            </div>
            <div class="mb-3">
                <label for="birthDate" class="form-label"><strong>Birthday</strong></label>
                <input type="text" value="${form.birthDate}" name="birthDate" class="form-control" id="birthDate" aria-describedby="birthDateHelp"/> 
                <div id="birthDateHelp" class="form-text">Please enter the birthday of your pet in YYYY/MM/DD format.</div>
            </div>
            <div class="mb-3">
                <label for="personality" class="form-label-long"><strong>Additional Information</strong></label>
                <input type="text" value="${form.personality}" name="personality" class="form-control" id="personality" aria-describedby="personalityHelp"/> 
                <div id="personalityHelp" class="form-text">Please provide any additional details including medical information, personality, temperament, etc.</div> 
            </div>
            <div id="button"><button class="btn btn-primary" type="submit">Add</button></div>
 
            <f:if test="${bindingResult.hasErrors()}">

                    <c:forEach items="${bindingResult.getAllErrors()}" var="error">
                        <p class="signup-error">${error.getDefaultMessage()}</p>
                    </c:forEach>
    
            </f:if>
            
        </form>
    </div>
    </div>
</div>




<jsp:include page="include/footer.jsp" /> 