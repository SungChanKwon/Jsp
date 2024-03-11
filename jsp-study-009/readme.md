create table employees(
    id VARCHAR2(10) not null,
    pass VARCHAR2(10) not null,
    name VARCHAR2(24),
    lev CHAR(1) DEFAULT 'A',
    enter date DEFAULT sysdate,
    gender char(1) default '1',
    phone VARCHAR2(30),
    PRIMARY KEY (id)
);



insert into employees values('test', '1234', '권성찬', '2', sysdate, '1',
                                '010-1111-2222');

INSERT INTO EMPLOYEES
VALUES('admin','1111','정운영','A',TO_DATE('2014/04/17','yy/mm/dd'), '1', '010-1111-1111');

INSERT INTO EMPLOYEES
VALUES('subin','2222','전수빈','B',TO_DATE('2014/04/17','yy/mm/dd'), '2', '010-2222-2222');

INSERT INTO EMPLOYEES
VALUES('pinksung','3333','성윤정','A',TO_DATE('2014/04/17','yy/mm/dd'), '2', '010-2222-2222');

commit;