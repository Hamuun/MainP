drop table if exists books CASCADE;
create table books
	(
			id integer primary key auto_increment,
			name varChar(255),
			pageNum varChar(255),
			author varChar(255),
            shelfNum varChar(255)
			
		);
			 