## Setting up environment variables to connect to database

1) Create a file called 'env' (without any extensions) and 
2) Fill this out with no spaces after the '='

```
DB_HOST=
DB_USERNAME=
DB_PASSWORD=
DB_PORT=
DB_NAME=
```

Example: 
```
DB_HOST=EXAMPLE.com
DB_USERNAME=USERNAME123
DB_PASSWORD=PASSWORD456
DB_PORT=3306
DB_NAME=DATABASENAME789
```

## Setting up gitignore

It is very important that you do not share the database information with anyone.
So you need to set up a .gitignore so that you will not accidentally push the 'env' file

1) Create a file called '.gitignore'
2) Inside .gitignore, write 'env' so git will ignore the 'env' file

## Writing code

Always work on features in a new branch. NEVER work directly from master

## Making queries to the database

Now when you run the program, it will automatically get all the information you need to
connect to the database and save them inside a Database object.

The Database object should only be used to perform queries so make sure to return the data back into main
and pass it to a new object or something.

## Database schema - Table information

```
CREATE TABLE `adherence_response` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `date` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Q2` int(10) unsigned NOT NULL,
  `Q3` int(10) unsigned NOT NULL,
  `Q4` int(10) unsigned NOT NULL,
  `Q5` int(10) unsigned NOT NULL,
  `Q6` int(10) unsigned NOT NULL,
  `Q7` int(10) unsigned NOT NULL,
  `Q8` int(10) unsigned NOT NULL,
  `Q9` int(10) unsigned NOT NULL,
  `Q10` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`,`date`)
);
```

```
CREATE TABLE `all_log` (
  `memberId` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `time` timestamp NOT NULL,
  `description` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`memberId`,`time`,`description`)
);
```

```
CREATE TABLE `behavior_score` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `motivation` double unsigned NOT NULL,
  `intention` double unsigned NOT NULL,
  `attitude` double unsigned NOT NULL,
  `ownership` double unsigned NOT NULL,
  PRIMARY KEY (`id`)
);
```

```
CREATE TABLE `selected_log` (
  `memberId` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `participantId` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time` timestamp NOT NULL,
  `description` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`memberId`,`time`,`description`)
);
```

```
CREATE TABLE `self_efficacy` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `date` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Q2` int(10) unsigned NOT NULL,
  `Q3` int(10) unsigned NOT NULL,
  `Q4` int(10) unsigned NOT NULL,
  `Q5` int(10) unsigned NOT NULL,
  `Q6` int(10) unsigned NOT NULL,
  `Q7` int(10) unsigned NOT NULL,
  `Q8` int(10) unsigned NOT NULL,
  `Q9` int(10) unsigned NOT NULL,
  `Q10` int(10) unsigned NOT NULL,
  `Q11` int(10) unsigned NOT NULL,
  `Q12` int(10) unsigned NOT NULL,
  `Q13` int(10) unsigned NOT NULL,
  `Q14` int(10) unsigned NOT NULL,
  `Q15` int(10) unsigned NOT NULL,
  `Q16` int(10) unsigned NOT NULL,
  `Q17` int(10) unsigned NOT NULL,
  `Q18` int(10) unsigned NOT NULL,
  `Q19` int(10) unsigned NOT NULL,
  `Q20` int(10) unsigned NOT NULL,
  `Q21` int(10) unsigned NOT NULL,
  `Q22` int(10) unsigned NOT NULL,
  `Q23` int(10) unsigned NOT NULL,
  `Q24` int(10) unsigned NOT NULL,
  `Q25` int(10) unsigned NOT NULL,
  `Q26` int(10) unsigned NOT NULL,
  `Q27` int(10) unsigned NOT NULL,
  `Q28` int(10) unsigned NOT NULL,
  `Q29` int(10) unsigned NOT NULL,
  `Q30` int(10) unsigned NOT NULL,
  `Q31` int(10) unsigned NOT NULL,
  `Q32` int(10) unsigned NOT NULL,
  `Q33` int(10) unsigned NOT NULL,
  `Q34` int(10) unsigned NOT NULL,
  `Q35` int(10) unsigned NOT NULL,
  `Q36` int(10) unsigned NOT NULL,
  `Q37` int(10) unsigned NOT NULL,
  `Q38` int(10) unsigned NOT NULL,
  `Q39` int(10) unsigned NOT NULL,
  `Q40` int(10) unsigned NOT NULL,
  `Q41` int(10) unsigned NOT NULL,
  `Q42` int(10) unsigned NOT NULL,
  `Q43` int(10) unsigned NOT NULL,
  `Q44` int(10) unsigned NOT NULL,
  `Q45` int(10) unsigned NOT NULL,
  `Q46` int(10) unsigned NOT NULL,
  `Q47` int(10) unsigned NOT NULL,
  `Q48` int(10) unsigned NOT NULL,
  `Q49` int(10) unsigned NOT NULL,
  `Q50` int(10) unsigned NOT NULL,
  `Q51` int(10) unsigned NOT NULL,
  `Q52` int(10) unsigned NOT NULL,
  `Q53` int(10) unsigned NOT NULL,
  `Q54` int(10) unsigned NOT NULL,
  `Q55` int(10) unsigned NOT NULL,
  `Q56` int(10) unsigned NOT NULL,
  `Q57` int(10) unsigned NOT NULL,
  `Q58` int(10) unsigned NOT NULL,
  `Q59` int(10) unsigned NOT NULL,
  `Q60` int(10) unsigned NOT NULL,
  `Q61` int(10) unsigned NOT NULL,
  `Q62` int(10) unsigned NOT NULL,
  `Q63` int(10) unsigned NOT NULL,
  `Q64` int(10) unsigned NOT NULL,
  `Q65` int(10) unsigned NOT NULL,
  `Q66` int(10) unsigned NOT NULL,
  `Q67` int(10) unsigned NOT NULL,
  `Q68` int(10) unsigned NOT NULL,
  `Q69` int(10) unsigned NOT NULL,
  `Q70` int(10) unsigned NOT NULL,
  `Q71` int(10) unsigned NOT NULL,
  `Q72` int(10) unsigned NOT NULL,
  `Q73` int(10) unsigned NOT NULL,
  `Q74` int(10) unsigned NOT NULL,
  `Q75` int(10) unsigned NOT NULL,
  `Q76` int(10) unsigned NOT NULL,
  `Q77` int(10) unsigned NOT NULL,
  `Q78` int(10) unsigned NOT NULL,
  `Q79` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`,`date`)
);
```