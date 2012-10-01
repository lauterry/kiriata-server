CREATE TABLE IF NOT EXISTS `Movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `lastWatched` date DEFAULT NULL unique,
  `rate` int DEFAULT -1,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
  );


INSERT INTO `Movie` (`id`, `code`, `status`, `lastWatched`, `rate`, `comment`) VALUES
(1, '61282', 'seen', '2012-09-05', '5', 'Super film. La 3D est géniale.');