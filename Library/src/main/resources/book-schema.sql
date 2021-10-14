drop table if exists librarian CASCADE;
create table librarian
	(
			id integer primary key auto_increment,
			name varchar(255),
			pagenum varchar(255),
			author varchar(255),
            shelfnum varchar(255)
			
		);
			 