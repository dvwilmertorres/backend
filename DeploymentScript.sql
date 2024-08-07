/*
create schema "appmatch_apigateway";
alter schema "appmatch_apigateway" owner to admin;
 */

create table appmatch_apigateway.mst_route_manager
(
    pkid_mst_route_manager uuid DEFAULT gen_random_uuid() NOT NULL primary key,
    creation_date          varchar(50) default NOW() NOT NULL,
    expiration_date        varchar(50),
    service_name           varchar(50),
    "group"                varchar(50),
    method                 varchar(20),
    protocol               varchar(9),
    uri                    varchar(40),
    port                   varchar(5),
    predicates             varchar(40),
    filters                varchar(40),
    endpoint               varchar(50)
);

alter table appmatch_apigateway.mst_route_manager
    owner to admin;

insert into appmatch_apigateway.mst_route_manager(service_name, "group", method,protocol, uri, port, predicates, filters, endpoint)
values ('Dictionary','common','POST','http://','127.0.0.1','8082','Path=/searchDictionaries',
        'RewritePath=/searchDictionaries,','/userProfile/searchDictionaries');

create table appmatch_apigateway.mst_functionality
(
    pkid_mst_functionality uuid DEFAULT gen_random_uuid() NOT NULL primary key,
    creation_date          varchar(50) default NOW() NOT NULL,
    expiration_date        varchar(50),
    event_name             varchar(50),
    description            varchar(120)
);

alter table appmatch_apigateway.mst_functionality
    owner to admin;


create table appmatch_apigateway.mst_orchestration
(
    pkid_mst_orchestration    uuid DEFAULT gen_random_uuid() NOT NULL primary key,
    creation_date             varchar(50) default NOW() NOT NULL,
    expiration_date           varchar(50),
    fk_pkid_mst_route_manager uuid not null
        constraint fk_pkid_mst_route_manager
            references appmatch_apigateway.mst_route_manager,
    fk_pkid_mst_funtionality  uuid not null
        constraint fk_pkid_mst_funtionality
            references appmatch_apigateway.mst_functionality,
    execution_order           integer
);

alter table appmatch_apigateway.mst_orchestration
    owner to admin;
/*=======================================================================================================*/
CREATE TABLE IF NOT EXISTS appmatch_schema."dictionary"
(
    "pkid_dictionary" uuid DEFAULT gen_random_uuid() NOT NULL,
    PRIMARY KEY ("pkid_dictionary"),
    creation_date varchar(50) default NOW() NOT NULL,
    expiration_date varchar(50),
    "group_name" varchar(60),
    "subgroup_name" varchar(60),
    "value" varchar(60),
    description varchar(120)
);

	INSERT INTO appmatch_schema."dictionary" (
    group_name, subgroup_name, value, description)
	VALUES
	    ('Basic_Information', 'gender', 'M', 'Masculono'),
	    ('Basic_Information', 'gender', 'F', 'Femenino'),
	    ('Basic_Information', 'gender', 'O', 'Otro'),
	    ('Basic_Information', 'Tipo_Identificacion', 'CC', 'Cédula de Ciudadania'),
	    ('Basic_Information', 'Tipo_Identificacion', 'TI', 'Tarjeta de Identidad'),
	    ('Basic_Information', 'Country', 'CO', 'COLOMBIA'),
	    ('Basic_Information', 'Country', 'VE', 'VENEZUELA'),
	    ('Basic_Information', 'Country', 'EU', 'ESTADOS UNIDOS'),
	    ('Basic_Information', 'Country', 'CA', 'CANADA');
/*=======================================================================================================*/
CREATE TABLE IF NOT EXISTS appmatch_schema."country"
(
    "pkid_country" uuid DEFAULT gen_random_uuid() NOT NULL,
    PRIMARY KEY ("pkid_country"),
    creation_date varchar(50) default NOW() NOT NULL,
    expiration_date varchar(50),
    "countryName" varchar(60),
    "countryNameEn" varchar(60),
    "iso2" varchar(5),
    "iso3" varchar(5),
    "phoneCode" int
);

    INSERT INTO appmatch_schema."country"("countryName","countryNameEn", iso2, iso3, "phoneCode")
    VALUES('Colombia','Colombia','CO','COL',57);
/*=======================================================================================================*/
CREATE TABLE IF NOT EXISTS appmatch_schema.user_profile
(
    pkid_user_profile UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    creation_date varchar(50) default NOW() NOT NULL,
    expiration_date varchar(50),
    fk_pkid_dictionary_id_type UUID,
    identification_number VARCHAR(40) UNIQUE,
    name VARCHAR(30),
    middle_name VARCHAR(30),
    fathers_last_name VARCHAR(30),
    mothers_last_name VARCHAR(30),
    birthdate varchar(50),
    phone VARCHAR(15),
    email VARCHAR(50) unique ,
    address VARCHAR(50),
    fk_pkid_dictionary_gender UUID,
    fk_pkid_dictionary_country_birth UUID,
    image VARCHAR(250),

    CONSTRAINT fk_country_birth
        FOREIGN KEY (fk_pkid_dictionary_country_birth)
        REFERENCES appmatch_schema.dictionary (pkid_dictionary)
        ON DELETE SET NULL,

    CONSTRAINT fk_gender
        FOREIGN KEY (fk_pkid_dictionary_gender)
        REFERENCES appmatch_schema.dictionary (pkid_dictionary)
        ON DELETE SET NULL,

    CONSTRAINT fk_id_type
        FOREIGN KEY (fk_pkid_dictionary_id_type)
        REFERENCES appmatch_schema.dictionary (pkid_dictionary)
        ON DELETE SET NULL
);


-- Crear índices para mejorar el rendimiento en consultas
CREATE INDEX idx_user_profile_id_type ON appmatch_schema.user_profile (fk_pkid_dictionary_id_type);
CREATE INDEX idx_user_profile_gender ON appmatch_schema.user_profile (fk_pkid_dictionary_gender);
CREATE INDEX idx_user_profile_country_birth ON appmatch_schema.user_profile (fk_pkid_dictionary_country_birth);



    INSERT INTO appmatch_schema."user_profile"
        (name,fk_pkid_dictionary_gender, birthdate, phone, email, address, fk_pkid_dictionary_country_birth)
    VALUES
        (
            'Super-User',
            (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'gender' AND value = 'M'),
            '1989-07-22',
            '3016738627',
            'appmatch.dev@gmail.com',
            'Calle 1 # 2-36 sur',
            (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Country' AND value = 'COLOMBIA')
        );
    INSERT INTO appmatch_schema."user_profile"
        (name,middle_name,fathers_last_name,mothers_last_name,fk_pkid_dictionary_id_type,identification_number, fk_pkid_dictionary_gender, birthdate, phone, email, address, fk_pkid_dictionary_country_birth,image)
    VALUES
        (
            'Wilmer','Giovanny','Torres','Achury',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Tipo_Identificacion' AND value = 'CC'),
             '1030558878',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'gender' AND value = 'M'),
            '1989-07-22',
            '3016738627',
            'dv.wilmer.torres1@gmail.com',
            'Calle 1 # 2-36 sur',
            (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Country' AND value = 'COLOMBIA'),
            'https://media.istockphoto.com/id/1201144328/es/foto/hombre-negro-sonriente-en-traje-posando-en-el-fondo-del-estudio.jpg?s=612x612&w=0&k=20&c=rkrFGjza4PQzIAbd7Q0LnAo1tGY31tm1fjevBSaIn00='
        ),
        (
            'Natalia','Rendon','Socatenjo','Caceres',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Tipo_Identificacion' AND value = 'CC'),
             '1030558879',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'gender' AND value = 'M'),
            '1989-07-22',
            '3016738627',
            'dv.wilmer.torres2@gmail.com',
            'Calle 1 # 2-36 sur',
            (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Country' AND value = 'COLOMBIA'),
            'https://media.istockphoto.com/id/1201144328/es/foto/hombre-negro-sonriente-en-traje-posando-en-el-fondo-del-estudio.jpg?s=612x612&w=0&k=20&c=rkrFGjza4PQzIAbd7Q0LnAo1tGY31tm1fjevBSaIn00='
        ),
        (
            'Diego','Sarmiento','Roncancio','',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Tipo_Identificacion' AND value = 'CC'),
             '1030558880',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'gender' AND value = 'M'),
            '1989-07-22',
            '3016738627',
            'dv.wilmer.torres3@gmail.com',
            'Calle 1 # 2-36 sur',
            (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Country' AND value = 'COLOMBIA'),
            'https://media.istockphoto.com/id/1201144328/es/foto/hombre-negro-sonriente-en-traje-posando-en-el-fondo-del-estudio.jpg?s=612x612&w=0&k=20&c=rkrFGjza4PQzIAbd7Q0LnAo1tGY31tm1fjevBSaIn00='
        ),
        (
            'Miguiel','Angel','Rodriguez','',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Tipo_Identificacion' AND value = 'CC'),
             '1030558881',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'gender' AND value = 'M'),
            '1989-07-22',
            '3016738627',
            'dv.wilmer.torres4@gmail.com',
            'Calle 1 # 2-36 sur',
            (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Country' AND value = 'COLOMBIA'),
            'https://media.istockphoto.com/id/1201144328/es/foto/hombre-negro-sonriente-en-traje-posando-en-el-fondo-del-estudio.jpg?s=612x612&w=0&k=20&c=rkrFGjza4PQzIAbd7Q0LnAo1tGY31tm1fjevBSaIn00='
        ),
        (
            'Yeri','Alexandra','Villaba','',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Tipo_Identificacion' AND value = 'CC'),
             '1030558882',
             (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'gender' AND value = 'M'),
            '1989-07-22',
            '3016738627',
            'dv.wilmer.torres5@gmail.com',
            'Calle 1 # 2-36 sur',
            (SELECT pkid_dictionary FROM appmatch_schema."dictionary" WHERE group_name = 'Basic_Information' AND subgroup_name = 'Country' AND value = 'COLOMBIA'),
            'https://media.istockphoto.com/id/1201144328/es/foto/hombre-negro-sonriente-en-traje-posando-en-el-fondo-del-estudio.jpg?s=612x612&w=0&k=20&c=rkrFGjza4PQzIAbd7Q0LnAo1tGY31tm1fjevBSaIn00='
        );

/*=======================================================================================================*/
CREATE TABLE IF NOT EXISTS appmatch_schema."user_rol"
    (
        "pkid_user_rol" uuid DEFAULT gen_random_uuid() NOT NULL,
        PRIMARY KEY (pkid_user_rol),
        creation_date varchar(50) default NOW() NOT NULL,
        expiration_date varchar(50),
        rol_name varchar(20),
        description varchar(30)
    );

insert into appmatch_schema."user_rol"(rol_name, description)
values ('sudo','Super usuario'),
        ('tutor','usuario tutor'),
        ('Student','usuario Estudiante');


/*=======================================================================================================*/
CREATE TABLE IF NOT EXISTS appmatch_schema."user"
(
    "pkid_user" uuid DEFAULT gen_random_uuid() NOT NULL,
    PRIMARY KEY ("pkid_user"),
    creation_date varchar(50) default NOW() NOT NULL,
    expiration_date varchar(50),
    "username" varchar(30),
    "password" varchar(32),
    "fk_pkid_user_profile" uuid unique,
    CONSTRAINT fk_pkid_user_profile
        FOREIGN KEY ("fk_pkid_user_profile")
        REFERENCES appmatch_schema."user_profile"("pkid_user_profile"),
    "number_attempts" int DEFAULT 0
);


    insert into appmatch_schema."user"(username, password, "fk_pkid_user_profile")
    values('appmatch.dev@gmail.com',md5('appmatch'),
           (select pkid_user_profile from appmatch_schema."user_profile" where name ='Super-User')),
        ('dv.wilmer.torres@gmail.com',md5('Shacall1989*.'),
           (select pkid_user_profile from appmatch_schema."user_profile" where name ='Wilmer'));
/*=======================================================================================================*/

CREATE TABLE IF NOT EXISTS appmatch_schema."role_relationship"
    (
        "pkid_role_relationship" uuid DEFAULT gen_random_uuid() NOT NULL,
        PRIMARY KEY (pkid_role_relationship),
        creation_date varchar(50) default NOW() NOT NULL,
        expiration_date varchar(50),
        "fk_pkid_login_user" uuid,
        "fk_pkid_user_rol" uuid,
        CONSTRAINT fk_pkid_login_user FOREIGN KEY (fk_pkid_login_user) REFERENCES appmatch_schema."user"(pkid_user),
        CONSTRAINT fk_pkid_user_rol FOREIGN KEY (fk_pkid_user_rol) REFERENCES appmatch_schema."user_rol"(pkid_user_rol)
    );

insert into appmatch_schema."role_relationship"(fk_pkid_login_user, fk_pkid_user_rol)
values(
        (SELECT pkid_user FROM appmatch_schema."user" WHERE username = 'appmatch.dev@gmail.com'),
        (SELECT pkid_user_rol FROM appmatch_schema."user_rol" WHERE rol_name = 'sudo' )
      ),
      (
        (SELECT pkid_user FROM appmatch_schema."user" WHERE username = 'dv.wilmer.torres@gmail.com'),
        (SELECT pkid_user_rol FROM appmatch_schema."user_rol" WHERE rol_name = 'tutor' )
      );
/*=======================================================================================================*/

CREATE TABLE IF NOT EXISTS appmatch_schema.knowledge
(

    pkid_knowledge uuid DEFAULT gen_random_uuid()  PRIMARY KEY NOT NULL,
    creation_date varchar(50) default NOW() NOT NULL,
    expiration_date varchar(50),
    group_knowledge varchar(50),
    name_knowledge varchar(40),
    fk_pkid_knowledge uuid,
    CONSTRAINT fk_pkid_knowledge_fk FOREIGN KEY (fk_pkid_knowledge) REFERENCES appmatch_schema.knowledge(pkid_knowledge)
);
insert into appmatch_schema.knowledge(group_knowledge,name_knowledge)
values ('Ciencias Naturales','Física'),
    ('Ciencias Naturales','Química'),
    ('Ciencias Naturales','Biología'),
    ('Ciencias Naturales','Geología'),
    ('Ciencias Formales','Matemáticas'),
    ('Ciencias Formales','Lógica'),
    ('Ciencias Formales','Desarrollo de software'),
    ('Ciencias Sociales','Sociología'),
    ('Ciencias Sociales','Psicología'),
    ('Ciencias Sociales','Antropología'),
    ('Ciencias Sociales','Antropología');
insert into appmatch_schema.knowledge(group_knowledge,name_knowledge,fk_pkid_knowledge)
values ('Ciencias Formales','Álgebra',(select pkid_knowledge from appmatch_schema.knowledge where name_knowledge = 'Matemáticas')),
    ('Ciencias Formales','Álgebra Abstracta',(select pkid_knowledge from appmatch_schema.knowledge where name_knowledge = 'Matemáticas'));



/*=======================================================================================================*/
CREATE TABLE IF NOT EXISTS appmatch_schema.professor_profile
		(
		    pkid_product uuid DEFAULT gen_random_uuid() NOT NULL,
            creation_date varchar(50) default NOW() NOT NULL,
            expiration_date varchar(50),
		    fk_pkid_user_profile uuid,
		    fk_pkid_knowledge uuid,
			price numeric(10,2),
            rating int CHECK (rating >= 1 AND rating <= 5),
		    CONSTRAINT fk_pkid_user_profile FOREIGN KEY (fk_pkid_user_profile) REFERENCES appmatch_schema."user_profile"(pkid_user_profile),
		    CONSTRAINT fk_pkid_knowledge FOREIGN KEY (fk_pkid_knowledge) REFERENCES appmatch_schema.knowledge(pkid_knowledge)
		);
        insert into appmatch_schema.professor_profile (fk_pkid_user_profile, fk_pkid_knowledge, price, rating)
        VALUES (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Wilmer'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Matemáticas'),
                20000,
                '3'
               ),
                (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Wilmer'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Desarrollo de software'),
                8000,
                '4'
               );
                insert into appmatch_schema.professor_profile (fk_pkid_user_profile, fk_pkid_knowledge, price, rating)
        VALUES (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Natalia'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Química'),
                20000,
                '4'
               ),
                (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Natalia'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Lógica'),
                8000,
                '5'
               );
                insert into appmatch_schema.professor_profile (fk_pkid_user_profile, fk_pkid_knowledge, price, rating)
                VALUES (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Diego'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Química'),
                20000,
                '4'
               ),
                (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Diego'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Geología'),
                8000,
                '5'
               );
                insert into appmatch_schema.professor_profile (fk_pkid_user_profile, fk_pkid_knowledge, price, rating)
                VALUES (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Miguiel'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Física'),
                20000,
                '2'
               );
                insert into appmatch_schema.professor_profile (fk_pkid_user_profile, fk_pkid_knowledge, price, rating)
                VALUES (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Yeri'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Psicología'),
                20000,
                '4'
               ),
                (
                (SELECT pkid_user_profile FROM appmatch_schema."user_profile" WHERE name = 'Yeri'),
                (SELECT pkid_knowledge FROM appmatch_schema.knowledge WHERE name_knowledge = 'Sociología'),
                8000,
                '5'
               );
/*VIEW======================================================================================================*/
CREATE VIEW appmatch_schema.vw_user_information AS
SELECT
    asu.pkid_user as id,
    ac."countryName" As country,
    concat(au.name, ' ', au.middle_name, ' ', au.fathers_last_name, ' ', au.mothers_last_name) As name,
    asu.username As user,
    asu.password AS password,
    aur.rol_name As rol,
    ad.value AS gender
FROM appmatch_schema."user" AS asu
INNER JOIN appmatch_schema."user_profile" AS au ON asu."fk_pkid_user_profile" = au.pkid_user_profile
INNER JOIN appmatch_schema."country" AS ac ON au.fk_pkid_dictionary_country_birth = ac.pkid_country
INNER JOIN appmatch_schema."dictionary" AS ad ON au.fk_pkid_dictionary_gender = ad.pkid_dictionary
INNER JOIN appmatch_schema."role_relationship" AS are ON asu.pkid_user = are.fk_pkid_login_user
INNER JOIN appmatch_schema."user_rol" AS aur ON are.fk_pkid_user_rol = aur.pkid_user_rol;


SELECT * FROM appmatch_schema.vw_user_information;

/*VIEW======================================================================================================*/

CREATE VIEW appmatch_schema.vw_knowledge_showcase AS
select app.pkid_product as id,
       au.pkid_user_profile as userid,
    concat(au.name, ' ', au.fathers_last_name) As name,
    ak.name_knowledge as knowledge,
    app.price as price,
    app.rating as rating,
    au.image as image
from appmatch_schema.professor_profile as app
INNER JOIN appmatch_schema."user_profile" as au on app.fk_pkid_user_profile = au.pkid_user_profile
inner join appmatch_schema.knowledge as ak on app.fk_pkid_knowledge =  ak.pkid_knowledge;

SELECT * FROM appmatch_schema.vw_knowledge_showcase;


/*
    drop view appmatch_schema.vw_user_information;
    drop view appmatch_schema.vw_knowledge_showcase;
    drop table appmatch_schema."role_relationship";
    drop table appmatch_schema."user_rol";
    drop table appmatch_schema."user";
    drop table appmatch_schema.professor_profile;
    drop table appmatch_schema."user_profile";
    drop table appmatch_schema."dictionary";
    drop table appmatch_schema."country";
    drop table appmatch_schema.knowledge;

    drop table appmatch_apigateway.mst_orchestration
    drop table appmatch_apigateway.mst_functionality
    drop table appmatch_apigateway.mst_route_manager




    select * from appmatch_apigateway.mst_functionality;
    select * from appmatch_apigateway.mst_orchestration;
    select * from appmatch_apigateway.mst_route_manager;
*/

/*
select * from appmatch_schema.professor_profile;
select * from appmatch_schema."user_profile";
select * from appmatch_schema."dictionary";
select * from appmatch_schema."country";
SELECT pkid_knowledge, group_knowledge,name_knowledge FROM appmatch_schema.knowledge
 */

