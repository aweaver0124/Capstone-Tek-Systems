<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="include/header.jsp" /> 

<div class="page-container" items="${currentPet}">
    <div id="image-and-table">
        <div id="image">
            <h2>${currentPet.name}</h2>
            <img src="${currentPet.image}" alt="${currentPet.name}" height="406px" width="385px" />
        </div>
        <div id="vax-table">
            <h3>Vaccination Details</h3>
            <table>
                <tr>
                    <td><strong>Vaccination Name</strong></td>
                    <td><strong>Clinic Name</strong></td>
                    <td><strong>Date Received</strong></td>
                    <td><strong>Expiration Date</strong></td>
                    <td><strong>Remove</strong></td>
                    
                </tr>
                    <c:forEach items="${vaccines}" var="vaccine">
                        <tr>
                            <td>${vaccine.name}</td>
                            <td>${vaccine.clinicName}</td>
                            <td>${vaccine.dateReceived}</td>
                            <td>${vaccine.expirationDate}</td>
                            <td><button> X </button></td>
                        </tr>
                    </c:forEach>
            </table>
            <a href="/addVaccination"><button>Add A Vaccination</button></a>
        </div>
    </div>
    <section>
        <h3>Birthday:</h3>
        <p>${currentPet.birthDate}</p>
        <br></br>
        <h3>Gender:</h3>
        <p>${currentPet.gender}</p>
        <br></br>
        <h3>Breed:</h3>
        <p>${currentPet.breed}</p>
        <br></br>
        <h3>Personality:</h3>
        <p>${currentPet.personality}</p>
        <br></br>
    </section>
</div>

<jsp:include page="include/footer.jsp" /> 