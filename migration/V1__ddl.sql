DROP TABLE IF EXISTS CARTITEM;
CREATE TABLE CARTITEM
  (
     id         BIGINT NOT NULL,
     userid     BIGINT NOT NULL,
     itemid     BIGINT NOT NULL,
     itemname   VARCHAR(255),
     quantity   BIGINT NOT NULL,
     PRIMARY KEY (id)
  );

DROP SEQUENCE IF EXISTS CartItemSeq;
CREATE SEQUENCE CartItemSeq INCREMENT 1 MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


Insert Into CartItem (id,userid,itemid,itemname,quantity)
VALUES (1,44,9,'esse',2),(2,35,6,'qui',4),(3,17,7,'dicta',7),(4,10,3,'fuga',3),(5,30,1,'omnis',2),(6,26,3,'magnam',2),(7,45,8,'rem',6),(8,40,4,'quo',1),(9,42,7,'sit',6),(10,1,6,'nihil',7),(11,7,3,'voluptatem',9),(12,12,8,'asperiores',4),(13,6,3,'dolorum',1),(14,50,4,'rerum',6),(15,26,7,'modi',7),(16,50,2,'vitae',7),(17,43,2,'aliquam',1),(18,30,3,'quis',4),(19,15,8,'fuga',7),(20,3,9,'consequuntur',4),(21,41,6,'et',3),(22,14,9,'provident',8),(23,11,5,'fugiat',4),(24,9,8,'quis',5),(25,50,6,'debitis',3),(26,26,8,'quas',4),(27,3,1,'magni',2),(28,41,1,'tempora',1),(29,41,2,'porro',5),(30,28,2,'autem',1),(31,29,5,'aut',2),(32,30,1,'non',4),(33,8,3,'aut',9),(34,30,2,'mollitia',2),(35,10,5,'fugit',4),(36,38,9,'recusandae',4),(37,3,8,'nihil',4),(38,43,6,'natus',6),(39,45,3,'sit',4),(40,29,6,'voluptas',9),(41,2,3,'rem',4),(42,23,8,'aspernatur',5),(43,34,4,'pariatur',7),(44,22,7,'praesentium',6),(45,44,4,'commodi',8),(46,44,2,'animi',6),(47,2,9,'velit',2),(48,35,7,'adipisci',4),(49,27,7,'velit',8),(50,33,7,'numquam',2),(51,28,9,'voluptatem',4),(52,26,7,'amet',7),(53,37,6,'eligendi',5),(54,16,6,'est',9),(55,20,2,'iusto',8),(56,26,2,'et',2),(57,25,2,'expedita',8),(58,27,5,'aut',2),(59,1,6,'voluptate',7),(60,11,8,'impedit',6),(61,48,7,'aperiam',4),(62,3,4,'tempora',8),(63,49,2,'id',4),(64,33,5,'id',9),(65,21,8,'mollitia',9),(66,1,3,'sint',3),(67,33,7,'consequuntur',2),(68,44,4,'nihil',6),(69,36,3,'illum',1),(70,12,1,'sunt',9),(71,20,1,'ratione',8),(72,28,7,'doloremque',4),(73,20,4,'dolorem',8),(74,24,8,'vel',3),(75,43,4,'pariatur',3),(76,33,1,'dolor',5),(77,12,9,'fugiat',2),(78,12,4,'eius',2),(79,21,9,'est',8),(80,50,5,'est',4),(81,48,7,'nobis',5),(82,1,7,'voluptatum',6),(83,2,6,'ratione',6),(84,49,2,'officia',6),(85,40,6,'ipsa',7),(86,43,8,'vel',1),(87,28,5,'sed',8),(88,16,2,'illo',6),(89,23,4,'est',3),(90,34,6,'pariatur',2),(91,22,3,'aut',7),(92,8,1,'nisi',6),(93,25,8,'sequi',6),(94,43,2,'quisquam',8),(95,5,7,'nam',5),(96,10,1,'aut',7),(97,9,9,'esse',2),(98,3,1,'maiores',6),(99,48,5,'voluptatem',2),(100,36,5,'quasi',9);