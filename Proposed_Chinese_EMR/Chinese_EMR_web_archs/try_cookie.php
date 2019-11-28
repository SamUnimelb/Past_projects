<?php
	$data['userid'] = "abcd";
	$data['first_name'] = "Sam";
	echo $data['userid'].'<br>';
	
	setcookie('userid', $data['userid']);
	setcookie('firstname', $data['first_name']);
	include('register_page.php');
?>