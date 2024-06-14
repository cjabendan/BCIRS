-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2024 at 03:39 AM
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
(1001, 'Pob. Ward II', 'Minglanilla, Cebu', 13);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_household`
--

CREATE TABLE `tbl_household` (
  `h_id` int(10) NOT NULL,
  `h_name` varchar(100) NOT NULL,
  `h_address` varchar(150) NOT NULL,
  `p_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_household`
--

INSERT INTO `tbl_household` (`h_id`, `h_name`, `h_address`, `p_id`) VALUES
(1, 'HN. 01', 'Gimenez Street', 1),
(2, 'HN. 02', 'Gimenez Street', 1),
(3, 'HN. 03', 'Lopez Street', 2),
(4, 'HN. 04', 'Lopez Street', 2),
(5, 'HN. 05', 'Patricio Aleman', 3),
(6, 'HN. 06', 'Patricio Aleman', 3),
(7, 'HN. 07', 'Ward II Road', 4),
(8, 'HN. 08', 'Ward II Road', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `l_id` int(10) NOT NULL,
  `l_timestamp` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `l_event` varchar(500) NOT NULL,
  `u_id` int(10) NOT NULL,
  `l_description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`l_id`, `l_timestamp`, `l_event`, `u_id`, `l_description`) VALUES
(1, '2024-05-29 16:01:36', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(2, '2024-05-29 16:06:48', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(3, '2024-05-29 16:08:33', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(4, '2024-05-29 16:09:34', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(5, '2024-05-29 16:20:14', 'USER_REGISTRATION', 1018, 'User registered successfully'),
(6, '2024-05-29 16:20:29', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(7, '2024-05-29 18:31:45', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(8, '2024-05-29 20:12:40', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(9, '2024-05-29 20:23:04', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(10, '2024-05-29 20:25:14', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(11, '2024-05-29 20:26:01', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(12, '2024-05-29 20:30:16', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(13, '2024-05-29 20:32:00', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(14, '2024-05-29 20:35:43', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(15, '2024-05-29 20:37:11', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(16, '2024-05-29 20:38:00', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(17, '2024-05-29 20:38:32', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(18, '2024-05-29 20:51:53', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(19, '2024-05-29 20:52:58', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(20, '2024-05-29 20:55:08', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(21, '2024-05-29 20:56:42', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(22, '2024-05-29 20:57:48', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(23, '2024-05-29 21:06:09', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(24, '2024-05-29 21:08:26', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(25, '2024-05-29 21:11:14', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(26, '2024-05-29 21:13:10', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(27, '2024-05-30 07:10:19', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(28, '2024-05-30 07:11:18', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(29, '2024-05-30 07:12:03', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(30, '2024-05-30 07:18:02', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(31, '2024-05-30 07:28:45', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(32, '2024-05-30 07:29:30', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(33, '2024-05-30 07:33:54', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(34, '2024-05-30 07:49:29', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(35, '2024-05-30 07:49:37', 'EXPORT_USER_DATA', 1001, 'Admin exported user data to PDF: ada.pdf'),
(36, '2024-05-30 08:43:40', 'PASSWORD_RESET', 1001, 'User password has been reset'),
(37, '2024-05-30 08:43:54', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(38, '2024-05-30 08:58:33', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(39, '2024-05-30 09:08:31', 'LOGOUT', 1001, 'User logged out'),
(40, '2024-05-30 09:08:41', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(41, '2024-05-30 09:11:07', 'LOGOUT', 1001, 'User logged out'),
(42, '2024-05-30 09:40:29', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(43, '2024-05-30 09:42:12', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(44, '2024-05-30 09:42:57', 'LOGOUT', 1001, 'User logged out'),
(45, '2024-05-30 09:43:06', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(46, '2024-05-30 10:05:20', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(47, '2024-05-30 10:05:27', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(48, '2024-05-30 10:06:19', 'LOGOUT', 1001, 'User logged out'),
(49, '2024-05-30 10:12:30', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(50, '2024-05-30 10:14:28', 'USER_REGISTRATION', 1001, 'New user registered. User ID: 1019'),
(51, '2024-05-30 10:18:14', 'LOGOUT', 1001, 'User logged out'),
(52, '2024-05-30 10:26:13', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(53, '2024-05-30 10:27:24', 'USER_DATA_UPDATE', 1001, 'User: 1015 data updated by admin'),
(54, '2024-05-30 11:00:02', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(55, '2024-05-30 11:00:09', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(56, '2024-05-30 11:02:29', 'LOGOUT', 1001, 'User logged out'),
(57, '2024-05-30 11:25:58', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(58, '2024-05-30 11:26:03', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(59, '2024-05-30 11:26:52', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(60, '2024-05-30 11:27:57', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(61, '2024-05-30 11:28:24', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(62, '2024-05-30 11:29:49', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(63, '2024-05-30 11:31:25', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(64, '2024-05-30 14:19:26', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(65, '2024-05-30 14:21:52', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(66, '2024-05-30 14:21:59', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(67, '2024-05-30 14:25:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(68, '2024-05-30 14:27:49', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(69, '2024-05-30 14:28:30', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(70, '2024-05-30 14:28:35', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(71, '2024-05-31 08:35:19', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(72, '2024-05-31 08:35:30', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(73, '2024-05-31 08:35:44', 'USER_DATA_UPDATE', 1001, 'User: 1006 data updated by admin'),
(74, '2024-05-31 08:35:54', 'USER_DATA_UPDATE', 1001, 'User: 1007 data updated by admin'),
(75, '2024-05-31 08:59:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(76, '2024-05-31 09:26:46', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(77, '2024-05-31 09:28:45', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(78, '2024-05-31 10:01:28', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(79, '2024-05-31 10:02:06', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(80, '2024-05-31 10:22:21', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(81, '2024-05-31 10:25:38', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(82, '2024-05-31 10:29:11', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(83, '2024-05-31 10:30:54', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(84, '2024-05-31 10:34:07', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(85, '2024-05-31 10:34:48', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(86, '2024-05-31 10:35:07', 'USER_DATA_UPDATE', 1001, 'User: 1009 data updated by admin'),
(87, '2024-05-31 10:35:16', 'USER_DATA_UPDATE', 1001, 'User: 1010 data updated by admin'),
(88, '2024-05-31 10:39:24', 'ADMIN_USER_REGISTRATION', 1001, 'New user registered. User ID: 1020'),
(89, '2024-05-31 13:35:29', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(90, '2024-05-31 13:36:07', 'LOGIN_FAILURE', 1005, 'Invalid username or password'),
(91, '2024-05-31 13:36:13', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(92, '2024-05-31 13:36:45', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(93, '2024-05-31 13:39:59', 'LOGIN_FAILURE', 1005, 'Invalid username or password'),
(94, '2024-05-31 13:40:05', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(95, '2024-05-31 13:40:39', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(96, '2024-05-31 13:51:58', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(97, '2024-05-31 13:52:24', 'EXPORT_USER_DATA', 1001, 'Admin exported User: 1001 data.'),
(98, '2024-05-31 13:56:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(99, '2024-05-31 15:42:29', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(100, '2024-05-31 15:57:56', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(101, '2024-05-31 15:59:11', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(102, '2024-05-31 21:40:25', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(103, '2024-05-31 21:43:03', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(104, '2024-05-31 21:51:22', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(105, '2024-05-31 22:02:21', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(106, '2024-05-31 22:09:30', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(107, '2024-05-31 22:10:22', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(108, '2024-05-31 22:15:58', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(109, '2024-05-31 22:19:31', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(110, '2024-05-31 22:20:21', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(111, '2024-05-31 22:20:42', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(112, '2024-05-31 22:30:12', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(113, '2024-06-01 08:44:45', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(114, '2024-06-01 08:45:39', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(115, '2024-06-01 08:47:32', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(116, '2024-06-01 08:53:23', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(117, '2024-06-01 09:17:18', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(118, '2024-06-01 09:18:45', 'LOGOUT', 1001, 'User logged out'),
(119, '2024-06-01 09:32:23', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(120, '2024-06-01 09:37:49', 'USER_DATA_UPDATE', 1001, 'User: 1017 data updated by admin'),
(121, '2024-06-01 09:47:07', 'USER_DATA_UPDATE', 1001, 'User: 1018 data updated by admin'),
(122, '2024-06-01 09:48:32', 'USER_DATA_UPDATE', 1001, 'User: 1019 data updated by admin'),
(123, '2024-06-01 09:50:13', 'LOGOUT', 1001, 'User logged out'),
(124, '2024-06-01 10:14:12', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(125, '2024-06-01 10:27:34', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(126, '2024-06-01 10:30:40', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(127, '2024-06-01 10:33:41', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(128, '2024-06-01 10:38:40', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(129, '2024-06-01 10:40:24', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(130, '2024-06-01 10:41:21', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(131, '2024-06-01 10:42:56', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(132, '2024-06-01 10:56:24', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(133, '2024-06-01 11:01:23', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(134, '2024-06-01 11:02:37', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(135, '2024-06-01 11:08:55', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(136, '2024-06-01 11:10:54', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(137, '2024-06-01 11:15:53', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(138, '2024-06-01 11:16:02', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(139, '2024-06-01 11:18:09', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(140, '2024-06-01 11:20:53', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(141, '2024-06-01 11:28:29', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(142, '2024-06-01 11:29:16', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(143, '2024-06-01 13:02:24', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(144, '2024-06-01 13:14:57', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(145, '2024-06-01 13:15:41', 'RESIDENT_DATA_UPDATE', 1001, 'Resident: 1110 data is updated by admin'),
(146, '2024-06-01 13:39:06', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(147, '2024-06-01 13:39:15', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(148, '2024-06-01 13:40:54', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(149, '2024-06-01 13:41:33', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(150, '2024-06-01 13:42:33', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(151, '2024-06-01 15:45:28', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(152, '2024-06-01 15:46:07', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(153, '2024-06-01 15:47:27', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(154, '2024-06-01 15:48:43', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(155, '2024-06-01 15:49:09', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(156, '2024-06-01 15:50:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(157, '2024-06-01 15:54:51', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(158, '2024-06-02 09:09:21', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(159, '2024-06-02 09:10:44', 'LOGOUT', 1001, 'User logged out'),
(160, '2024-06-02 09:11:05', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(161, '2024-06-02 09:12:26', 'LOGOUT', 1001, 'User logged out'),
(162, '2024-06-02 09:12:33', 'LOGIN_FAILURE', 1005, 'Invalid username or password'),
(163, '2024-06-02 09:12:35', 'LOGIN_FAILURE', 1005, 'Invalid username or password'),
(164, '2024-06-02 09:12:40', 'LOGIN_FAILURE', 1005, 'Invalid username or password'),
(165, '2024-06-02 09:12:52', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(166, '2024-06-02 09:18:36', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(167, '2024-06-02 09:20:15', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(168, '2024-06-02 09:21:04', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(169, '2024-06-02 09:22:18', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(170, '2024-06-02 09:49:25', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(171, '2024-06-02 09:53:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(172, '2024-06-02 09:56:16', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(173, '2024-06-02 09:57:03', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(174, '2024-06-02 09:59:14', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(175, '2024-06-02 10:00:11', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(176, '2024-06-02 10:00:55', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(177, '2024-06-02 10:02:39', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(178, '2024-06-02 10:06:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(179, '2024-06-02 10:11:44', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(180, '2024-06-02 10:15:54', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(181, '2024-06-02 10:18:57', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(182, '2024-06-02 10:19:00', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(183, '2024-06-02 10:19:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(184, '2024-06-02 10:20:07', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(185, '2024-06-02 10:20:07', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(186, '2024-06-02 10:20:17', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(187, '2024-06-02 10:24:15', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(188, '2024-06-02 10:24:38', 'EXPORT_USER_DATA', 1001, 'Admin exported User: 1001 data.'),
(189, '2024-06-02 10:31:13', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(190, '2024-06-02 10:31:58', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(191, '2024-06-02 10:34:58', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(192, '2024-06-02 10:34:58', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(193, '2024-06-02 10:35:03', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(194, '2024-06-02 10:35:04', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(195, '2024-06-02 10:35:10', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(196, '2024-06-02 10:46:54', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(197, '2024-06-02 10:51:04', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(198, '2024-06-02 10:55:03', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(199, '2024-06-02 11:02:34', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(200, '2024-06-02 11:04:30', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(201, '2024-06-02 11:04:31', 'LOGOUT', 1001, 'User logged out'),
(202, '2024-06-02 11:04:39', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(203, '2024-06-02 13:28:24', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(204, '2024-06-02 13:29:35', 'LOGOUT', 1001, 'User logged out'),
(205, '2024-06-02 13:29:42', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(206, '2024-06-02 13:32:02', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(207, '2024-06-02 14:04:50', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(208, '2024-06-02 14:09:47', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(209, '2024-06-02 14:10:13', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(210, '2024-06-02 14:10:42', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(211, '2024-06-02 15:07:12', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(212, '2024-06-02 15:15:25', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(213, '2024-06-02 15:17:09', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(214, '2024-06-02 15:19:57', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(215, '2024-06-02 15:20:43', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(216, '2024-06-02 15:51:46', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(217, '2024-06-02 15:51:47', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(218, '2024-06-02 15:53:05', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(219, '2024-06-02 15:57:15', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(220, '2024-06-02 16:00:39', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(221, '2024-06-03 07:40:16', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(222, '2024-06-03 07:41:16', 'LOGOUT', 1001, 'User logged out'),
(223, '2024-06-03 07:41:24', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(224, '2024-06-03 07:43:57', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(225, '2024-06-03 07:45:25', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(226, '2024-06-03 07:46:03', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(227, '2024-06-03 07:46:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(228, '2024-06-03 07:47:06', 'LOGOUT', 1001, 'User logged out'),
(229, '2024-06-03 07:59:31', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(230, '2024-06-03 08:02:53', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(231, '2024-06-03 08:06:59', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(232, '2024-06-03 08:16:01', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(233, '2024-06-03 08:21:49', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(234, '2024-06-03 08:23:37', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(235, '2024-06-03 09:41:00', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(236, '2024-06-03 10:41:30', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(237, '2024-06-03 15:24:11', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(238, '2024-06-03 15:24:33', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(239, '2024-06-03 18:30:40', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(240, '2024-06-03 18:32:55', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(241, '2024-06-03 18:36:54', 'LOGOUT', 1001, 'User logged out'),
(242, '2024-06-03 18:37:09', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(243, '2024-06-03 18:37:30', 'LOGOUT', 1001, 'User logged out'),
(244, '2024-06-04 12:15:45', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(245, '2024-06-04 12:47:56', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(246, '2024-06-05 10:39:26', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(247, '2024-06-06 08:29:53', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(248, '2024-06-06 08:30:08', 'USER_DATA_ARCHIVED', 1001, 'User: 1002 data is archived by admin'),
(249, '2024-06-06 08:33:51', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(250, '2024-06-06 08:34:06', 'USER_DATA_UPDATE', 1001, 'User: 1014 data is updated by admin'),
(251, '2024-06-06 08:55:04', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(252, '2024-06-06 08:55:52', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(253, '2024-06-06 08:57:40', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(254, '2024-06-06 08:59:11', 'USER_DATA_UPDATE', 1001, 'User: 1016 data is updated by admin'),
(255, '2024-06-06 09:01:11', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(256, '2024-06-06 09:01:38', 'LOGOUT', 1001, 'User logged out'),
(257, '2024-06-06 09:04:42', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(258, '2024-06-06 09:06:03', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(259, '2024-06-06 09:39:40', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(260, '2024-06-06 09:40:40', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(261, '2024-06-06 09:42:03', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(262, '2024-06-06 09:42:47', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(263, '2024-06-06 09:43:15', 'LOGOUT', 1001, 'User logged out'),
(264, '2024-06-06 09:44:51', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(265, '2024-06-06 09:45:54', 'USER_DATA_ARCHIVED', 1001, 'User: 1020 data is archived by admin'),
(266, '2024-06-06 09:54:43', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(267, '2024-06-06 09:55:02', 'USER_UNARCHIVED', 1001, 'User: 1020 data is unarchived by admin'),
(268, '2024-06-06 09:58:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(269, '2024-06-06 09:58:16', 'USER_ARCHIVED', 1001, 'User: 1020 data is archived by admin'),
(270, '2024-06-06 10:18:11', 'USER_UNARCHIVED', 1001, 'User: 1020 data is unarchived by admin'),
(271, '2024-06-06 10:18:16', 'LOGOUT', 1001, 'User logged out'),
(272, '2024-06-06 10:18:43', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(273, '2024-06-06 10:18:58', 'USER_DATA_UPDATE', 1001, 'User: 1020 data is updated by admin'),
(274, '2024-06-06 10:19:06', 'USER_ARCHIVED', 1001, 'User: 1020 data is archived by admin'),
(275, '2024-06-06 10:22:06', 'USER_UNARCHIVED', 1001, 'User: 1002 data is unarchived by admin'),
(276, '2024-06-06 10:23:25', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(277, '2024-06-06 10:23:34', 'USER_ARCHIVED', 1001, 'User: 1002 data is archived by admin'),
(278, '2024-06-06 10:23:50', 'USER_ARCHIVED', 1001, 'User: 1011 data is archived by admin'),
(279, '2024-06-06 10:24:00', 'USER_UNARCHIVED', 1001, 'User: 1002 data is unarchived by admin'),
(280, '2024-06-06 10:24:13', 'LOGOUT', 1001, 'User logged out'),
(281, '2024-06-06 10:36:34', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(282, '2024-06-06 10:39:51', 'LOGOUT', 1001, 'User logged out'),
(283, '2024-06-06 11:01:37', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(284, '2024-06-06 11:17:13', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(285, '2024-06-06 12:06:24', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(286, '2024-06-06 12:14:47', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(287, '2024-06-06 12:15:49', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(288, '2024-06-06 12:17:00', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(289, '2024-06-06 12:17:15', 'RESIDENT_ARCHIVED', 1001, 'User: 1125 data is archived by admin.'),
(290, '2024-06-06 12:17:31', 'LOGOUT', 1001, 'User logged out'),
(291, '2024-06-06 12:21:52', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(292, '2024-06-06 12:22:12', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(293, '2024-06-06 12:25:56', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(294, '2024-06-06 12:27:03', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(295, '2024-06-06 12:27:32', 'LOGOUT', 1001, 'User logged out'),
(296, '2024-06-06 12:30:58', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(297, '2024-06-06 12:53:10', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(298, '2024-06-06 12:53:37', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(299, '2024-06-06 12:56:30', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(300, '2024-06-06 12:59:30', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(301, '2024-06-06 12:59:45', 'LOGOUT', 1001, 'User logged out'),
(302, '2024-06-06 12:59:52', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(303, '2024-06-06 13:01:40', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(304, '2024-06-06 13:05:19', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(305, '2024-06-06 13:05:30', 'LOGOUT', 1001, 'User logged out'),
(306, '2024-06-06 13:05:37', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(307, '2024-06-06 13:10:22', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(308, '2024-06-06 13:10:25', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(309, '2024-06-06 13:10:35', 'LOGOUT', 1001, 'User logged out'),
(310, '2024-06-06 13:11:48', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(311, '2024-06-06 13:12:27', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(312, '2024-06-06 13:12:43', 'LOGOUT', 1001, 'User logged out'),
(313, '2024-06-06 13:16:47', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(314, '2024-06-06 13:17:55', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(315, '2024-06-06 13:18:26', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(316, '2024-06-06 13:18:39', 'LOGOUT', 1001, 'User logged out'),
(317, '2024-06-06 16:55:34', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(318, '2024-06-06 16:57:41', 'LOGIN_SUCCESS', 1005, 'User logged in successfully'),
(319, '2024-06-07 08:28:24', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(320, '2024-06-07 08:37:47', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(321, '2024-06-07 08:38:16', 'LOGOUT', 1001, 'User logged out'),
(322, '2024-06-07 08:39:29', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(323, '2024-06-07 08:40:35', 'LOGOUT', 1001, 'User logged out'),
(324, '2024-06-07 08:40:56', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(325, '2024-06-07 08:41:28', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(326, '2024-06-07 08:42:14', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(327, '2024-06-07 08:42:22', 'LOGOUT', 1001, 'User logged out'),
(328, '2024-06-07 08:42:40', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(329, '2024-06-07 08:43:40', 'LOGOUT', 1001, 'User logged out'),
(330, '2024-06-07 08:59:19', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(331, '2024-06-07 09:39:39', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(332, '2024-06-07 09:39:44', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(333, '2024-06-07 09:40:03', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(334, '2024-06-07 09:42:28', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(335, '2024-06-07 09:44:32', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(336, '2024-06-07 09:44:32', 'LOGIN_FAILURE', 1001, 'Invalid username or password'),
(337, '2024-06-07 09:44:37', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(338, '2024-06-07 09:46:12', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(339, '2024-06-07 09:50:30', 'LOGOUT', 1001, 'User logged out'),
(340, '2024-06-07 10:17:08', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(341, '2024-06-07 10:20:28', 'LOGOUT', 1001, 'User logged out'),
(342, '2024-06-07 10:20:41', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(343, '2024-06-07 10:27:11', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(344, '2024-06-07 10:29:40', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(345, '2024-06-07 10:33:27', 'LOGOUT', 1001, 'User logged out'),
(346, '2024-06-07 10:34:13', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(347, '2024-06-07 10:34:47', 'LOGOUT', 1001, 'User logged out'),
(348, '2024-06-07 10:36:32', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(349, '2024-06-07 10:37:27', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(350, '2024-06-07 10:38:13', 'LOGOUT', 1001, 'User logged out'),
(351, '2024-06-07 10:38:27', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(352, '2024-06-07 10:41:48', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(353, '2024-06-07 10:42:05', 'EXPORT_USER_DATA', 1001, 'Admin exported User: 1005 data.'),
(354, '2024-06-07 10:59:52', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(355, '2024-06-07 11:06:41', 'LOGOUT', 1001, 'User logged out'),
(356, '2024-06-07 11:06:50', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(357, '2024-06-07 11:12:14', 'LOGOUT', 1001, 'User logged out'),
(358, '2024-06-07 11:14:17', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(359, '2024-06-07 11:14:54', 'LOGOUT', 1001, 'User logged out'),
(360, '2024-06-07 11:21:43', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(361, '2024-06-07 11:23:06', 'LOGOUT', 1001, 'User logged out'),
(362, '2024-06-07 11:25:13', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(363, '2024-06-07 11:25:23', 'LOGOUT', 1001, 'User logged out'),
(364, '2024-06-07 11:25:59', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(365, '2024-06-07 11:27:47', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(366, '2024-06-07 11:29:17', 'LOGOUT', 1001, 'User logged out'),
(367, '2024-06-07 11:35:40', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(368, '2024-06-07 11:36:25', 'LOGOUT', 1001, 'User logged out'),
(369, '2024-06-07 12:12:31', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(370, '2024-06-07 12:13:38', 'LOGOUT', 1001, 'User logged out'),
(371, '2024-06-07 12:16:21', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(372, '2024-06-07 12:18:11', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(373, '2024-06-07 12:19:06', 'LOGOUT', 1001, 'User logged out'),
(374, '2024-06-07 12:22:40', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(375, '2024-06-07 12:24:33', 'LOGOUT', 1001, 'User logged out'),
(376, '2024-06-07 15:16:45', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(377, '2024-06-07 15:18:56', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(378, '2024-06-07 15:22:56', 'LOGOUT', 1001, 'User logged out'),
(379, '2024-06-07 15:53:50', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(380, '2024-06-09 09:05:32', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(381, '2024-06-09 09:06:23', 'LOGOUT', 1001, 'User logged out'),
(382, '2024-06-09 09:07:57', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(383, '2024-06-09 09:09:20', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(384, '2024-06-09 09:09:58', 'LOGOUT', 1001, 'User logged out'),
(385, '2024-06-10 14:01:42', 'LOGIN_SUCCESS', 1001, 'Admin logged in successfully'),
(386, '2024-06-10 14:05:31', 'LOGOUT', 1001, 'User logged out'),
(387, '2024-06-10 14:05:41', 'LOGIN_SUCCESS', 1005, 'User logged in successfully');

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
-- Table structure for table `tbl_request`
--

CREATE TABLE `tbl_request` (
  `Re_id` varchar(255) NOT NULL,
  `Re_doc_type` varchar(255) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `r_id` int(11) DEFAULT NULL,
  `Re_dateissued` date NOT NULL,
  `Re_purpose` varchar(255) DEFAULT NULL,
  `Re_status` varchar(50) DEFAULT NULL,
  `Re_action` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `r_dob` date DEFAULT NULL,
  `r_civilstatus` varchar(100) NOT NULL,
  `r_occupation` varchar(100) NOT NULL,
  `r_religion` varchar(100) NOT NULL,
  `h_id` int(10) NOT NULL,
  `r_image` varchar(200) NOT NULL,
  `r_status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_residents`
--

INSERT INTO `tbl_residents` (`r_id`, `r_lname`, `r_fname`, `r_mname`, `r_address`, `r_sex`, `r_dob`, `r_civilstatus`, `r_occupation`, `r_religion`, `h_id`, `r_image`, `r_status`) VALUES
(1121, 'Smith', 'John', 'Michael', '123 Main St. Anytown, CA 12345', 'Male', '1980-01-01', 'Married', 'Doctor', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(1122, 'Johnson', 'Jane', 'Anne', '456 Elm St. Anytown, CA 12345', 'Female', '1985-02-14', 'Single', 'Teacher', 'Christian', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(1123, 'Lee', 'David', 'William', '789 Maple St. Anytown, CA 12345', 'Male', '1970-12-25', 'Single', 'Engineer', 'Muslim', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(1124, 'Abendan', 'Christian James', 'Arquilos', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-27', 'Single', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(1125, 'Villondo', 'David Sailas', 'Romano', 'Lipata, Minglanilla, Cebu', 'Male', '2003-02-10', 'Married', 'Student', 'Born Again', 2, 'src/u_default/blank_pfp.jpg', 'Archived'),
(1126, 'Plameran', 'John Bert', 'Decena', 'Lipata, Minglanilla, Cebu', 'Male', '2003-07-10', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active');

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
(1002, 'David Sailas', 'Villondo', 'chebry@gmail.com', 'dasai', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1003, 'Vince Micheal', 'Bacarisas', 'bensoy@gmail.com', 'bensoy', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1004, 'John Michael', 'Dela Cuesta', 'jeym@gmail.com', 'jeym', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1005, 'Emman', 'Bas', 'emmanbas@gmail.com', 'wais.', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_images/emman_bas.jpg', ''),
(1006, 'Ariane Jae', 'Bas', 'aj@gmail.com', 'inu', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1007, 'Briane Jae', 'Bas', 'bj@gmail.com', 'brinap', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1008, 'Angel Faith', 'Abendan', 'angel@gmail.com', 'apay', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1009, 'Rhovella', 'Abendan', 'ruby@gmail.com', 'ruby85', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1010, 'Rommel', 'Abendan', 'rommel@gmail.com', 'romeo', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1011, 'Nathaniel', 'Manto', 'nath@gmail.com', 'nath', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Archived', 'src/u_default/blank_pfp.jpg', ''),
(1012, 'Mark Ken', 'Purisima', 'kenpurisima@gmail.com', 'markky', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1013, 'Brylle Justin', 'Herminio', 'byrllenio@gmail.com', 'matjuks', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1014, 'Michelle', 'Abendan', 'micth@gmail.com', 'mitch', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1015, 'Maleah', 'Delcinea', 'delcinea@gmail.com', 'maleah', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1016, 'Levi', 'Jimenez', 'ackerman@gmail.com', 'levi', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1017, 'Kirk', 'Cerinza', 'kirk@gmail.com', 'kirk', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1018, 'Noah', 'Galleros', 'noah@gmail.com', 'noah', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Pending', 'src/u_default/blank_pfp.jpg', ''),
(1019, 'Triston', 'Manalo', 'trist@gmail.com', 'trist', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_default/blank_pfp.jpg', ''),
(1020, 'Jaric', 'Delima', 'delimaj@gmail.com', 'jaric', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Archived', 'src/u_default/blank_pfp.jpg', '');

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
-- Indexes for table `tbl_request`
--
ALTER TABLE `tbl_request`
  ADD PRIMARY KEY (`Re_id`);

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
  MODIFY `h_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=388;

--
-- AUTO_INCREMENT for table `tbl_purok`
--
ALTER TABLE `tbl_purok`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_residents`
--
ALTER TABLE `tbl_residents`
  MODIFY `r_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1127;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1021;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
