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
