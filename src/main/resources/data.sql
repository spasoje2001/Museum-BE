-- var password = username;
INSERT INTO _user(email, username, password, first_name, last_name, role, is_account_locked) VALUES
    ('nikolicveljko01@gmail.com', 'veljko', '$2a$10$kVZ6MkAdppKk5GtbzjsgbubBx1Uos0EOTdiY9mIBA5XwWy1ezVQam', 'Veljko', 'Nikolić', 0, false),
    ('vule.dok@gmail.com', 'dokma', '$2a$10$jicdgzoNyODhfwtEuXsYHelIRjzFZ5zIgqcXlHfoy9BROPAnWV2y2', 'Vukašin', 'Dokmanović', 0, false),
    ('spale01@gmail.com', 'spale', '$2a$10$NhX4GkvqpZTas4mZa9wxuevS.8VCi70t3tKXVekdD5/VCg2Hf.kAu', 'Spasoje', 'Brborić', 0, false),
    ('kuzminacn@gmail.com', 'nina', '$2a$10$XxmC.cIEK6XvYUVOa2HvTOlMQlIk0J6oQYouW2iBdgob.sRv78W9C', 'Nina', 'Kuzminac', 0, false),
    ('admin@gmail.com', 'admin', '$2a$12$zSJwNzNr/uFw.a9H5YRus.gQhZ.hjaNxhads7618x/U8KTFCPUnde', 'Admin', 'Adminovski', 4, false),
    ('organizer@gmail.com', 'organizer', '$2a$10$KVAfGs.glFRaekHlH3OWaeUASPrUMoh7MBuNu8DYT/SzRnvD9ZjL6', 'Organizator', 'Organizatorović', 1, false),
    ('curator@gmail.com', 'curator', '$2a$10$JGckcPY5eO8/1.xE7h7KmuH0A4gNif6PDSxBzUbxsThjQTTu.Nyai', 'Kustos', 'Kustosović', 2, false),
    ('restaurateur@gmail.com', 'restaurateur', '$2a$10$tdoK34QObn2cUrANXLUzveWSSdkMuaT/EkN4RCzqmIjaAH0ze8PNW', 'Restaurator', 'Restaruatorović', 3, false);

INSERT INTO guest(id, biography) VALUES
    (1, 'I am passionate about ancient civilizations, always seeking to uncover the mysteries of the past within museum walls.'),
    (2, 'I am interested in narco cartel history.'),
    (3, 'I am passionate about unraveling ancient civilizations and love exploring museums for insights.'),
    (4, 'Dedicated to preserving cultural heritage, advocating for the importance of museums in safeguarding our collective history.');

INSERT INTO administrator(id, biography) VALUES
    (5, 'Dedicated to preserving everything right as admin.');

INSERT INTO organizer(id, biography) VALUES
    (6, 'I love organizing stuff.');

INSERT INTO curator(id, biography) VALUES
    (7, 'I love artifacts.');
    
INSERT INTO restaurateur(id, biography) VALUES
    (8, 'I love restoring stuff.');

INSERT INTO room(name, floor, number) VALUES
    ('Main room', '1', '10');

INSERT INTO exhibition
(name, picture, short_description, long_description, theme, status, start_date, end_date, price, organizer_id, curator_id)
VALUES
    ('Ancient Civilizations Unveiled',
     'https://cdn.pixabay.com/photo/2024/03/27/01/21/ai-generated-8657978_640.png',
     'Discover the secrets of ancient civilizations',
     'Unearth the legacies of ancient societies through immersive exhibits and authentic artifacts that tell a story of innovation and discovery.',
     'ANCIENT_HISTORY', 'OPEN', '2024-04-01', '2024-04-30', 10, 6, 7);

INSERT INTO exhibition
(name, picture, short_description, long_description, theme, status, start_date, end_date, price, organizer_id, curator_id)
VALUES
    ('Medieval Treasures',
     'https://cdn.pixabay.com/photo/2024/04/02/02/24/ai-generated-8669925_640.png',
     'Explore the medieval era',
     'Delve into the Middle Ages with treasures that reveal the daily life, art, and the grandeur of a time cloaked in both darkness and enlightenment.',
     'MEDIEVAL_HISTORY', 'READY_TO_OPEN', '2024-05-15', '2024-06-15', 12, 6, 7);

INSERT INTO exhibition
(name, picture, short_description, long_description, theme, status, start_date, end_date, price, organizer_id, curator_id)
VALUES
    ('Military History: Triumphs and Tragedies',
     'https://cdn.pixabay.com/photo/2020/04/19/17/44/war-5064697_640.jpg',
     'Explore the triumphs and tragedies of military history',
     'Explore pivotal moments of military history, showcasing the tactics, artifacts, and personal stories that echo through time.',
     'MILITARY_HISTORY', 'READY_TO_OPEN', '2024-09-01', '2024-09-30', 12, 6, 7);

INSERT INTO room_reservation (room_id, start_date_time, end_date_time, exhibition_id)
VALUES (1, '2024-04-01 09:00:00', '2024-04-30 17:00:00', 1);
INSERT INTO room_reservation (room_id, start_date_time, end_date_time, exhibition_id)
VALUES (1, '2024-05-15 09:00:00', '2024-06-15 17:00:00', 2);
INSERT INTO room_reservation (room_id, start_date_time, end_date_time, exhibition_id)
VALUES (1, '2024-09-01 09:00:00', '2024-09-30 17:00:00', 3);

INSERT INTO item (name, description, authors_name, year_of_creation, period, category, picture, room_id)
VALUES ('Ancient Artifact', 'A unique artifact from an ancient civilization', 'Unknown', '1000 BC', 'Ancient', 'POTTERY', 'https://cdn.pixabay.com/photo/2022/02/08/17/00/nefertiti-statue-7001723_640.jpg', 1);
INSERT INTO item (name, description, authors_name, year_of_creation, period, category, picture, room_id)
VALUES ('Medieval Manuscript', 'An illuminated manuscript from the medieval era', 'Unknown', '1200 AD', 'Medieval', 'JEWELRY', 'https://cdn.pixabay.com/photo/2023/07/07/14/29/medieval-goblet-8112741_640.png', 1);
INSERT INTO item (name, description, authors_name, year_of_creation, period, category, picture, room_id)
VALUES ('World War II Memorabilia', 'Artifacts and memorabilia from the World War II era', 'Unknown', '1939-1945', '20th Century', 'SCULPTURE', 'https://cdn.pixabay.com/photo/2015/07/05/21/38/tank-832810_640.jpg', 1);

INSERT INTO item_reservation (item_id, start_date_time, end_date_time, room_reservation_id)
VALUES (1, '2024-04-01 09:00:00', '2024-04-30 17:00:00', 1);
INSERT INTO item_reservation (item_id, start_date_time, end_date_time, room_reservation_id)
VALUES (2, '2024-05-15 09:00:00', '2024-06-15 17:00:00', 2);
INSERT INTO item_reservation (item_id, start_date_time, end_date_time, room_reservation_id)
VALUES (3, '2024-09-01 09:00:00', '2024-09-30 17:00:00', 3);

-- Insert an exhibition focusing on military history




