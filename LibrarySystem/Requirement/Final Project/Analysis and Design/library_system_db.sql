-- phpMyAdmin SQL Dump
-- version 4.7.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2017 at 10:15 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_system_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `user_id` int(11) NOT NULL,
  `start_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_number` varchar(6) NOT NULL DEFAULT '',
  `publisher` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `authors` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `isbn` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_number`, `publisher`, `title`, `authors`, `status`, `isbn`) VALUES
('12', 'zczc', 'a', 'ac', 3, 'sdada'),
('312', '1', '1', '1', 0, '1'),
('424', 'adsad', 'áda', 'ád', 0, 'ads'),
('coo', 'coo', 'cool', 'coo', 1, 'coo'),
('dating', 'skrrrra', 'goes', 'pa pa ', 0, 'kakaka'),
('it1230', 'mr something guy', 'it1234book', 'same', 1, '12345isbnfkoff'),
('it1231', 'mr something guy', 'it1234book', 'same', 1, '12345isbnfkoff'),
('it1233', 'mr something guy', 'it1234book', 'same', 1, '12345isbnfkoff'),
('it1234', 'mr something guy', 'it1234book', 'same', 1, '12345isbnfkoff'),
('it8212', 'b', 'a', 'c', 1, 'd'),
('it9233', 'a', 'a', 'a', 0, 'a'),
('it9234', 'nha nam', 'clgt book', 'phagi boye', 2, '1432r232r');

-- --------------------------------------------------------

--
-- Table structure for table `borrowed-history`
--

CREATE TABLE `borrowed-history` (
  `history_id` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  `borrowed-date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `borrowed-history_copy`
--

CREATE TABLE `borrowed-history_copy` (
  `history_id` int(11) NOT NULL,
  `sequence_number` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `book_number` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `borrower`
--

CREATE TABLE `borrower` (
  `user_id` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  `role` smallint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrower`
--

INSERT INTO `borrower` (`user_id`, `card_id`, `role`) VALUES
(232324, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `card_id` int(11) NOT NULL,
  `expiration_date` date NOT NULL,
  `name` varchar(50) NOT NULL,
  `activation_code` varchar(30) NOT NULL,
  `status` int(10) UNSIGNED NOT NULL,
  `birthday` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`card_id`, `expiration_date`, `name`, `activation_code`, `status`, `birthday`) VALUES
(1, '2018-12-05', 'Trinh Thien Long', 'akdhaskjd', 0, '1996-11-23'),
(2, '2017-12-31', 'Trinh Thien Long', '0agrew3', 1, '2017-12-01');

-- --------------------------------------------------------

--
-- Table structure for table `copy`
--

CREATE TABLE `copy` (
  `sequence_number` int(11) NOT NULL,
  `book_number` varchar(8) NOT NULL,
  `type_of_copy` varchar(15) NOT NULL,
  `price` float NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `copy`
--

INSERT INTO `copy` (`sequence_number`, `book_number`, `type_of_copy`, `price`, `status`) VALUES
(1, 'coo', '0', 3.2, 2),
(4, '12', '0', 125.3, 1),
(5, 'coo', '2', 42, 2),
(6, 'coo', '2', 42, 1),
(7, 'coo', '2', 42, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hust-student`
--

CREATE TABLE `hust-student` (
  `user_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `graduation_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `user_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `salary` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `registration_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `registered_date` date NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `book_number` varchar(6) NOT NULL,
  `sequence_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`registration_id`, `user_id`, `registered_date`, `status`, `book_number`, `sequence_number`) VALUES
(2, 232324, '2017-12-09', 0, 'coo', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(15) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `contact` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `role`, `gender`, `contact`, `email`, `status`) VALUES
(123, 'a', 'a', '1', 'a', 231, 'adsasd', 1),
(232323, 'pnam2311', '1', '3', '1', 1, '1', 1),
(232324, 'long', 'long', '1', '1', 1296010296, 'long@gmail.com', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_number`);

--
-- Indexes for table `borrowed-history`
--
ALTER TABLE `borrowed-history`
  ADD PRIMARY KEY (`history_id`),
  ADD KEY `card_id` (`card_id`);

--
-- Indexes for table `borrowed-history_copy`
--
ALTER TABLE `borrowed-history_copy`
  ADD KEY `history_id` (`history_id`);

--
-- Indexes for table `borrower`
--
ALTER TABLE `borrower`
  ADD KEY `card_id` (`card_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`card_id`);

--
-- Indexes for table `copy`
--
ALTER TABLE `copy`
  ADD KEY `book_number` (`book_number`);

--
-- Indexes for table `hust-student`
--
ALTER TABLE `hust-student`
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`registration_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `registration_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=232325;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `borrowed-history`
--
ALTER TABLE `borrowed-history`
  ADD CONSTRAINT `borrowed-history_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `borrowed-history_copy`
--
ALTER TABLE `borrowed-history_copy`
  ADD CONSTRAINT `borrowed-history_copy_ibfk_2` FOREIGN KEY (`history_id`) REFERENCES `borrowed-history` (`history_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `borrower`
--
ALTER TABLE `borrower`
  ADD CONSTRAINT `borrower_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `borrower_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `copy`
--
ALTER TABLE `copy`
  ADD CONSTRAINT `copy_ibfk_1` FOREIGN KEY (`book_number`) REFERENCES `book` (`book_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hust-student`
--
ALTER TABLE `hust-student`
  ADD CONSTRAINT `hust-student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `borrower` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `librarian`
--
ALTER TABLE `librarian`
  ADD CONSTRAINT `librarian_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `registration`
--
ALTER TABLE `registration`
  ADD CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `borrower` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
