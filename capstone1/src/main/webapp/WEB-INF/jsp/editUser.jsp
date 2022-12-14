<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container">
    <div id="edit-user-container">
        <form action="/editUser" method="POST">
            <div class="row">
                <div class="mb-3 col-6">
                    <label for="firstName" class="form-label"><strong>First Name</strong></label>
                    <input type="text" value="${form.firstName}" name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelp"/> 
                    <div id="firstNameHelp" class="form-text">Please update your first name.</div>
                </div>
                <div class="mb-3 col-6">
                    <label for="lastName" class="form-label"><strong>Last Name</strong></label>
                    <input type="text" value="${form.lastName}" name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelp" /> 
                    <div id="lastName" class="form-text">Please update your last name.</div>
                </div>
            </div>
            <div class="mb-3">
                <label for="state" class="form-label"><strong>Select State</strong></label>
                <select class="form-control" id="state" name="state" aria-describedby="stateHelp">
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
                <div id="stateHelp" class="form-text">Please update your state.</div>
            </div>
            <div><button type="submit" class="btn btn-primary">Update</button></div>
        </form>
    </div>
</div>





<jsp:include page="include/footer.jsp" /> 