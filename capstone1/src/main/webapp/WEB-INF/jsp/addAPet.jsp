<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container">
    <h1>Add Your Pet</h1>
    <div id="addpet-container">
        <form id="addpet-form" action="/addAPet" method="POST">
            <div>
                <label for="name" class="form-label"><strong>Name</strong></label>
                <input type="text" value="${form.name}" name="name" class="form-control" id="name" /> 
            </div>
            <div>
                <input type="radio" id="dog" name="species" value="Dog">
                <label for="dog">Dog</label><br>
                <input type="radio" id="cat" name="species" value="Cat">
                <label for="cat">Cat</label><br>
            </div>
            <!-- File upload at later date -->
            <div>
                <label for="name" class="form-label"><strong>Image</strong></label>
                <input type="text" value="${form.image}" name="image" class="form-control" /> 
            </div>
            <div>
                <label for="breed" class="form-label"><strong>Breed</strong></label>
                <input type="text" value="${form.breed}" name="breed" class="form-control" id="breed" /> 
            </div>
            <div>
                <label for="birthDate" class="form-label"><strong>Birthday</strong></label>
                <input type="text" value="${form.birthDate}" name="birthDate" class="form-control" id="birthDate" /> 
            </div>
            <div>
                <label for="gender" class="form-label"><strong>Gender</strong></label>
                <select id="gender" name="gender">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
            <div>
                <label for="personality" class="form-label-long"><strong>Personality</strong></label>
                <input type="text" value="${form.personality}" name="personality" class="form-control" id="personality" /> 
            </div>
           
            <button type="submit">Add</button>
 
            <f:if test="${bindingResult.hasErrors()}">

                    <c:forEach items="${bindingResult.getAllErrors()}" var="error">
                        <p class="signup-error">${error.getDefaultMessage()}</p>
                    </c:forEach>
    
            </f:if>
            
        </form>
    </div>
</div>




<jsp:include page="include/footer.jsp" /> 