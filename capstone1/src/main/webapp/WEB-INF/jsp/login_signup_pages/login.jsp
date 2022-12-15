<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div class="page-container">
    <div id="login-container">
        <div class="block">
            <div>
                <h1 class="login-h1">Login</h1>
            </div>
            <form action="/login" method="POST" id="login-form">
                <div class="mb-3" >
                    <label for="username" class="form-label">Username</label>
                    <input type="username" name="username" class="form-control" id="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="password">
                </div>
                <div id="to-login-signup">
                    <p>Don't have an account? <a href="/signup">Sign up here</a>.</p>
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>


<jsp:include page="../include/footer.jsp" />