<%@ page import="com.tubespbo.tubesweb.model.Pengguna" %>
<%
    // Ambil objek pengguna dari sesi
    Pengguna pengguna = (Pengguna) session.getAttribute("user");

    // Jika karena suatu hal pengguna tidak ada di sesi, arahkan kembali ke login
    if (pengguna == null) {
        response.sendRedirect(request.getContextPath() + "/controller?action=dashboard");
        return; // Hentikan pemrosesan sisa halaman
    }
%>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<div class="d-flex flex-column vh-100">
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand d-flex align-items-center" href="#">
                <img src="${pageContext.request.contextPath}/img/image1.png" class="Logo" alt="Logo">
                <span class="ms-2 fw-bold">X JURAGAN</span>
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a href="#" class="nav-link active"><i class="fas fa-th-large me-2"></i>Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><i class="fas fa-shopping-bag me-2 "></i>Produk</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><i class="far fa-clock me-2"></i>Transaksi</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><i class="fas fa-file me-2"></i>Laporan</a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/controller?action=logout" class="nav-link"><i class="fas fa-times me-2"></i>Sign Out</a>
                    </li>
                </ul>
                <span class="navbar-text text-white ms-3">
                    Halo, <%= pengguna.getNama() %>
                </span>
            </div>
        </div>
    </nav>

    <div class="flex-grow-1 px-4 py-1 overflow-auto">

        <div class="row g-3 my-4">
            <div class="col-12 col-sm-6 col-lg-3">
                <div class="subteks-atas stats-card keycard" >
                    <h3>32.000.000,00</h3>
                    <p class="sub-teks">Total Pendapatan Bulanan</p>
                </div>
            </div>
            <div class="col-12 col-sm-6 col-lg-3">
                <div class="subteks-atas stats-card keycard">
                    <h3>13000+</h3>
                    <p class="sub-teks">Total Barang Terjual</p>
                </div>
            </div>
            <div class="col-12 col-sm-6 col-lg-3">
                <div class="subteks-atas stats-card keycard">
                    <h3>4.800.000,00</h3>
                    <p class="sub-teks" >Laba Bersih Bulanan</p>
                </div>
            </div>
            <div class="col-12 col-sm-6 col-lg-3">
                <div class="subteks-atas stats-card keycard">
                    <h3>10%</h3>
                    <p class="sub-teks">Kenaikan Laba Penjualan MoM</p>
                </div>
            </div>
        </div>

        <div class="row gx-5 gy-4">
            <section class="col-12 col-lg-6">
                <div>
                    <h2 class="mb-3 fw-semibold text-white ke">Grafik penjualan</h2>
                    <canvas id="myChart" class="keycard"></canvas>
                </div>
            </section>
            <section class="col-12 col-lg-6">
                <div class="kosongan">
                    <h2 class="mb-3 fw-semibold text-white">Inventori</h2>
                    <ul class="list-unstyled d-flex flex-column gap-3">
                        <li class="product-card keycard p-2 d-flex align-items-center">
                            <img src="https://storage.googleapis.com/a1aa/image/ac9dcd3a-1002-4d8e-d9a2-9c35273ce5b9.jpg" class="me-3" style="width: 56px; height: 56px; border-radius: 0.5rem; object-fit: cover;"
                                 alt="Hotwheels Bucket Mini Toy Car in Blue Packaging" />
                            <div>
                                <p class="mb-1 fw-semibold">#1</p>
                                <p class="fw-semibold fs-5 m-0 sub-teks">Hotwheels Bucket Mini</p>
                            </div>
                        </li>
                        <li class="product-card keycard p-2 d-flex align-items-center">
                            <img src="https://storage.googleapis.com/a1aa/image/c157bb10-432d-445c-8f87-27e9eef38436.jpg" class="me-3" style="width: 56px; height: 56px; border-radius: 0.5rem; object-fit: cover;"
                                 alt="Spiderman Couple Keychain with Black Background" />
                            <div>
                                <p class="mb-1 fw-semibold">#2</p>
                                <p class="fw-semibold fs-5 m-0 sub-teks">Gantungan Kunci Spiderman Couple</p>
                            </div>
                        </li>
                        <li class="product-card keycard p-2 d-flex align-items-center">
                            <img src="https://storage.googleapis.com/a1aa/image/4540618b-3c7e-4a86-497e-5263e9354fdd.jpg" class="me-3" style="width: 56px; height: 56px; border-radius: 0.5rem; object-fit: cover;"
                                 alt="Custom Photo Keychain held in hand" />
                            <div>
                                <p class="mb-1 fw-semibold">#3</p>
                                <p class="fw-semibold fs-5 m-0 sub-teks">Gantungan Kunci Foto Custom</p>
                            </div>
                        </li>
                        <li class="product-card keycard p-2 d-flex align-items-center">
                            <img src="https://storage.googleapis.com/a1aa/image/4540618b-3c7e-4a86-497e-5263e9354fdd.jpg" class="me-3" style="width: 56px; height: 56px; border-radius: 0.5rem; object-fit: cover;"
                                 alt="Custom Photo Keychain held in hand" />
                            <div>
                                <p class="mb-1 fw-semibold">#3</p>
                                <p class="fw-semibold fs-5 m-0 sub-teks">Gantungan Kunci Foto Custom</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </section>
            <button id="chat-toggle-btn">
                <i class="fas fa-comments"></i>
            </button>

            <div id="chat-overlay">
                <div id="chat-window">
                    <div class="chat-header">
                        <h5>AI Assistant - Santo</h5>
                        <button id="close-chat-btn">&times;</button>
                    </div>

                    <div id="chat-messages">
                        <div class="chat-bubble bot-bubble">
                            Halo JURAGAN! Apa yang bisa saya bantu hari ini?
                        </div>
                    </div>

                    <div class="chat-input-area">
                        <input type="text" id="chat-input" placeholder="Ketik pesan Anda...">
                        <button id="send-chat-btn">
                            <i class="fas fa-paper-plane"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer container-fluid d-flex flex-column flex-sm-row justify-content-between align-items-end text-center">
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
<script>
    document.addEventListener('DOMContentLoaded', function() {
        // Ambil semua elemen yang dibutuhkan
        const toggleButton = document.getElementById('chat-toggle-btn');
        const chatOverlay = document.getElementById('chat-overlay');
        const closeButton = document.getElementById('close-chat-btn');
        const sendButton = document.getElementById('send-chat-btn');
        const chatInput = document.getElementById('chat-input');
        const chatMessages = document.getElementById('chat-messages');

        // Fungsi untuk membuka overlay chat
        function openChat() {
            if (chatOverlay) chatOverlay.classList.add('active');
        }

        // Fungsi untuk menutup overlay chat
        function closeChat() {
            if (chatOverlay) chatOverlay.classList.remove('active');
        }

        if (toggleButton) toggleButton.addEventListener('click', openChat);
        if (closeButton) closeButton.addEventListener('click', closeChat);

        if (chatOverlay) {
            chatOverlay.addEventListener('click', function(event) {
                if (event.target === chatOverlay) {
                    closeChat();
                }
            });
        }


        // Fungsi untuk mengirim pesan (tidak berubah)
        function sendMessage() {
            const messageText = chatInput.value.trim();
            if (messageText === '') return;
            addMessageToUI(messageText, 'user');
            chatInput.value = '';
            simulateBotReply();
        }

        // Fungsi untuk menambahkan bubble chat ke UI (tidak berubah)
        function addMessageToUI(message, sender) {
            const bubble = document.createElement('div');
            bubble.classList.add('chat-bubble', sender === 'user' ? 'user-bubble' : 'bot-bubble');
            bubble.innerText = message;
            chatMessages.appendChild(bubble);
            chatMessages.scrollTop = chatMessages.scrollHeight;
        }

        // Fungsi untuk simulasi balasan bot (tidak berubah)
        function simulateBotReply() {
            setTimeout(() => {
                addMessageToUI('Ini adalah balasan otomatis dari AI. Bagaimana saya bisa membantu?', 'bot');
            }, 1000);
        }

        if (sendButton) sendButton.addEventListener('click', sendMessage);
        if (chatInput) {
            chatInput.addEventListener('keypress', function(event) {
                if (event.key === 'Enter') {
                    sendMessage();
                }
            });
        }
    });
    // 1. Dapatkan elemen canvas
    const ctx = document.getElementById('myChart');
    if (ctx) { // Menambahkan pengecekan jika elemen canvas ada
        // 2. Siapkan data untuk grafik
        const data = {
            labels: ['Januari', 'Februari', 'Maret', 'April', 'Mei', 'Juni', 'Juli', 'Agustus', 'September', 'Oktober', 'November', 'Desember'],
            datasets: [{
                label: 'Penjualan',
                data: [65, 59, 80, 81, 56, 55, 40, 50, 55, 60, 75, 100],
                fill: false,
                borderColor: 'rgb(75, 192, 192)',
                tension: 0.1,
                backgroundColor: 'rgb(75, 192, 192)' // Untuk bar chart
            }]
        };

        // 3. Buat objek konfigurasi lengkap
        const config = {
            type: 'line', // Ganti menjadi 'bar' jika ingin grafik batang
            data: data,
            options: {
                responsive: true,
                scales: {
                    y: {
                        ticks: {
                            color: 'white' // Warna teks di sumbu Y
                        }
                    },
                    x: {
                        ticks: {
                            color: 'white' // Warna teks di sumbu X
                        }
                    }
                },
                plugins: {
                    legend: {
                        labels: {
                            color: 'white' // Warna teks legenda
                        }
                    }
                }
            }
        };

        // 4. Buat grafiknya
        new Chart(ctx, config);
    }
</script>
</body>
</html>