-- phpMyAdmin SQL Dump
-- version 4.2.12deb2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 15, 2015 at 09:22 PM
-- Server version: 5.6.27-0ubuntu0.15.04.1
-- PHP Version: 5.6.4-4ubuntu6.4

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 90, 6, 5, 1, 0, 0, 0);

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
  `password_policy` tinyint(1) NOT NULL DEFAULT '0',
  `profile_names` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_permissions`
--

INSERT INTO `tbl_permissions` (`id`, `analytics`, `content`, `content_help`, `content_page`, `media`, `media_upload`, `member_edit`, `members`, `operation_balance_history`, `operation_benefit_projection`, `operation_contribution_history`, `operation_personal_info`, `operation_statement_of_account`, `operations`, `payments`, `profile`, `receipts`, `scheme_managers`, `schemes`, `setup`, `setup_banner`, `setup_company`, `setup_contact_reason`, `setup_interest_rate`, `setup_logo`, `setup_menu`, `setup_other`, `setup_social`, `setup_theme`, `uac`, `media_remove`, `member_edit_permissions`, `member_view`, `profile_login_username`, `profile_privileges`, `users`, `user_enable_disable`, `audit_trail`, `portal_member_delete`, `portal_member_process`, `portal_member_view`, `portal_members`, `portal_sponsor_delete`, `portal_sponsor_process`, `portal_sponsor_view`, `portal_sponsors`, `portal_member_add`, `portal_sponsor_add`, `password_policy`, `profile_names`) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'ADMINISTRATOR', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(2, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 'MANAGER', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'SPONSOR', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'TRUSTEE', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'AGENT', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'CUSTODIAN', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'CUSTOMER_RELATIONSHIP_MANAGER', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'CUSTOMER_RELATIONSHIP_EXECUTIVE', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'FUND_MANAGER', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'PENSIONER', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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
(3, 'EMAIL', 'SPONSOR', 1),
(4, 'EMAIL', 'TRUSTEE', 1),
(5, 'EMAIL', 'AGENT', 1),
(6, 'EMAIL', 'CUSTODIAN', 1),
(7, 'EMAIL', 'CUSTOMER_RELATIONSHIP_MANAGER', 1),
(8, 'EMAIL', 'CUSTOMER_RELATIONSHIP_EXECUTIVE', 1),
(9, 'EMAIL', 'FUND_MANAGER', 1),
(10, 'EMAIL', 'PENSIONER', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_profile_names`
--

DROP TABLE IF EXISTS `tbl_profile_names`;
CREATE TABLE IF NOT EXISTS `tbl_profile_names` (
`id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_profile_names`
--

INSERT INTO `tbl_profile_names` (`id`, `name`, `profile`) VALUES
(1, 'MEMBER', 'MEMBER'),
(2, 'ADMINISTRATOR', 'ADMINISTRATOR'),
(3, 'SPONSOR', 'SPONSOR'),
(4, 'TRUSTEE', 'TRUSTEE'),
(5, 'AGENT', 'AGENT'),
(6, 'CUSTODIAN', 'CUSTODIAN'),
(7, 'CUSTOMER_RELATIONSHIP_MANAGER', 'CUSTOMER_RELATIONSHIP_MANAGER'),
(8, 'CUSTOMER_RELATIONSHIP_EXECUTIVE', 'CUSTOMER_RELATIONSHIP_EXECUTIVE'),
(9, 'FUND_MANAGER', 'FUND_MANAGER'),
(10, 'PENSIONER', 'PENSIONER');

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
(1, 'EMAIL', 'http://progressdemo.systechafrica.com:8080/Xi/api/', 'admin', 'admin', '', 'admin', 'weblogic', 'logo.png', 'BOTH', 'BOTH', 0, 'http://localhost:8080/Mss/');

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Indexes for table `tbl_profile_names`
--
ALTER TABLE `tbl_profile_names`
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
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_audit_trails`
--
ALTER TABLE `tbl_audit_trails`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
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
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_members`
--
ALTER TABLE `tbl_members`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
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
-- AUTO_INCREMENT for table `tbl_profile_names`
--
ALTER TABLE `tbl_profile_names`
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
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_theme`
--
ALTER TABLE `tbl_theme`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_used_passwords`
--
ALTER TABLE `tbl_used_passwords`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
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
