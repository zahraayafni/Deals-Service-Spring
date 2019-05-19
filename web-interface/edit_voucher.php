<?php

	$r_id = $_GET['r_id'];
	$id = $_GET['id'];
	$curl = curl_init();
	curl_setopt_array($curl, array(
		CURLOPT_URL => "deals-service-spring.herokuapp.com/deals/".$r_id."/".$id,
		CURLOPT_RETURNTRANSFER => true,
		CURLOPT_TIMEOUT => 30,
  		CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  		CURLOPT_CUSTOMREQUEST => "GET",
  		CURLOPT_HTTPHEADER => array(
    		"cache-control: no-cache"
  		),
	));

	$response = curl_exec($curl);
	$err = curl_error($curl);

	curl_close($curl);

	$deals = json_decode($response, true); 	

	if ($_SERVER["REQUEST_METHOD"] == "POST") {

		//API Url
		$url = 'https://deals-service-spring.herokuapp.com/deals/'.$_POST["r_id"]."/".$_POST["id"];
		 
		//Initiate cURL.
		$ch = curl_init($url);
		 
		//The JSON data.
		$jsonData = array(
		    'code' 				=> $_POST["code"],
		    'name' 				=> $_POST["name"],
		    'description' 		=> $_POST["description"],
		    'type' 				=> $_POST["type"],
		    'amount' 			=> $_POST["amount"],
		    'max_val' 			=> $_POST["max_val"],
		    'min_val' 			=> $_POST["min_val"],
		    'total_limit_use' 	=> $_POST["total_limit_use"],
		    'limit_use_per_user'=> $_POST["limit_use_per_user"],
		    'new_cust_only' 	=> $_POST["new_cust_only"],
		    'active_status' 	=> $_POST["active_status"],
		    'start' 			=> $_POST["start"],
		    'end_time' 			=> $_POST["end_time"]
		);
		 
		//Encode the array into JSON.
		$jsonDataEncoded = json_encode($jsonData);
		 
		//Tell cURL that we want to send a PUT request.
		curl_setopt($ch,CURLOPT_CUSTOMREQUEST,"PUT");
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
		 
		//Attach our encoded JSON string to the POST fields.
		curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonDataEncoded);
		 
		//Set the content type to application/json
		curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json')); 
		 
		//Execute the request
		$result = curl_exec($ch);

		/* Check for 404 (file not found). */
	    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
	    // Check the HTTP Status code
	    switch ($httpCode) {
	        case 200:
	            $error_status = "200: Success";
	            header("Location: get_all_deals.php"); 
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
	            break;
	    }

		curl_close($ch);
	}
?>


<!DOCTYPE html>
<html>
<head>
	<title>Edit Deals</title>
	<style type="text/css">
		.deals-form {
			margin-left: 35%;
		}
		.submit {
			margin-top: 5%;
			margin-left: 38%;
		}
	</style>
</head>
<body>
	<div class="deals-form">
		<h1>Edit Deals</h1>

		<form action="" method="POST">
			<table>

				<input type="hidden" name="r_id" value="<?php echo $r_id ?>">
				<input type="hidden" name="id" value="<?php echo $id ?>">
				<tr>
					<td>Kode voucher</td>
					<td><input type="text" name="code" value="<?php echo $deals['code'] ?>" required></td>
				</tr>

				<tr>
					<td>Nama voucher</td>
					<td><input type="text" name="name" value="<?php echo $deals['name'] ?>" required></td>
				</tr>

				<tr>
					<td>Deskripsi</td>
					<td><input type="text" name="description" value="<?php echo $deals['description'] ?>" required></td>
				</tr>

				<tr>
					<td>Tipe voucher</td>
					<td>
						<select name="type" required>
							<option value="0">Presentase</option>
							<option value="1">Potongan langsung</option>
						</select>
					</td>
				</tr>

				<tr>
					<td>Besar diskon</td>
					<td><input type="text" name="amount" value="<?php echo $deals['amount'] ?>" required></td>
				</tr>

				<tr>
					<td>Max diskon</td>
					<td><input type="text" name="max_val" value="<?php echo $deals['max_val'] ?>" required></td>
				</tr>

				<tr>
					<td>Min belanja</td>
					<td><input type="text" name="min_val" value="<?php echo $deals['min_val'] ?>" required></td>
				</tr>

				<tr>
					<td>Banyak voucher</td>
					<td><input type="text" name="total_limit_use" value="<?php echo $deals['total_limit_use'] ?>" required></td>
				</tr>

				<tr>
					<td>Batas penggunaan tiap customer</td>
					<td><input type="text" name="limit_use_per_user" value="<?php echo $deals['limit_use_per_user'] ?>" required></td>
				</tr>

				<tr>
					<td>Hanya customer baru</td>
					<td><input type="radio" name="new_cust_only" value="true" required> Ya
					<input type="radio" name="new_cust_only" value="false" required> Tidak </td>
				</tr>

				<tr>
					<td>Status voucher</td>
					<td><input type="radio" name="active_status" value="true" required> Aktifkan
						<input type="radio" name="active_status" value="false" required> Nanti Dulu </td>
				</tr>

				<tr>
					<td>Berlaku sejak</td>
					<td><input type="text" name="start" value="<?php echo $deals['start'] ?>" required></td>
				</tr>

				<tr>
					<td>Berakhir pada</td>
					<td><input type="text" name="end_time" value="<?php echo $deals['end_time'] ?>" required></td>
				</tr>
			</table>

			<input class="submit" type="submit" name="submit" value="Submit">
		</form>
	</div>
	
</body>
</html>