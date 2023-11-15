#drop database hotelmanegement;
#create database hotelmanegement;
use hotelmanegement;
# ------------------------회원 관련 테이블


# memberinfo (회원 공통 정보)
truncate table memberinfo;
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
    (100, 0, '박다은', '여성', '01033331111', '19980218', NOW()),
    (101, 2, '김민수', '남성', '01077778888', '19951215', NOW()),
    (102, 2, '이지은', '여성', '01055556666', '19900420', NOW()),
    (103, 2, '박영호', '남성', '01033335555', '19970803', NOW()),
    (104, 2, '신다혜', '여성', '01012345678', '19920312', NOW()),
    (105, 2, '홍길순', '여성', '01098765432', '19951105', NOW()),
    (106, 2, '이승우', '남성', '01055553333', '19980418', NOW()),
    (107, 2, '김현지', '여성', '01011112222', '19921230', NOW()),
    (108, 2, '박민수', '남성', '01088889999', '19900125', NOW()),
    (109, 2, '한예슬', '여성', '01077776666', '19940908', NOW()),
    (110, 2, '정재영', '남성', '01033334444', '19960201', NOW()),
    (111, 2, '김미희', '여성', '01022221111', '19980715', NOW()),
    (112, 2, '신동희', '남성', '01044445555', '19910922', NOW()),
    (113, 2, '이지원', '여성', '01099998888', '19970407', NOW()),
    (114, 2, '박현우', '남성', '01066667777', '19931014', NOW()),
    (115, 2, '정지훈', '남성', '01022228888', '19950101', NOW()),
    (116, 2, '김예은', '여성', '01012347777', '19900229', NOW()),
    (117, 2, '이승미', '여성', '01088883333', '19931207', NOW()),
    (118, 2, '송준호', '남성', '01055554444', '19970430', NOW()),
    (119, 2, '김지우', '남성', '01011113333', '19921111', NOW()),
    (120, 2, '박은지', '여성', '01033339999', '19950818', NOW()),
    (121, 2, '신수진', '여성', '01066662222', '19900404', NOW()),
    (122, 2, '이재민', '남성', '01044446666', '19971225', NOW()),
    (123, 2, '김다영', '여성', '01012342222', '19921212', NOW()),
    (124, 2, '정승우', '남성', '01077773333', '19951231', NOW()),
    (125, 2, '박수빈', '여성', '01099992222', '19920109', NOW()),
    (126, 2, '신민재', '남성', '01055551111', '19960315', NOW()),
    (127, 2, '이정민', '남성', '01011118888', '19931030', NOW()),
    (128, 2, '김서현', '여성', '01044443333', '19950505', NOW()),
    (129, 2, '박현준', '남성', '01077779999', '19980708', NOW()),
    (130, 2, '정서연', '여성', '01066668888', '19941011', NOW());

# member 샘플 코드 (회원)
truncate table member;
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
truncate table rgrade;
INSERT INTO rgrade (rgname, rhprice,rwprice, rgmaxcapa)
VALUES
    ('Standard', 400000, 800000, 3),
    ('Deluxe', 550000, 1100000, 4),
    ('Suite', 800000, 1600000, 6),
    ('Premier', 1200000, 2400000, 10),
    ('Royal', 3000000, 6000000, 10);

# 객실 샘플 코드
truncate table room;
INSERT INTO room (rno, rgname_fk, rstate)
VALUES
    (401, 'Standard', 1),
    (402, 'Standard', 1),
    (403, 'Standard', 1),
    (404, 'Standard', 1),
    (405, 'Standard', 1),
    (406, 'Deluxe', 1),
    (407, 'Deluxe', 1),
    (408, 'Deluxe', 1),
    (409, 'Deluxe', 1),
    (410, 'Suite', 1),
    (411, 'Suite', 1),
    (412, 'Suite', 1),
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
truncate table roomresv;
drop procedure if exists random_dates;
DELIMITER $$

CREATE PROCEDURE random_dates()
BEGIN
    DECLARE mno_fk INT DEFAULT 1;
    DECLARE rno_fk INT DEFAULT 1;
    DECLARE rrstartdate DATE DEFAULT '2020-01-01';
    DECLARE rrenddate DATE DEFAULT '2023-12-31';
    DECLARE rrcheckin DATETIME DEFAULT '2020-01-01 00:00:00';
    DECLARE rrcheckout DATETIME DEFAULT '2023-12-31 23:59:59';
    DECLARE diff INT DEFAULT 1;

    WHILE mno_fk <= 100 DO
            WHILE rno_fk <= 15 DO
                    SET diff = FLOOR(RAND() * 7 + 1);
                    SET rrcheckin = DATE_ADD(rrstartdate, INTERVAL FLOOR(RAND() * (DATEDIFF(rrenddate, rrstartdate) + 1)) DAY);
                    SET rrcheckout = DATE_ADD(rrcheckin, INTERVAL diff DAY);

                    SELECT rno INTO rno_fk FROM room ORDER BY RAND() LIMIT 1;

                    INSERT INTO roomresv (mno_fk, rrtime, rno_fk, rrstartdate, rrenddate, rrcheckin, rrcheckout)
                    VALUES (mno_fk, CURRENT_TIMESTAMP(), rno_fk, rrstartdate, rrenddate, rrcheckin, rrcheckout);

                    SET rno_fk = rno_fk + 1;
                END WHILE;

            SET mno_fk = mno_fk + 1;
            SET rno_fk = 1;
        END WHILE;
END $$

DELIMITER ;

DELIMITER $$

drop PROCEDURE if exists random_dates_40times;

CREATE PROCEDURE random_dates_40times()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 40 DO
            CALL random_dates();
            SET i = i + 1;
        END WHILE;
END $$

DELIMITER ;

CALL random_dates_40times();

# 객실 등급 샘플 코드



# ------------------------시설 관련 테이블

# location (시설) 샘플코드
truncate table location;
INSERT INTO location (lname, lstarttime, lendtime, lprice, lchildprice, lmaxcapa)
VALUES
    ('실내수영장', '09:00:00', '18:00:00', 35000, 20000, 100),
    ('피트니스', '09:00:00', '18:00:00', 15000, 15000, 50),
    ('실내골프장', '09:00:00', '18:00:00', 80000, 80000, 20),
    ('런치_다이닝', '11:00:00', '14:00:00', 100000, 50000, 100),
    ('모닝_다이닝', '07:00:00', '09:30:00', 60000, 30000, 100),
    ('디너_다이닝', '17:00:00', '21:00:00', 180000, 90000, 100);



# discount (할인율) 샘플코드
truncate table discount;
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
truncate table lresv;
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
    CASE WHEN RAND() < 0.5 THEN 0 ELSE 2 END AS lrstate,
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

INSERT INTO lresv (lrstate, lrtime, lname, mno, udate)
SELECT
    0,
    TIMESTAMPADD(MINUTE, FLOOR(RAND() * TIMESTAMPDIFF(MINUTE, '2021-01-01', '2024-04-30')), '2021-01-01'),
    CASE
        WHEN FLOOR(RAND() * 6) = 0 THEN '실내수영장'
        WHEN FLOOR(RAND() * 6) = 1 THEN '디너_다이닝'
        WHEN FLOOR(RAND() * 6) = 2 THEN '피트니스'
        WHEN FLOOR(RAND() * 6) = 3 THEN '실내골프장'
        WHEN FLOOR(RAND() * 6) = 4 THEN '런치_다이닝'
        WHEN FLOOR(RAND() * 6) = 5 THEN '모닝_다이닝'
        END AS lname,
    FLOOR(1 + RAND() * 134),
    CURRENT_TIMESTAMP
FROM
    information_schema.tables
LIMIT 100;
# 삽입한 시설 예약 샘플 코드가
# 오늘 날짜 기준으로 이전이면 예약 만료(1)로 변경
UPDATE lresv
SET lrstate = 1
WHERE DATE(lrtime) < CURDATE();
# ticket 샘플코드 (회원권)
truncate table ticket;
INSERT INTO ticket (tstartdate, tenddate, mno)
VALUES
    ('2023-10-30', '2023-10-20', 1),
    ('2023-11-15', '2023-11-05', 3),
    ('2023-11-20', '2023-11-10', 7),
    ('2023-12-05', '2023-11-25', 8),
    ('2023-12-10', '2023-12-01', 9),
    ('2023-12-25', '2023-12-15', 11),
    ('2023-01-15', '2024-01-05', 14),
    ('2023-01-20', '2024-01-10', 15),
    ('2023-02-05', '2024-01-25', 16),
    ('2023-02-20', '2024-02-10', 21),
    ('2023-03-06', '2024-02-25', 22),
    ('2023-04-04', '2024-03-25', 24),
    ('2023-04-20', '2024-04-10', 25),
    ('2023-05-05', '2024-04-25', 26),
    ('2023-05-20', '2024-05-10', 27),
    ('202#-06-05', '2024-05-25', 28),
    ('2023-06-20', '2024-06-10', 29),
    ('2023-07-05', '2024-06-25', 30),
    ('2023-08-20', '2024-08-10', 33),
    ('2023-09-05', '2024-08-25', 34),
    ('2023-10-20', '2024-10-10', 37),
    ('2024-11-04', '2024-10-25', 38),
    ('2023-10-30', '2023-10-20', 41),
    ('2023-11-20', '2023-11-10', 43),
    ('2023-12-05', '2023-11-25', 44),
    ('2023-12-10', '2023-12-01', 45),
    ('2023-12-30', '2023-12-20', 47),
    ('2023-01-15', '2024-01-05', 48),
    ('2023-02-20', '2024-02-10', 51),
    ('2023-03-06', '2024-02-25', 52),
    ('2023-04-04', '2024-03-25', 54),
    ('2023-05-20', '2024-05-10', 57),
    ('2023-06-20', '2024-06-10', 59),
    ('2023-08-04', '2024-07-25', 62),
    ('2023-08-20', '2024-08-10', 63),
    ('2023-09-20', '2024-09-10', 73),
    ('2023-10-05', '2024-09-25', 77),
    ('2023-10-20', '2024-10-10', 78),
    ('2023-11-20', '2024-11-10', 81),
    ('2023-12-05', '2024-11-25', 82),
    ('2023-08-04', '2024-07-25', 83),
    ('2023-08-20', '2024-08-10', 85),
    ('2023-09-20', '2024-09-10', 89),
    ('2023-10-05', '2024-09-25', 91),
    ('2023-12-05', '2024-11-25', 95);

/* 직원 관련 샘플 코드 */

/* 부서 테이블 */
truncate table department;
insert into department (dcode, dname)
values
    ('01', '서비스'),
    ('02', '시설관리'),
    ('03', '호텔조리'),
    ('04', '마케팅'),
    ('05', '총무'),
    ('06', '인사'),
    ('07', '총괄');


/* 직책 테이블 */
truncate table position;
insert into position (pname, psalary, pbonus, pannual)
values
    ('사원', 3000000, 0.5,15),
    ('주임', 3500000, 0.7,17),
    ('대리', 4000000, 0.8,18),
    ('과장', 4500000, 1,20),
    ('차장', 5000000, 1.5,22),
    ('부장', 6000000, 2,24),
    ('이사', 10000000, 5,30),
    ('사장', 20000000, 20,30);

/* 직원 테이블 */
truncate table employee;
insert into employee (eno, epwd, eaddress, ejoin, mno_fk,dcode_fk,pname_fk)
values
    ('23010001', 'asdopkopk', '경기도 안산시 단원구 중앙동', '2018-07-01', '101', '01', '사원'),
    ('23020002', 'qwertyui', '서울특별시 강남구 역삼동', '2001-11-15', '102', '02', '주임'),
    ('23030003', 'zxcvbnm', '인천광역시 남동구 도화동', '2005-03-28', '103', '03', '대리'),
    ('23040004', '12345678', '대구광역시 수성구 만촌동', '2010-06-09', '104', '04', '과장'),
    ('23050005', 'abcdefg', '부산광역시 해운대구 우동', '2002-09-22', '105', '05', '차장'),
    ('23060006', '87654321', '광주광역시 서구 치평동', '2015-01-14', '106', '06', '부장'),
    ('23070007', 'qazwsx', '대전광역시 서구 둔산동', '2019-12-05', '107', '07', '이사'),
    ('23050008', 'poiuytrew', '울산광역시 남구 삼산동', '2003-04-18', '108', '05', '과장'),
    ('23050009', 'mnbvcxz', '경기도 수원시 영통구 매탄동', '2008-08-30', '109', '05', '사원'),
    ('23040010', 'plmoknij', '서울특별시 종로구 인사동', '2006-02-14', '110', '04', '주임'),
    ('23010011', 'ytrewq', '인천광역시 부평구 부평동', '2011-10-29', '111', '01', '대리'),
    ('23010012', '0987654321', '대구광역시 달서구 이곡동', '2000-07-07', '112', '01', '과장'),
    ('23030013', 'vbnmasdf', '부산광역시 사하구 하단동', '2018-03-20', '113', '03', '차장'),
    ('23050014', '1q2w3e4r', '광주광역시 북구 우치로1가', '2016-09-11', '114', '05', '부장'),
    ('23060015', 'zaq1xsw2', '대전광역시 유성구 구즉동', '2017-07-02', '115', '06', '이사'),
    ('23040016', 'cde3vfr4', '울산광역시 동구 성남동', '2004-12-25', '116', '04', '과장'),
    ('23070017', '7y6t5r4e', '경기도 화성시 병점동', '2013-06-16', '117', '07', '사원'),
    ('23070018', 'u8i9o0p-', '서울특별시 송파구 거여동', '2014-04-28', '118', '07', '주임'),
    ('23050019', 'asdfghjk', '인천광역시 서구 검단동', '2007-01-10', '119', '05', '대리'),
    ('23040020', 'zxvbnm123', '대구광역시 달서구 신당동', '2012-11-01', '120', '04', '과장'),
    ('23040021', 'qweasdzxc', '부산광역시 중구 남포동', '2019-10-15', '121', '04', '차장'),
    ('23030022', '1qaz2wsx', '광주광역시 남구 대촌동', '2014-12-03', '122', '03', '부장'),
    ('23050023', 'poiuyt123', '대전광역시 대덕구 송촌동', '2013-03-25', '123', '05', '이사'),
    ('23010024', 'mko0nji9', '울산광역시 남구 삼산로', '2015-05-07', '124', '01', '사원'),
    ('23030025', 'zxcvbn4321', '경기도 용인시 수지구 풍덕천동', '2019-08-18', '125', '03', '사원'),
    ('23010026', '0987poiuy', '서울특별시 강동구 천호동', '2022-01-01', '126', '01', '주임'),
    ('23010027', 'mnbvcx987', '인천광역시 계양구 작전동', '2001-05-12', '127', '01', '대리'),
    ('23030028', 'qwerasdf', '대구광역시 수성구 수성동', '2010-09-07', '128', '03', '과장'),
    ('23010029', '1qaz2wsx', '부산광역시 사상구 괘법동', '2008-11-30', '129', '01', '사장'),
    ('23010030', 'plmoknij', '광주광역시 동구 서석동', '2016-02-20', '130', '01', '부장');


