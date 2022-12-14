<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container-petcard" id="petcard-divs" items="${currentPet}">
    <div id="image-and-data">
        <div id="image">
            <h1>${currentPet.name}</h1>
            <img src="${currentPet.image}" alt="${currentPet.name}" height="406px" width="385px" />
        </div>
        <div id="pet-data">
            <h2>${currentPet.name}'s Information</h2>
            <br><br>
            <h4>Birthday:</h4>
            <p>${currentPet.birthDate}</p>
            
            <h4>Gender:</h4>
            <p>${currentPet.gender}</p>
            
            <h4>Breed:</h4>
            <p>${currentPet.breed}</p>
           
            <h4>Personality:</h4>
            <p>${currentPet.personality}</p>
            
        </div>
    </div>
    <h3 id="vax-details">Vaccination Details</h3>
    <div id="vax-table-container">
        <div id="vax-table">
            <table>
                <tr>
                    <td><strong>Vaccination Name</strong></td>
                    <td><strong>Clinic Name</strong></td>
                    <td><strong>Date Received</strong></td>
                    <td><strong>Expiration Date</strong></td>
                    
                </tr>
                <c:forEach items="${vaccines}" var="vaccine">
                    <tr>
                        <td>${vaccine.name}</td>
                        <td>${vaccine.clinicName}</td>
                        <td>${vaccine.dateReceived}</td>
                        <td>${vaccine.expirationDate}</td>
                        
                    </tr>
                </c:forEach>
            </table>
            <a href="/addVaccination/?id=${currentPet.id}"><button>Add A Vaccination</button></a>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" /> 