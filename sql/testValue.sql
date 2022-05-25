INSERT INTO public.t_author (id, name) VALUES (100, 'Aa');
INSERT INTO public.t_author (id, name) VALUES (101, 'Ba');
INSERT INTO public.t_author (id, name) VALUES (102, 'Ca');


INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (100, '1200-05-25 20:47:22.000000', 'A0', 100);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (101, '1000-05-25 20:47:10.000000', 'A1', 101);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (102, '2017-05-25 20:47:06.000000', 'A2', 101);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (103, '2022-05-25 20:47:03.000000', 'A3', 100);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (104, '2022-05-25 20:47:00.000000', 'A4', 102);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (105, '2006-05-25 20:46:53.000000', 'A5', 101);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (106, '2024-05-26 20:46:45.000000', 'A6', 102);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (107, '1500-05-25 20:46:39.000000', 'A7', 100);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (108, '2013-05-25 20:46:35.000000', 'A8', 101);
INSERT INTO public.t_book (id, release_date, title, author_id) VALUES (109, '2022-05-25 20:46:28.000000', 'A9', 100);


INSERT INTO public.t_user (id, login, password, registration_date) VALUES (100, 'test', 'test', '2022-05-25 20:45:13.000000');
INSERT INTO public.t_user (id, login, password, registration_date) VALUES (101, 'testv1', 'testv1', '2022-05-25 20:45:27.000000');
