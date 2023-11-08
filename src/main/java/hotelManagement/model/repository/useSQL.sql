#drop database hotelmanegement;
#create database hotelmanegement;
use hotelmanegement;
# ------------------------회원 관련 테이블


# memberinfo (회원 공통 정보)

INSERT INTO memberinfo (mno, mtype, mname, msex, mphone, mbirth, cdate)
VALUES
    (1, 1, '홍길동', '남성', '01011111111', '19990630', NOW()),
    (2, 0, '이순신', '남성', '01012345678', '19900101', NOW()),
    (3, 1, '신혜선', '여성', '01032321111', '19831211', NOW()),
    (4, 0, '김영희', '여성', '01023456789', '19910202', NOW()),
    (5, 0, '이태승', '남성', '01090123456', '19980909', NOW()),
    (6, 0, '박영숙', '여성', '01001234567', '19991010', NOW()),
    (7, 1, '신동엽', '남성', '01050321232', '19880201', NOW()),
    (8, 1, '김선미', '여성', '01014234444', '19900312', NOW()),
    (9, 1, '서선화', '여성', '01088321234', '20001222', NOW()),
    (10, 0, '정미영', '여성', '01045678901', '19930404', NOW()),
    (11, 1, '차태현', '남성', '01065436666', '19710203', NOW()),
    (12, 1, '김문화', '남성', '01032136634', '19881021', NOW()),
    (13, 0, '박철수', '남성', '01034567890', '19920303', NOW()),
    (14, 1, '이지석', '남성', '01098321333', '19980312', NOW()),
    (15, 1, '김태승', '남성', '01043565121', '19910405', NOW()),
    (16, 1, '박민성', '남성', '01064231321', '19861011', NOW()),
    (17, 0, '홍길동', '남성', '01056789012', '19940505', NOW()),
    (18, 0, '송미정', '여성', '01067890123', '19950606', NOW()),
    (19, 0, '이상호', '남성', '01078901234', '19960707', NOW()),
    (20, 0, '김지석', '여성', '01089012345', '19970808', NOW()),
    (21, 1, '김영호', '남성', '01011112222', '19950715', NOW()),
    (22, 1, '이지은', '여성', '01012344321', '19881228', NOW()),
    (23, 1, '박민준', '남성', '01032321234', '19900403', NOW()),
    (24, 1, '정서영', '여성', '01011223344', '19871117', NOW()),
    (25, 1, '이영철', '남성', '01099998888', '19911122', NOW()),
    (26, 1, '한미경', '여성', '01023456789', '19870214', NOW()),
    (27, 1, '송재현', '남성', '01078787878', '19930330', NOW()),
    (28, 1, '김지우', '남성', '01033332222', '19870407', NOW()),
    (29, 1, '임미희', '여성', '01012340000', '19961209', NOW()),
    (30, 1, '박준호', '남성', '01056781234', '19860914', NOW()),
    (31, 1, '최영미', '여성', '01033333333', '19980418', NOW()),
    (32, 1, '김동희', '남성', '01000001111', '19851129', NOW()),
    (33, 1, '이민수', '남성', '01015557777', '19970820', NOW()),
    (34, 1, '신지영', '여성', '01033336666', '19850625', NOW()),
    (35, 1, '한주영', '남성', '01044445555', '19951231', NOW()),
    (36, 1, '김현우', '남성', '01056781111', '19831212', NOW()),
    (37, 1, '이지원', '여성', '01034562345', '19930808', NOW()),
    (38, 1, '박유정', '여성', '01099999999', '19891223', NOW()),
    (39, 1, '정민지', '여성', '01088887777', '19920602', NOW()),
    (40, 1, '김정호', '남성', '01011112233', '19891228', NOW()),
    (41, 0, '김성호', '남성', '01011112222', '19890615', NOW()),
    (42, 0, '박지은', '여성', '01012344321', '19871228', NOW()),
    (43, 0, '정민준', '남성', '01032321234', '19910403', NOW()),
    (44, 0, '이서영', '여성', '01011223344', '19861117', NOW()),
    (45, 0, '김영철', '남성', '01099998888', '19911122', NOW()),
    (46, 0, '박미경', '여성', '01023456789', '19870214', NOW()),
    (47, 0, '김재현', '남성', '01078787878', '19930330', NOW()),
    (48, 0, '박지우', '남성', '01033332222', '19870407', NOW()),
    (49, 0, '임미희', '여성', '01012340000', '19961209', NOW()),
    (50, 0, '최준호', '남성', '01056781234', '19860914', NOW()),
    (51, 0, '신영미', '여성', '01033333333', '19980418', NOW()),
    (52, 0, '강동희', '남성', '01000001111', '19851129', NOW()),
    (53, 1, '강민우', '남성', '01033332222', '19991231', NOW()),
    (54, 0, '이유진', '여성', '01012340000', '19951209', NOW()),
    (55, 1, '송지호', '남성', '01056781234', '19860914', NOW()),
    (56, 0, '김영미', '여성', '01033333333', '19980418', NOW()),
    (57, 1, '박민서', '남성', '01000001111', '19851129', NOW()),
    (58, 0, '이서수', '여성', '01015557777', '19970820', NOW()),
    (59, 1, '장영희', '남성', '01033336666', '19850625', NOW()),
    (60, 0, '정수정', '여성', '01044445555', '19951231', NOW()),
    (61, 1, '이동우', '남성', '01056781111', '19831212', NOW()),
    (62, 0, '신지원', '여성', '01034562345', '19930808', NOW()),
    (63, 1, '한유정', '여성', '01099999999', '19891223', NOW()),
    (64, 0, '김민지', '여성', '01088887777', '19920602', NOW()),
    (65, 1, '박정호', '남성', '01011112233', '19891228', NOW()),
    (66, 0, '김민철', '남성', '01012345678', '19901212', NOW()),
    (67, 1, '신영철', '남성', '01098765432', '19910201', NOW()),
    (68, 0, '박영미', '여성', '01012341234', '19920302', NOW()),
    (69, 1, '이민수', '남성', '01099993333', '19930403', NOW()),
    (70, 0, '김영화', '여성', '01055556666', '19940404', NOW()),
    (71, 1, '이현우', '남성', '01055557777', '19950909', NOW()),
    (72, 0, '박영희', '여성', '01012348765', '19901210', NOW()),
    (73, 1, '장민지', '여성', '01033334444', '19950220', NOW()),
    (74, 0, '김민서', '남성', '01044445555', '19930228', NOW()),
    (75, 1, '박민호', '남성', '01055556666', '19970407', NOW()),
    (76, 0, '강영숙', '여성', '01098765432', '19960205', NOW()),
    (77, 1, '이민지', '여성', '01012341234', '19930123', NOW()),
    (78, 0, '신민수', '남성', '01099993333', '19910111', NOW()),
    (79, 1, '김영화', '여성', '01022221111', '19931119', NOW()),
    (80, 0, '박현우', '남성', '01012345678', '19970907', NOW()),
    (81, 1, '이순신', '남성', '01033333333', '19940806', NOW()),
    (82, 0, '신사랑', '여성', '01055555555', '19950214', NOW()),
    (83, 1, '박정호', '남성', '01098788888', '19970304', NOW()),
    (84, 0, '김동해', '남성', '01012341234', '19901121', NOW()),
    (85, 1, '정지원', '여성', '01099999999', '19960829', NOW()),
    (86, 0, '신동우', '남성', '01055557777', '19921025', NOW()),
    (87, 1, '김민아', '여성', '01055555555', '19940809', NOW()),
    (88, 0, '박하늘', '여성', '01012346789', '19971211', NOW()),
    (89, 1, '이해찬', '남성', '01044448888', '19920110', NOW()),
    (90, 0, '송유진', '여성', '01055555555', '19940714', NOW()),
    (91, 1, '정윤하', '여성', '01022223333', '19970327', NOW()),
    (92, 0, '강우리', '여성', '01012341234', '19980218', NOW()),
    (93, 1, '신도영', '남성', '01044441111', '19960224', NOW()),
    (94, 0, '이재은', '여성', '01098766543', '19950217', NOW()),
    (95, 1, '김현영', '여성', '01055553333', '19920303', NOW()),
    (96, 0, '박혜경', '여성', '01012340000', '19990101', NOW()),
    (97, 1, '홍영수', '남성', '01044447777', '19960716', NOW()),
    (98, 0, '정지영', '여성', '01055555555', '19941225', NOW()),
    (99, 1, '김수민', '여성', '01012345555', '19921231', NOW()),
    (100, 0, '박다은', '여성', '01033331111', '19980218', NOW());

# member 샘플 코드 (회원)
INSERT INTO member (mid, mpwd, mno_fk)
VALUES
    ('qwe123', 'Al123456@', 1),
    ('abc456', 'Bc789012@', 3),
    ('def123', 'Df901234@', 7),
    ('xyz789', 'Xy345678@', 8),
    ('lmn456', 'Lm567890@', 9),
    ('pqw789', 'Pq123456@', 11),
    ('uvw123', 'Uv789012@', 12),
    ('ijk456', 'Ij345678@', 14),
    ('mno789', 'Mn901234@', 15),
    ('stu123', 'St567890@', 16),
    ('zab456', 'Za123456@', 21),
    ('cde789', 'Cd789012@', 22),
    ('rst123', 'Rt345678@', 23),
    ('fgh456', 'Fh901234@', 24),
    ('nop789', 'Np567890@', 25),
    ('vwx123', 'Vx123456@', 26),
    ('ghi456', 'Gh789012@', 27),
    ('klm789', 'Km345678@', 28),
    ('tuv123', 'Tv901234@', 29),
    ('xyz123', 'Xz567890@', 30),
    ('abc789', 'Ab123456@', 31),
    ('dev123', 'Df789012@', 32),
    ('gh2456', 'Gh345678@', 33),
    ('jkl789', 'Jk901234@', 34),
    ('mno123', 'Mn567890@', 35),
    ('pqr789', 'Pq123456@', 36),
    ('stf123', 'St789012@', 37),
    ('vwx456', 'Vw345678@', 38),
    ('yza789', 'Yz901234@', 39),
    ('bcd123', 'Bc567890@', 40),
    ('kimseongho', 'C0mpl3xPwd@!', 41),
    ('parkjieun', 'S@fePassword1', 42),
    ('jeongminjun', 'R@ndomPassword9', 43),
    ('leoseoyoung', 'UniquePassw0rd@', 44),
    ('kimyeongcheol', 'S@ferAccess5678', 45),
    ('parkjaehyun', 'H@rdToGuess2023', 46),
    ('bakjiwoo', 'Password!1234', 47),
    ('immihee', 'M0reS3curePass', 48),
    ('choijunho', 'P@ssphrase2023', 49),
    ('shinyeongmi', 'Str0ng3rPwd!@', 50),
    ('gangdonghee', 'An0therP@ssw0rd', 51),
    ('gangminwoo', 'Rt345678@', 52),
    ('leeujiin', 'Fh901234@', 53),
    ('kimyeongmi', 'Np567890@', 54),
    ('songjiho', 'Vx123456@', 55),
    ('bakminseong', 'Gh789012@', 56),
    ('jeongyeongho', 'Km345678@', 57),
    ('gangu', 'Tv901234@', 58),
    ('jangyeonghi', 'Xz567890@', 59),
    ('jeongsujeong', 'Pq123456@', 60),
    ('hanyujeong', 'St789012@', 61),
    ('kimminji', 'Vw345678@', 62),
    ('bakjeongho', 'Yz901234@', 63),
    ('user123', 'Passw0rd@1', 71),
    ('john_doe', 'J0hnDoe@2023', 73),
    ('happy_guy', 'H@ppyGuy123', 77),
    ('secure_login', 'Secure#Login', 78),
    ('random_user', 'RandomUser987!', 79),
    ('unique1234', 'Unique@5678', 81),
    ('complex_pass', 'C0mpl3x_P@ss', 82),
    ('safe_access', 'S@feAccess4U', 83),
    ('secret_user', 'S3cret_U$er', 85),
    ('pass12345', 'P@ssw0rd12345', 87),
    ('strong_one', 'Str0ng@One', 89),
    ('new_member', 'N3w_Memb3r!', 91),
    ('coded_entry', 'C0d3d_EntrY', 93),
    ('secure_9876', 'S3cur3_9876', 95);

# ------------------------객실 관련 테이블
INSERT INTO rgrade (rgname, rhprice,rwprice, rgmaxcapa)
VALUES
    ('Standard', 400000, 800000, 3),
    ('Deluxe', 550000, 1100000, 4),
    ('Suite', 800000, 1600000, 6),
    ('Premier', 1200000, 2400000, 10),
    ('Royal', 3000000, 6000000, 10);

# 객실 샘플 코드
INSERT INTO room (rno, rgname_fk, rstate)
VALUES
    (401, 'Standard', 1),
    (402, 'Standard', 1),
    (403, 'Standard', 1),
    (404, 'Standard', 1),
    (405, 'Standard', 0),
    (406, 'Deluxe', 1),
    (407, 'Deluxe', 1),
    (408, 'Deluxe', 1),
    (409, 'Deluxe', 1),
    (410, 'Suite', 1),
    (411, 'Suite', 1),
    (412, 'Suite', 0),
    (413, 'Premier', 1),
    (414, 'Premier', 1),
    (415, 'Royal', 1),
    (501, 'Standard', 1),
    (502, 'Standard', 1),
    (503, 'Standard', 0),
    (504, 'Standard', 1),
    (505, 'Standard', 1),
    (506, 'Deluxe', 1),
    (507, 'Deluxe', 1),
    (508, 'Deluxe', 1),
    (509, 'Deluxe', 1),
    (510, 'Suite', 1),
    (511, 'Suite', 1),
    (512, 'Suite', 1),
    (513, 'Premier', 1),
    (514, 'Premier', 1),
    (515, 'Royal', 1),
    (601, 'Standard', 1),
    (602, 'Standard', 1),
    (603, 'Standard', 0),
    (604, 'Standard', 1),
    (605, 'Standard', 1),
    (606, 'Deluxe', 1),
    (607, 'Deluxe', 1),
    (608, 'Deluxe', 1),
    (609, 'Deluxe', 1),
    (610, 'Suite', 1),
    (611, 'Suite', 1),
    (612, 'Suite', 1),
    (613, 'Premier', 1),
    (614, 'Premier', 1),
    (615, 'Royal', 1),
    (701, 'Standard', 1),
    (702, 'Standard', 1),
    (703, 'Standard', 1),
    (704, 'Standard', 1),
    (705, 'Standard', 1),
    (706, 'Deluxe', 1),
    (707, 'Deluxe', 1),
    (708, 'Deluxe', 1),
    (709, 'Deluxe', 1),
    (710, 'Suite', 1),
    (711, 'Suite', 1),
    (712, 'Suite', 1),
    (713, 'Premier', 1),
    (714, 'Premier', 1),
    (715, 'Royal', 1),
    (801, 'Standard', 1),
    (802, 'Standard', 1),
    (803, 'Standard', 1),
    (804, 'Standard', 1),
    (805, 'Standard', 1),
    (806, 'Deluxe', 1),
    (807, 'Deluxe', 1),
    (808, 'Deluxe', 1),
    (809, 'Deluxe', 1),
    (810, 'Suite', 1),
    (811, 'Suite', 1),
    (812, 'Suite', 1),
    (813, 'Premier', 1),
    (814, 'Premier', 1),
    (815, 'Royal', 1),
    (901, 'Standard', 1),
    (902, 'Standard', 1),
    (903, 'Standard', 1),
    (904, 'Standard', 1),
    (905, 'Standard', 1),
    (906, 'Deluxe', 1),
    (907, 'Deluxe', 1),
    (908, 'Deluxe', 1),
    (909, 'Deluxe', 1),
    (910, 'Suite', 1),
    (911, 'Suite', 1),
    (912, 'Suite', 1),
    (913, 'Premier', 1),
    (914, 'Premier', 1),
    (915, 'Royal', 1),
    (1001, 'Standard', 1),
    (1002, 'Standard', 1),
    (1003, 'Standard', 1),
    (1004, 'Standard', 1),
    (1005, 'Standard', 1),
    (1006, 'Deluxe', 1),
    (1007, 'Deluxe', 1),
    (1008, 'Deluxe', 0),
    (1009, 'Deluxe', 1),
    (1010, 'Suite', 1),
    (1011, 'Suite', 1),
    (1012, 'Suite', 1),
    (1013, 'Premier', 1),
    (1014, 'Premier', 1),
    (1015, 'Royal', 1);

# 객실 예약 명단 샘플 코드
INSERT INTO roomresv (mno_fk, rrtime, rno_fk, rrstartdate, rrenddate, rrcheckin, rrcheckout)
VALUES
    (1, '2023-10-23 9:28', 401, '2023-11-01', '2023-11-30', '2023-11-01 9:00', null),
    (2, '2023-10-24 0:28', 402, '2023-11-01', '2023-11-30', '2023-11-01 9:00', '2023-11-30 14:00'),
    (3, '2023-10-21 0:28', 403, '2023-11-01', '2023-11-30', '2023-11-01 8:30', '2023-11-30 11:30'),
    (4, '2023-10-21 14:28', 404, '2023-11-01', '2023-11-30', '2023-11-01 11:00', null),
    (5, '2023-10-23 2:28', 406, '2023-11-01', '2023-11-30', '2023-11-01 9:30', null),
    (6, '2023-10-24 14:55', 408, '2023-11-01', '2023-11-30', '2023-11-01 10:30', '2023-11-30 14:30'),
    (7, '2023-10-25 5:28', 410, '2023-11-01', '2023-11-30', '2023-11-01 8:00', '2023-11-30 12:00'),
    (8, '2023-10-18 10:28', 411, '2023-11-01', '2023-11-30', '2023-11-01 9:15', '2023-11-30 13:15'),
    (9, '2023-10-21 10:21', 412, '2023-11-01', '2023-11-30', '2023-11-01 11:00', null),
    (10, '2023-10-22 7:28', 413, '2023-11-01', '2023-11-30', '2023-11-01 8:45', null),
    (11, '2023-10-26 15:45', 414, '2023-11-01', '2023-11-30', '2023-11-01 10:00', '2023-11-30 13:00'),
    (12, '2023-10-27 9:12', 501, '2023-11-01', '2023-11-30', '2023-11-01 11:30', null),
    (13, '2023-10-28 10:33', 503, '2023-11-01', '2023-11-30', '2023-11-01 9:15', null),
    (14, '2023-10-29 14:17', 504, '2023-11-01', '2023-11-30', '2023-11-01 8:45', '2023-11-30 12:45'),
    (15, '2023-10-30 3:05', 507, '2023-11-01', '2023-11-30', '2023-11-01 10:30', null),
    (16, '2023-10-31 6:59', 508, '2023-11-01', '2023-11-30', '2023-11-01 9:00', '2023-11-30 12:00'),
    (17, '2023-11-01 2:37', 509, '2023-11-01', '2023-11-30', '2023-11-01 8:30', '2023-11-30 11:30'),
    (18, '2023-11-02 7:18', 510, '2023-11-01', '2023-11-30', '2023-11-01 11:00', null),
    (19, '2023-11-30 12:14', 513, '2023-11-01', '2023-11-30', '2023-11-01 9:30', '2023-11-30 13:30'),
    (20, '2023-11-04 8:29', 514, '2023-11-01', '2023-11-30', '2023-11-01 12:00', '2023-11-30 14:00'),
    (21, '2023-11-05 9:28', 601, '2023-11-01', '2023-11-30', '2023-11-01 9:00', null),
    (22, '2023-11-06 0:28', 602, '2023-11-01', '2023-11-30', '2023-11-01 9:00', null),
    (23, '2023-11-07 0:28', 603, '2023-11-01', '2023-11-30', '2023-11-01 8:30', '2023-11-30 11:30'),
    (24, '2023-11-08 14:28', 604, '2023-11-01', '2023-11-30', '2023-11-01 11:00', '2023-11-30 15:00'),
    (25, '2023-11-09 2:28', 605, '2023-11-01', '2023-11-30', '2023-11-01 9:30', '2023-11-30 13:30'),
    (26, '2023-11-10 14:55', 606, '2023-11-01', '2023-11-30', '2023-11-01 10:30', '2023-11-30 14:30'),
    (27, '2023-11-11 5:28', 607, '2023-11-01', '2023-11-30', '2023-11-01 8:00', '2023-11-30 12:00'),
    (28, '2023-11-12 10:28', 608, '2023-11-01', '2023-11-30', '2023-11-01 9:15', null),
    (29, '2023-11-13 10:21', 611, '2023-11-01', '2023-11-30', '2023-11-01 11:00', null),
    (30, '2023-11-14 7:28', 613, '2023-11-01', '2023-11-30', '2023-11-01 8:45', null),
    (31, '2023-11-15 15:45', 701, '2023-11-01', '2023-11-30', '2023-11-01 10:00', '2023-11-30 13:00'),
    (32, '2023-11-16 9:12', 702, '2023-11-01', '2023-11-30', '2023-11-01 11:30', null),
    (33, '2023-11-17 10:33', 703, '2023-11-01', '2023-11-30', '2023-11-01 9:15', null),
    (34, '2023-11-18 14:17', 707, '2023-11-01', '2023-11-30', '2023-11-01 8:45', '2023-11-30 12:45'),
    (35, '2023-11-19 3:05', 709, '2023-11-01', '2023-11-30', '2023-11-01 10:30', '2023-11-30 14:30'),
    (36, '2023-11-20 6:59', 710, '2023-11-01', '2023-11-30', '2023-11-01 9:00', null),
    (37, '2023-11-21 2:37', 712, '2023-11-01', '2023-11-30', '2023-11-01 8:30', null),
    (38, '2023-11-22 7:18', 713, '2023-11-01', '2023-11-30', '2023-11-01 11:00', null),
    (39, '2023-11-23 12:14', 714, '2023-11-01', '2023-11-30', '2023-11-01 9:30', '2023-11-30 13:30'),
    (40, '2023-11-24 8:29', 715, '2023-11-01', '2023-11-30', '2023-11-01 12:00', '2023-11-30 14:00'),
    (41, '2023-11-25 15:45', 801, '2023-11-01', '2023-11-30', '2023-11-01 10:00', '2023-11-30 13:00'),
    (42, '2023-11-26 9:12', 802, '2023-11-01', '2023-11-30', '2023-11-01 11:30', null),
    (43, '2023-11-27 10:33', 804, '2023-11-01', '2023-11-30', '2023-11-01 9:15', null),
    (44, '2023-11-28 14:17', 806, '2023-11-01', '2023-11-30', '2023-11-01 8:45', '2023-11-30 12:45'),
    (45, '2023-11-29 3:05', 807, '2023-11-01', '2023-11-30', '2023-11-01 10:30', '2023-11-30 14:30'),
    (46, '2023-11-30 6:59', 808, '2023-11-01', '2023-11-30', '2023-11-01 9:00', null),
    (47, '2023-12-01 2:37', 811, '2023-11-01', '2023-11-30', '2023-11-01 8:30', null),
    (48, '2023-12-02 7:18', 812, '2023-11-01', '2023-11-30', '2023-11-01 11:00', '2023-11-30 15:00'),
    (49, '2023-12-03 12:14', 813, '2023-11-01', '2023-11-30', '2023-11-01 9:30', '2023-11-30 13:30'),
    (50, '2023-12-04 8:29', 814, '2023-11-01', '2023-11-30', '2023-11-01 12:00', null),
    (51, '2023-12-05 15:45', 901, '2023-11-01', '2023-11-30', '2023-11-01 10:00', '2023-11-30 13:00'),
    (52, '2023-12-06 9:12', 902, '2023-11-01', '2023-11-30', '2023-11-01 11:30', null),
    (53, '2023-12-07 10:33', 905, '2023-11-01', '2023-11-30', '2023-11-01 9:15', '2023-11-30 13:15'),
    (54, '2023-12-08 14:17', 906, '2023-11-01', '2023-11-30', '2023-11-01 8:45', null),
    (55, '2023-12-09 3:05', 908, '2023-11-01', '2023-11-30', '2023-11-01 10:30', null),
    (56, '2023-12-10 6:59', 909, '2023-11-01', '2023-11-30', '2023-11-01 9:00', '2023-11-30 12:00'),
    (57, '2023-12-11 2:37', 910, '2023-11-01', '2023-11-30', '2023-11-01 8:30', '2023-11-30 11:30'),
    (58, '2023-12-12 7:18', 912, '2023-11-01', '2023-11-30', '2023-11-01 11:00', null),
    (59, '2023-12-13 12:14', 913, '2023-11-01', '2023-11-30', '2023-11-01 9:30', '2023-11-30 13:30'),
    (60, '2023-12-14 8:29', 915, '2023-11-01', '2023-11-30', '2023-11-01 12:00', '2023-11-30 14:00'),
    (61, '2023-12-15 15:45', 1001, '2023-11-01', '2023-11-30', '2023-11-01 10:00', null),
    (62, '2023-12-16 9:12', 1002, '2023-11-01', '2023-11-30', '2023-11-01 11:30', '2023-11-30 15:30'),
    (63, '2023-12-17 10:33', 1003, '2023-11-01', '2023-11-30', '2023-11-01 9:15', '2023-11-30 13:15'),
    (64, '2023-12-18 14:17', 1004, '2023-11-01', '2023-11-30', '2023-11-01 8:45', null),
    (65, '2023-12-19 3:05', 1006, '2023-11-01', '2023-11-30', '2023-11-01 10:30', null),
    (66, '2023-12-20 6:59', 1007, '2023-11-01', '2023-11-30', '2023-11-01 9:00', '2023-11-30 12:00'),
    (67, '2023-12-21 2:37', 1009, '2023-11-01', '2023-11-30', '2023-11-01 8:30', null),
    (68, '2023-12-22 7:18', 1011, '2023-11-01', '2023-11-30', '2023-11-01 11:00', '2023-11-30 15:00'),
    (69, '2023-12-23 12:14', 1013, '2023-11-01', '2023-11-30', '2023-11-01 9:30', null),
    (70, '2023-12-24 8:29', 1015, '2023-11-01', '2023-11-30', '2023-11-01 12:00', '2023-11-30 14:00'),
    (71, '2023-12-15 09:00', 401, '2023-12-15', '2023-12-17', '2023-12-15 10:00', '2023-12-17 15:00'),
    (72, '2023-12-15 10:00', 402, '2023-12-15', '2023-12-17', '2023-12-15 10:30', '2023-12-17 13:30'),
    (73, '2023-12-15 11:00', 403, '2023-12-15', '2023-12-17', '2023-12-15 11:00', '2023-12-17 14:00'),
    (74, '2023-12-15 12:00', 404, '2023-12-15', '2023-12-17', '2023-12-15 12:30', '2023-12-17 15:30'),
    (75, '2023-12-15 13:00', 405, '2023-12-15', '2023-12-17', '2023-12-15 13:15', '2023-12-17 16:15'),
    (76, '2023-12-15 14:00', 406, '2023-12-15', '2023-12-17', '2023-12-15 14:30', '2023-12-17 17:30'),
    (77, '2023-12-15 15:00', 407, '2023-12-15', '2023-12-17', '2023-12-15 15:00', '2023-12-17 18:00'),
    (78, '2023-12-15 16:00', 408, '2023-12-15', '2023-12-17', '2023-12-15 16:30', '2023-12-17 19:30'),
    (79, '2023-12-15 17:00', 409, '2023-12-15', '2023-12-17', '2023-12-15 17:45', '2023-12-17 20:45'),
    (80, '2023-12-15 18:00', 410, '2023-12-15', '2023-12-17', '2023-12-15 18:15', '2023-12-17 21:15'),
    (81, '2023-12-15 19:00', 411, '2023-12-15', '2023-12-17', '2023-12-15 19:30', '2023-12-17 22:30'),
    (82, '2023-12-15 20:00', 412, '2023-12-15', '2023-12-17', '2023-12-15 20:00', '2023-12-17 23:00'),
    (83, '2023-12-15 21:00', 413, '2023-12-15', '2023-12-17', '2023-12-15 21:15', '2023-12-17 00:15'),
    (84, '2023-12-15 22:00', 414, '2023-12-15', '2023-12-17', '2023-12-15 22:30', '2023-12-17 01:30'),
    (85, '2023-12-15 23:00', 415, '2023-12-15', '2023-12-17', '2023-12-15 23:00', '2023-12-17 02:00'),
    (86, '2023-12-16 09:00', 501, '2023-12-18', '2023-12-20', '2023-12-18 10:00', '2023-12-20 15:00'),
    (87, '2023-12-16 10:00', 502, '2023-12-18', '2023-12-20', '2023-12-18 10:30', '2023-12-20 13:30'),
    (88, '2023-12-16 11:00', 503, '2023-12-18', '2023-12-20', '2023-12-18 11:00', '2023-12-20 14:00'),
    (89, '2023-12-16 12:00', 504, '2023-12-18', '2023-12-20', '2023-12-18 12:30', '2023-12-20 15:30'),
    (90, '2023-12-16 13:00', 505, '2023-12-18', '2023-12-20', '2023-12-18 13:15', '2023-12-20 16:15'),
    (91, '2023-12-16 14:00', 506, '2023-12-18', '2023-12-20', '2023-12-18 14:30', '2023-12-20 17:30'),
    (92, '2023-12-16 15:00', 507, '2023-12-18', '2023-12-20', '2023-12-18 15:00', '2023-12-20 18:00'),
    (93, '2023-12-16 16:00', 508, '2023-12-18', '2023-12-20', '2023-12-18 16:30', '2023-12-20 19:30'),
    (94, '2023-12-16 17:00', 509, '2023-12-18', '2023-12-20', '2023-12-18 17:45', '2023-12-20 20:45'),
    (95, '2023-12-16 18:00', 510, '2023-12-18', '2023-12-20', '2023-12-18 18:15', '2023-12-20 21:15'),
    (96, '2023-12-16 19:00', 511, '2023-12-18', '2023-12-20', '2023-12-18 19:30', '2023-12-20 22:30'),
    (97, '2023-12-16 20:00', 512, '2023-12-18', '2023-12-20', '2023-12-18 20:00', '2023-12-20 23:00'),
    (98, '2023-12-16 21:00', 513, '2023-12-18', '2023-12-20', '2023-12-18 21:15', '2023-12-20 00:15'),
    (99, '2023-12-16 22:00', 514, '2023-12-18', '2023-12-20', '2023-12-18 22:30', '2023-12-20 01:30'),
    (100, '2023-12-16 23:00', 515, '2023-12-18', '2023-12-20', '2023-12-18 23:00', '2023-12-20 02:00');

# 객실 등급 샘플 코드



# ------------------------시설 관련 테이블

# location (시설) 샘플코드
INSERT INTO location (lname, lstarttime, lendtime, lprice, lchildprice, lmaxcapa)
VALUES
    ('실내수영장', '09:00:00', '18:00:00', 35000, 20000, 100),
    ('디너_다이닝', '17:00:00', '21:00:00', 180000, 90000, 100),
    ('피트니스', '09:00:00', '18:00:00', 15000, 15000, 50),
    ('실내골프장', '09:00:00', '18:00:00', 80000, 80000, 20),
    ('런치_다이닝', '11:00:00', '14:00:00', 100000, 50000, 100),
    ('모닝_다이닝', '07:00:00', '09:30:00', 60000, 30000, 100);


DELIMITER //
CREATE PROCEDURE GenerateRandomReservations()
BEGIN
    DECLARE i INT;
    DECLARE mno INT;
    DECLARE lname VARCHAR(255);
    DECLARE lstarttime TIME;
    DECLARE lendtime TIME;
    DECLARE lmaxcapa INT;
    DECLARE udate DATE;
    DECLARE lrtime TIME;
    DECLARE lrstate VARCHAR(255);

    SET i = 1;

    WHILE i <= 100 DO
            -- 랜덤 회원번호 (1에서 100까지)
            SET mno = FLOOR(RAND() * 100) + 1;

            -- 랜덤 날짜 (+2일 기준)
            SET udate = DATE_ADD(CURRENT_DATE, INTERVAL 2 DAY);

            -- 랜덤 시설 선택
            SELECT lname, lstarttime, lendtime, lmaxcapa
            INTO lname, lstarttime, lendtime, lmaxcapa
            FROM location
            ORDER BY RAND()
            LIMIT 1;

            -- 랜덤 시설 내 예약 시간 생성
            SET lrtime = ADDTIME(lstarttime, SEC_TO_TIME(FLOOR(RAND() * TIME_TO_SEC(TIMEDIFF(lendtime, lstarttime)))));

            -- 예약 상태 (임의로 '예약'으로 설정)
            SET lrstate = '예약';

            -- 예약 추가
            INSERT INTO lresv (lrstate, lrtime, lname, mno, udate)
            VALUES (lrstate, lrtime, lname, mno, udate);

            SET i = i + 1;
        END WHILE;
END//
DELIMITER ;

-- 저장 프로시저 실행
CALL GenerateRandomReservations();

# discount (할인율) 샘플코드
INSERT INTO discount (dtype, drate, cdate, udate)
VALUES
    ('실내수영장', 0.30, '2023-10-28 9:00:00', '2023-11-03 12:00:00'),
    ('디너_다이닝', 0.35, '2023-10-29 00:00:00', '2023-11-04 14:00:00'),
    ('피트니스', 0.25, '2023-10-28 8:30:00', '2023-11-02 11:30:00'),
    ('실내골프장', 0.20, '2023-10-30 11:00:00', '2023-11-04 15:00:00'),
    ('런치_다이닝', 0.35, '2023-10-28 9:30:00', '2023-11-01 13:30:00'),
    ('모닝_다이닝', 0.40, '2023-10-28 10:30:00', '2023-11-03 14:30:00'),
    ('Standard', 0.20, '2023-10-28 8:00:00', '2023-11-01 12:00:00'),
    ('Deluxe', 0.25, '2023-10-29 9:15:00', '2023-11-02 13:15:00'),
    ('Suite', 0.30, '2023-10-28 11:00:00', '2023-11-03 15:00:00'),
    ('Premier', 0.35, '2023-10-28 8:45:00', '2023-11-02 12:45:00'),
    ('Royal', 0.40, '2023-10-29 8:45:00', '2023-11-03 12:45:00');


# locationresv (시설 예약 명단)
drop table lresv;
INSERT INTO lresv ( lrstate, lrtime, lname, mno, udate)
VALUES
    ( 0, '2023-10-30 11:00:00', '실내수영장', 1, '2023-10-28 9:00:00'),
    ( 0, '2023-10-28 19:00:00', '디너_다이닝', 2, '2023-10-29 00:00:00'),
    ( 0, '2023-10-30 11:00:00', '피트니스', 3, '2023-10-28 8:30:00'),
    ( 0, '2023-10-30 14:00:00', '실내골프장', 4, '2023-10-30 11:00:00'),
    ( 0, '2023-10-30 12:00:00', '런치_다이닝', 5, '2023-10-28 9:30:00'),
    ( 0, '2023-10-30 8:00:00', '모닝_다이닝', 6, '2023-10-28 10:30:00'),
    ( 0, '2023-10-31 12:00:00', '런치_다이닝', 7, '2023-10-28 8:00:00'),
    ( 0, '2023-10-28 12:00:00', '런치_다이닝', 8, '2023-10-29 9:15:00'),
    ( 0, '2023-11-02 19:00:00', '디너_다이닝', 9, '2023-10-28 11:00:00'),
    ( 0, '2023-11-01 19:00:00', '디너_다이닝', 10, '2023-10-28 8:45:00');
# 무작위로 생성해주는 sql
# 많은 데이터 원할 시 반복해서 실행
# lrstate 0 : 예약중 1 : 예약 완료 2 : 예약 취소

INSERT INTO lresv (lrstate, lrtime, lname, mno, udate)
SELECT
    0,
    CONCAT(
            DATE_ADD(CURDATE(), INTERVAL FLOOR(RAND() * 3) DAY),
            ' ',
            SEC_TO_TIME(
                        TIME_TO_SEC(lstarttime) + FLOOR(RAND() * (TIME_TO_SEC(lendtime) - TIME_TO_SEC(lstarttime) + 1))
            )
    ) AS reservation_time,
    lname,
    FLOOR(RAND() * 100) + 1 AS member_number,
    NOW() AS creation_time
FROM location
         JOIN (
    SELECT n1.n * 1 + n2.n * 10 AS num
    FROM (
             SELECT 0 AS n UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4
         ) AS n1
             CROSS JOIN (
        SELECT 0 AS n UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4
    ) AS n2
) AS nums
WHERE FLOOR(RAND() * lmaxcapa) > 0;

# ticket 샘플코드 (회원권)
INSERT INTO ticket (tstartdate, tenddate, mno)
VALUES
    ('2023-10-20', '2023-10-30', 1),
    ('2023-11-05', '2023-11-15', 2),
    ('2023-11-10', '2023-11-20', 3),
    ('2023-11-25', '2023-12-05', 4),
    ('2023-12-01', '2023-12-10', 5),
    ('2023-12-15', '2023-12-25', 6),
    ('2023-12-20', '2023-12-30', 7),
    ('2024-01-05', '2024-01-15', 8),
    ('2024-01-10', '2024-01-20', 9),
    ('2024-01-25', '2024-02-05', 10),
    # 추가 샘플코드
    ('2024-02-10', '2024-02-20', 11),
    ('2024-02-25', '2024-03-06', 12),
    ('2024-03-10', '2024-03-20', 13),
    ('2024-03-25', '2024-04-04', 14),
    ('2024-04-10', '2024-04-20', 15),
    ('2024-04-25', '2024-05-05', 16),
    ('2024-05-10', '2024-05-20', 17),
    ('2024-05-25', '2024-06-05', 18),
    ('2024-06-10', '2024-06-20', 19),
    ('2024-06-25', '2024-07-05', 20),
    ('2024-07-10', '2024-07-20', 21),
    ('2024-07-25', '2024-08-04', 22),
    ('2024-08-10', '2024-08-20', 23),
    ('2024-08-25', '2024-09-05', 24),
    ('2024-09-10', '2024-09-20', 25),
    ('2024-09-25', '2024-10-05', 26),
    ('2024-10-10', '2024-10-20', 27),
    ('2024-10-25', '2024-11-04', 28),
    ('2024-11-10', '2024-11-20', 29),
    ('2024-11-25', '2024-12-05', 30);
