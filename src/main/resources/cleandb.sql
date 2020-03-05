DROP TABLE IF EXISTS `guestUser`;

DROP TABLE IF EXISTS `proUser`;

DROP TABLE IF EXISTS `reservationInfo`;

DROP TABLE IF EXISTS `clientServices`;

DROP TABLE IF EXISTS `proServices`;

DROP TABLE IF EXISTS `allServices`;
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
                        `userId` int(11) NOT NULL AUTO_INCREMENT,
                        `userEmailAddress` varchar(255) DEFAULT NULL,
                        `userPassword` varchar(255) DEFAULT NULL,
                        `userDisplayName` varchar(255) DEFAULT NULL,
                        `userFirstName` varchar(255) NOT NULL,
                        `userLastName` varchar(255) NOT NULL,
                        `userStreetAddress` varchar(255) DEFAULT NULL,
                        `userCity` varchar(255) DEFAULT NULL,
                        `userState` varchar(2) DEFAULT NULL,
                        `userZip` varchar(5) DEFAULT NULL,
                        `userProfilePic` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`userId`),
                        UNIQUE KEY `userEmailAddress` (`userEmailAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



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
                                   CONSTRAINT `reservationinfo_ibfk_1` FOREIGN KEY (`resSalonId`) REFERENCES `user` (`userId`) ON DELETE CASCADE,
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

