-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2024 at 09:03 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `abendandb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(20) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_usn` varchar(50) NOT NULL,
  `u_pass` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_usn`, `u_pass`, `u_type`, `u_status`, `u_image`) VALUES
(1027, 'Christian James', 'Abendan', 'chrisbend2004@gmail.com', 'cjabendan', '3c7ef747ce6f3e1c28d1c277088080e14e661f379d297ffe1d', 'Admin', 'Active', 'src/u_images/438112599_424135973659403_368998786136545955_n.jpg'),
(1028, 'David Sailas', 'Villondo', 'dasai@gmail.com', 'dasai', '54b444b782a52174b5504592602d5a59d6a5245a854e1b3056', 'User', 'Active', 'src/u_images/ce150469-7680-41d4-9b70-030174ef38bd.jpg'),
(1031, 'John Michael', 'Dela Cuesta', 'jeym@gmail.com', 'jeym', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1036, 'Vince Michael', 'Bacarisas', 'vmbacarisas@gmail.com', 'binsoy', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1037, 'John Bert', 'Plameran', 'jb', 'jb', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', 'src/u_images/440173363_3801477933464088_139592517797323345_n.jpg'),
(1038, 'Mark Ken', 'Purisima', 'kenmar@gmail.com', 'marken', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', ''),
(1039, 'Emman', 'Bas', 'emman@gmai.com', 'emmantuts', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1040, 'Briane Jae', 'Bas', 'bj@gmail.com', 'brinap', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', ''),
(1041, 'Ariane Jae', 'Bas', 'aj@gmail.com', 'Inu', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', ''),
(1042, 'Angel Faith', 'Abendan', 'faith@gmail.com', 'apayapay', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', ''),
(1043, 'Rhovellah', 'Abendan', 'rhovella@gmail.com', 'rubyabendan', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', ''),
(1044, 'Rommel', 'Abendan', 'rommel@gmail.com', 'romeoab', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', ''),
(1045, 'Nathaniel', 'Manto', 'manto@gmail.com', 'mynath', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1046, 'Kolton', 'Buclod', 'kolton@gmail.com', 'kolton12', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1047, 'Tristan', 'Reyes', 'tantris@gmail,ocm', 'tristzy', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1048, 'Michelle', 'Abendan', 'michelle@gmail.com', 'mitch', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1049, 'Ashley', 'Abendan', 'ashley@gmail.com', 'bahagnat', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1050, 'Alex', 'Paca', 'alex@gmail.com', 'alexx1', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1051, 'Zavier', 'Macalinao', 'zav21@gmail.com', 'zavy', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1052, 'Conner', 'Cabrera', 'conny@gmail.com', 'corner21', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1053, 'Steven', 'Cayetano', 'stevecat@gmail.com', 'stevemen', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1054, 'David Sailas', 'Villondo Romano', 'romano@gmail.com', 'dasai21', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Active', ''),
(1055, 'a', 'a', 'a', 'a', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', ''),
(1056, 'Tim', 'Romano', 'braxy@gmail.com', 'shaman', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', ''),
(1057, 'b', 'b', 'b', 'b', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff12265', 'User', 'Pending', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1058;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
