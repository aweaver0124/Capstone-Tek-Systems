<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div class="page-container">
    <h1>Login</h1>
    <div id="login-container">
        <form action="/login" method="POST">
            <div class="login-input">
                <label for="username" class="form-label">Username</label>
                <input type="username" name="username" class="form-control" id="username">
            </div>
            <div class="login-input">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password">
            </div>
            <div class="to-signup-login">
                <p>Don't have an account? <a href="/signup">Sign up here</a>.</p>
            </div>
            <button type="submit">Login</button>
        </form>
    </div>
</div>


<jsp:include page="../include/footer.jsp" />