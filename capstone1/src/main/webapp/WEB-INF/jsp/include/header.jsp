<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vax Track</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <!-- Body font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa&display=swap" rel="stylesheet">
    
    <!-- Header/Footer font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oleo+Script&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../../pub/main.css">

</head>
<body>
    
    <div id="header">
        <div id="logo-section" class="slide-in">
            <div>
                <img src="../../../pub/images/vax-track-icon.png" alt="vax track logo" height="100px" width="100px">
            </div>
            <div><h1>Vax Track</h1></div>
        </div>
       
        <nav class="slide-in-opp">
            <sec:authorize access="!isAuthenticated()">
            <a class="hvr-float" href="/">Home</a>
            <a class="hvr-float" href="/login">Login</a>
            <a class="hvr-float" href="/signup">Sign Up</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a class="hvr-float" href="/home">Home</a>
                <a class="hvr-float" href="/account">My Account</a>
                <a class="hvr-float" href="/addAPet">Add A Pet</a>
                <a class="hvr-float" href="/logout">Logout</a>
            </sec:authorize>
        </nav>
</div>
   