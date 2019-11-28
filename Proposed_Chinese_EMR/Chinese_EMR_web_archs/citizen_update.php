<?php # Script 9.5 - register.php #2
// This script performs an INSERT query to add a record to the users table.

$page_title = 'Citizen update information';

function run_update($attribute, $variable, $citizenID)
{
	require('../../mysqli_doctorweb.php'); 
	$q = "UPDATE citizen
		SET $attribute = '$variable'
		WHERE ID = '$citizenID'";
	$r = @mysqli_query ($dbc, $q); // Run the query.
	if($r)
		echo "Update succeeded!\n";
	else
		echo 'Update fails!<br>';	

	mysqli_close($dbc);		
}//end function
	
/// Check for form submission:
if ($_SERVER['REQUEST_METHOD'] == 'POST')
{
	$citizenID = $_POST['citizenID'];
	$name = strip_tags($_POST['name']);
	$password = trim(strip_tags($_POST['password']));
	$c_password = trim(strip_tags($_POST['c_password']));
	$age = trim(strip_tags($_POST['age']));
	$gender = $_POST['gender'];
	$blood_type = $_POST['blood_type'];
	$agree_share = $_POST['agree_share'];
	
	$errors = array();
	/*$confirm_pass = trim(strip_tags($_POST['confirm_pass']));
	$age = $_POST['age'];
	$sex = $_POST['gender'];
	$blood_type = $_POST['blood_type'];
	$agree_share = $_POST['agree_share'];*/
	
	if($password != $c_password)
		$errors[] = 'Two passwords are not identical!';
	
	if(empty($errors))
	{
		if(!empty($name))
			run_update('name', $name, $citizenID);
		if(!empty($password))
			run_update('password', SHA1($password), $citizenID);
		if(!empty($age))
			run_update('age', $age, $citizenID);
		if(!empty($gender))
			run_update('sex', $gender, $citizenID);
		if(!empty($blood_type))
			run_update('blood_type', $blood_type, $citizenID);
		if(!empty($agree_share))
		 	run_update('agree_share', $agree_share, $citizenID);
	}//No error, execute update.

} // End of the main Submit conditional.
?>