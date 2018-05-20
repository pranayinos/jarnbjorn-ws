SET FOREIGN_KEY_CHECKS=0;

-- Create syntax for TABLE 'authority'
CREATE TABLE `authority` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `AUTHORITY_NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'deliveries'
CREATE TABLE `deliveries` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `delivery_time` bigint(18) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(127) DEFAULT NULL,
  `phone` bigint(10) DEFAULT NULL,
  `landmark` varchar(127) DEFAULT NULL,
  `order_id` bigint(18) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `deliveries_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'OAUTH_ACCESS_TOKEN'
CREATE TABLE `OAUTH_ACCESS_TOKEN` (
  `TOKEN_ID` varchar(255) DEFAULT NULL,
  `TOKEN` varbinary(4095) DEFAULT NULL,
  `AUTHENTICATION_ID` varchar(255) NOT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  `CLIENT_ID` varchar(255) DEFAULT NULL,
  `AUTHENTICATION` varbinary(4095) DEFAULT NULL,
  `REFRESH_TOKEN` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AUTHENTICATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'OAUTH_CLIENT_DETAILS'
CREATE TABLE `OAUTH_CLIENT_DETAILS` (
  `CLIENT_ID` varchar(255) NOT NULL,
  `RESOURCE_IDS` varchar(255) DEFAULT NULL,
  `CLIENT_SECRET` varchar(255) DEFAULT NULL,
  `SCOPE` varchar(255) DEFAULT NULL,
  `AUTHORIZED_GRANT_TYPES` varchar(255) DEFAULT NULL,
  `WEB_SERVER_REDIRECT_URI` varchar(255) DEFAULT NULL,
  `AUTHORITIES` varchar(255) DEFAULT NULL,
  `ACCESS_TOKEN_VALIDITY` int(11) DEFAULT NULL,
  `REFRESH_TOKEN_VALIDITY` int(11) DEFAULT NULL,
  `ADDITIONAL_INFORMATION` varchar(4096) DEFAULT NULL,
  `AUTOAPPROVE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CLIENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'OAUTH_CLIENT_TOKEN'
CREATE TABLE `OAUTH_CLIENT_TOKEN` (
  `TOKEN_ID` varchar(255) DEFAULT NULL,
  `TOKEN` varbinary(512) DEFAULT NULL,
  `AUTHENTICATION_ID` varchar(255) NOT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  `CLIENT_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AUTHENTICATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'OAUTH_CODE'
CREATE TABLE `OAUTH_CODE` (
  `CODE` varchar(255) DEFAULT NULL,
  `AUTHENTICATION` varbinary(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'OAUTH_REFRESH_TOKEN'
CREATE TABLE `OAUTH_REFRESH_TOKEN` (
  `TOKEN_ID` varchar(255) DEFAULT NULL,
  `TOKEN` varbinary(512) DEFAULT NULL,
  `AUTHENTICATION` varbinary(4095) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'orders'
CREATE TABLE `orders` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT,
  `has_return` tinyint(1) DEFAULT NULL,
  `special_instructions` text,
  `status` varchar(31) NOT NULL DEFAULT '',
  `order_created_time` bigint(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'pickups'
CREATE TABLE `pickups` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `pickup_time` bigint(18) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(127) DEFAULT NULL,
  `phone` bigint(10) DEFAULT NULL,
  `landmark` varchar(127) DEFAULT NULL,
  `order_id` bigint(18) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `pickups_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'saved_address'
CREATE TABLE `saved_address` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(127) DEFAULT NULL,
  `phone` bigint(10) DEFAULT NULL,
  `landmark` varchar(127) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_savedAddress` (`user_id`),
  CONSTRAINT `user_savedAddress` FOREIGN KEY (`user_id`) REFERENCES `user_` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'user_'
CREATE TABLE `user_` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  `ACCOUNT_EXPIRED` tinyint(1) DEFAULT NULL,
  `ACCOUNT_LOCKED` tinyint(1) DEFAULT NULL,
  `CREDENTIALS_EXPIRED` tinyint(1) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'users_authorities'
CREATE TABLE `users_authorities` (
  `USER_ID` bigint(20) unsigned NOT NULL,
  `AUTHORITY_ID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`USER_ID`,`AUTHORITY_ID`),
  KEY `USERS_AUTHORITIES_AUTHORITY` (`AUTHORITY_ID`),
  CONSTRAINT `USERS_AUTHORITIES_AUTHORITY` FOREIGN KEY (`AUTHORITY_ID`) REFERENCES `AUTHORITY` (`ID`),
  CONSTRAINT `USERS_AUTHORITIES_USER_` FOREIGN KEY (`USER_ID`) REFERENCES `USER_` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Create syntax for TABLE 'vendor'
CREATE TABLE `vendor` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS=1;