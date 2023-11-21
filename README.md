# CineJava

Um projeto feito para gerenciar filmes e exibições de um cinema.

<!--Vídeo ************-->

## Íncide
- <a href="#sobre-o-projeto">Sobre o Projeto</a>
- <a href="#funcionalidades-do-projeto">Funcionalidades do Projeto</a>
- <a href="#layout">Layout</a>
- <a href="#como-executar-o-projeto">Como executar o projeto</a>
- <a href="#tecnologias-utilizadas">Tecnologias utilizadas</a>
- <a href="#autor">Autor</a>

## Sobre o Projeto
Sempre gostei de cinemas e, quando eu comecei a aprender Java juntamente com os comandos para a manipulação de um banco de dados com o MySQL, decidi praticá-los criando essa aplicação. Foi feita para gerenciar e organizar filmes e exibições de um cinema com 3 salas.

## Funcionalidades do Projeto
- [x] Inserir e remover filmes do banco de dados;
- [x] Visualizar e buscar filmes existentes;
- [x] Visualizar horários de exibição;
- [x] Adicionar horários de forma que não haja colisão;
- [x] Remover horários;

## Layout
![Tela inicial](/src/assets/Main%20Screen.png)
![Tela inicial](/src/assets/Movies.png)
![Tela inicial](/src/assets/Showtime.png)
![Tela inicial](/src/assets/Add%20Showtime.png)

## Como executar o projeto
### Pré Requisitos
- IDE com Java SWING
- MySQL Instalado
- Biblioteca JDK 11
- Biblioteca mysql-connector-j-8.1.0.jar 
   
### MySQL
```MySQL
CREATE SCHEMA cinema
USE cinema;
CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `poster` varchar(100) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `showtime` (
  `idshowtime` int NOT NULL AUTO_INCREMENT,
  `movie_id` int NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` int NOT NULL,
  `room` int NOT NULL,
  PRIMARY KEY (`idshowtime`),
  KEY `movie_id` (`movie_id`),
  CONSTRAINT `showtime_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
)
```
Honesta observação quanto ao bash script: Ainda não aprendi os comandos necessários para executar este projeto.

## Tecnologias utilizadas
- Java
- Java SWING
- MySQL

## Autor
Estêvão Ferreira Caixeta

[www.linkedin.com/in/estevaof7](www.linkedin.com/in/estevaof7)
