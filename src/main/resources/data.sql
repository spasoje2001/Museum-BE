-- var password = username;
--ALTER TABLE exhibition ALTER COLUMN long_description TYPE TEXT;



INSERT INTO _user(email, username, password, first_name, last_name, role, is_account_locked, picture) VALUES
    ('nikolicveljko01@gmail.com', 'veljko', '$2a$10$kVZ6MkAdppKk5GtbzjsgbubBx1Uos0EOTdiY9mIBA5XwWy1ezVQam', 'Veljko', 'Nikolić', 0, false, 'https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cG9ydHJhaXR8ZW58MHx8MHx8fDA%3D'),
    ('vule.dok@gmail.com', 'dokma', '$2a$10$jicdgzoNyODhfwtEuXsYHelIRjzFZ5zIgqcXlHfoy9BROPAnWV2y2', 'Vukašin', 'Dokmanović', 0, false, 'https://plus.unsplash.com/premium_photo-1683121771856-3c3964975777?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fHBvcnRyYWl0fGVufDB8fDB8fHww'),
    ('spale01@gmail.com', 'spale', '$2a$10$NhX4GkvqpZTas4mZa9wxuevS.8VCi70t3tKXVekdD5/VCg2Hf.kAu', 'Spasoje', 'Brborić', 0, false, 'https://images.unsplash.com/photo-1519699047748-de8e457a634e?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHBvcnRyYWl0fGVufDB8fDB8fHww'),
    ('kuzminacn@gmail.com', 'nina', '$2a$10$XxmC.cIEK6XvYUVOa2HvTOlMQlIk0J6oQYouW2iBdgob.sRv78W9C', 'Nina', 'Kuzminac', 0, false, 'https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8cG9ydHJhaXR8ZW58MHx8MHx8fDA%3D'),
    ('admin@gmail.com', 'admin', '$2a$12$zSJwNzNr/uFw.a9H5YRus.gQhZ.hjaNxhads7618x/U8KTFCPUnde', 'Admin', 'Adminovski', 3, false, 'https://images.unsplash.com/photo-1544005313-94ddf0286df2?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fHBvcnRyYWl0fGVufDB8fDB8fHww'),
    ('organizer@gmail.com', 'organizer', '$2a$10$KVAfGs.glFRaekHlH3OWaeUASPrUMoh7MBuNu8DYT/SzRnvD9ZjL6', 'Organizator', 'Organizatorović', 1, false, 'https://images.unsplash.com/photo-1526510747491-58f928ec870f?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHBvcnRyYWl0fGVufDB8fDB8fHww'),
    ('curator@gmail.com', 'curator', '$2a$10$JGckcPY5eO8/1.xE7h7KmuH0A4gNif6PDSxBzUbxsThjQTTu.Nyai', 'Kustos', 'Kustosović', 2, false, '');


INSERT INTO guest(id, biography) VALUES
    (1, 'I am passionate about ancient civilizations, always seeking to uncover the mysteries of the past within museum walls.'),
    (2, 'I am interested in the captivating world of ancient civilizations and the rich tapestry of mythologies they cherished.'),
    (3, 'I am passionate about unraveling ancient civilizations and love exploring museums for insights.'),
    (4, 'Dedicated to preserving cultural heritage, advocating for the importance of museums in safeguarding our collective history.');

INSERT INTO administrator(id, biography) VALUES
    (5, 'Dedicated to preserving everything right as admin.');

INSERT INTO organizer(id, biography) VALUES
    (6, 'I love organizing stuff.');

INSERT INTO curator(id, biography) VALUES
    (7, 'I love artifacts.');

-- Insert Rooms (without the 'floor' field)
INSERT INTO room(name, number) VALUES
    ('Main room', '101'),
    ('Side room', '121'),
    ('Front room', '203');

INSERT INTO exhibition_pricelist(adult_ticket_price, minor_ticket_price) VALUES
    (10, 5),   -- Price List 1
    (12, 6),   -- Price List 2
    (15, 8);   -- Price List 3


INSERT INTO room_reservation(room_id, start_date, end_date) VALUES
    (1, '2024-04-01', '2024-04-30'),
    (2, '2024-05-15', '2024-09-15'),
    (3, '2024-09-01', '2024-09-30');


INSERT INTO exhibition_proposal(start_date, end_date, organizer_id, room_reservation_id, pricelist_id, proposal_date) VALUES
    ('2024-04-01', '2024-04-30', 6, 1, 1, '2024-03-15'),
    ('2024-05-15', '2024-09-15', 6, 2, 2, '2024-04-01'),
    ('2024-09-01', '2024-09-30', 6, 3, 3, '2024-08-01');



-- Insert Exhibitions (assuming exhibition_proposal is a related table or a part of the insertion process)
INSERT INTO exhibition
(name, picture, short_description, long_description, theme, status, curator_id, exhibition_proposal_id)
VALUES
    ('Ancient Civilizations Unveiled',
     'https://cdn.pixabay.com/photo/2024/03/27/01/21/ai-generated-8657978_640.png',
     'Discover the secrets of ancient civilizations',
     'Unearth the legacies of ancient societies through immersive exhibits and authentic artifacts that tell a story of innovation and discovery.',
     'ANCIENT_HISTORY', 'CLOSED', 7, 1);

INSERT INTO exhibition
(name, picture, short_description, long_description, theme, status, curator_id, exhibition_proposal_id)
VALUES
    ('Medieval Treasures',
     'https://cdn.pixabay.com/photo/2024/04/02/02/24/ai-generated-8669925_640.png',
     'Explore the medieval era',
     'Delve into the Middle Ages with treasures that reveal the daily life, art, and the grandeur of a time cloaked in both darkness and enlightenment.',
     'MEDIEVAL_HISTORY', 'OPENED', 7, 2);

INSERT INTO exhibition
(name, picture, short_description, long_description, theme, status, curator_id, exhibition_proposal_id)
VALUES
    ('Military History: Triumphs and Tragedies',
     'https://cdn.pixabay.com/photo/2020/04/19/17/44/war-5064697_640.jpg',
     'Explore the triumphs and tragedies of military history',
     'Explore pivotal moments of military history, showcasing the tactics, artifacts, and personal stories that echo through time.',
     'MILITARY_HISTORY', 'READY_TO_OPEN', 7, 3);

-- Insert Items
INSERT INTO item(category, id, authors_name, description, name, period, picture, year_of_creation) VALUES
    (0, -1, 'Leonardo da Vinci', 'Slika zene sa tajanstvenim osmehom', 'Mona Lisa', 'Renaissance', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fspokenvision.com%2Fwp-content%2Fuploads%2F2017%2F03%2FMona-Lisa-770x876.jpg&f=1&nofb=1&ipt=f33b774de9794bf6413fd7e4c1b323f2c6cf2e170382753993da0a7b53706043&ipo=images', '1503'),
    (0, -2, 'Leonardo da Vinci', 'Momenat Judine izdaje', 'Tajna večera', 'Renaissance', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fbanjalucanke.com%2Fwp-content%2Fuploads%2F2018%2F04%2Ftajna-vecera.jpg&f=1&nofb=1&ipt=c1c4810e054d5fc837614e051123e735ec0b9c4fb967e8a5d227ed45ee689a8a&ipo=images', '1498'),
    (0, -3, 'Vincent van Gogh', 'Pogled sa istočnog prozora azilantske sobe', 'Zvezdana noć', 'Post-Impressionism', 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fd%2Fde%2FVincent_van_Gogh_Starry_Night.jpg&f=1&nofb=1&ipt=5cc303de5ac08f9b5cc8a5c90dabb9e38ef72fa5b9d06e3752bb42d942bf820e&ipo=images', '1889'),
    (0, -4, 'Gustav Klimt', 'Najsladji poljubac', 'Poljubac', 'Symbolism', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/The_Scream.jpg/450px-The_Scream.jpg', '1907'),
    (0, -5, 'Edvard Munch', 'Vrisak koji su čuli svi na svetu', 'Vrisak', 'Expressionism', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/El_beso%28Gustav_Klimt%29.jpg/640px-El_beso%28Gustav_Klimt%29.jpg', '1893'),
    (0, -6, 'Vincent Van Gogh', 'Auto portret', 'Ja', 'Expressionism', 'https://upload.wikimedia.org/wikipedia/commons/3/38/VanGogh_1887_Selbstbildnis.jpg', '1933'),
    (0, -7, 'Cukioka', 'Divna slika', 'Onogawa', 'Renaissance', 'https://uploads7.wikiart.org/images/tsukioka-yoshitoshi/onogawa.jpg', '1650');
-- Insert Item Reservations for "Medieval Treasures" Exhibition (ID 2)
INSERT INTO item_reservation (item_id, start_date, end_date, exhibition_id) VALUES
    (-1, '2024-05-15', '2024-09-15', 2),
    (-2, '2024-05-15', '2024-09-15', 2);

-- Insert Item Reservations for "Ancient Civilizations Unveiled" Exhibition (ID 1)
INSERT INTO item_reservation (item_id, start_date, end_date, exhibition_id) VALUES
    (-3, '2024-04-01', '2024-04-30', 1),
    (-4, '2024-04-01', '2024-04-30', 1),
    (-5, '2024-04-01', '2024-04-30', 1),
    (-6, '2024-04-01', '2024-04-30', 1),
    (-7, '2024-04-01', '2024-04-30', 1),
    (-1, '2024-04-01', '2024-04-30', 1),
    (-2, '2024-04-01', '2024-04-30', 1);

INSERT INTO ticket(number_of_adults, number_of_minors, total_price, exhibition_id, guest_id) VALUES
    (2, 1, 30.00, 2, 1),
    (1, 0, 12.00, 2, 2),
    (3, 2, 48.00, 2, 3);



-- Insert Reviews for "Medieval Treasures" Exhibition (ID 2)
INSERT INTO review(guest_id, exhibition_id, rating, comment, review_date) VALUES
    (1, 2, 5, 'An amazing deep dive into the medieval era. The artifacts were astonishing!', now()),  -- Review by Veljko (guest ID 1)
    (2, 2, 4, 'Great exhibition! The curation was excellent, but I expected more interactive elements.', now()),  -- Review by Dokma (guest ID 2)
    (2, 2, 5, 'An amazing deep dive into the medieval era. The artifacts were astonishing!', now()),  -- Review by Veljko (guest ID 1)
    (4, 2, 2, 'Great exhibition! The curation was excellent, but I expected more interactive elements.', now()),  -- Review by Dokma (guest ID 2)
    (4, 2, 1, 'An amazing deep dive into the medieval era. The artifacts were astonishing!', now()),  -- Review by Veljko (guest ID 1)
    (1, 2, 5, 'Great exhibition! The curation was excellent, but I expected more interactive elements.', now());  -- Review by Dokma (guest ID 2)








