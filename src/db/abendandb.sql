-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2024 at 12:24 PM
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
(1001, 'Pob. Ward II', 'Minglanilla, Cebu', 9);

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
(2, 'HN. 02', 'Gimenez Street', 2),
(3, 'HN. 03', 'Lopez Street', 3),
(4, 'HN. 04', 'Lopez Street', 4),
(5, 'HN. 05', 'Patricio Aleman', 5),
(6, 'HN. 06', 'Patricio Aleman', 6),
(7, 'HN. 07', 'Ward II Road', 7),
(8, 'HN. 08', 'Ward II Road', 4),
(12, 'HN. 09', 'Pob. Ward II, MInglanilla, Cebu', 5),
(13, 'HN. 10', 'Pob. Ward II, MInglanilla, Cebu', 5),
(14, 'HN. 11', 'Pob. Ward II, Minglanilla, Cebu', 6),
(15, 'HN. 11', 'Pob. Ward II, Minglanilla, Cebu', 6),
(16, 'HN. 12', 'Pob. Ward II, MInglanilla, Cebu', 7);

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
(1387, '2024-11-26 17:11:00', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1388, '2024-11-26 17:11:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1389, '2024-11-26 17:11:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1390, '2024-11-26 17:11:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1391, '2024-11-26 17:11:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1392, '2024-11-26 17:11:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1393, '2024-11-26 17:11:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1394, '2024-11-26 17:11:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1395, '2024-11-26 17:13:47', 'LOGOUT', 1022, 'User logged out'),
(1396, '2024-11-26 17:13:55', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1397, '2024-11-26 17:14:09', 'LOGOUT', 1021, 'User logged out'),
(1398, '2024-11-27 12:16:06', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1399, '2024-11-27 12:18:21', 'LOGOUT', 1022, 'User logged out'),
(1400, '2024-11-28 21:24:43', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1401, '2024-11-28 21:27:46', 'LOGOUT', 1022, 'User logged out'),
(1402, '2024-11-28 21:38:53', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1403, '2024-11-28 21:39:21', 'LOGOUT', 1022, 'User logged out'),
(1404, '2024-11-28 21:47:23', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1405, '2024-11-28 21:47:40', 'LOGOUT', 1022, 'User logged out'),
(1406, '2024-11-28 21:49:37', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1407, '2024-11-28 21:50:28', 'LOGOUT', 1022, 'User logged out'),
(1408, '2024-11-28 21:56:17', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1409, '2024-11-28 21:56:35', 'LOGOUT', 1022, 'User logged out'),
(1410, '2024-11-28 21:57:05', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1411, '2024-11-28 21:57:11', 'LOGOUT', 1022, 'User logged out'),
(1412, '2024-11-28 21:58:11', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1413, '2024-11-28 21:58:38', 'LOGOUT', 1022, 'User logged out'),
(1414, '2024-11-28 21:59:22', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1415, '2024-11-28 21:59:40', 'LOGOUT', 1022, 'User logged out'),
(1416, '2024-11-28 21:59:54', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1417, '2024-11-28 22:00:07', 'LOGOUT', 1022, 'User logged out'),
(1418, '2024-11-28 22:00:51', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1419, '2024-11-28 22:01:11', 'LOGOUT', 1022, 'User logged out'),
(1420, '2024-11-28 22:14:37', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1421, '2024-11-28 22:14:52', 'LOGOUT', 1022, 'User logged out'),
(1422, '2024-11-28 22:15:32', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1423, '2024-11-28 22:16:35', 'LOGOUT', 1022, 'User logged out'),
(1424, '2024-11-28 22:17:25', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1425, '2024-11-28 22:17:57', 'LOGOUT', 1021, 'User logged out'),
(1426, '2024-11-28 22:20:06', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1427, '2024-11-28 22:20:54', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1428, '2024-11-28 22:21:11', 'LOGOUT', 1021, 'User logged out'),
(1429, '2024-11-28 22:21:49', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1430, '2024-11-28 22:22:13', 'LOGOUT', 1021, 'User logged out'),
(1431, '2024-11-28 22:22:57', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1432, '2024-11-28 22:23:47', 'LOGOUT', 1021, 'User logged out'),
(1433, '2024-11-28 22:29:11', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1434, '2024-11-28 22:29:35', 'RESIDENT ARCHIVED', 1022, 'Resident ID: 2865 data is archived by user.'),
(1435, '2024-11-28 22:29:44', 'USER_UNARCHIVED', 1022, 'User: 2865 data is unarchived by admin'),
(1436, '2024-11-28 22:29:52', 'RESIDENT ARCHIVED', 1022, 'Resident ID: 2866 data is archived by user.'),
(1437, '2024-11-28 22:30:18', 'LOGOUT', 1022, 'User logged out'),
(1438, '2024-11-28 22:42:47', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1439, '2024-11-28 22:43:01', 'LOGOUT', 1021, 'User logged out'),
(1440, '2024-11-28 22:43:09', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1441, '2024-11-28 22:44:04', 'LOGOUT', 1022, 'User logged out'),
(1442, '2024-11-28 22:45:53', 'LOGOUT', 1021, 'User logged out'),
(1443, '2024-11-28 22:46:02', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1444, '2024-11-28 22:50:55', 'LOGIN_FAILURE', 1022, 'Invalid username or password'),
(1445, '2024-11-28 22:51:00', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1446, '2024-11-28 22:51:20', 'LOGOUT', 1022, 'User logged out'),
(1447, '2024-11-28 22:51:46', 'LOGIN_FAILURE', 1022, 'Invalid username or password'),
(1448, '2024-11-28 22:51:53', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1449, '2024-11-28 22:52:07', 'LOGOUT', 1022, 'User logged out'),
(1450, '2024-11-28 22:52:36', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1451, '2024-11-28 22:53:05', 'LOGOUT', 1022, 'User logged out'),
(1452, '2024-11-28 22:53:33', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1453, '2024-11-28 22:53:54', 'LOGOUT', 1022, 'User logged out'),
(1454, '2024-11-28 22:54:56', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1455, '2024-11-28 22:55:03', 'USER_UNARCHIVED', 1022, 'User: 2866 data is unarchived by admin'),
(1456, '2024-11-28 22:55:06', 'LOGOUT', 1022, 'User logged out'),
(1457, '2024-11-28 22:59:34', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1458, '2024-11-28 22:59:42', 'RESIDENT ARCHIVED', 1022, 'Resident ID: 2866 data is archived by user.'),
(1459, '2024-11-28 23:02:42', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1460, '2024-11-28 23:02:54', 'LOGOUT', 1022, 'User logged out'),
(1461, '2024-11-28 23:03:02', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1462, '2024-11-28 23:03:09', 'USER_ARCHIVED', 1021, 'User: 1022 data is archived by admin'),
(1463, '2024-11-28 23:03:31', 'USER_UNARCHIVED', 1021, 'User: 1022 data is unarchived by admin'),
(1464, '2024-11-28 23:03:45', 'USER_DATA_UPDATE', 1021, 'User ID: 1022 data is updated by admin'),
(1465, '2024-11-28 23:04:12', 'LOGOUT', 1021, 'User logged out'),
(1466, '2024-11-28 23:04:18', 'LOGOUT', 1022, 'User logged out'),
(1467, '2024-11-28 23:17:37', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1468, '2024-11-28 23:17:44', 'USER_UNARCHIVED', 1022, 'User: 2866 data is unarchived by admin'),
(1469, '2024-11-28 23:18:02', 'LOGOUT', 1022, 'User logged out'),
(1470, '2024-11-28 23:19:36', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1471, '2024-11-28 23:21:40', 'NEW_INCIDENT_REPORT', 1022, 'New incident reported. Incident ID: 4'),
(1472, '2024-11-28 23:26:12', 'LOGOUT', 1022, 'User logged out'),
(1473, '2024-11-28 23:26:22', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1474, '2024-11-28 23:26:29', 'LOGOUT', 1022, 'User logged out'),
(1475, '2024-11-28 23:29:32', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1476, '2024-11-28 23:30:03', 'LOGOUT', 1022, 'User logged out'),
(1477, '2024-11-28 23:30:14', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1478, '2024-11-28 23:30:51', 'LOGOUT', 1022, 'User logged out'),
(1479, '2024-11-29 07:12:06', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1480, '2024-11-29 07:13:36', 'LOGOUT', 1021, 'User logged out'),
(1481, '2024-11-29 07:13:48', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1482, '2024-11-29 07:15:10', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2674 data is updated by user: 1022.'),
(1483, '2024-11-29 07:15:33', 'LOGOUT', 1022, 'User logged out'),
(1484, '2024-11-29 07:29:43', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1485, '2024-11-29 07:30:22', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2763 data is updated by user: 1022.'),
(1486, '2024-11-29 08:57:54', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1487, '2024-11-29 08:58:32', 'LOGOUT', 1021, 'User logged out'),
(1488, '2024-11-29 08:58:42', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1489, '2024-11-29 08:59:46', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2865 data is updated by user: 1022.'),
(1490, '2024-11-29 09:00:08', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2863 data is updated by user: 1022.'),
(1491, '2024-11-29 09:01:52', 'UPDATE_INCIDENT_REPORT', 1022, 'Incident updated. Incident ID: 4'),
(1492, '2024-11-29 09:02:49', 'LOGOUT', 1022, 'User logged out'),
(1493, '2024-11-29 09:02:58', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1494, '2024-11-29 09:03:10', 'USER_DATA_UPDATE', 1021, 'User ID: 1021 data is updated by admin'),
(1495, '2024-11-29 09:03:43', 'USER_DATA_UPDATE', 1021, 'User ID: 1022 data is updated by admin'),
(1496, '2024-11-29 09:03:46', 'LOGOUT', 1021, 'User logged out'),
(1497, '2024-11-29 09:04:00', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1498, '2024-11-29 09:04:09', 'LOGOUT', 1022, 'User logged out'),
(1499, '2024-11-29 09:07:55', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1500, '2024-11-29 09:08:53', 'LOGOUT', 1021, 'User logged out'),
(1501, '2024-11-29 10:12:01', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1502, '2024-11-29 10:12:17', 'LOGOUT', 1021, 'User logged out'),
(1503, '2024-11-29 10:12:30', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1504, '2024-11-29 10:13:19', 'LOGOUT', 1022, 'User logged out'),
(1505, '2024-11-29 10:13:41', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1506, '2024-11-29 10:16:20', 'RESIDENT_DOCUMENT_DOWNLOAD', 1021, 'Resident ID: 2864 document is downloaded by user.'),
(1507, '2024-11-29 10:16:45', 'LOGOUT', 1021, 'User logged out'),
(1508, '2024-11-29 12:28:57', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1509, '2024-11-29 12:30:43', 'USER_DATA_UPDATE', 1021, 'User ID: 1021 data is updated by admin'),
(1510, '2024-11-29 12:30:57', 'LOGOUT', 1021, 'User logged out'),
(1511, '2024-11-29 12:31:23', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1512, '2024-11-29 12:32:51', 'USER_DATA_UPDATE', 1021, 'User ID: 1022 data is updated by admin'),
(1513, '2024-11-29 12:33:00', 'USER_DATA_UPDATE', 1021, 'User ID: 1021 data is updated by admin'),
(1514, '2024-11-29 12:33:03', 'LOGOUT', 1021, 'User logged out'),
(1515, '2024-11-29 12:34:01', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1516, '2024-11-29 12:34:21', 'LOGOUT', 1021, 'User logged out'),
(1517, '2024-11-29 12:37:16', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1518, '2024-11-29 12:37:47', 'USER_DATA_UPDATE', 1021, 'User ID: 1021 data is updated by admin'),
(1519, '2024-11-29 12:39:47', 'LOGOUT', 1021, 'User logged out'),
(1520, '2024-11-29 12:40:21', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1521, '2024-11-29 12:41:45', 'USER_DATA_UPDATE', 1021, 'User ID: 1022 data is updated by admin'),
(1522, '2024-11-29 12:47:33', 'LOGOUT', 1021, 'User logged out'),
(1523, '2024-11-29 12:47:47', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1524, '2024-11-29 12:48:44', 'ADMIN_USER_REGISTRATION', 1021, 'New user registered. User ID: 1023'),
(1525, '2024-11-29 12:49:38', 'USER_DATA_UPDATE', 1021, 'User ID: 1023 data is updated by admin'),
(1526, '2024-11-29 12:50:58', 'USER_DATA_UPDATE', 1021, 'User ID: 1023 data is updated by admin'),
(1527, '2024-11-29 12:51:23', 'LOGOUT', 1021, 'User logged out'),
(1528, '2024-11-29 13:01:04', 'LOGIN_SUCCESS', 1023, 'User logged in successfully'),
(1529, '2024-11-29 13:01:59', 'LOGOUT', 1023, 'User logged out'),
(1530, '2024-11-29 13:04:12', 'LOGIN_SUCCESS', 1023, 'User logged in successfully'),
(1531, '2024-11-29 13:04:54', 'LOGOUT', 1023, 'User logged out'),
(1532, '2024-11-29 13:05:01', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1533, '2024-11-29 13:05:24', 'USER_DATA_UPDATE', 1021, 'User ID: 1023 data is updated by admin'),
(1534, '2024-11-29 13:07:49', 'LOGOUT', 1021, 'User logged out'),
(1535, '2024-11-29 13:18:20', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1536, '2024-11-29 13:19:10', 'USER_DATA_UPDATE', 1021, 'User ID: 1023 data is updated by admin'),
(1537, '2024-11-29 13:19:45', 'USER_DATA_UPDATE', 1021, 'User ID: 1023 data is updated by admin'),
(1538, '2024-11-29 13:20:13', 'USER_DATA_UPDATE', 1021, 'User ID: 1023 data is updated by admin'),
(1539, '2024-11-29 13:20:36', 'LOGOUT', 1021, 'User logged out'),
(1540, '2024-11-29 13:22:14', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1541, '2024-11-29 13:24:13', 'LOGOUT', 1021, 'User logged out'),
(1542, '2024-11-29 13:25:37', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1543, '2024-11-29 13:26:11', 'LOGOUT', 1021, 'User logged out'),
(1544, '2024-11-29 13:27:33', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1545, '2024-11-29 13:28:00', 'LOGOUT', 1021, 'User logged out'),
(1546, '2024-11-29 13:28:14', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1547, '2024-11-29 13:28:37', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1548, '2024-11-29 13:29:17', 'LOGOUT', 1022, 'User logged out'),
(1549, '2024-11-29 13:37:35', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1550, '2024-11-29 13:38:34', 'LOGOUT', 1021, 'User logged out'),
(1551, '2024-11-29 13:42:16', 'LOGIN_FAILURE', 1022, 'Invalid username or password'),
(1552, '2024-11-29 13:42:21', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1553, '2024-11-29 13:43:10', 'LOGOUT', 1022, 'User logged out'),
(1554, '2024-11-29 13:43:18', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1555, '2024-11-29 13:43:58', 'LOGOUT', 1021, 'User logged out'),
(1556, '2024-11-29 13:44:06', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1557, '2024-11-29 13:45:44', 'ADDED NEW RESIDENT', 1022, 'Resident ID: 2867 is added by user: 1022.'),
(1558, '2024-11-29 13:46:53', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2867 data is updated by user: 1022.'),
(1559, '2024-11-29 13:49:43', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2867 data is updated by user: 1022.'),
(1560, '2024-11-29 13:50:21', 'LOGOUT', 1022, 'User logged out'),
(1561, '2024-11-30 08:48:22', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1562, '2024-11-30 08:50:13', 'RESIDENT ARCHIVED', 1022, 'Resident ID: 2867 data is archived by user.'),
(1563, '2024-11-30 08:50:43', 'LOGOUT', 1022, 'User logged out'),
(1564, '2024-11-30 08:50:51', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1565, '2024-11-30 08:55:50', 'LOGOUT', 1021, 'User logged out'),
(1566, '2024-11-30 08:58:28', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1567, '2024-11-30 08:59:51', 'LOGOUT', 1021, 'User logged out'),
(1568, '2024-11-30 09:00:04', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1569, '2024-11-30 09:00:18', 'LOGOUT', 1022, 'User logged out'),
(1570, '2024-11-30 12:29:35', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1571, '2024-11-30 12:32:45', 'LOGOUT', 1021, 'User logged out'),
(1572, '2024-11-30 12:32:59', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1573, '2024-11-30 12:33:17', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1574, '2024-11-30 12:33:23', 'LOGOUT', 1022, 'User logged out'),
(1575, '2024-11-30 12:37:48', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1576, '2024-11-30 12:38:16', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1577, '2024-11-30 14:11:56', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1578, '2024-11-30 14:12:52', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1579, '2024-11-30 14:12:59', 'LOGOUT', 1022, 'User logged out'),
(1580, '2024-11-30 14:18:33', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1581, '2024-11-30 14:18:54', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1582, '2024-11-30 14:19:26', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1583, '2024-11-30 14:19:36', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1584, '2024-11-30 14:20:03', 'LOGOUT', 1022, 'User logged out'),
(1585, '2024-11-30 14:24:27', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1586, '2024-11-30 14:25:00', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1587, '2024-11-30 14:25:09', 'LOGOUT', 1022, 'User logged out'),
(1588, '2024-11-30 14:27:10', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1589, '2024-11-30 14:27:19', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1590, '2024-11-30 14:27:29', 'LOGOUT', 1022, 'User logged out'),
(1591, '2024-11-30 14:31:50', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1592, '2024-11-30 14:31:58', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1593, '2024-11-30 14:32:02', 'LOGOUT', 1022, 'User logged out'),
(1594, '2024-11-30 14:37:37', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1595, '2024-11-30 14:38:13', 'LOGOUT', 1022, 'User logged out'),
(1596, '2024-11-30 19:22:19', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1597, '2024-11-30 19:22:30', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1598, '2024-11-30 19:23:05', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1599, '2024-11-30 19:23:16', 'EDITED RESIDENT DATA', 1022, 'Resident ID: 2866 data is updated by user: 1022.'),
(1600, '2024-11-30 19:23:22', 'LOGOUT', 1022, 'User logged out');

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
(4, 'Ipil-Ipil', 1001),
(5, 'Minsinitas', 1001),
(6, 'Tugas', 1001),
(7, 'Lubi', 1001);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_reports`
--

CREATE TABLE `tbl_reports` (
  `inc_id` int(11) NOT NULL,
  `inc_type` varchar(255) NOT NULL,
  `inc_date_time` varchar(200) NOT NULL,
  `inc_loc` varchar(255) NOT NULL,
  `inc_involvedpersons` varchar(200) NOT NULL,
  `inc_narrative` varchar(200) NOT NULL,
  `inc_reported_by` varchar(255) NOT NULL,
  `inc_received_by` varchar(255) NOT NULL,
  `inc_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_reports`
--

INSERT INTO `tbl_reports` (`inc_id`, `inc_type`, `inc_date_time`, `inc_loc`, `inc_involvedpersons`, `inc_narrative`, `inc_reported_by`, `inc_received_by`, `inc_status`) VALUES
(3, 'Car Theft', 'Febuarary 10, 2024 at  2:30 AM', 'Main St. Of the Earth', 'John Doe, Jane Smith', 'Report of theft from a parked vehicle.', 'Officer Lee', 'Christian', 'Closed'),
(4, 'House Thief', 'November 28, 2024 at 11:20pm', 'Pob. Ward II, Minglanilla, Cebu', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ', 'Christian Abendan', 'Officer Lee', 'Open');

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
(2517, 'Santos', 'Rosa', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '1980-01-01', 'Married', 'Doctor', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2518, 'Fernandez', 'Carmen', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '1985-02-14', 'Single', 'Teacher', 'Christian', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2519, 'Rivera', 'Luis', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '1970-12-25', 'Single', 'Engineer', 'Muslim', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2520, 'Gonzales', 'Luis', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-27', 'Single', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2521, 'Lopez', 'Victoria', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-02-10', 'Married', 'Student', 'Born Again', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2522, 'Flores', 'Maria', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-10', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2523, 'Santos', 'Miguel', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-11', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2524, 'Diaz', 'Juan', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-12', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2525, 'Morales', 'Carmen', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-13', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2526, 'Reyes', 'Jorge', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-14', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2527, 'Morales', 'Jose', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-15', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2528, 'Cruz', 'Miguel', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-16', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2529, 'Fernandez', 'Teresa', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-17', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2530, 'Mendoza', 'Sofia', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-18', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2531, 'Cruz', 'Ana', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-19', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2532, 'Garcia', 'Jorge', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-20', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2533, 'Fernandez', 'Maria', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-21', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2534, 'Lopez', 'Carlos', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-22', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2535, 'Mendoza', 'Maria', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-23', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2536, 'Fernandez', 'Luis', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-24', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2537, 'Perez', 'Teresa', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-25', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2538, 'Morales', 'Carlos', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-26', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2539, 'Gonzales', 'Jose', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-27', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2540, 'Santos', 'Ramon', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-28', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2541, 'Fernandez', 'Fernando', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-29', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2542, 'Castillo', 'Angel', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-30', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2543, 'Reyes', 'Elena', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-07-31', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2544, 'Castillo', 'Maria', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-01', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2545, 'Santos', 'Sofia', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-02', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2546, 'Diaz', 'Elena', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-03', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2547, 'Garcia', 'Sofia', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-04', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2548, 'Ramos', 'Victoria', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-05', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2549, 'Ramos', 'Manuel', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-06', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2550, 'Gonzales', 'Maria', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-07', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2551, 'Castillo', 'Maria', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-08', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2552, 'Santos', 'Luz', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-09', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2553, 'Gonzales', 'Juan', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-10', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2554, 'Rodriguez', 'Jose', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-08-11', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2555, 'Rodriguez', 'Ricardo', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-08-12', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2556, 'Martinez', 'Jose', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-08-13', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2557, 'Mendoza', 'Ramon', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-08-14', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2558, 'Flores', 'Ricardo', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-08-15', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2559, 'Diaz', 'Juan', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-08-16', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2560, 'Ramos', 'Fernando', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-08-17', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2561, 'Reyes', 'Ana', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-18', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2562, 'Mendoza', 'Ricardo', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-19', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2563, 'Martinez', 'Manuel', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-20', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2564, 'Diaz', 'Sofia', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-21', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2565, 'Castillo', 'Jose', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-22', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2566, 'Mendoza', 'Sofia', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-23', 'Married', 'Student', 'Catholic', 1, 'src/u_default/blank_pfp.jpg', 'Active'),
(2567, 'Cruz', 'Angel', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-24', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2568, 'Cruz', 'Miguel', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-25', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2569, 'Fernandez', 'Maria', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-26', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2570, 'Reyes', 'Pedro', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-27', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2571, 'Morales', 'Pedro', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-28', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2572, 'Santos', 'Ricardo', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-29', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2573, 'Ramos', 'Miguel', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-30', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2574, 'Torres', 'Maria', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-08-31', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2575, 'Lopez', 'Sofia', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-01', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2576, 'Perez', 'Angel', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-02', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2577, 'Flores', 'Teresa', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-03', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2578, 'Rodriguez', 'Fernando', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-04', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2579, 'Castillo', 'Ramon', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-05', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2580, 'Diaz', 'Jose', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-06', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2581, 'Perez', 'Manuel', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-07', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2582, 'Diaz', 'Pedro', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-08', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2583, 'Cruz', 'Ramon', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-09', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2584, 'Ramos', 'Carmen', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-10', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2585, 'Rodriguez', 'Ricardo', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-11', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2586, 'Aquino', 'Manuel', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-12', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2587, 'Santos', 'Miguel', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-13', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2588, 'Diaz', 'Carlos', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-14', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2589, 'Perez', 'Carmen', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-15', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2590, 'Mendoza', 'Victoria', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-16', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2591, 'Gonzales', 'Pedro', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-17', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2592, 'Santos', 'Miguel', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-18', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2593, 'Perez', 'Carmen', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-19', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2594, 'Mendoza', 'Luis', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-20', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2595, 'Morales', 'Luis', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-21', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2596, 'Gonzales', 'Manuel', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-22', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2597, 'Morales', 'Sofia', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-23', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2598, 'Perez', 'Sofia', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-24', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2599, 'Gonzales', 'Ana', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-25', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2600, 'Ramos', 'Pedro', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-26', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2601, 'Cruz', 'Rosa', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-09-27', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2602, 'Morales', 'Carmen', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-28', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2603, 'Reyes', 'Teresa', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-29', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2604, 'Morales', 'Angel', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-09-30', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2605, 'Martinez', 'Angel', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-01', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2606, 'Castillo', 'Luis', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-02', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2607, 'Fernandez', 'Manuel', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-03', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2608, 'Santos', 'Luz', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-04', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2609, 'Perez', 'Carmen', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-05', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2610, 'Rodriguez', 'Ricardo', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-06', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2611, 'Gonzales', 'Juan', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-07', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2612, 'Ramos', 'Carmen', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-08', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2613, 'Fernandez', 'Carmen', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-09', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2614, 'Rivera', 'Ramon', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-10', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2615, 'Castillo', 'Ramon', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-11', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2616, 'Diaz', 'Rosa', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-12', 'Married', 'Student', 'Catholic', 2, 'src/u_default/blank_pfp.jpg', 'Active'),
(2617, 'Rodriguez', 'Angel', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-13', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2618, 'Reyes', 'Sofia', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-14', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2619, 'Flores', 'Jorge', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-15', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2620, 'Cruz', 'Ramon', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-16', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2621, 'Castillo', 'Victoria', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-17', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2622, 'Fernandez', 'Carmen', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-18', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2623, 'Gonzales', 'Manuel', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-19', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2624, 'Fernandez', 'Ana', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-20', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2625, 'Mendoza', 'Carlos', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-21', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2626, 'Cruz', 'Elena', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-22', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2627, 'Rivera', 'Angel', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-23', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2628, 'Garcia', 'Jose', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-24', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2629, 'Aquino', 'Ana', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-25', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2630, 'Mendoza', 'Carlos', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-10-26', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2631, 'Garcia', 'Carlos', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-27', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2632, 'Mendoza', 'Pedro', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-28', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2633, 'Garcia', 'Luz', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-29', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2634, 'Ramos', 'Rosa', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-30', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2635, 'Aquino', 'Jorge', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-10-31', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2636, 'Aquino', 'Rosa', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-01', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2637, 'Mendoza', 'Fernando', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-02', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2638, 'Diaz', 'Ana', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-03', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2639, 'Lopez', 'Victoria', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-04', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2640, 'Fernandez', 'Sofia', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-05', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2641, 'Reyes', 'Sofia', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-06', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2642, 'Rodriguez', 'Victoria', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-07', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2643, 'Bautista', 'Rosa', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-08', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2644, 'Mendoza', 'Victoria', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-09', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2645, 'Flores', 'Rosa', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-10', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2646, 'Castillo', 'Elena', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-11', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2647, 'Rivera', 'Juan', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-12', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2648, 'Reyes', 'Miguel', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-13', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2649, 'Mendoza', 'Carlos', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-11-14', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2650, 'Castillo', 'Manuel', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-15', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2651, 'Flores', 'Luz', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-16', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2652, 'Garcia', 'Maria', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-17', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2653, 'Ramos', 'Teresa', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-18', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2654, 'Morales', 'Sofia', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-19', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2655, 'Flores', 'Ana', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-20', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2656, 'Santos', 'Maria', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-21', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2657, 'Gonzales', 'Jose', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-22', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2658, 'Perez', 'Miguel', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-23', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2659, 'Ramos', 'Maria', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-24', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2660, 'Mendoza', 'Pedro', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-25', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2661, 'Rivera', 'Victoria', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-26', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2662, 'Gonzales', 'Angel', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-27', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2663, 'Rodriguez', 'Pedro', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-28', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2664, 'Perez', 'Jose', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-29', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2665, 'Gonzales', 'Sofia', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-11-30', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2666, 'Ramos', 'Juan', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-01', 'Married', 'Student', 'Catholic', 3, 'src/u_default/blank_pfp.jpg', 'Active'),
(2667, 'Lopez', 'Elena', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-02', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2668, 'Reyes', 'Ana', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-03', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2669, 'Santos', 'Elena', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-04', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2670, 'Ramos', 'Fernando', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-05', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2671, 'Rivera', 'Elena', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-06', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2672, 'Ramos', 'Jorge', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-07', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2673, 'Perez', 'Ana', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-08', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2674, 'Aquino', 'Carmen', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '1984-12-05', 'Married', 'Student', 'Catholic', 4, '', 'Active'),
(2675, 'Ramos', 'Jose', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-10', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2676, 'Santos', 'Miguel', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-11', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2677, 'Martinez', 'Juan', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-12', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2678, 'Gonzales', 'Carmen', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-13', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2679, 'Gonzales', 'Victoria', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-14', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2680, 'Santos', 'Carlos', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-15', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2681, 'Diaz', 'Sofia', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-16', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2682, 'Gonzales', 'Manuel', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-17', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2683, 'Diaz', 'Ricardo', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2003-12-18', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2684, 'Gonzales', 'Rosa', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-19', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2685, 'Torres', 'Teresa', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-20', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2686, 'Bautista', 'Ricardo', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-21', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2687, 'Castillo', 'Juan', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-22', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2688, 'Gonzales', 'Carmen', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-23', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2689, 'Castillo', 'Ana', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-24', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2690, 'Rodriguez', 'Jorge', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-25', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2691, 'Garcia', 'Sofia', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-26', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2692, 'Lopez', 'Rosa', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-27', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2693, 'Reyes', 'Angel', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-28', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2694, 'Torres', 'Luz', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-29', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2695, 'Diaz', 'Fernando', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-30', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2696, 'Lopez', 'Jose', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2003-12-31', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2697, 'Torres', 'Maria', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-01', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2698, 'Rodriguez', 'Elena', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-02', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2699, 'Ramos', 'Juan', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-03', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2700, 'Aquino', 'Ramon', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-04', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2701, 'Lopez', 'Ramon', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-05', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2702, 'Perez', 'Rosa', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-06', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2703, 'Gonzales', 'Ana', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-07', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2704, 'Fernandez', 'Jose', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-08', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2705, 'Flores', 'Luis', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-09', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2706, 'Rodriguez', 'Maria', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-10', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2707, 'Bautista', 'Maria', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-11', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2708, 'Garcia', 'Angel', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-12', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2709, 'Santos', 'Maria', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-13', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2710, 'Reyes', 'Maria', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-14', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2711, 'Ramos', 'Fernando', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-15', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2712, 'Rodriguez', 'Juan', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-16', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2713, 'Ramos', 'Angel', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-17', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2714, 'Morales', 'Ana', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-01-18', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2715, 'Rivera', 'Carmen', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-19', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2716, 'Aquino', 'Elena', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-20', 'Married', 'Student', 'Catholic', 4, 'src/u_default/blank_pfp.jpg', 'Active'),
(2717, 'Lopez', 'Carmen', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-21', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2718, 'Castillo', 'Ricardo', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-22', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2719, 'Mendoza', 'Victoria', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-23', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2720, 'Aquino', 'Carmen', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-24', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2721, 'Diaz', 'Ramon', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-25', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2722, 'Cruz', 'Miguel', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-26', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2723, 'Flores', 'Miguel', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-27', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2724, 'Martinez', 'Carmen', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-28', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2725, 'Garcia', 'Pedro', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-29', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2726, 'Fernandez', 'Sofia', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-30', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2727, 'Morales', 'Luz', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-01-31', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2728, 'Flores', 'Miguel', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-01', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2729, 'Perez', 'Carmen', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-02', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2730, 'Rodriguez', 'Jose', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-03', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2731, 'Santos', 'Angel', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-04', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2732, 'Bautista', 'Victoria', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-05', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2733, 'Cruz', 'Juan', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-06', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2734, 'Ramos', 'Jorge', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-07', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2735, 'Lopez', 'Manuel', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-08', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2736, 'Reyes', 'Victoria', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-09', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2737, 'Reyes', 'Ramon', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-10', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2738, 'Diaz', 'Luz', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-11', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2739, 'Lopez', 'Pedro', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-12', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2740, 'Reyes', 'Elena', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-13', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2741, 'Ramos', 'Pedro', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-14', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2742, 'Reyes', 'Ramon', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-15', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2743, 'Reyes', 'Jorge', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-16', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2744, 'Diaz', 'Ana', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-17', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2745, 'Santos', 'Carmen', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-18', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2746, 'Lopez', 'Carmen', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-19', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2747, 'Santos', 'Luz', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-20', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2748, 'Torres', 'Rosa', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-21', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2749, 'Lopez', 'Pedro', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-22', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2750, 'Bautista', 'Jose', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-23', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2751, 'Aquino', 'Jorge', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-24', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2752, 'Perez', 'Elena', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-02-25', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2753, 'Martinez', 'Elena', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-26', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2754, 'Mendoza', 'Angel', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-27', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2755, 'Bautista', 'Sofia', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-28', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2756, 'Torres', 'Fernando', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-02-29', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2757, 'Santos', 'Elena', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-03-01', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2758, 'Martinez', 'Manuel', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-03-02', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2759, 'Morales', 'Teresa', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-03-03', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2760, 'Rodriguez', 'Sofia', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-03-04', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2761, 'Morales', 'Maria', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-03-05', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2762, 'Torres', 'Fernando', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-03-06', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2763, 'Garcia', 'Luz', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-07', 'Married', 'Student', 'Catholic', 5, '', 'Active'),
(2764, 'Garcia', 'Miguel', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-03-08', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2765, 'Garcia', 'Jorge', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-03-09', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2766, 'Diaz', 'Victoria', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-10', 'Married', 'Student', 'Catholic', 5, 'src/u_default/blank_pfp.jpg', 'Active'),
(2767, 'Santos', 'Elena', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-11', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2768, 'Flores', 'Juan', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-12', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2769, 'Lopez', 'Juan', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-13', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2770, 'Castillo', 'Fernando', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-14', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2771, 'Cruz', 'Elena', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-15', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2772, 'Flores', 'Victoria', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-16', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2773, 'Mendoza', 'Manuel', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-17', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2774, 'Lopez', 'Maria', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-18', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2775, 'Rivera', 'Teresa', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-19', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2776, 'Rodriguez', 'Teresa', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-20', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2777, 'Bautista', 'Elena', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-21', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2778, 'Garcia', 'Jorge', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-22', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2779, 'Lopez', 'Carlos', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-23', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2780, 'Mendoza', 'Manuel', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-24', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2781, 'Aquino', 'Rosa', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-25', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2782, 'Torres', 'Carmen', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-26', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2783, 'Martinez', 'Luis', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-27', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2784, 'Martinez', 'Pedro', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-28', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2785, 'Aquino', 'Teresa', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-29', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2786, 'Mendoza', 'Ramon', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-30', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2787, 'Rivera', 'Pedro', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-03-31', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2788, 'Perez', 'Juan', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-01', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2789, 'Reyes', 'Rosa', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-02', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2790, 'Fernandez', 'Victoria', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-03', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2791, 'Garcia', 'Luis', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-04', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2792, 'Rivera', 'Ana', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-05', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2793, 'Flores', 'Maria', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-06', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2794, 'Perez', 'Rosa', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-07', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2795, 'Reyes', 'Rosa', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-08', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2796, 'Lopez', 'Juan', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-09', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2797, 'Flores', 'Jorge', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-10', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2798, 'Martinez', 'Teresa', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-11', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2799, 'Aquino', 'Pedro', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-12', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2800, 'Bautista', 'Miguel', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-13', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2801, 'Flores', 'Carmen', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-14', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2802, 'Lopez', 'Fernando', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-15', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2803, 'Fernandez', 'Luis', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-16', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2804, 'Castillo', 'Carmen', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-17', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active');
INSERT INTO `tbl_residents` (`r_id`, `r_lname`, `r_fname`, `r_mname`, `r_address`, `r_sex`, `r_dob`, `r_civilstatus`, `r_occupation`, `r_religion`, `h_id`, `r_image`, `r_status`) VALUES
(2805, 'Diaz', 'Teresa', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-18', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2806, 'Castillo', 'Juan', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-19', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2807, 'Reyes', 'Jorge', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-20', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2808, 'Reyes', 'Fernando', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-21', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2809, 'Reyes', 'Manuel', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-22', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2810, 'Santos', 'Jose', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-23', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2811, 'Mendoza', 'Carmen', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-24', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2812, 'Reyes', 'Jose', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-25', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2813, 'Martinez', 'Maria', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-26', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2814, 'Flores', 'Luis', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-27', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2815, 'Torres', 'Jose', 'Navarro', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-28', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2816, 'Castillo', 'Manuel', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-04-29', 'Married', 'Student', 'Catholic', 6, 'src/u_default/blank_pfp.jpg', 'Active'),
(2817, 'Lopez', 'Teresa', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-04-30', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2818, 'Castillo', 'Angel', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-01', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2819, 'Bautista', 'Fernando', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-02', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2820, 'Reyes', 'Carmen', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-03', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2821, 'Torres', 'Pedro', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-04', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2822, 'Rivera', 'Angel', 'De Leon', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-05', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2823, 'Martinez', 'Jorge', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-06', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2824, 'Perez', 'Manuel', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-07', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2825, 'Rivera', 'Miguel', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-08', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2826, 'Torres', 'Teresa', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-09', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2827, 'Santos', 'Teresa', 'Silva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-10', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2828, 'Lopez', 'Ricardo', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-11', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2829, 'Castillo', 'Manuel', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-12', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2830, 'Aquino', 'Pedro', 'Aguilar', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-13', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2831, 'Fernandez', 'Carlos', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-14', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2832, 'Gonzales', 'Luz', 'Pascual', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-15', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2833, 'Reyes', 'Victoria', 'Velasquez', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-16', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2834, 'Torres', 'Miguel', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-17', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2835, 'Santos', 'Carlos', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-18', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2836, 'Garcia', 'Victoria', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-19', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2837, 'Perez', 'Jose', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-20', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2838, 'Martinez', 'Ricardo', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-21', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2839, 'Rodriguez', 'Ricardo', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-22', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2840, 'Morales', 'Maria', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-23', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2841, 'Fernandez', 'Maria', 'Dela Cruz', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-24', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2842, 'Garcia', 'Luis', 'Guzman', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-25', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2843, 'Bautista', 'Carmen', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-26', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2844, 'Lopez', 'Pedro', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-27', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2845, 'Reyes', 'Jorge', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-28', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2846, 'Torres', 'Miguel', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-29', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2847, 'Cruz', 'Manuel', 'Santiago', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-05-30', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2848, 'Castillo', 'Teresa', 'Madrigal', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-05-31', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2849, 'Bautista', 'Rosa', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-01', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2850, 'Perez', 'Carlos', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-02', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2851, 'Castillo', 'Luis', 'Pineda', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-03', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2852, 'Mendoza', 'Miguel', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-04', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2853, 'Torres', 'Manuel', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-05', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2854, 'Ramos', 'Miguel', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-06', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2855, 'Perez', 'Teresa', 'Garcia', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-07', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2856, 'Perez', 'Victoria', 'Cabrera', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-08', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2857, 'Torres', 'Fernando', 'Villanueva', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-09', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2858, 'Ramos', 'Rosa', 'Salvador', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-10', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2859, 'Lopez', 'Ramon', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-11', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2860, 'Cruz', 'Luz', 'Ortega', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-12', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2861, 'Flores', 'Jose', 'Vargas', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-13', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2862, 'Santos', 'Juan', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-14', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2863, 'Reyes', 'Ana', 'Torres', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '2004-06-15', 'Single', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2864, 'Morales', 'Juan', 'Domingo', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '2004-06-16', 'Married', 'Student', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2865, 'Morales', 'Angel', 'Padilla', 'Pob. Ward II, Minglanilla, Cebu', 'Female', '1997-02-07', 'Married', 'Sales Clerk', 'Catholic', 7, 'src/u_default/blank_pfp.jpg', 'Active'),
(2866, 'Morales', 'Raymod', 'Degamo', 'Pob. Ward II, Minglanilla, Cebu', 'Male', '1998-09-07', 'Single', 'Worker', 'Catholic', 7, 'src/r_images/resident_pfp.png', 'Active'),
(2867, 'Plameran', 'John Bert', 'Decena', 'Tungkil, Minglanilla, Cebu', 'Male', '0001-11-29', 'Married', 'Adonis Dancer', 'Iglesia ni Chris Brown', 13, 'src/r_images/johnbert_pfp.png', 'Archived');

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
(1021, 'Christian James', 'Abendan', 'admin@gmail.com', 'admin', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_images/admin_pfp.png', ''),
(1022, 'Emman', 'Bas', 'user@gmail.com', 'user', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_images/emman_pfp.png', ''),
(1023, 'Shane', 'Hermando', 'user1@gmail.com', 'user1', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_images/brgy_sec.png', '');

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
-- Indexes for table `tbl_reports`
--
ALTER TABLE `tbl_reports`
  ADD PRIMARY KEY (`inc_id`);

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
  MODIFY `h_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1601;

--
-- AUTO_INCREMENT for table `tbl_purok`
--
ALTER TABLE `tbl_purok`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_reports`
--
ALTER TABLE `tbl_reports`
  MODIFY `inc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_residents`
--
ALTER TABLE `tbl_residents`
  MODIFY `r_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2868;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1024;

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
