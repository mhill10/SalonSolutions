DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `guestUser`;
DROP TABLE IF EXISTS `proUser`;
DROP TABLE IF EXISTS `reservationInfo`;
DROP TABLE IF EXISTS `clientServices`;
DROP TABLE IF EXISTS `proServices`;
DROP TABLE IF EXISTS `allServices`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `retailProducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allServices` (
                               `serviceId` int(11) NOT NULL AUTO_INCREMENT,
                               `serviceName` varchar(255) DEFAULT NULL,
                               `serviceDescription` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`serviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `userEmailAddress` varchar(255) NOT NULL,
                        `userPassword` varchar(255) NOT NULL,
                        `userDisplayName` varchar(255) DEFAULT NULL,
                        `userFirstName` varchar(255) NOT NULL,
                        `userLastName` varchar(255) NOT NULL,
                        `userPhone` varchar(12) NULL,
                        `userStreetAddress` varchar(255) DEFAULT NULL,
                        `userCity` varchar(255) DEFAULT NULL,
                        `userState` varchar(2) DEFAULT NULL,
                        `userZip` varchar(5) DEFAULT NULL,
                        `userProfilePic` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `userEmailAddress` (`userEmailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `user` VALUES (0, 'thehandyhairdresser@gmail.com', 'samplePassword', 'The Handy Hairdresser', 'Kacy', 'Bott', '608-271-7270', '6839 N. Old 92', 'Evansville', 'WI', '53536', 'smileyKacy.jpg');
INSERT INTO `user` VALUES (0, 'matthewbhill@gmail.com', 'samplePassword1', 'Mr. Cool Guy', 'Matthew', 'Hill', '608-219-8296', '6839 N. Old 92', 'Evansville', 'WI', '53536', 'smileyMatt.jpg');
INSERT INTO `user` VALUES (0, 'mjhill3@gmail.com', 'samplePassword3', 'Runner Freak', 'Michael', 'Hill', '608-999-6666', '1858 Mintwood Place, Apt 3', 'Washington', 'DC', '20009', 'smileyMikey.jpg');
INSERT INTO `user` VALUES (0, 'shill@starkhomes.com', 'samplePassword4', 'Mr. Real Estate', 'Stanley', '608-867-5309', 'Hill', '444 Richie Rd', 'Verona', 'WI', '53711', 'smileyStan.jpg');
INSERT INTO `user` VALUES (0, 'ssmmhill@juno.com', 'samplePassword5', 'Nurse in Charge', 'Sherry', 'Hill', '608-555-4444', '345 Sterling Dr', 'Oregon', 'WI', '53575', 'smileySherry.jpg');

CREATE TABLE `role` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `roleName` varchar(255) DEFAULT NULL,
                        `userEmailAddress` varchar(255) DEFAULT NULL,
                        `userId` int(11) NOT NULL,
                        PRIMARY KEY (`id`),
                        CONSTRAINT `role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
                        CONSTRAINT `role_ibfk_2` FOREIGN KEY (`userEmailAddress`) REFERENCES `user` (`userEmailAddress`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `role` VALUES (0, 'admin', 'thehandyhairdresser@gmail.com', 1);
INSERT INTO `role` VALUES (0, 'admin', 'matthewbhill@gmail.com', 2);
INSERT INTO `role` VALUES (0, 'guest', 'mjhill3@gmail.com', 3);

DROP TABLE IF EXISTS `clientServices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientServices` (
                                  `clientServiceId` int(11) NOT NULL AUTO_INCREMENT,
                                  `allServiceId` int(11) NOT NULL,
                                  `serviceDefaultStartDuration` int(11) DEFAULT 45,
                                  `serviceDefaultProcessDuration` int(11) DEFAULT NULL,
                                  `serviceDefaultEndDuration` int(11) DEFAULT NULL,
                                  PRIMARY KEY (`clientServiceId`),
                                  KEY `allServiceId` (`allServiceId`),
                                  CONSTRAINT `proservices_ibfk_1` FOREIGN KEY (`allServiceId`) REFERENCES `allservices` (`serviceId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
DROP TABLE IF EXISTS `reservationInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservationInfo` (
                                   `resId` int(11) NOT NULL AUTO_INCREMENT,
                                   `resSalonId` int(11) NOT NULL,
                                   `resServiceId` int(11) NOT NULL,
                                   `resDateTime` datetime DEFAULT NULL,
                                   PRIMARY KEY (`resId`),
                                   KEY `resSalonId` (`resSalonId`),
                                   KEY `resServiceId` (`resServiceId`),
                                   CONSTRAINT `reservationinfo_ibfk_1` FOREIGN KEY (`resSalonId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
                                   CONSTRAINT `reservationinfo_ibfk_2` FOREIGN KEY (`resServiceId`) REFERENCES `clientServices` (`clientServiceId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
DROP TABLE IF EXISTS `retailProducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retailProducts` (
                                  `productId` int(11) NOT NULL AUTO_INCREMENT,
                                  `productName` varchar(255) DEFAULT NULL,
                                  `productCost` decimal(10,2) NOT NULL,
                                  `productSalePrice` decimal(10,2) NOT NULL,
                                  `productDescription` varchar(255) DEFAULT NULL,
                                  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;