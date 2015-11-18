-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 09, 2015 at 10:39 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `clocms`
--
CREATE DATABASE IF NOT EXISTS `clocms` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `clocms`;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--
-- Creation: Sep 09, 2015 at 04:59 PM
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `idcategory` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`idcategory`, `nama`) VALUES
(1, 'kategori1'),
(2, 'kategori2'),
(3, 'coba');

-- --------------------------------------------------------

--
-- Table structure for table `post`
--
-- Creation: Sep 09, 2015 at 04:59 PM
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `idpost` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `body` longtext NOT NULL,
  `idcategory` int(11) NOT NULL,
  `idwriter` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`idpost`, `title`, `body`, `idcategory`, `idwriter`) VALUES
(1, 'pertama', '\r\n\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fringilla condimentum urna, eu blandit justo fringilla posuere. Curabitur eget arcu id nisl consectetur fringilla. Nullam quis arcu sem. Pellentesque varius imperdiet ornare. Donec et nulla pellentesque, mollis ipsum sit amet, tincidunt magna. In hac habitasse platea dictumst. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec dui est, suscipit molestie facilisis sed, posuere vel est.\r\n\r\nPellentesque congue congue metus interdum egestas. Sed neque erat, ultricies id odio ac, rhoncus euismod risus. Mauris dapibus sapien sit amet erat bibendum, quis lobortis nulla lobortis. Etiam luctus, dolor nec pulvinar tincidunt, neque augue euismod eros, in pretium turpis dolor nec dolor. Vivamus ornare, metus at facilisis luctus, nunc enim porta diam, non pretium nisi justo et nisi. Phasellus eget quam quam. Curabitur a euismod purus. Quisque id venenatis tellus. Aenean ullamcorper magna leo, id lobortis metus dignissim ac.\r\n\r\nNunc libero arcu, molestie at ultrices quis, tincidunt quis mi. Proin et dui ligula. Etiam aliquet feugiat laoreet. Aliquam malesuada pharetra felis, eget blandit quam auctor quis. Aenean pulvinar tempus mauris ut posuere. Maecenas pellentesque libero sapien, in lacinia enim tempus luctus. Mauris accumsan mauris neque, in varius arcu faucibus at. Morbi in pretium velit. Morbi lacinia ipsum nec dignissim rutrum. Suspendisse lorem nibh, tincidunt ut nulla nec, iaculis ultrices nisi. Etiam magna ante, eleifend nec posuere quis, faucibus in eros. Donec id dolor sed ligula scelerisque fermentum eget sed erat.\r\n\r\nUt feugiat id augue vitae porttitor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In nec elit vel nulla suscipit viverra. Phasellus pharetra ipsum sed hendrerit pretium. Duis ut lobortis massa. Vivamus nec augue condimentum, dignissim lectus et, sodales ipsum. Nulla in augue id arcu sollicitudin venenatis et vitae dolor. Nam scelerisque mauris orci, in finibus enim posuere in. Nulla vulputate, nunc sit amet auctor euismod, ante magna facilisis eros, eu iaculis mi urna a eros. Curabitur sit amet elit velit. Cras lobortis varius nibh, vitae porttitor metus tincidunt sed. Maecenas nec lorem interdum, iaculis tortor sed, vulputate enim. Morbi lectus nisl, eleifend at euismod et, lobortis sed neque. Donec a est eget diam efficitur vulputate vitae vitae libero.\r\n\r\nDonec risus enim, vulputate vitae libero vitae, semper ullamcorper orci. Mauris nec bibendum massa. Praesent sit amet mattis nibh. Nullam vel dolor et ipsum aliquam sagittis. Praesent non finibus dolor. Vestibulum volutpat id lacus sed finibus. Aenean congue ultricies metus id fringilla. In porttitor odio dolor. Donec semper ex sit amet tincidunt viverra. Donec dui mi, posuere non purus nec, scelerisque lobortis nibh.\r\n\r\nAliquam in ligula a felis interdum volutpat a quis odio. Nunc orci felis, laoreet in velit a, malesuada consequat massa. Suspendisse at urna congue, efficitur dolor in, facilisis risus. Sed porta sapien eu ipsum elementum, eget iaculis nunc vestibulum. Quisque volutpat tincidunt lectus. Sed condimentum est nulla, ac iaculis enim rutrum eu. Ut tincidunt interdum ligula, eget pretium tortor sagittis ac. Duis facilisis, metus ut imperdiet eleifend, nibh quam ullamcorper ipsum, bibendum varius quam mauris sed libero. Vestibulum hendrerit, odio vel elementum dictum, neque justo pulvinar orci, et malesuada ex ligula dapibus eros.\r\n\r\nMorbi venenatis nunc eu justo eleifend pulvinar. Curabitur et feugiat neque. Donec in dui condimentum, hendrerit dui ac, posuere quam. Praesent malesuada purus ac congue sodales. Mauris aliquam, augue facilisis mattis convallis, ex nulla semper dolor, ut vulputate quam quam vel mi. Ut feugiat felis sed lectus malesuada, facilisis pellentesque ipsum cursus. Ut volutpat, risus a aliquam ultrices, nulla purus maximus mauris, a ornare dui lectus et mauris. Nunc tortor lorem, accumsan id mollis eu, auctor vitae ligula. Nam et urna nec orci egestas porttitor. Pellentesque eget sapien eget est faucibus porttitor. Curabitur imperdiet ultricies venenatis. Vivamus vitae dolor dolor. Duis sed purus a metus rhoncus rutrum.\r\n\r\nEtiam vel nunc mauris. Vivamus vehicula justo et mauris accumsan ultrices. Phasellus odio erat, pretium sed massa et, molestie sagittis metus. Praesent vestibulum faucibus magna, in placerat augue feugiat at. Nullam volutpat pellentesque lectus vitae hendrerit. Integer varius elit nec suscipit vulputate. Maecenas porttitor fringilla eros, laoreet viverra nisl dictum quis. Ut sit amet aliquet justo. Nunc sodales nunc vitae consectetur laoreet. Nunc finibus luctus suscipit.\r\n\r\nNam aliquet eros ex, nec elementum erat scelerisque consequat. Etiam in erat at mi porta imperdiet vel a quam. Maecenas euismod massa at lectus laoreet, in egestas ante pellentesque. Integer congue ligula in enim commodo pellentesque. Suspendisse tristique faucibus ante et commodo. Etiam et aliquam orci. Vivamus tincidunt, odio vitae ullamcorper suscipit, enim arcu lacinia libero, nec imperdiet mauris lectus non est. Cras a cursus lorem. Nulla consequat libero ac lectus mattis, vel rutrum lacus scelerisque. Sed et dui pharetra, condimentum purus lacinia, elementum arcu. Etiam quis dolor orci. Quisque egestas, leo quis pulvinar fermentum, elit neque efficitur lorem, ut rutrum nisi enim ac sem. Vivamus nec mattis elit, eu elementum ipsum. Proin efficitur nulla vel sagittis dapibus. Nunc consectetur sem non lorem fringilla congue. Phasellus fermentum feugiat diam condimentum luctus.\r\n\r\nDonec vehicula sapien vitae tellus efficitur volutpat. Phasellus molestie justo sed cursus vestibulum. Nulla at ipsum at purus ultrices ullamcorper condimentum porta purus. Vivamus in lorem pellentesque, tincidunt ante non, tristique purus. Nullam massa enim, condimentum eu accumsan vel, feugiat quis sem. Morbi nec consectetur arcu. Donec porta iaculis vehicula. Morbi condimentum dui at nulla fermentum lacinia. Donec sit amet ante ligula.\r\n\r\nQuisque lobortis vitae diam eget euismod. Curabitur convallis, justo id tempus molestie, dui quam hendrerit magna, sit amet congue enim turpis ac lectus. Curabitur et mollis arcu, non sagittis mi. Nunc sed mattis justo, at varius ligula. Aenean convallis justo vehicula blandit cursus. Maecenas molestie, neque id pretium dapibus, sapien leo porttitor lectus, in blandit purus purus et mi. Sed ut varius dui, sit amet gravida quam. Phasellus consectetur massa risus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus euismod rhoncus rhoncus.\r\n\r\nInteger viverra sapien nec elit ultricies dictum. Integer fermentum ante eget velit venenatis laoreet. Ut eros massa, vehicula sit amet dui at, rhoncus luctus libero. Morbi non mattis ligula, nec facilisis libero. Integer porta vestibulum lacinia. Nam in facilisis augue. Morbi non massa finibus, molestie nunc sed, eleifend augue. Nulla facilisi. Fusce a enim et sapien porta sodales. Praesent maximus, enim at fringilla tincidunt, massa lacus dignissim nulla, eget fermentum odio nisi quis nulla. Quisque sit amet venenatis lacus. Vivamus rhoncus arcu sed enim porttitor, a lacinia nunc tempor. Vivamus pulvinar elit a dui feugiat, sed viverra ligula fermentum. Aliquam erat dolor, rutrum vel dictum ut, rutrum vel orci. Aenean egestas dignissim odio, sed ultrices ipsum tempus eget. Nam quis urna accumsan, laoreet lectus eget, fringilla nunc.\r\n\r\nAenean congue facilisis ex ac pellentesque. Etiam elit nulla, bibendum eu est rutrum, sollicitudin varius lectus. Fusce lacinia risus elit, quis luctus sapien egestas eu. Nulla placerat fringilla mi, id lacinia orci. Fusce consectetur, dui id facilisis elementum, nunc turpis interdum nisi, ac imperdiet ex tellus interdum justo. Pellentesque enim lacus, laoreet sit amet ornare quis, fringilla nec velit. Pellentesque sit amet arcu ac est dapibus ultrices ac vel arcu. Morbi tempus molestie elit ac pulvinar. Sed gravida iaculis sem, sed mattis dolor ullamcorper sit amet. Aliquam dolor libero, viverra ut massa laoreet, sagittis lobortis neque. Praesent porta odio sit amet purus congue, eu lobortis metus dictum.\r\n\r\nQuisque eu enim finibus nibh finibus fermentum. Nulla id est quam. Pellentesque lorem ipsum, consequat ac tellus quis, sagittis molestie augue. Fusce et placerat turpis. Duis tellus arcu, aliquam non nibh aliquet, viverra vulputate tellus. Etiam mauris justo, dignissim sit amet tincidunt vitae, tempor id nunc. Nulla molestie magna sapien, sit amet elementum turpis aliquet quis. Nulla sed ex lacinia, venenatis odio sit amet, porttitor velit. Donec et mollis urna. Quisque ac est massa. Maecenas eros diam, sodales eu aliquam non, dictum a mi. Praesent sagittis posuere neque ac feugiat.\r\n\r\nCurabitur at egestas erat. Curabitur placerat, felis non ornare porttitor, mi velit porta sapien, a iaculis nisi dolor eu odio. Nunc sagittis metus sit amet ante semper, eu venenatis erat fermentum. Maecenas nec magna tristique risus accumsan maximus consequat a massa. Mauris lacinia vestibulum tortor. Maecenas sagittis nisi sed tincidunt viverra. Phasellus luctus turpis nec nibh finibus, in blandit magna molestie. In elementum enim non viverra rutrum. Mauris dolor magna, consectetur sit amet lacinia et, feugiat ac felis. Praesent pretium ex dignissim sapien faucibus faucibus. Duis dignissim lacus in nulla lacinia tempor. Ut neque ipsum, iaculis id diam non, volutpat luctus risus. Morbi eu nisl sit amet nunc placerat ullamcorper.\r\n\r\nCurabitur varius enim mi, eu dignissim lacus porttitor id. Aenean id fringilla massa, a pretium felis. Sed eleifend aliquam semper. Integer tempus euismod vulputate. Aenean odio sem, varius nec ipsum ut, feugiat laoreet felis. Donec vel tortor vel enim egestas vestibulum quis in ante. Maecenas quam quam, pretium ac lectus id, faucibus varius dolor. Nunc eleifend neque bibendum metus condimentum rhoncus. Vivamus elementum vel nibh et semper. Aliquam euismod sagittis tortor et elementum. Maecenas a erat nec odio dignissim molestie. Nullam lacus lorem, fringilla sed volutpat id, vestibulum in purus. Donec dapibus velit ac libero aliquet, eu ullamcorper mauris venenatis. Mauris sem libero, rutrum in finibus eget, ultricies ac odio. Vivamus sed enim rhoncus, fermentum lectus vitae, condimentum odio.\r\n\r\nAenean in malesuada nisl. Pellentesque vitae metus pharetra, egestas eros id, pulvinar urna. Phasellus ut rhoncus est, eu scelerisque felis. Suspendisse eget scelerisque neque, sit amet sodales nunc. Nullam eget pretium neque, eget viverra lorem. Duis interdum magna sed ultricies commodo. Nam et felis dolor. Mauris vitae tellus odio. Duis posuere tortor sed ex euismod accumsan. Aenean nibh ligula, aliquet in libero eget, ornare dictum purus.\r\n\r\nCurabitur vel tellus vel elit placerat egestas. Praesent non vestibulum augue. Nulla sit amet ex justo. Proin feugiat tempor dictum. Vestibulum consectetur, nisi id placerat luctus, ligula orci rutrum arcu, ut iaculis justo justo id urna. Nam massa quam, consequat quis urna ac, lobortis aliquet urna. Pellentesque et nulla tincidunt, mollis lectus sed, fringilla metus.\r\n\r\nDonec dolor lorem, elementum vitae facilisis quis, ornare quis odio. Nullam gravida scelerisque metus non sodales. Etiam vel fringilla erat, at vehicula nisi. Vivamus ut elementum felis. Sed porttitor aliquet turpis eu pretium. Phasellus vel diam dapibus lacus cursus cursus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In eu urna ut nisi egestas faucibus id nec arcu. Phasellus id ipsum placerat mauris malesuada ultricies. Curabitur sit amet purus scelerisque ex efficitur bibendum. Proin non ipsum eu leo bibendum laoreet. Donec a nisl congue, pulvinar nibh ac, egestas mi.\r\n\r\nAenean mattis tortor at dui efficitur eleifend. Sed risus mauris, commodo sit amet diam id, sodales fringilla nulla. Donec vehicula tincidunt arcu, quis faucibus eros placerat a. Aenean est erat, dapibus vitae convallis vel, eleifend quis nisi. Donec consequat interdum porttitor. Nunc venenatis iaculis vestibulum. Pellentesque vulputate fermentum felis eu pellentesque. Nulla turpis tortor, rutrum eget malesuada a, imperdiet at quam. Integer imperdiet vestibulum vestibulum. Donec mattis viverra varius. Aenean feugiat porttitor leo, volutpat dictum sem efficitur eu. ', 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `writer`
--
-- Creation: Sep 09, 2015 at 04:59 PM
--

DROP TABLE IF EXISTS `writer`;
CREATE TABLE IF NOT EXISTS `writer` (
  `idwriter` int(11) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `bio` longtext NOT NULL,
  `foto` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `writer`
--

INSERT INTO `writer` (`idwriter`, `nama`, `bio`, `foto`) VALUES
(1, 'Dimas', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin eros pretium, mollis mauris ut, tristique purus. Pellentesque condimentum augue et lectus convallis scelerisque. Donec magna augue, pulvinar sed interdum sit amet, fringilla vitae purus. Fusce iaculis pharetra dictum. Donec egestas justo in leo efficitur rutrum. Nullam at sollicitudin odio. Nullam ullamcorper viverra augue, sit amet imperdiet augue molestie ut. Duis imperdiet libero quis odio molestie iaculis. Nullam orci enim, finibus sit amet suscipit eget, suscipit et massa. Sed odio lectus, molestie ac tortor vel, imperdiet pellentesque quam. Vestibulum ultricies odio id vulputate eleifend. Aliquam hendrerit tincidunt risus ultrices fermentum. ', '/img/1.jpg'),
(4, 'aquaman', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin eros pretium, mollis mauris ut, tristique purus. Pellentesque condimentum augue et lectus convallis scelerisque. Donec magna augue, pulvinar sed interdum sit amet, fringilla vitae purus. Fusce iaculis pharetra dictum. Donec egestas justo in leo efficitur rutrum. Nullam at sollicitudin odio. Nullam ullamcorper viverra augue, sit amet imperdiet augue molestie ut. Duis imperdiet libero quis odio molestie iaculis. Nullam orci enim, finibus sit amet suscipit eget, suscipit et massa. Sed odio lectus, molestie ac tortor vel, imperdiet pellentesque quam. Vestibulum ultricies odio id vulputate eleifend. Aliquam hendrerit tincidunt risus ultrices fermentum.</p>', '/img/aquaman.jpeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
 ADD PRIMARY KEY (`idcategory`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
 ADD PRIMARY KEY (`idpost`), ADD KEY `idwriter_idx` (`idwriter`), ADD KEY `idcategory_idx` (`idcategory`);

--
-- Indexes for table `writer`
--
ALTER TABLE `writer`
 ADD PRIMARY KEY (`idwriter`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `post`
--
ALTER TABLE `post`
ADD CONSTRAINT `idcategory` FOREIGN KEY (`idcategory`) REFERENCES `category` (`idcategory`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `idwriter` FOREIGN KEY (`idwriter`) REFERENCES `writer` (`idwriter`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
