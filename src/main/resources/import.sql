SET IDENTITY_INSERT user_info ON;
INSERT INTO user_info (user_info_id, email, first_name, last_name, password, role, balance)
VALUES (1, 'admin@smart-yatayat.com', 'Admin', '', '$2a$10$hSZPkOaff5Z0HxE17ZNiCOX7FSCGG.X7gM5xHduTC5qDJFA/vemXy', 0, 0);
SET IDENTITY_INSERT user_info OFF;