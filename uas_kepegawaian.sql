-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jan 2024 pada 06.48
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_kepegawaian`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_absensi`
--

CREATE TABLE `data_absensi` (
  `id` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `tanggal_rekap` date NOT NULL,
  `jumlah_masuk` int(5) NOT NULL,
  `jumlah_izin` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `data_absensi`
--

INSERT INTO `data_absensi` (`id`, `id_pegawai`, `tanggal_rekap`, `jumlah_masuk`, `jumlah_izin`) VALUES
(18, 16, '2024-01-31', 31, 0),
(19, 17, '2024-01-31', 30, 1),
(20, 18, '2024-01-31', 29, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_gaji`
--

CREATE TABLE `data_gaji` (
  `id` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `tanggal_gaji` date NOT NULL,
  `jumlah_gaji` int(10) NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `data_gaji`
--

INSERT INTO `data_gaji` (`id`, `id_pegawai`, `tanggal_gaji`, `jumlah_gaji`, `status`) VALUES
(27, 16, '2024-01-31', 9000000, 'Diterima'),
(28, 17, '2024-01-31', 8000000, 'Diterima'),
(32, 18, '2024-01-31', 7000000, 'Diterima'),
(35, 27, '2024-01-31', 8000000, 'Belum Diterima');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_pegawai`
--

CREATE TABLE `data_pegawai` (
  `id` int(11) NOT NULL,
  `nip` int(10) NOT NULL,
  `nama_pegawai` varchar(50) NOT NULL,
  `tempat_lahir` varchar(30) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(13) NOT NULL,
  `jabatan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `data_pegawai`
--

INSERT INTO `data_pegawai` (`id`, `nip`, `nama_pegawai`, `tempat_lahir`, `tanggal_lahir`, `alamat`, `telepon`, `jabatan`) VALUES
(16, 2110010519, 'Jihad Lutfian', 'Banjarbaru', '2002-07-13', 'Jl . Belimbing', '0895700745598', 'Leader'),
(17, 2110010491, 'Ihsan Ali', 'Martapura', '2003-02-12', 'Jl . Rahayu', '0878999900008', 'Manager'),
(18, 2110010532, 'Wafi Dhiya', 'Martapura', '2003-06-07', 'Jl . Sekumpul', '0812123412345', 'Staff'),
(27, 2110010567, 'Bintang Fathehah', 'Banjarbaru', '2002-04-19', 'Jl . Angkasa', '0897990099000', 'Staff');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data_absensi`
--
ALTER TABLE `data_absensi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indeks untuk tabel `data_gaji`
--
ALTER TABLE `data_gaji`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indeks untuk tabel `data_pegawai`
--
ALTER TABLE `data_pegawai`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nip` (`nip`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `data_absensi`
--
ALTER TABLE `data_absensi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT untuk tabel `data_gaji`
--
ALTER TABLE `data_gaji`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT untuk tabel `data_pegawai`
--
ALTER TABLE `data_pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `data_absensi`
--
ALTER TABLE `data_absensi`
  ADD CONSTRAINT `data_absensi_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `data_pegawai` (`id`);

--
-- Ketidakleluasaan untuk tabel `data_gaji`
--
ALTER TABLE `data_gaji`
  ADD CONSTRAINT `data_gaji_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `data_pegawai` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
