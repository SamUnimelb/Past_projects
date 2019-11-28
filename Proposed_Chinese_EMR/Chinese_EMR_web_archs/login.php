<?php
	$identity = $_POST['identity'];
	$logv = $_POST['logv'];
	$pass = strip_tags(trim($_POST['password']));
	
	function check_user($table, $dbv, $logv, $pass)
	{
		require ('../../mysqli_doctorweb.php'); 
		$q = "SELECT * FROM $table 
		WHERE $dbv = '$logv' AND password = '".SHA1($pass)."'";
		$result = @mysqli_query($dbc, $q);
		if($result)
			return 1;
		else
			return 0;
	}//end function: Check identity.
	
	if($identity == 1)
	{
		if(check_user('doctor', 'password', $logv, $pass) == 1)
		{
			//Direct to citizen_direct.php
			echo "<form action=\"doctor_direct.php\" method=\"post\" />";
			echo "<input type=\"hidden\" name=\"ID\" value=\"".$logv."\" />";
			echo "<input type=\"hidden\" name=\"password\" value=\"".$pass."\" />";
			echo "<input type=\"submit\" value=\"Go to my page\" />";
			echo "</form>";
		}else{
			echo "Invalid user information! Try again!\n";
			include("login_page.php");
		}//end if-else
	}//end if: User is a doctor.
	
	else if($identity == 2)
	{
		if(check_user('citizen', 'ID', $logv, $pass) == 1)
		{
			//Direct to citizen_direct.php
			echo "<form action=\"citizen_direct.php\" method=\"post\" />";
			echo "<input type=\"hidden\" name=\"ID\" value=\"".$logv."\" />";
			echo "<input type=\"hidden\" name=\"password\" value=\"".$pass."\" />";
			echo "<input type=\"submit\" value=\"Go to my page\" />";
			echo "</form>";
		}else{
			echo "Invalid user information! Try again!\n";
			include("login_page.php");
		}//end if-else
	}//end else if
?>