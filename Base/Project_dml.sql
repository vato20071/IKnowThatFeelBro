/* insert data */

insert into `category`
	(`name`)
values
	('ალკოჰოლიზმი'),
	('ანორექსია'),
	('ჩარჩენილი საგნები'),
	('გაკოტრება'),
	('მოწევა');

insert into `account`
	(`user_name`, `password`, `status`)
values
	('NutsaNutsa', 'chemidzma', '2'),
	('mariami', 'bezhka', '2'),
	('Vato20071', 'assasin', '0'),
	('elfi_gogo', 'dagchrit', '1'),
	('cxeni', 'mxsneli', '2'),
	('meskhi', 'kunkula', '2'),
	('cimaki', '010101', '2');

insert into `friendship`
	(`user1_ID`, `user2_ID`, `cat_ID`)
values
	('2', '1', '2'),
	('1', '2', '3'),
	('3', '2', '4'),
	('4', '1', '1');

/*-----------------------------------------------------------------------------------------*/

/* take info */

select user2_ID from friendship where user1_ID = 1 && cat_ID = 3

/*-----------------------------------------------------------------------------------------*/
