DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `guestUser`;
DROP TABLE IF EXISTS `proUser`;
DROP TABLE IF EXISTS `reservationInfo`;
DROP TABLE IF EXISTS `clientServices`;
DROP TABLE IF EXISTS `proServices`;
DROP TABLE IF EXISTS `allServices`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `retailProducts`;
DROP TABLE IF EXISTS `allServices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allServices` (
                               `serviceId` int(11) NOT NULL AUTO_INCREMENT,
                               `serviceName` varchar(255) DEFAULT NULL,
                               `serviceDescription` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`serviceId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allServices`
--

LOCK TABLES `allServices` WRITE;
/*!40000 ALTER TABLE `allServices` DISABLE KEYS */;
INSERT INTO `allServices` VALUES (1,'Haircut','Spruce up your look by trimming the sides, back, thinning the top, getting the bangs out of your eyes, or switch your style completely.  Mohawk, anyone?'),(2,'Foil, Color, Cut','Our most prestigious service.  Custom color matching, application, and foils set to process at maximum strength.  Finish with relaxing scalp massage, haircut and blowdry style!'),(3,'Foil, Cut','Apply a splash of color to up to 3 sections of hair.  Either the same color for all three, or a combination of colors (a different one for each)');
/*!40000 ALTER TABLE `allServices` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `userEmailAddress` varchar(255) DEFAULT NULL,
                        `userPassword` varchar(255) DEFAULT NULL,
                        `userDisplayName` varchar(255) DEFAULT NULL,
                        `userFirstName` varchar(255) NOT NULL,
                        `userLastName` varchar(255) NOT NULL,
                        `userPhone` varchar(10) DEFAULT NULL,
                        `userStreetAddress` varchar(255) DEFAULT NULL,
                        `userCity` varchar(255) DEFAULT NULL,
                        `userState` varchar(2) DEFAULT NULL,
                        `userZip` varchar(5) DEFAULT NULL,
                        `userProfilePic` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `userEmailAddress` (`userEmailAddress`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'matthewbhill@gmail.com','samplePassword1','Mr. Cool Guy','Matthew','Hill',NULL,'6839 N. Old 92','Evansville','WI','53536','smileyMatt.jpg'),(2,'salonkb@gmail.com','samplePassword2','The Handy Hairdresser','Kacy','Bott',NULL,'6839 N. Old 92','Evansville','WI','53536','smileyKacy.jpg'),(3,'mjhill3@gmail.com','samplePassword3','Runner Freak','Michael','Hill',NULL,'1858 Mintwood Place, Apt 3','Washington','DC','20009','smileyMikey.jpg'),(4,'shill@starkhomes.com','samplePassword4','Mr. Real Estate','Stanley','Hill',NULL,'444 Richie Rd','Verona','WI','53711','smileyStan.jpg'),(5,'ssmmhill@juno.com','samplePassword5','Nurse in Charge','Sherry','Hill',NULL,'345 Sterling Dr','Oregon','WI','53575','smileySherry.jpg'),(6,'sallyRocks','sallyRocks',NULL,'Sally','OMalley',NULL,NULL,NULL,NULL,NULL,NULL),(7,'marcoRocks@hotmail.com','marcoRocks',NULL,'Marco','Polo',NULL,NULL,NULL,NULL,NULL,NULL),(8,'samRocks@hotmail.com','samRocks',NULL,'Sam','Smith',NULL,NULL,NULL,NULL,NULL,NULL),(9,'jillRocks@hotmail.com','jillRocks',NULL,'Jill','Sanderson',NULL,NULL,NULL,NULL,NULL,NULL),(10,'paulaRocks@hotmail.com','paulaRocks',NULL,'Paula','Waite',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `roleName` varchar(255) DEFAULT NULL,
                        `userEmailAddress` varchar(255) DEFAULT NULL,
                        `userId` int(11) NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `role_ibfk_1` (`userId`),
                        KEY `role_ibfk_2` (`userEmailAddress`),
                        CONSTRAINT `role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
                        CONSTRAINT `role_ibfk_2` FOREIGN KEY (`userEmailAddress`) REFERENCES `user` (`userEmailAddress`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','matthewbhill@gmail.com',1),(2,'guest','mjhill3@gmail.com',3),(3,'guest','sallyRocks',6),(4,'guest','marcoRocks@hotmail.com',7),(5,'guest','samRocks@hotmail.com',8),(6,'guest','jillRocks@hotmail.com',9),(7,'guest','paulaRocks@hotmail.com',10);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `clientServices`
--

DROP TABLE IF EXISTS `clientServices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientServices` (
                                  `clientServiceId` int(11) NOT NULL AUTO_INCREMENT,
                                  `clientId` int(11) NOT NULL,
                                  `allServiceId` int(11) NOT NULL,
                                  `serviceDefaultStartDuration` int(11) DEFAULT '45',
                                  `serviceDefaultProcessDuration` int(11) DEFAULT NULL,
                                  `serviceDefaultEndDuration` int(11) DEFAULT NULL,
                                  PRIMARY KEY (`clientServiceId`),
                                  KEY `allServiceId` (`allServiceId`),
                                  KEY `clientId___fk` (`clientId`),
                                  CONSTRAINT `clientId___fk` FOREIGN KEY (`clientId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                  CONSTRAINT `proservices_ibfk_1` FOREIGN KEY (`allServiceId`) REFERENCES `allservices` (`serviceId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientServices`
--

LOCK TABLES `clientServices` WRITE;
/*!40000 ALTER TABLE `clientServices` DISABLE KEYS */;
INSERT INTO `clientServices` VALUES (0, 2, 1, 45, 0, 0),(0, 3, 1, 60, 0, 0),(0, 6, 2, 45, 45, 45),(0, 2, 1, 45, 0, 0),(0, 4, 3, 35, 45, 35),(0, 5, 1, 45, 0, 0);
/*!40000 ALTER TABLE `clientServices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservationInfo`
--

DROP TABLE IF EXISTS `reservationInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservationInfo` (
                                   `resId` int(11) NOT NULL AUTO_INCREMENT,
                                   `resSalonId` int(11) NOT NULL,
                                   `resServiceId` int(11) NOT NULL,
                                   `resDateTime` datetime NOT NULL,
                                   `googleConfirmation` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`resId`),
                                   KEY `resSalonId` (`resSalonId`),
                                   KEY `resServiceId` (`resServiceId`),
                                   CONSTRAINT `reservationinfo_ibfk_1` FOREIGN KEY (`resSalonId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
                                   CONSTRAINT `reservationinfo_ibfk_2` FOREIGN KEY (`resServiceId`) REFERENCES `clientservices` (`clientServiceId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservationInfo`
--

LOCK TABLES `reservationInfo` WRITE;
/*!40000 ALTER TABLE `reservationInfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservationInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retailProducts`
--

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

--
-- Dumping data for table `retailProducts`
--

LOCK TABLES `retailProducts` WRITE;
/*!40000 ALTER TABLE `retailProducts` DISABLE KEYS */;
/*!40000 ALTER TABLE `retailProducts` ENABLE KEYS */;
UNLOCK TABLES;

