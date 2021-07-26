<?php # Script 9.2 - mysqli_connect.php

/* This file contains the database access information. 
// This file also establishes a connection to MySQL, 
// selects the database, and sets the encoding.

// Set the database access information as constants: */
if(!defined('DB_USER'))
    DEFINE ('DB_USER', 'root');

if(!defined('DB_PASSWORD'))
    DEFINE ('DB_PASSWORD', '12345');

if(!defined('DB_HOST'))
    DEFINE ('DB_HOST', 'localhost');

if(!defined('DB_NAME'))
    DEFINE ('DB_NAME', 'national_medical');

// Make the connection:
$dbc = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD, DB_NAME) OR die ('Could not connect to MySQL: ' . mysqli_connect_error() );

// Set the encoding...
mysqli_set_charset($dbc, 'utf8');
