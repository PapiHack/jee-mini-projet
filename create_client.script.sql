######################################
#	Author : Meïssa B.C MBAYE    #
#	Date   : 07/02/20 15h32      #
#	Niveau : M2GLSI (ESP/DGI)    #
#     Database : gestion_client      #
#       Table  : client              #
######################################

# CREATION DE LA BD
CREATE DATABASE IF NOT EXISTS gestion_client;
USE gestion_client;

#CREATION DE LA TABLE client
CREATE TABLE IF NOT EXISTS client(
id INT AUTO_INCREMENT,
nom varchar(100),
prenom varchar(100),
email varchar(50),
adresse varchar(50),
telephone varchar(50),
PRIMARY KEY(id));
