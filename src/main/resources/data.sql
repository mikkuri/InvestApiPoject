
-- drop table goods if exists;
--
-- create table goods (
--     /*
--      String title;
--
--     int totalInvestingAmount;
--
--     int nowInvestingAmount;
--
--     int numberOfInvestors;
--
--     boolean recruitmentStatus;
--
--     Date startedAt;
--
--     Date finishedAt;
--
--      */
--                        product_id bigint not null,
--                        title varchar(255),
--                        total_investing_amount int,
--                        now_investing_amount int,
--                        number_of_investors int,
--                        recruitment_status boolean,
--                        started_at datetime,
--                        finished_at datetime,
--                        primary key (product_id)
-- );

call next value for hibernate_sequence;
insert into goods (
    product_id,
    title,
    total_investing_amount,
    now_investing_amount,
    number_of_investors,
    recruitment_status,
    started_at,
    finished_at,
    created_at,
    updated_at
) VALUES (
          1, '개인신용포트폴리오', 1000000, 0, 0, true, '2021-05-17', '2021-05-31', now(), now()
          );

call next value for hibernate_sequence;
insert into goods (
    product_id,
    title,
    total_investing_amount,
    now_investing_amount,
    number_of_investors,
    recruitment_status,
    started_at,
    finished_at,
    created_at,
    updated_at
)
VALUES (
           2, '부동산포트폴리오', 5000000, 0, 0, true, '2021-05-16', '2021-05-20', now(), now()
       );

call next value for hibernate_sequence;
insert into goods (
    product_id,
    title,
    total_investing_amount,
    now_investing_amount,
    number_of_investors,
    recruitment_status,
    started_at,
    finished_at,
    created_at,
    updated_at
)
VALUES (
           3, '마감포트폴리오', 5000000, 0, 0, false, '2021-05-16', '2021-05-17', now(), now()
       );
