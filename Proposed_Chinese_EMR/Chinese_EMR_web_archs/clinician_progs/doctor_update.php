<?php

function run_update($attribute, $variable, $username)
{
	require('../db_connection.php'); 
	$q = "UPDATE doctor
		SET $attribute = '$variable'
		WHERE username = '$username'";
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
	$username = $_POST['username'];
	$hospital = $_POST['hospital'];
	$password = trim(strip_tags($_POST['password']));
	$c_password = trim(strip_tags($_POST['c_password']));
	$real_name = trim(strip_tags($_POST['name']));
	
	$errors = array();
	
	if($password != $c_password)
		$errors[] = 'Two passwords are not identical!';
	
	if(empty($errors))
	{
		if(!empty($hospital))
		{
			require('../db_connection.php'); 
			$q = "SELECT hospitalID FROM hospitals
			WHERE name = '$hospital'";
			$result = @mysqli_query($dbc, $q);
		
			while($row = mysqli_fetch_array($result, MYSQLI_ASSOC))
				$hospitalID = $row['hospitalID'];
			run_update('hospitalID', $hospitalID, $username);
			mysqli_close($dbc);	
		}//end if
			
		if(!empty($password))
			run_update('password', SHA1($password), $username);
	
		if(!empty($real_name))
			run_update('real_name',$real_name, $username);;
	}//No error, execute update.

} // End of the main Submit conditional.
	

include ('../includes/footer.html');
?>