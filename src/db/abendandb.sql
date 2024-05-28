-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2024 at 11:55 AM
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

--
-- Dumping data for table `tbl_barangay`
--

INSERT INTO `tbl_barangay` (`b_id`, `b_name`, `b_location`, `b_population`) VALUES
(1001, 'Pob. Ward II', 'Minglanilla, Cebu', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_household`
--

CREATE TABLE `tbl_household` (
  `h_id` int(10) NOT NULL,
  `h_name` varchar(150) NOT NULL,
  `p_id` int(10) NOT NULL,
  `h_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_household`
--

INSERT INTO `tbl_household` (`h_id`, `h_name`, `p_id`, `h_address`) VALUES
(1, 'HN. 01', 1, 'Gimenez Street');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `l_id` int(10) NOT NULL,
  `l_timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `l_event` varchar(150) NOT NULL,
  `u_id` int(10) NOT NULL,
  `l_description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_purok`
--

CREATE TABLE `tbl_purok` (
  `p_id` int(10) NOT NULL,
  `p_name` varchar(100) NOT NULL,
  `b_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_purok`
--

INSERT INTO `tbl_purok` (`p_id`, `p_name`, `b_id`) VALUES
(1, 'Tambis', 1001),
(2, 'Mahogany', 1001),
(3, 'Guyabano', 1001),
(4, 'Ipil-Ipil', 1001);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_residents`
--

CREATE TABLE `tbl_residents` (
  `r_id` int(10) NOT NULL,
  `r_lname` varchar(100) NOT NULL,
  `r_fname` varchar(100) NOT NULL,
  `r_mname` varchar(100) NOT NULL,
  `r_address` varchar(200) NOT NULL,
  `r_sex` varchar(50) NOT NULL,
  `r_dob` date NOT NULL,
  `r_civilstatus` varchar(100) NOT NULL,
  `r_occupation` varchar(100) NOT NULL,
  `r_religion` varchar(100) NOT NULL,
  `h_id` int(10) NOT NULL,
  `r_image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_residents`
--

INSERT INTO `tbl_residents` (`r_id`, `r_lname`, `r_fname`, `r_mname`, `r_address`, `r_sex`, `r_dob`, `r_civilstatus`, `r_occupation`, `r_religion`, `h_id`, `r_image`) VALUES
(1001, 'Abendan', 'Christian James', 'Arquilos', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-24', 'Single', 'Broke', 'Catholic', 1, 'src/r_images/sample3.jpg'),
(1002, 'Ignacio', 'Roger', 'Quimson', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2001-05-07', 'Single', 'Adunis Dancer', 'Born for you', 1, 'src/r_images/sample.jpg'),
(1003, 'Perez', 'Emmett', 'Limbudan', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '1969-08-08', 'Widowed', 'Investor', 'Catholic', 1, 'src/r_images/sample2.jpg'),
(1004, 'Esquivias', 'Fernando Alvar', 'Ciocon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '1969-05-16', 'Married', 'Investor', 'Catholic', 1, 'src/r_images/sample1.jpg'),
(1005, 'End', 'The', 'Week', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '1990-02-16', 'Single', 'Singer', 'None', 1, 'src/u_images/sample4.jpg'),
(1006, 'Arabejo', 'Haylie', 'Quiocson', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2000-05-19', 'Single', 'Student', 'Catholic', 1, 'src/u_images/sample5.jpg'),
(1007, 'Purisima', 'Marcy', 'Kendra', 'Pob. Ward II, MInglanilla, Cebu', 'Female', '1998-03-12', 'Single', 'Influencer', 'Born to be wild', 1, 'src/u_images/marcy_kendra.jpg'),
(1008, 'Romano', 'David Sailas', 'Villondo', 'Lower, Lipata,Minglanilla, Cebu. ', 'Male', '2003-02-10', 'Single', 'Student', 'Born Again', 1, 'src/u_default/blank_pfp.jpg');

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
  `u_image` varchar(250) NOT NULL,
  `u_code` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_usn`, `u_pass`, `u_type`, `u_status`, `u_image`, `u_code`) VALUES
(1001, 'Christian James', 'Abendan', 'chrisbend2004@gmail.com', 'cjabendan', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_images/chan2.jpg', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe'),
(1002, 'David Sailas', 'Villondo', 'chebry@gmail.com', 'dasai', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1003, 'Vince Micheal', 'Bacarisas', 'bensoy@gmail.com', 'bensoy', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1004, 'John Michael', 'Dela Cuesta', 'jeym@gmail.com', 'jeym', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1005, 'Emman', 'Bas', 'emmanbas@gmail.com', 'wais.', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_images/emman_bas.jpg', ''),
(1006, 'Ariane Jae', 'Bas', 'aj@gmail.com', 'inu', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1007, 'Briane Jae', 'Bas', 'bj@gmail.com', 'brinap', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1008, 'Angel Faith', 'Abendan', 'angel@gmail.com', 'apay', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1009, 'Rhovella', 'Abendan', 'ruby@gmail.com', 'ruby85', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1010, 'Rommel', 'Abendan', 'rommel@gmail.com', 'romeo', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1011, 'Nathaniel', 'Manto', 'nath@gmail.com', 'nath', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1012, 'Mark Ken', 'Purisima', 'kenpurisima@gmail.com', 'markky', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1013, 'Brylle Justin', 'Herminio', 'byrllenio@gmail.com', 'matjuks', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1014, 'MIchelle', 'Abendan', 'micth@gmail.com', 'mitch', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1015, 'try', 'try', 'try@g.com', 'try', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1016, 'a', 'a', 'a@gmail.com', 'a', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_barangay`
--
ALTER TABLE `tbl_barangay`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `tbl_household`
--
ALTER TABLE `tbl_household`
  ADD PRIMARY KEY (`h_id`),
  ADD KEY `p_id` (`p_id`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`l_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `tbl_purok`
--
ALTER TABLE `tbl_purok`
  ADD PRIMARY KEY (`p_id`),
  ADD KEY `b_id` (`b_id`);

--
-- Indexes for table `tbl_residents`
--
ALTER TABLE `tbl_residents`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `h_id` (`h_id`);

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
  MODIFY `b_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- AUTO_INCREMENT for table `tbl_household`
--
ALTER TABLE `tbl_household`
  MODIFY `h_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_purok`
--
ALTER TABLE `tbl_purok`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_residents`
--
ALTER TABLE `tbl_residents`
  MODIFY `r_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1009;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1017;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_household`
--
ALTER TABLE `tbl_household`
  ADD CONSTRAINT `tbl_household_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `tbl_purok` (`p_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `tbl_logs_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_purok`
--
ALTER TABLE `tbl_purok`
  ADD CONSTRAINT `tbl_purok_ibfk_2` FOREIGN KEY (`b_id`) REFERENCES `tbl_barangay` (`b_id`);

--
-- Constraints for table `tbl_residents`
--
ALTER TABLE `tbl_residents`
  ADD CONSTRAINT `tbl_residents_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `tbl_household` (`h_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
