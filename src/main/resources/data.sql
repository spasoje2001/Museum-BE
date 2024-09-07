-- var password = username;
--ALTER TABLE exhibition ALTER COLUMN long_description TYPE TEXT;



INSERT INTO _user(email, username, password, first_name, last_name, role, is_account_locked, picture) VALUES
    ('nemanja.tasovac@gmail.com', 'papi', '$2a$10$kVZ6MkAdppKk5GtbzjsgbubBx1Uos0EOTdiY9mIBA5XwWy1ezVQam', 'Nemanja', 'Tasovac', 0, false, 'assets/profile/guest1.jpg'), --veljko
    ('luka.zelovic@gmail.com', 'zela11', '2a$10$jicdgzoNyODhfwtEuXsYHelIRjzFZ5zIgqcXlHfoy9BROPAnWV2y2', 'Luka', 'Zelovic', 0, false, 'assets/profile/guest2.jpg'), --dokma
    ('jana.zecevic@gmail.com', 'janci01', '$2a$10$NhX4GkvqpZTas4mZa9wxuevS.8VCi70t3tKXVekdD5/VCg2Hf.kAu', 'Jana', 'Zecevic', 0, false, 'assets/profile/guest3.jpg'), --spale
    ('katarina.medic@gmail.com', 'meeeedic', '$2a$10$XxmC.cIEK6XvYUVOa2HvTOlMQlIk0J6oQYouW2iBdgob.sRv78W9C', 'Katarina', 'Medic', 0, false, 'assets/profile/guest4.jpg'), --nina
    ('nina.knezevic@gmail.com', 'bekana', 'password5', 'Nina', 'Knezevic', 0, false, 'assets/profile/guest5.jpg'),
    ('jovan.brboric@gmail.com', 'cabacaba', 'password6', 'Jovan', 'Brboric', 0, false, 'assets/profile/guest6.jpg'),
    ('spasoje.brboric@gmail.com', 'cicko01', 'password7', 'Spasoje', 'Brboric', 0, false, 'assets/profile/guest7.jpg'),
    ('nikola.markovic@gmail.com', 'markan01', 'password8', 'Nikola', 'Markovic', 0, false, 'assets/profile/guest8.jpg'),
    ('ryan.reynolds@gmail.com', 'deadpool', 'password9', 'Ryan', 'Reynolds', 0, false, 'assets/profile/guest9.jpg'),
    ('hugh.jackman@gmail.com', 'wolverine', 'password10', 'Hugh', 'Jackman', 0, false, 'assets/profile/guest10.jpg'),
    ('nikola.vukovic@gmail.com', 'nidza', 'password11', 'Nikola', 'Vuković', 0, false, 'assets/profile/guest11.jpg'),
    ('nikolina.vukovic@gmail.com', 'mekeu', 'password12', 'Nikolina', 'Vuković', 0, false, 'assets/profile/guest12.jpg'),
    ('julia.roberts@gmail.com', 'julia', 'password13', 'Julia', 'Roberts', 0, false, 'assets/profile/guest13.jpg'),
    ('walter.white@gmail.com', 'heisenberg', 'password14', 'Walter', 'White', 0, false, 'assets/profile/guest14.jpg'),
    ('tony.soprano@gmail.com', 'tony', 'password15', 'Tony', 'Soprano', 0, false, 'assets/profile/guest15.jpg'),
    ('jesse.pinkman@gmail.com', 'elcamino', 'password16', 'Jesse', 'Pinkman', 0, false, 'assets/profile/guest16.jpg'),
    ('sandra.bullock@gmail.com', 'sandra', 'password17', 'Sandra', 'Bullock', 0, false, 'assets/profile/guest17.jpg'),
    ('elon.musk@gmail.com', 'tesla', 'password18', 'Elon', 'Musk', 0, false, 'assets/profile/guest18.jpg'),
    ('chandler.bling@gmail.com', 'chandler', 'password19', 'Chandler', 'Bling', 0, false, 'assets/profile/guest19.jpg'),
    ('joey.tribbiani@gmail.com', 'joey', 'password20', 'Joey', 'Tribbiani', 0, false, 'assets/profile/guest20.jpg'),
    ('rdj@gmail.com', 'rdj', 'password21', 'Robert', 'Downey JR', 0, false, 'assets/profile/guest21.jpg'),
    ('michaelscott@gmail.com', 'mscott', '$2a$10$KVAfGs.glFRaekHlH3OWaeUASPrUMoh7MBuNu8DYT/SzRnvD9ZjL6', 'Michael', 'Scott', 1, false, 'assets/profile/organizer1.jpg'), --organizer
    ('barneystinson@gmail.com', 'bstinson', 'password2', 'Barney', 'Stinson', 1, false, 'assets/profile/organizer2.jpg'),
    ('drhouse@gmail.com', 'drhouse', 'password3', 'Doctor', 'House', 1, false, 'assets/profile/organizer3.jpg'),
    ('tedmosby@gmail.com', 'tmosby', '$2a$10$JGckcPY5eO8/1.xE7h7KmuH0A4gNif6PDSxBzUbxsThjQTTu.Nyai', 'Ted', 'Mosby', 2, false, 'assets/profile/curator1.jpg'), --curator
    ('dwightschrute@gmail.com', 'justdwight', 'password2', 'Dwight', 'Schrute', 2, false, 'assets/profile/curator2.jpg'),
    ('jimhalpert@gmail.com', 'jim', 'password3', 'Jim', 'Halpert', 2, false, 'assets/profile/curator3.jpg'),
    ('pambeesly@gmail.com', 'ilovejim', 'password4', 'Pam', 'Beesly',2, false, 'assets/profile/curator4.jpg'),
    ('harvey@gmail.com', 'harvey', '$2a$12$zSJwNzNr/uFw.a9H5YRus.gQhZ.hjaNxhads7618x/U8KTFCPUnde', 'Harvey', 'Specter', 3, false, 'assets/profile/admin1.jpg'), --admin
    ('bettercallsaul@gmail.com', 'bettercallsaul', 'password2', 'Saul', 'Goodman', 3, false, 'assets/profile/admin2.jpg');

INSERT INTO guest(id, biography) VALUES
    (1, 'A lover of art and history, Nemanja enjoys exploring museums and learning about different cultures.'),
    (2, 'Luka is an avid traveler with a deep appreciation for art and architecture, always looking for new experiences.'),
    (3, 'Jana has a keen interest in Renaissance art and spends her free time visiting galleries and museums.'),
    (4, 'Katarina is passionate about modern art and enjoys discussing artistic expressions with fellow art enthusiasts.'),
    (5, 'Nina has a deep appreciation for classical sculptures and loves attending exhibitions that showcase ancient artifacts.'),
    (6, 'Jovan is a history buff who enjoys learning about historical events and figures through museum visits.'),
    (7, 'Spasoje is fascinated by cultural heritage and spends weekends visiting museums to discover more about different civilizations.'),
    (8, 'Nikola is passionate about art history, particularly the works of the Impressionists, and regularly visits exhibitions.'),
    (9, 'Ryan enjoys exploring contemporary art and is always on the lookout for the latest exhibitions and installations.'),
    (10, 'Hugh is a fan of classic paintings and spends his free time visiting art galleries around the world.'),
    (11, 'Nikola is deeply interested in Serbian history and art, making frequent visits to museums to explore his heritage.'),
    (12, 'Nikolina loves learning about different art movements and enjoys visiting museums to see famous works in person.'),
    (13, 'Julia is an art enthusiast who enjoys exploring various art forms, from paintings to sculptures, in her free time.'),
    (14, 'Walter has a deep appreciation for abstract art and often visits galleries to explore new interpretations of artistic expression.'),
    (15, 'Tony is passionate about modern art and frequently attends exhibitions to stay up-to-date with the latest trends.'),
    (16, 'Jesse is intrigued by street art and enjoys visiting urban galleries to discover new and emerging artists.'),
    (17, 'Sandra loves photography and often visits museums to see iconic photographs and learn about their history.'),
    (18, 'Elon has a deep interest in technology and innovation, and he enjoys exploring museums that highlight scientific achievements.'),
    (19, 'Chandler enjoys visiting museums and galleries as a way to unwind and learn about different cultures and histories.'),
    (20, 'Joey is passionate about pop culture and often visits exhibitions that showcase iconic moments in film and television history.'),
    (21, 'Robert enjoys exploring art from different periods and cultures, making frequent visits to both classical and modern art museums.');

INSERT INTO organizer(id, biography) VALUES
    (22, 'Michael Scott is a passionate event organizer with a love for history and culture. He has been organizing exhibitions for over a decade, focusing on creating engaging and educational experiences for all visitors. His enthusiasm for art and history is evident in every exhibition he curates, bringing a unique and personal touch to each event.'),
    (23, 'Barney Stinson is a dynamic and creative event organizer with a flair for the extraordinary. With a background in marketing and a deep appreciation for art, Barney enjoys curating exhibitions that are both visually stunning and thought-provoking. His innovative approach to event planning has made him a well-known figure in the art community.'),
    (24, 'Doctor House, a former physician turned art enthusiast, has brought his analytical mind and attention to detail to the world of exhibition planning. He specializes in medical history exhibitions, combining his medical knowledge with his love for art to create unique and educational experiences. His exhibitions often explore the intersection of science and art, offering visitors a deep and engaging experience.');

INSERT INTO curator(id, biography) VALUES
    (25, 'Ted Mosby is an experienced architect with a passion for historical buildings. His love for intricate designs and storytelling through structures makes him a unique curator. Ted has a keen eye for detail and enjoys sharing the history behind every exhibit.'),
    (26, 'Dwight Schrute, a man of many talents, is not only an assistant to the regional manager but also a dedicated curator. His knowledge of medieval weapons and ancient artifacts is unmatched, and he prides himself on keeping the exhibits in perfect order. Dwight approaches his work with the utmost seriousness.'),
    (27, 'Jim Halpert, known for his laid-back demeanor, has a deep appreciation for modern art and contemporary exhibitions. He enjoys curating exhibits that challenge traditional notions of art and provoke thought. Jim brings a fresh perspective to the curation process.'),
    (28, 'Pam Beesly, with a background in art and design, is passionate about curating exhibits that connect with the audience on an emotional level. Her artistic sensibilities and creative approach to curation bring life to every exhibit. Pam believes in the power of art.');

INSERT INTO administrator(id, biography) VALUES
    (29, 'Harvey Specter is a top corporate lawyer with a passion for art and history. Known for his sharp mind and attention to detail, Harvey oversees the smooth operation of the museum. He is dedicated to ensuring that every exhibit is presented with the highest standards.'),
    (30, 'Saul Goodman, a lawyer with a knack for creative problem-solving, brings his unique flair to museum administration. His love for art and culture is evident in the way he manages the museums collections and events. Saul is committed to making the museum an engaging and accessible place for all visitors.');

-- Insert Rooms (without the 'floor' field)
INSERT INTO room(name, number) VALUES
    ('Main room', '101'),
    ('Side room', '121'),
    ('Front room', '203'),
    ('Gallery A', '104'),
    ('Gallery B', '105'),
    ('East Wing', '201'),
    ('West Wing', '202'),
    ('North Hall', '301'),
    ('South Hall', '302'),
    ('Ancient Art Room', '303'),
    ('Modern Art Room', '304'),
    ('Sculpture Hall', '305'),
    ('Photography Gallery', '306'),
    ('Textile Room', '307'),
    ('Ceramics Room', '308'),
    ('Interactive Exhibit', '309'),
    ('Temporary Exhibit', '310');


INSERT INTO exhibition_pricelist(adult_ticket_price, minor_ticket_price) VALUES
    (12, 6),
    (14, 7),
    (18, 9),
    (14, 7),
    (16, 8),
    (14, 7),
    (13, 6),
    (15, 9),
    (12, 4),
    (14, 9),
    (13, 8),
    (8, 7),
    (10, 6),
    (12, 6),
    (8, 4),
    (13, 6),
    (11, 6),
    (12, 8),
    (11, 5),
    (13, 6),
    (12, 5),
    (10, 3),
    (11, 7),
    (15, 8),
    (9, 7),
    (15, 8),
    (13, 8),
    (13, 9),
    (13, 7),
    (14, 7),
    (13, 6),
    (12, 5);

-- Trenutno otvorene izložbe
INSERT INTO room_reservation(room_id, start_date, end_date) VALUES
    (1, '2024-06-25', '2024-10-25'), -- Exhibition 1
    (2, '2024-07-01', '2024-10-30'), -- Exhibition 2
    (13, '2024-07-15', '2024-10-15'), -- Exhibition 3
    (4, '2024-08-04', '2024-11-04'), -- Exhibition 4
    (5, '2024-08-20', '2024-10-20'), -- Exhibition 5
    (3, '2024-08-27', '2024-10-27'), -- Exhibition 6
    (6, '2024-08-10', '2024-12-30'), -- Exhibition 7
    (7, '2024-09-01', '2025-01-01'); -- Exhibition 8

-- Buduće izložbe (READY_TO_OPEN)
INSERT INTO room_reservation(room_id, start_date, end_date) VALUES
    (11, '2024-10-15', '2025-01-15'), -- Exhibition 9
    (10, '2024-10-30', '2025-02-01'), -- Exhibition 10
    (12, '2024-12-01', '2025-03-01'), -- Exhibition 11
    (15, '2025-01-10', '2025-03-28'), -- Exhibition 12
    (16, '2025-01-15', '2025-04-30'); -- Exhibition 13

-- Stare izlozbe (CLOSED)
INSERT INTO room_reservation(room_id, start_date, end_date) VALUES
    (7, '2021-09-01', '2022-01-01'), -- Exhibition 8
    (16, '2022-01-15', '2022-04-30'), -- Exhibition 13
    (4, '2022-06-04', '2022-08-04'), -- Exhibition 4
    (2, '2022-07-01', '2022-10-30'), -- Exhibition 2
    (10, '2022-10-30', '2023-02-01'), -- Exhibition 10
    (1, '2023-06-25', '2023-10-25'), -- Exhibition 1
    (3, '2023-08-27', '2023-10-27'), -- Exhibition 6
    (6, '2023-10-10', '2023-12-30'), -- Exhibition 7
    (11, '2024-02-15', '2024-05-15'); -- Exhibition 9

-- Nove izložbe za 2025. godinu

INSERT INTO room_reservation(room_id, start_date, end_date) VALUES
    (1, '2025-03-01', '2025-06-01'), -- Organizer 22, Proposal 1
    (2, '2025-02-15', '2025-05-15'), -- Organizer 22, Proposal 2
    (5, '2025-03-15', '2025-06-20'), -- Organizer 22, Proposal 3
    (8, '2025-04-01', '2025-07-01'), -- Organizer 22, Proposal 4
    (12, '2025-05-01', '2025-07-30'), -- Organizer 22, Proposal 5
    (6, '2025-03-10', '2025-06-15'), -- Organizer 23, Proposal 6
    (10, '2025-04-05', '2025-07-05'), -- Organizer 23, Proposal 7
    (7, '2025-05-10', '2025-08-01'), -- Organizer 23, Proposal 8
    (13, '2025-06-01', '2025-08-30'), -- Organizer 24, Proposal 9
    (11, '2025-07-01', '2025-09-30'); -- Organizer 24, Proposal 10



INSERT INTO exhibition_proposal(start_date, end_date, organizer_id, room_reservation_id, pricelist_id, proposal_date) VALUES
--trenutno otvoreni
    ('2024-06-25', '2024-10-25', 22, 1, 1, '2024-04-01'),
    ('2024-07-01', '2024-10-30', 23, 2, 2, '2024-05-10'),
    ('2024-07-15', '2024-10-15', 24, 3, 3, '2024-07-05'),
    ('2024-08-04', '2024-11-04', 23, 4, 4, '2024-05-01'),
    ('2024-08-20', '2024-10-20', 23, 5, 5, '2024-07-20'),
    ('2024-08-27', '2024-10-27', 23, 6, 6, '2024-07-01'),
    ('2024-08-30', '2024-12-30', 22, 7, 7, '2024-06-25'),
    ('2024-09-01', '2025-01-01', 23, 8, 8, '2024-07-20'),
--ready-to-open
    ('2024-10-15', '2025-01-15', 24, 9, 9, '2024-09-01'),
    ('2024-10-30', '2025-02-01', 23, 10, 10, '2024-09-01'),
    ('2024-12-01', '2025-03-01', 22, 11, 11, '2024-09-02'),
    ('2025-01-10', '2025-03-28', 23, 12, 12, '2024-06-10'),
    ('2025-01-15', '2025-04-30', 23, 13, 13, '2024-05-05'),
--closed
    ('2021-09-01', '2022-01-01', 23, 14, 14, '2021-07-01'), -- Exhibition 8
    ('2022-01-15', '2022-04-30', 23, 15, 15, '2021-12-15'), -- Exhibition 13
    ('2022-06-04', '2022-08-04', 23, 16, 16, '2022-04-04'), -- Exhibition 4
    ('2022-07-01', '2022-10-30', 23, 17, 17, '2022-04-01'),-- Exhibition 2
    ('2022-10-30', '2023-02-01', 23, 18, 18, '2022-08-30'), -- Exhibition 10
    ('2023-06-25', '2023-10-25', 22, 19, 19, '2023-04-25'), -- Exhibition 1
    ('2023-08-27', '2023-10-27', 23, 20, 20, '2023-07-27'), -- Exhibition 6
    ('2023-10-10', '2023-12-30', 22, 21, 21, '2023-06-10'), -- Exhibition 7
    ('2024-02-15', '2024-05-15', 24, 22, 22, '2024-01-10'); -- Exhibition 9

-- nerealizovani proposali za 2025
INSERT INTO exhibition_proposal(start_date, end_date, organizer_id, room_reservation_id, pricelist_id, proposal_date) VALUES
    ('2025-03-01', '2025-06-01', 22, 23, 23, '2024-09-01'), -- Proposal 1
    ('2025-02-15', '2025-05-15', 22, 24, 24, '2024-08-15'), -- Proposal 2
    ('2025-03-15', '2025-06-20', 22, 25, 25, '2024-08-15'), -- Proposal 3
    ('2025-04-01', '2025-07-01', 22, 26, 26, '2024-07-25'), -- Proposal 4
    ('2025-05-01', '2025-07-30', 22, 27, 27, '2024-08-31'), -- Proposal 5
    ('2025-03-10', '2025-06-15', 23, 28, 28, '2025-08-05'), -- Proposal 6
    ('2025-04-05', '2025-07-05', 23, 29, 29, '2025-07-10'), -- Proposal 7
    ('2025-05-10', '2025-08-01', 23, 30, 30, '2025-08-13'), -- Proposal 8
    ('2025-06-01', '2025-08-30', 24, 31, 31, '2025-07-20'), -- Proposal 9
    ('2025-07-01', '2025-09-30', 24, 32, 32, '2025-06-01'); -- Proposal 10


INSERT INTO exhibition(name, picture, short_description, long_description, theme, status, curator_id, exhibition_proposal_id) VALUES
    ('Van Gogh and the Masters of Impressionism',
     'assets/exhibitions/exhibition1.jpg',
     'Journey through the vibrant world of Van Gogh and his fellow Impressionists.',
     'Immerse yourself in the dazzling colors and emotional brushstrokes of Vincent van Gogh, accompanied by works of other legendary Impressionists. This exhibition explores the evolution of artistic techniques and how these masters captured the beauty of the world around them, often pushing the boundaries of traditional art. From the serenity of rural landscapes to the bustling life of cities, each piece in this collection tells a unique story of observation and interpretation, making this exhibition a must-see for art lovers.',
     'FINE_ARTS', 'OPENED', 25, 1),

    ('The Mastery of Katsushika Hokusai and Kawanabe Kyōsai',
    'assets/exhibitions/exhibition2.jpg',
    'Explore the captivating artistry of Katsushika Hokusai and Kawanabe Kyōsai.',
    'Delve into the intricate and mesmerizing world of two of Japans most renowned artists, Katsushika Hokusai and Kawanabe Kyōsai. This exhibition showcases the profound impact these masters had on the art world, both in Japan and globally. From the iconic waves of Hokusai’s Under the Wave off Kanagawa to the serene depiction of Fine Wind, Clear Morning, and the compelling Sarumaru Dayu, each piece reflects the depth of Hokusais skill and vision. Complementing this is Kyōsai’s vivid Deer and Monkeys, which adds a dynamic contrast, highlighting the diversity of Japanese art. Together, these works offer a rich visual experience, celebrating the enduring legacy of Japanese cultural heritage.',
     'WORLD_CULTURES', 'OPENED', 26, 2),

    ('Icons of 20th Century Photography',
     'assets/exhibitions/exhibition3.jpg',
     'Explore the defining moments of the 20th century through iconic photography.',
     'This exhibition brings together some of the most powerful and recognizable images of the 20th century, captured by legendary photographers. Each photograph not only tells a story of a moment frozen in time but also reflects the cultural, social, and political landscapes of the era. From Charles Ebbets daring Lunch Atop a Skyscraper to Dorothea Lange’s poignant Migrant Mother, and Robert Capa’s harrowing The Falling Soldier, these images have shaped the way we see the world. The exhibition also features iconic portraits like Yousuf Karsh’s The Roaring Lion and Arthur Sasse’s Albert Einstein, as well as historic events captured in Alfred Eisenstaedt s V-J Day in Times Square and Joe Rosenthals Flag Raising at Iwo Jima. With a total of 20 breathtaking photographs, this collection offers a powerful visual journey through the pivotal moments of the 20th century.',
     'PHOTOGRAPHY', 'OPENED', 27, 3),

    ('Monet and the Masters of Light',
     'assets/exhibitions/exhibition4.jpg',
     'Experience the brilliance of light and color through the masterpieces of Monet and his contemporaries.',
     'This exhibition explores the mastery of light and color in the works of Claude Monet and other renowned artists who revolutionized the world of fine arts. From the gentle play of light in "Woman Seated under the Willows" by Monet to the vibrant "Ship on the Touques" by Eugène Boudin, and the serene "Santa Maria della Salute at Sunset" by William Stanley Haseltine, each piece showcases the artists exceptional ability to capture the ephemeral beauty of nature. Visitors will journey through a collection of stunning landscapes and seascapes that evoke a deep appreciation for the subtle interplay between light and shadow. These masterpieces represent a pivotal moment in the history of art, where the focus shifted towards capturing the fleeting effects of light, setting the stage for modern artistic expression.',
     'FINE_ARTS', 'OPENED', 26, 4),

    ('The Power of the Past: Neoclassicism and Romanticism',
    'assets/exhibitions/exhibition5.jpg',
    'Explore the influence of Neoclassicism and Romanticism on art and culture.',
    'This exhibition delves into the powerful movements of Neoclassicism and Romanticism, showcasing their profound impact on art, culture, and society. Through the meticulous brushstrokes of Jacques-Louis David in "Emperor Napoleon in His Study at the Tuileries," the grandeur of ancient civilizations captured by Giovanni Paolo Panini in "Ancient Rome," and the majestic portrayal of "The Parthenon" by Frederic Edwin Church, visitors will witness the revival of classical ideals and the emotional intensity that defined these movements. The exhibition also features the evocative "Two Men Contemplating the Moon" by Caspar David Friedrich, a hallmark of Romanticisms fascination with nature and the sublime, and "The Storm" by Pierre-Auguste Cot, a masterpiece that blends dramatic romanticism with classical precision. Together, these works highlight the enduring power of the past and its influence on the present, inviting viewers to reflect on the timeless themes of heroism, beauty, and the human condition.',
     'FINE_ARTS', 'OPENED', 27, 5),

    ('The Art of Paja Jovanović',
     'assets/exhibitions/exhibition6.jpg',
     'Explore the life and works of the celebrated Serbian painter, Paja Jovanović.',
     'This exhibition is a comprehensive journey through the artistic legacy of Paja Jovanović, one of Serbias most prominent painters. Known for his masterful depictions of historical events, folkloric scenes, and portraits, Jovanovićs work captures the essence of Serbian culture and history. The exhibition features iconic pieces such as "Seoba Srba," which portrays the migration of Serbs, and "Takovski ustanak," a powerful representation of the Serbian uprising. Visitors will also encounter "Krunisanje Cara Dušana," showcasing the coronation of Emperor Dušan, alongside the vibrant and dynamic "Borba petlova," and the intricate "Kićenje Neveste," which captures the tradition of adorning a bride. Through these works, Jovanovićs profound ability to narrate history and culture through art is vividly displayed, offering a window into the soul of a nation and its people.',
     'FINE_ARTS', 'OPENED', 26, 6),

    ('Uroš Predić: Realism and Tradition',
     'assets/exhibitions/exhibition7.jpg',
     'Experience the depth of Serbian realism through the works of Uroš Predić.',
     'This exhibition delves into the rich artistic legacy of Uroš Predić, a master of Serbian realism. Predićs works are celebrated for their meticulous attention to detail, emotional depth, and their ability to convey the cultural and spiritual essence of Serbia. The exhibition features iconic pieces such as "Kosovka devojka," a poignant portrayal of a woman tending to the wounded after the Battle of Kosovo, and "Sveti Sava blagosilja Srpčad," which depicts Saint Sava blessing Serbian children. Visitors will also encounter "Sveti Nikola spasava brodolomce," illustrating the saints miracle at sea, alongside "Hercegovačke izbeglice," capturing the plight of refugees, and "Deca pod dudom," a serene scene of children playing under a mulberry tree. Through these works, Predićs profound ability to blend realism with the spiritual and cultural traditions of Serbia is vividly displayed, offering a window into the soul of a nation.',
     'FINE_ARTS', 'OPENED', 27, 7),

    ('The Golden Age of Gustav Klimt',
     'assets/exhibitions/exhibition8.jpg',
     'Immerse yourself in the opulent world of Gustav Klimt, where gold and beauty converge.',
     'This exhibition celebrates the opulent and intricate works of Gustav Klimt, one of the most prominent figures of the Vienna Secession movement. Klimts use of gold leaf, vibrant colors, and sensual subject matter have made his works some of the most beloved and recognizable in art history. The exhibition features "The Kiss," a masterpiece that captures the epitome of love and intimacy through its dazzling gold and intricate patterns. "Judith I," another highlight, portrays the biblical heroine with a blend of seduction and strength, showcasing Klimts unique approach to the female form. The enigmatic "Mermaids" further demonstrates Klimts ability to weave myth and reality into a tapestry of beauty and mystery. Together, these works represent the zenith of Klimts artistic journey, where every brushstroke is a testament to his mastery of form, color, and ornamentation.',
     'FINE_ARTS', 'OPENED', 28, 8),
--ready_to_open
    ('Sava Šumanović: The Serbian Modernist',
    'assets/exhibitions/exhibition9.jpg',
    'Experience the vibrant modernist vision of Sava Šumanović, a cornerstone of Serbian art.',
    'This exhibition delves into the modernist approach of Sava Šumanović, a pivotal figure in Serbian art. His works, characterized by bold colors, striking compositions, and a deep connection to his homeland, reflect both personal and collective narratives. The exhibition features "Sid pod snegom," a poignant portrayal of a serene winter landscape, where the quiet beauty of nature is captured through Šumanovićs unique lens. "Pijana ladja," another masterpiece, presents a dynamic and almost surreal depiction of life’s journey, filled with metaphor and emotion. Finally, "Cveće" showcases Šumanovićs ability to bring the simplicity of nature to life on canvas, with vivid colors and a delicate balance of form. Together, these works offer a comprehensive view of Šumanovićs artistic evolution and his enduring legacy in the world of modern art.',
     'MODERN_HISTORY', 'READY_TO_OPEN', 26, 9),

    ('Wassily Kandinsky: Abstract Expressionism',
     'assets/exhibitions/exhibition10.jpg',
     'Explore the abstract world of Wassily Kandinsky, a pioneer of modern art.',
     'This exhibition showcases the groundbreaking work of Wassily Kandinsky, one of the foremost pioneers of abstract art. Kandinskys use of color, form, and composition broke away from traditional artistic conventions and opened new avenues for expression in modern art. The exhibition features "Composition VIII," a masterpiece that exemplifies Kandinskys approach to abstraction, where geometric shapes and bold colors create a dynamic visual experience. "Heavy Red" further explores the emotional power of color, using deep reds and contrasting tones to evoke a sense of tension and depth. Finally, "Delicate Tension" presents a more subtle interplay of shapes and lines, demonstrating Kandinskys ability to convey complex emotions through abstract forms. Together, these works offer a deep dive into the world of abstract expressionism and Kandinskys enduring influence on contemporary art.',
     'CONTEMPORARY_ART', 'READY_TO_OPEN', 27, 10),

    ('Greek Sculpture: Gods and Ephebes',
     'assets/exhibitions/exhibition11.jpg',
     'Explore the divine beauty and youthful vigor in ancient Greek sculpture.',
     'This exhibition delves into the world of ancient Greek sculpture, focusing on the divine representations of gods and the idealized forms of young men, or ephebes. "Artemis or Bendis with a Herm of Pan" showcases the elegance and mystique of the Greek deities, capturing their power and grace in stone. The "Ephebe in Traveling Hat, Cloak, and Boots" represents the youthful athleticism and beauty that were central to Greek ideals, while the "Fragment of a Statue of a Young Man" offers a glimpse into the artistic techniques and aesthetic values of the period. Through these exquisite sculptures, visitors can experience the timeless allure of ancient Greece, where gods and humans shared the same aesthetic ideals of beauty, strength, and perfection.',
     'ANCIENT_HISTORY', 'READY_TO_OPEN', 25, 11),

    ('Medieval Sculpture: Faith in Stone',
     'assets/exhibitions/exhibition12.jpg',
     'Experience the spiritual devotion captured in medieval stone sculptures.',
     'This exhibition takes you back to the Middle Ages, a time of deep religious faith and artistic devotion. Through the intricate sculptures of "Saint Peter" and "Saint Paul," we explore the reverence and symbolism that defined the medieval period. The centerpiece, "The Holy Trinity," embodies the spiritual essence of the era, capturing the divine presence in every carved detail. These works showcase the skill of medieval sculptors, who transformed cold stone into living expressions of faith. Visitors will be transported to a time when art was not just a form of expression but a conduit for spiritual experience, bringing the divine closer to the mortal world.',
     'MEDIEVAL_HISTORY', 'READY_TO_OPEN', 26, 12),

    ('The Art of Printmaking: Renaissance Masters',
     'assets/exhibitions/exhibition13.jpg',
     'Explore the intricate world of Renaissance printmaking.',
     'This exhibition celebrates the mastery of Renaissance printmakers who brought religious and cultural narratives to life through the delicate art of printmaking. Featuring works by Ludovico Mattioli, such as "Februarius (February)," "Iunius (June)," and "Januarius (January)," the exhibition provides a glimpse into the craftsmanship and dedication required to create these timeless pieces. Additionally, the exhibition showcases Israhel van Meckenems evocative prints like "Virgin and Child in a Courtyard," "Saint Stephen," and "Saint Quirinus of Neuss," highlighting the rich tradition of religious iconography in Renaissance art. Visitors will gain an appreciation for the precision and artistry that defined this important medium, which played a crucial role in disseminating ideas and stories during the Renaissance.',
     'FINE_ARTS', 'READY_TO_OPEN', 27, 13),
--closed
    ('The Golden Age of Gustav Klimt',
     'assets/exhibitions/exhibition8.jpg',
     'Immerse yourself in the opulent world of Gustav Klimt, where gold and beauty converge.',
     'This exhibition celebrates the opulent and intricate works of Gustav Klimt, one of the most prominent figures of the Vienna Secession movement. Klimts use of gold leaf, vibrant colors, and sensual subject matter have made his works some of the most beloved and recognizable in art history. The exhibition features "The Kiss," a masterpiece that captures the epitome of love and intimacy through its dazzling gold and intricate patterns. "Judith I," another highlight, portrays the biblical heroine with a blend of seduction and strength, showcasing Klimts unique approach to the female form. The enigmatic "Mermaids" further demonstrates Klimts ability to weave myth and reality into a tapestry of beauty and mystery. Together, these works represent the zenith of Klimts artistic journey, where every brushstroke is a testament to his mastery of form, color, and ornamentation.',
     'FINE_ARTS', 'CLOSED', 28, 14),

    ('The Art of Printmaking: Renaissance Masters',
     'assets/exhibitions/exhibition13.jpg',
     'Explore the intricate world of Renaissance printmaking.',
     'This exhibition celebrates the mastery of Renaissance printmakers who brought religious and cultural narratives to life through the delicate art of printmaking. Featuring works by Ludovico Mattioli, such as "Februarius (February)," "Iunius (June)," and "Januarius (January)," the exhibition provides a glimpse into the craftsmanship and dedication required to create these timeless pieces. Additionally, the exhibition showcases Israhel van Meckenems evocative prints like "Virgin and Child in a Courtyard," "Saint Stephen," and "Saint Quirinus of Neuss," highlighting the rich tradition of religious iconography in Renaissance art. Visitors will gain an appreciation for the precision and artistry that defined this important medium, which played a crucial role in disseminating ideas and stories during the Renaissance.',
     'FINE_ARTS', 'CLOSED', 27, 15),

    ('Monet and the Masters of Light',
     'assets/exhibitions/exhibition4.jpg',
     'Experience the brilliance of light and color through the masterpieces of Monet and his contemporaries.',
     'This exhibition explores the mastery of light and color in the works of Claude Monet and other renowned artists who revolutionized the world of fine arts. From the gentle play of light in "Woman Seated under the Willows" by Monet to the vibrant "Ship on the Touques" by Eugène Boudin, and the serene "Santa Maria della Salute at Sunset" by William Stanley Haseltine, each piece showcases the artists exceptional ability to capture the ephemeral beauty of nature. Visitors will journey through a collection of stunning landscapes and seascapes that evoke a deep appreciation for the subtle interplay between light and shadow. These masterpieces represent a pivotal moment in the history of art, where the focus shifted towards capturing the fleeting effects of light, setting the stage for modern artistic expression.',
     'FINE_ARTS', 'CLOSED', 26, 16),

    ('The Mastery of Katsushika Hokusai and Kawanabe Kyōsai',
     'assets/exhibitions/exhibition2.jpg',
     'Explore the captivating artistry of Katsushika Hokusai and Kawanabe Kyōsai.',
     'Delve into the intricate and mesmerizing world of two of Japans most renowned artists, Katsushika Hokusai and Kawanabe Kyōsai. This exhibition showcases the profound impact these masters had on the art world, both in Japan and globally. From the iconic waves of Hokusai’s Under the Wave off Kanagawa to the serene depiction of Fine Wind, Clear Morning, and the compelling Sarumaru Dayu, each piece reflects the depth of Hokusais skill and vision. Complementing this is Kyōsai’s vivid Deer and Monkeys, which adds a dynamic contrast, highlighting the diversity of Japanese art. Together, these works offer a rich visual experience, celebrating the enduring legacy of Japanese cultural heritage.',
     'WORLD_CULTURES', 'CLOSED', 26, 17),

    ('Wassily Kandinsky: Abstract Expressionism',
     'assets/exhibitions/exhibition10.jpg',
     'Explore the abstract world of Wassily Kandinsky, a pioneer of modern art.',
     'This exhibition showcases the groundbreaking work of Wassily Kandinsky, one of the foremost pioneers of abstract art. Kandinskys use of color, form, and composition broke away from traditional artistic conventions and opened new avenues for expression in modern art. The exhibition features "Composition VIII," a masterpiece that exemplifies Kandinskys approach to abstraction, where geometric shapes and bold colors create a dynamic visual experience. "Heavy Red" further explores the emotional power of color, using deep reds and contrasting tones to evoke a sense of tension and depth. Finally, "Delicate Tension" presents a more subtle interplay of shapes and lines, demonstrating Kandinskys ability to convey complex emotions through abstract forms. Together, these works offer a deep dive into the world of abstract expressionism and Kandinskys enduring influence on contemporary art.',
     'CONTEMPORARY_ART', 'CLOSED', 27, 18),

    ('Van Gogh and the Masters of Impressionism',
     'assets/exhibitions/exhibition1.jpg',
     'Journey through the vibrant world of Van Gogh and his fellow Impressionists.',
     'Immerse yourself in the dazzling colors and emotional brushstrokes of Vincent van Gogh, accompanied by works of other legendary Impressionists. This exhibition explores the evolution of artistic techniques and how these masters captured the beauty of the world around them, often pushing the boundaries of traditional art. From the serenity of rural landscapes to the bustling life of cities, each piece in this collection tells a unique story of observation and interpretation, making this exhibition a must-see for art lovers.',
     'FINE_ARTS', 'CLOSED', 25, 19),

    ('The Art of Paja Jovanović',
     'assets/exhibitions/exhibition6.jpg',
     'Explore the life and works of the celebrated Serbian painter, Paja Jovanović.',
     'This exhibition is a comprehensive journey through the artistic legacy of Paja Jovanović, one of Serbias most prominent painters. Known for his masterful depictions of historical events, folkloric scenes, and portraits, Jovanovićs work captures the essence of Serbian culture and history. The exhibition features iconic pieces such as "Seoba Srba," which portrays the migration of Serbs, and "Takovski ustanak," a powerful representation of the Serbian uprising. Visitors will also encounter "Krunisanje Cara Dušana," showcasing the coronation of Emperor Dušan, alongside the vibrant and dynamic "Borba petlova," and the intricate "Kićenje Neveste," which captures the tradition of adorning a bride. Through these works, Jovanovićs profound ability to narrate history and culture through art is vividly displayed, offering a window into the soul of a nation and its people.',
     'FINE_ARTS', 'CLOSED', 26, 20),

    ('Uroš Predić: Realism and Tradition',
     'assets/exhibitions/exhibition7.jpg',
     'Experience the depth of Serbian realism through the works of Uroš Predić.',
     'This exhibition delves into the rich artistic legacy of Uroš Predić, a master of Serbian realism. Predićs works are celebrated for their meticulous attention to detail, emotional depth, and their ability to convey the cultural and spiritual essence of Serbia. The exhibition features iconic pieces such as "Kosovka devojka," a poignant portrayal of a woman tending to the wounded after the Battle of Kosovo, and "Sveti Sava blagosilja Srpčad," which depicts Saint Sava blessing Serbian children. Visitors will also encounter "Sveti Nikola spasava brodolomce," illustrating the saints miracle at sea, alongside "Hercegovačke izbeglice," capturing the plight of refugees, and "Deca pod dudom," a serene scene of children playing under a mulberry tree. Through these works, Predićs profound ability to blend realism with the spiritual and cultural traditions of Serbia is vividly displayed, offering a window into the soul of a nation.',
     'FINE_ARTS', 'CLOSED', 27, 21),

    ('Sava Šumanović: The Serbian Modernist',
     'assets/exhibitions/exhibition9.jpg',
     'Experience the vibrant modernist vision of Sava Šumanović, a cornerstone of Serbian art.',
     'This exhibition delves into the modernist approach of Sava Šumanović, a pivotal figure in Serbian art. His works, characterized by bold colors, striking compositions, and a deep connection to his homeland, reflect both personal and collective narratives. The exhibition features "Sid pod snegom," a poignant portrayal of a serene winter landscape, where the quiet beauty of nature is captured through Šumanovićs unique lens. "Pijana ladja," another masterpiece, presents a dynamic and almost surreal depiction of life’s journey, filled with metaphor and emotion. Finally, "Cveće" showcases Šumanovićs ability to bring the simplicity of nature to life on canvas, with vivid colors and a delicate balance of form. Together, these works offer a comprehensive view of Šumanovićs artistic evolution and his enduring legacy in the world of modern art.',
     'MODERN_HISTORY', 'CLOSED', 26, 22);

INSERT INTO item(category, authors_name, description, name, period, picture, year_of_creation) VALUES
    (0, 'Katsushika Hokusai', 'Under the Wave off Kanagawa, also known as The Great Wave, is one of the most famous Japanese artworks. This woodblock print depicts a massive wave threatening to engulf small fishing boats, with Mount Fuji visible in the background. The piece is part of Hokusai’s series titled "Thirty-Six Views of Mount Fuji". This work symbolizes the power of nature and is often used as a representative piece of Japanese art.', 'Under the Wave off Kanagawa', 'Edo period', 'assets/items/item1.jpg', '1831'),
    (0, 'Pierre-Auguste Cot', 'The Storm is a painting depicting a young couple running through a storm, tightly embracing each other under a billowing white sheet. The work captures a moment of intense emotion and movement, with dramatic lighting and a sense of urgency in the characters expressions and poses. The background is a lush, slightly blurred landscape that enhances the romantic and dynamic feel of the piece.', 'The Storm', 'Romanticism', 'assets/items/item2.jpg', '1880'),
    (0, 'Vincent van Gogh', 'Wheat Field is one of Van Goghs iconic works, capturing the raw beauty and intensity of the countryside. The painting depicts a vast wheat field under a swirling sky, where the golden crops appear to be alive, bending and shifting with the wind. The use of thick, impasto brushstrokes creates a textured, almost tangible scene, while the contrasting colors of the golden wheat and the deep blues of the sky evoke a sense of both serenity and unease. This painting is a powerful representation of Van Goghs emotional state during the time of its creation, reflecting his deep connection to nature and his inner turmoil.', 'Wheat Field', 'Post-Impressionism', 'assets/items/item3.jpg', '1889'),
    (0, 'Paul Cézanne', 'Gardener Vallier is a remarkable painting by Paul Cézanne, completed in 1906. The artwork portrays Vallier, the gardener of Cézannes estate, with a simplicity that is both humble and profound. Cézanne captures the essence of the man through a careful study of form, color, and light. The gardener is depicted seated, holding a tool, with his body turned slightly away from the viewer, yet his face is clearly visible, revealing a sense of quiet dignity. The muted colors and subtle brushstrokes reflect Cézannes mature style, where he sought to convey the underlying structure of reality through geometric forms and a restrained palette. This painting is considered one of Cézannes last masterpieces, showcasing his profound understanding of human character and the natural world.', 'Gardener Vallier', 'Post-Impressionism', 'assets/items/item4.jpg', '1906'),
    (0, 'Vincent van Gogh', 'Roses is a beautiful still life painting by Vincent van Gogh, created in 1890. The artwork features a bouquet of white roses arranged in a green vase, set against a pale background. Van Goghs use of vibrant colors and thick, expressive brushstrokes brings the flowers to life, capturing their delicate beauty and the fleeting nature of their bloom. The painting is filled with a sense of lightness and tranquility, reflecting van Goghs deep appreciation for the beauty of nature. Despite the simplicity of the subject, the work is rich with emotion and texture, showcasing van Goghs mastery in portraying the ephemeral beauty of flowers. This painting is one of the last still lifes created by van Gogh before his untimely death, making it a poignant representation of his enduring artistic vision.', 'Roses', 'Post-Impressionism', 'assets/items/item5.jpg', '1890'),
    (0, 'Vincent van Gogh', 'Wheat Fields at Auvers is one of the final masterpieces by Vincent van Gogh, painted in July 1890 during his stay in Auvers-sur-Oise, shortly before his death. The painting depicts expansive fields of golden wheat under a turbulent sky, capturing the essence of the rural landscape. Van Goghs vigorous brushstrokes and dynamic composition convey a sense of movement and emotion, reflecting his inner turmoil. The painting is filled with intense color contrasts, with the golden wheat fields juxtaposed against the deep blues and greens of the sky and trees. This artwork is often interpreted as an expression of van Goghs state of mind during his final days, filled with both beauty and despair. The vastness of the fields, stretching to the horizon, symbolizes both the isolation and the infinite possibilities of the natural world.', 'Wheat Fields at Auvers', 'Post-Impressionism', 'assets/items/item6.jpg', '1890'),
    (0, 'Claude Monet', 'Woman Seated under the Willows is a serene and reflective piece by Claude Monet, painted in 1880. The painting captures a tranquil moment where a woman is seated under the shade of a willow tree, immersed in her thoughts. Monet, known for his mastery of light and color, uses soft, diffused light to create a peaceful atmosphere. The lush greenery and delicate leaves of the willow tree surround the figure, creating a sense of intimacy and seclusion. The subtle play of light filtering through the branches adds a gentle warmth to the scene, highlighting Monets skill in capturing the fleeting effects of light in nature. This painting exemplifies Monets focus on the harmony between humanity and the natural world, portraying a quiet, contemplative moment in a beautiful, natural setting.', 'Woman Seated under the Willows', 'Impressionism', 'assets/items/item7.jpg', '1880'),
    (0, 'Eugène Boudin', 'Ship on the Touques, painted in 1895 by Eugène Boudin, is a beautiful example of his ability to capture the essence of the sea and maritime life. Boudin, often called the "King of the Skies," is known for his ability to depict the ever-changing atmosphere of coastal landscapes. In this painting, a ship is anchored on the Touques River, with its reflection shimmering on the calm waters. The sky above, filled with soft clouds, creates a sense of vastness and tranquility. Boudins delicate brushwork and use of light give the painting a luminous quality, emphasizing the serenity of the scene. The composition, with the ship centered against the expansive sky, reflects Boudins mastery in balancing the elements of earth, water, and air, making this work a testament to his legacy as one of the pioneers of plein air painting.', 'Ship on the Touques', 'Impressionism', 'assets/items/item8.jpg', '1895'),
    (0, 'Jacques-Louis David', 'Emperor Napoleon in His Study at the Tuileries, painted in 1812 by Jacques-Louis David, is an iconic portrait of one of historys most famous figures. In this powerful depiction, Napoleon is shown in his study at the Tuileries Palace, dressed in his military uniform. The painting captures him in a moment of quiet determination, surrounded by the tools of his leadership, including a quill, papers, and a map. David, known for his neoclassical style, uses sharp lines and a muted color palette to convey the strength and resolve of the emperor. The attention to detail, from the folds in Napoleons uniform to the intricate decor of the study, reflects Davids skill as a portraitist. The painting not only serves as a historical record but also as a testament to Napoleons enduring legacy as a leader.', 'Emperor Napoleon in His Study at the Tuileries', 'Neoclassicism', 'assets/items/item9.jpg', '1812'),
    (0, 'Caspar David Friedrich', 'Two Men Contemplating the Moon, painted by Caspar David Friedrich in 1825-30, is a quintessential example of Romanticism. The painting features two figures standing on a rocky outcrop, gazing at a large, glowing moon in a night sky filled with clouds. The men, dressed in dark, cloaked garments, are dwarfed by the vast landscape, highlighting the Romantic theme of the sublime—the awe-inspiring power of nature. Friedrichs use of light and shadow, as well as his detailed rendering of the natural elements, creates a serene yet mysterious atmosphere. The painting evokes a sense of introspection and wonder, as the figures appear lost in contemplation of the moon and the infinite beyond. This work is one of Friedrichs most celebrated, capturing the spiritual and philosophical depth characteristic of his art.', 'Two Men Contemplating the Moon', 'Romanticism', 'assets/items/item10.jpg', '1825-30'),
    (0, 'Frederic Edwin Church', 'The Parthenon, painted by Frederic Edwin Church in 1871, is a masterful representation of the iconic Greek temple. The painting captures the Parthenon in all its classical grandeur, bathed in the golden light of the setting sun. Church, known for his detailed and luminous landscapes, meticulously rendered the architectural details of the Parthenon, emphasizing its majestic presence atop the Acropolis in Athens. The surrounding landscape, with its rolling hills and ancient ruins, enhances the sense of historical significance and timeless beauty. The sky, filled with soft clouds and the warm glow of dusk, adds a peaceful and contemplative mood to the scene. This painting reflects Churchs fascination with the ancient world and his skill in conveying the grandeur and serenity of monumental structures.', 'The Parthenon', 'Hudson River School', 'assets/items/item11.jpg', '1871'),
    (0, 'El Greco', 'Christ Carrying the Cross, painted by El Greco in 1587, is a powerful depiction of one of the most poignant moments in Christian iconography. El Greco, known for his dramatic and emotional style, presents Christ with an elongated figure, a characteristic of his work, emphasizing the spiritual over the physical. The painting focuses on Christ’s solitary figure, bearing the cross with a profound expression of suffering and resignation. His eyes, turned heavenward, reflect a deep connection with the divine, as if seeking strength to endure the impending crucifixion. The background is abstract and dark, which further accentuates the luminous and almost otherworldly presence of Christ. The use of light and shadow, along with the rich, yet subdued color palette, enhances the emotional intensity of the scene, making it a deeply moving representation of faith and sacrifice.', 'Christ Carrying the Cross', 'Mannerism', 'assets/items/item12.jpg', '1587'),
    (0, 'Vincent van Gogh', 'Self-Portrait with a Straw Hat and The Potato Peeler are two works by Vincent van Gogh, created in 1887. The obverse side of the canvas features the self-portrait, where van Gogh depicts himself wearing a straw hat, with the influence of pointillism evident in the technique used. The portrait reflects van Gogh’s intense gaze, highlighting his inner turmoil and determination. On the reverse side, The Potato Peeler captures a simple yet poignant scene of a peasant woman engaged in the mundane task of peeling potatoes, a subject van Gogh often explored to depict the harsh realities of rural life. The use of contrasting colors and brushstrokes in both works demonstrates van Gogh’s evolving style during this period, marked by a blend of realism and his unique expressive touch.', 'Self-Portrait with a Straw Hat (obverse: The Potato Peeler)', 'Post-Impressionism', 'assets/items/item13.jpg', '1887'),
    (0, 'William Stanley Haseltine', 'Santa Maria della Salute at Sunset, painted in 1870 by William Stanley Haseltine, captures the majestic beauty of Venice’s iconic church as the day draws to a close. The scene is bathed in the warm, golden hues of sunset, which reflect off the tranquil waters of the Grand Canal. Haseltine’s meticulous attention to detail brings out the architectural splendor of Santa Maria della Salute, while the soft, diffused light creates a serene and almost ethereal atmosphere. The painting not only showcases Haseltine’s skill in rendering landscapes with precision but also his ability to convey the emotional and atmospheric qualities of the setting, making it a captivating depiction of one of Venice’s most famous landmarks.', 'Santa Maria della Salute at Sunset', 'Realism', 'assets/items/item14.jpg', '1870'),
    (0, 'Giovanni Paolo Panini', 'Ancient Rome, painted by Giovanni Paolo Panini in 1757, is a grand and intricate depiction of the architectural wonders of ancient Rome. The painting is a capriccio, combining various famous Roman landmarks into a single, imaginary scene. It features structures such as the Colosseum, the Pantheon, and the Arch of Constantine, all rendered with Panini’s characteristic precision and attention to detail. The composition is bustling with activity, filled with figures admiring the grandeur of the ancient ruins, which are portrayed with a sense of reverence and nostalgia. Panini’s work reflects the 18th-century fascination with Rome’s classical past and serves as a visual celebration of the city’s enduring legacy.', 'Ancient Rome', 'Baroque', 'assets/items/item15.jpg', '1757'),
    (0, 'Berlinghiero Berlinghieri', 'Madonna and Child, created by Berlinghiero Berlinghieri around 1230, is a remarkable example of Byzantine-influenced Italian painting. The piece portrays the Virgin Mary holding the Christ Child in a tender and solemn embrace. The figures are depicted with elongated, stylized forms, and their expressions are serene and contemplative. The use of gold leaf in the background emphasizes the sacred and divine nature of the subjects. The painting is characterized by its flat, linear style, typical of the Byzantine tradition, with little emphasis on naturalism or depth. This work is significant for its historical context, as it represents the transition from Byzantine to early Italian Gothic art.', 'Madonna and Child', 'Medieval', 'assets/items/item16.jpg', '1230'),
    (0, 'Kawanabe Kyōsai', 'Deer and Monkeys, painted by Kawanabe Kyōsai in 1887, is an exquisite example of Japanese ukiyo-e style. The artwork depicts a tranquil scene of deer and monkeys in a natural setting, embodying the harmonious coexistence of animals in the wild. Kyōsais mastery of brushwork is evident in the delicate and fluid lines, capturing the grace and agility of the animals. The composition reflects Kyōsais deep understanding of traditional Japanese aesthetics, with a focus on balance and simplicity. The painting is also notable for its subtle use of color and shading, which adds depth and dimension to the scene, creating a serene and contemplative atmosphere.', 'Deer and Monkeys', 'Meiji period', 'assets/items/item17.jpg', '1887'),
    (0, 'Paja Jovanović', 'Seoba Srba, or The Migration of the Serbs, is one of the most iconic works by the Serbian painter Paja Jovanović, completed in 1896. This monumental painting captures the historical event of the Great Serbian Migration in 1690, led by Patriarch Arsenije III. Jovanović masterfully depicts the struggle and determination of the Serbian people as they migrate under dire circumstances. The composition is grand and dynamic, with a strong diagonal movement that conveys the sense of journey and hardship. The attention to detail in the portrayal of the people, their clothing, and the surrounding landscape is remarkable, bringing to life the emotional intensity of the event. The painting is not only a historical document but also a powerful symbol of national identity and resilience.', 'Seoba Srba', 'Realism', 'assets/items/item18.jpg', '1896'),
    (0, 'Paja Jovanović', 'Takovski ustanak, or The Uprising at Takovo, is another significant work by the Serbian artist Paja Jovanović, completed in 1898. The painting depicts the momentous event of the Second Serbian Uprising against the Ottoman Empire, led by Prince Miloš Obrenović in 1815. Jovanović captures the dramatic intensity of the moment with great detail, focusing on the figure of Miloš Obrenović as he rallies the people to rise against their oppressors. The composition is filled with movement and emotion, showcasing Jovanovićs skill in portraying historical scenes with both realism and a deep sense of patriotism. The figures are depicted with strong, expressive gestures, and the landscape in the background enhances the narrative of the uprising, symbolizing the struggle and hope of the Serbian people for freedom.', 'Takovski ustanak', 'Realism', 'assets/items/item19.jpg', '1898'),
    (0, 'Paja Jovanović', 'Krunisanje Cara Dušana, or The Coronation of Tsar Dušan, is a celebrated work by Paja Jovanović, completed in 1900. The painting depicts the coronation of Stefan Dušan, a pivotal moment in Serbian history when Dušan declared himself Emperor (Tsar) of the Serbs and Greeks in 1346. Jovanović masterfully captures the grandeur and solemnity of the event, with rich details in the clothing, architecture, and ceremonial objects. The central figure of Dušan is portrayed with regal dignity, surrounded by clerics, nobles, and warriors, all contributing to the majestic atmosphere. The composition is a testament to Jovanovićs ability to bring historical events to life, combining accuracy with artistic expression to evoke a deep sense of national pride and historical significance.', 'Krunisanje Cara Dušana', 'Realism', 'assets/items/item20.jpg', '1900'),
    (0, 'Paja Jovanović', 'Borba petlova, or The Cockfight, is a notable painting by Paja Jovanović, created in 1898. This work showcases a vibrant and lively scene of a traditional cockfight, a popular event in rural communities at the time. Jovanovićs attention to detail is evident in the depiction of the spectators, who are fully engaged in the excitement of the event. The tension of the fight is captured through the dynamic poses of the roosters and the intensity in the faces of the onlookers. The painting reflects Jovanovićs interest in ethnographic subjects and his ability to portray the cultural practices of the people with both realism and a sense of drama. The use of color, light, and composition adds to the vividness of the scene, making it a compelling portrayal of rural life and tradition.', 'Borba petlova', 'Realism', 'assets/items/item21.jpg', '1898'),
    (0, 'Paja Jovanović', 'Kićenje Neveste, or Decorating the Bride, is one of Paja Jovanovićs most famous paintings, completed in 1886. The artwork depicts a traditional Serbian wedding custom where the bride is adorned by her family and friends before the ceremony. Jovanović captures the intricate details of the traditional costumes and the emotional atmosphere of the occasion. The painting is rich with cultural significance, showcasing Jovanovićs mastery in portraying folk customs and the spirit of the Serbian people. The composition draws the viewer into the intimate moment of preparation, filled with both anticipation and solemnity, reflecting the importance of the ritual in the life of the community. The careful use of color and light highlights the ornate costumes and the tender interactions between the figures, making it a celebrated piece in Jovanovićs oeuvre.', 'Kićenje Neveste', 'Realism', 'assets/items/item22.jpg', '1886'),
    (0, 'Uroš Predić', 'Kosovka devojka, or The Kosovo Maiden, is a renowned painting by Uroš Predić, completed in 1919. The artwork depicts a young Serbian woman tending to a wounded knight after the historic Battle of Kosovo in 1389. This painting is one of the most iconic representations of Serbian national history and folklore. Predić masterfully portrays the sorrow and compassion of the maiden as she provides comfort to the fallen warrior. The composition is deeply emotional, reflecting themes of sacrifice, bravery, and the enduring spirit of the Serbian people. The detailed rendering of the maidens attire and the solemn landscape adds to the poignant atmosphere, making it a significant cultural and historical piece in Serbian art.', 'Kosovka devojka', 'Realism', 'assets/items/item23.jpg', '1919'),
    (0, 'Uroš Predić', 'Sveti Sava blagosilja Srpčad (Saint Sava Blesses the Serbian Children) is a deeply symbolic painting by Uroš Predić, created in 1921. The artwork depicts Saint Sava, the first Archbishop of the Serbian Orthodox Church, blessing a group of Serbian children. This painting is revered for its portrayal of Saint Sava as a guiding and protective figure for the Serbian people. Predić’s attention to detail in the children’s traditional attire and the serene, almost divine expression of Saint Sava reflects the strong cultural and religious identity of the Serbian nation. The painting is not only a religious icon but also a representation of the nurturing and educational role that Saint Sava holds in Serbian history and tradition.', 'Sveti Sava blagosilja Srpčad', 'Realism', 'assets/items/item24.jpg', '1921'),
    (0, 'Uroš Predić', 'Sveti Nikola spasava brodolomce (Saint Nicholas Saving the Shipwrecked) is a compelling painting by Uroš Predić, created in 1893. The artwork vividly captures the moment Saint Nicholas, the patron saint of sailors, intervenes to save a group of shipwrecked sailors from a violent storm. Predić masterfully uses light and shadow to emphasize the dramatic scene, with the stormy sea contrasting against the calm, protective figure of Saint Nicholas. The painting is a powerful expression of faith and divine intervention, highlighting the saint’s role as a protector of those in peril.', 'Sveti Nikola spasava brodolomce', 'Realism', 'assets/items/item25.jpg', '1893'),
    (0, 'Uroš Predić', 'Hercegovačke izbeglice (Herzegovinian Refugees) is a poignant painting by Uroš Predić, created in 1889. The artwork depicts the difficult journey of refugees from Herzegovina during a time of conflict. Predić’s attention to detail brings out the hardship and sorrow on the faces of the figures, emphasizing their resilience and endurance. The muted colors and somber tone of the painting reflect the bleak reality of their situation, while the composition directs the viewer’s focus to the central group of refugees, highlighting their shared sense of loss and determination.', 'Hercegovačke izbeglice', 'Realism', 'assets/items/item26.jpg', '1889'),
    (0, 'Uroš Predić', 'Deca pod dudom (Children under the Mulberry Tree) is a charming and tender painting by Uroš Predić, created in 1887. The artwork portrays a group of children gathered under a mulberry tree, engaging in playful activities. Predić captures the innocence and joy of childhood through his use of vibrant colors and dynamic composition. The sunlight filtering through the leaves creates a warm and inviting atmosphere, making the scene feel idyllic and serene. This painting is a beautiful representation of rural life and the simple pleasures found in nature.', 'Deca pod dudom', 'Realism', 'assets/items/item27.jpg', '1887'),
    (0, 'Sava Šumanović', 'Šid pod snegom (Šid Under the Snow) is a mesmerizing winter landscape painted by Sava Šumanović in 1935. The artwork captures the quiet beauty of the town of Šid blanketed in snow. Šumanović’s use of soft, muted tones and delicate brushstrokes evokes a sense of calm and stillness, characteristic of a winter day. The painting reflects the artist’s deep connection to his homeland and his ability to portray the subtle interplay of light and shadow on the snow-covered ground. This piece is a testament to Šumanović’s mastery in capturing the essence of Serbian landscapes.', 'Sid pod snegom', 'Modernism', 'assets/items/item28.jpg', '1935'),
    (0, 'Sava Šumanović', 'Pijana lađa (The Drunken Boat) is one of Sava Šumanovićs most renowned works, created in 1927. The painting is a vivid and expressive depiction of a boat tossed by the waves, symbolizing the tumultuous journey of life. Šumanović’s dynamic use of color and bold brushstrokes convey a sense of movement and emotional intensity. The artwork is inspired by the poem "Le Bateau ivre" by Arthur Rimbaud, and it reflects the artists deep exploration of the human condition and existential themes. This piece is a powerful example of Šumanovićs ability to blend literary inspiration with visual art.', 'Pijana ladja', 'Expressionism', 'assets/items/item29.jpg', '1927'),
    (0, 'Sava Šumanović', 'Cveće (Flowers) is a delicate and vibrant painting created by Sava Šumanović in 1926. This piece showcases the artists masterful use of color and light, capturing the beauty and vitality of blooming flowers. Šumanović’s attention to detail and the harmonious composition of the bouquet reflect his deep appreciation for nature and his skill in translating its essence onto canvas. The painting is celebrated for its balance between realism and artistic expression, making it a cherished work in Šumanovićs oeuvre.', 'Cveće', 'Modernism', 'assets/items/item30.jpg', '1926'),
    (0, 'Gustav Klimt', 'The Kiss, painted by Gustav Klimt in 1908, is one of the most iconic and celebrated works of the early 20th century. This masterpiece represents a couple locked in a tender embrace, their bodies entwined in elaborate, gilded robes that exemplify Klimt’s signature style. The use of gold leaf and intricate patterns creates a sense of opulence, while the intimate portrayal of the figures evokes deep emotion and a connection between the sacred and the sensual. The Kiss is a pinnacle of Klimt’s Golden Phase and a timeless symbol of love and intimacy.', 'The Kiss', 'Symbolism', 'assets/items/item31.jpg', '1908'),
    (0, 'Wassily Kandinsky', 'Composition VIII, created by Wassily Kandinsky in 1923, is a dynamic example of abstract art that showcases the artist’s exploration of geometric forms, color, and spatial relationships. The painting is a vibrant and complex composition where circles, triangles, lines, and other shapes interact on the canvas, creating a sense of rhythm and movement. Kandinsky believed that color and form could express emotion and spiritual ideas, and Composition VIII is a testament to his belief in the power of abstract art to communicate beyond the literal.', 'Composition VIII', 'Abstract', 'assets/items/item32.jpg', '1923'),
    (0, 'Vincent van Gogh', 'Starry Night is one of Van Goghs most famous works, depicting a dreamy interpretation of the artists asylum rooms sweeping view of Saint-Rémy-de-Provence at night. The swirling patterns in the sky, a glowing crescent moon, and a peaceful village below represent the turbulence in Van Goghs mind. Painted with intense, expressive colors, Starry Night embodies Van Goghs unique style, blending his emotional state with the landscape in a symphony of brushstrokes and hues.', 'Starry Night', 'Post-Impressionism', 'assets/items/item33.jpg', '1889'),
    (0, 'Wassily Kandinsky', 'Heavy Red (Teška crvena) is an abstract painting by Wassily Kandinsky, one of the pioneers of abstract art. This piece reflects Kandinskys exploration of color and form, with deep red tones dominating the canvas. The bold shapes and contrasting colors create a dynamic composition that evokes emotions and ideas rather than representing the physical world. Kandinsky believed that art should express the inner experience rather than just depict the external reality, and Heavy Red is a prime example of this philosophy.', 'Heavy Red', 'Abstract', 'assets/items/item34.jpg', '1926'),
    (0, 'Wassily Kandinsky', 'Delicate Tension (Delikatna tenzija) is a work by Wassily Kandinsky, showcasing his unique approach to abstract art. The painting is a symphony of colors and shapes, where lines and forms interact with each other to create a sense of balance and movement. The interplay of soft and intense hues, along with the precise arrangement of geometric elements, conveys a feeling of tension and harmony simultaneously. This piece exemplifies Kandinskys belief in the emotional power of color and form, which he used to express complex ideas and feelings.', 'Delicate Tension', 'Abstract', 'assets/items/item35.jpg', '1923'),
    (0, 'Gustav Klimt', 'Judith I is one of Gustav Klimts most famous works, created in 1901. The painting portrays Judith, a biblical figure known for her beauty and strength, who seduced and beheaded the Assyrian general Holofernes. Klimts depiction of Judith is both seductive and powerful, emphasizing her allure and the intensity of her gaze. The use of gold leaf, intricate patterns, and detailed ornamentation is characteristic of Klimts style, adding a luxurious and otherworldly quality to the painting. Judith I is a masterpiece of Symbolism, embodying themes of power, sensuality, and mortality.', 'Judith I', 'Symbolism', 'assets/items/item36.jpg', '1901'),
    (0, 'Gustav Klimt', 'Mermaids, also known as Sea Serpents, is a lesser-known yet captivating work by Gustav Klimt, created around 1899. The painting delves into the mythological theme of mermaids, blending sensuality and mysticism. Klimts use of vibrant colors and fluid forms creates a dreamlike atmosphere, evoking the allure and mystery of these legendary creatures. The composition is rich with symbolism, reflecting Klints fascination with the feminine form and the enigmatic depths of the sea. This work is a fine example of Klimts early explorations into Symbolism and Art Nouveau.', 'Mermaids', 'Symbolism', 'assets/items/item37.jpg', '1899'),
    (0, 'Katsushika Hokusai', 'Fine Wind, Clear Morning, also known as Red Fuji, is another famous print from Hokusai’s series "Thirty-Six Views of Mount Fuji". This artwork captures Mount Fuji in the early morning light, where the mountain appears red under a clear sky. The image is celebrated for its simplicity, use of color, and the serene depiction of the iconic mountain.', 'Fine Wind, Clear Morning (Red Fuji)', 'Edo period', 'assets/items/item38.jpg', '1831'),
    (0, 'Katsushika Hokusai', 'Sarumaru Dayu is a masterful woodblock print from Katsushika Hokusai, created as part of his famous series "One Hundred Poems Explained by the Nurse". The artwork illustrates the legendary poet Sarumaru Dayu standing beneath a towering pine tree, gazing thoughtfully at a distant mountain. The compositions minimalistic yet striking design captures the serene and introspective atmosphere of the scene. The use of bold lines and subtle color gradients enhances the sense of depth and the emotional resonance of the poets contemplative solitude. This piece is a beautiful example of Hokusai’s ability to merge poetry and visual art.', 'Sarumaru Dayu', 'Edo period', 'assets/items/item39.jpg', '1835'),
    (2, 'Unknown', 'This sculpture, dated to the 4th century B.C., depicts Artemis, the Greek goddess of the hunt, or Bendis, a Thracian deity, accompanied by a Herm of Pan. The sculpture captures the elegance and strength of the goddess, who is portrayed with a serene expression and a poised stance. The Herm of Pan, representing the rustic god of the wild, adds a contrasting element of vitality to the composition. The intricate detailing of the drapery and the naturalistic rendering of the figures exemplify the skill of ancient sculptors in creating lifelike and dynamic representations of deities.', 'Artemis or Bendis with a Herm of Pan', 'Classical Greece', 'assets/items/item40.jpg', '4th century B.C.'),
    (2, 'Unknown', 'This sculpture from the late 4th century B.C. portrays an ephebe, a young man of ancient Greece, dressed in a traveling hat, cloak, and boots. The ephebe is depicted in a relaxed pose, suggesting a moment of pause during a journey. The attire, especially the traveling hat, known as a petasos, and the cloak, or chlamys, is rendered with great attention to detail, reflecting the styles of the period. This sculpture not only highlights the youths beauty and vitality but also offers a glimpse into the clothing and accessories of ancient Greek travelers.', 'Ephebe in Traveling Hat, Cloak, and Boots', 'Late Classical Greece', 'assets/items/item41.jpg', 'Late 4th century B.C.'),
    (2, 'Unknown', 'This fragment of a statue, dating back to the 3rd century B.C., represents a young man from ancient Greece. Although the statue is incomplete, the remaining portion showcases the artists skill in depicting the human form with lifelike detail. The muscular structure and the subtle rendering of the anatomy indicate a focus on idealized youth and beauty, common in Hellenistic sculpture. The fragment suggests that the original statue was of significant size and grandeur, possibly part of a larger composition or a standalone figure.', 'Fragment of a Statue of a Young Man', 'Hellenistic Greece', 'assets/items/item42.jpg', '3rd century B.C.'),
    (2, 'Unknown', 'This sculpture, known as The Holy Trinity, dates back to the early 14th century and is of either English or Spanish origin. It represents the Christian doctrine of the Trinity, depicting the Father, Son, and Holy Spirit in a unified form. The craftsmanship reflects the Gothic style of the period, with intricate details and a sense of divine grace. The figures are carved with solemn expressions, embodying the spiritual significance of the Trinity. The piece would have likely been used in a religious setting, possibly as an altarpiece or devotional object.', 'The Holy Trinity', 'Gothic period', 'assets/items/item43.jpg', '1300/1350'),
    (2, 'Unknown', 'This 14th-century sculpture of Saint Peter is of Venetian origin, dating around 1340. The sculpture is a fine example of Gothic art, showcasing the distinct style of Venetian religious works of the period. Saint Peter is depicted with traditional iconography, often holding the keys to heaven, symbolizing his role as the gatekeeper of the heavenly realm. The craftsmanship is detailed, with careful attention to the facial expression and drapery of the robes. This piece would have been a significant devotional object in a church or chapel.', 'Saint Peter', 'Gothic period', 'assets/items/item44.jpg', '1340'),
    (2, 'Unknown', 'This 14th-century sculpture of Saint Paul, created in Venice around 1340, exemplifies the Gothic style prevalent in religious art of the period. Saint Paul is often depicted holding a sword, representing his martyrdom, and a book, symbolizing his epistles in the New Testament. The sculpture showcases intricate details in the facial expression and the flowing robes, reflecting the reverence and importance of Saint Paul in Christian tradition. This piece likely served as a focal point in a religious setting, offering a powerful visual representation of the apostle.', 'Saint Paul', 'Gothic period', 'assets/items/item45.jpg', '1340'),
    (3, 'Ludovico Mattioli', 'Februarius (February) is a print by Ludovico Mattioli, part of a series depicting the months of the year. Created in the 18th century, this piece embodies the characteristics of February, often associated with cold weather and winter activities. The print is rich in detail, showcasing Mattioli’s skill in capturing the essence of the season through intricate line work and careful composition. This artwork serves as both a visual representation of the month and a celebration of the cycle of the year.', 'Februarius (February)', '18th century', 'assets/items/item46.jpg', '1750'),
    (3, 'Ludovico Mattioli', 'Iunius (June) is another masterful print by Ludovico Mattioli, representing the month of June. This piece, part of his renowned series on the months of the year, captures the essence of early summer with its lively depictions of nature and human activity. The detailed engraving reflects the warmth and vibrancy of June, showcasing Mattioli’s ability to bring the seasonal atmosphere to life through his intricate lines and thoughtful composition.', 'Iunius (June)', '18th century', 'assets/items/item47.jpg', '1750'),
    (3, 'Ludovico Mattioli', 'Januarius (January) by Ludovico Mattioli depicts the cold, serene ambiance of the first month of the year. As part of his series on the months, this print portrays the winter landscape and the activities associated with January. The intricate details of the engraving highlight Mattioli’s skill in capturing the stark beauty of the winter season, making this piece a fine representation of the month’s essence.', 'Januarius (January)', '18th century', 'assets/items/item48.jpg', '1750'),
    (3, 'Israhel van Meckenem', 'Virgin and Child in a Courtyard by Israhel van Meckenem is an exquisite print that illustrates the serene and tender moment between the Virgin Mary and the Child Jesus. Set in a peaceful courtyard, the artwork captures the intimacy and divine connection between mother and child. Van Meckenem’s detailed engraving work brings out the delicate emotions and the holy ambiance, making it a cherished piece of religious art from the late 15th century.', 'Virgin and Child in a Courtyard', 'Late 15th century', 'assets/items/item49.jpg', '1490'),
    (3, 'Israhel van Meckenem', 'Saint Stephen by Israhel van Meckenem is a detailed print depicting the first Christian martyr, Saint Stephen. The artwork captures the solemnity and reverence of the saint, who is traditionally depicted holding the stones that were used to martyr him. Van Meckenem’s fine engraving techniques highlight the textures and the solemn expression, making this print a powerful representation of faith and sacrifice in the late 15th century.', 'Saint Stephen', 'Late 15th century', 'assets/items/item50.jpg', '1490'),
    (3, 'Israhel van Meckenem', 'Saint Quirinus of Neuss by Israhel van Meckenem is a finely detailed print portraying the Roman martyr and saint, Quirinus of Neuss. Known for his steadfast faith, Saint Quirinus is depicted in traditional bishop’s attire, with symbols of his martyrdom. The intricate lines and shading by van Meckenem capture the depth of emotion and the sacred atmosphere, making this print a significant representation of religious devotion in the late 15th century.', 'Saint Quirinus of Neuss', 'Late 15th century', 'assets/items/item51.jpg', '1490'),
    (4, 'Charles Ebbets', 'Lunch Atop a Skyscraper is an iconic photograph taken by Charles Ebbets in 1932. It shows eleven construction workers casually eating lunch, seated on a steel beam without any safety harnesses, high above New York City during the construction of the Rockefeller Center. The image has become a symbol of American resilience and the daring spirit of the workers who helped build the modern cityscape.', 'Lunch Atop a Skyscraper', '40s', 'assets/items/item52.jpg', '1932'),
    (4, 'Alfred Stieglitz', 'The Steerage, taken in 1907 by Alfred Stieglitz, is a pioneering work in the field of modern photography. It captures a scene aboard a transatlantic steamer, with a stark contrast between the upper-class passengers on the deck and the lower-class immigrants in the steerage below. The photograph is celebrated for its composition and its ability to convey a powerful social commentary on class divisions.', 'The Steerage', 'early 20th century', 'assets/items/item53.jpg', '1907'),
    (4, 'Henri Cartier-Bresson', 'Place de l’Europe Gare Saint Lazare, taken in 1932 by Henri Cartier-Bresson, is a quintessential example of his mastery of timing, known as the "decisive moment." The photograph captures a man mid-air as he leaps over a puddle, creating a perfect reflection below. This image exemplifies Cartier-Bressons ability to find and freeze moments of fleeting beauty in everyday life, making it one of the most iconic images in the history of photography.', 'Place de l’Europe Gare Saint Lazare', '40s', 'assets/items/item54.jpg', '1932'),
    (4, 'Dorothea Lange', 'Migrant Mother, captured by Dorothea Lange in 1936, is one of the most enduring images of the Great Depression. The photograph shows Florence Owens Thompson, a destitute pea picker, surrounded by her children, their faces filled with concern and uncertainty. This image became a symbol of the struggles faced by countless families during the economic downturn, highlighting the plight of the impoverished and the resilience of the human spirit. It has since become an iconic representation of this era in American history.', 'Migrant Mother', 'Great Depression', 'assets/items/item55.jpg', '1936'),
    (4, 'Robert Capa', 'The Falling Soldier, taken by Robert Capa in 1936, is one of the most famous war photographs, capturing the exact moment a Spanish Republican soldier is struck by a bullet during the Spanish Civil War. The image is powerful and dramatic, showing the soldier in mid-fall, symbolizing the tragic cost of war. Although there has been debate over the authenticity of the moment captured, the photograph remains a poignant representation of the horrors of conflict.', 'The Falling Soldier', 'Spanish Civil War', 'assets/items/item56.jpg', '1936'),
    (4, 'Sam Shere', 'The Hindenburg disaster photograph by Sam Shere, taken in 1937, is one of the most iconic images in history. It captures the moment the German airship Hindenburg burst into flames as it attempted to dock in New Jersey. The photograph shows the airship engulfed in a massive fireball, with its tail still partially intact. The disaster marked the end of the airship era, and Sheres image remains a powerful reminder of the tragedy.', 'Hindenburg', '20th Century', 'assets/items/item57.jpg', '1937'),
    (4, 'Yousuf Karsh', 'The Roaring Lion, a powerful portrait taken by Yousuf Karsh in 1941, captures British Prime Minister Winston Churchill in a moment of defiance and determination during World War II. The photograph, taken after Karsh famously removed Churchill’s cigar, reveals a stern and resolute expression that symbolized the British resolve during the war. The image has since become one of the most iconic portraits of the 20th century, embodying the spirit of leadership and resilience.', 'The Roaring Lion', 'World War II', 'assets/items/item58.jpg', '1941'),
    (4, 'Alfred Eisenstaedt', 'V-J Day in Times Square, captured by Alfred Eisenstaedt in 1945, is one of the most iconic photographs of the 20th century. The image shows an exuberant sailor kissing a nurse in the middle of Times Square, celebrating the end of World War II. The photograph became a symbol of the joy and relief felt across the world at the conclusion of the war. It represents a spontaneous moment of happiness and the beginning of a new era of peace.', 'V-J Day in Times Square', '20th Century', 'assets/items/item59.jpg', '1945'),
    (4, 'Joe Rosenthal', 'Flag Raising at Iwo Jima, taken by Joe Rosenthal in 1945, is a powerful photograph that became an enduring symbol of American patriotism. The image captures six U.S. Marines raising the American flag atop Mount Suribachi during the Battle of Iwo Jima in World War II. This moment of triumph and sacrifice was widely circulated, boosting morale and becoming one of the most iconic images of the war. The photograph later served as the inspiration for the Marine Corps War Memorial.', 'Flag Raising at Iwo Jima', '20th Century', 'assets/items/item60.jpg', '1945'),
    (4, 'Arthur Sasse', 'This famous photograph of Albert Einstein, captured by Arthur Sasse in 1951, shows the renowned physicist sticking out his tongue. Taken on Einsteins 72nd birthday, the image has since become one of the most iconic and playful representations of the genius. It highlights a lighter, more human side of Einstein, contrasting with his serious public image. The photograph has been widely reproduced and remains a symbol of Einsteins unique personality.', 'Albert Einstein', '20th Century', 'assets/items/item61.jpg', '1951'),
    (4, 'Sam Shaw', 'This iconic photograph of Marilyn Monroe, taken by Sam Shaw in 1954, captures the Hollywood star in one of her most famous poses. The image shows Monroe standing over a subway grate, with her white dress billowing upwards, which became a defining moment in her career. The photograph was taken during the filming of "The Seven Year Itch" and has since become an emblem of Monroes enduring legacy and sex appeal, representing the golden age of Hollywood.', 'Marilyn Monroe', '20th Century', 'assets/items/item62.jpg', '1954'),
    (4, 'Robert H Jackson', 'This historic photograph captured the moment of the assassination of Lee Harvey Oswald, the man accused of killing President John F. Kennedy. Taken by Robert H. Jackson on November 24, 1963, it shows Jack Ruby, a nightclub owner, shooting Oswald as he was being transferred from the Dallas police headquarters. The image is one of the most famous and shocking photographs in American history, symbolizing the chaotic aftermath of the Kennedy assassination.', 'Assassination of Lee Harvey Oswald', '20th Century', 'assets/items/item63.jpg', '1963'),
    (4, 'Malcolm Browne', 'This powerful photograph, taken by Malcolm Browne on June 11, 1963, depicts the self-immolation of Thích Quảng Đức, a Vietnamese Mahayana Buddhist monk. The monk set himself on fire at a busy intersection in Saigon to protest the persecution of Buddhists by the South Vietnamese government. The image, which spread rapidly around the world, brought international attention to the struggles in Vietnam and remains one of the most iconic images of protest and resistance.', 'Burning Monk', '20th Century', 'assets/items/item64.jpg', '1963'),
    (4, 'Neil Leifer', 'This iconic photograph, captured by Neil Leifer on May 25, 1965, shows Muhammad Ali standing triumphantly over a fallen Sonny Liston during their heavyweight championship rematch in Lewiston, Maine. Ali’s pose, with his fist clenched and muscles tensed, has become one of the most recognized images in sports history. The photo captures the moment Ali demanded that Liston rise and continue the fight, symbolizing Ali’s dominance and charisma both inside and outside the ring.', 'Muhammad Ali v Sonny Liston', '20th Century', 'assets/items/item65.jpg', '1965'),
    (4, 'Eddie Adams', 'Captured on February 1, 1968, during the Vietnam War, this powerful and controversial photograph by Eddie Adams shows the execution of a Viet Cong prisoner by South Vietnamese General Nguyễn Ngọc Loan in Saigon. The stark brutality of the image shocked the world and became a symbol of the horrors of war. Despite its raw depiction of violence, the photo won the Pulitzer Prize for Spot News Photography and significantly influenced public opinion about the Vietnam War.', 'Saigon Execution', '20th Century', 'assets/items/item66.jpg', '1969'),
    (4, 'Iain Macmillan', 'This iconic photograph was taken by Iain Macmillan on August 8, 1969, for the cover of The Beatles album "Abbey Road." The image shows the band members crossing the zebra crossing outside Abbey Road Studios in London. It has since become one of the most famous and imitated images in popular culture. The simplicity and spontaneity of the shot, combined with its association with The Beatles, have made it an enduring symbol of the 1960s.', 'Abbey Road', '20th Century', 'assets/items/item67.jpg', '1969'),
    (4, 'John Filo', 'This powerful photograph was taken by John Filo on May 4, 1970, during the Kent State shootings. The image captures a 14-year-old runaway, Mary Ann Vecchio, kneeling over the body of Jeffrey Miller, one of the four students killed by the Ohio National Guard during a protest against the invasion of Cambodia. The photo won the Pulitzer Prize and became a symbol of the anti-war movement and the national unrest during the Vietnam War era.', 'Kent State shooting', '20th Century', 'assets/items/item68.jpg', '1970'),
    (4, 'Nick Ut', 'This iconic photograph, taken by Nick Ut on June 8, 1972, during the Vietnam War, depicts a young girl, Phan Thi Kim Phuc, running naked down a road after being severely burned by a napalm attack. The image, often referred to as “Napalm Girl,” captured the horrors of the war and played a significant role in shifting public opinion against the conflict. The photograph won a Pulitzer Prize and remains one of the most powerful images in the history of photojournalism.', 'The Terror of War (“Napalm Girl”)', '20th Century', 'assets/items/item69.jpg', '1972'),
    (4, 'Steve McCurry', 'Taken in December 1984 by Steve McCurry, "Afghan Girl" is one of the most iconic portraits in the history of photography. The image depicts Sharbat Gula, a young Afghan refugee with piercing green eyes, living in a refugee camp in Pakistan during the Soviet occupation of Afghanistan. The photograph was published on the cover of National Geographic in June 1985, bringing worldwide attention to the plight of refugees.', 'Afghan Girl', '20th Century', 'assets/items/item70.jpg', '1984'),
    (4, 'Jeff Widener', 'Captured by Jeff Widener on June 5, 1989, "Tank Man" is a powerful photograph showing an unidentified man standing in front of a column of tanks during the Tiananmen Square protests in Beijing, China. The image symbolizes the courage and defiance of the individual against oppressive forces, and has become one of the most enduring symbols of resistance and peaceful protest in the face of authoritarianism.', 'Tank Man', '20th Century', 'assets/items/item71.jpg', '1989');


-- Insert Item Reservations for "Medieval Treasures" Exhibition (ID 2)
INSERT INTO item_reservation (item_id, start_date, end_date, exhibition_id) VALUES
    (3, '2024-06-25', '2024-10-25', 1),
    (5, '2024-06-25', '2024-10-25', 1),
    (6, '2024-06-25', '2024-10-25', 1),
    (33, '2024-06-25', '2024-10-25', 1),
    (13, '2024-06-25', '2024-10-25', 1),
    (4, '2024-06-25', '2024-10-25', 1),

    (1, '2024-07-01', '2024-10-30', 2),
    (38, '2024-07-01', '2024-10-30', 2),
    (39, '2024-07-01', '2024-10-30', 2),
    (17, '2024-07-01', '2024-10-30', 2),

    (52, '2024-07-15', '2024-10-15', 3),
    (53, '2024-07-15', '2024-10-15', 3),
    (54, '2024-07-15', '2024-10-15', 3),
    (55, '2024-07-15', '2024-10-15', 3),
    (56, '2024-07-15', '2024-10-15', 3),
    (57, '2024-07-15', '2024-10-15', 3),
    (58, '2024-07-15', '2024-10-15', 3),
    (59, '2024-07-15', '2024-10-15', 3),
    (60, '2024-07-15', '2024-10-15', 3),
    (61, '2024-07-15', '2024-10-15', 3),
    (62, '2024-07-15', '2024-10-15', 3),
    (63, '2024-07-15', '2024-10-15', 3),
    (64, '2024-07-15', '2024-10-15', 3),
    (65, '2024-07-15', '2024-10-15', 3),
    (66, '2024-07-15', '2024-10-15', 3),
    (67, '2024-07-15', '2024-10-15', 3),
    (68, '2024-07-15', '2024-10-15', 3),
    (69, '2024-07-15', '2024-10-15', 3),
    (70, '2024-07-15', '2024-10-15', 3),
    (71, '2024-07-15', '2024-10-15', 3),

    (7, '2024-08-04', '2024-11-04', 4),
    (8, '2024-08-04', '2024-11-04', 4),
    (14, '2024-08-04', '2024-11-04', 4),

    (9, '2024-08-20', '2024-10-20', 5),
    (15, '2024-08-20', '2024-10-20', 5),
    (11, '2024-08-20', '2024-10-20', 5),
    (10, '2024-08-20', '2024-10-20', 5),
    (2, '2024-08-20', '2024-10-20', 5),

    (18, '2024-08-27', '2024-10-27', 6),
    (19, '2024-08-27', '2024-10-27', 6),
    (20, '2024-08-27', '2024-10-27', 6),
    (21, '2024-08-27', '2024-10-27', 6),
    (22, '2024-08-27', '2024-10-27', 6),

    (23, '2024-08-30', '2024-12-30', 7),
    (24, '2024-08-30', '2024-12-30', 7),
    (25, '2024-08-30', '2024-12-30', 7),
    (26, '2024-08-30', '2024-12-30', 7),
    (27, '2024-08-30', '2024-12-30', 7),

    (31, '2024-09-01', '2025-01-01', 8),
    (36, '2024-09-01', '2025-01-01', 8),
    (37, '2024-09-01', '2025-01-01', 8),

    (28, '2024-10-15', '2025-01-15', 9),
    (29, '2024-10-15', '2025-01-15', 9),
    (30, '2024-10-15', '2025-01-15', 9),

    (32, '2024-10-30', '2025-02-01', 10),
    (34, '2024-10-30', '2025-02-01', 10),
    (35, '2024-10-30', '2025-02-01', 10),

    (40, '2024-12-01', '2025-03-01', 11),
    (41, '2024-12-01', '2025-03-01', 11),
    (42, '2024-12-01', '2025-03-01', 11),

    (43, '2025-01-10', '2025-03-28', 12),
    (44, '2025-01-10', '2025-03-28', 12),
    (45, '2025-01-10', '2025-03-28', 12),

    (46, '2025-01-15', '2025-04-30', 13),
    (47, '2025-01-15', '2025-04-30', 13),
    (48, '2025-01-15', '2025-04-30', 13),
    (49, '2025-01-15', '2025-04-30', 13),
    (50, '2025-01-15', '2025-04-30', 13),
    (51, '2025-01-15', '2025-04-30', 13),
--closed
    (31, '2021-09-01', '2022-01-01', 14),
    (36, '2021-09-01', '2022-01-01', 14),
    (37, '2021-09-01', '2022-01-01', 14),

    (46, '2022-01-15', '2022-04-30', 15),
    (47, '2022-01-15', '2022-04-30', 15),
    (48, '2022-01-15', '2022-04-30', 15),
    (49, '2022-01-15', '2022-04-30', 15),
    (50, '2022-01-15', '2022-04-30', 15),
    (51, '2022-01-15', '2022-04-30', 15),

    (7, '2022-06-04', '2022-08-04', 16),
    (8, '2022-06-04', '2022-08-04', 16),
    (14, '2022-06-04', '2022-08-04', 16),

    (1, '2022-07-01', '2022-10-30', 17),
    (38, '2022-07-01', '2022-10-30', 17),
    (39, '2022-07-01', '2022-10-30', 17),
    (17, '2022-07-01', '2022-10-30', 17),

    (32, '2022-10-30', '2023-02-01', 18),
    (34, '2022-10-30', '2023-02-01', 18),
    (35, '2022-10-30', '2023-02-01', 18),

    (3, '2023-06-25', '2023-10-25', 19),
    (5, '2023-06-25', '2023-10-25', 19),
    (6, '2023-06-25', '2023-10-25', 19),
    (33, '2023-06-25', '2023-10-25', 19),
    (13, '2023-06-25', '2023-10-25', 19),
    (4, '2023-06-25', '2023-10-25', 19),

    (18, '2023-08-27', '2023-10-27', 20),
    (19, '2023-08-27', '2023-10-27', 20),
    (20, '2023-08-27', '2023-10-27', 20),
    (21, '2023-08-27', '2023-10-27', 20),
    (22, '2023-08-27', '2023-10-27', 20),

    (23, '2023-10-10', '2023-12-30', 21),
    (24, '2023-10-10', '2023-12-30', 21),
    (25, '2023-10-10', '2023-12-30', 21),
    (26, '2023-10-10', '2023-12-30', 21),
    (27, '2023-10-10', '2023-12-30', 21),

    (28, '2024-02-15', '2024-05-15', 22),
    (29, '2024-02-15', '2024-05-15', 22),
    (30, '2024-02-15', '2024-05-15', 22);




INSERT INTO ticket(number_of_adults, number_of_minors, total_price, exhibition_id, guest_id) VALUES
-- The Golden Age of Gustav Klimt (15-20 karata)
     (3, 2, 72.00, 14, 1),
     (2, 0, 32.00, 14, 2),
     (1, 1, 24.00, 14, 3),
     (4, 1, 80.00, 14, 4),
     (2, 3, 64.00, 14, 5),
     (3, 2, 72.00, 14, 6),
     (2, 0, 32.00, 14, 7),
     (1, 1, 24.00, 14, 8),
     (4, 1, 80.00, 14, 9),
     (2, 2, 64.00, 14, 10),
     (3, 1, 68.00, 14, 11),
     (2, 2, 64.00, 14, 12),
     (1, 0, 16.00, 14, 13),
     (3, 2, 72.00, 14, 14),
     (4, 0, 64.00, 14, 15),
     (2, 1, 40.00, 14, 16),
     (3, 2, 72.00, 14, 17),
     (1, 1, 24.00, 14, 18),
     (2, 0, 32.00, 14, 19),
     (3, 1, 60.00, 14, 20),
-- The Art of Printmaking: Renaissance Masters (10-15 karata)
     (1, 1, 21.00, 15, 1),
     (3, 2, 77.00, 15, 2),
     (2, 0, 28.00, 15, 3),
     (4, 1, 63.00, 15, 4),
     (2, 1, 35.00, 15, 5),
     (3, 0, 42.00, 15, 6),
     (2, 2, 56.00, 15, 7),
     (1, 1, 21.00, 15, 8),
     (3, 1, 56.00, 15, 9),
     (2, 0, 28.00, 15, 10),
     (3, 2, 77.00, 15, 11),
     (4, 0, 56.00, 15, 12),
     (2, 1, 35.00, 15, 13),
-- Monet and the Masters of Light (10-15 karata)
     (2, 0, 26.00, 16, 1),
     (3, 1, 51.00, 16, 2),
     (1, 2, 25.00, 16, 3),
     (4, 0, 52.00, 16, 4),
     (3, 3, 69.00, 16, 5),
     (2, 0, 26.00, 16, 6),
     (1, 1, 19.00, 16, 7),
     (3, 1, 51.00, 16, 8),
     (2, 0, 26.00, 16, 9),
     (3, 2, 69.00, 16, 10),
     (4, 0, 52.00, 16, 11),
-- The Mastery of Katsushika Hokusai and Kawanabe Kyōsai (15-20 karata)
     (2, 1, 39.00, 17, 1),
     (4, 0, 60.00, 17, 2),
     (3, 2, 81.00, 17, 3),
     (1, 3, 42.00, 17, 4),
     (2, 2, 48.00, 17, 5),
     (3, 1, 66.00, 17, 6),
     (2, 1, 39.00, 17, 7),
     (1, 2, 42.00, 17, 8),
     (4, 0, 60.00, 17, 9),
     (3, 1, 66.00, 17, 10),
     (2, 3, 93.00, 17, 11),
     (1, 1, 24.00, 17, 12),
     (3, 2, 81.00, 17, 13),
     (2, 0, 30.00, 17, 14),
     (4, 2, 96.00, 17, 15),
     (1, 1, 24.00, 17, 16),
     (3, 2, 81.00, 17, 17),
     (2, 0, 30.00, 17, 18),
-- Wassily Kandinsky: Abstract Expressionism (5-10 karata)
     (1, 0, 12.00, 18, 1),
     (2, 2, 42.00, 18, 2),
     (3, 1, 45.00, 18, 3),
     (4, 0, 48.00, 18, 4),
     (2, 0, 24.00, 18, 5),
     (3, 0, 36.00, 18, 6),
     (1, 2, 21.00, 18, 7),
     (4, 1, 51.00, 18, 8),
     (2, 0, 24.00, 18, 9),
-- Van Gogh and the Masters of Impressionism (10-15 karata)
     (3, 2, 77.00, 19, 1),
     (2, 0, 28.00, 19, 2),
     (4, 1, 63.00, 19, 3),
     (3, 2, 77.00, 19, 4),
     (2, 3, 91.00, 19, 5),
     (1, 0, 14.00, 19, 6),
     (3, 2, 77.00, 19, 7),
     (4, 0, 56.00, 19, 8),
     (2, 1, 35.00, 19, 9),
     (3, 1, 63.00, 19, 10),
     (4, 1, 63.00, 19, 11),
-- The Art of Paja Jovanović (10-15 karata)
     (2, 1, 34.00, 20, 1),
     (3, 2, 77.00, 20, 2),
     (4, 0, 52.00, 20, 3),
     (1, 2, 29.00, 20, 4),
     (2, 0, 26.00, 20, 5),
     (3, 1, 52.00, 20, 6),
     (1, 1, 21.00, 20, 7),
     (2, 2, 56.00, 20, 8),
     (3, 0, 39.00, 20, 9),
     (4, 1, 60.00, 20, 10),
     (2, 0, 26.00, 20, 11),
     (1, 1, 21.00, 20, 12),
-- Uroš Predić: Realism and Tradition (5-10 karata)
     (2, 0, 16.00, 21, 1),
     (1, 1, 15.00, 21, 2),
     (3, 2, 53.00, 21, 3),
     (4, 0, 32.00, 21, 4),
     (2, 3, 50.00, 21, 5),
     (1, 1, 15.00, 21, 6),
     (3, 0, 24.00, 21, 7),
     (2, 0, 16.00, 21, 8),
     (4, 1, 32.00, 21, 9),

--trenutno otvorene izlozbe

--"Van Gogh and the Masters of Impressionism" (10-15 sold tickets)
    (2, 1, 30.00, 1, 1),
    (1, 0, 12.00, 1, 2),
    (3, 2, 54.00, 1, 3),
    (1, 1, 18.00, 1, 4),
    (2, 2, 36.00, 1, 5),
    (1, 0, 12.00, 1, 6),
    (2, 1, 30.00, 1, 7),
    (3, 0, 36.00, 1, 8),
    (1, 1, 18.00, 1, 9),
    (1, 0, 12.00, 1, 10),
-- The Mastery of Katsushika Hokusai and Kawanabe Kyōsai" (10-15 sold tickets)
    (2, 1, 35.00, 2, 11),
    (3, 2, 63.00, 2, 12),
    (1, 0, 14.00, 2, 13),
    (1, 1, 21.00, 2, 14),
    (3, 0, 42.00, 2, 15),
    (2, 2, 42.00, 2, 16),
    (1, 1, 21.00, 2, 17),
    (2, 1, 35.00, 2, 18),
    (1, 0, 14.00, 2, 19),
    (1, 1, 21.00, 2, 20),
--"Icons of 20th Century Photography" (10-15 sold tickets)
    (2, 2, 54.00, 3, 1),
    (1, 0, 18.00, 3, 2),
    (3, 2, 81.00, 3, 3),
    (1, 1, 27.00, 3, 4),
    (2, 1, 45.00, 3, 5),
    (1, 0, 18.00, 3, 6),
    (2, 1, 45.00, 3, 7),
    (3, 0, 54.00, 3, 8),
    (1, 1, 27.00, 3, 9),
    (1, 0, 18.00, 3, 10),
--"Monet and the Masters of Light" (5-10 sold tickets)
    (2, 1, 35.00, 4, 11),
    (1, 0, 14.00, 4, 12),
    (3, 2, 63.00, 4, 13),
    (1, 1, 21.00, 4, 14),
    (2, 1, 35.00, 4, 15),
    (1, 0, 14.00, 4, 16),
    (2, 2, 56.00, 4, 17),
-- Exhibition 5: "The Power of the Past: Neoclassicism and Romanticism" (5-10 sold tickets)
    (2, 1, 40.00, 5, 18),
    (1, 0, 16.00, 5, 19),
    (3, 2, 80.00, 5, 20),
    (1, 1, 24.00, 5, 1),
    (2, 1, 40.00, 5, 2),
-- Exhibition 6: "The Art of Paja Jovanović" (5-10 sold tickets)
    (2, 1, 35.00, 6, 3),
    (1, 0, 14.00, 6, 4),
    (3, 2, 63.00, 6, 5),
    (1, 1, 21.00, 6, 6),
    (2, 1, 35.00, 6, 7),
-- Exhibition 7: "Uroš Predić: Realism and Tradition" (5-10 sold tickets)
    (2, 1, 31.00, 7, 8),
    (1, 0, 13.00, 7, 9),
    (3, 2, 65.00, 7, 10),
    (1, 1, 19.00, 7, 11),
    (2, 1, 31.00, 7, 12),
-- Exhibition 8: "The Golden Age of Gustav Klimt" (5-10 sold tickets)
    (2, 1, 39.00, 8, 13),
    (1, 0, 15.00, 8, 14),
    (3, 2, 78.00, 8, 15),
    (1, 1, 24.00, 8, 16),
    (2, 1, 39.00, 8, 17),

--buduce izlozbe

--"Sava Šumanović: The Serbian Modernist" (7-9 karata)
    (2, 1, 27.00, 9, 1),
    (1, 1, 15.00, 9, 2),
    (2, 0, 24.00, 9, 3),
    (1, 2, 18.00, 9, 4),
    (3, 1, 42.00, 9, 5),
    (1, 1, 15.00, 9, 6),
    (2, 0, 24.00, 9, 7),
    (1, 2, 18.00, 9, 8),
    (2, 0, 24.00, 9, 9),
--"Wassily Kandinsky: Abstract Expressionism" (7-9 karata)
    (2, 1, 46.00, 10, 10),
    (1, 0, 14.00, 10, 11),
    (3, 2, 75.00, 10, 12),
    (2, 1, 46.00, 10, 13),
    (1, 0, 14.00, 10, 14),
    (2, 0, 28.00, 10, 15),
    (3, 0, 42.00, 10, 16),
    (1, 1, 23.00, 10, 17),
    (2, 1, 46.00, 10, 18),
--"Greek Sculpture: Gods and Ephebes" (4-6 karata)
    (2, 0, 26.00, 11, 19),
    (1, 1, 21.00, 11, 20),
    (3, 0, 39.00, 11, 21),
    (1, 2, 29.00, 11, 1),
    (2, 1, 34.00, 11, 2),
--"Medieval Sculpture: Faith in Stone" (0-3 karata)
    (1, 0, 8.00, 12, 3),
    (1, 1, 15.00, 12, 4),
    (2, 0, 16.00, 12, 5),
--"The Art of Printmaking: Renaissance Masters" (4-6 karata)
    (2, 1, 26.00, 13, 6),
    (1, 0, 10.00, 13, 7),
    (3, 2, 54.00, 13, 8),
    (1, 1, 16.00, 13, 9),
    (2, 0, 20.00, 13, 10),
    (1, 2, 22.00, 13, 11);

-- Insert Reviews for "Medieval Treasures" Exhibition (ID 2)
INSERT INTO review(guest_id, exhibition_id, rating, review_date) VALUES
    (1, 2, 5, now()),  -- Review by Veljko (guest ID 1)
    (2, 2, 4, now()),  -- Review by Dokma (guest ID 2)
    (2, 2, 5, now()),  -- Review by Veljko (guest ID 1)
    (4, 2, 2, now()),  -- Review by Dokma (guest ID 2)
    (4, 2, 1, now()),  -- Review by Veljko (guest ID 1)
    (1, 2, 5, now()),  -- Review by Dokma (guest ID 2)
    (3, 6, 4, now());  -- Review by Dokma (guest ID 2)








