-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2017 at 04:01 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `battery_info_list`
--

CREATE TABLE `battery_info_list` (
  `battery_item_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `brand_name` varchar(50) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `mrp_price` decimal(7,2) NOT NULL,
  `specs` varchar(150) NOT NULL,
  `pic` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `battery_types`
--

CREATE TABLE `battery_types` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `hsn_code` int(11) NOT NULL,
  `cgst` decimal(2,2) NOT NULL,
  `sgst` decimal(2,2) NOT NULL,
  `igst` decimal(2,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `bill_no` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `bill_status` varchar(20) NOT NULL,
  `serial_number` varchar(30) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `discount` decimal(7,2) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `date_of_sale` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tax_applied` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_details`
--

CREATE TABLE `purchase_details` (
  `id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `date_of_purchase` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `count` int(11) NOT NULL,
  `amount` decimal(7,2) NOT NULL,
  `tax_details` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users_table`
--

CREATE TABLE `users_table` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL DEFAULT 'User',
  `pswd` varchar(100) NOT NULL,
  `permissions` bigint(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_table`
--

INSERT INTO `users_table` (`user_id`, `user_name`, `pswd`, `permissions`) VALUES
(1, 'admin', '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `battery_info_list`
--
ALTER TABLE `battery_info_list`
  ADD PRIMARY KEY (`battery_item_id`),
  ADD KEY `battery_id` (`id`);

--
-- Indexes for table `battery_types`
--
ALTER TABLE `battery_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `hsn_code` (`hsn_code`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`bill_no`),
  ADD KEY `bill_item` (`item_id`);

--
-- Indexes for table `purchase_details`
--
ALTER TABLE `purchase_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `battery_info_list`
--
ALTER TABLE `battery_info_list`
  MODIFY `battery_item_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `battery_types`
--
ALTER TABLE `battery_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `bill_no` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `purchase_details`
--
ALTER TABLE `purchase_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `battery_info_list`
--
ALTER TABLE `battery_info_list`
  ADD CONSTRAINT `battery_info_list_ibfk_1` FOREIGN KEY (`id`) REFERENCES `battery_types` (`id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `battery_info_list` (`battery_item_id`) ON UPDATE NO ACTION;

--
-- Constraints for table `purchase_details`
--
ALTER TABLE `purchase_details`
  ADD CONSTRAINT `purchase_details_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `battery_info_list` (`battery_item_id`) ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
