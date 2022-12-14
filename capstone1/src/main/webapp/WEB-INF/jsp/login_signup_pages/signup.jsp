<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

    <!-- display flex in CSS-->
    <div class="page-container">
        <h1 class="signup-h1">Sign Up</h1>
        <div id="signup-container">
            <div id="form-img">
                <div>
                    <img src="../../../pub/images/popart-signup.webp" width="500px" height="670px" style="border-radius: 10px" />
                </div>
                <form id="signup-form" action="/signup" method="POST">
                    <div class="mb-3">
                        <label for="firstName" class="form-label"><strong>First Name</strong></label>
                        <input type="text" value="${form.firstName}" name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelp">
                        <div id="firstNameHelp" class="form-text">Please enter your first name.</div>
                    </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label"><strong>Last Name</strong></label>
                    <input type="text" value="${form.lastName}" name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelp">
                    <div id="lastNameHelp" class="form-text">Please enter your last name.</div>
                </div>
                <div class="mb-3">
                    <label for="State" class="form-label"><strong>State</strong></label>
                    <select class="form-control" id="state" name="state">
                        <option value="Alabama">Alabama</option>
                        <option value="Alaska">Alaska</option>
                        <option value="Arizona">Arizona</option>
                        <option value="Arkansas">Arkansas</option>
                        <option value="California">California</option>
                        <option value="Colorado">Colorado</option>
                        <option value="Connecticut">Connecticut</option>
                        <option value="Delaware">Delaware</option>
                        <option value="Florida">Florida</option>
                        <option value="Georgia">Georgia</option>
                        <option value="Hawaii">Hawaii</option>
                        <option value="Idaho">Idaho</option>
                        <option value="Illinois">Illinois</option>
                        <option value="Indiana">Indiana</option>
                        <option value="Iowa">Iowa</option>
                        <option value="Kansas">Kansas</option>
                        <option value="Kentucky">Kentucky</option>
                        <option value="Louisiana">Louisiana</option>
                        <option value="Maine">Maine</option>
                        <option value="Maryland">Maryland</option>
                        <option value="Massachusetts">Massachusetts</option>
                        <option value="Michigan">Michigan</option>
                        <option value="Minnesota">Minnesota</option>
                        <option value="Mississippi">Mississippi</option>
                        <option value="Missouri">Missouri</option>
                        <option value="Montana">Montana</option>
                        <option value="Nebraska">Nebraska</option>
                        <option value="Nevada">Nevada</option>
                        <option value="New Hampshire">New Hampshire</option>
                        <option value="New Jersey">New Jersey</option>
                        <option value="New Mexico">New Mexico</option>
                        <option value="New York">New York</option>
                        <option value="North Carolina">North Carolina</option>
                        <option value="North Dakota">North Dakota</option>
                        <option value="Ohio">Ohio</option>
                        <option value="Oklahoma">Oklahoma</option>
                        <option value="Oregon">Oregon</option>
                        <option value="Pennsylvania">Pennsylvania</option>
                        <option value="Rhode Island">Rhode Island</option>
                        <option value="South Carolina">South Carolina</option>
                        <option value="South Dakota">South Dakota</option>
                        <option value="Tennessee">Tennessee</option>
                        <option value="Texas">Texas</option>
                        <option value="Utah">Utah</option>
                        <option value="Vermont">Vermont</option>
                        <option value="Virginia">Virginia</option>
                        <option value="Washington">Washington</option>
                        <option value="West Virginia">West Virginia</option>
                        <option value="Wisconsin">Wisconsin</option>
                        <option value="Wyoming">Wyoming</option>
                    </select>
                </div>
                <div>
                    <label for="username" class="form-label"><strong>Username</strong></label>
                    <input type="text" value="${form.username}" name="username" class="form-control" id="username" aria-describedby="usernameHelp">
                    <div id="usernameHelp" class="form-text">Please enter a username.</div>
                </div>
                <div class="row">
                    <div class="mb-3 col-6">
                        <label for="password" class="form-label"><strong>Password</strong></label>
                        <input type="password" name="password" class="form-control" id="password" aria-describedby="passwordHelp">
                        <div id="passwordHelp" class="form-text">Please enter a password.</div>
                    </div>
                    <div class="mb-3 col-6">
                        <label for="confirmPassword" class="form-label"><strong>Confirm Password</strong></label>
                        <input type="password" name="confirmPassword" class="form-control" id="confirmPassword">
                    </div>
                </div>
                <div id="to-signup-login" class="mb-3">
                    <p>Already have an account? <a href="/login">Login here</a>.</p>
                    <button type="submit" class="btn btn-primary">Sign Up</button>
                </div>

                <!-- <button type="submit" class="btn btn-primary">Sign Up</button> -->

                <f:if test="${bindingResult.hasErrors()}">
                    <c:forEach items="${bindingResult.getAllErrors()}" var="error">
                        <p class="signup-error">${error.getDefaultMessage()}</p>
                    </c:forEach>
                </f:if>
            </form>
        </div>
        </div>
    </div>
    
<jsp:include page="../include/footer.jsp" />