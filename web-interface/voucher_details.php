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

	/* Check for 404 (file not found). */
    $httpCode = curl_getinfo($curl, CURLINFO_HTTP_CODE);
    // Check the HTTP Status code
    switch ($httpCode) {
        case 200:
            $error_status = "200: Success";
            $deals = json_decode($response, true); 		
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
            $error_status = "Undocumented error: " . $httpCode . " : " . curl_error($curl);
            break;
    }

	curl_close($curl);
?>


<!DOCTYPE html>
<html>
<head>
	<title>Details Voucher</title>
</head>
<body>
<h1>Details Voucher</h1>
<table>
		<tr>
			<td>ID</td>
			<td><?php echo $deals['id'] ?></td>
		</tr>

		<tr>
			<td>Kode Voucher</td>
			<td><?php echo $deals['code'] ?></td>
		</tr>
		
		<tr>
			<td>Name</td>
			<td><?php echo $deals['name'] ?></td>
		</tr>

		<tr>
			<td>Description</td>
			<td><?php echo $deals['description'] ?></td>
		</tr>

		<tr>
			<td>Tipe Diskon</td>
			<td><?php 
				if($deals['type']  === 0)
			        echo "Persen";
			    else
			        echo "Potongan Langsung";
			?></td>
		</tr>
		
		<tr>
			<td>Besar Diskon</td>
			<td><?php echo $deals['amount'] ?></td>
		</tr>

		<tr>
			<td>Maksimum Diskon</td>
			<td><?php echo $deals['max_val'] ?></td>
		</tr>

		<tr>
			<td>Belanja Minimal</td>
			<td><?php echo $deals['min_val'] ?></td>
		</tr>

		<tr>
			<td>Banyak voucher</td>
			<td><?php echo $deals['total_limit_use'] ?></td>
		</tr>

		<tr>
			<td>Batas penggunaan tiap customer</td>
			<td><?php echo $deals['limit_use_per_user'] ?></td>
		</tr>

		<tr>
			<td>Hanya customer baru</td>
			<td><?php 
				if($deals['new_cust_only'] === TRUE)
			        echo "Yes";
			    else
			        echo "No";
				?></td>
		</tr>

		<tr>
			<td>Status voucher</td>
			<td><?php 
				if($deals['active_status'] === TRUE)
			        echo "Active";
			    else
			        echo "Non Active";
				?>					
			</td>
		</tr>
		
		<tr>
			<td>Berlaku sejak</td>
			<td><?php echo $deals['start'] ?></td>
		</tr>
		
		<tr>
			<td>Hingga</td>
			<td><?php echo $deals['end_time'] ?></td>
		</tr>
</table>
</body>
</html>