-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2024 at 06:10 AM
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
-- Table structure for table `tbl_barangay`
--

CREATE TABLE `tbl_barangay` (
  `b_id` int(10) NOT NULL,
  `b_name` varchar(255) NOT NULL,
  `b_location` varchar(255) NOT NULL,
  `b_population` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_citizen`
--

CREATE TABLE `tbl_citizen` (
  `c_id` int(10) NOT NULL,
  `h_id` int(10) NOT NULL,
  `c_name` varchar(100) NOT NULL,
  `c_dob` date NOT NULL,
  `c_sex` int(50) NOT NULL,
  `c_civilstatus` int(50) NOT NULL,
  `c_occupation` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_household`
--

CREATE TABLE `tbl_household` (
  `h_id` int(10) NOT NULL,
  `p_id` int(10) NOT NULL,
  `h_address` varchar(255) NOT NULL,
  `h_occupants` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_purok`
--

CREATE TABLE `tbl_purok` (
  `p_id` int(10) NOT NULL,
  `p_name` varchar(100) NOT NULL,
  `u_id` int(10) NOT NULL,
  `b_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(10) NOT NULL,
  `u_fname` varchar(100) NOT NULL,
  `u_lname` varchar(100) NOT NULL,
  `u_email` varchar(100) NOT NULL,
  `u_usn` varchar(100) NOT NULL,
  `u_pass` varchar(150) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_image` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_usn`, `u_pass`, `u_type`, `u_status`, `u_image`) VALUES
(1001, 'Christian James', 'Abendan', 'chrisbend2004@gmail.com', 'cjabendan', '3c7ef747ce6f3e1c28d1c277088080e14e661f379d297ffe1d6ef74cd6960a194cde122d462e9224a54c97a52477934ad9cf1f4609386da77e712137ae8281af', 'Admin', 'Active', 'src/u_images/chan2.jpg'),
(1002, 'David Sailas', 'Villondo', 'chebry@gmail.com', 'dasai', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', ''),
(1003, 'Vince Micheal', 'Bacarisas', 'bensoy@gmail.com', 'bensoy', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_barangay`
--
ALTER TABLE `tbl_barangay`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `tbl_citizen`
--
ALTER TABLE `tbl_citizen`
  ADD PRIMARY KEY (`c_id`),
  ADD KEY `h_id` (`h_id`);

--
-- Indexes for table `tbl_household`
--
ALTER TABLE `tbl_household`
  ADD PRIMARY KEY (`h_id`),
  ADD KEY `p_id` (`p_id`);

--
-- Indexes for table `tbl_purok`
--
ALTER TABLE `tbl_purok`
  ADD PRIMARY KEY (`p_id`),
  ADD KEY `u_id` (`u_id`),
  ADD KEY `b_id` (`b_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_barangay`
--
ALTER TABLE `tbl_barangay`
  MODIFY `b_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_citizen`
--
ALTER TABLE `tbl_citizen`
  MODIFY `c_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_household`
--
ALTER TABLE `tbl_household`
  MODIFY `h_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_purok`
--
ALTER TABLE `tbl_purok`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1004;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_citizen`
--
ALTER TABLE `tbl_citizen`
  ADD CONSTRAINT `tbl_citizen_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `tbl_household` (`h_id`);

--
-- Constraints for table `tbl_household`
--
ALTER TABLE `tbl_household`
  ADD CONSTRAINT `tbl_household_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `tbl_purok` (`p_id`);

--
-- Constraints for table `tbl_purok`
--
ALTER TABLE `tbl_purok`
  ADD CONSTRAINT `tbl_purok_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`),
  ADD CONSTRAINT `tbl_purok_ibfk_2` FOREIGN KEY (`b_id`) REFERENCES `tbl_barangay` (`b_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
