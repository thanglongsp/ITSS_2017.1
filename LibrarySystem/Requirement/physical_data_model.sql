
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
  `book_number` varchar(8) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `authors` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `isbn` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `borrower`
--

CREATE TABLE `borrower` (
  `user_id` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  `role` smallint(1) NOT NULL,
  `activation_code` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `card_id` int(11) NOT NULL,
  `expiration_date` date NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registration_book`
--

CREATE TABLE `registration_book` (
  `registration_id` int(11) NOT NULL,
  `book_number` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD KEY `sequence_number` (`sequence_number`),
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
  ADD PRIMARY KEY (`sequence_number`),
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
-- Indexes for table `registration_book`
--
ALTER TABLE `registration_book`
  ADD KEY `book_number` (`book_number`),
  ADD KEY `registration_id` (`registration_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

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
  ADD CONSTRAINT `borrowed-history_copy_ibfk_1` FOREIGN KEY (`sequence_number`) REFERENCES `copy` (`sequence_number`) ON DELETE CASCADE ON UPDATE CASCADE,
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

--
-- Constraints for table `registration_book`
--
ALTER TABLE `registration_book`
  ADD CONSTRAINT `registration_book_ibfk_1` FOREIGN KEY (`book_number`) REFERENCES `book` (`book_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `registration_book_ibfk_2` FOREIGN KEY (`registration_id`) REFERENCES `registration` (`registration_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
