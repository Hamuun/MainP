drop table if exists librarian CASCADE;
create table librarian
	(
			id integer primary key auto_increment,
			name varChar(255),
			pageNum varChar(255),
			author varChar(255),
            shelfNum varChar(255)
			
		);