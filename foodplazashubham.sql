-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 05, 2016 at 10:20 AM
-- Server version: 5.6.16-1~exp1
-- PHP Version: 5.5.9-1ubuntu4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `foodplazashubham`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE IF NOT EXISTS `Admin` (
  `adminname` varchar(25) DEFAULT NULL,
  `adminusername` varchar(25) NOT NULL DEFAULT '',
  `adminpassword` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`adminusername`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`adminname`, `adminusername`, `adminpassword`) VALUES
('anup', 'anup21017', 'sdfg'),
('kunal', 'kunal21027', 'as');

-- --------------------------------------------------------

--
-- Table structure for table `Cart`
--

CREATE TABLE IF NOT EXISTS `Cart` (
  `cartid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `foodname` varchar(20) DEFAULT NULL,
  `foodquantity` int(11) DEFAULT NULL,
  `foodprice` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `Cart`
--

INSERT INTO `Cart` (`cartid`, `customerid`, `foodname`, `foodquantity`, `foodprice`) VALUES
(4, 456, 'spicy', 3, 370),
(5, 457, 'veggie pizza', 5, 170),
(6, 458, 'double cheese pizza', 2, 270);

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE IF NOT EXISTS `Customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `customername` varchar(25) DEFAULT NULL,
  `customeraddress` char(20) DEFAULT NULL,
  `contact` mediumtext,
  `customerusername` varchar(20) NOT NULL DEFAULT '',
  `customerpassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customerid`,`customerusername`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=462 ;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`customerid`, `customername`, `customeraddress`, `contact`, `customerusername`, `customerpassword`) VALUES
(456, 'shubham', 'b-201,sec-19,airoli', '8898600239', 'shub09', 'zxc'),
(457, 'sunny', 'thane', '9323998570', 'sun09', 'werty'),
(458, 'sonu', 'nerul', '9773190293', 'son09', 'erty'),
(459, 'sanjay', 'mulund', '9323998594', 'san09', 'uiui'),
(461, 'nisha                  ', 'thane', '9619152737', 'nish09', 'yuyu');

-- --------------------------------------------------------

--
-- Table structure for table `Food`
--

CREATE TABLE IF NOT EXISTS `Food` (
  `foodid` int(11) NOT NULL,
  `foodname` varchar(20) DEFAULT NULL,
  `foodprice` double DEFAULT NULL,
  `foodtype` char(8) DEFAULT NULL,
  PRIMARY KEY (`foodid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Food`
--

INSERT INTO `Food` (`foodid`, `foodname`, `foodprice`, `foodtype`) VALUES
(1212, 'double cheese pizza', 270, 'non veg'),
(1222, 'spicy chicken wrap', 170, 'non veg'),
(1227, 'Aloo Tikki', 40, 'veg'),
(1313, 'chicken nuggets     ', 200, 'non veg'),
(1342, 'spicy cheese pizza', 470, 'non veg'),
(1453, 'pops                ', 77, 'veg');

-- --------------------------------------------------------

--
-- Table structure for table `Foodorder`
--

CREATE TABLE IF NOT EXISTS `Foodorder` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `totalbill` double DEFAULT NULL,
  `orderstatus` varchar(15) DEFAULT NULL,
  `orderdate` date DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `Foodorder`
--

INSERT INTO `Foodorder` (`orderid`, `customerid`, `totalbill`, `orderstatus`, `orderdate`) VALUES
(1, 456, 1110, 'delivered', '2016-06-21'),
(2, 457, 850, 'delivered', '2016-06-21'),
(3, 458, 540, 'Delivered', '2016-06-21');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
