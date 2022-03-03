INSERT INTO rooms (room_id, room_name, capacity) VALUES
('A001', 'Official meeting', 10),
('C001001', 'Seminar', 30),
('X9999', 'Conference ', 100);

INSERT INTO equipments (equipment_id, room_id, equipment_name, equipment_count, equipment_remarks) VALUES
('10-1', 'A001', 'TV meeting', 1, NULL),
('20-1', 'A001', 'Projector', 1, 'With room'),
('40-50', 'C001001', 'Thin Client', 10, NULL),
('20-2', 'C001001', 'Projector', 5, 'Movable'),
('30-1', 'C001001', 'White board', 6, 'Movable');
