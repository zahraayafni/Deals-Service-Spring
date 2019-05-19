<?php
	if ($_SERVER["REQUEST_METHOD"] == "POST") {
		//API Url
		$url = 'http://128.199.210.218:7001/token?email='.$_POST["email"].'&password='.$_POST["password"];
		 
		//Initiate cURL.
		$ch = curl_init($url);
		 
		//Tell cURL that we want to send a POST request.
		curl_setopt($ch, CURLOPT_POST, 1);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

		//Execute the request
		$result = curl_exec($ch);
		$response = json_decode($result, true); 	

		/* Check for 404 (file not found). */
	    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
	    // Check the HTTP Status code
	    switch ($httpCode) {
	        case 200:
	            $error_status = "200: Success";
	            header("Location: admin_all_deals.php"); 
	            break;
	        case 404:
	            $error_status = "404: API Not found";
	            break;
	        case 500:
	            $error_status = "500: servers replied with an error.";
	            break;
	        case 502:
	            $error_status = "502: servers may be down or being upgraded. Hopefully they'll be OK soon!";
	            break;
	        case 503:
	            $error_status = "503: service unavailable. Hopefully they'll be OK soon!";
	            break;
	        default:
	            $error_status = "Undocumented error: " . $httpCode . " : " . curl_error($ch);
	            var_dump($result);
	            break;
	    }
	}
?>

<!DOCTYPE html>
<html>
<head>
	<title>Admin Login</title>
</head>
<body>
<form method="POST">
	<label>email</label>
	<input type="email" name="email" required>
	<label>password</label>
	<input type="password" name="password" required>
	<input type="submit" name="submit" value="Login">
</form>
</body>
</html>