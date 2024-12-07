-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2024 at 05:39 AM
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
(1001, 'Pob. Ward II', 'Minglanilla, Cebu', 359);

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
(1600, '2024-11-30 19:23:22', 'LOGOUT', 1022, 'User logged out'),
(1601, '2024-12-01 09:22:09', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1602, '2024-12-01 09:22:35', 'USER_DATA_UPDATE', 1021, 'User ID: 1023 data is updated by admin'),
(1603, '2024-12-01 09:22:53', 'LOGOUT', 1021, 'User logged out'),
(1604, '2024-12-02 09:55:18', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1605, '2024-12-02 09:56:01', 'LOGOUT', 1021, 'User logged out'),
(1606, '2024-12-02 09:56:10', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1607, '2024-12-02 10:01:28', 'LOGOUT', 1022, 'User logged out'),
(1608, '2024-12-04 19:12:49', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1609, '2024-12-04 19:13:08', 'LOGOUT', 1021, 'User logged out'),
(1610, '2024-12-04 19:13:15', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1611, '2024-12-04 19:13:32', 'LOGOUT', 1022, 'User logged out'),
(1612, '2024-12-04 19:13:45', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1613, '2024-12-04 19:14:48', 'LOGOUT', 1023, 'User logged out'),
(1614, '2024-12-04 19:14:57', 'LOGIN_SUCCESS', 1021, 'Admin logged in successfully'),
(1615, '2024-12-04 19:15:48', 'USER_DATA_UPDATE', 1021, 'User ID: 1023 data is updated by admin'),
(1616, '2024-12-04 19:15:52', 'LOGOUT', 1021, 'User logged out'),
(1617, '2024-12-04 19:15:58', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1618, '2024-12-04 19:16:06', 'LOGOUT', 1022, 'User logged out'),
(1619, '2024-12-06 11:31:24', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1620, '2024-12-06 11:31:44', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Resident ID: Id number document is downloaded by user.'),
(1621, '2024-12-06 11:32:21', 'LOGOUT', 1023, 'User logged out'),
(1622, '2024-12-06 11:37:17', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1623, '2024-12-06 11:37:29', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: All Residents is downloaded by user.'),
(1624, '2024-12-06 11:41:53', 'LOGOUT', 1023, 'User logged out'),
(1625, '2024-12-06 11:42:06', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1626, '2024-12-06 11:47:31', 'LOGOUT', 1023, 'User logged out'),
(1627, '2024-12-06 11:48:10', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1628, '2024-12-06 11:48:34', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Tambis Residents is downloaded by user.'),
(1629, '2024-12-06 11:49:05', 'LOGOUT', 1023, 'User logged out'),
(1630, '2024-12-06 11:53:00', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1631, '2024-12-06 11:53:14', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Tambis Residents is downloaded by user.'),
(1632, '2024-12-06 11:53:41', 'LOGOUT', 1023, 'User logged out'),
(1633, '2024-12-06 11:57:16', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1634, '2024-12-06 11:57:28', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Guyabano Residents is downloaded by user.'),
(1635, '2024-12-06 11:59:10', 'LOGOUT', 1023, 'User logged out'),
(1636, '2024-12-06 11:59:18', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1637, '2024-12-06 11:59:27', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: All Residents is downloaded by user.'),
(1638, '2024-12-06 12:00:48', 'LOGOUT', 1023, 'User logged out'),
(1639, '2024-12-06 12:00:59', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1640, '2024-12-06 12:01:09', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Tambis Residents is downloaded by user.'),
(1641, '2024-12-06 12:02:03', 'LOGOUT', 1023, 'User logged out'),
(1642, '2024-12-06 12:02:14', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1643, '2024-12-06 12:02:25', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Lubi Residents is downloaded by user.'),
(1644, '2024-12-06 12:02:53', 'LOGOUT', 1023, 'User logged out'),
(1645, '2024-12-06 12:03:03', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1646, '2024-12-06 12:03:15', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Tugas Residents is downloaded by user.'),
(1647, '2024-12-06 12:03:18', 'LOGOUT', 1023, 'User logged out'),
(1648, '2024-12-06 12:04:59', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1649, '2024-12-06 12:05:06', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Tambis Residents is downloaded by user.'),
(1650, '2024-12-06 12:05:25', 'LOGOUT', 1023, 'User logged out'),
(1651, '2024-12-06 12:05:54', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1652, '2024-12-06 12:06:01', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Tambis Residents is downloaded by user.'),
(1653, '2024-12-06 12:06:38', 'LOGOUT', 1023, 'User logged out'),
(1654, '2024-12-06 12:06:49', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1655, '2024-12-06 12:08:20', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Tambis Residents is downloaded by user.'),
(1656, '2024-12-06 12:08:21', 'LOGOUT', 1023, 'User logged out'),
(1657, '2024-12-06 12:08:33', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1658, '2024-12-06 12:08:39', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Mahogany Residents is downloaded by user.'),
(1659, '2024-12-06 12:09:33', 'LOGOUT', 1023, 'User logged out'),
(1660, '2024-12-06 12:10:27', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1661, '2024-12-06 12:10:33', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: All Residents is downloaded by user.'),
(1662, '2024-12-06 12:11:11', 'LOGOUT', 1023, 'User logged out'),
(1663, '2024-12-06 12:11:28', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1664, '2024-12-06 12:11:34', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: Mahogany Residents is downloaded by user.'),
(1665, '2024-12-06 12:12:10', 'LOGOUT', 1023, 'User logged out'),
(1666, '2024-12-06 12:13:02', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1667, '2024-12-06 12:13:12', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: All Residents is downloaded by user.'),
(1668, '2024-12-06 12:13:45', 'LOGOUT', 1023, 'User logged out'),
(1669, '2024-12-06 12:16:02', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1670, '2024-12-06 12:16:10', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: All Residents is downloaded by user.'),
(1671, '2024-12-06 12:16:56', 'LOGOUT', 1023, 'User logged out'),
(1672, '2024-12-06 12:17:06', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1673, '2024-12-06 12:17:24', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Resident ID: 2866 document is downloaded by user.'),
(1674, '2024-12-06 12:17:30', 'LOGOUT', 1023, 'User logged out'),
(1675, '2024-12-06 12:17:38', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1676, '2024-12-06 12:17:51', 'EXPORT_USER_DATA', 1023, 'Admin exported User: 1023 data.'),
(1677, '2024-12-06 12:18:10', 'LOGOUT', 1023, 'User logged out'),
(1678, '2024-12-06 16:12:06', 'LOGIN_FAILURE', 1023, 'Invalid username or password'),
(1679, '2024-12-06 16:12:22', 'LOGIN_SUCCESS', 1023, 'Admin logged in successfully'),
(1680, '2024-12-06 16:12:47', 'RESIDENT_DOCUMENT_DOWNLOAD', 1023, 'Data: All Residents is downloaded by user.'),
(1681, '2024-12-07 12:20:55', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1682, '2024-12-07 12:21:09', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1683, '2024-12-07 12:21:10', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1684, '2024-12-07 12:21:10', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1685, '2024-12-07 12:21:10', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1686, '2024-12-07 12:21:10', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1687, '2024-12-07 12:21:10', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1688, '2024-12-07 12:21:10', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1689, '2024-12-07 12:22:16', 'LOGOUT', 1022, 'User logged out'),
(1690, '2024-12-07 12:22:26', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1691, '2024-12-07 12:28:21', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1692, '2024-12-07 12:30:52', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1693, '2024-12-07 12:31:29', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1694, '2024-12-07 12:33:50', 'LOGOUT', 1022, 'User logged out'),
(1695, '2024-12-07 12:34:01', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1696, '2024-12-07 12:34:18', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1697, '2024-12-07 12:34:18', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1698, '2024-12-07 12:34:18', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1699, '2024-12-07 12:34:18', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1700, '2024-12-07 12:34:18', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1701, '2024-12-07 12:34:18', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1702, '2024-12-07 12:34:18', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1703, '2024-12-07 12:36:50', 'LOGOUT', 1022, 'User logged out'),
(1704, '2024-12-07 12:37:02', 'LOGIN_SUCCESS', 1022, 'User logged in successfully'),
(1705, '2024-12-07 12:37:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1706, '2024-12-07 12:37:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1707, '2024-12-07 12:37:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1708, '2024-12-07 12:37:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1709, '2024-12-07 12:37:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1710, '2024-12-07 12:37:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1711, '2024-12-07 12:37:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added 50 new residents.'),
(1712, '2024-12-07 12:37:15', 'IMPORT_NEW_RESIDENT_BATCH', 1022, 'Added remaining residents.'),
(1713, '2024-12-07 12:37:54', 'LOGOUT', 1022, 'User logged out');

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
(1021, 'Christian James', 'Abendan', 'Main@gmail.com', 'Main', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_images/admin_pfp.png', ''),
(1022, 'Emman', 'Bas', 'user@gmail.com', 'user', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'User', 'Active', 'src/u_images/emman_pfp.png', ''),
(1023, 'Shane', 'Hermando', 'admin@gmail.com', 'admin', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'Admin', 'Active', 'src/u_images/brgy_sec.png', '');

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
  MODIFY `l_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1714;

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
  MODIFY `r_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3920;

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
