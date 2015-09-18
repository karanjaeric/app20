-- phpMyAdmin SQL Dump
-- version 4.2.12deb2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 09, 2015 at 11:57 AM
-- Server version: 5.6.25-0ubuntu0.15.04.1
-- PHP Version: 5.6.4-4ubuntu6.2

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mss`
--
CREATE DATABASE IF NOT EXISTS `mss` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mss`;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_activity_logs`
--

DROP TABLE IF EXISTS `tbl_activity_logs`;
CREATE TABLE IF NOT EXISTS `tbl_activity_logs` (
`id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `datetime` datetime NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `scheme` varchar(255) DEFAULT NULL,
  `access_menu` varchar(255) DEFAULT NULL,
  `userProfile` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2641 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_activity_logs`
--

INSERT INTO `tbl_activity_logs` (`id`, `description`, `datetime`, `user_id`, `scheme`, `access_menu`, `userProfile`) VALUES
(2, 'accesed home page', '2015-07-26 16:02:05', 0, NULL, 'HOME', NULL),
(3, 'accesed home page', '2015-07-26 16:02:11', 0, NULL, 'HOME', NULL),
(4, 'successfully logged in', '2015-07-26 16:03:08', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(5, 'successfully logged in', '2015-07-26 16:49:24', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(6, 'successfully logged in', '2015-07-26 16:51:04', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(7, 'successfully logged in', '2015-07-26 16:52:04', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(8, 'successfully logged in', '2015-07-26 16:54:31', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(9, 'successfully logged in', '2015-07-26 16:56:03', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(10, 'successfully logged in', '2015-07-26 16:56:36', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(11, 'successfully logged in', '2015-07-26 16:57:28', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(12, 'successfully logged in', '2015-07-26 17:02:49', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(13, 'successfully logged in', '2015-07-26 17:03:08', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(14, 'successfully logged in', '2015-07-26 17:17:32', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(15, 'successfully logged in', '2015-07-26 17:18:34', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(16, 'successfully logged in', '2015-07-26 17:20:13', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(17, 'successfully logged in', '2015-07-26 17:51:58', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(18, 'successfully logged in', '2015-07-26 17:52:57', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(19, 'successfully logged in', '2015-07-26 18:03:48', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(20, 'successfully logged in', '2015-07-26 18:12:30', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(21, 'successfully logged in', '2015-07-26 18:14:44', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(22, 'successfully logged in', '2015-07-26 18:16:38', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(23, 'successfully logged in', '2015-07-26 18:18:45', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(24, 'successfully logged in', '2015-07-26 18:20:10', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(25, 'successfully logged in', '2015-07-26 18:22:24', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(26, 'successfully logged in', '2015-07-26 18:24:00', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(27, 'successfully logged in', '2015-07-26 18:27:04', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(28, 'successfully logged in', '2015-07-26 18:27:57', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(29, 'successfully logged in', '2015-07-26 18:35:07', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(30, 'logged out', '2015-07-26 18:37:15', 18, NULL, '', 'MEMBER'),
(31, 'successfully logged in', '2015-07-26 18:37:22', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(32, 'successfully logged in', '2015-07-26 18:42:20', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(33, 'successfully logged in', '2015-07-26 18:55:49', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(34, 'successfully logged in', '2015-07-26 18:56:47', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(35, 'successfully logged in', '2015-07-26 18:56:54', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(36, 'successfully logged in', '2015-07-26 18:58:36', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(37, 'successfully logged in', '2015-07-26 19:01:15', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(38, 'successfully logged in', '2015-07-26 19:50:49', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(39, 'successfully logged in', '2015-07-26 19:50:54', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(40, 'successfully logged in', '2015-07-26 19:52:14', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(41, 'successfully logged in', '2015-07-26 19:56:03', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(42, 'successfully logged in', '2015-07-26 20:01:21', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(43, 'successfully logged in', '2015-07-26 20:06:57', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(44, 'successfully logged in', '2015-07-26 20:08:18', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(45, 'successfully logged in', '2015-07-26 20:09:21', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(46, 'successfully logged in', '2015-07-26 20:13:24', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(47, 'successfully logged in', '2015-07-26 20:18:58', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(48, 'successfully logged in', '2015-07-26 20:30:01', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(49, 'successfully logged in', '2015-07-26 20:31:19', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(50, 'successfully logged in', '2015-07-26 20:31:42', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(51, 'successfully logged in', '2015-07-26 20:32:22', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(52, 'successfully logged in', '2015-07-26 20:36:45', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(53, 'logged out', '2015-07-26 20:58:33', 13, NULL, '', 'ADMINISTRATOR'),
(54, 'accesed home page', '2015-07-26 20:58:41', 0, NULL, 'HOME', NULL),
(55, 'successfully logged in', '2015-07-26 20:58:55', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(56, 'successfully logged in', '2015-07-26 21:08:44', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(57, 'successfully logged in', '2015-07-26 21:22:06', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(58, 'accesed home page', '2015-07-27 03:06:39', 0, NULL, 'HOME', NULL),
(59, 'accesed home page', '2015-07-27 12:20:58', 0, NULL, 'HOME', NULL),
(60, 'successfully logged in', '2015-07-27 12:21:10', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(61, 'logged out', '2015-07-27 12:39:45', 18, NULL, '', 'MEMBER'),
(62, 'successfully logged in', '2015-07-27 12:39:52', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(63, 'successfully logged in', '2015-07-27 15:56:29', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(64, 'accesed home page', '2015-07-27 16:02:08', 0, NULL, 'HOME', NULL),
(65, 'accesed home page', '2015-07-27 17:23:24', 0, NULL, 'HOME', NULL),
(66, 'accesed home page', '2015-07-27 18:01:11', 0, NULL, 'HOME', NULL),
(67, 'accesed home page', '2015-07-27 18:02:38', 0, NULL, 'HOME', NULL),
(68, 'accesed home page', '2015-07-27 18:10:30', 0, NULL, 'HOME', NULL),
(69, 'accesed home page', '2015-07-27 18:10:33', 0, NULL, 'HOME', NULL),
(70, 'accesed home page', '2015-07-27 18:11:13', 0, NULL, 'HOME', NULL),
(71, 'successfully logged in', '2015-07-27 18:11:18', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(72, 'accesed home page', '2015-07-27 18:23:54', 0, NULL, 'HOME', NULL),
(73, 'accesed home page', '2015-07-27 18:28:47', 0, NULL, 'HOME', NULL),
(74, 'accesed home page', '2015-07-27 18:44:50', 0, NULL, 'HOME', NULL),
(75, 'accesed home page', '2015-07-27 18:45:01', 0, NULL, 'HOME', NULL),
(76, 'accesed home page', '2015-07-27 18:48:26', 0, NULL, 'HOME', NULL),
(77, 'accesed home page', '2015-07-27 18:50:02', 0, NULL, 'HOME', NULL),
(78, 'accesed home page', '2015-07-27 18:53:03', 0, NULL, 'HOME', NULL),
(79, 'successfully logged in', '2015-07-27 18:53:55', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(80, 'logged out', '2015-07-27 18:56:07', 13, NULL, '', 'ADMINISTRATOR'),
(81, 'successfully logged in', '2015-07-27 18:56:12', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(82, 'successfully logged in', '2015-07-27 19:00:33', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(83, 'successfully logged in', '2015-07-27 19:14:53', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(84, 'successfully logged in', '2015-07-27 19:16:26', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(85, 'successfully logged in', '2015-07-27 19:17:09', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(86, 'successfully logged in', '2015-07-27 19:24:34', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(87, 'successfully logged in', '2015-07-27 19:29:35', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(88, 'accesed home page', '2015-07-27 20:50:58', 0, NULL, 'HOME', NULL),
(89, 'successfully logged in', '2015-07-27 20:51:06', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(90, 'successfully logged in', '2015-07-27 20:53:27', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(91, 'successfully logged in', '2015-07-27 20:53:31', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(92, 'successfully logged in', '2015-07-27 20:54:13', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(93, 'successfully logged in', '2015-07-27 20:58:49', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(94, 'successfully logged in', '2015-07-27 20:59:39', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(95, 'successfully logged in', '2015-07-27 21:00:13', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(96, 'successfully logged in', '2015-07-27 21:01:08', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(97, 'successfully logged in', '2015-07-27 21:08:26', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(98, 'successfully logged in', '2015-07-27 21:10:41', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(99, 'successfully logged in', '2015-07-28 08:46:53', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(100, 'successfully logged in', '2015-07-28 08:58:47', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(101, 'successfully logged in', '2015-07-28 09:00:05', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(102, 'successfully logged in', '2015-07-28 09:01:47', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(103, 'successfully logged in', '2015-07-28 09:03:06', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(104, 'successfully logged in', '2015-07-28 09:03:33', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(105, 'successfully logged in', '2015-07-28 09:04:09', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(106, 'successfully logged in', '2015-07-28 09:05:53', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(107, 'successfully logged in', '2015-07-28 09:07:45', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(108, 'successfully logged in', '2015-07-28 09:11:24', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(109, 'successfully logged in', '2015-07-28 09:12:24', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(110, 'successfully logged in', '2015-07-28 09:13:03', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(111, 'successfully logged in', '2015-07-28 09:19:05', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(112, 'successfully logged in', '2015-07-28 09:21:04', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(113, 'successfully logged in', '2015-07-28 09:21:45', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(114, 'successfully logged in', '2015-07-28 09:22:15', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(115, 'successfully logged in', '2015-07-28 09:31:36', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(116, 'successfully logged in', '2015-07-28 09:33:11', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(117, 'successfully logged in', '2015-07-28 09:34:38', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(118, 'successfully logged in', '2015-07-28 09:35:19', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(119, 'successfully logged in', '2015-07-28 09:35:47', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(120, 'logged out', '2015-07-28 09:36:02', 13, NULL, '', 'ADMINISTRATOR'),
(121, 'accesed home page', '2015-07-28 09:36:12', 0, NULL, 'HOME', NULL),
(122, 'accesed home page', '2015-07-28 09:37:35', 0, NULL, 'HOME', NULL),
(123, 'login attempt', '2015-07-28 09:37:48', 0, NULL, 'MEMBER_LOGIN', NULL),
(124, 'successfully logged in', '2015-07-28 09:37:55', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(125, 'logged out', '2015-07-28 09:38:14', 18, NULL, '', 'MEMBER'),
(126, 'accesed home page', '2015-07-28 11:29:19', 0, NULL, 'HOME', NULL),
(127, 'successfully logged in', '2015-07-28 11:29:45', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(128, 'logged out', '2015-07-28 11:31:35', 18, NULL, '', 'MEMBER'),
(129, 'successfully logged in', '2015-07-28 11:31:41', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(130, 'successfully logged in', '2015-07-28 11:32:41', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(131, 'successfully logged in', '2015-07-28 12:03:39', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(132, 'successfully logged in', '2015-07-28 12:05:13', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(133, 'successfully logged in', '2015-07-28 12:06:04', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(134, 'accesed home page', '2015-07-28 12:07:06', 0, NULL, 'HOME', NULL),
(135, 'successfully logged in', '2015-07-28 12:07:12', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(136, 'successfully logged in', '2015-07-28 12:08:08', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(137, 'successfully logged in', '2015-07-28 12:09:37', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(138, 'successfully logged in', '2015-07-28 12:12:48', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(139, 'successfully logged in', '2015-07-28 12:22:01', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(140, 'successfully logged in', '2015-07-28 12:32:43', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(141, 'logged out', '2015-07-28 12:34:39', 18, NULL, '', 'MEMBER'),
(142, 'login attempt', '2015-07-28 12:34:45', 0, NULL, 'ADMIN_LOGIN', NULL),
(143, 'successfully logged in', '2015-07-28 12:35:52', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(144, 'successfully logged in', '2015-07-28 12:35:59', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(145, 'successfully logged in', '2015-07-28 12:39:58', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(146, 'successfully logged in', '2015-07-28 12:42:04', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(147, 'successfully logged in', '2015-07-28 12:43:21', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(148, 'successfully logged in', '2015-07-28 13:02:17', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(149, 'accesed home page', '2015-07-28 13:14:43', 0, NULL, 'HOME', NULL),
(150, 'accesed home page', '2015-07-28 13:17:24', 0, NULL, 'HOME', NULL),
(151, 'accesed home page', '2015-07-28 13:17:38', 0, NULL, 'HOME', NULL),
(152, 'accesed home page', '2015-07-28 13:20:11', 0, NULL, 'HOME', NULL),
(153, 'accesed home page', '2015-07-28 13:20:22', 0, NULL, 'HOME', NULL),
(154, 'successfully logged in', '2015-07-28 13:59:26', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(155, 'logged out', '2015-07-28 14:10:29', 13, NULL, '', 'ADMINISTRATOR'),
(156, 'successfully logged in', '2015-07-28 14:14:29', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(157, 'successfully logged in', '2015-07-28 14:30:39', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(158, 'successfully logged in', '2015-07-28 14:35:26', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(159, 'successfully logged in', '2015-07-28 14:36:45', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(160, 'successfully logged in', '2015-07-28 14:40:04', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(161, 'successfully logged in', '2015-07-28 14:48:36', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(162, 'successfully logged in', '2015-07-28 14:51:14', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(163, 'successfully logged in', '2015-07-28 14:51:21', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(164, 'successfully logged in', '2015-07-28 14:52:54', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(165, 'successfully logged in', '2015-07-28 14:55:20', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(166, 'successfully logged in', '2015-07-28 15:00:13', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(167, 'successfully logged in', '2015-07-28 15:04:37', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(168, 'successfully logged in', '2015-07-28 15:09:14', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(169, 'successfully logged in', '2015-07-28 15:25:01', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(170, 'logged out', '2015-07-28 15:26:43', 18, NULL, '', 'MEMBER'),
(171, 'successfully logged in', '2015-07-28 15:26:48', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(172, 'successfully logged in', '2015-07-28 15:30:12', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(173, 'logged out', '2015-07-28 15:30:43', 13, NULL, '', 'ADMINISTRATOR'),
(174, 'successfully logged in', '2015-07-28 15:30:55', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(175, 'logged out', '2015-07-28 15:33:35', 18, NULL, '', 'MEMBER'),
(176, 'successfully logged in', '2015-07-28 15:33:40', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(177, 'successfully logged in', '2015-07-28 15:33:53', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(178, 'logged out', '2015-07-28 15:50:47', 13, NULL, '', 'ADMINISTRATOR'),
(179, 'successfully logged in', '2015-07-28 15:50:54', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(180, 'accesed home page', '2015-07-28 15:50:59', 0, NULL, 'HOME', NULL),
(181, 'successfully logged in', '2015-07-28 15:51:04', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(182, 'logged out', '2015-07-28 15:51:27', 18, NULL, '', 'MEMBER'),
(183, 'accesed home page', '2015-07-28 15:51:35', 0, NULL, 'HOME', NULL),
(184, 'successfully logged in', '2015-07-28 15:55:25', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(185, 'logged out', '2015-07-28 15:57:38', 18, NULL, '', 'MEMBER'),
(186, 'accesed home page', '2015-07-28 15:57:45', 0, NULL, 'HOME', NULL),
(187, 'successfully logged in', '2015-07-28 15:57:54', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(188, 'logged out', '2015-07-28 16:09:56', 18, NULL, '', 'MEMBER'),
(189, 'successfully logged in', '2015-07-28 16:10:02', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(190, 'successfully logged in', '2015-07-28 16:10:10', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(191, 'logged out', '2015-07-28 16:12:43', 13, NULL, '', 'ADMINISTRATOR'),
(192, 'accesed home page', '2015-07-28 16:12:47', 0, NULL, 'HOME', NULL),
(193, 'successfully logged in', '2015-07-28 16:12:55', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(194, 'logged out', '2015-07-28 16:22:54', 18, NULL, '', 'MEMBER'),
(195, 'successfully logged in', '2015-07-28 16:23:01', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(196, 'successfully logged in', '2015-07-28 16:23:13', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(197, 'successfully logged in', '2015-07-28 16:24:18', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(198, 'logged out', '2015-07-28 16:26:09', 13, NULL, '', 'ADMINISTRATOR'),
(199, 'successfully logged in', '2015-07-28 16:26:33', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(200, 'logged out', '2015-07-28 16:32:33', 18, NULL, '', 'MEMBER'),
(201, 'successfully logged in', '2015-07-28 16:32:38', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(202, 'successfully logged in', '2015-07-28 16:47:24', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(203, 'successfully logged in', '2015-07-28 16:47:29', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(204, 'successfully logged in', '2015-07-28 16:47:33', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(205, 'successfully logged in', '2015-07-28 16:47:46', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(206, 'successfully logged in', '2015-07-28 16:49:53', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(207, 'logged out', '2015-07-28 17:03:51', 13, NULL, '', 'ADMINISTRATOR'),
(208, 'successfully logged in', '2015-07-28 17:03:57', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(209, 'successfully logged in', '2015-07-28 17:04:13', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(210, 'logged out', '2015-07-28 17:05:35', 18, NULL, '', 'MEMBER'),
(211, 'successfully logged in', '2015-07-28 17:05:40', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(212, 'successfully logged in', '2015-07-28 17:05:44', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(213, 'logged out', '2015-07-28 17:08:44', 13, NULL, '', 'ADMINISTRATOR'),
(214, 'successfully logged in', '2015-07-28 17:08:58', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(215, 'logged out', '2015-07-28 17:16:40', 18, NULL, '', 'MEMBER'),
(216, 'accesed home page', '2015-07-31 04:04:37', 0, NULL, 'HOME', NULL),
(217, 'accesed home page', '2015-07-31 04:05:21', 0, NULL, 'HOME', NULL),
(218, 'login attempt', '2015-07-31 04:05:58', 0, NULL, 'MEMBER_LOGIN', NULL),
(219, 'login attempt', '2015-07-31 04:06:25', 0, NULL, 'MEMBER_LOGIN', NULL),
(220, 'login attempt', '2015-07-31 04:17:10', 0, NULL, 'MEMBER_LOGIN', NULL),
(221, 'accesed home page', '2015-07-31 04:17:33', 0, NULL, 'HOME', NULL),
(222, 'successfully logged in', '2015-07-31 04:17:47', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(223, 'accesed home page', '2015-07-31 08:38:54', 0, NULL, 'HOME', NULL),
(224, 'successfully logged in', '2015-07-31 08:42:28', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(225, 'successfully logged in', '2015-07-31 08:50:01', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(226, 'successfully logged in', '2015-07-31 09:07:11', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(227, 'successfully logged in', '2015-07-31 09:14:48', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(228, 'successfully logged in', '2015-07-31 09:17:21', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(229, 'successfully logged in', '2015-07-31 09:19:18', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(230, 'logged out', '2015-07-31 09:23:24', 13, NULL, '', 'ADMINISTRATOR'),
(231, 'login attempt', '2015-07-31 09:23:33', 0, NULL, 'MEMBER_LOGIN', NULL),
(232, 'successfully logged in', '2015-07-31 09:23:42', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(233, 'successfully logged in', '2015-07-31 09:27:46', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(234, 'successfully logged in', '2015-07-31 09:38:10', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(235, 'successfully logged in', '2015-07-31 09:38:39', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(236, 'logged out', '2015-07-31 09:39:03', 13, NULL, '', 'ADMINISTRATOR'),
(237, 'successfully logged in', '2015-07-31 09:44:35', 18, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(238, 'successfully logged in', '2015-07-31 09:45:35', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(239, 'successfully logged in', '2015-07-31 09:49:24', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(240, 'successfully logged in', '2015-07-31 09:52:28', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(241, 'successfully logged in', '2015-07-31 09:54:24', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(242, 'successfully logged in', '2015-07-31 10:08:20', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(243, 'accesed home page', '2015-07-31 10:08:38', 0, NULL, 'HOME', NULL),
(244, 'successfully logged in', '2015-07-31 10:11:05', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(245, 'logged out', '2015-07-31 10:11:54', 13, NULL, '', 'ADMINISTRATOR'),
(246, 'successfully logged in', '2015-07-31 10:12:22', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(247, 'successfully logged in', '2015-07-31 10:20:31', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(248, 'successfully logged in', '2015-07-31 10:22:37', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(249, 'successfully logged in', '2015-07-31 10:23:28', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(250, 'successfully logged in', '2015-07-31 10:24:09', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(251, 'login attempt', '2015-07-31 10:28:14', 0, NULL, 'MEMBER_LOGIN', NULL),
(252, 'successfully logged in', '2015-07-31 10:28:29', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(253, 'successfully logged in', '2015-07-31 10:37:12', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(254, 'successfully logged in', '2015-07-31 10:38:01', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(255, 'successfully logged in', '2015-07-31 10:39:51', 18, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(256, 'accesed home page', '2015-07-31 12:31:12', 0, NULL, 'HOME', NULL),
(257, 'accesed home page', '2015-07-31 12:31:37', 0, NULL, 'HOME', NULL),
(258, 'accesed home page', '2015-07-31 12:31:55', 0, NULL, 'HOME', NULL),
(259, 'accesed home page', '2015-07-31 12:51:18', 0, NULL, 'HOME', NULL),
(260, 'accesed home page', '2015-07-31 12:52:23', 0, NULL, 'HOME', NULL),
(261, 'successfully logged in', '2015-07-31 13:02:37', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(262, 'successfully logged in', '2015-07-31 13:09:17', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(263, 'logged out', '2015-07-31 13:49:39', 13, NULL, '', 'ADMINISTRATOR'),
(264, 'successfully logged in', '2015-07-31 13:54:20', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(265, 'successfully logged in', '2015-07-31 14:14:39', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(266, 'successfully logged in', '2015-07-31 14:14:55', 13, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(267, 'logged out', '2015-07-31 14:15:05', 13, NULL, '', 'ADMINISTRATOR'),
(268, 'accesed home page', '2015-07-31 14:15:10', 0, NULL, 'HOME', NULL),
(269, 'accesed home page', '2015-07-31 14:51:28', 0, NULL, 'HOME', NULL),
(270, 'successfully logged in', '2015-07-31 14:52:01', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(271, 'accesed home page', '2015-07-31 14:59:27', 0, NULL, 'HOME', NULL),
(272, 'successfully logged in', '2015-07-31 14:59:50', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(273, 'successfully logged in', '2015-07-31 15:01:52', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(274, 'successfully logged in', '2015-07-31 15:12:58', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(275, 'successfully logged in', '2015-07-31 15:15:05', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(276, 'logged out', '2015-07-31 15:15:34', 19, NULL, '', 'ADMINISTRATOR'),
(277, 'successfully logged in', '2015-07-31 15:15:41', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(278, 'login attempt', '2015-07-31 15:18:38', 0, NULL, 'ADMIN_LOGIN', NULL),
(279, 'successfully logged in', '2015-07-31 15:18:46', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(280, 'successfully logged in', '2015-07-31 15:20:50', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(281, 'successfully logged in', '2015-07-31 15:21:48', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(282, 'successfully logged in', '2015-07-31 15:23:36', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(283, 'successfully logged in', '2015-07-31 15:25:48', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(284, 'logged out', '2015-07-31 15:29:18', 19, NULL, '', 'ADMINISTRATOR'),
(285, 'accesed home page', '2015-07-31 15:29:25', 0, NULL, 'HOME', NULL),
(286, 'accesed home page', '2015-07-31 15:33:45', 0, NULL, 'HOME', NULL),
(287, 'successfully logged in', '2015-07-31 16:27:15', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(288, 'logged out', '2015-07-31 16:28:00', 20, NULL, '', 'MEMBER'),
(289, 'successfully logged in', '2015-07-31 16:28:08', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(290, 'login attempt', '2015-07-31 16:29:55', 0, NULL, 'ADMIN_LOGIN', NULL),
(291, 'successfully logged in', '2015-07-31 16:30:09', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(292, 'successfully logged in', '2015-07-31 16:51:56', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(293, 'successfully logged in', '2015-07-31 16:53:04', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(294, 'successfully logged in', '2015-07-31 16:57:26', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(295, 'logged out', '2015-07-31 16:58:29', 19, NULL, '', 'ADMINISTRATOR'),
(296, 'successfully logged in', '2015-07-31 16:58:41', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(297, 'successfully logged in', '2015-07-31 17:04:04', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(298, 'successfully logged in', '2015-07-31 17:04:41', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(299, 'successfully logged in', '2015-07-31 17:05:46', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(300, 'logged out', '2015-07-31 17:10:45', 20, NULL, '', 'MEMBER'),
(301, 'successfully logged in', '2015-07-31 17:10:52', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(302, 'successfully logged in', '2015-07-31 17:16:52', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(303, 'logged out', '2015-07-31 17:19:02', 19, NULL, '', 'ADMINISTRATOR'),
(304, 'successfully logged in', '2015-07-31 17:19:11', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(305, 'successfully logged in', '2015-07-31 17:26:14', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(306, 'accesed home page', '2015-08-03 11:48:26', 0, NULL, 'HOME', NULL),
(307, 'accesed home page', '2015-08-03 11:49:38', 0, NULL, 'HOME', NULL),
(308, 'accesed home page', '2015-08-03 11:49:39', 0, NULL, 'HOME', NULL),
(309, 'accesed home page', '2015-08-03 11:50:12', 0, NULL, 'HOME', NULL),
(310, 'accesed home page', '2015-08-03 13:05:46', 0, NULL, 'HOME', NULL),
(311, 'accesed home page', '2015-08-03 13:11:19', 0, NULL, 'HOME', NULL),
(312, 'successfully logged in', '2015-08-03 13:14:39', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(313, 'login attempt', '2015-08-03 13:16:27', 0, NULL, 'ADMIN_LOGIN', NULL),
(314, 'successfully logged in', '2015-08-03 13:16:44', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(315, 'logged out', '2015-08-03 13:17:12', 19, NULL, '', 'ADMINISTRATOR'),
(316, 'accesed home page', '2015-08-03 13:17:49', 0, NULL, 'HOME', NULL),
(317, 'accesed home page', '2015-08-03 14:28:32', 0, NULL, 'HOME', NULL),
(318, 'successfully logged in', '2015-08-03 14:29:35', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(319, 'successfully logged in', '2015-08-03 14:33:52', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(320, 'successfully logged in', '2015-08-03 14:37:14', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(321, 'successfully logged in', '2015-08-03 14:38:04', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(322, 'successfully logged in', '2015-08-03 14:46:13', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(323, 'successfully logged in', '2015-08-03 14:47:19', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(324, 'successfully logged in', '2015-08-03 14:50:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(325, 'successfully logged in', '2015-08-03 14:50:53', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(326, 'successfully logged in', '2015-08-03 14:51:44', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(327, 'successfully logged in', '2015-08-03 14:54:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(328, 'successfully logged in', '2015-08-03 14:56:10', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(329, 'successfully logged in', '2015-08-03 14:58:03', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(330, 'successfully logged in', '2015-08-03 14:59:37', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(331, 'successfully logged in', '2015-08-03 15:00:27', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(332, 'successfully logged in', '2015-08-03 15:36:14', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(333, 'accesed home page', '2015-08-03 15:36:23', 0, NULL, 'HOME', NULL),
(334, 'successfully logged in', '2015-08-03 15:55:29', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(335, 'successfully logged in', '2015-08-03 16:00:59', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(336, 'successfully logged in', '2015-08-03 16:01:36', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(337, 'successfully logged in', '2015-08-03 16:21:43', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(338, 'successfully logged in', '2015-08-03 16:23:26', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(339, 'successfully logged in', '2015-08-03 16:24:23', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(340, 'successfully logged in', '2015-08-03 16:31:37', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(341, 'successfully logged in', '2015-08-03 16:40:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(342, 'successfully logged in', '2015-08-04 02:50:43', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(343, 'successfully logged in', '2015-08-04 02:57:30', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(344, 'successfully logged in', '2015-08-04 03:05:59', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(345, 'successfully logged in', '2015-08-04 03:08:49', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(346, 'successfully logged in', '2015-08-04 03:12:05', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(347, 'successfully logged in', '2015-08-04 03:13:59', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(348, 'successfully logged in', '2015-08-04 03:15:38', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(349, 'successfully logged in', '2015-08-04 03:21:16', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(350, 'logged out', '2015-08-04 03:26:28', 19, NULL, '', 'ADMINISTRATOR'),
(351, 'accesed home page', '2015-08-04 03:26:34', 0, NULL, 'HOME', NULL),
(352, 'accesed home page', '2015-08-04 03:27:44', 0, NULL, 'HOME', NULL),
(353, 'login attempt', '2015-08-04 04:20:28', 0, NULL, 'MEMBER_LOGIN', NULL),
(354, 'accesed home page', '2015-08-04 04:20:47', 0, NULL, 'HOME', NULL),
(355, 'login attempt', '2015-08-04 04:20:55', 0, NULL, 'MEMBER_LOGIN', NULL),
(356, 'accesed home page', '2015-08-04 04:21:21', 0, NULL, 'HOME', NULL),
(357, 'accesed home page', '2015-08-04 04:28:37', 0, NULL, 'HOME', NULL),
(358, 'accesed home page', '2015-08-04 04:39:01', 0, NULL, 'HOME', NULL),
(359, 'accesed home page', '2015-08-04 04:40:11', 0, NULL, 'HOME', NULL),
(360, 'accesed home page', '2015-08-04 04:40:16', 0, NULL, 'HOME', NULL),
(361, 'accesed home page', '2015-08-04 04:49:56', 0, NULL, 'HOME', NULL),
(362, 'accesed home page', '2015-08-04 04:51:09', 0, NULL, 'HOME', NULL),
(363, 'accesed home page', '2015-08-04 04:58:54', 0, NULL, 'HOME', NULL),
(364, 'accesed home page', '2015-08-04 07:08:51', 0, NULL, 'HOME', NULL),
(365, 'accesed home page', '2015-08-04 07:10:53', 0, NULL, 'HOME', NULL),
(366, 'accesed home page', '2015-08-04 07:11:31', 0, NULL, 'HOME', NULL),
(367, 'login attempt', '2015-08-04 07:17:11', 0, NULL, 'ADMIN_LOGIN', NULL),
(368, 'successfully logged in', '2015-08-04 07:17:19', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(369, 'successfully logged in', '2015-08-04 10:17:25', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(370, 'successfully logged in', '2015-08-04 12:35:53', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(371, 'successfully logged in', '2015-08-04 14:38:14', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(372, 'successfully logged in', '2015-08-04 14:45:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(373, 'successfully logged in', '2015-08-04 14:49:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(374, 'successfully logged in', '2015-08-04 14:53:56', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(375, 'login attempt', '2015-08-04 15:31:12', 0, NULL, 'ADMIN_LOGIN', NULL),
(376, 'successfully logged in', '2015-08-04 15:31:21', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(377, 'successfully logged in', '2015-08-04 15:34:38', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(378, 'logged out', '2015-08-04 15:35:29', 19, NULL, '', 'ADMINISTRATOR'),
(379, 'login attempt', '2015-08-04 15:50:11', 0, NULL, 'MEMBER_LOGIN', NULL),
(380, 'successfully logged in', '2015-08-04 15:59:55', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(381, 'login attempt', '2015-08-04 16:21:43', 0, NULL, 'MEMBER_LOGIN', NULL),
(382, 'successfully logged in', '2015-08-04 16:21:57', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(383, 'successfully logged in', '2015-08-04 16:23:01', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(384, 'successfully logged in', '2015-08-04 16:24:45', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(385, 'accesed home page', '2015-08-04 16:28:24', 0, NULL, 'HOME', NULL),
(386, 'successfully logged in', '2015-08-04 16:52:29', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(387, 'successfully logged in', '2015-08-04 18:02:42', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(388, 'successfully logged in', '2015-08-04 18:05:04', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(389, 'successfully logged in', '2015-08-04 18:06:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(390, 'successfully logged in', '2015-08-04 18:07:04', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(391, 'successfully logged in', '2015-08-04 18:08:16', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(392, 'successfully logged in', '2015-08-04 18:13:47', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(393, 'logged out', '2015-08-04 18:34:10', 19, NULL, '', 'ADMINISTRATOR'),
(394, 'accesed home page', '2015-08-04 18:34:18', 0, NULL, 'HOME', NULL),
(395, 'accesed home page', '2015-08-04 18:38:49', 0, NULL, 'HOME', NULL),
(396, 'successfully logged in', '2015-08-04 18:45:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(397, 'accesed home page', '2015-08-04 18:58:24', 0, NULL, 'HOME', NULL),
(398, 'successfully logged in', '2015-08-04 18:59:10', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(399, 'login attempt', '2015-08-04 19:01:31', 0, NULL, 'ADMIN_LOGIN', NULL),
(400, 'successfully logged in', '2015-08-04 19:01:46', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(401, 'logged out', '2015-08-04 19:44:14', 19, NULL, '', 'ADMINISTRATOR'),
(402, 'successfully logged in', '2015-08-04 19:44:36', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(403, 'accesed home page', '2015-08-06 03:32:33', 0, NULL, 'HOME', NULL),
(404, 'accesed home page', '2015-08-06 03:35:30', 0, NULL, 'HOME', NULL),
(405, 'accesed home page', '2015-08-06 03:36:03', 0, NULL, 'HOME', NULL),
(406, 'accesed home page', '2015-08-06 03:37:26', 0, NULL, 'HOME', NULL),
(407, 'successfully logged in', '2015-08-06 03:56:26', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(408, 'successfully logged in', '2015-08-06 03:58:43', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(409, 'successfully logged in', '2015-08-06 04:11:35', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(410, 'successfully logged in', '2015-08-06 04:12:52', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(411, 'successfully logged in', '2015-08-06 04:14:15', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(412, 'successfully logged in', '2015-08-06 04:16:55', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(413, 'successfully logged in', '2015-08-06 04:18:19', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(414, 'login attempt', '2015-08-06 04:22:34', 0, NULL, 'MEMBER_LOGIN', NULL),
(415, 'successfully logged in', '2015-08-06 04:22:41', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(416, 'successfully logged in', '2015-08-06 04:24:52', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(417, 'successfully logged in', '2015-08-06 04:27:23', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(418, 'successfully logged in', '2015-08-06 04:28:02', 20, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(419, 'successfully logged in', '2015-08-06 04:28:08', 20, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(420, 'successfully logged in', '2015-08-06 04:28:17', 20, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(421, 'successfully logged in', '2015-08-06 04:28:42', 20, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(422, 'successfully logged in', '2015-08-06 04:28:46', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(423, 'successfully logged in', '2015-08-06 04:34:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(424, 'successfully logged in', '2015-08-06 04:48:38', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(425, 'successfully logged in', '2015-08-06 04:52:21', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(426, 'successfully logged in', '2015-08-06 04:53:01', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(427, 'logged out', '2015-08-06 04:54:50', 19, NULL, '', 'ADMINISTRATOR'),
(428, 'successfully logged in', '2015-08-06 04:55:06', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(429, 'successfully logged in', '2015-08-06 04:56:20', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(430, 'accesed home page', '2015-08-06 17:20:15', 0, NULL, 'HOME', NULL),
(431, 'successfully logged in', '2015-08-06 17:20:31', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(432, 'accesed home page', '2015-08-06 20:03:27', 0, NULL, 'HOME', NULL),
(433, 'successfully logged in', '2015-08-06 20:26:31', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(434, 'successfully logged in', '2015-08-06 21:56:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(435, 'successfully logged in', '2015-08-06 21:59:15', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(436, 'successfully logged in', '2015-08-06 22:00:19', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(437, 'successfully logged in', '2015-08-06 22:01:14', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(438, 'successfully logged in', '2015-08-06 22:02:49', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(439, 'successfully logged in', '2015-08-06 22:03:49', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(440, 'successfully logged in', '2015-08-06 22:06:15', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(441, 'successfully logged in', '2015-08-06 22:07:49', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(442, 'accesed home page', '2015-08-07 09:38:49', 0, NULL, 'HOME', NULL),
(443, 'accesed home page', '2015-08-07 09:41:16', 0, NULL, 'HOME', NULL),
(444, 'login attempt', '2015-08-07 09:41:42', 0, NULL, 'ADMIN_LOGIN', NULL),
(445, 'successfully logged in', '2015-08-07 09:42:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(446, 'logged out', '2015-08-07 10:18:08', 19, NULL, '', 'ADMINISTRATOR'),
(447, 'successfully logged in', '2015-08-07 10:19:09', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(448, 'login attempt', '2015-08-07 10:49:40', 0, NULL, 'MEMBER_LOGIN', NULL),
(449, 'successfully logged in', '2015-08-07 10:49:56', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(450, 'successfully logged in', '2015-08-07 10:51:13', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(451, 'successfully logged in', '2015-08-07 10:52:01', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(452, 'successfully logged in', '2015-08-07 10:52:59', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(453, 'successfully logged in', '2015-08-07 11:09:18', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(454, 'successfully logged in', '2015-08-07 11:11:20', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(455, 'successfully logged in', '2015-08-07 11:12:40', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(456, 'successfully logged in', '2015-08-07 11:14:57', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(457, 'successfully logged in', '2015-08-07 12:07:16', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(458, 'login attempt', '2015-08-07 12:14:18', 0, NULL, 'MEMBER_LOGIN', NULL),
(459, 'login attempt', '2015-08-07 12:15:00', 0, NULL, 'MEMBER_LOGIN', NULL),
(460, 'login attempt', '2015-08-07 12:15:17', 0, NULL, 'MEMBER_LOGIN', NULL),
(461, 'successfully logged in', '2015-08-07 12:15:30', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(462, 'successfully logged in', '2015-08-07 12:18:56', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(463, 'successfully logged in', '2015-08-07 12:45:34', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(464, 'successfully logged in', '2015-08-07 12:46:37', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(465, 'successfully logged in', '2015-08-07 13:20:28', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(466, 'successfully logged in', '2015-08-07 13:22:50', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(467, 'successfully logged in', '2015-08-07 13:24:42', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(468, 'logged out', '2015-08-07 13:25:27', 20, NULL, '', 'MEMBER'),
(469, 'successfully logged in', '2015-08-07 13:28:25', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(470, 'successfully logged in', '2015-08-07 14:13:45', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(471, 'successfully logged in', '2015-08-07 14:17:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(472, 'successfully logged in', '2015-08-07 14:26:49', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(473, 'successfully logged in', '2015-08-07 14:30:51', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(474, 'successfully logged in', '2015-08-07 14:33:41', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(475, 'successfully logged in', '2015-08-07 14:36:26', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(476, 'successfully logged in', '2015-08-07 14:41:01', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(477, 'successfully logged in', '2015-08-07 14:42:23', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(478, 'successfully logged in', '2015-08-07 14:43:36', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(479, 'successfully logged in', '2015-08-07 14:45:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(480, 'successfully logged in', '2015-08-07 14:53:41', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(481, 'successfully logged in', '2015-08-07 14:56:26', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(482, 'successfully logged in', '2015-08-07 14:56:59', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(483, 'logged out', '2015-08-07 14:59:25', 19, NULL, '', 'ADMINISTRATOR'),
(484, 'successfully logged in', '2015-08-07 14:59:40', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(485, 'successfully logged in', '2015-08-07 15:03:15', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(486, 'successfully logged in', '2015-08-07 15:26:28', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(487, 'accesed home page', '2015-08-07 15:27:58', 0, NULL, 'HOME', NULL),
(488, 'successfully logged in', '2015-08-07 15:28:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(489, 'successfully logged in', '2015-08-07 15:32:49', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(490, 'successfully logged in', '2015-08-07 15:34:28', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(491, 'successfully logged in', '2015-08-07 15:38:12', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(492, 'successfully logged in', '2015-08-07 15:40:23', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(493, 'successfully logged in', '2015-08-07 15:57:01', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(494, 'accesed home page', '2015-08-07 16:01:04', 0, NULL, 'HOME', NULL),
(495, 'successfully logged in', '2015-08-07 16:03:58', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(496, 'successfully logged in', '2015-08-07 16:08:13', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(497, 'successfully logged in', '2015-08-07 16:09:17', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(498, 'successfully logged in', '2015-08-07 16:19:14', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(499, 'successfully logged in', '2015-08-07 16:23:59', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(500, 'successfully logged in', '2015-08-07 16:35:44', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(501, 'successfully logged in', '2015-08-07 16:37:18', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(502, 'successfully logged in', '2015-08-07 16:42:40', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(503, 'logged out', '2015-08-07 16:43:51', 20, NULL, '', 'MEMBER'),
(504, 'successfully logged in', '2015-08-07 16:44:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(505, 'successfully logged in', '2015-08-07 16:46:36', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(506, 'successfully logged in', '2015-08-07 17:01:25', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(507, 'successfully logged in', '2015-08-07 17:20:37', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(508, 'successfully logged in', '2015-08-07 17:21:22', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(509, 'successfully logged in', '2015-08-07 17:22:14', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(510, 'successfully logged in', '2015-08-07 17:22:56', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(511, 'successfully logged in', '2015-08-07 17:24:28', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(512, 'successfully logged in', '2015-08-07 17:25:03', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(513, 'successfully logged in', '2015-08-07 17:57:53', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(514, 'successfully logged in', '2015-08-07 18:04:43', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(515, 'successfully logged in', '2015-08-07 18:05:36', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(516, 'accesed home page', '2015-08-07 18:34:49', 0, NULL, 'HOME', NULL),
(517, 'login attempt', '2015-08-07 18:35:17', 0, NULL, 'MEMBER_LOGIN', NULL),
(518, 'login attempt', '2015-08-07 18:36:08', 0, NULL, 'MEMBER_LOGIN', NULL),
(519, 'login attempt', '2015-08-07 18:36:12', 0, NULL, 'MEMBER_LOGIN', NULL),
(520, 'login attempt', '2015-08-07 18:36:17', 0, NULL, 'MEMBER_LOGIN', NULL),
(521, 'successfully logged in', '2015-08-07 18:36:25', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(522, 'successfully logged in', '2015-08-07 18:38:08', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(523, 'successfully logged in', '2015-08-07 18:48:03', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(524, 'successfully logged in', '2015-08-07 18:50:36', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(525, 'logged out', '2015-08-07 18:52:52', 20, NULL, '', 'MEMBER'),
(526, 'successfully logged in', '2015-08-07 18:53:02', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(527, 'successfully logged in', '2015-08-07 19:02:51', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(528, 'successfully logged in', '2015-08-07 19:05:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(529, 'successfully logged in', '2015-08-07 19:11:39', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(530, 'successfully logged in', '2015-08-07 19:12:14', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(531, 'successfully logged in', '2015-08-07 19:15:22', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(532, 'successfully logged in', '2015-08-07 19:16:50', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(533, 'successfully logged in', '2015-08-07 19:24:09', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(534, 'successfully logged in', '2015-08-07 19:34:09', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(535, 'successfully logged in', '2015-08-07 19:36:39', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(536, 'successfully logged in', '2015-08-07 19:38:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(537, 'successfully logged in', '2015-08-07 19:39:27', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(538, 'successfully logged in', '2015-08-07 19:42:45', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(539, 'successfully logged in', '2015-08-07 19:43:20', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(540, 'successfully logged in', '2015-08-07 19:44:08', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(541, 'successfully logged in', '2015-08-07 19:44:52', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(542, 'successfully logged in', '2015-08-07 19:51:19', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(543, 'successfully logged in', '2015-08-07 19:54:16', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(544, 'successfully logged in', '2015-08-07 19:54:32', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(545, 'logged out', '2015-08-07 19:55:20', 20, NULL, '', 'MEMBER'),
(546, 'successfully logged in', '2015-08-07 19:56:12', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(547, 'successfully logged in', '2015-08-07 20:00:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(548, 'successfully logged in', '2015-08-07 20:03:23', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(549, 'successfully logged in', '2015-08-07 20:07:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(550, 'successfully logged in', '2015-08-07 20:07:44', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(551, 'successfully logged in', '2015-08-07 20:16:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(552, 'successfully logged in', '2015-08-07 20:18:20', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(553, 'successfully logged in', '2015-08-07 20:20:42', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(554, 'successfully logged in', '2015-08-07 20:22:33', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(555, 'accesed home page', '2015-08-08 09:22:15', 0, NULL, 'HOME', NULL),
(556, 'successfully logged in', '2015-08-08 09:22:37', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(557, 'successfully logged in', '2015-08-08 09:45:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(558, 'successfully logged in', '2015-08-08 09:46:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(559, 'successfully logged in', '2015-08-08 09:49:24', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(560, 'successfully logged in', '2015-08-08 09:51:19', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(561, 'successfully logged in', '2015-08-08 09:56:43', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(562, 'successfully logged in', '2015-08-08 09:59:43', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(563, 'successfully logged in', '2015-08-08 10:22:08', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(564, 'successfully logged in', '2015-08-08 10:26:48', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(565, 'accesed home page', '2015-08-08 10:28:25', 0, NULL, 'HOME', NULL),
(566, 'accesed home page', '2015-08-08 10:28:27', 0, NULL, 'HOME', NULL),
(567, 'successfully logged in', '2015-08-08 10:29:09', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(568, 'logged out', '2015-08-08 10:38:53', 19, NULL, '', 'ADMINISTRATOR'),
(569, 'accesed home page', '2015-08-08 10:38:59', 0, NULL, 'HOME', NULL),
(570, 'successfully logged in', '2015-08-08 11:11:29', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(571, 'successfully logged in', '2015-08-08 11:20:41', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR');
INSERT INTO `tbl_activity_logs` (`id`, `description`, `datetime`, `user_id`, `scheme`, `access_menu`, `userProfile`) VALUES
(572, 'successfully logged in', '2015-08-08 11:24:15', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(573, 'successfully logged in', '2015-08-08 11:29:43', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(574, 'successfully logged in', '2015-08-08 11:30:58', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(575, 'successfully logged in', '2015-08-08 11:41:18', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(576, 'successfully logged in', '2015-08-08 11:57:03', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(577, 'successfully logged in', '2015-08-08 11:58:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(578, 'successfully logged in', '2015-08-08 12:00:23', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(579, 'successfully logged in', '2015-08-08 12:08:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(580, 'successfully logged in', '2015-08-08 13:58:20', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(581, 'successfully logged in', '2015-08-08 14:00:15', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(582, 'successfully logged in', '2015-08-08 14:21:17', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(583, 'successfully logged in', '2015-08-08 14:24:11', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(584, 'accesed home page', '2015-08-08 14:27:37', 0, NULL, 'HOME', NULL),
(585, 'accesed home page', '2015-08-08 14:40:34', 0, NULL, 'HOME', NULL),
(586, 'successfully logged in', '2015-08-08 14:44:55', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(587, 'successfully logged in', '2015-08-08 14:47:57', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(588, 'successfully logged in', '2015-08-08 14:49:21', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(589, 'successfully logged in', '2015-08-08 15:03:16', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(590, 'successfully logged in', '2015-08-08 15:14:18', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(591, 'successfully logged in', '2015-08-08 15:16:29', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(592, 'successfully logged in', '2015-08-08 15:43:51', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(593, 'successfully logged in', '2015-08-08 15:47:41', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(594, 'successfully logged in', '2015-08-08 15:49:38', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(595, 'successfully logged in', '2015-08-08 16:00:56', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(596, 'successfully logged in', '2015-08-08 16:02:42', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(597, 'successfully logged in', '2015-08-08 16:04:59', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(598, 'successfully logged in', '2015-08-08 16:08:45', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(599, 'successfully logged in', '2015-08-08 21:43:01', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(600, 'successfully logged in', '2015-08-08 21:44:24', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(601, 'login attempt', '2015-08-09 10:16:54', 0, NULL, 'MEMBER_LOGIN', NULL),
(602, 'successfully logged in', '2015-08-09 10:17:43', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(603, 'successfully logged in', '2015-08-09 11:02:02', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(604, 'login attempt', '2015-08-09 11:02:16', 0, NULL, 'MEMBER_LOGIN', NULL),
(605, 'login attempt', '2015-08-09 11:05:33', 0, NULL, 'MEMBER_LOGIN', NULL),
(606, 'successfully logged in', '2015-08-09 11:05:43', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(607, 'login attempt', '2015-08-09 11:11:40', 0, NULL, 'MEMBER_LOGIN', NULL),
(608, 'login attempt', '2015-08-09 11:11:49', 0, NULL, 'MEMBER_LOGIN', NULL),
(609, 'login attempt', '2015-08-09 11:24:10', 0, NULL, 'MEMBER_LOGIN', NULL),
(610, 'login attempt', '2015-08-09 11:24:16', 0, NULL, 'MEMBER_LOGIN', NULL),
(611, 'successfully logged in', '2015-08-09 11:24:43', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(612, 'logged out', '2015-08-09 11:25:24', 20, NULL, '', 'MEMBER'),
(613, 'login attempt', '2015-08-09 11:28:31', 0, NULL, 'MEMBER_LOGIN', NULL),
(614, 'successfully logged in', '2015-08-09 11:28:36', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(615, 'logged out', '2015-08-09 11:29:11', 20, NULL, '', 'MEMBER'),
(616, 'successfully logged in', '2015-08-09 11:29:27', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(617, 'logged out', '2015-08-09 11:29:37', 20, NULL, '', 'MEMBER'),
(618, 'successfully logged in', '2015-08-09 11:29:46', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(619, 'successfully logged in', '2015-08-09 11:32:57', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(620, 'successfully logged in', '2015-08-09 11:34:02', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(621, 'successfully logged in', '2015-08-09 11:37:33', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(622, 'successfully logged in', '2015-08-09 11:51:45', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(623, 'successfully logged in', '2015-08-09 11:53:37', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(624, 'successfully logged in', '2015-08-09 11:55:17', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(625, 'logged out', '2015-08-09 11:58:12', 20, NULL, '', 'MEMBER'),
(626, 'successfully logged in', '2015-08-09 12:39:25', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(627, 'login attempt', '2015-08-09 12:39:25', 0, NULL, 'MEMBER_LOGIN', NULL),
(628, 'successfully logged in', '2015-08-09 12:39:38', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(629, 'login attempt', '2015-08-09 12:39:38', 0, NULL, 'MEMBER_LOGIN', NULL),
(630, 'login attempt', '2015-08-09 12:39:47', 0, NULL, 'MEMBER_LOGIN', NULL),
(631, 'successfully logged in', '2015-08-09 12:40:23', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(632, 'login attempt', '2015-08-09 12:40:23', 0, NULL, 'MEMBER_LOGIN', NULL),
(633, 'successfully logged in', '2015-08-09 12:40:57', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(634, 'login attempt', '2015-08-09 12:40:57', 0, NULL, 'MEMBER_LOGIN', NULL),
(635, 'successfully logged in', '2015-08-09 12:41:31', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(636, 'login attempt', '2015-08-09 12:41:31', 0, NULL, 'MEMBER_LOGIN', NULL),
(637, 'successfully logged in', '2015-08-09 12:53:25', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(638, 'successfully logged in', '2015-08-09 12:54:36', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(639, 'successfully logged in', '2015-08-09 12:57:52', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(640, 'successfully logged in', '2015-08-09 12:59:38', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(641, 'successfully logged in', '2015-08-09 13:10:35', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(642, 'successfully logged in', '2015-08-09 14:14:09', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(643, 'successfully logged in', '2015-08-09 14:17:32', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(644, 'successfully logged in', '2015-08-09 16:00:25', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(645, 'successfully logged in', '2015-08-09 17:34:31', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(646, 'successfully logged in', '2015-08-09 17:35:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(647, 'successfully logged in', '2015-08-09 17:37:22', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(648, 'successfully logged in', '2015-08-09 17:38:53', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(649, 'successfully logged in', '2015-08-09 17:39:49', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(650, 'successfully logged in', '2015-08-09 17:41:05', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(651, 'successfully logged in', '2015-08-09 18:35:28', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(652, 'successfully logged in', '2015-08-09 18:38:20', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(653, 'successfully logged in', '2015-08-09 18:40:39', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(654, 'successfully logged in', '2015-08-09 18:43:32', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(655, 'successfully logged in', '2015-08-09 18:47:35', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(656, 'successfully logged in', '2015-08-09 18:48:34', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(657, 'successfully logged in', '2015-08-09 19:08:05', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(658, 'successfully logged in', '2015-08-09 19:08:11', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(659, 'successfully logged in', '2015-08-09 19:12:37', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(660, 'successfully logged in', '2015-08-09 19:13:27', 20, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(661, 'successfully logged in', '2015-08-09 19:24:56', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(662, 'successfully logged in', '2015-08-09 19:29:07', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(663, 'successfully logged in', '2015-08-09 19:31:52', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(664, 'successfully logged in', '2015-08-09 19:35:28', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(665, 'logged out', '2015-08-09 19:37:15', 19, NULL, '', 'ADMINISTRATOR'),
(666, 'successfully logged in', '2015-08-09 19:37:44', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(667, 'successfully logged in', '2015-08-09 19:45:24', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(668, 'successfully logged in', '2015-08-09 20:13:53', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(669, 'successfully logged in', '2015-08-09 20:27:45', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(670, 'successfully logged in', '2015-08-09 20:56:52', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(671, 'successfully logged in', '2015-08-09 20:59:52', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(672, 'successfully logged in', '2015-08-09 21:01:13', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(673, 'successfully logged in', '2015-08-09 21:06:43', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(674, 'successfully logged in', '2015-08-09 21:11:03', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(675, 'accesed home page', '2015-08-10 07:01:18', 0, NULL, 'HOME', NULL),
(676, 'login attempt', '2015-08-10 07:01:49', 0, NULL, 'MEMBER_LOGIN', NULL),
(677, 'login attempt', '2015-08-10 07:01:56', 0, NULL, 'MEMBER_LOGIN', NULL),
(678, 'successfully logged in', '2015-08-10 07:02:04', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(679, 'successfully logged in', '2015-08-10 07:16:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(680, 'successfully logged in', '2015-08-10 07:16:59', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(681, 'successfully logged in', '2015-08-10 07:19:10', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(682, 'successfully logged in', '2015-08-10 07:34:19', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(683, 'successfully logged in', '2015-08-10 07:38:38', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(684, 'logged out', '2015-08-10 07:40:45', 19, NULL, '', 'ADMINISTRATOR'),
(685, 'successfully logged in', '2015-08-10 07:42:20', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(686, 'successfully logged in', '2015-08-10 07:52:18', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(687, 'successfully logged in', '2015-08-10 07:54:02', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(688, 'logged out', '2015-08-10 08:00:24', 19, NULL, '', 'ADMINISTRATOR'),
(689, 'successfully logged in', '2015-08-10 08:00:35', 20, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(690, 'successfully logged in', '2015-08-10 08:00:43', 20, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(691, 'successfully logged in', '2015-08-10 08:01:08', 20, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(692, 'successfully logged in', '2015-08-10 08:01:20', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(693, 'successfully logged in', '2015-08-10 08:10:22', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(694, 'successfully logged in', '2015-08-10 08:11:36', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(695, 'successfully logged in', '2015-08-10 08:12:32', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(696, 'successfully logged in', '2015-08-10 08:14:22', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(697, 'successfully logged in', '2015-08-10 08:20:11', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(698, 'successfully logged in', '2015-08-10 08:21:51', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(699, 'successfully logged in', '2015-08-10 08:23:28', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(700, 'successfully logged in', '2015-08-10 08:25:05', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(701, 'successfully logged in', '2015-08-10 08:41:24', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(702, 'successfully logged in', '2015-08-10 08:45:18', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(703, 'successfully logged in', '2015-08-10 08:46:40', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(704, 'successfully logged in', '2015-08-10 08:51:38', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(705, 'successfully logged in', '2015-08-10 08:53:18', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(706, 'logged out', '2015-08-10 08:54:33', 19, NULL, '', 'ADMINISTRATOR'),
(707, 'accesed home page', '2015-08-10 08:56:04', 0, NULL, 'HOME', NULL),
(708, 'successfully logged in', '2015-08-10 08:56:21', 38, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(709, 'accesed home page', '2015-08-10 08:57:41', 0, NULL, 'HOME', NULL),
(710, 'successfully logged in', '2015-08-10 08:57:45', 38, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(711, 'successfully logged in', '2015-08-10 08:59:33', 38, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(712, 'successfully logged in', '2015-08-10 09:00:27', 38, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(713, 'successfully logged in', '2015-08-10 09:02:16', 38, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(714, 'logged out', '2015-08-10 09:03:41', 38, NULL, '', 'MEMBER'),
(715, 'successfully logged in', '2015-08-10 09:03:49', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(716, 'logged out', '2015-08-10 09:08:15', 19, NULL, '', 'ADMINISTRATOR'),
(717, 'accesed home page', '2015-08-10 09:09:39', 0, NULL, 'HOME', NULL),
(718, 'successfully logged in', '2015-08-10 09:18:53', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(719, 'successfully logged in', '2015-08-10 09:21:20', 38, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(720, 'logged out', '2015-08-10 09:22:47', 38, NULL, '', 'MEMBER'),
(721, 'successfully logged in', '2015-08-10 09:22:55', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(722, 'accesed home page', '2015-08-10 09:23:16', 0, NULL, 'HOME', NULL),
(723, 'successfully logged in', '2015-08-10 09:24:41', 38, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(724, 'logged out', '2015-08-10 09:24:54', 38, NULL, '', 'MEMBER'),
(725, 'accesed home page', '2015-08-10 09:30:50', 0, NULL, 'HOME', NULL),
(726, 'accesed home page', '2015-08-10 09:42:18', 0, NULL, 'HOME', NULL),
(727, 'successfully logged in', '2015-08-10 09:43:39', 39, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(728, 'logged out', '2015-08-10 09:45:27', 39, NULL, '', 'MEMBER'),
(729, 'successfully logged in', '2015-08-10 09:45:40', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(730, 'successfully logged in', '2015-08-10 09:45:54', 20, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(731, 'successfully logged in', '2015-08-10 09:46:15', 38, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(732, 'logged out', '2015-08-10 09:48:42', 38, NULL, '', 'MEMBER'),
(733, 'successfully logged in', '2015-08-10 09:48:50', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(734, 'successfully logged in', '2015-08-10 10:01:28', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(735, 'logged out', '2015-08-10 10:05:37', 19, NULL, '', 'ADMINISTRATOR'),
(736, 'successfully logged in', '2015-08-10 10:06:27', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(737, 'successfully logged in', '2015-08-10 10:18:00', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(738, 'successfully logged in', '2015-08-10 10:26:03', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(739, 'successfully logged in', '2015-08-10 10:33:06', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(740, 'successfully logged in', '2015-08-10 10:35:31', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(741, 'successfully logged in', '2015-08-10 10:37:29', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(742, 'successfully logged in', '2015-08-10 10:47:20', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(743, 'accesed home page', '2015-08-10 10:59:08', 0, NULL, 'HOME', NULL),
(744, 'login attempt', '2015-08-10 11:01:44', 0, NULL, 'ADMIN_LOGIN', NULL),
(745, 'login attempt', '2015-08-10 11:01:59', 0, NULL, 'ADMIN_LOGIN', NULL),
(746, 'successfully logged in', '2015-08-10 11:02:12', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(747, 'successfully logged in', '2015-08-10 11:02:29', 19, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(748, 'logged out', '2015-08-10 11:03:20', 19, NULL, '', 'ADMINISTRATOR'),
(749, 'accesed home page', '2015-08-10 11:04:37', 0, NULL, 'HOME', NULL),
(750, 'accesed home page', '2015-08-10 11:08:23', 0, NULL, 'HOME', NULL),
(751, 'successfully logged in', '2015-08-10 11:08:50', 40, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(752, 'successfully logged in', '2015-08-10 11:15:36', 40, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(753, 'successfully logged in', '2015-08-10 11:17:19', 40, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(754, 'successfully logged in', '2015-08-10 11:23:18', 40, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(755, 'successfully logged in', '2015-08-10 11:24:13', 40, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(756, 'successfully logged in', '2015-08-10 11:25:39', 40, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(757, 'successfully logged in', '2015-08-10 11:28:41', 40, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(758, 'logged out', '2015-08-10 11:34:40', 40, NULL, '', 'MEMBER'),
(759, 'accesed home page', '2015-08-10 11:34:46', 0, NULL, 'HOME', NULL),
(760, 'accesed home page', '2015-08-10 11:42:38', 0, NULL, 'HOME', NULL),
(761, 'successfully logged in', '2015-08-10 11:42:45', 41, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(762, 'logged out', '2015-08-10 11:57:52', 41, NULL, '', 'MEMBER'),
(763, 'login attempt', '2015-08-10 11:58:05', 0, NULL, 'ADMIN_LOGIN', NULL),
(764, 'accesed home page', '2015-08-10 11:58:32', 0, NULL, 'HOME', NULL),
(765, 'successfully logged in', '2015-08-10 11:59:28', 42, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(766, 'successfully logged in', '2015-08-10 12:00:31', 42, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(767, 'successfully logged in', '2015-08-10 12:04:02', 42, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(768, 'successfully logged in', '2015-08-10 12:06:21', 42, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(769, 'accesed home page', '2015-08-10 12:11:16', 0, NULL, 'HOME', NULL),
(770, 'successfully logged in', '2015-08-10 12:12:00', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(771, 'logged out', '2015-08-10 12:13:01', 43, NULL, '', 'ADMINISTRATOR'),
(772, 'successfully logged in', '2015-08-10 12:13:07', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(773, 'accesed home page', '2015-08-10 12:14:02', 0, NULL, 'HOME', NULL),
(774, 'successfully logged in', '2015-08-10 12:45:07', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(775, 'successfully logged in', '2015-08-10 12:46:42', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(776, 'accesed home page', '2015-08-10 17:48:15', 0, NULL, 'HOME', NULL),
(777, 'successfully logged in', '2015-08-10 17:48:29', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(778, 'successfully logged in', '2015-08-10 17:50:33', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(779, 'successfully logged in', '2015-08-10 17:53:05', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(780, 'successfully logged in', '2015-08-10 17:55:09', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(781, 'successfully logged in', '2015-08-10 19:02:47', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(782, 'successfully logged in', '2015-08-10 19:17:03', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(783, 'successfully logged in', '2015-08-10 19:18:15', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(784, 'successfully logged in', '2015-08-10 19:19:53', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(785, 'successfully logged in', '2015-08-10 19:26:17', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(786, 'successfully logged in', '2015-08-10 19:46:14', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(787, 'successfully logged in', '2015-08-10 19:53:58', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(788, 'successfully logged in', '2015-08-10 20:01:12', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(789, 'accesed home page', '2015-08-10 20:04:50', 0, NULL, 'HOME', NULL),
(790, 'successfully logged in', '2015-08-10 21:49:18', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(791, 'successfully logged in', '2015-08-10 21:54:34', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(792, 'successfully logged in', '2015-08-10 22:22:42', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(793, 'successfully logged in', '2015-08-10 22:24:09', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(794, 'successfully logged in', '2015-08-10 22:27:46', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(795, 'successfully logged in', '2015-08-11 01:35:04', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(796, 'successfully logged in', '2015-08-11 01:40:46', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(797, 'successfully logged in', '2015-08-11 01:43:46', 43, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(798, 'accesed home page', '2015-08-12 12:57:50', 0, NULL, 'HOME', NULL),
(799, 'login attempt', '2015-08-12 12:58:18', 0, NULL, 'MEMBER_LOGIN', NULL),
(800, 'accesed home page', '2015-08-12 13:02:09', 0, NULL, 'HOME', NULL),
(801, 'successfully logged in', '2015-08-12 13:02:42', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(802, 'accesed home page', '2015-08-12 13:28:14', 0, NULL, 'HOME', NULL),
(803, 'login attempt', '2015-08-12 13:28:42', 0, NULL, 'ADMIN_LOGIN', NULL),
(804, 'successfully logged in', '2015-08-12 13:28:47', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(805, 'accesed home page', '2015-08-12 13:29:20', 0, NULL, 'HOME', NULL),
(806, 'accesed home page', '2015-08-12 13:35:13', 0, NULL, 'HOME', NULL),
(807, 'login attempt', '2015-08-12 13:35:20', 0, NULL, 'MEMBER_LOGIN', NULL),
(808, 'logged out', '2015-08-12 13:41:29', 44, NULL, '', 'ADMINISTRATOR'),
(809, 'accesed home page', '2015-08-12 13:41:38', 0, NULL, 'HOME', NULL),
(810, 'successfully logged in', '2015-08-12 13:42:07', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(811, 'accesed home page', '2015-08-12 13:43:25', 0, NULL, 'HOME', NULL),
(812, 'logged out', '2015-08-12 13:44:22', 44, NULL, '', 'ADMINISTRATOR'),
(813, 'successfully logged in', '2015-08-12 13:44:40', 45, NULL, 'ADMIN_LOGIN', 'SPONSOR'),
(814, 'logged out', '2015-08-12 13:47:28', 45, NULL, '', 'SPONSOR'),
(815, 'successfully logged in', '2015-08-12 13:47:39', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(816, 'accesed home page', '2015-08-12 13:49:28', 0, NULL, 'HOME', NULL),
(817, 'successfully logged in', '2015-08-12 15:55:50', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(818, 'successfully logged in', '2015-08-12 16:03:43', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(819, 'accesed home page', '2015-08-13 07:43:56', 0, NULL, 'HOME', NULL),
(820, 'accesed home page', '2015-08-13 08:02:16', 0, NULL, 'HOME', NULL),
(821, 'login attempt', '2015-08-13 08:19:38', 0, NULL, 'ADMIN_LOGIN', NULL),
(822, 'login attempt', '2015-08-13 08:19:54', 0, NULL, 'ADMIN_LOGIN', NULL),
(823, 'login attempt', '2015-08-13 08:56:46', 0, NULL, 'ADMIN_LOGIN', NULL),
(824, 'successfully logged in', '2015-08-13 10:50:59', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(825, 'logged out', '2015-08-13 10:54:11', 44, NULL, '', 'ADMINISTRATOR'),
(826, 'accesed home page', '2015-08-13 10:57:47', 0, NULL, 'HOME', NULL),
(827, 'accesed home page', '2015-08-13 11:07:35', 0, NULL, 'HOME', NULL),
(828, 'accesed home page', '2015-08-13 11:07:36', 0, NULL, 'HOME', NULL),
(829, 'accesed home page', '2015-08-13 11:07:37', 0, NULL, 'HOME', NULL),
(830, 'accesed home page', '2015-08-13 11:18:27', 0, NULL, 'HOME', NULL),
(831, 'successfully logged in', '2015-08-13 11:19:42', 45, NULL, 'ADMIN_LOGIN', 'SPONSOR'),
(832, 'accesed home page', '2015-08-13 11:20:24', 0, NULL, 'HOME', NULL),
(833, 'accesed home page', '2015-08-13 11:21:04', 0, NULL, 'HOME', NULL),
(834, 'successfully logged in', '2015-08-13 11:21:20', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(835, 'successfully logged in', '2015-08-13 11:23:46', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(836, 'logged out', '2015-08-13 11:23:52', 46, NULL, '', 'MEMBER'),
(837, 'successfully logged in', '2015-08-13 11:23:59', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(838, 'successfully logged in', '2015-08-13 11:36:13', 44, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(839, 'successfully logged in', '2015-08-13 11:39:02', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(840, 'successfully logged in', '2015-08-13 11:39:24', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(841, 'successfully logged in', '2015-08-13 11:40:26', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(842, 'successfully logged in', '2015-08-13 11:41:25', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(843, 'successfully logged in', '2015-08-13 11:42:46', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(844, 'logged out', '2015-08-13 11:44:58', 46, NULL, '', 'MEMBER'),
(845, 'login attempt', '2015-08-13 11:49:49', 0, NULL, 'MEMBER_LOGIN', NULL),
(846, 'successfully logged in', '2015-08-13 11:50:59', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(847, 'successfully logged in', '2015-08-13 11:54:48', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(848, 'successfully logged in', '2015-08-13 11:55:58', 46, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(849, 'logged out', '2015-08-13 11:58:46', 46, NULL, '', 'MEMBER'),
(850, 'accesed home page', '2015-08-13 11:58:53', 0, NULL, 'HOME', NULL),
(851, 'accesed home page', '2015-08-13 12:03:09', 0, NULL, 'HOME', NULL),
(852, 'login attempt', '2015-08-13 12:03:24', 0, NULL, 'MEMBER_LOGIN', NULL),
(853, 'successfully logged in', '2015-08-13 12:03:32', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(854, 'logged out', '2015-08-13 12:37:03', 47, NULL, '', 'MEMBER'),
(855, 'successfully logged in', '2015-08-13 12:37:31', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(856, 'logged out', '2015-08-13 12:41:44', 47, NULL, '', 'MEMBER'),
(857, 'accesed home page', '2015-08-13 12:42:17', 0, NULL, 'HOME', NULL),
(858, 'successfully logged in', '2015-08-13 12:44:56', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(859, 'successfully logged in', '2015-08-13 12:49:29', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(860, 'successfully logged in', '2015-08-13 12:54:01', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(861, 'accesed home page', '2015-08-13 12:55:24', 0, NULL, 'HOME', NULL),
(862, 'successfully logged in', '2015-08-13 13:16:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(863, 'logged out', '2015-08-13 13:29:59', 48, NULL, '', 'ADMINISTRATOR'),
(864, 'successfully logged in', '2015-08-13 13:30:08', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(865, 'successfully logged in', '2015-08-13 14:42:34', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(866, 'successfully logged in', '2015-08-13 14:57:27', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(867, 'successfully logged in', '2015-08-13 15:37:04', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(868, 'successfully logged in', '2015-08-13 15:39:45', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(869, 'successfully logged in', '2015-08-13 15:41:35', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(870, 'successfully logged in', '2015-08-13 16:47:39', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(871, 'successfully logged in', '2015-08-13 16:49:17', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(872, 'successfully logged in', '2015-08-14 02:44:26', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(873, 'successfully logged in', '2015-08-14 02:45:29', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(874, 'successfully logged in', '2015-08-14 02:49:13', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(875, 'successfully logged in', '2015-08-14 02:51:09', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(876, 'successfully logged in', '2015-08-14 02:53:47', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(877, 'successfully logged in', '2015-08-14 02:56:22', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(878, 'successfully logged in', '2015-08-14 03:03:58', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(879, 'login attempt', '2015-08-14 03:17:58', 0, NULL, 'ADMIN_LOGIN', NULL),
(880, 'successfully logged in', '2015-08-14 03:20:10', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(881, 'successfully logged in', '2015-08-14 03:54:22', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(882, 'successfully logged in', '2015-08-14 04:01:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(883, 'successfully logged in', '2015-08-14 04:03:46', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(884, 'successfully logged in', '2015-08-14 04:14:25', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(885, 'successfully logged in', '2015-08-14 05:10:44', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(886, 'successfully logged in', '2015-08-14 05:12:06', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(887, 'logged out', '2015-08-14 05:13:09', 48, NULL, '', 'ADMINISTRATOR'),
(888, 'login attempt', '2015-08-14 05:13:21', 0, NULL, 'MEMBER_LOGIN', NULL),
(889, 'successfully logged in', '2015-08-14 05:13:42', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(890, 'login attempt', '2015-08-14 05:27:32', 0, NULL, 'MEMBER_LOGIN', NULL),
(891, 'successfully logged in', '2015-08-14 05:27:42', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(892, 'successfully logged in', '2015-08-14 05:30:49', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(893, 'successfully logged in', '2015-08-14 05:34:44', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(894, 'successfully logged in', '2015-08-14 05:41:24', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(895, 'successfully logged in', '2015-08-14 05:44:41', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(896, 'successfully logged in', '2015-08-14 05:48:02', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(897, 'successfully logged in', '2015-08-14 06:02:59', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(898, 'successfully logged in', '2015-08-14 06:04:13', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(899, 'successfully logged in', '2015-08-14 06:06:49', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(900, 'successfully logged in', '2015-08-14 06:09:14', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(901, 'successfully logged in', '2015-08-14 06:11:44', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(902, 'successfully logged in', '2015-08-14 08:24:42', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(903, 'successfully logged in', '2015-08-14 08:25:27', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(904, 'successfully logged in', '2015-08-14 08:30:12', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(905, 'successfully logged in', '2015-08-14 08:32:39', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(906, 'successfully logged in', '2015-08-14 08:34:22', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(907, 'successfully logged in', '2015-08-14 08:54:58', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(908, 'successfully logged in', '2015-08-14 09:05:06', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(909, 'successfully logged in', '2015-08-14 09:14:27', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(910, 'successfully logged in', '2015-08-14 09:17:21', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(911, 'successfully logged in', '2015-08-14 09:20:18', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(912, 'successfully logged in', '2015-08-14 09:25:41', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(913, 'successfully logged in', '2015-08-14 09:27:47', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(914, 'successfully logged in', '2015-08-14 09:31:04', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(915, 'successfully logged in', '2015-08-14 09:33:44', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(916, 'successfully logged in', '2015-08-14 09:36:08', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(917, 'successfully logged in', '2015-08-14 09:59:45', 47, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(918, 'successfully logged in', '2015-08-14 10:04:17', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(919, 'successfully logged in', '2015-08-14 10:05:02', 47, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(920, 'successfully logged in', '2015-08-14 10:05:23', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(921, 'successfully logged in', '2015-08-14 11:13:30', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(922, 'successfully logged in', '2015-08-14 11:32:14', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(923, 'successfully logged in', '2015-08-14 12:00:15', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(924, 'successfully logged in', '2015-08-14 12:06:08', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(925, 'successfully logged in', '2015-08-14 12:08:56', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(926, 'logged out', '2015-08-14 12:09:34', 47, NULL, '', 'MEMBER'),
(927, 'successfully logged in', '2015-08-14 12:09:41', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(928, 'successfully logged in', '2015-08-14 12:15:05', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(929, 'successfully logged in', '2015-08-14 12:16:45', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(930, 'logged out', '2015-08-14 12:21:02', 48, NULL, '', 'ADMINISTRATOR'),
(931, 'successfully logged in', '2015-08-14 13:12:45', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(932, 'successfully logged in', '2015-08-14 13:15:17', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(933, 'successfully logged in', '2015-08-14 13:16:41', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(934, 'logged out', '2015-08-14 13:42:48', 48, NULL, '', 'ADMINISTRATOR'),
(935, 'successfully logged in', '2015-08-14 13:43:02', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(936, 'successfully logged in', '2015-08-14 14:30:15', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(937, 'successfully logged in', '2015-08-14 14:40:39', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(938, 'successfully logged in', '2015-08-14 14:41:49', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(939, 'successfully logged in', '2015-08-14 14:44:31', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(940, 'successfully logged in', '2015-08-14 14:57:00', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(941, 'successfully logged in', '2015-08-14 15:00:20', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(942, 'successfully logged in', '2015-08-14 15:03:38', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(943, 'successfully logged in', '2015-08-14 15:04:50', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(944, 'successfully logged in', '2015-08-14 15:27:22', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(945, 'successfully logged in', '2015-08-14 15:29:01', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(946, 'successfully logged in', '2015-08-14 15:29:48', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(947, 'logged out', '2015-08-14 15:43:03', 47, NULL, '', 'MEMBER'),
(948, 'successfully logged in', '2015-08-14 15:43:10', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(949, 'logged out', '2015-08-14 15:54:11', 48, NULL, '', 'ADMINISTRATOR'),
(950, 'successfully logged in', '2015-08-14 15:54:17', 47, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(951, 'successfully logged in', '2015-08-14 15:54:26', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(952, 'successfully logged in', '2015-08-14 16:02:57', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(953, 'successfully logged in', '2015-08-14 16:13:10', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(954, 'successfully logged in', '2015-08-14 16:20:26', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(955, 'successfully logged in', '2015-08-14 16:21:57', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(956, 'successfully logged in', '2015-08-14 16:22:52', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(957, 'successfully logged in', '2015-08-14 16:24:59', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(958, 'successfully logged in', '2015-08-14 16:26:07', 47, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(959, 'accesed home page', '2015-08-14 16:27:32', 0, NULL, 'HOME', NULL),
(960, 'successfully logged in', '2015-08-14 16:27:38', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(961, 'successfully logged in', '2015-08-14 16:28:43', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(962, 'accesed home page', '2015-08-14 16:30:11', 0, NULL, 'HOME', NULL),
(963, 'accesed home page', '2015-08-14 16:43:58', 0, NULL, 'HOME', NULL),
(964, 'accesed home page', '2015-08-14 16:45:36', 0, NULL, 'HOME', NULL),
(965, 'successfully logged in', '2015-08-14 16:47:42', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(966, 'successfully logged in', '2015-08-14 16:48:02', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(967, 'accesed home page', '2015-08-14 16:49:17', 0, NULL, 'HOME', NULL),
(968, 'accesed home page', '2015-08-14 16:50:49', 0, NULL, 'HOME', NULL),
(969, 'successfully logged in', '2015-08-14 16:51:38', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(970, 'logged out', '2015-08-14 16:58:24', 48, NULL, '', 'ADMINISTRATOR'),
(971, 'successfully logged in', '2015-08-14 16:58:37', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(972, 'accesed home page', '2015-08-14 17:26:58', 0, NULL, 'HOME', NULL),
(973, 'login attempt', '2015-08-14 17:29:17', 0, NULL, 'ADMIN_LOGIN', NULL),
(974, 'login attempt', '2015-08-14 17:29:25', 0, NULL, 'ADMIN_LOGIN', NULL),
(975, 'login attempt', '2015-08-14 17:48:08', 0, NULL, 'ADMIN_LOGIN', NULL),
(976, 'login attempt', '2015-08-14 17:48:23', 0, NULL, 'ADMIN_LOGIN', NULL),
(977, 'login attempt', '2015-08-14 17:48:39', 0, NULL, 'ADMIN_LOGIN', NULL),
(978, 'login attempt', '2015-08-14 17:49:18', 0, NULL, 'ADMIN_LOGIN', NULL),
(979, 'login attempt', '2015-08-14 17:50:28', 0, NULL, 'ADMIN_LOGIN', NULL),
(980, 'successfully logged in', '2015-08-14 17:50:48', 49, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(981, 'successfully logged in', '2015-08-14 18:02:12', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(982, 'logged out', '2015-08-14 18:14:46', 48, NULL, '', 'ADMINISTRATOR'),
(983, 'successfully logged in', '2015-08-14 18:14:58', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(984, 'successfully logged in', '2015-08-14 18:19:28', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(985, 'logged out', '2015-08-14 18:25:26', 47, NULL, '', 'MEMBER'),
(986, 'successfully logged in', '2015-08-14 18:25:32', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(987, 'successfully logged in', '2015-08-14 18:26:41', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(988, 'successfully logged in', '2015-08-14 18:28:53', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(989, 'successfully logged in', '2015-08-16 21:43:24', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(990, 'accesed home page', '2015-08-17 02:05:22', 0, NULL, 'HOME', NULL),
(991, 'accesed home page', '2015-08-17 02:31:34', 0, NULL, 'HOME', NULL),
(992, 'successfully logged in', '2015-08-17 02:48:06', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(993, 'accesed home page', '2015-08-17 02:48:50', 0, NULL, 'HOME', NULL),
(994, 'successfully logged in', '2015-08-17 02:49:42', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(995, 'successfully logged in', '2015-08-17 02:56:24', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(996, 'successfully logged in', '2015-08-17 02:57:20', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(997, 'successfully logged in', '2015-08-17 02:59:43', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(998, 'successfully logged in', '2015-08-17 03:01:22', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(999, 'successfully logged in', '2015-08-17 03:07:36', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1000, 'successfully logged in', '2015-08-17 03:16:42', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1001, 'successfully logged in', '2015-08-17 03:18:16', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1002, 'successfully logged in', '2015-08-17 03:19:32', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1003, 'successfully logged in', '2015-08-17 03:22:14', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1004, 'successfully logged in', '2015-08-17 03:23:41', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1005, 'successfully logged in', '2015-08-17 03:26:29', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1006, 'successfully logged in', '2015-08-17 03:36:34', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1007, 'successfully logged in', '2015-08-17 03:45:57', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1008, 'successfully logged in', '2015-08-17 03:48:24', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1009, 'successfully logged in', '2015-08-17 03:52:44', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1010, 'successfully logged in', '2015-08-17 03:55:02', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1011, 'successfully logged in', '2015-08-17 04:01:50', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1012, 'successfully logged in', '2015-08-17 04:07:05', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1013, 'successfully logged in', '2015-08-17 04:09:03', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1014, 'successfully logged in', '2015-08-17 04:12:19', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1015, 'successfully logged in', '2015-08-17 04:13:24', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1016, 'login attempt', '2015-08-17 04:16:14', 0, NULL, 'ADMIN_LOGIN', NULL),
(1017, 'successfully logged in', '2015-08-17 04:19:32', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1018, 'logged out', '2015-08-17 04:20:59', 48, NULL, '', 'ADMINISTRATOR'),
(1019, 'successfully logged in', '2015-08-17 04:21:05', 47, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(1020, 'successfully logged in', '2015-08-17 04:21:15', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1021, 'successfully logged in', '2015-08-17 04:26:45', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1022, 'logged out', '2015-08-17 04:28:30', 47, NULL, '', 'MEMBER'),
(1023, 'successfully logged in', '2015-08-17 04:28:48', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1024, 'successfully logged in', '2015-08-17 04:45:11', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1025, 'successfully logged in', '2015-08-17 04:46:55', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1026, 'successfully logged in', '2015-08-17 04:48:36', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1027, 'successfully logged in', '2015-08-17 04:54:14', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1028, 'successfully logged in', '2015-08-17 04:55:10', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1029, 'successfully logged in', '2015-08-17 05:04:25', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1030, 'successfully logged in', '2015-08-17 05:08:14', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1031, 'successfully logged in', '2015-08-17 05:12:33', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1032, 'accesed home page', '2015-08-17 05:19:48', 0, NULL, 'HOME', NULL),
(1033, 'accesed home page', '2015-08-17 05:20:43', 0, NULL, 'HOME', NULL),
(1034, 'accesed home page', '2015-08-17 05:21:19', 0, NULL, 'HOME', NULL),
(1035, 'accesed home page', '2015-08-17 05:21:38', 0, NULL, 'HOME', NULL),
(1036, 'accesed home page', '2015-08-17 05:24:04', 0, NULL, 'HOME', NULL),
(1037, 'accesed home page', '2015-08-17 05:24:25', 0, NULL, 'HOME', NULL),
(1038, 'accesed home page', '2015-08-17 05:24:50', 0, NULL, 'HOME', NULL),
(1039, 'successfully logged in', '2015-08-17 06:48:12', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1040, 'successfully logged in', '2015-08-17 06:49:12', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1041, 'accesed home page', '2015-08-17 06:52:45', 0, NULL, 'HOME', NULL),
(1042, 'successfully logged in', '2015-08-17 06:55:48', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1043, 'logged out', '2015-08-17 06:57:59', 47, NULL, '', 'MEMBER'),
(1044, 'successfully logged in', '2015-08-17 06:58:09', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1045, 'successfully logged in', '2015-08-17 06:59:19', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1046, 'successfully logged in', '2015-08-17 07:06:10', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1047, 'successfully logged in', '2015-08-17 07:09:01', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1048, 'successfully logged in', '2015-08-17 07:17:47', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1049, 'successfully logged in', '2015-08-17 07:19:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1050, 'successfully logged in', '2015-08-17 07:20:15', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1051, 'successfully logged in', '2015-08-17 07:22:28', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1052, 'successfully logged in', '2015-08-17 07:23:50', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1053, 'successfully logged in', '2015-08-17 07:24:57', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1054, 'successfully logged in', '2015-08-17 07:31:10', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1055, 'successfully logged in', '2015-08-17 07:34:11', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1056, 'successfully logged in', '2015-08-17 07:34:36', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1057, 'successfully logged in', '2015-08-17 07:35:42', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1058, 'successfully logged in', '2015-08-17 07:37:00', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1059, 'successfully logged in', '2015-08-17 07:37:23', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1060, 'successfully logged in', '2015-08-17 07:45:00', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1061, 'successfully logged in', '2015-08-17 07:45:27', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1062, 'successfully logged in', '2015-08-17 07:53:22', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1063, 'successfully logged in', '2015-08-17 07:54:12', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1064, 'successfully logged in', '2015-08-17 07:54:56', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1065, 'successfully logged in', '2015-08-17 07:56:25', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1066, 'accesed home page', '2015-08-17 08:19:33', 0, NULL, 'HOME', NULL),
(1067, 'successfully logged in', '2015-08-17 09:15:34', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1068, 'successfully logged in', '2015-08-17 11:55:55', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1069, 'logged out', '2015-08-17 11:56:08', 48, NULL, '', 'ADMINISTRATOR'),
(1070, 'successfully logged in', '2015-08-17 11:57:27', 47, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(1071, 'successfully logged in', '2015-08-17 11:57:39', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1072, 'successfully logged in', '2015-08-17 12:02:02', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1073, 'successfully logged in', '2015-08-17 12:02:52', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1074, 'logged out', '2015-08-17 12:03:52', 48, NULL, '', 'ADMINISTRATOR'),
(1075, 'successfully logged in', '2015-08-17 12:04:14', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1076, 'logged out', '2015-08-17 12:04:54', 48, NULL, '', 'ADMINISTRATOR'),
(1077, 'login attempt', '2015-08-17 12:05:06', 0, NULL, 'MEMBER_LOGIN', NULL),
(1078, 'successfully logged in', '2015-08-17 12:05:18', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1079, 'successfully logged in', '2015-08-17 12:06:24', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1080, 'successfully logged in', '2015-08-17 12:07:17', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1081, 'successfully logged in', '2015-08-17 12:09:08', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1082, 'successfully logged in', '2015-08-17 12:09:49', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1083, 'successfully logged in', '2015-08-17 12:13:30', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1084, 'logged out', '2015-08-17 12:15:37', 47, NULL, '', 'MEMBER'),
(1085, 'successfully logged in', '2015-08-17 12:15:48', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1086, 'successfully logged in', '2015-08-17 12:16:58', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1087, 'successfully logged in', '2015-08-17 12:19:00', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1088, 'successfully logged in', '2015-08-17 12:21:41', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1089, 'successfully logged in', '2015-08-17 12:22:59', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1090, 'successfully logged in', '2015-08-17 12:24:16', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1091, 'accesed home page', '2015-08-17 12:26:09', 0, NULL, 'HOME', NULL),
(1092, 'successfully logged in', '2015-08-17 12:27:11', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1093, 'successfully logged in', '2015-08-17 12:35:44', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1094, 'successfully logged in', '2015-08-17 12:36:43', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1095, 'successfully logged in', '2015-08-17 12:37:33', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1096, 'successfully logged in', '2015-08-17 12:41:31', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1097, 'successfully logged in', '2015-08-17 12:51:33', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1098, 'successfully logged in', '2015-08-17 12:52:26', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1099, 'successfully logged in', '2015-08-17 12:53:51', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1100, 'successfully logged in', '2015-08-17 12:56:14', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1101, 'successfully logged in', '2015-08-17 12:57:55', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1102, 'successfully logged in', '2015-08-17 12:58:26', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1103, 'successfully logged in', '2015-08-17 13:02:39', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1104, 'successfully logged in', '2015-08-17 13:04:57', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1105, 'successfully logged in', '2015-08-17 13:05:24', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1106, 'successfully logged in', '2015-08-17 13:07:05', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1107, 'successfully logged in', '2015-08-17 13:07:48', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1108, 'successfully logged in', '2015-08-17 13:12:18', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1109, 'successfully logged in', '2015-08-17 13:13:40', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1110, 'successfully logged in', '2015-08-17 13:14:43', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1111, 'successfully logged in', '2015-08-17 13:15:27', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1112, 'successfully logged in', '2015-08-17 13:16:30', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1113, 'successfully logged in', '2015-08-17 14:33:24', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1114, 'successfully logged in', '2015-08-17 14:34:10', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1115, 'successfully logged in', '2015-08-17 14:40:13', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1116, 'successfully logged in', '2015-08-17 14:44:57', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1117, 'successfully logged in', '2015-08-17 14:45:34', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1118, 'successfully logged in', '2015-08-17 14:47:46', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1119, 'successfully logged in', '2015-08-17 14:48:16', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1120, 'successfully logged in', '2015-08-17 14:48:45', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1121, 'successfully logged in', '2015-08-17 14:49:19', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1122, 'successfully logged in', '2015-08-17 14:49:59', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1123, 'logged out', '2015-08-17 15:04:44', 48, NULL, '', 'ADMINISTRATOR'),
(1124, 'successfully logged in', '2015-08-17 15:06:26', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1125, 'successfully logged in', '2015-08-17 15:15:43', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1126, 'successfully logged in', '2015-08-17 15:16:32', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1127, 'successfully logged in', '2015-08-17 15:17:22', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1128, 'successfully logged in', '2015-08-17 15:18:20', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1129, 'successfully logged in', '2015-08-17 15:19:25', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1130, 'accesed home page', '2015-08-17 15:23:39', 0, NULL, 'HOME', NULL),
(1131, 'accesed annuity quotation page', '2015-08-17 15:23:40', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1132, 'accesed annuity quotation page', '2015-08-17 15:23:42', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1133, 'accesed annuity quotation page', '2015-08-17 15:23:43', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1134, 'accesed interest rates page', '2015-08-17 15:23:44', 0, NULL, 'INTEREST_RATES', NULL);
INSERT INTO `tbl_activity_logs` (`id`, `description`, `datetime`, `user_id`, `scheme`, `access_menu`, `userProfile`) VALUES
(1135, 'accesed what if analysis page', '2015-08-17 15:23:45', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1136, 'accesed what if analysis page', '2015-08-17 15:23:47', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1137, 'accesed what if analysis page', '2015-08-17 15:23:48', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1138, 'accesed what if analysis page', '2015-08-17 15:23:49', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1139, 'accesed what if analysis page', '2015-08-17 15:23:50', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1140, 'accesed contact us page', '2015-08-17 15:23:52', 0, NULL, 'CONTACT_US', NULL),
(1141, 'successfully logged in', '2015-08-17 15:24:01', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1142, 'successfully logged in', '2015-08-17 15:33:36', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1143, 'successfully logged in', '2015-08-17 15:35:11', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1144, 'successfully logged in', '2015-08-17 15:36:12', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1145, 'successfully logged in', '2015-08-17 16:04:02', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1146, 'accesed', '2015-08-17 16:04:05', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1147, 'accesed', '2015-08-17 16:04:07', 48, '242', 'HELP CONTENT', 'ADMINISTRATOR'),
(1148, 'accesed', '2015-08-17 16:04:10', 48, '242', 'HELP CONTENT', 'ADMINISTRATOR'),
(1149, 'accesed', '2015-08-17 16:04:12', 48, '242', 'PAGE CONTENT', 'ADMINISTRATOR'),
(1150, 'accesed', '2015-08-17 16:04:18', 48, '242', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1151, 'accesed', '2015-08-17 16:04:22', 48, '242', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1152, 'accesed', '2015-08-17 16:04:24', 48, '242', 'MEDIA & FILES', 'ADMINISTRATOR'),
(1153, 'accesed', '2015-08-17 16:04:26', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1154, 'successfully logged in', '2015-08-17 16:22:46', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1155, 'logged out', '2015-08-17 16:24:18', 48, NULL, '', 'ADMINISTRATOR'),
(1156, 'accesed home page', '2015-08-17 16:28:55', 0, NULL, 'SIGNIN', NULL),
(1157, 'successfully logged in', '2015-08-17 16:28:59', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1158, 'accesed', '2015-08-17 16:29:05', 47, '281', 'MEMBER CONTRIBUTION HISTORY', 'MEMBER'),
(1159, 'accesed', '2015-08-17 16:29:16', 47, '281', 'MEMBER BALANCES HISTORY', 'MEMBER'),
(1160, 'accesed', '2015-08-17 16:29:18', 47, '281', 'MEMBER PERSONAL INFORMATION', 'MEMBER'),
(1161, 'accesed', '2015-08-17 16:29:20', 47, '281', 'MEMBER PERSONAL INFORMATION', 'MEMBER'),
(1162, 'accesed', '2015-08-17 16:29:22', 47, '281', 'MEMBER PERSONAL INFORMATION', 'MEMBER'),
(1163, 'accesed', '2015-08-17 16:29:24', 47, '281', 'MEMBER BENEFITS PROJECTION', 'MEMBER'),
(1164, 'accesed', '2015-08-17 16:29:26', 47, '281', 'WHAT IF ANALYSIS', 'MEMBER'),
(1165, 'accesed', '2015-08-17 16:29:28', 47, '281', 'MEMBER STATEMENT OF ACCOUNT', 'MEMBER'),
(1166, 'logged out', '2015-08-17 16:29:39', 47, NULL, '', 'MEMBER'),
(1167, 'successfully logged in', '2015-08-17 16:29:46', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1168, 'successfully logged in', '2015-08-17 16:30:41', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1169, 'successfully logged in', '2015-08-17 16:33:39', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1170, 'successfully logged in', '2015-08-17 16:34:58', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1171, 'successfully logged in', '2015-08-17 16:37:02', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1172, 'accesed', '2015-08-17 16:37:23', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1173, 'accesed', '2015-08-17 16:37:31', 48, '242', 'MEDIA & FILES', 'ADMINISTRATOR'),
(1174, 'accesed', '2015-08-17 16:37:33', 48, '242', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1175, 'accesed', '2015-08-17 16:37:59', 48, '242', 'HELP CONTENT', 'ADMINISTRATOR'),
(1176, 'accesed home page', '2015-08-17 16:38:11', 0, NULL, 'HOME', NULL),
(1177, 'accesed', '2015-08-17 16:39:26', 48, '242', 'HELP CONTENT', 'ADMINISTRATOR'),
(1178, 'accesed', '2015-08-17 16:39:29', 48, '242', 'HELP CONTENT', 'ADMINISTRATOR'),
(1179, 'accesed', '2015-08-17 16:39:32', 48, '242', 'PAGE CONTENT', 'ADMINISTRATOR'),
(1180, 'accesed', '2015-08-17 16:39:57', 48, '242', 'SCHEMES', 'ADMINISTRATOR'),
(1181, 'accesed', '2015-08-17 16:40:10', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1182, 'accesed', '2015-08-17 16:40:13', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1183, 'accesed', '2015-08-17 16:41:21', 48, '242', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1184, 'successfully logged in', '2015-08-17 16:46:40', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1185, 'accesed home page', '2015-08-17 16:47:00', 0, NULL, 'HOME', NULL),
(1186, 'accesed what if analysis page', '2015-08-17 16:47:05', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1187, 'accesed annuity quotation page', '2015-08-17 16:47:06', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1188, 'accesed contact us page', '2015-08-17 16:47:11', 0, NULL, 'CONTACT_US', NULL),
(1189, 'logged out', '2015-08-17 16:47:18', 48, NULL, '', 'ADMINISTRATOR'),
(1190, 'accesed home page', '2015-08-17 16:47:24', 0, NULL, 'SIGNIN', NULL),
(1191, 'successfully logged in', '2015-08-17 16:47:28', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1192, 'accesed', '2015-08-17 16:47:34', 47, '281', 'MEMBER CONTRIBUTION HISTORY', 'MEMBER'),
(1193, 'accesed', '2015-08-17 16:47:44', 47, '281', 'MEMBER CONTRIBUTION HISTORY', 'MEMBER'),
(1194, 'accesed home page', '2015-08-17 16:48:31', 0, NULL, 'SIGNIN', NULL),
(1195, 'successfully logged in', '2015-08-17 16:48:35', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1196, 'accesed', '2015-08-17 16:48:39', 47, '281', 'MEMBER CONTRIBUTION HISTORY', 'MEMBER'),
(1197, 'accesed', '2015-08-17 16:49:59', 47, '281', 'MEMBER STATEMENT OF ACCOUNT', 'MEMBER'),
(1198, 'accesed home page', '2015-08-17 16:53:03', 0, NULL, 'SIGNIN', NULL),
(1199, 'successfully logged in', '2015-08-17 16:53:07', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1200, 'accesed', '2015-08-17 16:53:13', 47, '281', 'MEMBER CONTRIBUTION HISTORY', 'MEMBER'),
(1201, 'accesed home page', '2015-08-17 16:53:40', 0, NULL, 'SIGNIN', NULL),
(1202, 'successfully logged in', '2015-08-17 16:53:45', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1203, 'accesed', '2015-08-17 16:53:51', 47, '281', 'MEMBER CONTRIBUTION HISTORY', 'MEMBER'),
(1204, 'accesed home page', '2015-08-17 16:56:03', 0, NULL, 'SIGNIN', NULL),
(1205, 'login attempt', '2015-08-17 16:56:07', 0, NULL, 'MEMBER_LOGIN', NULL),
(1206, 'successfully logged in', '2015-08-17 16:56:14', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1207, 'accesed', '2015-08-17 16:56:19', 47, '281', 'MEMBER BALANCES HISTORY', 'MEMBER'),
(1208, 'accesed', '2015-08-17 16:56:45', 47, '281', 'MEMBER STATEMENT OF ACCOUNT', 'MEMBER'),
(1209, 'accesed', '2015-08-17 16:57:18', 47, '281', 'MEDIA FILES', 'MEMBER'),
(1210, 'logged out', '2015-08-17 16:57:22', 47, NULL, '', 'MEMBER'),
(1211, 'successfully logged in', '2015-08-17 16:57:30', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1212, 'accesed', '2015-08-17 16:58:50', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1213, 'accesed', '2015-08-17 16:58:53', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1214, 'successfully logged in', '2015-08-17 17:05:08', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1215, 'accesed', '2015-08-17 17:05:15', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1216, 'successfully logged in', '2015-08-17 17:06:15', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1217, 'accesed', '2015-08-17 17:06:50', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1218, 'accesed', '2015-08-17 17:06:52', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1219, 'successfully logged in', '2015-08-17 17:09:06', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1220, 'accesed', '2015-08-17 17:09:10', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1221, 'accesed', '2015-08-17 17:09:12', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1222, 'successfully logged in', '2015-08-17 17:09:32', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1223, 'accesed', '2015-08-17 17:09:40', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1224, 'accesed', '2015-08-17 17:09:42', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1225, 'successfully logged in', '2015-08-17 17:11:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1226, 'accesed', '2015-08-17 17:11:38', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1227, 'accesed', '2015-08-17 17:11:42', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1228, 'accesed', '2015-08-17 17:14:12', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1229, 'accesed', '2015-08-17 17:14:24', 48, '242', 'MEDIA & FILES', 'ADMINISTRATOR'),
(1230, 'accesed', '2015-08-17 17:14:26', 48, '242', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1231, 'accesed', '2015-08-17 17:14:38', 48, '242', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1232, 'accesed', '2015-08-17 17:14:49', 48, '242', 'SCHEMES', 'ADMINISTRATOR'),
(1233, 'accesed', '2015-08-17 17:14:54', 48, '242', 'HELP CONTENT', 'ADMINISTRATOR'),
(1234, 'accesed', '2015-08-17 17:15:06', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1235, 'accesed', '2015-08-17 17:15:08', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1236, 'successfully logged in', '2015-08-17 17:24:20', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1237, 'accesed', '2015-08-17 17:24:25', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1238, 'accesed', '2015-08-17 17:24:27', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1239, 'successfully logged in', '2015-08-17 17:31:07', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1240, 'accesed', '2015-08-17 17:31:11', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1241, 'accesed', '2015-08-17 17:31:13', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1242, 'accesed', '2015-08-17 17:31:18', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1243, 'successfully logged in', '2015-08-17 17:32:54', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1244, 'accesed', '2015-08-17 17:32:58', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1245, 'accesed', '2015-08-17 17:33:00', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1246, 'accesed', '2015-08-17 17:33:03', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1247, 'successfully logged in', '2015-08-17 17:33:59', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1248, 'accesed', '2015-08-17 17:34:05', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1249, 'accesed', '2015-08-17 17:34:07', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1250, 'accesed', '2015-08-17 17:34:16', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1251, 'successfully logged in', '2015-08-17 17:36:16', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1252, 'accesed', '2015-08-17 17:36:23', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1253, 'accesed', '2015-08-17 17:36:27', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1254, 'accesed', '2015-08-17 17:36:30', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1255, 'accesed', '2015-08-17 17:36:33', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1256, 'accesed', '2015-08-17 17:36:35', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1257, 'accesed', '2015-08-17 17:36:38', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1258, 'accesed', '2015-08-17 17:36:40', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1259, 'accesed', '2015-08-17 17:36:43', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1260, 'accesed', '2015-08-17 17:36:45', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1261, 'accesed', '2015-08-17 17:36:47', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1262, 'accesed', '2015-08-17 17:36:54', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1263, 'accesed', '2015-08-17 17:36:59', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1264, 'accesed', '2015-08-17 17:37:24', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1265, 'accesed', '2015-08-17 17:37:26', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1266, 'accesed', '2015-08-17 17:37:29', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1267, 'accesed', '2015-08-17 17:37:33', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1268, 'accesed', '2015-08-17 17:37:35', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1269, 'accesed', '2015-08-17 17:37:37', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1270, 'accesed', '2015-08-17 17:37:39', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1271, 'accesed', '2015-08-17 17:37:42', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1272, 'accesed', '2015-08-17 17:37:45', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1273, 'accesed', '2015-08-17 17:37:47', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1274, 'accesed', '2015-08-17 17:37:49', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1275, 'accesed', '2015-08-17 17:37:51', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1276, 'accesed', '2015-08-17 17:38:09', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1277, 'accesed', '2015-08-17 17:38:12', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1278, 'accesed', '2015-08-17 17:39:30', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1279, 'accesed', '2015-08-17 17:39:32', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1280, 'accesed', '2015-08-17 17:39:48', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1281, 'accesed', '2015-08-17 17:39:51', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1282, 'accesed', '2015-08-17 17:40:34', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1283, 'accesed', '2015-08-17 17:40:36', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1284, 'accesed', '2015-08-17 17:40:39', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1285, 'successfully logged in', '2015-08-17 17:42:16', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1286, 'accesed', '2015-08-17 17:42:20', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1287, 'accesed', '2015-08-17 17:42:22', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1288, 'accesed', '2015-08-17 17:42:27', 48, '242', 'MEDIA & FILES', 'ADMINISTRATOR'),
(1289, 'accesed', '2015-08-17 17:42:32', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1290, 'accesed', '2015-08-17 17:42:35', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1291, 'accesed', '2015-08-17 17:48:47', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1292, 'accesed', '2015-08-17 17:48:48', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1293, 'accesed', '2015-08-17 17:48:50', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1294, 'accesed', '2015-08-17 17:48:51', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1295, 'accesed', '2015-08-17 17:48:53', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1296, 'successfully logged in', '2015-08-17 17:51:31', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1297, 'accesed', '2015-08-17 17:51:35', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1298, 'accesed', '2015-08-17 17:51:38', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1299, 'accesed', '2015-08-17 17:51:42', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1300, 'accesed', '2015-08-17 17:51:47', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1301, 'accesed', '2015-08-17 17:51:49', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1302, 'accesed', '2015-08-17 17:51:51', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1303, 'accesed', '2015-08-17 17:51:52', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1304, 'accesed', '2015-08-17 17:51:57', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1305, 'accesed', '2015-08-17 17:52:00', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1306, 'successfully logged in', '2015-08-17 17:59:50', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1307, 'accesed', '2015-08-17 17:59:55', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1308, 'accesed', '2015-08-17 17:59:59', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1309, 'successfully logged in', '2015-08-17 18:04:44', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1310, 'accesed', '2015-08-17 18:04:47', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1311, 'accesed', '2015-08-17 18:04:50', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1312, 'accesed', '2015-08-17 18:05:04', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1313, 'accesed', '2015-08-17 18:05:11', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1314, 'successfully logged in', '2015-08-17 18:06:10', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1315, 'accesed', '2015-08-17 18:06:16', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1316, 'accesed', '2015-08-17 18:06:19', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1317, 'accesed', '2015-08-17 18:06:28', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1318, 'accesed', '2015-08-17 18:06:32', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1319, 'accesed', '2015-08-17 18:06:34', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1320, 'accesed', '2015-08-17 18:06:39', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1321, 'accesed', '2015-08-17 18:06:41', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1322, 'accesed', '2015-08-17 18:12:32', 48, '242', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1323, 'successfully logged in', '2015-08-17 18:18:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1324, 'accesed', '2015-08-17 18:18:57', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1325, 'accesed', '2015-08-17 18:19:00', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1326, 'successfully logged in', '2015-08-17 18:22:34', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1327, 'successfully logged in', '2015-08-17 18:27:36', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1328, 'successfully logged in', '2015-08-17 18:47:32', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1329, 'successfully logged in', '2015-08-17 18:48:55', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1330, 'Accessed help content', '2015-08-17 18:49:04', 48, '242', 'HELP CONTENT', 'ADMINISTRATOR'),
(1331, 'accesed', '2015-08-17 18:49:08', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1332, 'successfully logged in', '2015-08-17 20:49:14', 47, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(1333, 'successfully logged in', '2015-08-17 20:59:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1334, 'successfully logged in', '2015-08-17 21:01:25', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1335, 'Accessed administrative member operations', '2015-08-17 21:04:41', 48, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1336, 'Accessed media & files (documents)', '2015-08-17 21:04:47', 48, '281', 'MEDIA & FILES', 'ADMINISTRATOR'),
(1337, 'accesed', '2015-08-17 21:04:52', 48, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1338, 'accesed', '2015-08-17 21:04:54', 48, '281', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1339, 'Viewed scheme payments for scheme #281', '2015-08-17 21:05:55', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1340, 'successfully logged in', '2015-08-17 21:07:47', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1341, 'Viewed scheme payments for scheme #242', '2015-08-17 21:07:56', 48, '242', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1342, 'Viewed scheme payments for scheme #281', '2015-08-17 21:08:31', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1343, 'successfully logged in', '2015-08-17 21:09:49', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1344, 'Viewed scheme payments for scheme #281', '2015-08-17 21:10:38', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1345, 'Accessed setup menu and details', '2015-08-17 21:31:54', 48, '281', 'SETUP', 'ADMINISTRATOR'),
(1346, 'Accessed View Con', '2015-08-17 21:33:45', 48, '281', 'CONTACT CATEGORIES', 'ADMINISTRATOR'),
(1347, 'Accessed administrative member operations', '2015-08-17 21:35:15', 48, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1348, 'accesed home page', '2015-08-17 21:35:25', 0, NULL, 'HOME', NULL),
(1349, 'accesed what if analysis page', '2015-08-17 21:35:30', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1350, 'accesed interest rates page', '2015-08-17 21:35:55', 0, NULL, 'INTEREST_RATES', NULL),
(1351, 'accesed home page', '2015-08-17 21:37:13', 0, NULL, 'HOME', NULL),
(1352, 'accesed annuity quotation page', '2015-08-17 21:37:49', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1353, 'accesed annuity quotation page', '2015-08-17 21:39:06', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1354, 'accesed annuity quotation page', '2015-08-17 21:39:19', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1355, 'accesed interest rates page', '2015-08-17 21:39:22', 0, NULL, 'INTEREST_RATES', NULL),
(1356, 'accesed contact us page', '2015-08-17 21:40:11', 0, NULL, 'CONTACT_US', NULL),
(1357, 'accesed contact us page', '2015-08-18 03:19:07', 0, NULL, 'CONTACT_US', NULL),
(1358, 'accesed annuity quotation page', '2015-08-18 03:23:22', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1359, 'accesed annuity quotation page', '2015-08-18 03:25:09', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1360, 'successfully logged in', '2015-08-18 03:34:57', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1361, 'Accessed setup menu and details', '2015-08-18 03:35:00', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1362, 'successfully logged in', '2015-08-18 03:44:03', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1363, 'Accessed setup menu and details', '2015-08-18 03:44:07', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1364, 'successfully logged in', '2015-08-18 03:44:41', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1365, 'Accessed setup menu and details', '2015-08-18 03:44:48', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1366, 'successfully logged in', '2015-08-18 03:46:18', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1367, 'Accessed setup menu and details', '2015-08-18 03:46:23', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1368, 'successfully logged in', '2015-08-18 03:47:47', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1369, 'Accessed setup menu and details', '2015-08-18 03:47:51', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1370, 'accesed home page', '2015-08-18 03:48:15', 0, NULL, 'HOME', NULL),
(1371, 'successfully logged in', '2015-08-18 03:49:03', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1372, 'Accessed setup menu and details', '2015-08-18 03:49:10', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1373, 'successfully logged in', '2015-08-18 03:49:48', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1374, 'Accessed setup menu and details', '2015-08-18 03:49:57', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1375, 'accesed home page', '2015-08-18 03:50:06', 0, NULL, 'HOME', NULL),
(1376, 'logged out', '2015-08-18 03:51:40', 48, NULL, '', 'ADMINISTRATOR'),
(1377, 'successfully logged in', '2015-08-18 03:51:47', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1378, 'successfully logged in', '2015-08-18 03:52:47', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1379, 'Viewed Schemes', '2015-08-18 03:52:51', 48, '242', 'SCHEMES', 'ADMINISTRATOR'),
(1380, 'successfully logged in', '2015-08-18 03:54:03', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1381, 'accesed', '2015-08-18 03:55:19', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1382, 'accesed', '2015-08-18 03:55:21', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1383, 'successfully logged in', '2015-08-18 03:57:46', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1384, 'successfully logged in', '2015-08-18 03:58:23', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1385, 'successfully logged in', '2015-08-18 04:07:46', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1386, 'successfully logged in', '2015-08-18 04:19:22', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1387, 'successfully logged in', '2015-08-18 04:28:53', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1388, 'successfully logged in', '2015-08-18 04:41:01', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1389, 'successfully logged in', '2015-08-18 04:43:27', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1390, 'successfully logged in', '2015-08-18 04:45:14', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1391, 'successfully logged in', '2015-08-18 04:47:44', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1392, 'successfully logged in', '2015-08-18 04:50:44', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1393, 'successfully logged in', '2015-08-18 04:55:58', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1394, 'successfully logged in', '2015-08-18 04:58:07', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1395, 'successfully logged in', '2015-08-18 05:03:51', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1396, 'successfully logged in', '2015-08-18 05:05:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1397, 'successfully logged in', '2015-08-18 05:08:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1398, 'successfully logged in', '2015-08-18 05:16:49', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1399, 'accesed', '2015-08-18 05:16:59', 48, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1400, 'accesed', '2015-08-18 05:17:02', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1401, 'accesed', '2015-08-18 05:17:12', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1402, 'accesed', '2015-08-18 05:17:17', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1403, 'accesed', '2015-08-18 05:17:20', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1404, 'accesed', '2015-08-18 05:18:08', 48, '242', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1405, 'successfully logged in', '2015-08-18 05:20:59', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1406, 'successfully logged in', '2015-08-18 05:22:39', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1407, 'accesed', '2015-08-18 05:23:02', 48, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1408, 'accesed', '2015-08-18 05:23:04', 48, '281', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1409, 'successfully logged in', '2015-08-18 05:24:33', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1410, 'Viewed scheme payments for scheme #281', '2015-08-18 05:25:27', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1411, 'Viewed scheme payments for scheme #281', '2015-08-18 05:36:26', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1412, 'successfully logged in', '2015-08-18 05:37:22', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1413, 'Viewed scheme payments for scheme #281', '2015-08-18 05:38:03', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1414, 'Viewed scheme payments for scheme #281', '2015-08-18 05:38:46', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1415, 'Viewed scheme receipts for scheme #281', '2015-08-18 05:46:12', 48, '281', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1416, 'successfully logged in', '2015-08-18 05:50:34', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1417, 'Viewed scheme payments for scheme #281', '2015-08-18 05:51:07', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1418, 'Viewed scheme payments for scheme #281', '2015-08-18 05:51:17', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1419, 'Viewed scheme payments for scheme #281', '2015-08-18 05:51:41', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1420, 'Viewed scheme payments for scheme #281', '2015-08-18 05:51:54', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1421, 'Viewed scheme receipts for scheme #281', '2015-08-18 05:52:52', 48, '281', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1422, 'Viewed scheme payments for scheme #281', '2015-08-18 05:53:50', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1423, 'Viewed scheme payments for scheme #281', '2015-08-18 05:54:07', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1424, 'Viewed scheme payments for scheme #281', '2015-08-18 05:54:20', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1425, 'Accessed help content', '2015-08-18 05:54:39', 48, '281', 'HELP CONTENT', 'ADMINISTRATOR'),
(1426, 'successfully logged in', '2015-08-18 07:35:09', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1427, 'successfully logged in', '2015-08-18 07:38:53', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1428, 'successfully logged in', '2015-08-18 07:41:39', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1429, 'successfully logged in', '2015-08-18 07:45:04', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1430, 'successfully logged in', '2015-08-18 07:46:19', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1431, 'Accessed administrative member operations', '2015-08-18 07:49:17', 48, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1432, 'accesed', '2015-08-18 07:49:30', 48, '281', 'MEMBER CONTRIBUTION HISTORY', 'ADMINISTRATOR'),
(1433, 'accesed', '2015-08-18 07:54:25', 48, '1182761', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1434, 'accesed', '2015-08-18 07:54:28', 48, '1182761', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1435, 'Accessed administrative member operations', '2015-08-18 07:57:16', 48, '1182761', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1436, 'accesed', '2015-08-18 07:57:41', 48, '1182761', 'MEMBER BALANCES HISTORY', 'ADMINISTRATOR'),
(1437, 'Viewed scheme receipts for scheme #1182761', '2015-08-18 07:59:45', 48, '1182761', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1438, 'Viewed scheme payments for scheme #1182761', '2015-08-18 08:00:55', 48, '1182761', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1439, 'Accessed administrative member operations', '2015-08-18 08:13:45', 48, '1182761', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1440, 'accesed', '2015-08-18 08:13:57', 48, '1182761', 'MEMBER CONTRIBUTION HISTORY', 'ADMINISTRATOR'),
(1441, 'accesed', '2015-08-18 08:14:17', 48, '1182761', 'MEMBER BALANCES HISTORY', 'ADMINISTRATOR'),
(1442, 'accesed', '2015-08-18 08:14:26', 48, '1182761', 'MEMBER STATEMENT OF ACCOUNT', 'ADMINISTRATOR'),
(1443, 'accesed', '2015-08-18 08:14:47', 48, '1182761', 'MEMBER BENEFITS PROJECTION', 'ADMINISTRATOR'),
(1444, 'Accessed administrative member operations', '2015-08-18 08:15:17', 48, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1445, 'accesed', '2015-08-18 08:15:28', 48, '281', 'MEMBER CONTRIBUTION HISTORY', 'ADMINISTRATOR'),
(1446, 'accesed', '2015-08-18 08:15:46', 48, '281', 'MEMBER BALANCES HISTORY', 'ADMINISTRATOR'),
(1447, 'accesed', '2015-08-18 08:15:57', 48, '281', 'MEMBER STATEMENT OF ACCOUNT', 'ADMINISTRATOR'),
(1448, 'accesed', '2015-08-18 08:16:12', 48, '281', 'MEMBER BENEFITS PROJECTION', 'ADMINISTRATOR'),
(1449, 'accesed', '2015-08-18 08:16:59', 48, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1450, 'successfully logged in', '2015-08-18 08:22:00', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1451, 'successfully logged in', '2015-08-18 08:23:42', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1452, 'Viewed scheme payments for scheme #281', '2015-08-18 08:24:39', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1453, 'Viewed scheme receipts for scheme #281', '2015-08-18 08:27:34', 48, '281', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1454, 'Viewed scheme payments for scheme #281', '2015-08-18 08:27:48', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1455, 'successfully logged in', '2015-08-18 08:51:56', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1456, 'successfully logged in', '2015-08-18 08:53:24', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1457, 'Viewed scheme payments for scheme #242', '2015-08-18 08:53:29', 48, '242', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1458, 'Viewed scheme payments for scheme #281', '2015-08-18 08:53:52', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1459, 'Viewed scheme payments for scheme #281', '2015-08-18 08:54:22', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1460, 'successfully logged in', '2015-08-18 08:55:53', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1461, 'Viewed scheme payments for scheme #281', '2015-08-18 08:56:15', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1462, 'Viewed scheme payments for scheme #281', '2015-08-18 08:56:39', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1463, 'successfully logged in', '2015-08-18 08:57:08', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1464, 'Viewed scheme payments for scheme #1182761', '2015-08-18 08:57:50', 48, '1182761', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1465, 'Viewed scheme payments for scheme #1182761', '2015-08-18 08:58:34', 48, '1182761', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1466, 'Viewed scheme payments for scheme #1182761', '2015-08-18 08:59:29', 48, '1182761', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1467, 'Viewed scheme payments for scheme #1182761', '2015-08-18 09:00:38', 48, '1182761', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1468, 'accesed home page', '2015-08-18 09:09:19', 0, NULL, 'SIGNIN', NULL),
(1469, 'login attempt', '2015-08-18 09:09:23', 0, NULL, 'MEMBER_LOGIN', NULL),
(1470, 'successfully logged in', '2015-08-18 09:09:27', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1471, 'accesed', '2015-08-18 09:11:22', 47, '281', 'MEMBER PERSONAL INFORMATION', 'MEMBER'),
(1472, 'logged out', '2015-08-18 09:11:59', 47, NULL, '', 'MEMBER'),
(1473, 'successfully logged in', '2015-08-18 09:12:05', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1474, 'Viewed scheme payments for scheme #281', '2015-08-18 09:12:34', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1475, 'successfully logged in', '2015-08-18 09:13:44', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1476, 'Viewed scheme payments for scheme #281', '2015-08-18 09:14:12', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1477, 'Viewed scheme payments for scheme #281', '2015-08-18 09:15:27', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1478, 'Viewed scheme payments for scheme #281', '2015-08-18 09:16:04', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1479, 'Viewed scheme payments for scheme #281', '2015-08-18 09:17:45', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1480, 'successfully logged in', '2015-08-18 09:19:31', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1481, 'Viewed scheme payments for scheme #281', '2015-08-18 09:21:21', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1482, 'Viewed scheme payments for scheme #281', '2015-08-18 09:21:34', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1483, 'Viewed scheme payments for scheme #281', '2015-08-18 09:21:46', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1484, 'successfully logged in', '2015-08-18 09:27:00', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1485, 'Viewed scheme receipts for scheme #242', '2015-08-18 09:27:04', 48, '242', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1486, 'Viewed scheme payments for scheme #242', '2015-08-18 09:27:10', 48, '242', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1487, 'Accessed administrative member operations', '2015-08-18 09:29:17', 48, '242', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1488, 'successfully logged in', '2015-08-18 09:30:32', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1489, 'successfully logged in', '2015-08-18 09:33:13', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1490, 'successfully logged in', '2015-08-18 09:52:49', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1491, 'successfully logged in', '2015-08-18 09:54:01', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1492, 'successfully logged in', '2015-08-18 09:59:41', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1493, 'successfully logged in', '2015-08-18 10:01:55', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1494, 'Accessed administrative member operations', '2015-08-18 10:03:38', 48, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1495, 'successfully logged in', '2015-08-18 10:05:19', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1496, 'Accessed administrative member operations', '2015-08-18 10:05:43', 48, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1497, 'successfully logged in', '2015-08-18 10:06:36', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1498, 'Accessed administrative member operations', '2015-08-18 10:06:49', 48, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1499, 'accesed', '2015-08-18 10:07:05', 48, '281', 'MEMBER PERSONAL INFORMATION', 'ADMINISTRATOR'),
(1500, 'successfully logged in', '2015-08-18 10:12:33', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1501, 'Accessed media & files (documents)', '2015-08-18 10:15:00', 48, '281', 'MEDIA & FILES', 'ADMINISTRATOR'),
(1502, 'accesed', '2015-08-18 10:16:46', 48, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1503, 'accesed', '2015-08-18 10:16:49', 48, '281', 'USERS', 'ADMINISTRATOR'),
(1504, 'accesed interest rates page', '2015-08-18 10:22:44', 0, NULL, 'INTEREST_RATES', NULL),
(1505, 'accesed annuity quotation page', '2015-08-18 10:22:46', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1506, 'accesed what if analysis page', '2015-08-18 10:22:50', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1507, 'successfully logged in', '2015-08-18 10:44:00', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1508, 'Accessed User Access Control Panel', '2015-08-18 10:44:41', 48, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1509, 'successfully logged in', '2015-08-18 10:45:23', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1510, 'Accessed User Access Control Panel', '2015-08-18 10:45:38', 48, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1511, 'accesed home page', '2015-08-18 10:50:01', 0, NULL, 'SIGNIN', NULL),
(1512, 'accesed home page', '2015-08-18 10:58:40', 0, NULL, 'HOME', NULL),
(1513, 'accesed registration page', '2015-08-18 10:58:43', 0, NULL, 'REGISTRATION', NULL),
(1514, 'accesed home page', '2015-08-18 10:59:48', 0, NULL, 'HOME', NULL),
(1515, 'accesed what if analysis page', '2015-08-18 11:41:38', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1516, 'accesed registration page', '2015-08-18 11:41:43', 0, NULL, 'REGISTRATION', NULL),
(1517, 'accesed registration page', '2015-08-18 11:56:43', 0, NULL, 'REGISTRATION', NULL),
(1518, 'accesed registration page', '2015-08-18 12:05:01', 0, NULL, 'REGISTRATION', NULL),
(1519, 'successfully logged in', '2015-08-18 12:20:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1520, 'Viewed scheme payments for scheme #281', '2015-08-18 12:21:07', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1521, 'Viewed members for scheme #281', '2015-08-18 12:21:27', 48, '281', 'MEMBERS', 'ADMINISTRATOR'),
(1522, 'Accessed portal analytics & reporting', '2015-08-18 12:21:39', 48, '281', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(1523, 'successfully logged in', '2015-08-18 13:02:27', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1524, 'Accessed setup menu and details', '2015-08-18 13:03:39', 48, '281', 'SETUP', 'ADMINISTRATOR'),
(1525, 'accesed home page', '2015-08-18 13:04:53', 0, NULL, 'HOME', NULL),
(1526, 'logged out', '2015-08-18 13:05:44', 48, NULL, '', 'ADMINISTRATOR'),
(1527, 'accesed home page', '2015-08-18 13:05:50', 0, NULL, 'HOME', NULL),
(1528, 'accesed registration page', '2015-08-18 13:07:35', 0, NULL, 'REGISTRATION', NULL),
(1529, 'accesed home page', '2015-08-18 13:09:09', 0, NULL, 'SIGNIN', NULL),
(1530, 'login attempt', '2015-08-18 13:09:24', 0, NULL, 'MEMBER_LOGIN', NULL),
(1531, 'login attempt', '2015-08-18 13:09:47', 0, NULL, 'MEMBER_LOGIN', NULL),
(1532, 'login attempt', '2015-08-18 13:10:03', 0, NULL, 'MEMBER_LOGIN', NULL),
(1533, 'successfully logged in', '2015-08-18 13:10:09', 47, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1534, 'logged out', '2015-08-18 13:11:25', 47, NULL, '', 'MEMBER'),
(1535, 'successfully logged in', '2015-08-18 13:11:45', 52, NULL, 'ADMIN_LOGIN', 'MEMBER'),
(1536, 'accesed home page', '2015-08-18 13:11:55', 0, NULL, 'SIGNIN', NULL),
(1537, 'accesed home page', '2015-08-18 13:12:32', 0, NULL, 'SIGNIN', NULL),
(1538, 'successfully logged in', '2015-08-18 13:12:41', 52, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1539, 'Viewed editable member personal information', '2015-08-18 13:23:44', 52, '281', 'MEMBER PERSONAL INFORMATION', 'MEMBER'),
(1540, 'Viewed member contribution history', '2015-08-18 13:24:27', 52, '281', 'MEMBER CONTRIBUTION HISTORY', 'MEMBER'),
(1541, 'Viewed member balances history', '2015-08-18 13:25:02', 52, '281', 'MEMBER BALANCES HISTORY', 'MEMBER'),
(1542, 'Viewed member statement of account', '2015-08-18 13:25:21', 52, '281', 'MEMBER STATEMENT OF ACCOUNT', 'MEMBER'),
(1543, 'logged out', '2015-08-18 13:26:26', 52, NULL, '', 'MEMBER'),
(1544, 'successfully logged in', '2015-08-18 13:26:39', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1545, 'Accessed setup menu and details', '2015-08-18 13:29:14', 48, '281', 'SETUP', 'ADMINISTRATOR'),
(1546, 'accesed home page', '2015-08-18 13:31:12', 0, NULL, 'HOME', NULL),
(1547, 'accesed home page', '2015-08-18 13:31:54', 0, NULL, 'HOME', NULL),
(1548, 'accesed home page', '2015-08-18 13:33:07', 0, NULL, 'HOME', NULL),
(1549, 'accesed interest rates page', '2015-08-18 13:34:03', 0, NULL, 'INTEREST_RATES', NULL),
(1550, 'successfully logged in', '2015-08-18 13:34:39', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1551, 'login attempt', '2015-08-18 13:34:45', 0, NULL, 'ADMIN_LOGIN', NULL),
(1552, 'Viewed email contact categories', '2015-08-18 13:34:52', 48, '281', 'CONTACT CATEGORIES', 'ADMINISTRATOR'),
(1553, 'Accessed media & files (documents)', '2015-08-18 13:35:37', 48, '281', 'MEDIA & FILES', 'ADMINISTRATOR'),
(1554, 'Accessed help content', '2015-08-18 13:35:51', 48, '281', 'HELP CONTENT', 'ADMINISTRATOR'),
(1555, 'Accessed page content', '2015-08-18 13:37:39', 48, '281', 'PAGE CONTENT', 'ADMINISTRATOR'),
(1556, 'Viewed Schemes', '2015-08-18 13:37:58', 48, '281', 'SCHEMES', 'ADMINISTRATOR'),
(1557, 'Viewed scheme receipts for scheme #281', '2015-08-18 13:38:12', 48, '281', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1558, 'Viewed scheme payments for scheme #281', '2015-08-18 13:39:39', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1559, 'Viewed scheme payments for scheme #281', '2015-08-18 13:40:08', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1560, 'Viewed members for scheme #281', '2015-08-18 13:42:01', 48, '281', 'MEMBERS', 'ADMINISTRATOR'),
(1561, 'Accessed administrative member operations', '2015-08-18 13:43:51', 48, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(1562, 'Viewed editable member personal information', '2015-08-18 13:44:23', 48, '281', 'MEMBER PERSONAL INFORMATION', 'ADMINISTRATOR'),
(1563, 'Viewed member contribution history', '2015-08-18 13:44:28', 48, '281', 'MEMBER CONTRIBUTION HISTORY', 'ADMINISTRATOR'),
(1564, 'Accessed media & files (documents)', '2015-08-18 13:45:10', 48, '281', 'MEDIA & FILES', 'ADMINISTRATOR'),
(1565, 'Accessed User Access Control Panel', '2015-08-18 13:45:16', 48, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1566, 'Viewed Scheme Managers', '2015-08-18 13:45:52', 48, '281', 'SCHEME MANAGERS', 'ADMINISTRATOR'),
(1567, 'accesed registration page', '2015-08-18 13:46:26', 0, NULL, 'REGISTRATION', NULL),
(1568, 'accesed annuity quotation page', '2015-08-18 13:58:49', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1569, 'accesed what if analysis page', '2015-08-18 13:59:00', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1570, 'Viewed Audit Trails', '2015-08-18 14:00:13', 48, '281', 'AUDIT TRAIL', 'ADMINISTRATOR'),
(1571, 'Accessed portal analytics & reporting', '2015-08-18 14:00:17', 48, '281', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(1572, 'Accessed User Access Control Panel', '2015-08-18 14:01:05', 48, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1573, 'accesed registration page', '2015-08-18 14:02:43', 0, NULL, 'REGISTRATION', NULL),
(1574, 'Viewed Schemes', '2015-08-18 14:04:02', 48, '281', 'SCHEMES', 'ADMINISTRATOR'),
(1575, 'Viewed scheme payments for scheme #281', '2015-08-18 14:05:15', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1576, 'Viewed scheme payments for scheme #281', '2015-08-18 14:06:12', 48, '281', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1577, 'successfully logged in', '2015-08-18 15:38:22', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1578, 'accesed home page', '2015-08-19 08:57:33', 0, NULL, 'HOME', NULL),
(1579, 'accesed home page', '2015-08-19 09:01:34', 0, NULL, 'HOME', NULL),
(1580, 'accesed registration page', '2015-08-19 09:01:39', 0, NULL, 'REGISTRATION', NULL),
(1581, 'successfully logged in', '2015-08-19 09:23:56', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1582, 'Accessed portal analytics & reporting', '2015-08-19 09:24:07', 48, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(1583, 'successfully logged in', '2015-08-19 09:28:46', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1584, 'Accessed portal analytics & reporting', '2015-08-19 09:29:01', 48, '281', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(1585, 'Accessed setup menu and details', '2015-08-19 09:38:32', 48, '281', 'SETUP', 'ADMINISTRATOR'),
(1586, 'accesed home page', '2015-08-19 09:46:03', 0, NULL, 'HOME', NULL),
(1587, 'accesed home page', '2015-08-19 09:46:26', 0, NULL, 'HOME', NULL),
(1588, 'successfully logged in', '2015-08-19 09:49:11', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1589, 'Accessed setup menu and details', '2015-08-19 09:49:14', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1590, 'successfully logged in', '2015-08-19 09:56:35', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1591, 'Accessed setup menu and details', '2015-08-19 09:57:11', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1592, 'successfully logged in', '2015-08-19 09:57:23', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1593, 'login attempt', '2015-08-19 10:20:15', 0, NULL, 'ADMIN_LOGIN', NULL),
(1594, 'successfully logged in', '2015-08-19 10:22:16', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1595, 'Accessed setup menu and details', '2015-08-19 10:22:22', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1596, 'successfully logged in', '2015-08-19 10:22:39', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1597, 'successfully logged in', '2015-08-19 10:23:57', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1598, 'Accessed setup menu and details', '2015-08-19 10:24:00', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1599, 'successfully logged in', '2015-08-19 10:24:09', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1600, 'accesed what if analysis page', '2015-08-19 10:31:06', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1601, 'accesed contact us page', '2015-08-19 10:31:09', 0, NULL, 'CONTACT_US', NULL),
(1602, 'accesed home page', '2015-08-19 10:31:13', 0, NULL, 'HOME', NULL),
(1603, 'successfully logged in', '2015-08-19 10:32:33', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1604, 'Accessed setup menu and details', '2015-08-19 10:32:38', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1605, 'successfully logged in', '2015-08-19 10:33:49', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1606, 'Accessed setup menu and details', '2015-08-19 10:33:53', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1607, 'accesed home page', '2015-08-19 10:34:12', 0, NULL, 'HOME', NULL),
(1608, 'successfully logged in', '2015-08-19 10:35:14', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1609, 'successfully logged in', '2015-08-19 10:38:27', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1610, 'Accessed setup menu and details', '2015-08-19 10:38:30', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1611, 'successfully logged in', '2015-08-19 10:38:57', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1612, 'Accessed setup menu and details', '2015-08-19 10:39:00', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1613, 'accesed home page', '2015-08-19 10:39:03', 0, NULL, 'HOME', NULL),
(1614, 'accesed home page', '2015-08-19 10:39:05', 0, NULL, 'HOME', NULL),
(1615, 'successfully logged in', '2015-08-19 10:39:20', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1616, 'Accessed setup menu and details', '2015-08-19 10:39:25', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1617, 'successfully logged in', '2015-08-19 10:40:55', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1618, 'Accessed setup menu and details', '2015-08-19 10:40:59', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1619, 'successfully logged in', '2015-08-19 10:42:11', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1620, 'Accessed setup menu and details', '2015-08-19 10:42:15', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1621, 'Viewed email contact categories', '2015-08-19 10:42:22', 48, '242', 'CONTACT CATEGORIES', 'ADMINISTRATOR'),
(1622, 'Accessed help content', '2015-08-19 10:42:35', 48, '242', 'HELP CONTENT', 'ADMINISTRATOR'),
(1623, 'Viewed Schemes', '2015-08-19 10:42:45', 48, '242', 'SCHEMES', 'ADMINISTRATOR'),
(1624, 'Viewed scheme receipts for scheme #242', '2015-08-19 10:42:50', 48, '242', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1625, 'Viewed scheme payments for scheme #242', '2015-08-19 10:42:54', 48, '242', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1626, 'Viewed members for scheme #242', '2015-08-19 10:42:57', 48, '242', 'MEMBERS', 'ADMINISTRATOR'),
(1627, 'Viewed members for scheme #281', '2015-08-19 10:43:16', 48, '281', 'MEMBERS', 'ADMINISTRATOR'),
(1628, 'Accessed help content', '2015-08-19 10:43:51', 48, '281', 'HELP CONTENT', 'ADMINISTRATOR'),
(1629, 'successfully logged in', '2015-08-19 10:54:51', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1630, 'Accessed setup menu and details', '2015-08-19 10:55:17', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1631, 'Accessed setup menu and details', '2015-08-19 10:55:26', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1632, 'successfully logged in', '2015-08-19 10:55:37', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1633, 'successfully logged in', '2015-08-19 10:57:23', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1634, 'Accessed setup menu and details', '2015-08-19 10:57:27', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1635, 'successfully logged in', '2015-08-19 10:57:38', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1636, 'successfully logged in', '2015-08-19 11:03:07', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1637, 'Accessed setup menu and details', '2015-08-19 11:04:00', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1638, 'successfully logged in', '2015-08-19 11:04:12', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1639, 'successfully logged in', '2015-08-19 11:04:58', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1640, 'Accessed setup menu and details', '2015-08-19 11:05:02', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1641, 'successfully logged in', '2015-08-19 11:05:10', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1642, 'successfully logged in', '2015-08-19 11:15:18', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1643, 'Viewed members for scheme #242', '2015-08-19 11:15:22', 48, '242', 'MEMBERS', 'ADMINISTRATOR'),
(1644, 'Viewed Schemes', '2015-08-19 11:15:56', 48, '242', 'SCHEMES', 'ADMINISTRATOR'),
(1645, 'Viewed scheme receipts for scheme #242', '2015-08-19 11:16:21', 48, '242', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1646, 'Viewed scheme payments for scheme #242', '2015-08-19 11:16:41', 48, '242', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1647, 'accesed home page', '2015-08-19 11:26:01', 0, NULL, 'HOME', NULL),
(1648, 'accesed home page', '2015-08-19 11:30:17', 0, NULL, 'SIGNIN', NULL),
(1649, 'accesed registration page', '2015-08-19 11:40:18', 0, NULL, 'REGISTRATION', NULL),
(1650, 'accesed registration page', '2015-08-19 11:46:27', 0, NULL, 'REGISTRATION', NULL),
(1651, 'accesed registration page', '2015-08-19 11:47:00', 0, NULL, 'REGISTRATION', NULL),
(1652, 'accesed home page', '2015-08-19 12:04:27', 0, NULL, 'SIGNIN', NULL),
(1653, 'accesed home page', '2015-08-19 12:05:25', 0, NULL, 'SIGNIN', NULL),
(1654, 'accesed home page', '2015-08-19 12:08:17', 0, NULL, 'SIGNIN', NULL),
(1655, 'successfully logged in', '2015-08-19 12:09:38', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1656, 'accesed home page', '2015-08-19 12:09:53', 0, NULL, 'HOME', NULL),
(1657, 'accesed interest rates page', '2015-08-19 12:11:11', 0, NULL, 'INTEREST_RATES', NULL),
(1658, 'accesed contact us page', '2015-08-19 12:11:15', 0, NULL, 'CONTACT_US', NULL),
(1659, 'accesed home page', '2015-08-19 12:11:18', 0, NULL, 'HOME', NULL),
(1660, 'accesed interest rates page', '2015-08-19 12:11:20', 0, NULL, 'INTEREST_RATES', NULL),
(1661, 'accesed annuity quotation page', '2015-08-19 12:11:21', 0, NULL, 'ANNUITY_QUOTATION', NULL);
INSERT INTO `tbl_activity_logs` (`id`, `description`, `datetime`, `user_id`, `scheme`, `access_menu`, `userProfile`) VALUES
(1662, 'accesed what if analysis page', '2015-08-19 12:11:24', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1663, 'accesed what if analysis page', '2015-08-19 12:11:26', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1664, 'accesed contact us page', '2015-08-19 12:11:31', 0, NULL, 'CONTACT_US', NULL),
(1665, 'accesed home page', '2015-08-19 12:11:45', 0, NULL, 'HOME', NULL),
(1666, 'accesed home page', '2015-08-19 12:13:09', 0, NULL, 'HOME', NULL),
(1667, 'login attempt', '2015-08-19 12:18:02', 0, NULL, 'ADMIN_LOGIN', NULL),
(1668, 'login attempt', '2015-08-19 12:18:30', 0, NULL, 'ADMIN_LOGIN', NULL),
(1669, 'accesed home page', '2015-08-19 12:18:47', 0, NULL, 'HOME', NULL),
(1670, 'accesed registration page', '2015-08-19 12:18:51', 0, NULL, 'REGISTRATION', NULL),
(1671, 'accesed registration page', '2015-08-19 12:20:32', 0, NULL, 'REGISTRATION', NULL),
(1672, 'login attempt', '2015-08-19 12:21:22', 0, NULL, 'ADMIN_LOGIN', NULL),
(1673, 'login attempt', '2015-08-19 12:21:26', 0, NULL, 'ADMIN_LOGIN', NULL),
(1674, 'successfully logged in', '2015-08-19 12:21:50', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1675, 'Viewed members for scheme #1277', '2015-08-19 12:22:13', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1676, 'Viewed scheme payments for scheme #1277', '2015-08-19 12:22:35', 53, '1277', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1677, 'Viewed scheme receipts for scheme #1277', '2015-08-19 12:22:48', 53, '1277', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1678, 'Viewed Schemes', '2015-08-19 12:22:59', 53, '1277', 'SCHEMES', 'ADMINISTRATOR'),
(1679, 'successfully logged in', '2015-08-19 12:32:40', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1680, 'Viewed members for scheme #1277', '2015-08-19 12:32:48', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1681, 'Viewed members for scheme #1277', '2015-08-19 12:33:04', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1682, 'successfully logged in', '2015-08-19 12:33:30', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1683, 'Viewed members for scheme #1277', '2015-08-19 12:33:37', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1684, 'Viewed members for scheme #1277', '2015-08-19 12:33:48', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1685, 'successfully logged in', '2015-08-19 12:39:12', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1686, 'Viewed members for scheme #1277', '2015-08-19 12:39:16', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1687, 'Viewed members for scheme #1277', '2015-08-19 12:39:22', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1688, 'successfully logged in', '2015-08-19 12:40:05', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1689, 'Viewed members for scheme #1277', '2015-08-19 12:40:09', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1690, 'Viewed members for scheme #1277', '2015-08-19 12:40:12', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1691, 'successfully logged in', '2015-08-19 12:42:06', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1692, 'Viewed members for scheme #1277', '2015-08-19 12:42:10', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1693, 'Viewed members for scheme #1277', '2015-08-19 12:42:14', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1694, 'successfully logged in', '2015-08-19 12:42:52', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1695, 'Viewed members for scheme #1277', '2015-08-19 12:42:56', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1696, 'Viewed members for scheme #1277', '2015-08-19 12:43:01', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1697, 'successfully logged in', '2015-08-19 12:44:24', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1698, 'Viewed members for scheme #1277', '2015-08-19 12:44:28', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1699, 'Viewed members for scheme #1277', '2015-08-19 12:44:33', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1700, 'Viewed members for scheme #1277', '2015-08-19 12:44:38', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1701, 'Viewed members for scheme #1277', '2015-08-19 12:44:41', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1702, 'Viewed members for scheme #1277', '2015-08-19 12:44:45', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1703, 'Viewed members for scheme #1277', '2015-08-19 12:44:52', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1704, 'Viewed members for scheme #1277', '2015-08-19 12:44:54', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1705, 'successfully logged in', '2015-08-19 12:46:40', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1706, 'Viewed members for scheme #1277', '2015-08-19 12:46:49', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1707, 'Viewed scheme payments for scheme #1277', '2015-08-19 12:46:52', 53, '1277', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1708, 'successfully logged in', '2015-08-19 12:51:33', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1709, 'Viewed members for scheme #1277', '2015-08-19 12:51:37', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1710, 'Viewed members for scheme #1277', '2015-08-19 12:51:43', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1711, 'Viewed members for scheme #1277', '2015-08-19 12:51:47', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1712, 'successfully logged in', '2015-08-19 12:52:51', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1713, 'Viewed members for scheme #1277', '2015-08-19 12:53:02', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1714, 'Viewed members for scheme #1277', '2015-08-19 12:53:06', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1715, 'Viewed members for scheme #1277', '2015-08-19 12:53:18', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1716, 'Viewed members for scheme #1277', '2015-08-19 12:53:21', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1717, 'Viewed members for scheme #1277', '2015-08-19 12:53:24', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1718, 'Viewed members for scheme #1277', '2015-08-19 12:53:36', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1719, 'Viewed members for scheme #1277', '2015-08-19 12:53:44', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1720, 'Viewed members for scheme #1277', '2015-08-19 12:53:54', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1721, 'Viewed scheme payments for scheme #1277', '2015-08-19 12:54:59', 53, '1277', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1722, 'Viewed scheme receipts for scheme #1277', '2015-08-19 12:55:10', 53, '1277', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1723, 'accesed registration page', '2015-08-19 12:56:21', 0, NULL, 'REGISTRATION', NULL),
(1724, 'accesed registration page', '2015-08-19 12:59:30', 0, NULL, 'REGISTRATION', NULL),
(1725, 'accesed registration page', '2015-08-19 12:59:43', 0, NULL, 'REGISTRATION', NULL),
(1726, 'successfully logged in', '2015-08-19 13:02:05', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1727, 'Viewed scheme receipts for scheme #1277', '2015-08-19 13:02:12', 53, '1277', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1728, 'Viewed scheme payments for scheme #1277', '2015-08-19 13:02:32', 53, '1277', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1729, 'Viewed members for scheme #1277', '2015-08-19 13:02:35', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1730, 'Viewed Schemes', '2015-08-19 13:02:40', 53, '1277', 'SCHEMES', 'ADMINISTRATOR'),
(1731, 'Viewed Schemes', '2015-08-19 13:03:43', 53, '1277', 'SCHEMES', 'ADMINISTRATOR'),
(1732, 'successfully logged in', '2015-08-19 13:16:37', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1733, 'Viewed scheme payments for scheme #1277', '2015-08-19 13:16:41', 53, '1277', 'SCHEME PAYMENTS', 'ADMINISTRATOR'),
(1734, 'Viewed scheme receipts for scheme #1277', '2015-08-19 13:16:46', 53, '1277', 'SCHEME RECEIPTS', 'ADMINISTRATOR'),
(1735, 'Viewed members for scheme #1277', '2015-08-19 13:16:49', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1736, 'Viewed members for scheme #1277', '2015-08-19 13:16:52', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1737, 'Viewed members for scheme #1277', '2015-08-19 13:16:55', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1738, 'Viewed members for scheme #1277', '2015-08-19 13:16:58', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1739, 'Viewed members for scheme #1277', '2015-08-19 13:17:01', 53, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(1740, 'accesed registration page', '2015-08-19 13:19:25', 0, NULL, 'REGISTRATION', NULL),
(1741, 'accesed home page', '2015-08-19 13:20:14', 0, NULL, 'SIGNIN', NULL),
(1742, 'login attempt', '2015-08-19 13:20:23', 0, NULL, 'MEMBER_LOGIN', NULL),
(1743, 'successfully logged in', '2015-08-19 13:20:37', 54, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1744, 'login attempt', '2015-08-19 14:07:51', 0, NULL, 'ADMIN_LOGIN', NULL),
(1745, 'login attempt', '2015-08-19 14:35:20', 0, NULL, 'ADMIN_LOGIN', NULL),
(1746, 'login attempt', '2015-08-19 14:38:23', 0, NULL, 'ADMIN_LOGIN', NULL),
(1747, 'successfully logged in', '2015-08-19 14:49:24', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1748, 'logged out', '2015-08-19 14:49:38', 53, NULL, '', 'ADMINISTRATOR'),
(1749, 'accesed home page', '2015-08-19 14:49:59', 0, NULL, 'SIGNIN', NULL),
(1750, 'login attempt', '2015-08-19 14:50:07', 0, NULL, 'MEMBER_LOGIN', NULL),
(1751, 'accesed home page', '2015-08-19 14:50:27', 0, NULL, 'SIGNIN', NULL),
(1752, 'accesed registration page', '2015-08-19 14:50:36', 0, NULL, 'REGISTRATION', NULL),
(1753, 'accesed home page', '2015-08-19 14:51:14', 0, NULL, 'SIGNIN', NULL),
(1754, 'successfully logged in', '2015-08-19 14:51:19', 54, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1755, 'accesed home page', '2015-08-19 19:46:58', 0, NULL, 'SIGNIN', NULL),
(1756, 'login attempt', '2015-08-19 19:59:36', 0, NULL, 'ADMIN_LOGIN', NULL),
(1757, 'login attempt', '2015-08-19 20:04:08', 0, NULL, 'ADMIN_LOGIN', NULL),
(1758, 'successfully logged in', '2015-08-19 20:18:58', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1759, 'successfully logged in', '2015-08-20 01:56:47', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1760, 'logged out', '2015-08-20 01:59:35', 48, NULL, '', 'ADMINISTRATOR'),
(1761, 'accesed home page', '2015-08-20 01:59:42', 0, NULL, 'HOME', NULL),
(1762, 'accesed home page', '2015-08-20 01:59:44', 0, NULL, 'SIGNIN', NULL),
(1763, 'accesed home page', '2015-08-20 02:02:26', 0, NULL, 'SIGNIN', NULL),
(1764, 'accesed home page', '2015-08-20 02:05:40', 0, NULL, 'SIGNIN', NULL),
(1765, 'accesed home page', '2015-08-20 02:06:51', 0, NULL, 'SIGNIN', NULL),
(1766, 'accesed annuity quotation page', '2015-08-20 02:08:27', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1767, 'accesed home page', '2015-08-20 02:08:32', 0, NULL, 'SIGNIN', NULL),
(1768, 'successfully logged in', '2015-08-20 02:24:24', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1769, 'Accessed setup menu and details', '2015-08-20 02:42:39', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1770, 'successfully logged in', '2015-08-20 02:42:58', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1771, 'successfully logged in', '2015-08-20 02:47:25', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1772, 'Accessed setup menu and details', '2015-08-20 02:47:30', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1773, 'successfully logged in', '2015-08-20 02:47:37', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1774, 'successfully logged in', '2015-08-20 02:50:41', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1775, 'successfully logged in', '2015-08-20 02:53:03', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1776, 'Accessed setup menu and details', '2015-08-20 02:53:08', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1777, 'successfully logged in', '2015-08-20 02:53:15', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1778, 'successfully logged in', '2015-08-20 02:53:46', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1779, 'successfully logged in', '2015-08-20 03:01:14', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1780, 'Accessed setup menu and details', '2015-08-20 03:01:17', 48, '242', 'SETUP', 'ADMINISTRATOR'),
(1781, 'successfully logged in', '2015-08-20 03:01:26', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1782, 'accesed home page', '2015-08-20 03:05:02', 0, NULL, 'SIGNIN', NULL),
(1783, 'successfully logged in', '2015-08-20 08:20:42', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1784, 'accesed home page', '2015-08-20 09:03:42', 0, NULL, 'SIGNIN', NULL),
(1785, 'accesed home page', '2015-08-20 09:04:42', 0, NULL, 'SIGNIN', NULL),
(1786, 'accesed home page', '2015-08-20 09:05:35', 0, NULL, 'SIGNIN', NULL),
(1787, 'accesed home page', '2015-08-20 09:06:52', 0, NULL, 'SIGNIN', NULL),
(1788, 'accesed home page', '2015-08-20 09:08:23', 0, NULL, 'SIGNIN', NULL),
(1789, 'accesed home page', '2015-08-20 09:08:26', 0, NULL, 'SIGNIN', NULL),
(1790, 'accesed home page', '2015-08-20 09:09:37', 0, NULL, 'SIGNIN', NULL),
(1791, 'accesed home page', '2015-08-20 09:10:17', 0, NULL, 'SIGNIN', NULL),
(1792, 'accesed home page', '2015-08-20 09:11:06', 0, NULL, 'SIGNIN', NULL),
(1793, 'accesed home page', '2015-08-20 09:11:30', 0, NULL, 'SIGNIN', NULL),
(1794, 'accesed home page', '2015-08-20 09:15:46', 0, NULL, 'SIGNIN', NULL),
(1795, 'accesed home page', '2015-08-20 09:19:21', 0, NULL, 'SIGNIN', NULL),
(1796, 'accesed home page', '2015-08-20 09:19:24', 0, NULL, 'SIGNIN', NULL),
(1797, 'accesed home page', '2015-08-20 09:19:28', 0, NULL, 'SIGNIN', NULL),
(1798, 'accesed home page', '2015-08-20 09:19:56', 0, NULL, 'SIGNIN', NULL),
(1799, 'successfully logged in', '2015-08-20 09:22:48', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1800, 'accesed home page', '2015-08-20 09:31:11', 0, NULL, 'SIGNIN', NULL),
(1801, 'accesed home page', '2015-08-20 09:31:36', 0, NULL, 'SIGNIN', NULL),
(1802, 'accesed home page', '2015-08-20 09:32:12', 0, NULL, 'SIGNIN', NULL),
(1803, 'accesed home page', '2015-08-20 09:33:07', 0, NULL, 'SIGNIN', NULL),
(1804, 'accesed home page', '2015-08-20 09:33:27', 0, NULL, 'SIGNIN', NULL),
(1805, 'accesed home page', '2015-08-20 09:33:44', 0, NULL, 'SIGNIN', NULL),
(1806, 'accesed home page', '2015-08-20 09:34:27', 0, NULL, 'SIGNIN', NULL),
(1807, 'accesed home page', '2015-08-20 09:35:07', 0, NULL, 'SIGNIN', NULL),
(1808, 'accesed home page', '2015-08-20 09:38:27', 0, NULL, 'SIGNIN', NULL),
(1809, 'accesed home page', '2015-08-20 09:38:58', 0, NULL, 'SIGNIN', NULL),
(1810, 'accesed home page', '2015-08-20 09:42:02', 0, NULL, 'SIGNIN', NULL),
(1811, 'accesed home page', '2015-08-20 09:42:56', 0, NULL, 'SIGNIN', NULL),
(1812, 'accesed home page', '2015-08-20 09:43:58', 0, NULL, 'SIGNIN', NULL),
(1813, 'accesed home page', '2015-08-20 09:49:00', 0, NULL, 'SIGNIN', NULL),
(1814, 'accesed registration page', '2015-08-20 09:49:47', 0, NULL, 'REGISTRATION', NULL),
(1815, 'accesed registration page', '2015-08-20 09:51:06', 0, NULL, 'REGISTRATION', NULL),
(1816, 'accesed home page', '2015-08-20 09:52:43', 0, NULL, 'HOME', NULL),
(1817, 'accesed registration page', '2015-08-20 09:52:46', 0, NULL, 'REGISTRATION', NULL),
(1818, 'accesed registration page', '2015-08-20 09:54:40', 0, NULL, 'REGISTRATION', NULL),
(1819, 'successfully logged in', '2015-08-20 09:59:13', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1820, 'successfully logged in', '2015-08-20 10:17:50', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1821, 'accesed registration page', '2015-08-20 10:21:24', 0, NULL, 'REGISTRATION', NULL),
(1822, 'successfully logged in', '2015-08-20 11:03:11', 48, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1823, 'accesed registration page', '2015-08-20 11:04:40', 0, NULL, 'REGISTRATION', NULL),
(1824, 'accesed registration page', '2015-08-20 11:05:56', 0, NULL, 'REGISTRATION', NULL),
(1825, 'accesed registration page', '2015-08-20 11:07:32', 0, NULL, 'REGISTRATION', NULL),
(1826, 'accesed registration page', '2015-08-20 11:07:40', 0, NULL, 'REGISTRATION', NULL),
(1827, 'accesed registration page', '2015-08-20 11:15:14', 0, NULL, 'REGISTRATION', NULL),
(1828, 'successfully logged in', '2015-08-20 11:32:45', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1829, 'accesed registration page', '2015-08-20 11:33:41', 0, NULL, 'REGISTRATION', NULL),
(1830, 'accesed registration page', '2015-08-20 11:39:28', 0, NULL, 'REGISTRATION', NULL),
(1831, 'accesed home page', '2015-08-20 11:39:40', 0, NULL, 'SIGNIN', NULL),
(1832, 'accesed registration page', '2015-08-20 11:43:40', 0, NULL, 'REGISTRATION', NULL),
(1833, 'accesed registration page', '2015-08-20 11:53:26', 0, NULL, 'REGISTRATION', NULL),
(1834, 'accesed registration page', '2015-08-20 11:54:04', 0, NULL, 'REGISTRATION', NULL),
(1835, 'accesed registration page', '2015-08-20 12:01:50', 0, NULL, 'REGISTRATION', NULL),
(1836, 'accesed registration page', '2015-08-20 12:10:39', 0, NULL, 'REGISTRATION', NULL),
(1837, 'accesed home page', '2015-08-20 12:10:58', 0, NULL, 'HOME', NULL),
(1838, 'accesed registration page', '2015-08-20 12:12:10', 0, NULL, 'REGISTRATION', NULL),
(1839, 'accesed registration page', '2015-08-20 12:12:47', 0, NULL, 'REGISTRATION', NULL),
(1840, 'accesed registration page', '2015-08-20 12:13:54', 0, NULL, 'REGISTRATION', NULL),
(1841, 'accesed registration page', '2015-08-20 12:15:26', 0, NULL, 'REGISTRATION', NULL),
(1842, 'successfully logged in', '2015-08-20 12:15:36', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1843, 'accesed registration page', '2015-08-20 12:18:34', 0, NULL, 'REGISTRATION', NULL),
(1844, 'accesed home page', '2015-08-20 12:19:04', 0, NULL, 'HOME', NULL),
(1845, 'accesed registration page', '2015-08-20 12:19:06', 0, NULL, 'REGISTRATION', NULL),
(1846, 'accesed home page', '2015-08-20 12:19:49', 0, NULL, 'HOME', NULL),
(1847, 'accesed registration page', '2015-08-20 12:23:51', 0, NULL, 'REGISTRATION', NULL),
(1848, 'accesed interest rates page', '2015-08-20 12:27:02', 0, NULL, 'INTEREST_RATES', NULL),
(1849, 'accesed annuity quotation page', '2015-08-20 12:28:10', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1850, 'accesed interest rates page', '2015-08-20 12:34:12', 0, NULL, 'INTEREST_RATES', NULL),
(1851, 'accesed interest rates page', '2015-08-20 12:35:31', 0, NULL, 'INTEREST_RATES', NULL),
(1852, 'accesed registration page', '2015-08-20 12:35:44', 0, NULL, 'REGISTRATION', NULL),
(1853, 'accesed registration page', '2015-08-20 12:56:33', 0, NULL, 'REGISTRATION', NULL),
(1854, 'accesed registration page', '2015-08-20 12:57:49', 0, NULL, 'REGISTRATION', NULL),
(1855, 'accesed registration page', '2015-08-20 12:59:21', 0, NULL, 'REGISTRATION', NULL),
(1856, 'accesed home page', '2015-08-20 12:59:37', 0, NULL, 'HOME', NULL),
(1857, 'accesed annuity quotation page', '2015-08-20 13:00:17', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1858, 'accesed registration page', '2015-08-20 13:00:39', 0, NULL, 'REGISTRATION', NULL),
(1859, 'accesed registration page', '2015-08-20 13:26:33', 0, NULL, 'REGISTRATION', NULL),
(1860, 'accesed registration page', '2015-08-20 13:55:18', 0, NULL, 'REGISTRATION', NULL),
(1861, 'accesed registration page', '2015-08-20 13:55:37', 0, NULL, 'REGISTRATION', NULL),
(1862, 'accesed registration page', '2015-08-20 14:58:15', 0, NULL, 'REGISTRATION', NULL),
(1863, 'accesed home page', '2015-08-20 14:59:06', 0, NULL, 'HOME', NULL),
(1864, 'accesed registration page', '2015-08-20 14:59:15', 0, NULL, 'REGISTRATION', NULL),
(1865, 'accesed registration page', '2015-08-20 14:59:55', 0, NULL, 'REGISTRATION', NULL),
(1866, 'accesed annuity quotation page', '2015-08-20 15:06:54', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1867, 'successfully logged in', '2015-08-20 15:22:55', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1868, 'successfully logged in', '2015-08-20 15:24:00', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1869, 'successfully logged in', '2015-08-20 15:34:05', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1870, 'successfully logged in', '2015-08-20 15:34:58', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1871, 'successfully logged in', '2015-08-20 15:55:51', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1872, 'accesed annuity quotation page', '2015-08-20 16:11:24', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1873, 'accesed annuity quotation page', '2015-08-20 16:15:27', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1874, 'accesed annuity quotation page', '2015-08-20 16:17:17', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1875, 'accesed what if analysis page', '2015-08-20 16:37:01', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1876, 'accesed annuity quotation page', '2015-08-20 16:41:40', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1877, 'accesed annuity quotation page', '2015-08-20 17:09:43', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1878, 'accesed annuity quotation page', '2015-08-20 17:10:20', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1879, 'accesed annuity quotation page', '2015-08-20 17:11:33', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1880, 'accesed annuity quotation page', '2015-08-20 17:12:12', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1881, 'accesed annuity quotation page', '2015-08-20 17:12:45', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1882, 'accesed annuity quotation page', '2015-08-20 17:13:33', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1883, 'accesed annuity quotation page', '2015-08-20 17:14:32', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1884, 'accesed annuity quotation page', '2015-08-20 17:14:33', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1885, 'accesed annuity quotation page', '2015-08-20 17:16:47', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1886, 'accesed annuity quotation page', '2015-08-20 17:17:42', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1887, 'accesed annuity quotation page', '2015-08-20 17:22:35', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1888, 'accesed annuity quotation page', '2015-08-20 17:32:26', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1889, 'accesed annuity quotation page', '2015-08-20 17:35:30', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1890, 'accesed home page', '2015-08-20 17:36:13', 0, NULL, 'SIGNIN', NULL),
(1891, 'accesed annuity quotation page', '2015-08-20 17:36:30', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1892, 'accesed annuity quotation page', '2015-08-20 17:40:24', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1893, 'accesed what if analysis page', '2015-08-20 17:41:21', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(1894, 'successfully logged in', '2015-08-20 17:42:07', 53, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1895, 'accesed annuity quotation page', '2015-08-20 17:43:14', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1896, 'accesed annuity quotation page', '2015-08-20 17:44:08', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1897, 'accesed annuity quotation page', '2015-08-20 17:46:38', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1898, 'accesed annuity quotation page', '2015-08-20 17:46:46', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1899, 'accesed annuity quotation page', '2015-08-20 17:46:49', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1900, 'accesed annuity quotation page', '2015-08-20 17:47:25', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1901, 'accesed annuity quotation page', '2015-08-20 17:49:01', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1902, 'accesed annuity quotation page', '2015-08-20 17:49:22', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1903, 'accesed annuity quotation page', '2015-08-20 17:50:04', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1904, 'accesed annuity quotation page', '2015-08-20 17:50:12', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1905, 'accesed annuity quotation page', '2015-08-20 17:51:26', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1906, 'accesed home page', '2015-08-20 17:54:08', 0, NULL, 'HOME', NULL),
(1907, 'accesed registration page', '2015-08-20 17:55:15', 0, NULL, 'REGISTRATION', NULL),
(1908, 'accesed registration page', '2015-08-20 17:55:21', 0, NULL, 'REGISTRATION', NULL),
(1909, 'accesed registration page', '2015-08-20 17:55:35', 0, NULL, 'REGISTRATION', NULL),
(1910, 'accesed registration page', '2015-08-20 18:08:55', 0, NULL, 'REGISTRATION', NULL),
(1911, 'accesed registration page', '2015-08-20 18:10:18', 0, NULL, 'REGISTRATION', NULL),
(1912, 'accesed home page', '2015-08-20 18:10:20', 0, NULL, 'HOME', NULL),
(1913, 'accesed registration page', '2015-08-20 18:10:56', 0, NULL, 'REGISTRATION', NULL),
(1914, 'accesed registration page', '2015-08-20 18:14:57', 0, NULL, 'REGISTRATION', NULL),
(1915, 'accesed home page', '2015-08-20 18:29:27', 0, NULL, 'SIGNIN', NULL),
(1916, 'accesed registration page', '2015-08-20 18:34:42', 0, NULL, 'REGISTRATION', NULL),
(1917, 'accesed home page', '2015-08-20 18:36:29', 0, NULL, 'HOME', NULL),
(1918, 'accesed registration page', '2015-08-20 18:36:53', 0, NULL, 'REGISTRATION', NULL),
(1919, 'accesed home page', '2015-08-20 18:40:20', 0, NULL, 'HOME', NULL),
(1920, 'accesed annuity quotation page', '2015-08-20 18:44:31', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1921, 'successfully logged in', '2015-08-20 18:52:56', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1922, 'accesed registration page', '2015-08-20 18:56:05', 0, NULL, 'REGISTRATION', NULL),
(1923, 'accesed registration page', '2015-08-20 18:56:05', 0, NULL, 'REGISTRATION', NULL),
(1924, 'accesed home page', '2015-08-20 18:59:49', 0, NULL, 'SIGNIN', NULL),
(1925, 'successfully logged in', '2015-08-20 19:00:30', 61, NULL, 'MEMBER_LOGIN', 'MEMBER'),
(1926, 'accesed home page', '2015-08-20 19:03:56', 0, NULL, 'HOME', NULL),
(1927, 'accesed registration page', '2015-08-20 19:04:46', 0, NULL, 'REGISTRATION', NULL),
(1928, 'accesed home page', '2015-08-20 19:05:33', 0, NULL, 'SIGNIN', NULL),
(1929, 'accesed registration page', '2015-08-20 19:11:31', 0, NULL, 'REGISTRATION', NULL),
(1930, 'accesed home page', '2015-08-20 19:12:25', 0, NULL, 'SIGNIN', NULL),
(1931, 'accesed home page', '2015-08-21 06:54:44', 0, NULL, 'HOME', NULL),
(1932, 'accesed annuity quotation page', '2015-08-21 06:55:09', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1933, 'accesed annuity quotation page', '2015-08-21 06:56:32', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1934, 'accesed annuity quotation page', '2015-08-21 06:58:25', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1935, 'accesed annuity quotation page', '2015-08-21 06:59:03', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1936, 'accesed annuity quotation page', '2015-08-21 06:59:20', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1937, 'login attempt', '2015-08-21 07:00:27', 0, NULL, 'ADMIN_LOGIN', NULL),
(1938, 'successfully logged in', '2015-08-21 07:15:13', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1939, 'accesed home page', '2015-08-21 07:59:29', 0, NULL, 'HOME', NULL),
(1940, 'accesed home page', '2015-08-21 08:00:13', 0, NULL, 'HOME', NULL),
(1941, 'accesed home page', '2015-08-21 08:00:57', 0, NULL, 'HOME', NULL),
(1942, 'accesed registration page', '2015-08-21 08:01:00', 0, NULL, 'REGISTRATION', NULL),
(1943, 'accesed registration page', '2015-08-21 08:11:05', 0, NULL, 'REGISTRATION', NULL),
(1944, 'accesed registration page', '2015-08-21 08:12:52', 0, NULL, 'REGISTRATION', NULL),
(1945, 'accesed registration page', '2015-08-21 08:13:23', 0, NULL, 'REGISTRATION', NULL),
(1946, 'accesed annuity quotation page', '2015-08-21 08:13:46', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1947, 'accesed annuity quotation page', '2015-08-21 08:14:39', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1948, 'accesed registration page', '2015-08-21 08:14:45', 0, NULL, 'REGISTRATION', NULL),
(1949, 'login attempt', '2015-08-21 08:16:30', 0, NULL, 'ADMIN_LOGIN', NULL),
(1950, 'successfully logged in', '2015-08-21 08:16:51', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1951, 'successfully logged in', '2015-08-21 08:17:40', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1952, 'successfully logged in', '2015-08-21 08:19:26', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1953, 'Accessed User Access Control Panel', '2015-08-21 08:19:33', 60, '1277', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(1954, 'successfully logged in', '2015-08-21 08:21:08', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1955, 'successfully logged in', '2015-08-21 08:28:37', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1956, 'successfully logged in', '2015-08-21 08:30:09', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1957, 'successfully logged in', '2015-08-21 08:31:42', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1958, 'successfully logged in', '2015-08-21 08:37:17', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1959, 'successfully logged in', '2015-08-21 08:38:42', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1960, 'accesed home page', '2015-08-21 08:48:22', 0, NULL, 'HOME', NULL),
(1961, 'accesed registration page', '2015-08-21 08:48:24', 0, NULL, 'REGISTRATION', NULL),
(1962, 'accesed registration page', '2015-08-21 08:50:09', 0, NULL, 'REGISTRATION', NULL),
(1963, 'successfully logged in', '2015-08-21 08:51:15', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1964, 'Accessed setup menu and details', '2015-08-21 08:51:24', 60, '1277', 'SETUP', 'ADMINISTRATOR'),
(1965, 'successfully logged in', '2015-08-21 08:52:14', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(1966, 'Accessed setup menu and details', '2015-08-21 08:52:23', 60, '1277', 'SETUP', 'ADMINISTRATOR'),
(1967, 'accesed registration page', '2015-08-21 09:08:33', 0, NULL, 'REGISTRATION', NULL),
(1968, 'accesed registration page', '2015-08-21 09:11:44', 0, NULL, 'REGISTRATION', NULL),
(1969, 'accesed registration page', '2015-08-21 09:12:15', 0, NULL, 'REGISTRATION', NULL),
(1970, 'accesed registration page', '2015-08-21 09:16:46', 0, NULL, 'REGISTRATION', NULL),
(1971, 'accesed registration page', '2015-08-21 09:22:39', 0, NULL, 'REGISTRATION', NULL),
(1972, 'accesed home page', '2015-08-21 09:29:41', 0, NULL, 'HOME', NULL),
(1973, 'accesed registration page', '2015-08-21 09:29:47', 0, NULL, 'REGISTRATION', NULL),
(1974, 'accesed home page', '2015-08-21 09:37:11', 0, NULL, 'HOME', NULL),
(1975, 'accesed home page', '2015-08-21 09:38:39', 0, NULL, 'HOME', NULL),
(1976, 'accesed registration page', '2015-08-21 09:48:52', 0, NULL, 'REGISTRATION', NULL),
(1977, 'accesed annuity quotation page', '2015-08-21 09:49:20', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1978, 'accesed home page', '2015-08-21 09:49:29', 0, NULL, 'HOME', NULL),
(1979, 'accesed home page', '2015-08-21 09:49:39', 0, NULL, 'SIGNIN', NULL),
(1980, 'accesed home page', '2015-08-21 09:53:07', 0, NULL, 'SIGNIN', NULL),
(1981, 'accesed home page', '2015-08-21 09:53:51', 0, NULL, 'SIGNIN', NULL),
(1982, 'accesed annuity quotation page', '2015-08-21 09:54:45', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1983, 'accesed home page', '2015-08-21 10:01:19', 0, NULL, 'SIGNIN', NULL),
(1984, 'accesed home page', '2015-08-21 10:13:24', 0, NULL, 'SIGNIN', NULL),
(1985, 'accesed home page', '2015-08-21 10:20:59', 0, NULL, 'SIGNIN', NULL),
(1986, 'successfully logged in', '2015-08-21 10:22:19', 65, NULL, 'ADMIN_LOGIN', 'AGENT'),
(1987, 'successfully logged in', '2015-08-21 10:23:14', 65, NULL, 'ADMIN_LOGIN', 'AGENT'),
(1988, 'accesed home page', '2015-08-21 10:29:46', 0, NULL, 'HOME', NULL),
(1989, 'accesed interest rates page', '2015-08-21 10:30:00', 0, NULL, 'INTEREST_RATES', NULL),
(1990, 'Viewed Schemes', '2015-08-21 10:32:24', 65, '1277', 'SCHEMES', 'AGENT'),
(1991, 'accesed registration page', '2015-08-21 15:11:34', 0, NULL, 'REGISTRATION', NULL),
(1992, 'accesed registration page', '2015-08-21 15:16:46', 0, NULL, 'REGISTRATION', NULL),
(1993, 'accesed registration page', '2015-08-21 15:53:39', 0, NULL, 'REGISTRATION', NULL),
(1994, 'accesed annuity quotation page', '2015-08-21 16:00:03', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(1995, 'accesed home page', '2015-08-24 08:56:11', 0, NULL, 'HOME', NULL),
(1996, 'accesed home page', '2015-08-24 08:56:19', 0, NULL, 'SIGNIN', NULL),
(1997, 'accesed registration page', '2015-08-24 09:16:16', 0, NULL, 'REGISTRATION', NULL),
(1998, 'accesed registration page', '2015-08-24 09:17:26', 0, NULL, 'REGISTRATION', NULL),
(1999, 'accesed registration page', '2015-08-24 09:19:33', 0, NULL, 'REGISTRATION', NULL),
(2000, 'accesed registration page', '2015-08-24 09:23:53', 0, NULL, 'REGISTRATION', NULL),
(2001, 'accesed registration page', '2015-08-24 09:27:46', 0, NULL, 'REGISTRATION', NULL),
(2002, 'accesed registration page', '2015-08-24 09:29:35', 0, NULL, 'REGISTRATION', NULL),
(2003, 'accesed registration page', '2015-08-24 09:45:48', 0, NULL, 'REGISTRATION', NULL),
(2004, 'accesed registration page', '2015-08-24 09:53:41', 0, NULL, 'REGISTRATION', NULL),
(2005, 'accesed registration page', '2015-08-24 09:57:36', 0, NULL, 'REGISTRATION', NULL),
(2006, 'accesed registration page', '2015-08-24 10:07:14', 0, NULL, 'REGISTRATION', NULL),
(2007, 'accesed registration page', '2015-08-24 10:07:39', 0, NULL, 'REGISTRATION', NULL),
(2008, 'accesed registration page', '2015-08-24 10:08:05', 0, NULL, 'REGISTRATION', NULL),
(2009, 'accesed registration page', '2015-08-24 10:11:05', 0, NULL, 'REGISTRATION', NULL),
(2010, 'accesed registration page', '2015-08-24 10:11:48', 0, NULL, 'REGISTRATION', NULL),
(2011, 'accesed registration page', '2015-08-24 10:12:46', 0, NULL, 'REGISTRATION', NULL),
(2012, 'accesed registration page', '2015-08-24 10:13:24', 0, NULL, 'REGISTRATION', NULL),
(2013, 'accesed registration page', '2015-08-24 10:14:17', 0, NULL, 'REGISTRATION', NULL),
(2014, 'accesed annuity quotation page', '2015-08-24 10:16:46', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2015, 'accesed registration page', '2015-08-24 10:17:23', 0, NULL, 'REGISTRATION', NULL),
(2016, 'accesed registration page', '2015-08-24 10:30:16', 0, NULL, 'REGISTRATION', NULL),
(2017, 'accesed registration page', '2015-08-24 10:30:28', 0, NULL, 'REGISTRATION', NULL),
(2018, 'accesed registration page', '2015-08-24 10:31:58', 0, NULL, 'REGISTRATION', NULL),
(2019, 'accesed registration page', '2015-08-24 10:59:58', 0, NULL, 'REGISTRATION', NULL),
(2020, 'accesed registration page', '2015-08-24 11:01:51', 0, NULL, 'REGISTRATION', NULL),
(2021, 'accesed annuity quotation page', '2015-08-24 11:02:44', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2022, 'accesed annuity quotation page', '2015-08-24 11:07:55', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2023, 'accesed annuity quotation page', '2015-08-24 11:08:20', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2024, 'accesed registration page', '2015-08-24 11:08:29', 0, NULL, 'REGISTRATION', NULL),
(2025, 'successfully logged in', '2015-08-24 11:08:52', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2026, 'login attempt', '2015-08-24 11:26:51', 0, NULL, 'ADMIN_LOGIN', NULL),
(2027, 'successfully logged in', '2015-08-24 11:28:40', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2028, 'Viewed members for scheme #1277', '2015-08-24 11:29:07', 60, '1277', 'MEMBERS', 'ADMINISTRATOR'),
(2029, 'Accessed User Access Control Panel', '2015-08-24 11:30:27', 60, '1277', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2030, 'Viewed portal users', '2015-08-24 11:31:30', 60, '1277', 'USERS', 'ADMINISTRATOR'),
(2031, 'Viewed portal users', '2015-08-24 11:31:53', 60, '1277', 'USERS', 'ADMINISTRATOR'),
(2032, 'accesed home page', '2015-08-24 11:33:03', 0, NULL, 'HOME', NULL),
(2033, 'accesed registration page', '2015-08-24 11:33:59', 0, NULL, 'REGISTRATION', NULL),
(2034, 'accesed registration page', '2015-08-24 11:37:33', 0, NULL, 'REGISTRATION', NULL),
(2035, 'accesed registration page', '2015-08-24 11:37:39', 0, NULL, 'REGISTRATION', NULL),
(2036, 'accesed registration page', '2015-08-24 11:38:10', 0, NULL, 'REGISTRATION', NULL),
(2037, 'accesed registration page', '2015-08-24 11:40:39', 0, NULL, 'REGISTRATION', NULL),
(2038, 'accesed registration page', '2015-08-24 11:41:39', 0, NULL, 'REGISTRATION', NULL),
(2039, 'accesed registration page', '2015-08-24 11:42:41', 0, NULL, 'REGISTRATION', NULL),
(2040, 'accesed registration page', '2015-08-24 11:43:18', 0, NULL, 'REGISTRATION', NULL),
(2041, 'accesed registration page', '2015-08-24 11:58:27', 0, NULL, 'REGISTRATION', NULL),
(2042, 'accesed registration page', '2015-08-24 12:14:14', 0, NULL, 'REGISTRATION', NULL),
(2043, 'accesed registration page', '2015-08-24 12:14:27', 0, NULL, 'REGISTRATION', NULL),
(2044, 'accesed registration page', '2015-08-24 12:15:13', 0, NULL, 'REGISTRATION', NULL),
(2045, 'accesed registration page', '2015-08-24 12:19:26', 0, NULL, 'REGISTRATION', NULL),
(2046, 'accesed registration page', '2015-08-24 12:20:15', 0, NULL, 'REGISTRATION', NULL),
(2047, 'accesed registration page', '2015-08-24 12:20:46', 0, NULL, 'REGISTRATION', NULL),
(2048, 'accesed registration page', '2015-08-24 12:28:12', 0, NULL, 'REGISTRATION', NULL),
(2049, 'accesed registration page', '2015-08-24 12:29:07', 0, NULL, 'REGISTRATION', NULL),
(2050, 'accesed registration page', '2015-08-24 12:32:05', 0, NULL, 'REGISTRATION', NULL),
(2051, 'accesed registration page', '2015-08-24 12:33:37', 0, NULL, 'REGISTRATION', NULL),
(2052, 'accesed registration page', '2015-08-24 12:34:44', 0, NULL, 'REGISTRATION', NULL),
(2053, 'accesed registration page', '2015-08-24 12:36:10', 0, NULL, 'REGISTRATION', NULL),
(2054, 'accesed registration page', '2015-08-24 12:37:08', 0, NULL, 'REGISTRATION', NULL),
(2055, 'accesed registration page', '2015-08-24 12:37:50', 0, NULL, 'REGISTRATION', NULL),
(2056, 'accesed registration page', '2015-08-24 12:39:46', 0, NULL, 'REGISTRATION', NULL),
(2057, 'accesed registration page', '2015-08-24 12:42:38', 0, NULL, 'REGISTRATION', NULL),
(2058, 'accesed registration page', '2015-08-24 12:45:45', 0, NULL, 'REGISTRATION', NULL),
(2059, 'accesed annuity quotation page', '2015-08-24 12:47:10', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2060, 'accesed annuity quotation page', '2015-08-24 12:48:58', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2061, 'accesed contact us page', '2015-08-24 12:49:07', 0, NULL, 'CONTACT_US', NULL),
(2062, 'accesed what if analysis page', '2015-08-24 12:49:22', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2063, 'accesed interest rates page', '2015-08-24 12:49:29', 0, NULL, 'INTEREST_RATES', NULL),
(2064, 'accesed annuity quotation page', '2015-08-24 12:49:37', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2065, 'accesed what if analysis page', '2015-08-24 12:49:40', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2066, 'accesed what if analysis page', '2015-08-24 12:50:21', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2067, 'accesed what if analysis page', '2015-08-24 12:50:28', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2068, 'accesed interest rates page', '2015-08-24 12:50:31', 0, NULL, 'INTEREST_RATES', NULL),
(2069, 'accesed what if analysis page', '2015-08-24 12:51:18', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2070, 'accesed what if analysis page', '2015-08-24 12:52:07', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2071, 'accesed what if analysis page', '2015-08-24 12:56:04', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2072, 'accesed interest rates page', '2015-08-24 12:56:09', 0, NULL, 'INTEREST_RATES', NULL),
(2073, 'accesed interest rates page', '2015-08-24 12:57:35', 0, NULL, 'INTEREST_RATES', NULL),
(2074, 'accesed interest rates page', '2015-08-24 12:57:56', 0, NULL, 'INTEREST_RATES', NULL),
(2075, 'accesed interest rates page', '2015-08-24 12:59:10', 0, NULL, 'INTEREST_RATES', NULL),
(2076, 'accesed what if analysis page', '2015-08-24 12:59:32', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2077, 'accesed home page', '2015-08-24 13:01:47', 0, NULL, 'HOME', NULL),
(2078, 'accesed what if analysis page', '2015-08-24 13:01:51', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2079, 'accesed contact us page', '2015-08-24 13:01:52', 0, NULL, 'CONTACT_US', NULL),
(2080, 'accesed contact us page', '2015-08-24 13:02:52', 0, NULL, 'CONTACT_US', NULL),
(2081, 'accesed contact us page', '2015-08-24 13:03:10', 0, NULL, 'CONTACT_US', NULL),
(2082, 'accesed contact us page', '2015-08-24 13:04:15', 0, NULL, 'CONTACT_US', NULL),
(2083, 'accesed contact us page', '2015-08-24 13:05:03', 0, NULL, 'CONTACT_US', NULL),
(2084, 'accesed contact us page', '2015-08-24 13:05:26', 0, NULL, 'CONTACT_US', NULL),
(2085, 'accesed annuity quotation page', '2015-08-24 13:05:37', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2086, 'accesed home page', '2015-08-24 13:05:39', 0, NULL, 'HOME', NULL),
(2087, 'accesed contact us page', '2015-08-24 13:06:45', 0, NULL, 'CONTACT_US', NULL),
(2088, 'accesed what if analysis page', '2015-08-24 13:06:48', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2089, 'accesed interest rates page', '2015-08-24 13:06:55', 0, NULL, 'INTEREST_RATES', NULL),
(2090, 'accesed interest rates page', '2015-08-24 13:07:09', 0, NULL, 'INTEREST_RATES', NULL),
(2091, 'accesed home page', '2015-08-24 19:12:47', 0, NULL, 'HOME', NULL),
(2092, 'accesed contact us page', '2015-08-24 19:12:58', 0, NULL, 'CONTACT_US', NULL),
(2093, 'accesed contact us page', '2015-08-24 19:13:20', 0, NULL, 'CONTACT_US', NULL),
(2094, 'accesed interest rates page', '2015-08-24 19:13:56', 0, NULL, 'INTEREST_RATES', NULL),
(2095, 'accesed annuity quotation page', '2015-08-24 19:16:06', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2096, 'accesed annuity quotation page', '2015-08-24 19:17:25', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2097, 'accesed home page', '2015-08-24 19:17:52', 0, NULL, 'HOME', NULL),
(2098, 'accesed home page', '2015-08-24 19:18:02', 0, NULL, 'HOME', NULL),
(2099, 'accesed home page', '2015-08-24 19:18:21', 0, NULL, 'HOME', NULL),
(2100, 'accesed home page', '2015-08-24 19:18:29', 0, NULL, 'HOME', NULL),
(2101, 'accesed home page', '2015-08-24 19:18:53', 0, NULL, 'HOME', NULL),
(2102, 'accesed annuity quotation page', '2015-08-24 19:21:56', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2103, 'accesed home page', '2015-08-24 19:22:01', 0, NULL, 'HOME', NULL),
(2104, 'accesed home page', '2015-08-24 19:22:05', 0, NULL, 'HOME', NULL),
(2105, 'accesed home page', '2015-08-24 19:24:37', 0, NULL, 'HOME', NULL),
(2106, 'accesed home page', '2015-08-24 19:24:44', 0, NULL, 'HOME', NULL),
(2107, 'accesed home page', '2015-08-24 19:24:52', 0, NULL, 'HOME', NULL),
(2108, 'accesed home page', '2015-08-24 19:26:14', 0, NULL, 'HOME', NULL),
(2109, 'accesed home page', '2015-08-24 19:26:37', 0, NULL, 'HOME', NULL),
(2110, 'accesed home page', '2015-08-24 19:26:53', 0, NULL, 'HOME', NULL),
(2111, 'accesed contact us page', '2015-08-24 19:30:57', 0, NULL, 'CONTACT_US', NULL),
(2112, 'accesed what if analysis page', '2015-08-24 19:30:59', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2113, 'accesed interest rates page', '2015-08-24 19:31:04', 0, NULL, 'INTEREST_RATES', NULL),
(2114, 'accesed interest rates page', '2015-08-24 19:34:37', 0, NULL, 'INTEREST_RATES', NULL),
(2115, 'accesed home page', '2015-08-24 19:34:39', 0, NULL, 'HOME', NULL),
(2116, 'accesed home page', '2015-08-24 19:34:51', 0, NULL, 'HOME', NULL),
(2117, 'accesed home page', '2015-08-24 19:38:53', 0, NULL, 'HOME', NULL),
(2118, 'accesed home page', '2015-08-24 19:44:32', 0, NULL, 'HOME', NULL),
(2119, 'accesed home page', '2015-08-24 19:48:38', 0, NULL, 'HOME', NULL),
(2120, 'accesed home page', '2015-08-24 19:50:14', 0, NULL, 'HOME', NULL),
(2121, 'accesed home page', '2015-08-24 19:50:41', 0, NULL, 'HOME', NULL),
(2122, 'accesed home page', '2015-08-24 19:52:44', 0, NULL, 'HOME', NULL),
(2123, 'login attempt', '2015-08-24 19:53:08', 0, NULL, 'MEMBER_LOGIN', NULL),
(2124, 'accesed home page', '2015-08-24 19:53:21', 0, NULL, 'HOME', NULL),
(2125, 'accesed home page', '2015-08-24 19:53:59', 0, NULL, 'HOME', NULL),
(2126, 'accesed home page', '2015-08-24 19:55:19', 0, NULL, 'HOME', NULL),
(2127, 'accesed home page', '2015-08-24 19:55:32', 0, NULL, 'HOME', NULL),
(2128, 'accesed home page', '2015-08-24 19:55:52', 0, NULL, 'HOME', NULL),
(2129, 'accesed home page', '2015-08-24 19:56:25', 0, NULL, 'HOME', NULL),
(2130, 'accesed home page', '2015-08-24 19:57:01', 0, NULL, 'HOME', NULL),
(2131, 'accesed home page', '2015-08-24 19:57:08', 0, NULL, 'HOME', NULL),
(2132, 'accesed home page', '2015-08-24 19:57:31', 0, NULL, 'HOME', NULL),
(2133, 'accesed home page', '2015-08-24 19:57:45', 0, NULL, 'HOME', NULL),
(2134, 'accesed home page', '2015-08-24 20:01:09', 0, NULL, 'HOME', NULL),
(2135, 'login attempt', '2015-08-24 20:01:11', 0, NULL, 'MEMBER_LOGIN', NULL),
(2136, 'accesed home page', '2015-08-24 20:01:23', 0, NULL, 'HOME', NULL),
(2137, 'accesed home page', '2015-08-24 20:25:16', 0, NULL, 'HOME', NULL),
(2138, 'accesed home page', '2015-08-24 20:26:20', 0, NULL, 'HOME', NULL),
(2139, 'accesed annuity quotation page', '2015-08-24 20:30:26', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2140, 'accesed annuity quotation page', '2015-08-24 20:32:28', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2141, 'accesed annuity quotation page', '2015-08-24 20:39:32', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2142, 'accesed interest rates page', '2015-08-24 20:39:52', 0, NULL, 'INTEREST_RATES', NULL),
(2143, 'accesed what if analysis page', '2015-08-24 20:39:57', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2144, 'accesed contact us page', '2015-08-24 20:39:59', 0, NULL, 'CONTACT_US', NULL),
(2145, 'accesed what if analysis page', '2015-08-24 20:45:14', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2146, 'accesed annuity quotation page', '2015-08-24 20:45:18', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2147, 'accesed what if analysis page', '2015-08-24 20:45:20', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2148, 'accesed what if analysis page', '2015-08-24 20:45:32', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2149, 'accesed annuity quotation page', '2015-08-24 20:46:24', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2150, 'accesed interest rates page', '2015-08-24 20:46:35', 0, NULL, 'INTEREST_RATES', NULL),
(2151, 'accesed home page', '2015-08-24 20:46:54', 0, NULL, 'HOME', NULL),
(2152, 'accesed registration page', '2015-08-24 20:48:24', 0, NULL, 'REGISTRATION', NULL),
(2153, 'accesed home page', '2015-08-24 20:48:48', 0, NULL, 'HOME', NULL),
(2154, 'accesed contact us page', '2015-08-24 20:49:42', 0, NULL, 'CONTACT_US', NULL),
(2155, 'accesed what if analysis page', '2015-08-24 20:50:04', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2156, 'accesed home page', '2015-08-25 05:32:24', 0, NULL, 'HOME', NULL),
(2157, 'accesed registration page', '2015-08-25 05:32:36', 0, NULL, 'REGISTRATION', NULL),
(2158, 'accesed registration page', '2015-08-25 05:33:43', 0, NULL, 'REGISTRATION', NULL),
(2159, 'accesed registration page', '2015-08-25 05:34:48', 0, NULL, 'REGISTRATION', NULL),
(2160, 'accesed registration page', '2015-08-25 05:35:22', 0, NULL, 'REGISTRATION', NULL),
(2161, 'accesed registration page', '2015-08-25 05:35:30', 0, NULL, 'REGISTRATION', NULL),
(2162, 'accesed registration page', '2015-08-25 05:36:05', 0, NULL, 'REGISTRATION', NULL),
(2163, 'accesed registration page', '2015-08-25 05:36:25', 0, NULL, 'REGISTRATION', NULL),
(2164, 'accesed registration page', '2015-08-25 05:37:16', 0, NULL, 'REGISTRATION', NULL),
(2165, 'accesed registration page', '2015-08-25 07:06:04', 0, NULL, 'REGISTRATION', NULL),
(2166, 'accesed home page', '2015-08-25 07:06:47', 0, NULL, 'HOME', NULL),
(2167, 'accesed home page', '2015-08-25 07:14:43', 0, NULL, 'HOME', NULL),
(2168, 'accesed home page', '2015-08-25 07:24:26', 0, NULL, 'HOME', NULL),
(2169, 'accesed registration page', '2015-08-25 07:24:29', 0, NULL, 'REGISTRATION', NULL),
(2170, 'accesed registration page', '2015-08-25 07:25:59', 0, NULL, 'REGISTRATION', NULL),
(2171, 'accesed home page', '2015-08-25 07:26:38', 0, NULL, 'HOME', NULL),
(2172, 'accesed home page', '2015-08-25 07:27:31', 0, NULL, 'HOME', NULL),
(2173, 'accesed home page', '2015-08-25 07:27:50', 0, NULL, 'HOME', NULL),
(2174, 'accesed home page', '2015-08-25 07:28:35', 0, NULL, 'HOME', NULL),
(2175, 'accesed home page', '2015-08-25 07:29:31', 0, NULL, 'HOME', NULL),
(2176, 'accesed home page', '2015-08-25 07:29:50', 0, NULL, 'HOME', NULL),
(2177, 'accesed home page', '2015-08-25 07:30:15', 0, NULL, 'HOME', NULL),
(2178, 'accesed home page', '2015-08-25 07:30:35', 0, NULL, 'HOME', NULL),
(2179, 'accesed home page', '2015-08-25 07:30:46', 0, NULL, 'HOME', NULL),
(2180, 'accesed home page', '2015-08-25 07:31:10', 0, NULL, 'HOME', NULL),
(2181, 'accesed home page', '2015-08-25 07:31:16', 0, NULL, 'SIGNIN', NULL),
(2182, 'accesed home page', '2015-08-25 07:32:06', 0, NULL, 'SIGNIN', NULL),
(2183, 'accesed home page', '2015-08-25 07:32:12', 0, NULL, 'HOME', NULL),
(2184, 'accesed home page', '2015-08-25 07:32:29', 0, NULL, 'SIGNIN', NULL),
(2185, 'accesed home page', '2015-08-25 07:33:48', 0, NULL, 'HOME', NULL),
(2186, 'login attempt', '2015-08-25 07:34:19', 0, NULL, 'MEMBER_LOGIN', NULL),
(2187, 'accesed registration page', '2015-08-25 07:34:22', 0, NULL, 'REGISTRATION', NULL),
(2188, 'accesed registration page', '2015-08-25 07:34:52', 0, NULL, 'REGISTRATION', NULL),
(2189, 'accesed registration page', '2015-08-25 07:35:18', 0, NULL, 'REGISTRATION', NULL),
(2190, 'accesed registration page', '2015-08-25 07:37:29', 0, NULL, 'REGISTRATION', NULL),
(2191, 'accesed registration page', '2015-08-25 07:37:33', 0, NULL, 'REGISTRATION', NULL),
(2192, 'accesed registration page', '2015-08-25 07:37:51', 0, NULL, 'REGISTRATION', NULL),
(2193, 'accesed home page', '2015-08-25 07:48:35', 0, NULL, 'HOME', NULL),
(2194, 'accesed home page', '2015-08-25 07:48:45', 0, NULL, 'HOME', NULL),
(2195, 'successfully logged in', '2015-08-25 07:50:07', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2196, 'successfully logged in', '2015-08-25 08:23:55', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2197, 'login attempt', '2015-08-25 08:26:52', 0, NULL, 'ADMIN_LOGIN', NULL),
(2198, 'successfully logged in', '2015-08-25 08:26:57', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2199, 'accesed annuity quotation page', '2015-08-25 08:34:59', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2200, 'accesed annuity quotation page', '2015-08-25 08:50:08', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2201, 'successfully logged in', '2015-08-25 09:14:59', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2202, 'Viewed email contact categories', '2015-08-25 09:16:01', 60, '1277', 'PORTAL MEMBERS', 'ADMINISTRATOR'),
(2203, 'successfully logged in', '2015-08-25 09:21:52', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2204, 'Viewed email contact categories', '2015-08-25 09:22:01', 60, '1277', 'PORTAL MEMBERS', 'ADMINISTRATOR'),
(2205, 'successfully logged in', '2015-08-25 09:24:01', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2206, 'Viewed email contact categories', '2015-08-25 09:24:07', 60, '1277', 'PORTAL MEMBERS', 'ADMINISTRATOR'),
(2207, 'successfully logged in', '2015-08-25 09:27:28', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2208, 'Viewed email contact categories', '2015-08-25 09:27:33', 60, '1277', 'PORTAL MEMBERS', 'ADMINISTRATOR'),
(2209, 'successfully logged in', '2015-08-25 09:29:55', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2210, 'Viewed email contact categories', '2015-08-25 09:30:16', 60, '1277', 'PORTAL MEMBERS', 'ADMINISTRATOR'),
(2211, 'Accessed setup menu and details', '2015-08-25 09:32:11', 60, '1277', 'SETUP', 'ADMINISTRATOR'),
(2212, 'Viewed email contact categories', '2015-08-25 09:49:36', 60, '1277', 'PORTAL MEMBERS', 'ADMINISTRATOR'),
(2213, 'successfully logged in', '2015-08-25 09:52:51', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2214, 'successfully logged in', '2015-08-25 10:12:01', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2215, 'successfully logged in', '2015-08-25 10:25:21', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2216, 'successfully logged in', '2015-08-25 10:26:03', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2217, 'successfully logged in', '2015-08-25 10:26:51', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2218, 'successfully logged in', '2015-08-25 10:51:07', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2219, 'successfully logged in', '2015-08-25 10:55:55', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2220, 'successfully logged in', '2015-08-25 11:13:41', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR');
INSERT INTO `tbl_activity_logs` (`id`, `description`, `datetime`, `user_id`, `scheme`, `access_menu`, `userProfile`) VALUES
(2221, 'successfully logged in', '2015-08-25 11:18:13', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2222, 'successfully logged in', '2015-08-25 11:19:01', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2223, 'successfully logged in', '2015-08-25 11:19:53', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2224, 'successfully logged in', '2015-08-25 11:22:36', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2225, 'successfully logged in', '2015-08-25 11:30:37', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2226, 'successfully logged in', '2015-08-25 11:31:59', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2227, 'Viewed email contact categories', '2015-08-25 11:33:25', 60, '1277', 'PORTAL MEMBERS', 'ADMINISTRATOR'),
(2228, 'Viewed email contact categories', '2015-08-25 11:33:33', 60, '1277', 'PORTAL MEMBERS', 'ADMINISTRATOR'),
(2229, 'successfully logged in', '2015-08-25 11:35:27', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2230, 'successfully logged in', '2015-08-25 12:02:51', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2231, 'successfully logged in', '2015-08-25 12:04:12', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2232, 'successfully logged in', '2015-08-25 12:05:04', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2233, 'successfully logged in', '2015-08-25 12:05:46', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2234, 'successfully logged in', '2015-08-25 12:07:44', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2235, 'successfully logged in', '2015-08-25 12:08:27', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2236, 'successfully logged in', '2015-08-25 12:09:20', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2237, 'accesed home page', '2015-08-25 12:09:59', 0, NULL, 'HOME', NULL),
(2238, 'accesed registration page', '2015-08-25 12:10:03', 0, NULL, 'REGISTRATION', NULL),
(2239, 'successfully logged in', '2015-08-25 12:11:29', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2240, 'successfully logged in', '2015-08-25 12:15:28', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2241, 'successfully logged in', '2015-08-25 12:16:00', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2242, 'successfully logged in', '2015-08-25 12:17:43', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2243, 'successfully logged in', '2015-08-25 12:24:15', 60, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2244, 'accesed registration page', '2015-08-25 12:44:20', 0, NULL, 'REGISTRATION', NULL),
(2245, 'login attempt', '2015-08-25 12:54:30', 0, NULL, 'ADMIN_LOGIN', NULL),
(2246, 'accesed home page', '2015-08-25 12:54:39', 0, NULL, 'HOME', NULL),
(2247, 'accesed home page', '2015-08-25 12:56:24', 0, NULL, 'HOME', NULL),
(2248, 'accesed home page', '2015-08-25 12:56:30', 0, NULL, 'HOME', NULL),
(2249, 'accesed registration page', '2015-08-25 12:56:47', 0, NULL, 'REGISTRATION', NULL),
(2250, 'accesed registration page', '2015-08-25 12:59:55', 0, NULL, 'REGISTRATION', NULL),
(2251, 'accesed what if analysis page', '2015-08-25 13:00:09', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2252, 'accesed interest rates page', '2015-08-25 13:00:11', 0, NULL, 'INTEREST_RATES', NULL),
(2253, 'accesed home page', '2015-08-25 13:00:13', 0, NULL, 'HOME', NULL),
(2254, 'accesed contact us page', '2015-08-25 13:00:39', 0, NULL, 'CONTACT_US', NULL),
(2255, 'accesed registration page', '2015-08-25 13:00:58', 0, NULL, 'REGISTRATION', NULL),
(2256, 'accesed home page', '2015-08-25 13:04:29', 0, NULL, 'SIGNIN', NULL),
(2257, 'accesed home page', '2015-08-25 13:08:33', 0, NULL, 'SIGNIN', NULL),
(2258, 'accesed home page', '2015-08-25 13:08:37', 0, NULL, 'SIGNIN', NULL),
(2259, 'accesed home page', '2015-08-25 13:09:25', 0, NULL, 'SIGNIN', NULL),
(2260, 'accesed home page', '2015-08-25 13:09:26', 0, NULL, 'SIGNIN', NULL),
(2261, 'accesed home page', '2015-08-25 13:10:26', 0, NULL, 'SIGNIN', NULL),
(2262, 'accesed contact us page', '2015-08-25 13:10:39', 0, NULL, 'CONTACT_US', NULL),
(2263, 'accesed registration page', '2015-08-25 13:10:54', 0, NULL, 'REGISTRATION', NULL),
(2264, 'accesed registration page', '2015-08-25 13:19:29', 0, NULL, 'REGISTRATION', NULL),
(2265, 'accesed registration page', '2015-08-25 13:20:24', 0, NULL, 'REGISTRATION', NULL),
(2266, 'accesed registration page', '2015-08-25 13:22:01', 0, NULL, 'REGISTRATION', NULL),
(2267, 'accesed registration page', '2015-08-25 13:25:55', 0, NULL, 'REGISTRATION', NULL),
(2268, 'accesed registration page', '2015-08-25 13:26:09', 0, NULL, 'REGISTRATION', NULL),
(2269, 'accesed registration page', '2015-08-25 13:32:46', 0, NULL, 'REGISTRATION', NULL),
(2270, 'accesed registration page', '2015-08-25 13:33:35', 0, NULL, 'REGISTRATION', NULL),
(2271, 'accesed registration page', '2015-08-25 13:36:18', 0, NULL, 'REGISTRATION', NULL),
(2272, 'accesed registration page', '2015-08-25 13:38:10', 0, NULL, 'REGISTRATION', NULL),
(2273, 'accesed registration page', '2015-08-25 13:40:06', 0, NULL, 'REGISTRATION', NULL),
(2274, 'accesed registration page', '2015-08-25 13:40:30', 0, NULL, 'REGISTRATION', NULL),
(2275, 'accesed registration page', '2015-08-25 13:40:52', 0, NULL, 'REGISTRATION', NULL),
(2276, 'accesed registration page', '2015-08-25 13:41:21', 0, NULL, 'REGISTRATION', NULL),
(2277, 'accesed registration page', '2015-08-25 13:41:46', 0, NULL, 'REGISTRATION', NULL),
(2278, 'accesed registration page', '2015-08-25 13:42:44', 0, NULL, 'REGISTRATION', NULL),
(2279, 'accesed registration page', '2015-08-25 13:44:38', 0, NULL, 'REGISTRATION', NULL),
(2280, 'accesed registration page', '2015-08-25 13:46:14', 0, NULL, 'REGISTRATION', NULL),
(2281, 'accesed registration page', '2015-08-25 13:47:05', 0, NULL, 'REGISTRATION', NULL),
(2282, 'accesed registration page', '2015-08-25 13:48:27', 0, NULL, 'REGISTRATION', NULL),
(2283, 'accesed registration page', '2015-08-25 13:50:08', 0, NULL, 'REGISTRATION', NULL),
(2284, 'accesed registration page', '2015-08-25 13:51:14', 0, NULL, 'REGISTRATION', NULL),
(2285, 'accesed registration page', '2015-08-25 13:51:52', 0, NULL, 'REGISTRATION', NULL),
(2286, 'accesed registration page', '2015-08-25 13:52:07', 0, NULL, 'REGISTRATION', NULL),
(2287, 'accesed registration page', '2015-08-25 13:55:56', 0, NULL, 'REGISTRATION', NULL),
(2288, 'accesed registration page', '2015-08-25 14:00:49', 0, NULL, 'REGISTRATION', NULL),
(2289, 'accesed registration page', '2015-08-25 14:03:32', 0, NULL, 'REGISTRATION', NULL),
(2290, 'accesed registration page', '2015-08-25 14:03:57', 0, NULL, 'REGISTRATION', NULL),
(2291, 'accesed registration page', '2015-08-25 14:04:45', 0, NULL, 'REGISTRATION', NULL),
(2292, 'accesed registration page', '2015-08-25 14:09:48', 0, NULL, 'REGISTRATION', NULL),
(2293, 'accesed registration page', '2015-08-25 14:12:13', 0, NULL, 'REGISTRATION', NULL),
(2294, 'accesed registration page', '2015-08-25 14:14:55', 0, NULL, 'REGISTRATION', NULL),
(2295, 'accesed registration page', '2015-08-25 14:17:47', 0, NULL, 'REGISTRATION', NULL),
(2296, 'accesed registration page', '2015-08-25 14:18:00', 0, NULL, 'REGISTRATION', NULL),
(2297, 'accesed registration page', '2015-08-25 14:25:38', 0, NULL, 'REGISTRATION', NULL),
(2298, 'accesed registration page', '2015-08-25 14:32:24', 0, NULL, 'REGISTRATION', NULL),
(2299, 'accesed home page', '2015-08-25 22:34:13', 0, NULL, 'HOME', NULL),
(2300, 'accesed registration page', '2015-08-25 22:40:40', 0, NULL, 'REGISTRATION', NULL),
(2301, 'accesed home page', '2015-08-27 12:35:22', 0, NULL, 'SIGNIN', NULL),
(2302, 'accesed registration page', '2015-08-27 12:35:41', 0, NULL, 'REGISTRATION', NULL),
(2303, 'login attempt', '2015-08-27 12:36:56', 0, NULL, 'ADMIN_LOGIN', NULL),
(2304, 'accesed registration page', '2015-08-27 12:37:36', 0, NULL, 'REGISTRATION', NULL),
(2305, 'accesed registration page', '2015-08-27 12:38:19', 0, NULL, 'REGISTRATION', NULL),
(2306, 'accesed registration page', '2015-08-27 12:42:54', 0, NULL, 'REGISTRATION', NULL),
(2307, 'accesed annuity quotation page', '2015-08-27 12:56:38', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2308, 'accesed registration page', '2015-08-31 07:20:58', 0, NULL, 'REGISTRATION', NULL),
(2309, 'accesed what if analysis page', '2015-08-31 07:21:23', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2310, 'accesed annuity quotation page', '2015-08-31 07:21:26', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2311, 'accesed interest rates page', '2015-08-31 09:03:47', 0, NULL, 'INTEREST_RATES', NULL),
(2312, 'accesed what if analysis page', '2015-08-31 09:12:10', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2313, 'accesed contact us page', '2015-08-31 09:12:14', 0, NULL, 'CONTACT_US', NULL),
(2314, 'accesed registration page', '2015-08-31 10:06:24', 0, NULL, 'REGISTRATION', NULL),
(2315, 'accesed annuity quotation page', '2015-08-31 10:06:42', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2316, 'login attempt', '2015-08-31 10:07:11', 0, NULL, 'ADMIN_LOGIN', NULL),
(2317, 'login attempt', '2015-08-31 10:08:43', 0, NULL, 'ADMIN_LOGIN', NULL),
(2318, 'accesed home page', '2015-08-31 10:09:13', 0, NULL, 'HOME', NULL),
(2319, 'accesed registration page', '2015-08-31 10:09:27', 0, NULL, 'REGISTRATION', NULL),
(2320, 'successfully logged in', '2015-08-31 10:11:48', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2321, 'successfully logged in', '2015-08-31 10:15:40', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2322, 'successfully logged in', '2015-08-31 10:18:02', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2323, 'successfully logged in', '2015-08-31 11:27:46', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2324, 'successfully logged in', '2015-08-31 11:28:58', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2325, 'Viewed members for scheme #242', '2015-08-31 11:33:27', 66, '242', 'MEMBERS', 'ADMINISTRATOR'),
(2326, 'accesed registration page', '2015-09-01 09:44:47', 0, NULL, 'REGISTRATION', NULL),
(2327, 'accesed registration page', '2015-09-01 09:50:12', 0, NULL, 'REGISTRATION', NULL),
(2328, 'accesed registration page', '2015-09-01 10:06:10', 0, NULL, 'REGISTRATION', NULL),
(2329, 'accesed registration page', '2015-09-01 10:13:45', 0, NULL, 'REGISTRATION', NULL),
(2330, 'accesed registration page', '2015-09-01 10:15:24', 0, NULL, 'REGISTRATION', NULL),
(2331, 'accesed home page', '2015-09-01 10:15:40', 0, NULL, 'SIGNIN', NULL),
(2332, 'accesed registration page', '2015-09-01 10:17:27', 0, NULL, 'REGISTRATION', NULL),
(2333, 'accesed registration page', '2015-09-01 10:22:04', 0, NULL, 'REGISTRATION', NULL),
(2334, 'accesed registration page', '2015-09-01 11:04:18', 0, NULL, 'REGISTRATION', NULL),
(2335, 'accesed registration page', '2015-09-02 07:32:38', 0, NULL, 'REGISTRATION', NULL),
(2336, 'accesed registration page', '2015-09-02 07:33:41', 0, NULL, 'REGISTRATION', NULL),
(2337, 'accesed home page', '2015-09-02 07:33:51', 0, NULL, 'HOME', NULL),
(2338, 'accesed home page', '2015-09-02 07:35:19', 0, NULL, 'HOME', NULL),
(2339, 'accesed home page', '2015-09-02 07:35:24', 0, NULL, 'HOME', NULL),
(2340, 'accesed home page', '2015-09-02 07:35:25', 0, NULL, 'HOME', NULL),
(2341, 'accesed home page', '2015-09-02 07:35:26', 0, NULL, 'HOME', NULL),
(2342, 'accesed home page', '2015-09-02 07:35:29', 0, NULL, 'HOME', NULL),
(2343, 'accesed home page', '2015-09-02 07:35:52', 0, NULL, 'HOME', NULL),
(2344, 'accesed what if analysis page', '2015-09-02 07:35:54', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2345, 'accesed interest rates page', '2015-09-02 07:35:57', 0, NULL, 'INTEREST_RATES', NULL),
(2346, 'accesed annuity quotation page', '2015-09-02 07:35:58', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2347, 'accesed interest rates page', '2015-09-02 07:36:00', 0, NULL, 'INTEREST_RATES', NULL),
(2348, 'accesed home page', '2015-09-02 07:36:12', 0, NULL, 'HOME', NULL),
(2349, 'accesed home page', '2015-09-02 07:37:01', 0, NULL, 'HOME', NULL),
(2350, 'accesed home page', '2015-09-02 07:37:04', 0, NULL, 'HOME', NULL),
(2351, 'accesed registration page', '2015-09-02 12:24:21', 0, NULL, 'REGISTRATION', NULL),
(2352, 'accesed registration page', '2015-09-02 12:27:28', 0, NULL, 'REGISTRATION', NULL),
(2353, 'accesed registration page', '2015-09-02 12:44:18', 0, NULL, 'REGISTRATION', NULL),
(2354, 'accesed registration page', '2015-09-02 12:44:21', 0, NULL, 'REGISTRATION', NULL),
(2355, 'accesed registration page', '2015-09-02 12:46:59', 0, NULL, 'REGISTRATION', NULL),
(2356, 'accesed registration page', '2015-09-02 12:46:59', 0, NULL, 'REGISTRATION', NULL),
(2357, 'accesed registration page', '2015-09-02 12:47:45', 0, NULL, 'REGISTRATION', NULL),
(2358, 'accesed registration page', '2015-09-02 12:51:34', 0, NULL, 'REGISTRATION', NULL),
(2359, 'accesed registration page', '2015-09-02 12:55:33', 0, NULL, 'REGISTRATION', NULL),
(2360, 'accesed home page', '2015-09-02 12:56:03', 0, NULL, 'SIGNIN', NULL),
(2361, 'accesed interest rates page', '2015-09-02 12:58:14', 0, NULL, 'INTEREST_RATES', NULL),
(2362, 'accesed home page', '2015-09-02 12:58:49', 0, NULL, 'SIGNIN', NULL),
(2363, 'accesed home page', '2015-09-02 12:59:14', 0, NULL, 'SIGN_IN', NULL),
(2364, 'accesed home page', '2015-09-02 12:59:21', 0, NULL, 'SIGN_IN', NULL),
(2365, 'accesed registration page', '2015-09-02 13:00:11', 0, NULL, 'REGISTRATION', NULL),
(2366, 'accesed home page', '2015-09-04 16:51:28', 0, NULL, 'HOME', NULL),
(2367, 'accesed registration page', '2015-09-04 16:51:34', 0, NULL, 'REGISTRATION', NULL),
(2368, 'accesed home page', '2015-09-06 17:16:23', 0, NULL, 'HOME', NULL),
(2369, 'accesed home page', '2015-09-06 19:21:07', 0, NULL, 'HOME', NULL),
(2370, 'accesed registration page', '2015-09-06 19:22:04', 0, NULL, 'REGISTRATION', NULL),
(2371, 'accesed annuity quotation page', '2015-09-06 19:32:39', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2372, 'accesed home page', '2015-09-06 19:49:19', 0, NULL, 'HOME', NULL),
(2373, 'accesed annuity quotation page', '2015-09-06 20:10:08', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2374, 'accesed home page', '2015-09-06 20:10:19', 0, NULL, 'HOME', NULL),
(2375, 'accesed home page', '2015-09-06 20:43:17', 0, NULL, 'HOME', NULL),
(2376, 'accesed home page', '2015-09-06 20:55:44', 0, NULL, 'HOME', NULL),
(2377, 'accesed home page', '2015-09-06 20:56:02', 0, NULL, 'HOME', NULL),
(2378, 'accesed interest rates page', '2015-09-06 20:56:06', 0, NULL, 'INTEREST_RATES', NULL),
(2379, 'accesed registration page', '2015-09-06 20:56:15', 0, NULL, 'REGISTRATION', NULL),
(2380, 'accesed home page', '2015-09-07 11:11:53', 0, NULL, 'HOME', NULL),
(2381, 'accesed home page', '2015-09-07 19:37:19', 0, NULL, 'HOME', NULL),
(2382, 'accesed registration page', '2015-09-07 19:37:24', 0, NULL, 'REGISTRATION', NULL),
(2383, 'accesed contact us page', '2015-09-07 19:38:04', 0, NULL, 'CONTACT_US', NULL),
(2384, 'accesed home page', '2015-09-07 19:38:05', 0, NULL, 'HOME', NULL),
(2385, 'accesed registration page', '2015-09-07 19:38:18', 0, NULL, 'REGISTRATION', NULL),
(2386, 'accesed home page', '2015-09-07 19:44:48', 0, NULL, 'HOME', NULL),
(2387, 'accesed registration page', '2015-09-07 19:44:51', 0, NULL, 'REGISTRATION', NULL),
(2388, 'accesed registration page', '2015-09-07 19:45:25', 0, NULL, 'REGISTRATION', NULL),
(2389, 'accesed registration page', '2015-09-07 19:45:35', 0, NULL, 'REGISTRATION', NULL),
(2390, 'accesed interest rates page', '2015-09-07 19:45:43', 0, NULL, 'INTEREST_RATES', NULL),
(2391, 'accesed home page', '2015-09-07 19:45:47', 0, NULL, 'HOME', NULL),
(2392, 'accesed registration page', '2015-09-07 19:45:50', 0, NULL, 'REGISTRATION', NULL),
(2393, 'accesed registration page', '2015-09-07 19:51:38', 0, NULL, 'REGISTRATION', NULL),
(2394, 'accesed registration page', '2015-09-07 19:52:02', 0, NULL, 'REGISTRATION', NULL),
(2395, 'accesed registration page', '2015-09-07 19:53:12', 0, NULL, 'REGISTRATION', NULL),
(2396, 'accesed registration page', '2015-09-07 19:53:24', 0, NULL, 'REGISTRATION', NULL),
(2397, 'accesed home page', '2015-09-07 20:29:40', 0, NULL, 'HOME', NULL),
(2398, 'accesed home page', '2015-09-07 20:30:09', 0, NULL, 'HOME', NULL),
(2399, 'accesed home page', '2015-09-07 20:30:53', 0, NULL, 'HOME', NULL),
(2400, 'accesed home page', '2015-09-07 20:42:21', 0, NULL, 'HOME', NULL),
(2401, 'accesed home page', '2015-09-07 20:42:31', 0, NULL, 'HOME', NULL),
(2402, 'accesed registration page', '2015-09-07 20:42:48', 0, NULL, 'REGISTRATION', NULL),
(2403, 'accesed what if analysis page', '2015-09-07 20:43:00', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2404, 'accesed what if analysis page', '2015-09-07 20:49:04', 0, NULL, 'WHAT_IF_ANALYSIS', NULL),
(2405, 'accesed registration page', '2015-09-07 20:49:19', 0, NULL, 'REGISTRATION', NULL),
(2406, 'accesed registration page', '2015-09-07 20:49:56', 0, NULL, 'REGISTRATION', NULL),
(2407, 'accesed registration page', '2015-09-07 20:50:22', 0, NULL, 'REGISTRATION', NULL),
(2408, 'accesed registration page', '2015-09-07 20:53:52', 0, NULL, 'REGISTRATION', NULL),
(2409, 'accesed registration page', '2015-09-07 20:56:09', 0, NULL, 'REGISTRATION', NULL),
(2410, 'accesed home page', '2015-09-07 20:58:29', 0, NULL, 'SIGN_IN', NULL),
(2411, 'successfully logged in', '2015-09-07 20:58:46', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2412, 'Accessed User Access Control Panel', '2015-09-07 20:59:21', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2413, 'accesed home page', '2015-09-07 21:00:16', 0, NULL, 'HOME', NULL),
(2414, 'accesed home page', '2015-09-07 21:00:21', 0, NULL, 'SIGN_IN', NULL),
(2415, 'accesed home page', '2015-09-07 21:00:49', 0, NULL, 'SIGN_IN', NULL),
(2416, 'accesed interest rates page', '2015-09-07 21:03:05', 0, NULL, 'INTEREST_RATES', NULL),
(2417, 'accesed home page', '2015-09-07 21:03:57', 0, NULL, 'HOME', NULL),
(2418, 'accesed home page', '2015-09-07 21:04:26', 0, NULL, 'SIGN_IN', NULL),
(2419, 'accesed home page', '2015-09-07 21:04:30', 0, NULL, 'SIGN_IN', NULL),
(2420, 'accesed home page', '2015-09-07 21:04:42', 0, NULL, 'HOME', NULL),
(2421, 'accesed home page', '2015-09-07 21:05:02', 0, NULL, 'HOME', NULL),
(2422, 'accesed home page', '2015-09-07 21:05:15', 0, NULL, 'HOME', NULL),
(2423, 'accesed interest rates page', '2015-09-07 21:05:30', 0, NULL, 'INTEREST_RATES', NULL),
(2424, 'accesed registration page', '2015-09-07 21:05:44', 0, NULL, 'REGISTRATION', NULL),
(2425, 'accesed registration page', '2015-09-07 21:05:44', 0, NULL, 'REGISTRATION', NULL),
(2426, 'accesed annuity quotation page', '2015-09-07 21:12:31', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2427, 'accesed registration page', '2015-09-07 21:12:51', 0, NULL, 'REGISTRATION', NULL),
(2428, 'accesed home page', '2015-09-07 21:13:01', 0, NULL, 'HOME', NULL),
(2429, 'accesed annuity quotation page', '2015-09-07 21:13:05', 0, NULL, 'ANNUITY_QUOTATION', NULL),
(2430, 'accesed interest rates page', '2015-09-07 21:13:06', 0, NULL, 'INTEREST_RATES', NULL),
(2431, 'accesed interest rates page', '2015-09-07 21:14:47', 0, NULL, 'INTEREST_RATES', NULL),
(2432, 'successfully logged in', '2015-09-07 21:15:06', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2433, 'Accessed User Access Control Panel', '2015-09-07 21:15:17', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2434, 'successfully logged in', '2015-09-07 21:17:54', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2435, 'Accessed User Access Control Panel', '2015-09-07 21:17:59', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2436, 'Viewed Scheme Managers', '2015-09-07 21:18:06', 66, '242', 'SCHEME MANAGERS', 'ADMINISTRATOR'),
(2437, 'Viewed portal users', '2015-09-07 21:18:10', 66, '242', 'USERS', 'ADMINISTRATOR'),
(2438, 'Viewed members for scheme #242', '2015-09-07 21:18:40', 66, '242', 'MEMBERS', 'ADMINISTRATOR'),
(2439, 'successfully logged in', '2015-09-08 01:54:58', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2440, 'Accessed User Access Control Panel', '2015-09-08 01:55:02', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2441, 'successfully logged in', '2015-09-08 01:56:24', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2442, 'Accessed User Access Control Panel', '2015-09-08 01:56:35', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2443, 'successfully logged in', '2015-09-08 01:58:27', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2444, 'Accessed User Access Control Panel', '2015-09-08 01:58:30', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2445, 'accesed home page', '2015-09-08 01:59:17', 0, NULL, 'HOME', NULL),
(2446, 'login attempt', '2015-09-08 01:59:32', 0, NULL, 'ADMIN_LOGIN', NULL),
(2447, 'successfully logged in', '2015-09-08 01:59:39', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2448, 'Accessed User Access Control Panel', '2015-09-08 02:00:38', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2449, 'Accessed User Access Control Panel', '2015-09-08 02:05:12', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2450, 'successfully logged in', '2015-09-08 02:07:16', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2451, 'Accessed User Access Control Panel', '2015-09-08 02:07:19', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2452, 'successfully logged in', '2015-09-08 02:11:00', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2453, 'Accessed User Access Control Panel', '2015-09-08 02:11:03', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2454, 'accesed registration page', '2015-09-08 02:16:25', 0, NULL, 'REGISTRATION', NULL),
(2455, 'accesed registration page', '2015-09-08 02:17:37', 0, NULL, 'REGISTRATION', NULL),
(2456, 'accesed registration page', '2015-09-08 02:20:03', 0, NULL, 'REGISTRATION', NULL),
(2457, 'accesed registration page', '2015-09-08 02:20:54', 0, NULL, 'REGISTRATION', NULL),
(2458, 'accesed registration page', '2015-09-08 02:21:02', 0, NULL, 'REGISTRATION', NULL),
(2459, 'accesed registration page', '2015-09-08 02:21:10', 0, NULL, 'REGISTRATION', NULL),
(2460, 'accesed registration page', '2015-09-08 02:21:55', 0, NULL, 'REGISTRATION', NULL),
(2461, 'accesed registration page', '2015-09-08 02:23:22', 0, NULL, 'REGISTRATION', NULL),
(2462, 'accesed registration page', '2015-09-08 02:23:39', 0, NULL, 'REGISTRATION', NULL),
(2463, 'successfully logged in', '2015-09-08 02:27:53', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2464, 'Viewed members for scheme #281', '2015-09-08 02:29:16', 66, '281', 'MEMBERS', 'ADMINISTRATOR'),
(2465, 'Accessed User Access Control Panel', '2015-09-08 02:29:49', 66, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2466, 'Viewed portal users', '2015-09-08 02:29:53', 66, '281', 'USERS', 'ADMINISTRATOR'),
(2467, 'Accessed User Access Control Panel', '2015-09-08 02:31:04', 66, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2468, 'Viewed portal users', '2015-09-08 02:31:59', 66, '281', 'USERS', 'ADMINISTRATOR'),
(2469, 'Accessed media & files (documents)', '2015-09-08 02:38:22', 66, '281', 'MEDIA & FILES', 'ADMINISTRATOR'),
(2470, 'Accessed administrative member operations', '2015-09-08 02:38:26', 66, '281', 'MEMBER OPERATIONS', 'ADMINISTRATOR'),
(2471, 'Accessed User Access Control Panel', '2015-09-08 02:38:34', 66, '281', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2472, 'Accessed portal analytics & reporting', '2015-09-08 02:38:36', 66, '281', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2473, 'successfully logged in', '2015-09-08 02:45:54', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2474, 'Accessed portal analytics & reporting', '2015-09-08 02:45:57', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2475, 'Accessed user access reports', '2015-09-08 02:45:59', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2476, 'Accessed User Access Control Panel', '2015-09-08 02:48:35', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2477, 'Viewed portal users', '2015-09-08 02:48:39', 66, '242', 'USERS', 'ADMINISTRATOR'),
(2478, 'Accessed portal analytics & reporting', '2015-09-08 02:50:22', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2479, 'successfully logged in', '2015-09-08 02:59:56', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2480, 'Accessed User Access Control Panel', '2015-09-08 03:00:02', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2481, 'Accessed portal analytics & reporting', '2015-09-08 03:00:22', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2482, 'Accessed user access reports', '2015-09-08 03:00:24', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2483, 'Accessed User Access Control Panel', '2015-09-08 03:01:25', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2484, 'Accessed portal analytics & reporting', '2015-09-08 03:01:27', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2485, 'Accessed user access reports', '2015-09-08 03:01:30', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2486, 'successfully logged in', '2015-09-08 03:02:32', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2487, 'Accessed portal analytics & reporting', '2015-09-08 03:02:36', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2488, 'Accessed user access reports', '2015-09-08 03:02:38', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2489, 'successfully logged in', '2015-09-08 03:07:36', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2490, 'Accessed portal analytics & reporting', '2015-09-08 03:07:44', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2491, 'Accessed portal analytics & reporting', '2015-09-08 03:07:47', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2492, 'Accessed portal analytics & reporting', '2015-09-08 03:07:50', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2493, 'Accessed portal analytics & reporting', '2015-09-08 03:07:53', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2494, 'Accessed user access reports', '2015-09-08 03:07:54', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2495, 'successfully logged in', '2015-09-08 03:08:49', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2496, 'Accessed portal analytics & reporting', '2015-09-08 03:08:53', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2497, 'Accessed user access reports', '2015-09-08 03:08:54', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2498, 'successfully logged in', '2015-09-08 03:22:18', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2499, 'Accessed portal analytics & reporting', '2015-09-08 03:22:21', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2500, 'Accessed user access reports', '2015-09-08 03:22:23', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2501, 'Accessed portal analytics & reporting', '2015-09-08 03:23:33', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2502, 'Accessed user access reports', '2015-09-08 03:23:35', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2503, 'successfully logged in', '2015-09-08 03:27:42', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2504, 'Accessed User Access Control Panel', '2015-09-08 03:27:45', 66, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2505, 'Accessed portal analytics & reporting', '2015-09-08 03:27:46', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2506, 'Accessed user access reports', '2015-09-08 03:27:48', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2507, 'successfully logged in', '2015-09-08 03:31:07', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2508, 'Accessed portal analytics & reporting', '2015-09-08 03:31:10', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2509, 'Accessed user access reports', '2015-09-08 03:31:12', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2510, 'successfully logged in', '2015-09-08 03:33:00', 66, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2511, 'Accessed portal analytics & reporting', '2015-09-08 03:33:03', 66, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2512, 'Accessed user access reports', '2015-09-08 03:33:04', 66, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2513, 'accesed registration page', '2015-09-08 09:09:41', 0, NULL, 'REGISTRATION', NULL),
(2514, 'accesed registration page', '2015-09-08 09:10:20', 0, NULL, 'REGISTRATION', NULL),
(2515, 'accesed registration page', '2015-09-08 09:10:23', 0, NULL, 'REGISTRATION', NULL),
(2516, 'accesed registration page', '2015-09-08 09:16:52', 0, NULL, 'REGISTRATION', NULL),
(2517, 'accesed registration page', '2015-09-08 09:18:26', 0, NULL, 'REGISTRATION', NULL),
(2518, 'login attempt', '2015-09-08 10:04:05', 0, NULL, 'ADMIN_LOGIN', NULL),
(2519, 'login attempt', '2015-09-08 10:05:05', 0, NULL, 'ADMIN_LOGIN', NULL),
(2520, 'accesed home page', '2015-09-08 10:07:40', 0, NULL, 'SIGN_IN', NULL),
(2521, 'login attempt', '2015-09-08 10:07:45', 0, NULL, 'MEMBER_LOGIN', NULL),
(2522, 'login attempt', '2015-09-08 10:11:51', 0, NULL, 'MEMBER_LOGIN', NULL),
(2523, 'login attempt', '2015-09-08 10:12:00', 0, NULL, 'MEMBER_LOGIN', NULL),
(2524, 'login attempt', '2015-09-08 10:12:03', 0, NULL, 'MEMBER_LOGIN', NULL),
(2525, 'login attempt', '2015-09-08 10:12:05', 0, NULL, 'MEMBER_LOGIN', NULL),
(2526, 'login attempt', '2015-09-08 10:12:08', 0, NULL, 'MEMBER_LOGIN', NULL),
(2527, 'login attempt', '2015-09-08 10:12:29', 0, NULL, 'MEMBER_LOGIN', NULL),
(2528, 'accesed home page', '2015-09-08 10:13:14', 0, NULL, 'SIGN_IN', NULL),
(2529, 'login attempt', '2015-09-08 10:13:19', 0, NULL, 'MEMBER_LOGIN', NULL),
(2530, 'login attempt', '2015-09-08 10:13:55', 0, NULL, 'MEMBER_LOGIN', NULL),
(2531, 'accesed home page', '2015-09-08 10:14:33', 0, NULL, 'SIGN_IN', NULL),
(2532, 'login attempt', '2015-09-08 10:14:39', 0, NULL, 'MEMBER_LOGIN', NULL),
(2533, 'login attempt', '2015-09-08 10:14:52', 0, NULL, 'MEMBER_LOGIN', NULL),
(2534, 'login attempt', '2015-09-08 10:15:01', 0, NULL, 'MEMBER_LOGIN', NULL),
(2535, 'login attempt', '2015-09-08 10:15:10', 0, NULL, 'MEMBER_LOGIN', NULL),
(2536, 'login attempt', '2015-09-08 10:15:17', 0, NULL, 'MEMBER_LOGIN', NULL),
(2537, 'login attempt', '2015-09-08 10:16:11', 0, NULL, 'MEMBER_LOGIN', NULL),
(2538, 'accesed home page', '2015-09-08 10:16:48', 0, NULL, 'SIGN_IN', NULL),
(2539, 'login attempt', '2015-09-08 10:16:50', 0, NULL, 'MEMBER_LOGIN', NULL),
(2540, 'accesed registration page', '2015-09-08 10:45:06', 0, NULL, 'REGISTRATION', NULL),
(2541, 'accesed registration page', '2015-09-08 10:48:03', 0, NULL, 'REGISTRATION', NULL),
(2542, 'accesed registration page', '2015-09-08 10:51:11', 0, NULL, 'REGISTRATION', NULL),
(2543, 'accesed registration page', '2015-09-08 10:56:24', 0, NULL, 'REGISTRATION', NULL),
(2544, 'accesed registration page', '2015-09-08 11:10:56', 0, NULL, 'REGISTRATION', NULL),
(2545, 'accesed home page', '2015-09-08 11:38:32', 0, NULL, 'HOME', NULL),
(2546, 'accesed registration page', '2015-09-08 11:39:53', 0, NULL, 'REGISTRATION', NULL),
(2547, 'accesed registration page', '2015-09-08 11:40:18', 0, NULL, 'REGISTRATION', NULL),
(2548, 'accesed registration page', '2015-09-08 11:41:26', 0, NULL, 'REGISTRATION', NULL),
(2549, 'accesed registration page', '2015-09-08 11:41:34', 0, NULL, 'REGISTRATION', NULL),
(2550, 'accesed registration page', '2015-09-08 11:46:26', 0, NULL, 'REGISTRATION', NULL),
(2551, 'accesed registration page', '2015-09-08 11:48:06', 0, NULL, 'REGISTRATION', NULL),
(2552, 'accesed registration page', '2015-09-08 11:48:51', 0, NULL, 'REGISTRATION', NULL),
(2553, 'accesed registration page', '2015-09-08 11:51:34', 0, NULL, 'REGISTRATION', NULL),
(2554, 'accesed registration page', '2015-09-08 11:51:44', 0, NULL, 'REGISTRATION', NULL),
(2555, 'accesed registration page', '2015-09-08 11:53:40', 0, NULL, 'REGISTRATION', NULL),
(2556, 'accesed registration page', '2015-09-08 11:54:15', 0, NULL, 'REGISTRATION', NULL),
(2557, 'accesed registration page', '2015-09-08 11:54:55', 0, NULL, 'REGISTRATION', NULL),
(2558, 'accesed registration page', '2015-09-08 12:00:32', 0, NULL, 'REGISTRATION', NULL),
(2559, 'accesed registration page', '2015-09-08 12:02:04', 0, NULL, 'REGISTRATION', NULL),
(2560, 'accesed registration page', '2015-09-08 12:02:57', 0, NULL, 'REGISTRATION', NULL),
(2561, 'accesed registration page', '2015-09-08 12:03:51', 0, NULL, 'REGISTRATION', NULL),
(2562, 'accesed registration page', '2015-09-08 12:10:39', 0, NULL, 'REGISTRATION', NULL),
(2563, 'accesed registration page', '2015-09-08 12:10:47', 0, NULL, 'REGISTRATION', NULL),
(2564, 'accesed registration page', '2015-09-08 13:37:05', 0, NULL, 'REGISTRATION', NULL),
(2565, 'accesed registration page', '2015-09-08 13:38:37', 0, NULL, 'REGISTRATION', NULL),
(2566, 'accesed registration page', '2015-09-08 13:38:48', 0, NULL, 'REGISTRATION', NULL),
(2567, 'accesed registration page', '2015-09-08 13:44:56', 0, NULL, 'REGISTRATION', NULL),
(2568, 'accesed registration page', '2015-09-08 13:45:51', 0, NULL, 'REGISTRATION', NULL),
(2569, 'accesed registration page', '2015-09-08 13:47:09', 0, NULL, 'REGISTRATION', NULL),
(2570, 'accesed registration page', '2015-09-08 13:49:20', 0, NULL, 'REGISTRATION', NULL),
(2571, 'accesed registration page', '2015-09-08 13:49:50', 0, NULL, 'REGISTRATION', NULL),
(2572, 'accesed registration page', '2015-09-08 13:52:01', 0, NULL, 'REGISTRATION', NULL),
(2573, 'accesed registration page', '2015-09-08 14:02:31', 0, NULL, 'REGISTRATION', NULL),
(2574, 'accesed registration page', '2015-09-08 14:09:11', 0, NULL, 'REGISTRATION', NULL),
(2575, 'successfully logged in', '2015-09-08 14:12:22', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2576, 'Accessed User Access Control Panel', '2015-09-08 14:12:27', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2577, 'Accessed User Access Control Panel', '2015-09-08 14:13:06', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2578, 'successfully logged in', '2015-09-08 14:18:41', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2579, 'Accessed User Access Control Panel', '2015-09-08 14:18:45', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2580, 'successfully logged in', '2015-09-08 14:19:48', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2581, 'Accessed User Access Control Panel', '2015-09-08 14:19:52', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2582, 'successfully logged in', '2015-09-08 14:20:37', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2583, 'Accessed User Access Control Panel', '2015-09-08 14:20:39', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2584, 'successfully logged in', '2015-09-08 14:21:30', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2585, 'Accessed User Access Control Panel', '2015-09-08 14:21:33', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2586, 'successfully logged in', '2015-09-08 14:22:53', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2587, 'Accessed User Access Control Panel', '2015-09-08 14:22:57', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2588, 'Accessed User Access Control Panel', '2015-09-08 14:23:21', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2589, 'successfully logged in', '2015-09-08 14:25:52', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2590, 'Accessed User Access Control Panel', '2015-09-08 14:25:55', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2591, 'successfully logged in', '2015-09-08 14:27:04', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2592, 'Accessed User Access Control Panel', '2015-09-08 14:27:07', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2593, 'successfully logged in', '2015-09-08 14:35:27', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2594, 'Accessed User Access Control Panel', '2015-09-08 14:35:30', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2595, 'successfully logged in', '2015-09-08 14:37:00', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2596, 'Accessed User Access Control Panel', '2015-09-08 14:37:05', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2597, 'successfully logged in', '2015-09-08 14:38:08', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2598, 'Accessed User Access Control Panel', '2015-09-08 14:38:11', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2599, 'successfully logged in', '2015-09-08 14:45:13', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2600, 'Accessed User Access Control Panel', '2015-09-08 14:45:16', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2601, 'Accessed User Access Control Panel', '2015-09-08 14:45:28', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2602, 'Accessed User Access Control Panel', '2015-09-08 14:45:35', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2603, 'Accessed User Access Control Panel', '2015-09-08 14:47:09', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2604, 'successfully logged in', '2015-09-08 14:49:04', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2605, 'Accessed User Access Control Panel', '2015-09-08 14:49:07', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2606, 'Accessed User Access Control Panel', '2015-09-08 14:49:48', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2607, 'successfully logged in', '2015-09-08 14:50:36', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2608, 'Accessed User Access Control Panel', '2015-09-08 14:50:42', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2609, 'login attempt', '2015-09-08 14:53:47', 0, NULL, 'ADMIN_LOGIN', NULL),
(2610, 'successfully logged in', '2015-09-08 14:53:53', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2611, 'Accessed User Access Control Panel', '2015-09-08 14:53:56', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2612, 'accesed home page', '2015-09-08 17:56:45', 0, NULL, 'HOME', NULL),
(2613, 'successfully logged in', '2015-09-08 17:57:04', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2614, 'Accessed User Access Control Panel', '2015-09-08 17:57:21', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2615, 'Viewed portal users', '2015-09-08 17:57:57', 81, '242', 'USERS', 'ADMINISTRATOR'),
(2616, 'Accessed portal analytics & reporting', '2015-09-08 17:58:00', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2617, 'Accessed user access reports', '2015-09-08 17:58:02', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2618, 'Accessed portal analytics & reporting', '2015-09-08 18:00:48', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2619, 'Accessed user access reports', '2015-09-08 18:00:50', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2620, 'successfully logged in', '2015-09-09 06:09:30', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2621, 'Accessed portal analytics & reporting', '2015-09-09 06:09:37', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2622, 'Accessed user access reports', '2015-09-09 06:09:39', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2623, 'successfully logged in', '2015-09-09 06:10:00', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2624, 'Accessed User Access Control Panel', '2015-09-09 06:10:06', 81, '242', 'USER ACCESS CONTROL', 'ADMINISTRATOR'),
(2625, 'Accessed portal analytics & reporting', '2015-09-09 06:10:09', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2626, 'Accessed user access reports', '2015-09-09 06:10:11', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2627, 'successfully logged in', '2015-09-09 06:31:31', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2628, 'Accessed portal analytics & reporting', '2015-09-09 06:31:34', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2629, 'Accessed user access reports', '2015-09-09 06:31:36', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2630, 'Accessed portal analytics & reporting', '2015-09-09 06:31:43', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2631, 'Accessed user access reports', '2015-09-09 06:31:45', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2632, 'successfully logged in', '2015-09-09 06:33:45', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2633, 'Accessed portal analytics & reporting', '2015-09-09 06:33:48', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2634, 'Accessed user access reports', '2015-09-09 06:33:50', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2635, 'successfully logged in', '2015-09-09 06:34:16', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2636, 'Accessed portal analytics & reporting', '2015-09-09 06:34:19', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2637, 'Accessed user access reports', '2015-09-09 06:34:20', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR'),
(2638, 'successfully logged in', '2015-09-09 06:34:47', 81, NULL, 'ADMIN_LOGIN', 'ADMINISTRATOR'),
(2639, 'Accessed portal analytics & reporting', '2015-09-09 06:34:50', 81, '242', 'PORTAL ANALYTICS', 'ADMINISTRATOR'),
(2640, 'Accessed user access reports', '2015-09-09 06:34:52', 81, '242', 'USER ACCESS REPORTS', 'ADMINISTRATOR');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_audit_trails`
--

DROP TABLE IF EXISTS `tbl_audit_trails`;
CREATE TABLE IF NOT EXISTS `tbl_audit_trails` (
`id` bigint(20) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=732 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_audit_trails`
--

INSERT INTO `tbl_audit_trails` (`id`, `datetime`, `description`, `profile`, `username`, `version`) VALUES
(1, '2015-08-14 00:00:00', 'ASDFSDAF', 'ASDFASD', 'ASDFASDF', 1),
(2, '2015-08-14 04:29:36', 'asdfsad', 'asdf', 'asdf', NULL),
(3, '2015-08-14 05:12:44', 'Updated member edit permissions', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(4, '2015-08-14 05:13:09', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(5, '2015-08-14 05:13:43', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(6, '2015-08-14 05:27:45', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(7, '2015-08-14 05:30:50', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(8, '2015-08-14 05:34:46', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(9, '2015-08-14 05:41:26', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(10, '2015-08-14 05:44:43', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(11, '2015-08-14 05:48:26', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(12, '2015-08-14 06:03:04', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(13, '2015-08-14 06:04:15', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(14, '2015-08-14 06:06:51', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(15, '2015-08-14 06:09:16', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(16, '2015-08-14 06:11:45', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(17, '2015-08-14 08:24:44', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(18, '2015-08-14 08:25:28', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(19, '2015-08-14 08:30:13', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(20, '2015-08-14 08:32:40', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(21, '2015-08-14 08:34:24', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(22, '2015-08-14 08:54:59', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(23, '2015-08-14 09:05:07', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(24, '2015-08-14 09:14:28', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(25, '2015-08-14 09:17:22', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(26, '2015-08-14 09:20:19', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(27, '2015-08-14 09:25:43', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(28, '2015-08-14 09:27:49', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(29, '2015-08-14 09:27:58', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(30, '2015-08-14 09:31:06', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(31, '2015-08-14 09:33:46', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(32, '2015-08-14 09:36:10', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(33, '2015-08-14 10:05:27', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(34, '2015-08-14 10:05:38', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(35, '2015-08-14 11:13:33', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(36, '2015-08-14 11:32:17', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(37, '2015-08-14 12:00:17', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(38, '2015-08-14 12:06:11', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(39, '2015-08-14 12:08:58', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(40, '2015-08-14 12:09:34', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(41, '2015-08-14 12:17:11', 'Updated company details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(42, '2015-08-14 12:21:02', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(43, '2015-08-14 13:20:21', 'Changed password', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(44, '2015-08-14 13:42:48', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(45, '2015-08-14 13:43:04', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(46, '2015-08-14 14:30:17', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(47, '2015-08-14 14:40:42', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(48, '2015-08-14 14:41:52', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(49, '2015-08-14 14:44:33', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(50, '2015-08-14 14:57:02', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(51, '2015-08-14 15:00:22', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(52, '2015-08-14 15:01:40', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(53, '2015-08-14 15:01:48', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(54, '2015-08-14 15:03:41', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(55, '2015-08-14 15:04:53', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(56, '2015-08-14 15:27:23', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(57, '2015-08-14 15:29:03', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(58, '2015-08-14 15:29:50', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(59, '2015-08-14 15:42:55', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(60, '2015-08-14 15:43:03', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(61, '2015-08-14 15:54:11', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(62, '2015-08-14 15:54:28', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(63, '2015-08-14 16:02:58', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(64, '2015-08-14 16:13:11', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(65, '2015-08-14 16:20:28', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(66, '2015-08-14 16:21:58', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(67, '2015-08-14 16:48:09', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(68, '2015-08-14 16:48:20', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(69, '2015-08-14 16:50:47', 'Updated portal theme settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(70, '2015-08-14 16:53:54', 'Searched receipts for range between 31-08-2015 and 02-09-2015', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(71, '2015-08-14 16:54:30', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(72, '2015-08-14 16:58:24', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(73, '2015-08-14 16:58:38', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(74, '2015-08-14 17:18:24', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(75, '2015-08-14 17:23:06', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(76, '2015-08-14 17:25:26', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(77, '2015-08-14 17:50:55', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(78, '2015-08-14 18:02:22', 'Switched between schemes from scheme #1277 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(79, '2015-08-14 18:02:32', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(80, '2015-08-14 18:07:05', 'Changed password', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(81, '2015-08-14 18:10:06', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(82, '2015-08-14 18:11:16', 'Accessed editable view for member Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(83, '2015-08-14 18:13:44', 'Accessed editable view for member Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(84, '2015-08-14 18:14:15', 'Searched members with search parameter Joseph', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(85, '2015-08-14 18:14:46', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(86, '2015-08-14 18:14:59', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(87, '2015-08-14 18:18:23', 'Searched members with search parameter BAR', 'MEMBER', 't.mukoba@gmail.com', 0),
(88, '2015-08-14 18:19:30', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(89, '2015-08-14 18:25:26', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(90, '2015-08-14 18:26:24', 'Uploaded portal logo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(91, '2015-08-14 18:27:53', 'Uploaded portal logo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(92, '2015-08-14 18:29:14', 'Updated portal page content for page SIGN_IN', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(93, '2015-08-17 02:48:33', 'Uploaded portal logo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(94, '2015-08-17 02:57:35', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(95, '2015-08-17 02:57:48', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(96, '2015-08-17 03:29:17', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(97, '2015-08-17 03:29:28', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(98, '2015-08-17 03:29:39', 'Switched between schemes from scheme #281 to scheme #1182761', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(99, '2015-08-17 03:30:14', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(100, '2015-08-17 03:31:12', 'De-linked scheme manager #Mr. Ranyondo Mboya Opot', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(101, '2015-08-17 03:36:45', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(102, '2015-08-17 03:36:55', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(103, '2015-08-17 03:46:03', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(104, '2015-08-17 03:46:14', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(105, '2015-08-17 03:48:39', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(106, '2015-08-17 03:49:45', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(107, '2015-08-17 03:52:48', 'Switched between schemes from scheme #242 to scheme #1182761', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(108, '2015-08-17 03:53:22', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(109, '2015-08-17 03:55:07', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(110, '2015-08-17 03:55:17', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(111, '2015-08-17 04:01:59', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(112, '2015-08-17 04:02:09', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(113, '2015-08-17 04:07:11', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(114, '2015-08-17 04:07:23', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(115, '2015-08-17 04:08:45', 'Searched schemes with parameter dc', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(116, '2015-08-17 04:09:08', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(117, '2015-08-17 04:09:19', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(118, '2015-08-17 04:09:51', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(119, '2015-08-17 04:10:37', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(120, '2015-08-17 04:12:22', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(121, '2015-08-17 04:12:32', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(122, '2015-08-17 04:12:46', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(123, '2015-08-17 04:13:28', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(124, '2015-08-17 04:13:38', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(125, '2015-08-17 04:13:53', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(126, '2015-08-17 04:13:57', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(127, '2015-08-17 04:15:12', 'Accessed editable view for member Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(128, '2015-08-17 04:15:25', 'Accessed editable view for member Mr. Amboko Alex Kuya', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(129, '2015-08-17 04:15:37', 'Accessed editable view for member Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(130, '2015-08-17 04:17:17', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(131, '2015-08-17 04:20:26', 'Changed password', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(132, '2015-08-17 04:20:59', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(133, '2015-08-17 04:21:16', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(134, '2015-08-17 04:26:47', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(135, '2015-08-17 04:28:30', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(136, '2015-08-17 04:48:48', 'Added a new contact category Personal Details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(137, '2015-08-17 04:48:54', 'Added a new contact category Personal Detailsdd', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(138, '2015-08-17 04:54:28', 'Added a new contact category Contributions', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(139, '2015-08-17 06:48:13', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(140, '2015-08-17 06:49:13', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(141, '2015-08-17 06:55:49', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(142, '2015-08-17 06:57:59', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(143, '2015-08-17 06:59:38', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(144, '2015-08-17 06:59:48', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(145, '2015-08-17 07:56:59', 'Updated portal help content for page SIGN_IN', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(146, '2015-08-17 07:59:55', 'Updated portal help content for page SIGN_IN', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(147, '2015-08-17 08:12:24', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(148, '2015-08-17 08:12:35', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(149, '2015-08-17 11:56:08', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(150, '2015-08-17 12:03:12', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(151, '2015-08-17 12:03:52', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(152, '2015-08-17 12:04:54', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(153, '2015-08-17 12:06:26', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(154, '2015-08-17 12:09:51', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(155, '2015-08-17 12:13:31', 'Accessed scheme member listing', 'MEMBER', 't.mukoba@gmail.com', 0),
(156, '2015-08-17 12:15:37', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(157, '2015-08-17 12:27:22', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(158, '2015-08-17 12:27:34', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(159, '2015-08-17 13:03:07', 'Updated portal help content for page SIGN_IN', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(160, '2015-08-17 13:03:39', 'Updated portal help content for page LOGIN', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(161, '2015-08-17 13:08:13', 'Updated portal page content for page HOME', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(162, '2015-08-17 13:08:28', 'Updated portal page content for page SIGN_IN', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(163, '2015-08-17 13:25:00', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(164, '2015-08-17 13:25:11', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(165, '2015-08-17 13:28:13', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(166, '2015-08-17 14:25:06', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(167, '2015-08-17 14:40:59', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(168, '2015-08-17 14:41:10', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(169, '2015-08-17 14:43:06', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(170, '2015-08-17 14:54:10', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(171, '2015-08-17 14:54:21', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(172, '2015-08-17 15:04:44', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(173, '2015-08-17 15:47:35', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(174, '2015-08-17 15:47:45', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(175, '2015-08-17 15:49:18', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(176, '2015-08-17 15:51:28', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(177, '2015-08-17 16:24:18', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(178, '2015-08-17 16:29:39', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(179, '2015-08-17 16:37:39', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(180, '2015-08-17 16:37:44', 'Searched members with search parameter 4', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(181, '2015-08-17 16:37:49', 'Searched members with search parameter A', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(182, '2015-08-17 16:39:47', 'Updated portal page content for page LOGIN', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(183, '2015-08-17 16:47:18', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(184, '2015-08-17 16:57:22', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(185, '2015-08-17 17:01:45', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(186, '2015-08-17 17:01:56', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(187, '2015-08-17 18:15:10', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(188, '2015-08-17 18:15:21', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(189, '2015-08-17 18:22:39', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(190, '2015-08-17 18:27:49', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(191, '2015-08-17 18:47:40', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(192, '2015-08-17 18:47:53', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(193, '2015-08-17 18:49:14', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(194, '2015-08-17 18:49:23', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(195, '2015-08-17 20:59:41', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(196, '2015-08-17 20:59:57', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(197, '2015-08-17 21:01:30', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(198, '2015-08-17 21:01:45', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(199, '2015-08-17 21:02:44', 'Viewed member details for member #Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(200, '2015-08-17 21:04:27', 'Accessed editable view for member Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(201, '2015-08-17 21:07:59', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(202, '2015-08-17 21:08:12', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(203, '2015-08-17 21:09:53', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(204, '2015-08-17 21:10:07', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(205, '2015-08-17 21:28:59', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(206, '2015-08-17 21:33:51', 'Updated a contact category Claims', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(207, '2015-08-17 21:34:19', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(208, '2015-08-18 03:51:08', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(209, '2015-08-18 03:51:12', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(210, '2015-08-18 03:51:22', 'Switched between schemes from scheme #242 to scheme #1182761', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(211, '2015-08-18 03:51:41', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(212, '2015-08-18 03:51:51', 'Switched between schemes from scheme #242 to scheme #1182761', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(213, '2015-08-18 03:52:12', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(214, '2015-08-18 03:52:54', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(215, '2015-08-18 03:54:08', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(216, '2015-08-18 03:57:49', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(217, '2015-08-18 03:58:29', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(218, '2015-08-18 03:58:42', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(219, '2015-08-18 04:07:50', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(220, '2015-08-18 04:08:01', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(221, '2015-08-18 04:19:25', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(222, '2015-08-18 04:19:37', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(223, '2015-08-18 04:28:57', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(224, '2015-08-18 04:29:08', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(225, '2015-08-18 04:41:04', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(226, '2015-08-18 04:41:15', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(227, '2015-08-18 04:43:30', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(228, '2015-08-18 04:43:41', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(229, '2015-08-18 04:45:17', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(230, '2015-08-18 04:45:29', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(231, '2015-08-18 04:47:52', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(232, '2015-08-18 04:48:03', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(233, '2015-08-18 04:50:48', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(234, '2015-08-18 04:50:59', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(235, '2015-08-18 04:56:10', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(236, '2015-08-18 04:56:21', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(237, '2015-08-18 04:58:10', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(238, '2015-08-18 04:58:21', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(239, '2015-08-18 05:03:55', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(240, '2015-08-18 05:04:06', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(241, '2015-08-18 05:05:40', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(242, '2015-08-18 05:05:51', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(243, '2015-08-18 05:08:39', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(244, '2015-08-18 05:08:49', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(245, '2015-08-18 05:21:03', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(246, '2015-08-18 05:21:14', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(247, '2015-08-18 05:22:42', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(248, '2015-08-18 05:22:53', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(249, '2015-08-18 05:24:37', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(250, '2015-08-18 05:24:48', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(251, '2015-08-18 05:36:12', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(252, '2015-08-18 05:37:25', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(253, '2015-08-18 05:37:36', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(254, '2015-08-18 05:38:14', 'Searched payments for range between 28-07-2015 and 27-08-2015', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(255, '2015-08-18 05:38:22', 'Searched payments for range between 01-12-2014 and 27-08-2015', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(256, '2015-08-18 05:50:38', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(257, '2015-08-18 05:50:48', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(258, '2015-08-18 07:35:14', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(259, '2015-08-18 07:35:15', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(260, '2015-08-18 07:38:58', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(261, '2015-08-18 07:38:58', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(262, '2015-08-18 07:41:42', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(263, '2015-08-18 07:41:43', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(264, '2015-08-18 07:45:09', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(265, '2015-08-18 07:45:11', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(266, '2015-08-18 07:46:22', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(267, '2015-08-18 07:46:23', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(268, '2015-08-18 07:49:26', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(269, '2015-08-18 07:51:31', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(270, '2015-08-18 07:51:58', 'Switched between schemes from scheme #281 to scheme #1182761', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(271, '2015-08-18 07:51:59', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(272, '2015-08-18 07:57:24', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(273, '2015-08-18 07:57:35', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(274, '2015-08-18 08:08:23', 'Searched payments for range between 28-07-2015 and 03-08-2015', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(275, '2015-08-18 08:12:53', 'Accessed editable view for member Mr. Karuma Francis Gichiri', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(276, '2015-08-18 08:13:53', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(277, '2015-08-18 08:14:59', 'Switched between schemes from scheme #1182761 to scheme #1182761', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(278, '2015-08-18 08:15:00', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(279, '2015-08-18 08:15:08', 'Switched between schemes from scheme #1182761 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(280, '2015-08-18 08:15:09', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(281, '2015-08-18 08:15:24', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(282, '2015-08-18 08:22:05', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(283, '2015-08-18 08:22:07', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(284, '2015-08-18 08:23:46', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(285, '2015-08-18 08:23:46', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(286, '2015-08-18 08:24:36', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(287, '2015-08-18 08:24:41', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(288, '2015-08-18 08:28:49', 'Searched payments for range between 27-07-2015 and 12-08-2015', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(289, '2015-08-18 08:28:56', 'Searched payments for range between 26-01-2015 and 12-08-2015', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(290, '2015-08-18 08:51:59', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(291, '2015-08-18 08:52:00', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(292, '2015-08-18 08:53:34', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(293, '2015-08-18 08:53:34', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(294, '2015-08-18 08:56:00', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(295, '2015-08-18 08:56:00', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(296, '2015-08-18 08:57:11', 'Switched between schemes from scheme #242 to scheme #1182761', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(297, '2015-08-18 08:57:12', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(298, '2015-08-18 09:11:59', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(299, '2015-08-18 09:12:09', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(300, '2015-08-18 09:12:10', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(301, '2015-08-18 09:13:52', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(302, '2015-08-18 09:13:53', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(303, '2015-08-18 09:17:51', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(304, '2015-08-18 09:19:36', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(305, '2015-08-18 09:19:38', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(306, '2015-08-18 09:25:44', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(307, '2015-08-18 09:27:28', 'Searched members with search parameter 5617500108', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(308, '2015-08-18 09:27:30', 'Searched members with search parameter 5617500108', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(309, '2015-08-18 09:27:31', 'Searched members with search parameter 5617500108', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(310, '2015-08-18 09:27:45', 'Searched members with search parameter 5617500108', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(311, '2015-08-18 09:29:23', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(312, '2015-08-18 09:29:27', 'Searched members with search parameter a', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(313, '2015-08-18 09:30:35', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(314, '2015-08-18 09:30:36', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(315, '2015-08-18 09:31:13', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(316, '2015-08-18 09:32:36', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(317, '2015-08-18 09:33:00', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(318, '2015-08-18 09:33:16', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(319, '2015-08-18 09:33:17', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(320, '2015-08-18 09:33:57', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(321, '2015-08-18 09:52:52', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(322, '2015-08-18 09:52:53', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(323, '2015-08-18 09:54:04', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(324, '2015-08-18 09:54:05', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(325, '2015-08-18 09:59:44', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(326, '2015-08-18 09:59:45', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(327, '2015-08-18 10:01:58', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(328, '2015-08-18 10:01:59', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(329, '2015-08-18 10:03:27', 'Viewed member details for member #Mrs. Mjomba Savia Mwahe', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(330, '2015-08-18 10:05:22', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(331, '2015-08-18 10:05:23', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(332, '2015-08-18 10:05:50', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(333, '2015-08-18 10:06:39', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(334, '2015-08-18 10:06:40', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(335, '2015-08-18 10:06:55', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(336, '2015-08-18 10:08:20', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(337, '2015-08-18 10:12:38', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(338, '2015-08-18 10:12:39', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(339, '2015-08-18 10:44:03', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(340, '2015-08-18 10:44:04', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(341, '2015-08-18 10:44:41', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(342, '2015-08-18 10:45:32', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(343, '2015-08-18 10:45:33', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(344, '2015-08-18 10:45:38', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(345, '2015-08-18 12:20:39', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(346, '2015-08-18 12:20:40', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(347, '2015-08-18 12:21:07', 'Viewed scheme payments for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(348, '2015-08-18 12:21:27', 'Viewed members for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(349, '2015-08-18 12:21:39', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(350, '2015-08-18 13:02:29', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(351, '2015-08-18 13:03:39', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(352, '2015-08-18 13:04:58', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(353, '2015-08-18 13:05:44', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(354, '2015-08-18 13:11:25', 'Logged out of the portal', 'MEMBER', 't.mukoba@gmail.com', 0),
(355, '2015-08-18 13:23:44', 'Viewed  editable  member personal information', 'MEMBER', 'lance@systech.co.ke', 0),
(356, '2015-08-18 13:24:27', 'Viewed member contribution history', 'MEMBER', 'lance@systech.co.ke', 0),
(357, '2015-08-18 13:25:02', 'Viewed member balances history', 'MEMBER', 'lance@systech.co.ke', 0),
(358, '2015-08-18 13:25:21', 'Viewed member statement of account', 'MEMBER', 'lance@systech.co.ke', 0),
(359, '2015-08-18 13:26:26', 'Logged out of the portal', 'MEMBER', 'lance@systech.co.ke', 0),
(360, '2015-08-18 13:26:46', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(361, '2015-08-18 13:26:47', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(362, '2015-08-18 13:29:14', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(363, '2015-08-18 13:31:50', 'Updated portal social network settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(364, '2015-08-18 13:33:03', 'Updated portal theme settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(365, '2015-08-18 13:34:52', 'Viewed email contact categories', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(366, '2015-08-18 13:35:37', 'Accessed media & files (documents)', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(367, '2015-08-18 13:35:51', 'Accessed help content', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(368, '2015-08-18 13:37:39', 'Accessed page content', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(369, '2015-08-18 13:37:53', 'Updated portal page content for page INTEREST_RATES', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(370, '2015-08-18 13:37:58', 'Viewed Schemes', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(371, '2015-08-18 13:38:12', 'Viewed scheme receipts for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(372, '2015-08-18 13:39:39', 'Viewed scheme payments for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(373, '2015-08-18 13:40:08', 'Viewed scheme payments for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(374, '2015-08-18 13:42:01', 'Viewed members for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(375, '2015-08-18 13:42:41', 'Accessed editable view for member Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(376, '2015-08-18 13:43:46', 'Viewed member details for member #Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(377, '2015-08-18 13:43:51', 'Accessed administrative member operations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(378, '2015-08-18 13:44:12', 'Searched members with search parameter BAR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(379, '2015-08-18 13:44:23', 'Viewed  editable  member personal information', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(380, '2015-08-18 13:44:28', 'Viewed member contribution history', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(381, '2015-08-18 13:45:10', 'Accessed media & files (documents)', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(382, '2015-08-18 13:45:16', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(383, '2015-08-18 13:45:52', 'Viewed Scheme Managers', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(384, '2015-08-18 14:00:13', 'Viewed Audit Trails', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(385, '2015-08-18 14:00:17', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(386, '2015-08-18 14:01:05', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(387, '2015-08-18 14:03:37', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(388, '2015-08-18 14:04:02', 'Viewed Schemes', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(389, '2015-08-18 14:05:15', 'Viewed scheme payments for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(390, '2015-08-18 14:06:12', 'Viewed scheme payments for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(391, '2015-08-18 15:38:26', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(392, '2015-08-18 15:38:27', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(393, '2015-08-19 09:24:08', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(394, '2015-08-19 09:28:50', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(395, '2015-08-19 09:28:50', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(396, '2015-08-19 09:29:02', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(397, '2015-08-19 09:38:33', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(398, '2015-08-19 09:38:52', 'Uploaded portal logo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(399, '2015-08-19 09:49:14', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(400, '2015-08-19 09:57:11', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(401, '2015-08-19 10:22:22', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(402, '2015-08-19 10:22:52', 'Updated other portal settings and configurations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(403, '2015-08-19 10:24:00', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(404, '2015-08-19 10:24:12', 'Updated other portal settings and configurations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(405, '2015-08-19 10:32:38', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(406, '2015-08-19 10:33:53', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(407, '2015-08-19 10:34:25', 'Updated portal theme settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(408, '2015-08-19 10:35:17', 'Updated other portal settings and configurations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(409, '2015-08-19 10:38:30', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(410, '2015-08-19 10:38:45', 'Uploaded portal logo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(411, '2015-08-19 10:39:00', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(412, '2015-08-19 10:39:22', 'Updated other portal settings and configurations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(413, '2015-08-19 10:39:25', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(414, '2015-08-19 10:40:59', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(415, '2015-08-19 10:42:15', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(416, '2015-08-19 10:42:22', 'Viewed email contact categories', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(417, '2015-08-19 10:42:36', 'Accessed help content', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(418, '2015-08-19 10:42:45', 'Viewed Schemes', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(419, '2015-08-19 10:42:50', 'Viewed scheme receipts for scheme #242', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(420, '2015-08-19 10:42:54', 'Viewed scheme payments for scheme #242', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(421, '2015-08-19 10:42:57', 'Viewed members for scheme #242', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(422, '2015-08-19 10:43:00', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(423, '2015-08-19 10:43:01', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(424, '2015-08-19 10:43:16', 'Viewed members for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(425, '2015-08-19 10:43:29', 'Accessed editable view for member Mr. Odera Joseph Omollo', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(426, '2015-08-19 10:43:51', 'Accessed help content', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(427, '2015-08-19 10:55:17', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(428, '2015-08-19 10:55:26', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(429, '2015-08-19 10:57:27', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(430, '2015-08-19 11:04:00', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(431, '2015-08-19 11:05:02', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(432, '2015-08-19 11:05:14', 'Updated other portal settings and configurations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(433, '2015-08-19 11:15:22', 'Viewed members for scheme #242', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(434, '2015-08-19 11:15:56', 'Viewed Schemes', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(435, '2015-08-19 11:16:21', 'Viewed scheme receipts for scheme #242', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(436, '2015-08-19 11:16:41', 'Viewed scheme payments for scheme #242', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(437, '2015-08-19 12:21:54', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0);
INSERT INTO `tbl_audit_trails` (`id`, `datetime`, `description`, `profile`, `username`, `version`) VALUES
(438, '2015-08-19 12:22:13', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(439, '2015-08-19 12:22:35', 'Viewed scheme payments for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(440, '2015-08-19 12:22:48', 'Viewed scheme receipts for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(441, '2015-08-19 12:22:59', 'Viewed Schemes', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(442, '2015-08-19 12:26:49', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(443, '2015-08-19 12:32:41', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(444, '2015-08-19 12:32:48', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(445, '2015-08-19 12:33:04', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(446, '2015-08-19 12:33:32', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(447, '2015-08-19 12:33:38', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(448, '2015-08-19 12:33:49', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(449, '2015-08-19 12:39:13', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(450, '2015-08-19 12:39:16', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(451, '2015-08-19 12:39:23', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(452, '2015-08-19 12:40:06', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(453, '2015-08-19 12:40:09', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(454, '2015-08-19 12:40:12', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(455, '2015-08-19 12:42:07', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(456, '2015-08-19 12:42:10', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(457, '2015-08-19 12:42:14', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(458, '2015-08-19 12:42:53', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(459, '2015-08-19 12:42:56', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(460, '2015-08-19 12:43:02', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(461, '2015-08-19 12:44:26', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(462, '2015-08-19 12:44:28', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(463, '2015-08-19 12:44:33', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(464, '2015-08-19 12:44:38', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(465, '2015-08-19 12:44:41', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(466, '2015-08-19 12:44:46', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(467, '2015-08-19 12:44:52', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(468, '2015-08-19 12:44:54', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(469, '2015-08-19 12:46:42', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(470, '2015-08-19 12:46:49', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(471, '2015-08-19 12:46:52', 'Viewed scheme payments for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(472, '2015-08-19 12:51:34', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(473, '2015-08-19 12:51:37', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(474, '2015-08-19 12:51:43', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(475, '2015-08-19 12:51:47', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(476, '2015-08-19 12:52:53', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(477, '2015-08-19 12:53:02', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(478, '2015-08-19 12:53:06', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(479, '2015-08-19 12:53:18', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(480, '2015-08-19 12:53:21', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(481, '2015-08-19 12:53:24', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(482, '2015-08-19 12:53:36', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(483, '2015-08-19 12:53:44', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(484, '2015-08-19 12:53:54', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(485, '2015-08-19 12:54:59', 'Viewed scheme payments for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(486, '2015-08-19 12:55:10', 'Viewed scheme receipts for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(487, '2015-08-19 13:02:06', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(488, '2015-08-19 13:02:12', 'Viewed scheme receipts for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(489, '2015-08-19 13:02:33', 'Viewed scheme payments for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(490, '2015-08-19 13:02:35', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(491, '2015-08-19 13:02:40', 'Viewed Schemes', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(492, '2015-08-19 13:03:43', 'Viewed Schemes', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(493, '2015-08-19 13:16:38', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(494, '2015-08-19 13:16:41', 'Viewed scheme payments for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(495, '2015-08-19 13:16:46', 'Viewed scheme receipts for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(496, '2015-08-19 13:16:49', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(497, '2015-08-19 13:16:52', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(498, '2015-08-19 13:16:55', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(499, '2015-08-19 13:16:58', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(500, '2015-08-19 13:17:01', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(501, '2015-08-19 14:49:30', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(502, '2015-08-19 14:49:38', 'Logged out of the portal', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(503, '2015-08-19 20:19:09', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(504, '2015-08-20 01:56:53', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(505, '2015-08-20 01:59:35', 'Logged out of the portal', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(506, '2015-08-20 02:42:39', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(507, '2015-08-20 02:47:30', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(508, '2015-08-20 02:50:45', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(509, '2015-08-20 02:53:08', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(510, '2015-08-20 02:53:22', 'Updated other portal settings and configurations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(511, '2015-08-20 02:53:58', 'Updated other portal settings and configurations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(512, '2015-08-20 03:01:17', 'Accessed setup menu and details', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(513, '2015-08-20 03:01:36', 'Updated other portal settings and configurations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(514, '2015-08-20 08:28:43', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(515, '2015-08-20 09:22:52', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(516, '2015-08-20 09:23:23', 'Switched between schemes from scheme #1277 to scheme #1657', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(517, '2015-08-20 10:18:33', 'Switched between schemes from scheme #242 to scheme #1224', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(518, '2015-08-20 10:18:42', 'Switched between schemes from scheme #1224 to scheme #1221', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(519, '2015-08-20 10:18:45', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(520, '2015-08-20 10:19:05', 'Switched between schemes from scheme #1221 to scheme #1277', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(521, '2015-08-20 10:19:08', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(522, '2015-08-20 10:19:12', 'Switched between schemes from scheme #1277 to scheme #1254', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(523, '2015-08-20 10:19:14', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(524, '2015-08-20 10:19:18', 'Switched between schemes from scheme #1254 to scheme #1224', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(525, '2015-08-20 11:03:14', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(526, '2015-08-20 11:03:21', 'Switched between schemes from scheme #1277 to scheme #1224', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(527, '2015-08-20 11:04:18', 'Switched between schemes from scheme #1224 to scheme #1254', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(528, '2015-08-20 11:04:20', 'Accessed scheme member listing', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(529, '2015-08-20 11:32:52', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(530, '2015-08-20 11:33:17', 'Switched between schemes from scheme #1277 to scheme #1283', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(531, '2015-08-20 11:33:19', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(532, '2015-08-20 12:15:37', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(533, '2015-08-20 12:15:56', 'Switched between schemes from scheme #1277 to scheme #1224', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(534, '2015-08-20 15:22:58', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(535, '2015-08-20 15:24:02', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(536, '2015-08-20 15:34:59', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(537, '2015-08-20 15:35:50', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(538, '2015-08-20 15:55:55', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(539, '2015-08-20 17:42:08', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(540, '2015-08-20 17:42:18', 'Switched between schemes from scheme #1277 to scheme #1267', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(541, '2015-08-20 17:42:20', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(542, '2015-08-20 18:52:58', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(543, '2015-08-20 18:53:33', 'Switched between schemes from scheme #1277 to scheme #5124276692', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(544, '2015-08-20 18:53:41', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(545, '2015-08-21 07:15:19', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(546, '2015-08-21 08:16:53', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(547, '2015-08-21 08:17:41', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(548, '2015-08-21 08:19:27', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(549, '2015-08-21 08:19:33', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(550, '2015-08-21 08:20:24', 'Updated permissions and privileges for ADMINISTRATOR', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(551, '2015-08-21 08:21:09', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(552, '2015-08-21 08:28:39', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(553, '2015-08-21 08:30:10', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(554, '2015-08-21 08:31:43', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(555, '2015-08-21 08:37:18', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(556, '2015-08-21 08:38:43', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(557, '2015-08-21 08:39:36', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(558, '2015-08-21 08:51:17', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(559, '2015-08-21 08:51:24', 'Accessed setup menu and details', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(560, '2015-08-21 08:52:16', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(561, '2015-08-21 08:52:23', 'Accessed setup menu and details', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(562, '2015-08-21 10:32:14', 'Accessed scheme member listing', 'AGENT', 'bryanitur@gmail.com', 0),
(563, '2015-08-21 10:32:24', 'Viewed Schemes', 'AGENT', 'bryanitur@gmail.com', 0),
(564, '2015-08-21 10:32:55', 'Switched between schemes from scheme #1277 to scheme #829309396', 'AGENT', 'bryanitur@gmail.com', 0),
(565, '2015-08-21 10:32:59', 'Switched between schemes from scheme #829309396 to scheme #1277', 'AGENT', 'bryanitur@gmail.com', 0),
(566, '2015-08-21 10:33:00', 'Accessed scheme member listing', 'AGENT', 'bryanitur@gmail.com', 0),
(567, '2015-08-24 11:09:00', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(568, '2015-08-24 11:28:43', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(569, '2015-08-24 11:29:07', 'Viewed members for scheme #1277', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(570, '2015-08-24 11:30:27', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(571, '2015-08-24 11:31:30', 'Viewed portal users', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(572, '2015-08-24 11:31:50', 'Updated user status for MEMBER bryanitur@gmail.com', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(573, '2015-08-24 11:31:53', 'Viewed portal users', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(574, '2015-08-25 07:50:17', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(575, '2015-08-25 08:09:47', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(576, '2015-08-25 08:23:58', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(577, '2015-08-25 08:26:57', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(578, '2015-08-25 09:15:01', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(579, '2015-08-25 09:16:01', 'Viewed member details for a potential member', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(580, '2015-08-25 09:21:54', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(581, '2015-08-25 09:22:01', 'Viewed member details for a potential member', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(582, '2015-08-25 09:24:02', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(583, '2015-08-25 09:24:07', 'Viewed member details for a potential member', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(584, '2015-08-25 09:27:29', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(585, '2015-08-25 09:27:33', 'Viewed member details for a potential member', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(586, '2015-08-25 09:28:52', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(587, '2015-08-25 09:29:57', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(588, '2015-08-25 09:30:16', 'Viewed member details for a potential member', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(589, '2015-08-25 09:32:12', 'Accessed setup menu and details', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(590, '2015-08-25 09:49:36', 'Viewed member details for a potential member', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(591, '2015-08-25 09:52:55', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(592, '2015-08-25 10:12:03', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(593, '2015-08-25 10:26:05', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(594, '2015-08-25 10:26:52', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(595, '2015-08-25 10:51:14', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(596, '2015-08-25 10:52:06', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(597, '2015-08-25 10:56:00', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(598, '2015-08-25 11:13:42', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(599, '2015-08-25 11:14:03', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(600, '2015-08-25 11:18:16', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(601, '2015-08-25 11:18:24', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(602, '2015-08-25 11:19:03', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(603, '2015-08-25 11:19:13', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(604, '2015-08-25 11:19:55', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(605, '2015-08-25 11:22:39', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(606, '2015-08-25 11:30:40', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(607, '2015-08-25 11:32:01', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(608, '2015-08-25 11:33:25', 'Viewed member details for a potential member', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(609, '2015-08-25 11:33:33', 'Viewed member details for a potential member', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(610, '2015-08-25 11:35:30', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(611, '2015-08-25 12:02:54', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(612, '2015-08-25 12:04:14', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(613, '2015-08-25 12:05:07', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(614, '2015-08-25 12:05:49', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(615, '2015-08-25 12:07:46', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(616, '2015-08-25 12:08:29', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(617, '2015-08-25 12:09:23', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(618, '2015-08-25 12:11:33', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(619, '2015-08-25 12:15:30', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(620, '2015-08-25 12:16:03', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(621, '2015-08-25 12:17:46', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(622, '2015-08-25 12:24:18', 'Accessed scheme member listing', 'ADMINISTRATOR', 'timomwa@gmail.com', 0),
(623, '2015-08-31 10:16:12', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(624, '2015-08-31 11:33:27', 'Viewed members for scheme #242', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(625, '2015-09-07 20:59:21', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(626, '2015-09-07 21:15:17', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(627, '2015-09-07 21:17:59', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(628, '2015-09-07 21:18:06', 'Viewed Scheme Managers', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(629, '2015-09-07 21:18:10', 'Viewed portal users', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(630, '2015-09-07 21:18:40', 'Viewed members for scheme #242', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(631, '2015-09-08 01:55:02', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(632, '2015-09-08 01:56:35', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(633, '2015-09-08 01:58:30', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(634, '2015-09-08 02:00:38', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(635, '2015-09-08 02:05:12', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(636, '2015-09-08 02:07:19', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(637, '2015-09-08 02:07:24', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(638, '2015-09-08 02:07:24', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(639, '2015-09-08 02:07:24', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(640, '2015-09-08 02:07:24', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(641, '2015-09-08 02:07:24', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(642, '2015-09-08 02:07:24', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(643, '2015-09-08 02:07:25', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(644, '2015-09-08 02:07:25', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(645, '2015-09-08 02:07:25', 'Updated profile login settings', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(646, '2015-09-08 02:11:03', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(647, '2015-09-08 02:27:57', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(648, '2015-09-08 02:29:16', 'Viewed members for scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(649, '2015-09-08 02:29:49', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(650, '2015-09-08 02:29:53', 'Viewed portal users', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(651, '2015-09-08 02:31:04', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(652, '2015-09-08 02:31:59', 'Viewed portal users', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(653, '2015-09-08 02:38:22', 'Accessed media & files (documents)', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(654, '2015-09-08 02:38:26', 'Accessed administrative member operations', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(655, '2015-09-08 02:38:34', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(656, '2015-09-08 02:38:36', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(657, '2015-09-08 02:45:57', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(658, '2015-09-08 02:45:59', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(659, '2015-09-08 02:48:35', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(660, '2015-09-08 02:48:39', 'Viewed portal users', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(661, '2015-09-08 02:50:22', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(662, '2015-09-08 03:00:02', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(663, '2015-09-08 03:00:22', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(664, '2015-09-08 03:00:24', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(665, '2015-09-08 03:01:24', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(666, '2015-09-08 03:01:26', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(667, '2015-09-08 03:01:29', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(668, '2015-09-08 03:02:36', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(669, '2015-09-08 03:02:37', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(670, '2015-09-08 03:07:44', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(671, '2015-09-08 03:07:46', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(672, '2015-09-08 03:07:50', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(673, '2015-09-08 03:07:52', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(674, '2015-09-08 03:07:54', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(675, '2015-09-08 03:08:52', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(676, '2015-09-08 03:08:54', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(677, '2015-09-08 03:22:21', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(678, '2015-09-08 03:22:22', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(679, '2015-09-08 03:23:33', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(680, '2015-09-08 03:23:35', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(681, '2015-09-08 03:27:44', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(682, '2015-09-08 03:27:46', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(683, '2015-09-08 03:27:48', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(684, '2015-09-08 03:31:10', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(685, '2015-09-08 03:31:11', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(686, '2015-09-08 03:33:02', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(687, '2015-09-08 03:33:04', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(688, '2015-09-08 14:12:27', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(689, '2015-09-08 14:12:54', 'Updated permissions and privileges for ADMINISTRATOR', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(690, '2015-09-08 14:13:05', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(691, '2015-09-08 14:18:45', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(692, '2015-09-08 14:19:52', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(693, '2015-09-08 14:20:39', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(694, '2015-09-08 14:21:32', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(695, '2015-09-08 14:22:56', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(696, '2015-09-08 14:23:20', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(697, '2015-09-08 14:25:55', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(698, '2015-09-08 14:27:07', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(699, '2015-09-08 14:35:30', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(700, '2015-09-08 14:37:04', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(701, '2015-09-08 14:38:11', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(702, '2015-09-08 14:45:16', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(703, '2015-09-08 14:45:27', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(704, '2015-09-08 14:45:35', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(705, '2015-09-08 14:47:09', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(706, '2015-09-08 14:49:06', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(707, '2015-09-08 14:49:48', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(708, '2015-09-08 14:50:41', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(709, '2015-09-08 14:53:55', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(710, '2015-09-08 14:57:40', 'Switched between schemes from scheme #242 to scheme #281', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(711, '2015-09-08 17:57:21', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(712, '2015-09-08 17:57:57', 'Viewed portal users', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(713, '2015-09-08 17:58:00', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(714, '2015-09-08 17:58:02', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(715, '2015-09-08 18:00:48', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(716, '2015-09-08 18:00:50', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(717, '2015-09-09 06:09:36', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(718, '2015-09-09 06:09:39', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(719, '2015-09-09 06:10:06', 'Accessed User Access Control Panel', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(720, '2015-09-09 06:10:09', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(721, '2015-09-09 06:10:11', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(722, '2015-09-09 06:31:34', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(723, '2015-09-09 06:31:36', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(724, '2015-09-09 06:31:42', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(725, '2015-09-09 06:31:45', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(726, '2015-09-09 06:33:47', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(727, '2015-09-09 06:33:49', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(728, '2015-09-09 06:34:18', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(729, '2015-09-09 06:34:20', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(730, '2015-09-09 06:34:50', 'Accessed portal analytics & reporting', 'ADMINISTRATOR', 'lance@systechafrica.com', 0),
(731, '2015-09-09 06:34:52', 'Accessed user access reports', 'ADMINISTRATOR', 'lance@systechafrica.com', 0);

--
-- Triggers `tbl_audit_trails`
--
DROP TRIGGER IF EXISTS `tbl_audit_trails_before_insert`;
DELIMITER //
CREATE TRIGGER `tbl_audit_trails_before_insert` BEFORE INSERT ON `tbl_audit_trails`
 FOR EACH ROW BEGIN
	SET NEW.datetime = NOW();
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_banners`
--

DROP TABLE IF EXISTS `tbl_banners`;
CREATE TABLE IF NOT EXISTS `tbl_banners` (
`id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_banners`
--

INSERT INTO `tbl_banners` (`id`, `name`) VALUES
(6, '1.png'),
(7, '2.png'),
(8, '3.png'),
(9, '4.png'),
(10, '5.png');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_company`
--

DROP TABLE IF EXISTS `tbl_company`;
CREATE TABLE IF NOT EXISTS `tbl_company` (
`id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `streetAddress` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `geolocation` varchar(255) NOT NULL,
  `emailAddress` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_company`
--

INSERT INTO `tbl_company` (`id`, `city`, `email`, `fax`, `name`, `streetAddress`, `telephone`, `country_id`, `geolocation`, `emailAddress`) VALUES
(1, 'NAIROBI', 'info@systechafrica.com', '+254726503228', 'FUNDMASTER MSS', 'WESTLANDS, NAIROBI', '+254726503228', 3, '-1.262287,36.8090102', 'info@systechafrica.com');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_config`
--

DROP TABLE IF EXISTS `tbl_config`;
CREATE TABLE IF NOT EXISTS `tbl_config` (
`id` int(11) NOT NULL,
  `key_` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `companyName` varchar(255) NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `fax` varchar(255) NOT NULL,
  `streetAddress` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_contact_categories`
--

DROP TABLE IF EXISTS `tbl_contact_categories`;
CREATE TABLE IF NOT EXISTS `tbl_contact_categories` (
`id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_contact_categories`
--

INSERT INTO `tbl_contact_categories` (`id`, `name`, `version`) VALUES
(4, 'Claims', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_content`
--

DROP TABLE IF EXISTS `tbl_content`;
CREATE TABLE IF NOT EXISTS `tbl_content` (
`id` bigint(20) NOT NULL,
  `text` text,
  `page` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `publish` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_content`
--

INSERT INTO `tbl_content` (`id`, `text`, `page`, `position`, `publish`) VALUES
(1, '<div align="center"><b>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor </b></div>', 'SIGN_IN', 'LEFT', 0),
(2, '<p align="center"><strong>"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</strong></p>', 'LOGIN', 'LEFT', 0),
(3, '<h1 class="text-center">WHY SELF SERVICE PORTAL?</h1>\r\n	<div class="col-md-4 text-center grid-block">\r\n		<img src="/Mss/static/images/icons/menu/analysis.png" /><br />\r\n		<br />\r\n		<p>Get access to personalized financial analysis &amp; information</p>\r\n	</div>\r\n	<div class="col-md-4 text-center grid-block">\r\n		<img src="/Mss/static/images/icons/menu/history.png" /><br />\r\n		<br />\r\n		<p>Being a member, means you can now access your pension\r\n			contribution history</p>\r\n	</div>\r\n	<div class="/Mss/col-md-4 text-center grid-block">\r\n		<img src="static/images/icons/menu/user.png" /><br />\r\n		<br />\r\n		<p>As a member, you can manage your scheme account details</p>\r\n	</div>', 'HOME', 'LEFT', 0),
(4, 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, co', 'INTEREST_RATES', 'LEFT', 0),
(5, 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don''t look even slightly believable. If you are going to use a passage of Lorem Ipsum, yo', 'WHAT_IF_ANALYSIS', 'LEFT', 0),
(6, 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one ', 'ANNUITY_QUOTATION', 'LEFT', 0),
(7, 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions ', 'CONTACT_US', 'LEFT', 0),
(8, '"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human ', 'REGISTRATION', 'LEFT', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_countries`
--

DROP TABLE IF EXISTS `tbl_countries`;
CREATE TABLE IF NOT EXISTS `tbl_countries` (
`id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=502021 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_countries`
--

INSERT INTO `tbl_countries` (`id`, `code`, `name`) VALUES
(1, 'US', 'United States'),
(2, 'CA', 'Canada'),
(3, 'TZ', 'Tanzania'),
(4, 'AL', 'Albania'),
(5, 'DZ', 'Algeria'),
(6, 'DS', 'American Samoa'),
(7, 'AD', 'Andorra'),
(8, 'AO', 'Angola'),
(9, 'AI', 'Anguilla'),
(10, 'AQ', 'Antarctica'),
(11, 'AG', 'Antigua and/or Barbuda'),
(12, 'AR', 'Argentina'),
(13, 'AM', 'Armenia'),
(14, 'AW', 'Aruba'),
(15, 'AU', 'Australia'),
(16, 'AT', 'Austria'),
(17, 'AZ', 'Azerbaijan'),
(18, 'BS', 'Bahamas'),
(19, 'BH', 'Bahrain'),
(20, 'BD', 'Bangladesh'),
(21, 'BB', 'Barbados'),
(22, 'BY', 'Belarus'),
(23, 'BE', 'Belgium'),
(24, 'BZ', 'Belize'),
(25, 'BJ', 'Benin'),
(26, 'BM', 'Bermuda'),
(27, 'BT', 'Bhutan'),
(28, 'BO', 'Bolivia'),
(29, 'BA', 'Bosnia and Herzegovina'),
(30, 'BW', 'Botswana'),
(31, 'BV', 'Bouvet Island'),
(32, 'BR', 'Brazil'),
(33, 'IO', 'British lndian Ocean Territory'),
(34, 'BN', 'Brunei Darussalam'),
(35, 'BG', 'Bulgaria'),
(36, 'BF', 'Burkina Faso'),
(37, 'BI', 'Burundi'),
(38, 'KH', 'Cambodia'),
(39, 'CM', 'Cameroon'),
(40, 'CV', 'Cape Verde'),
(41, 'KY', 'Cayman Islands'),
(42, 'CF', 'Central African Republic'),
(43, 'TD', 'Chad'),
(44, 'CL', 'Chile'),
(45, 'CN', 'China'),
(46, 'CX', 'Christmas Island'),
(47, 'CC', 'Cocos (Keeling) Islands'),
(48, 'CO', 'Colombia'),
(49, 'KM', 'Comoros'),
(50, 'CG', 'Congo'),
(51, 'CK', 'Cook Islands'),
(52, 'CR', 'Costa Rica'),
(53, 'HR', 'Croatia (Hrvatska)'),
(54, 'CU', 'Cuba'),
(55, 'CY', 'Cyprus'),
(56, 'CZ', 'Czech Republic'),
(57, 'DK', 'Denmark'),
(58, 'DJ', 'Djibouti'),
(59, 'DM', 'Dominica'),
(60, 'DO', 'Dominican Republic'),
(61, 'TP', 'East Timor'),
(62, 'EC', 'Ecudaor'),
(63, 'EG', 'Egypt'),
(64, 'SV', 'El Salvador'),
(65, 'GQ', 'Equatorial Guinea'),
(66, 'ER', 'Eritrea'),
(67, 'EE', 'Estonia'),
(68, 'ET', 'Ethiopia'),
(69, 'FK', 'Falkland Islands (Malvinas)'),
(70, 'FO', 'Faroe Islands'),
(71, 'FJ', 'Fiji'),
(72, 'FI', 'Finland'),
(73, 'FR', 'France'),
(74, 'FX', 'France, Metropolitan'),
(75, 'GF', 'French Guiana'),
(76, 'PF', 'French Polynesia'),
(77, 'TF', 'French Southern Territories'),
(78, 'GA', 'Gabon'),
(79, 'GM', 'Gambia'),
(80, 'GE', 'Georgia'),
(81, 'DE', 'Germany'),
(82, 'GH', 'Ghana'),
(83, 'GI', 'Gibraltar'),
(84, 'GR', 'Greece'),
(85, 'GL', 'Greenland'),
(86, 'GD', 'Grenada'),
(87, 'GP', 'Guadeloupe'),
(88, 'GU', 'Guam'),
(89, 'GT', 'Guatemala'),
(90, 'GN', 'Guinea'),
(91, 'GW', 'Guinea-Bissau'),
(92, 'GY', 'Guyana'),
(93, 'HT', 'Haiti'),
(94, 'HM', 'Heard and Mc Donald Islands'),
(95, 'HN', 'Honduras'),
(96, 'HK', 'Hong Kong'),
(97, 'HU', 'Hungary'),
(98, 'IS', 'Iceland'),
(99, 'IN', 'India'),
(100, 'ID', 'Indonesia'),
(101, 'IR', 'Iran (Islamic Republic of)'),
(102, 'IQ', 'Iraq'),
(103, 'IE', 'Ireland'),
(104, 'IL', 'Israel'),
(105, 'IT', 'Italy'),
(106, 'CI', 'Ivory Coast'),
(107, 'JM', 'Jamaica'),
(108, 'JP', 'Japan'),
(109, 'JO', 'Jordan'),
(110, 'KZ', 'Kazakhstan'),
(111, 'KE', 'Kenya'),
(112, 'KI', 'Kiribati'),
(113, 'KP', 'Korea, Democratic People''s Republic of'),
(114, 'KR', 'Korea, Republic of'),
(115, 'KW', 'Kuwait'),
(116, 'KG', 'Kyrgyzstan'),
(117, 'LA', 'Lao People''s Democratic Republic'),
(118, 'LV', 'Latvia'),
(119, 'LB', 'Lebanon'),
(120, 'LS', 'Lesotho'),
(121, 'LR', 'Liberia'),
(122, 'LY', 'Libyan Arab Jamahiriya'),
(123, 'LI', 'Liechtenstein'),
(124, 'LT', 'Lithuania'),
(125, 'LU', 'Luxembourg'),
(126, 'MO', 'Macau'),
(127, 'MK', 'Macedonia'),
(128, 'MG', 'Madagascar'),
(129, 'MW', 'Malawi'),
(130, 'MY', 'Malaysia'),
(131, 'MV', 'Maldives'),
(132, 'ML', 'Mali'),
(133, 'MT', 'Malta'),
(134, 'MH', 'Marshall Islands'),
(135, 'MQ', 'Martinique'),
(136, 'MR', 'Mauritania'),
(137, 'MU', 'Mauritius'),
(138, 'TY', 'Mayotte'),
(139, 'MX', 'Mexico'),
(140, 'FM', 'Micronesia, Federated States of'),
(141, 'MD', 'Moldova, Republic of'),
(142, 'MC', 'Monaco'),
(143, 'MN', 'Mongolia'),
(144, 'MS', 'Montserrat'),
(145, 'MA', 'Morocco'),
(146, 'MZ', 'Mozambique'),
(147, 'MM', 'Myanmar'),
(148, 'NA', 'Namibia'),
(149, 'NR', 'Nauru'),
(150, 'NP', 'Nepal'),
(151, 'NL', 'Netherlands'),
(152, 'AN', 'Netherlands Antilles'),
(153, 'NC', 'New Caledonia'),
(154, 'NZ', 'New Zealand'),
(155, 'NI', 'Nicaragua'),
(156, 'NE', 'Niger'),
(157, 'NG', 'Nigeria'),
(158, 'NU', 'Niue'),
(159, 'NF', 'Norfork Island'),
(160, 'MP', 'Northern Mariana Islands'),
(161, 'NO', 'Norway'),
(162, 'OM', 'Oman'),
(163, 'PK', 'Pakistan'),
(164, 'PW', 'Palau'),
(165, 'PA', 'Panama'),
(166, 'PG', 'Papua New Guinea'),
(167, 'PY', 'Paraguay'),
(168, 'PE', 'Peru'),
(169, 'PH', 'Philippines'),
(170, 'PN', 'Pitcairn'),
(171, 'PL', 'Poland'),
(172, 'PT', 'Portugal'),
(173, 'PR', 'Puerto Rico'),
(174, 'QA', 'Qatar'),
(175, 'RE', 'Reunion'),
(176, 'RO', 'Romania'),
(177, 'RU', 'Russian Federation'),
(178, 'RW', 'Rwanda'),
(179, 'KN', 'Saint Kitts and Nevis'),
(180, 'LC', 'Saint Lucia'),
(181, 'VC', 'Saint Vincent and the Grenadines'),
(182, 'WS', 'Samoa'),
(183, 'SM', 'San Marino'),
(184, 'ST', 'Sao Tome and Principe'),
(185, 'SA', 'Saudi Arabia'),
(186, 'SN', 'Senegal'),
(187, 'SC', 'Seychelles'),
(188, 'SL', 'Sierra Leone'),
(189, 'SG', 'Singapore'),
(190, 'SK', 'Slovakia'),
(191, 'SI', 'Slovenia'),
(192, 'SB', 'Solomon Islands'),
(193, 'SO', 'Somalia'),
(194, 'ZA', 'South Africa'),
(195, 'GS', 'South Georgia South Sandwich Islands'),
(196, 'ES', 'Spain'),
(197, 'LK', 'Sri Lanka'),
(198, 'SH', 'St. Helena'),
(199, 'PM', 'St. Pierre and Miquelon'),
(200, 'SD', 'Sudan'),
(201, 'SR', 'Suriname'),
(202, 'SJ', 'Svalbarn and Jan Mayen Islands'),
(203, 'SZ', 'Swaziland'),
(204, 'SE', 'Sweden'),
(205, 'CH', 'Switzerland'),
(206, 'SY', 'Syrian Arab Republic'),
(207, 'TW', 'Taiwan'),
(208, 'TJ', 'Tajikistan'),
(209, 'TZ', 'Tanzania, United Republic of'),
(210, 'TH', 'Thailand'),
(211, 'TG', 'Togo'),
(212, 'TK', 'Tokelau'),
(213, 'TO', 'Tonga'),
(214, 'TT', 'Trinidad and Tobago'),
(215, 'TN', 'Tunisia'),
(216, 'TR', 'Turkey'),
(217, 'TM', 'Turkmenistan'),
(218, 'TC', 'Turks and Caicos Islands'),
(219, 'TV', 'Tuvalu'),
(220, 'UG', 'Uganda'),
(221, 'UA', 'Ukraine'),
(222, 'AE', 'United Arab Emirates'),
(223, 'GB', 'United Kingdom'),
(224, 'UM', 'United States minor outlying islands'),
(225, 'UY', 'Uruguay'),
(226, 'UZ', 'Uzbekistan'),
(227, 'VU', 'Vanuatu'),
(228, 'VA', 'Vatican City State'),
(229, 'VE', 'Venezuela'),
(230, 'VN', 'Vietnam'),
(231, 'VG', 'Virigan Islands (British)'),
(232, 'VI', 'Virgin Islands (U.S.)'),
(233, 'WF', 'Wallis and Futuna Islands'),
(234, 'EH', 'Western Sahara'),
(235, 'YE', 'Yemen'),
(236, 'YU', 'Yugoslavia'),
(237, 'ZR', 'Zaire'),
(238, 'ZM', 'Zambia'),
(239, 'ZW', 'Zimbabwe'),
(502020, 'AF', 'Afghanistan');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_genders`
--

DROP TABLE IF EXISTS `tbl_genders`;
CREATE TABLE IF NOT EXISTS `tbl_genders` (
`id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_genders`
--

INSERT INTO `tbl_genders` (`id`, `name`) VALUES
(1, 'Male'),
(2, 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_help`
--

DROP TABLE IF EXISTS `tbl_help`;
CREATE TABLE IF NOT EXISTS `tbl_help` (
`id` bigint(20) NOT NULL,
  `description` text NOT NULL,
  `page` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_help`
--

INSERT INTO `tbl_help` (`id`, `description`, `page`) VALUES
(1, '<div align="center"><b>This is the sign in help content</b><br></div>', 'SIGN_IN'),
(2, '<div align="center"><b>"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</b></div>', 'LOGIN'),
(3, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su', 'HOME'),
(4, 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, co', 'INTEREST_RATES'),
(5, 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don''t look even slightly believable. If you are going to use a passage of Lorem Ipsum, yo', 'WHAT_IF_ANALYSIS'),
(6, 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one ', 'ANNUITY_QUOTATION'),
(7, 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions ', 'CONTACT_US'),
(8, '"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human ', 'REGISTRATION');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_interest_rate_columns`
--

DROP TABLE IF EXISTS `tbl_interest_rate_columns`;
CREATE TABLE IF NOT EXISTS `tbl_interest_rate_columns` (
`id` bigint(20) NOT NULL,
  `accountingPeriod` tinyint(1) NOT NULL,
  `contributions` tinyint(1) NOT NULL,
  `dateDeclared` tinyint(1) NOT NULL,
  `openingBalances` tinyint(1) NOT NULL,
  `pensionDrawDown` tinyint(1) NOT NULL,
  `year` tinyint(1) NOT NULL,
  `accountingPeriodText` varchar(255) DEFAULT NULL,
  `contributionsText` varchar(255) DEFAULT NULL,
  `dateDeclaredText` varchar(255) DEFAULT NULL,
  `openingBalancesText` varchar(255) DEFAULT NULL,
  `pensionDrawDownText` varchar(255) DEFAULT NULL,
  `yearText` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_interest_rate_columns`
--

INSERT INTO `tbl_interest_rate_columns` (`id`, `accountingPeriod`, `contributions`, `dateDeclared`, `openingBalances`, `pensionDrawDown`, `year`, `accountingPeriodText`, `contributionsText`, `dateDeclaredText`, `openingBalancesText`, `pensionDrawDownText`, `yearText`) VALUES
(1, 1, 1, 1, 1, 1, 1, 'adfsdf', 'adfsadfds', 'asdfasdf', 'asdfasdf', 'asdfasdf', 'adsfasdfdf');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_marital_statuses`
--

DROP TABLE IF EXISTS `tbl_marital_statuses`;
CREATE TABLE IF NOT EXISTS `tbl_marital_statuses` (
`id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_marital_statuses`
--

INSERT INTO `tbl_marital_statuses` (`id`, `name`) VALUES
(1, 'Single'),
(2, 'Married'),
(3, 'Divorced'),
(4, 'Widowed');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_media`
--

DROP TABLE IF EXISTS `tbl_media`;
CREATE TABLE IF NOT EXISTS `tbl_media` (
`id` bigint(20) NOT NULL,
  `access` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `scheme` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_media`
--

INSERT INTO `tbl_media` (`id`, `access`, `created`, `name`, `description`, `scheme`) VALUES
(6, 'Member', '2015-08-13 13:16:21', 'FRS Kenya V16 11 May 2015 (Signed Off Version).docx', 'afddsfsdfafa							 ', '281');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_members`
--

DROP TABLE IF EXISTS `tbl_members`;
CREATE TABLE IF NOT EXISTS `tbl_members` (
`id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `emailAddress` varchar(255) DEFAULT NULL,
  `idNumber` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `residentialAddress` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `gender_id` bigint(20) DEFAULT NULL,
  `marital_status_id` bigint(20) DEFAULT NULL,
  `dateOfBirth` date NOT NULL,
  `scheme` varchar(255) NOT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `othernames` varchar(255) DEFAULT NULL,
  `posted` tinyint(1) NOT NULL,
  `country` tinyblob,
  `gender` tinyblob,
  `maritalStatus` tinyblob,
  `agentId` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_members`
--

INSERT INTO `tbl_members` (`id`, `city`, `emailAddress`, `idNumber`, `name`, `phoneNumber`, `residentialAddress`, `country_id`, `gender_id`, `marital_status_id`, `dateOfBirth`, `scheme`, `lastname`, `othernames`, `posted`, `country`, `gender`, `maritalStatus`, `agentId`) VALUES
(3, '-', 'bryanitur@gmail.com', 'bryanitur@gmail.com', 'BRIAN', '0726503328', 'NAIROBI', NULL, NULL, NULL, '2015-07-27', '1283', 'adsfsdfdfdf', '', 1, 0xaced000573720020636f6d2e66756e646d61737465722e6d73732e6d6f64656c2e436f756e74727900000000000000010200034c0004636f64657400124c6a6176612f6c616e672f537472696e673b4c000269647400104c6a6176612f6c616e672f4c6f6e673b4c00046e616d6571007e00017870740002545a7372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b0200007870000000000000000374000854616e7a616e6961, 0xaced00057372001f636f6d2e66756e646d61737465722e6d73732e6d6f64656c2e47656e64657200000000000000010200024c000269647400104c6a6176612f6c616e672f4c6f6e673b4c00046e616d657400124c6a6176612f6c616e672f537472696e673b78707372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b020000787000000000000000017400044d616c65, 0xaced000573720026636f6d2e66756e646d61737465722e6d73732e6d6f64656c2e4d61726974616c53746174757300000000000000010200024c000269647400104c6a6176612f6c616e672f4c6f6e673b4c00046e616d657400124c6a6176612f6c616e672f537472696e673b78707372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b020000787000000000000000027400074d617272696564, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_member_rights`
--

DROP TABLE IF EXISTS `tbl_member_rights`;
CREATE TABLE IF NOT EXISTS `tbl_member_rights` (
`id` bigint(20) NOT NULL,
  `city` tinyint(1) NOT NULL,
  `country` tinyint(1) NOT NULL,
  `dateOfBirth` tinyint(1) NOT NULL,
  `emailAddress` tinyint(1) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `idNumber` tinyint(1) NOT NULL,
  `maritalStatus` tinyint(1) NOT NULL,
  `name` tinyint(1) NOT NULL,
  `phoneNumber` tinyint(1) NOT NULL,
  `residentialAddress` tinyint(1) NOT NULL,
  `annualPensionableSalary` tinyint(1) DEFAULT NULL,
  `dateJoinedScheme` tinyint(1) DEFAULT NULL,
  `department` tinyint(1) DEFAULT NULL,
  `mbio_id` tinyint(1) DEFAULT NULL,
  `memberNo` tinyint(1) DEFAULT NULL,
  `membershipNo` tinyint(1) DEFAULT NULL,
  `partyRefNo` tinyint(1) DEFAULT NULL,
  `pinNo` tinyint(1) DEFAULT NULL,
  `policyNo` tinyint(1) DEFAULT NULL,
  `postalAddress` tinyint(1) DEFAULT NULL,
  `schemeId` tinyint(1) DEFAULT NULL,
  `staffNo` tinyint(1) DEFAULT NULL,
  `terminateCover` tinyint(1) DEFAULT NULL,
  `town` tinyint(1) DEFAULT NULL,
  `partnerNo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_member_rights`
--

INSERT INTO `tbl_member_rights` (`id`, `city`, `country`, `dateOfBirth`, `emailAddress`, `gender`, `idNumber`, `maritalStatus`, `name`, `phoneNumber`, `residentialAddress`, `annualPensionableSalary`, `dateJoinedScheme`, `department`, `mbio_id`, `memberNo`, `membershipNo`, `partyRefNo`, `pinNo`, `policyNo`, `postalAddress`, `schemeId`, `staffNo`, `terminateCover`, `town`, `partnerNo`) VALUES
(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_menus`
--

DROP TABLE IF EXISTS `tbl_menus`;
CREATE TABLE IF NOT EXISTS `tbl_menus` (
`id` bigint(20) NOT NULL,
  `annuityQuotationActive` tinyint(1) NOT NULL,
  `annuityQuotationName` varchar(255) NOT NULL,
  `contactUsActive` tinyint(1) NOT NULL,
  `contactUsName` varchar(255) NOT NULL,
  `interestRatesActive` tinyint(1) NOT NULL,
  `interestRatesName` varchar(255) NOT NULL,
  `whatIfAnalysisActive` tinyint(1) NOT NULL,
  `whatIfAnalysisName` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_menus`
--

INSERT INTO `tbl_menus` (`id`, `annuityQuotationActive`, `annuityQuotationName`, `contactUsActive`, `contactUsName`, `interestRatesActive`, `interestRatesName`, `whatIfAnalysisActive`, `whatIfAnalysisName`) VALUES
(1, 1, 'ANNUITY QUOTATION', 1, 'CONTACT US', 1, 'INTEREST RATES', 1, 'IPP BENEFITS CALCULATOR');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_notifications`
--

DROP TABLE IF EXISTS `tbl_notifications`;
CREATE TABLE IF NOT EXISTS `tbl_notifications` (
`id` bigint(20) NOT NULL,
  `details` varchar(255) NOT NULL,
  `date` datetime DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `target` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_password_policy`
--

DROP TABLE IF EXISTS `tbl_password_policy`;
CREATE TABLE IF NOT EXISTS `tbl_password_policy` (
`id` bigint(20) NOT NULL,
  `expiry_days` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `lock_after_count_of` int(11) NOT NULL,
  `lowercase` tinyint(1) NOT NULL,
  `numbers` tinyint(1) NOT NULL,
  `password_reuse` tinyint(1) NOT NULL,
  `uppercase` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_password_policy`
--

INSERT INTO `tbl_password_policy` (`id`, `expiry_days`, `length`, `lock_after_count_of`, `lowercase`, `numbers`, `password_reuse`, `uppercase`) VALUES
(1, 90, 84, 5, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_permissions`
--

DROP TABLE IF EXISTS `tbl_permissions`;
CREATE TABLE IF NOT EXISTS `tbl_permissions` (
`id` bigint(20) NOT NULL,
  `analytics` tinyint(1) NOT NULL,
  `content` tinyint(1) NOT NULL,
  `content_help` tinyint(1) NOT NULL,
  `content_page` tinyint(1) NOT NULL,
  `media` tinyint(1) NOT NULL,
  `media_upload` tinyint(1) NOT NULL,
  `member_edit` tinyint(1) NOT NULL,
  `members` tinyint(1) NOT NULL,
  `operation_balance_history` tinyint(1) NOT NULL,
  `operation_benefit_projection` tinyint(1) NOT NULL,
  `operation_contribution_history` tinyint(1) NOT NULL,
  `operation_personal_info` tinyint(1) NOT NULL,
  `operation_statement_of_account` tinyint(1) NOT NULL,
  `operations` tinyint(1) NOT NULL,
  `payments` tinyint(1) NOT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `receipts` tinyint(1) NOT NULL,
  `scheme_managers` tinyint(1) NOT NULL,
  `schemes` tinyint(1) NOT NULL,
  `setup` tinyint(1) NOT NULL,
  `setup_banner` tinyint(1) NOT NULL,
  `setup_company` tinyint(1) NOT NULL,
  `setup_contact_reason` tinyint(1) NOT NULL,
  `setup_interest_rate` tinyint(1) NOT NULL,
  `setup_logo` tinyint(1) NOT NULL,
  `setup_menu` tinyint(1) NOT NULL,
  `setup_other` tinyint(1) NOT NULL,
  `setup_social` tinyint(1) NOT NULL,
  `setup_theme` tinyint(1) NOT NULL,
  `uac` tinyint(1) NOT NULL,
  `media_remove` tinyint(1) NOT NULL,
  `member_edit_permissions` tinyint(1) NOT NULL,
  `member_view` tinyint(1) NOT NULL,
  `profile_login_username` tinyint(1) NOT NULL,
  `profile_privileges` tinyint(1) NOT NULL,
  `users` tinyint(1) NOT NULL,
  `user_enable_disable` tinyint(1) NOT NULL,
  `audit_trail` tinyint(1) NOT NULL,
  `portal_member_delete` tinyint(1) NOT NULL,
  `portal_member_process` tinyint(1) NOT NULL,
  `portal_member_view` tinyint(1) NOT NULL,
  `portal_members` tinyint(1) NOT NULL,
  `portal_sponsor_delete` tinyint(1) NOT NULL,
  `portal_sponsor_process` tinyint(1) NOT NULL,
  `portal_sponsor_view` tinyint(1) NOT NULL,
  `portal_sponsors` tinyint(1) NOT NULL,
  `portal_member_add` tinyint(1) NOT NULL,
  `portal_sponsor_add` tinyint(1) NOT NULL,
  `password_policy` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_permissions`
--

INSERT INTO `tbl_permissions` (`id`, `analytics`, `content`, `content_help`, `content_page`, `media`, `media_upload`, `member_edit`, `members`, `operation_balance_history`, `operation_benefit_projection`, `operation_contribution_history`, `operation_personal_info`, `operation_statement_of_account`, `operations`, `payments`, `profile`, `receipts`, `scheme_managers`, `schemes`, `setup`, `setup_banner`, `setup_company`, `setup_contact_reason`, `setup_interest_rate`, `setup_logo`, `setup_menu`, `setup_other`, `setup_social`, `setup_theme`, `uac`, `media_remove`, `member_edit_permissions`, `member_view`, `profile_login_username`, `profile_privileges`, `users`, `user_enable_disable`, `audit_trail`, `portal_member_delete`, `portal_member_process`, `portal_member_view`, `portal_members`, `portal_sponsor_delete`, `portal_sponsor_process`, `portal_sponsor_view`, `portal_sponsors`, `portal_member_add`, `portal_sponsor_add`, `password_policy`) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'ADMINISTRATOR', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(2, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 'MANAGER', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'SPONSOR', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'TRUSTEE', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'AGENT', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'CUSTODIAN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'CUSTOMER_RELATIONSHIP_MANAGER', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'CUSTOMER_RELATIONSHIP_EXECUTIVE', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'FUND_MANAGER', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'PENSIONER', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_profile_login_fields`
--

DROP TABLE IF EXISTS `tbl_profile_login_fields`;
CREATE TABLE IF NOT EXISTS `tbl_profile_login_fields` (
`id` bigint(20) NOT NULL,
  `ordinal` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `published` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_profile_login_fields`
--

INSERT INTO `tbl_profile_login_fields` (`id`, `ordinal`, `profile`, `published`) VALUES
(1, 'EMAIL', 'MEMBER', 1),
(2, 'EMAIL', 'ADMINISTRATOR', 1),
(3, 'PIN', 'SPONSOR', 1),
(4, 'EMAIL', 'TRUSTEE', 1),
(5, 'EMAIL', 'AGENT', 1),
(6, 'EMAIL', 'CUSTODIAN', 1),
(7, 'EMAIL', 'CUSTOMER_RELATIONSHIP_MANAGER', 1),
(8, 'EMAIL', 'CUSTOMER_RELATIONSHIP_EXECUTIVE', 1),
(9, 'EMAIL', 'FUND_MANAGER', 1),
(10, 'EMAIL', 'PENSIONER', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_schemes`
--

DROP TABLE IF EXISTS `tbl_schemes`;
CREATE TABLE IF NOT EXISTS `tbl_schemes` (
`id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_scheme_member_managers`
--

DROP TABLE IF EXISTS `tbl_scheme_member_managers`;
CREATE TABLE IF NOT EXISTS `tbl_scheme_member_managers` (
`id` bigint(20) NOT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `schemeID` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scheme` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sectors`
--

DROP TABLE IF EXISTS `tbl_sectors`;
CREATE TABLE IF NOT EXISTS `tbl_sectors` (
`id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_sectors`
--

INSERT INTO `tbl_sectors` (`id`, `name`) VALUES
(1, 'FINANCIAL'),
(2, 'NGOS'),
(3, 'PARASTATAL'),
(4, 'AGRICULTURAL'),
(5, 'INDUSTRIAL'),
(6, 'TOURISM'),
(7, 'EDUCATIONAL'),
(8, 'BANKING'),
(9, 'INSURANCE'),
(10, 'ENERGY'),
(11, 'MINING'),
(12, 'OTHER');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_settings`
--

DROP TABLE IF EXISTS `tbl_settings`;
CREATE TABLE IF NOT EXISTS `tbl_settings` (
`id` bigint(20) NOT NULL,
  `loginField` varchar(255) NOT NULL,
  `xiPath` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `xiReportPath` varchar(255) NOT NULL,
  `xiReportPassword` varchar(255) DEFAULT NULL,
  `xiReportUsername` varchar(255) DEFAULT NULL,
  `logoFile` varchar(255) DEFAULT NULL,
  `memberOnboarding` varchar(255) DEFAULT NULL,
  `sponsorOnboading` varchar(255) DEFAULT NULL,
  `encrypt` tinyint(1) NOT NULL,
  `portalBaseURL` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_settings`
--

INSERT INTO `tbl_settings` (`id`, `loginField`, `xiPath`, `password`, `username`, `xiReportPath`, `xiReportPassword`, `xiReportUsername`, `logoFile`, `memberOnboarding`, `sponsorOnboading`, `encrypt`, `portalBaseURL`) VALUES
(1, 'EMAIL', 'http://progressdemo.systechafrica.com:8080/Xi/api/', 'Admin12345^', 'admin', '', 'admin', 'weblogic', 'logo.png', 'BOTH', 'BOTH', 0, 'http://localhost:8080/Mss/');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_social`
--

DROP TABLE IF EXISTS `tbl_social`;
CREATE TABLE IF NOT EXISTS `tbl_social` (
`id` bigint(20) NOT NULL,
  `facebook` varchar(255) NOT NULL,
  `google` varchar(255) NOT NULL,
  `linkedin` varchar(255) NOT NULL,
  `pinterest` varchar(255) NOT NULL,
  `twitter` varchar(255) NOT NULL,
  `youtube` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_social`
--

INSERT INTO `tbl_social` (`id`, `facebook`, `google`, `linkedin`, `pinterest`, `twitter`, `youtube`) VALUES
(1, 'https://www.facebook.com', 'http://www.google.com', 'http://www.linkedin.com', '', 'http://www.twitter.com', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sponsors`
--

DROP TABLE IF EXISTS `tbl_sponsors`;
CREATE TABLE IF NOT EXISTS `tbl_sponsors` (
`id` bigint(20) NOT NULL,
  `applicationDate` datetime DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `companyAddress` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `country` tinyblob,
  `emailAddress` varchar(255) DEFAULT NULL,
  `employerRefNo` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `pinNumber` varchar(255) DEFAULT NULL,
  `sector` tinyblob,
  `posted` tinyint(1) NOT NULL,
  `scheme` varchar(255) DEFAULT NULL,
  `agentId` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_sponsors`
--

INSERT INTO `tbl_sponsors` (`id`, `applicationDate`, `city`, `companyAddress`, `companyName`, `country`, `emailAddress`, `employerRefNo`, `phoneNumber`, `pinNumber`, `sector`, `posted`, `scheme`, `agentId`) VALUES
(3, '2015-08-13 00:00:00', 'oghklamsdf', '798798', 'BRITAM', 0xaced000573720020636f6d2e66756e646d61737465722e6d73732e6d6f64656c2e436f756e74727900000000000000010200034c0004636f64657400124c6a6176612f6c616e672f537472696e673b4c000269647400104c6a6176612f6c616e672f4c6f6e673b4c00046e616d6571007e000178707400024b457372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b020000787000000000000000017400054b656e7961, 'bryanitur@gmail.com', '098767', '98698786789778', '0576980', 0xaced00057372001f636f6d2e66756e646d61737465722e6d73732e6d6f64656c2e536563746f7200000000000000010200024c000269647400104c6a6176612f6c616e672f4c6f6e673b4c00046e616d657400124c6a6176612f6c616e672f537472696e673b78707372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b0200007870000000000000000174000742616e6b696e67, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_theme`
--

DROP TABLE IF EXISTS `tbl_theme`;
CREATE TABLE IF NOT EXISTS `tbl_theme` (
`id` bigint(20) NOT NULL,
  `font` varchar(255) NOT NULL,
  `major` varchar(255) NOT NULL,
  `minor` varchar(255) NOT NULL,
  `other` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `footer` varchar(255) NOT NULL,
  `header` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_theme`
--

INSERT INTO `tbl_theme` (`id`, `font`, `major`, `minor`, `other`, `content`, `footer`, `header`) VALUES
(1, 'Open Sans', '#ef0d20', '#f27f00', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_used_passwords`
--

DROP TABLE IF EXISTS `tbl_used_passwords`;
CREATE TABLE IF NOT EXISTS `tbl_used_passwords` (
`id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userid` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_used_passwords`
--

INSERT INTO `tbl_used_passwords` (`id`, `password`, `userid`) VALUES
(7, '8cd2885e42fc718f73e589be330010d6523ff272', 81);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

DROP TABLE IF EXISTS `tbl_users`;
CREATE TABLE IF NOT EXISTS `tbl_users` (
`id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `userProfile` varchar(255) DEFAULT NULL,
  `profileID` bigint(20) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `securityCode` varchar(255) DEFAULT NULL,
  `attempt` int(11) NOT NULL,
  `password_expiry` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`id`, `password`, `username`, `userProfile`, `profileID`, `status`, `securityCode`, `attempt`, `password_expiry`) VALUES
(81, '8cd2885e42fc718f73e589be330010d6523ff272', 'lance@systechafrica.com', 'ADMINISTRATOR', 2263019, 1, '3a332471-4300-421f-9c7a-e38625af294e', 0, '2015-12-07');

--
-- Triggers `tbl_users`
--
DROP TRIGGER IF EXISTS `save_new_password`;
DELIMITER //
CREATE TRIGGER `save_new_password` AFTER INSERT ON `tbl_users`
 FOR EACH ROW BEGIN
	REPLACE INTO tbl_used_passwords VALUES(NULL, NEW.password, NEW.id);
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `save_new_password_on_update`;
DELIMITER //
CREATE TRIGGER `save_new_password_on_update` BEFORE UPDATE ON `tbl_users`
 FOR EACH ROW BEGIN
	REPLACE INTO tbl_used_passwords VALUES(NULL, NEW.password, NEW.id);
END
//
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_activity_logs`
--
ALTER TABLE `tbl_activity_logs`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_audit_trails`
--
ALTER TABLE `tbl_audit_trails`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_banners`
--
ALTER TABLE `tbl_banners`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_company`
--
ALTER TABLE `tbl_company`
 ADD PRIMARY KEY (`id`), ADD KEY `FK4DD404FC823897FA` (`country_id`);

--
-- Indexes for table `tbl_config`
--
ALTER TABLE `tbl_config`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_contact_categories`
--
ALTER TABLE `tbl_contact_categories`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_content`
--
ALTER TABLE `tbl_content`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_countries`
--
ALTER TABLE `tbl_countries`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_genders`
--
ALTER TABLE `tbl_genders`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_help`
--
ALTER TABLE `tbl_help`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_interest_rate_columns`
--
ALTER TABLE `tbl_interest_rate_columns`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_marital_statuses`
--
ALTER TABLE `tbl_marital_statuses`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_media`
--
ALTER TABLE `tbl_media`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_members`
--
ALTER TABLE `tbl_members`
 ADD PRIMARY KEY (`id`), ADD KEY `FK4DBB9198E152D81A` (`gender_id`), ADD KEY `FK4DBB9198CC322B03` (`marital_status_id`), ADD KEY `FK4DBB9198823897FA` (`country_id`);

--
-- Indexes for table `tbl_member_rights`
--
ALTER TABLE `tbl_member_rights`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_menus`
--
ALTER TABLE `tbl_menus`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_notifications`
--
ALTER TABLE `tbl_notifications`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_password_policy`
--
ALTER TABLE `tbl_password_policy`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_permissions`
--
ALTER TABLE `tbl_permissions`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_profile_login_fields`
--
ALTER TABLE `tbl_profile_login_fields`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_schemes`
--
ALTER TABLE `tbl_schemes`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_scheme_member_managers`
--
ALTER TABLE `tbl_scheme_member_managers`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_sectors`
--
ALTER TABLE `tbl_sectors`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_settings`
--
ALTER TABLE `tbl_settings`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_social`
--
ALTER TABLE `tbl_social`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_sponsors`
--
ALTER TABLE `tbl_sponsors`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_theme`
--
ALTER TABLE `tbl_theme`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_used_passwords`
--
ALTER TABLE `tbl_used_passwords`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `password` (`password`,`userid`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `username` (`username`,`userProfile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_activity_logs`
--
ALTER TABLE `tbl_activity_logs`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2641;
--
-- AUTO_INCREMENT for table `tbl_audit_trails`
--
ALTER TABLE `tbl_audit_trails`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=732;
--
-- AUTO_INCREMENT for table `tbl_banners`
--
ALTER TABLE `tbl_banners`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_company`
--
ALTER TABLE `tbl_company`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_config`
--
ALTER TABLE `tbl_config`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_contact_categories`
--
ALTER TABLE `tbl_contact_categories`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_content`
--
ALTER TABLE `tbl_content`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbl_countries`
--
ALTER TABLE `tbl_countries`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=502021;
--
-- AUTO_INCREMENT for table `tbl_genders`
--
ALTER TABLE `tbl_genders`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_help`
--
ALTER TABLE `tbl_help`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbl_interest_rate_columns`
--
ALTER TABLE `tbl_interest_rate_columns`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_marital_statuses`
--
ALTER TABLE `tbl_marital_statuses`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_media`
--
ALTER TABLE `tbl_media`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_members`
--
ALTER TABLE `tbl_members`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_member_rights`
--
ALTER TABLE `tbl_member_rights`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_menus`
--
ALTER TABLE `tbl_menus`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_notifications`
--
ALTER TABLE `tbl_notifications`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_password_policy`
--
ALTER TABLE `tbl_password_policy`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_permissions`
--
ALTER TABLE `tbl_permissions`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_profile_login_fields`
--
ALTER TABLE `tbl_profile_login_fields`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_schemes`
--
ALTER TABLE `tbl_schemes`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_scheme_member_managers`
--
ALTER TABLE `tbl_scheme_member_managers`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_sectors`
--
ALTER TABLE `tbl_sectors`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `tbl_settings`
--
ALTER TABLE `tbl_settings`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_social`
--
ALTER TABLE `tbl_social`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_sponsors`
--
ALTER TABLE `tbl_sponsors`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_theme`
--
ALTER TABLE `tbl_theme`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_used_passwords`
--
ALTER TABLE `tbl_used_passwords`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=82;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_company`
--
ALTER TABLE `tbl_company`
ADD CONSTRAINT `FK4DD404FC823897FA` FOREIGN KEY (`country_id`) REFERENCES `tbl_countries` (`id`);

--
-- Constraints for table `tbl_members`
--
ALTER TABLE `tbl_members`
ADD CONSTRAINT `FK4DBB9198823897FA` FOREIGN KEY (`country_id`) REFERENCES `tbl_countries` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK4DBB9198CC322B03` FOREIGN KEY (`marital_status_id`) REFERENCES `tbl_marital_statuses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK4DBB9198E152D81A` FOREIGN KEY (`gender_id`) REFERENCES `tbl_genders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

/* INNITIAL UPGRADE BEGINS HERE */

ALTER TABLE `tbl_profile_login_fields` ADD COLUMN `published` TINYINT(1) NOT NULL DEFAULT '0';
ALTER TABLE `tbl_users` ADD `attempt` INT NOT NULL;
--
-- Triggers `tbl_users`
--
DELIMITER //
CREATE TRIGGER `save_new_password` AFTER INSERT ON `tbl_users`
 FOR EACH ROW BEGIN
	REPLACE INTO tbl_used_passwords VALUES(NULL, NEW.password, NEW.id);
END
//
DELIMITER ;
DELIMITER //
CREATE TRIGGER `save_new_password_on_update` BEFORE UPDATE ON `tbl_users`
 FOR EACH ROW BEGIN
	REPLACE INTO tbl_used_passwords VALUES(NULL, NEW.password, NEW.id);
END
//
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `username` (`username`,`userProfile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_users`
--


CREATE TABLE IF NOT EXISTS `tbl_used_passwords` (
`id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_used_passwords`
--
ALTER TABLE `tbl_used_passwords`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `password` (`password`,`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_used_passwords`
--
ALTER TABLE `tbl_used_passwords`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `tbl_users` ADD `password_expiry` DATE NOT NULL DEFAULT '2016-01-31' ;
ALTER TABLE `tbl_password_policy` DROP COLUMN `version`;

/* INNITIAL UPGRADE ENDS HERE */
