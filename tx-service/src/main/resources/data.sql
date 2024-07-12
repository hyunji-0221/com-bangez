-- select * from points;

insert into points (point, user_id, last_charge_date)
values (10, 101, DATE_FORMAT(NOW(), '%Y-%m-%d/%H:%i:%s'));
