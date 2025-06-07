<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PRODUK</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="bg-dark text-white">
<nav class="navbar navbar-expand-lg navbar-dark bg-black">
    <div class="container-fluid">
        <a class="navbar-brand d-flex align-items-center" href="#">
            <img src="${pageContext.request.contextPath}/img/image1.png" class="Logo" alt="Logo">
            <span class="ms-2 fw-bold">X JURAGAN</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-th-large me-2"></i>Dashboard</a></li>
                <li class="nav-item"><a href="#" class="nav-link active"><i class="fas fa-shopping-bag me-2"></i>Produk</a></li>
                <li class="nav-item"><a href="#" class="nav-link"><i class="far fa-clock me-2"></i>Transaksi</a></li>
                <li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-file me-2"></i>Laporan</a></li>
                <li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-times me-2"></i>Sign Out</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container py-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="fw-semibold">Produk Lek</h2>
        <button type="button" class="btn btn-primary">Tambah Produk</button>
    </div>
    <div class="table-responsive">
        <table class="table table-dark table-striped table-hover rounded">
            <thead class="table-light text-dark">
            <tr>
                <th scope="col">Kode Produk</th>
                <th scope="col">Nama Produk</th>
                <th scope="col">Harga</th>
                <th scope="col">Stok</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>KT001</td>
                <td>Hotwheels Bucket Mini</td>
                <td>Rp. 70.000</td>
                <td>15</td>
                <td>
                    <button class="btn btn-outline-light btn-sm">Detail</button>
                    <button class="btn btn-primary btn-sm">Edit</button>
                    <button class="btn btn-danger btn-sm">Hapus</button>
                </td>
            </tr>
            <tr>
                <td>KT002</td>
                <td>Gantungan Kunci Spiderman Couple</td>
                <td>Rp. 31.000</td>
                <td>50</td>
                <td>
                    <button class="btn btn-outline-light btn-sm">Detail</button>
                    <button class="btn btn-primary btn-sm">Edit</button>
                    <button class="btn btn-danger btn-sm">Hapus</button>
                </td>
            </tr>
            <tr>
                <td>KT003</td>
                <td>Alat Tulis Kantor</td>
                <td>Rp. 150.000</td>
                <td>100</td>
                <td>
                    <button class="btn btn-outline-light btn-sm">Detail</button>
                    <button class="btn btn-primary btn-sm">Edit</button>
                    <button class="btn btn-danger btn-sm">Hapus</button>
                </td>
            </tr>
            <tr>
                <td>KT004</td>
                <td>Aksesoris</td>
                <td>Rp. 150.000</td>
                <td>100</td>
                <td>
                    <button class="btn btn-outline-light btn-sm">Detail</button>
                    <button class="btn btn-primary btn-sm">Edit</button>
                    <button class="btn btn-danger btn-sm">Hapus</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<footer class="footer container-fluid d-flex flex-column flex-sm-row justify-content-between align-items-center text-center mt-auto py-3 bg-black">
    <span class="text-white mb-2 mb-sm-0">&copy; JURAGAN was created by sekte penyihir kode error.</span>
    <div>
        <a href="#" class="text-white text-decoration-none me-3"><i class="fab fa-instagram fa-lg"></i></a>
        <a href="#" class="text-white text-decoration-none me-3"><i class="fab fa-facebook-f fa-lg"></i></a>
        <a href="#" class="text-white text-decoration-none"><i class="fab fa-whatsapp fa-lg"></i></a>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>