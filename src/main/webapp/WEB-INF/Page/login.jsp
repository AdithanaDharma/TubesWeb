<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Aplikasi Penjualan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #080f25;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-card {
            background-color: #181c34;
            padding: 2rem;
            border-radius: 1rem;
            width: 100%;
            max-width: 400px;
            border: 1px solid #343b4f;
        }
        .form-control {
            background-color: #080f25;
            border-color: #343b4f;
            color: white;
        }
        .form-control:focus {
            background-color: #080f25;
            border-color: #6c72ff;
            color: white;
            box-shadow: none;
        }
        .btn-primary {
            background-color: #6c72ff;
            border-color: #6c72ff;
        }
    </style>
</head>
<body>

<div class="login-card">
    <h2 class="text-center mb-4">Selamat Datang</h2>

    <%-- Menampilkan pesan error jika ada --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <%-- Menampilkan pesan sukses (cth: setelah logout) --%>
    <% if (request.getAttribute("successMessage") != null) { %>
    <div class="alert alert-success" role="alert">
        <%= request.getAttribute("successMessage") %>
    </div>
    <% } %>

    <form action="${pageContext.request.contextPath}/controller" method="post">
        <input type="hidden" name="action" value="login">
        <div class="mb-3">
            <label for="nama" class="form-label">Nama Pengguna</label>
            <input type="text" class="form-control" id="nama" name="nama" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Login</button>
    </form>
</div>

</body>
</html>