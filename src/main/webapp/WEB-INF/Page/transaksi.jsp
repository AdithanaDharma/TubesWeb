<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Data Transaksi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet" />
    <style>
        :root {
            --primary-color: #4e73df;
            --secondary-color: #f8f9fc;
            --accent-color: #2e59d9;
            --text-color: #5a5c69;
            --dark-bg: #1a1a2e;
            --card-bg: #16213e;
            --highlight: #0f3460;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--dark-bg);
            color: white;
        }

        .navbar {
            background-color: var(--highlight) !important;
            padding: 0.8rem 1rem;
        }

        .navbar-brand span {
            font-size: 1.2rem;
        }

        .keycard {
            background-color: var(--card-bg);
            border-radius: 0.5rem;
            padding: 1.5rem;
            box-shadow: 0 0.15rem 1.75rem 0 rgba(58, 59, 69, 0.15);
            border: none;
            color: white;
        }

        .stats-card h3 {
            font-size: 1.5rem;
            font-weight: 600;
            margin-bottom: 0.5rem;
        }

        .sub-teks {
            color: #b3b3b3;
            font-size: 0.875rem;
            margin-bottom: 0;
        }

        .table {
            color: white;
            background-color: var(--card-bg);
            border-radius: 0.5rem;
            overflow: hidden;
        }

        .table thead {
            background-color: white;
            color: black;
        }

        .table th {
            border-bottom: none;
            font-weight: 600;
        }

        .table td, .table th {
            padding: 1rem;
            vertical-align: middle;
        }

        .table-striped tbody tr:nth-of-type(odd) {
            background-color: rgba(255, 255, 255, 0.05);
        }

        .table-hover tbody tr:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        .btn-primary {
            background-color: var(--primary-color);
            border-color: var(--primary-color);
        }

        .btn-primary:hover {
            background-color: var(--accent-color);
            border-color: var(--accent-color);
        }

        .btn-sm {
            padding: 0.25rem 0.5rem;
            font-size: 0.875rem;
        }

        .footer {
            background-color: var(--highlight);
            padding: 1rem;
            color: white;
            font-size: 0.875rem;
        }

        .social-icons a {
            color: white;
            margin: 0 0.5rem;
            transition: opacity 0.3s;
        }

        .social-icons a:hover {
            opacity: 0.8;
        }

        .container {
            max-width: 1200px;
        }

        /* New table styling to match the second code */
        .table-dark {
            background-color: #212529;
        }

        .table-dark.table-striped tbody tr:nth-of-type(odd) {
            background-color: rgba(255, 255, 255, 0.05);
        }

        .table-dark.table-hover tbody tr:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        .rounded {
            border-radius: 0.5rem !important;
        }

        .table-responsive {
            overflow-x: auto;
        }
    </style>
</head>
<body>
<div class="d-flex flex-column vh-100">
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand d-flex align-items-center" href="#">
                <span class="ms-2 fw-bold">X JURAGAN</span>
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a href="#" class="nav-link"><i class="fas fa-th-large me-2"></i>Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><i class="fas fa-shopping-bag me-2"></i>Produk</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link active"><i class="far fa-clock me-2"></i>Transaksi</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><i class="fas fa-file me-2"></i>Laporan</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><i class="fas fa-times me-2"></i>Sign Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="flex-grow-1 px-4 py-1 overflow-auto">
        <div class="row my-4">
            <div class="col-12">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h2 class="fw-semibold m-0">Data Transaksi</h2>
                    <button type="button" class="btn btn-primary">
                        <i class="fas fa-plus me-2"></i>Tambah Transaksi
                    </button>
                </div>

                <div class="table-responsive">
                    <table class="table table-dark table-striped table-hover rounded">
                        <thead class="table-light text-dark">
                        <tr>
                            <th scope="col">Kode Produk</th>
                            <th scope="col">Nama Produk</th>
                            <th scope="col">Tanggal Transaksi</th>
                            <th scope="col">Status</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>KT001</td>
                            <td>Elektronik</td>
                            <td>2023-10-27 10:00:00</td>
                            <td><span class="badge bg-success">Selesai</span></td>
                            <td>
                                <button type="button" class="btn btn-outline-light btn-sm me-1">
                                    <i class="fas fa-info-circle"></i>
                                </button>
                                <button type="button" class="btn btn-primary btn-sm me-1">
                                    <i class="fas fa-edit"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm">
                                    <i class="fas fa-trash-alt"></i>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>KT002</td>
                            <td>Pakaian</td>
                            <td>2023-10-28 11:30:00</td>
                            <td><span class="badge bg-warning text-dark">Proses</span></td>
                            <td>
                                <button type="button" class="btn btn-outline-light btn-sm me-1">
                                    <i class="fas fa-info-circle"></i>
                                </button>
                                <button type="button" class="btn btn-primary btn-sm me-1">
                                    <i class="fas fa-edit"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm">
                                    <i class="fas fa-trash-alt"></i>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>KT003</td>
                            <td>Alat Tulis Kantor</td>
                            <td>2023-10-29 09:15:00</td>
                            <td><span class="badge bg-success">Selesai</span></td>
                            <td>
                                <button type="button" class="btn btn-outline-light btn-sm me-1">
                                    <i class="fas fa-info-circle"></i>
                                </button>
                                <button type="button" class="btn btn-primary btn-sm me-1">
                                    <i class="fas fa-edit"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm">
                                    <i class="fas fa-trash-alt"></i>
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="footer container-fluid d-flex flex-column flex-sm-row justify-content-between align-items-center text-center">
        <span class="text-white mb-2 mb-sm-0">&copy; JURAGAN was created by sekte penyihir kode error.</span>
        <div class="social-icons">
            <a href="#"><i class="fab fa-instagram fa-lg"></i></a>
            <a href="#"><i class="fab fa-facebook-f fa-lg"></i></a>
            <a href="#"><i class="fab fa-whatsapp fa-lg"></i></a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</body>
</html>