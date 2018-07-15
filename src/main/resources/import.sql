-- REQUIRED DATA

INSERT INTO user_info (email, first_name, last_name, password, role, balance)
VALUES ('admin@smart-yatayat.com', 'Admin', '', '$2a$10$hSZPkOaff5Z0HxE17ZNiCOX7FSCGG.X7gM5xHduTC5qDJFA/vemXy', 0, 0);

INSERT INTO price_settings (setting_name, setting_value)
VALUES
('checkpointRate', '5'),
('minimumBalanceAllowed', '-10');

-- DUMMY DATA

INSERT INTO bus (bus_number, total_seats, standing_capacity)
VALUES
('BA66Pa4983', 35, 5),
('BA66Pa4984', 30, 5),
('BA66Pa4985', 35, 10),
('BA66Pa4986', 25, 0);

INSERT INTO checkpoint_info (checkpoint_name, longitude, latitude)
VALUES
('Checkpoint A', 38.798624, -77.530224),
('Checkpoint B', 38.798624, -77.530224),
('Checkpoint C', 38.798624, -77.530224),
('Checkpoint D', 38.798624, -77.530224),
('Checkpoint E', 38.798624, -77.530224),
('Checkpoint F', 38.798624, -77.530224);

INSERT INTO user_info (email, first_name, last_name, password, role, balance)
VALUES ('sag.pan@gmail.com', 'Sagun', 'Pandey', '$2a$10$hSZPkOaff5Z0HxE17ZNiCOX7FSCGG.X7gM5xHduTC5qDJFA/vemXy', 2, 0);

INSERT INTO rfid (tag0, tag1, tag2, tag3, pin)
VALUES
('1234', '1234', '1234', '1234', '0000'),
('4567', '4567', '4567', '4567', '0000');

INSERT INTO user_rfid (active, rfid_id, user_info_id)
VALUES
(0, 1, 2),
(1, 2, 2);

INSERT INTO bus_log (entry_type, passengers_count, time, bus_id, checkpoint_info_id)
VALUES
(0, 30, '2008-11-11 13:23:44', 1, 1),
(1, 38, '2008-11-11 13:23:44', 1, 1),
(1, 35, '2008-11-11 13:23:44', 2, 3),
(1, 32, '2008-11-11 13:23:44', 3, 4);

INSERT INTO bus_log (latitude, longitude, passengers_count, time, bus_id)
VALUES
(38.798624, -77.530224, 20, '2008-11-11 13:23:44', 4);
